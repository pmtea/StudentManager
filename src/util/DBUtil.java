/**
 * 数据库工具类，这个类的作用是初始化驱动，并且提供一个getConnection用于获取连接。
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "student";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "root";
    static String useUnicode="true";
    static String useSSL = "false";

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        //String url = String.format("jdbc:mysql://%s:%d/%s?useUnicode=%s&characterEncoding=%s&useSSL=%s", ip, port, database, useUnicode,encoding,useSSL);
        String url= "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false";

        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());

    }

}