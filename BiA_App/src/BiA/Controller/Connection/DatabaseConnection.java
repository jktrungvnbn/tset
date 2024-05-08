
package BiA.Controller.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

// Kết nối tới DataBase của hệ thống
//
public class DatabaseConnection {

    
    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
                instance = new DatabaseConnection();
                instance.connectToDatabase();
        }
        return instance;
    }

    public DatabaseConnection() {

    }
    //Thực hiện kết nối tới Database
    public void connectToDatabase() throws SQLException {
        
        final String url = "jdbc:mysql://103.82.21.135:3306/BIA" ;
        final String username = "root";
        final String password = "Klmnop123#";
        
     
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex){
            ex.getMessage();
        }
        
    }
 
    public Connection getConnection()  {
        return connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public static void main(String[] args) throws SQLException {
       DatabaseConnection d  =  new DatabaseConnection();
       d.connectToDatabase();
       System.out.println("Kết nối thành công!");
   }
}

