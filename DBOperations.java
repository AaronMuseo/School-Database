package database;

import java.sql.*;

public class DBOperations {
    
    DBConnection dbc = new DBConnection();
    
    //they follow the steps bellow
    //step 3: Create Statement
    //step 4: Execute Statement
    //step 5: Process ResultSet ( Only for Select function)
    //step 6: Close connection
    
    //Create or Insert
    public void Insert(int id, String name, String course){
        
        try{
            //step 3: Create Statement
            String query = "INSERT INTO students (sid, sname, scourse) VALUES(?, ?, ?);";
            PreparedStatement pst = dbc.con.prepareStatement(query);
            
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, course);
            
            //step 4: Execute Statement
            pst.executeUpdate(); 

            
            System.out.println("Insert Successful\n");
            
        }catch(SQLException e){
            
            System.out.println("Insert not successful     " + e + "\n"); 
            
        }    
            
        
       
    }
    
    //Read or Select
    public void Select(int id){
         
        
        //step 3: Create Statement
        try{
            
            String query = "SELECT * FROM students WHERE sid = ?";
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, id);
            
            //step 4: Execute Statement
            ResultSet rs =pst.executeQuery();
            
            while(rs.next()){
                
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String scourse = rs.getString("scourse");
                
                System.out.println("ID: "+ sid +"\nName: " + sname +"\nCourse: " + scourse);
                
                    
            }
            
            System.out.println("Select Successful\n");
            
           
            
        }catch(SQLException e){
            
            System.out.println("Select not successful" + e.getMessage() + "\n");  
        }    
        
    }
    
    public void SelectAll(){
        
        try{
            String query = "SELECT * FROM students;";
            PreparedStatement pst = dbc.con.prepareStatement(query);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String scourse = rs.getString("scourse");
                
                System.out.println("ID: "+ sid +"\nName: " + sname +"\nCourse: " + scourse + "\n");
                
                    
            }
            
            System.out.println("Select Successful\n");
            
        }catch(SQLException e){
            
        }
    }
    //Update
    public void Update(int id, String course){
    
        try{
            String query = "UPDATE students SET scourse = ? where sid = ?;";
            PreparedStatement pst = dbc.con.prepareStatement(query);
            
            pst.setString(1, course);
            pst.setInt(2, id);
            
            pst.executeUpdate();
            
            System.out.println("Update Successful \n");
            
        }catch(SQLException e){
            System.out.println("Update not Successful " + e + "\n");
                       
        }
        
        
    }
    //Delete
    public void Delete(int id){
        
        try{
            String query = "DELETE FROM students WHERE sid = ?;";
            PreparedStatement pst = dbc.con.prepareStatement(query);
            
            pst.setInt(1, id);
            
             int rowsAffected = pst.executeUpdate();
            
             if(rowsAffected > 0){
                System.out.println("Deletion Successful\n");
             }else{
                System.out.println("Deletion not Successful\n");
             }
             
            
        }catch(SQLException e){
            System.out.println("Error Deleting " + e + "\n");
        }
        
        
        
        
        
        
    }
}
