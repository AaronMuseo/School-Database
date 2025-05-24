package database;

import java.util.Scanner;
public class Test {
    
    public static Scanner sc = new Scanner(System.in);
    static DBOperations dbo = new DBOperations();
    
    public static void main(String[] args){
    
        menu();
    
    }
    
    
    static void menu(){
        
        int id;
        String name;
        String course;
        int choice;
        
        while(true){
        System.out.println("-----Welcome to the school Database-----\n");
        System.out.println("Choose option");
        System.out.println("1. Insert");
        System.out.println("2. Display");
        System.out.println("3. Update");
        System.out.println("4. Delete\n");
        
        System.out.println("5. Show Whole Table\n");
        
        System.out.println("6. Exit\n");
        
        choice = sc.nextInt();
        
        switch(choice){
            
            case 1:
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                System.out.println("Enter name: ");
                name = sc.next();
                System.out.println("Enter course: ");
                course = sc.next();
                dbo.Insert(id, name, course);
            
            break;
            
            case 2:
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                System.out.println("\n");
                dbo.Select(id);
            break;
            
            case 3:
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                System.out.println("Enter course: ");
                course = sc.next();
                dbo.Update(id, course);
            break;
            
            case 4:
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                dbo.Delete(id);
            break;
            
            case 5:
                dbo.SelectAll();
            break;
                
            
            case 6:
                System.exit(0);
            break;
            
            default:
                System.out.println("choose an option");
                
                menu();
        }
        
    }
}
    
}
