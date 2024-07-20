/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
 /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }

    /*Insert your other code right after this comment*/
 /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "DESKTOP-IEL1ROP\\HUYNGO";
    private final String dbName = "PRJ301_SP24";
    private final String portNumber = "1443";
    private final String userID = "sa";
    private final String password = "123";

    public boolean testConnection() {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connected to the database.");
                connection.close(); // Đóng kết nối sau khi kiểm tra
                return true;
            } else {
                System.out.println("Failed to connect to the database.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            return false;
        }
    }

    public class Main {

        public static void main(String[] args) {
            DBContext dbContext = new DBContext();

            // Kiểm tra kết nối và xử lý kết quả
            if (testDBConnection(dbContext)) {
                // Nếu kết nối thành công, thực hiện các thao tác khác ở đây
                System.out.println("Connected to the database.");
            } else {
                // Nếu kết nối thất bại, xử lý theo mong muốn của bạn
                System.out.println("Failed to connect to the database.");
            }
        }

        // Hàm kiểm tra kết nối đến cơ sở dữ liệu
        public static boolean testDBConnection(DBContext dbContext) {
            try {
                // Thực hiện kết nối và đóng kết nối ngay sau khi kiểm tra
                Connection connection = dbContext.getConnection();
                if (connection != null) {
                    connection.close();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                // Xử lý các ngoại lệ nếu có
                System.out.println("Exception occurred: " + e.getMessage());
                return false;
            }
        }
    }
    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        
        // Kiểm tra kết nối và xử lý kết quả
        if (testDBConnection(dbContext)) {
            // Nếu kết nối thành công, thực hiện các thao tác khác ở đây
            System.out.println("Connected to the database.");
        } else {
            // Nếu kết nối thất bại, xử lý theo mong muốn của bạn
            System.out.println("Failed to connect to the database.");
        }
    }
    
    // Hàm kiểm tra kết nối đến cơ sở dữ liệu
    public static boolean testDBConnection(DBContext dbContext) {
        try {
            // Thực hiện kết nối và đóng kết nối ngay sau khi kiểm tra
            Connection connection = dbContext.getConnection();
            if (connection != null) {
                connection.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Xử lý các ngoại lệ nếu có
            System.out.println("Exception occurred: " + e.getMessage());
            return false;
        }
    }
}
