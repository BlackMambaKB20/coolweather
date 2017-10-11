package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * 安卓中主要提供了三种数据持久化的方式：文件存储（适合存储一些简单的文本数据或二进制数据）
 *                                      SharedPreferences存储（使用键值对的方式）
 *                                      数据库存储:SQLite
 *                                      也可以存储在sd卡中
 *
 * 本项目主要是使用了开源框架litePal
 * 使用LitePal框架必须继承DataSupport  因为进行CRUD操作时，LitePal要求所有的实体类都要继承自DataSupport这个类
 * */
public class Province extends DataSupport {

    private int id;

    private String provinceName;//省份的名字

    private int provinceCode;//省份的代号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
