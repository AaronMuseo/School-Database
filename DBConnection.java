package database;

import java.sql.*;


//establish a connection
public class DBConnection {
    
      Connection con;
      
    // step 1 load drivers    
    public DBConnection (){
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded successfully");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Could not load driver");
        }
    
    
    // step 2 establish connection
    String url = "jdbc:postgresql://localhost:5432/university";
    String user = "postgres";
    String password = "";
    
    try{
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Successful\n");
        
    }catch(SQLException e){
        System.out.println("Connection Failed\n");
   
    }
   
    }
}
