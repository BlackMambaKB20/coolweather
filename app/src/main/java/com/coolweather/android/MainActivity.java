package com.coolweather.android;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.coolweather.android.util.ReadFileUtill;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public LocationClient mLocationClient;
    public boolean FLAG=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //首先获取一个LocationClient实例   调用getApplicationContext()获取一个全局Context对象传入
        mLocationClient = new LocationClient(getApplicationContext());
        //注册一个定位监听器 ，当获取到位置信息时，回调这个定位监听器
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_main);
        //如何在运行时一次性申请三个权限呢？  采用集合方式去处理
        List<String> permissionList = new ArrayList<>();
        //ContextCompat.checkSelfPermission()检查应用是否拥有该权限，被授权返回值为PERMISSION_GRANTED，否则返回PERMISSION_DENIED
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);//将弹出请求授权对话框
        } else {
            requestLocation();
        }

        SharedPreferences prefs = this.getSharedPreferences("com.coolweather.android", Context.MODE_PRIVATE);
        if (prefs.getBoolean("automatic_positioning", false)) {
            this.FLAG=true;
        }else {
            this.FLAG = false;
        }
//        if (prefs.getString("weather", null) != null) {
//            Intent intent = new Intent(this, WeatherActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
    private void requestLocation() {
        initLocation();
        mLocationClient.start();//开始定位(默认情况下该方法只会定位一次)   定位结果会回调到我们前面注册的监听器中
        Toast.makeText(this, "requestLocation", Toast.LENGTH_SHORT).show();
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
//        option.setScanSpan(5000);//设置更新的间隔
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        /*
        该方法类似于Activity的OnActivityResult()的回调方法，主要接收请求授权的返回值
        注意这里的处理方式和以往有不同
        通过一个循环将申请的每个权限进行判断，如果有任何一个权限被拒绝，那么直接调用  finis方法关闭
        只有全部的权限都被授予，才可以调用requestLocation()开始进行定位操作;
        * */
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {//回调方法
            Toast.makeText(MainActivity.this, "地区：" + location.getDistrict(), Toast.LENGTH_SHORT).show();
            String countyId = ReadFileUtill.getCountyId(location.getDistrict());
            if (FLAG) {
                Toast.makeText(MainActivity.this, "id：" + countyId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("weather_id", countyId);
                startActivity(intent);
                MainActivity.this.finish();
            } else {
                AddFragment(new ChooseAreaFragment());
            }
        }
    }

    //动态添加碎片
    private void AddFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.dynamic, fragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();//在活动被销毁的时候一定要调用stop方法来停止定位，不然程序会在后台一直定位，严重消耗手机的电量
        Log.d("TAG", "onDestroy:活动被销毁 ");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        mLocationClient.start();
    }

}
