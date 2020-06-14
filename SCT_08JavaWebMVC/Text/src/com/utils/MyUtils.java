package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class MyUtils {
    private static QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
    //获取数据库连接池
    public static QueryRunner getDataBase(){
        return qr;
    }
}
