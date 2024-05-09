
package BIA.Controller.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

// Kết nối tới DataBase của hệ thống

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }
    //Thực hiện kết nối tới Database
    public void connectToDatabase() throws SQLException {
        
         try {
             String url = "jdbc:mysql://103.82.21.135:3306/BIA";
       connection =DriverManager.getConnection (url,"root","Klmnop123#");
        System.out.println("ok");
        } catch (Exception e) {
             System.out.println("BIA.Controller.Connection.DatabaseConnection.connectToDatabase()");
        }
    }
 
    public Connection getConnection() {
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public static void main(String[] args) throws SQLException {
        DatabaseConnection d  =  new DatabaseConnection();
        d.connectToDatabase();
  }
}

//
//package BiA.Controller.Connection;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
//
//// Kết nối tới DataBase của hệ thống
////
//public class DatabaseConnection {
//
//    
//    private static DatabaseConnection instance;
//    private Connection connection;
//
//    public static DatabaseConnection getInstance() throws SQLException {
//        if (instance == null) {
//                instance = new DatabaseConnection();
//                instance.connectToDatabase();
//        }
//        return instance;
//    }
//
//    public DatabaseConnection() {
//
//    }
//    //Thực hiện kết nối tới Database
//    public void connectToDatabase() throws SQLException {
//        
//        final String url = "jdbc:http://103.82.21.135:3306/BIA" ;
//        final String username = "root@localhost";
//        final String password = "Klmnop123#";
//        
//     
//         try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Kết nối ");
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("connect successfully!");
//        } catch (Exception ex){
//            ex.getMessage();
//            System.out.println("Kết nối ko thành công!");
//        }
//        
//    }
// 
//    public Connection getConnection()  {
//        return connection;
//    }
//    
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
//    public static void main(String[] args) throws SQLException {
//       DatabaseConnection d  =  new DatabaseConnection();
//       d.connectToDatabase();
//       
//   }
//}
//
