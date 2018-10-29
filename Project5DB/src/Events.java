import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Events implements EventInterface {

    @Override
    public List<Events> eventList() {
        return null;
    }

    public void addContent() {
        final String DB_URL = "jdbc:derby:Project5DB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");

            //Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }


    public void outputDB() {
        final String DB_URL = "jdbc:derby:Project5DB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM EVENTS";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                String id  = rs.getString("ProductNumber");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                Boolean isFeatured = rs.getBoolean("isFeatured");
                String image = rs.getString("Image");
                double price = rs.getDouble("Price");



                //Display values
                System.out.print("\nID: " + id.trim());
                System.out.print(", Name: " + name);
                System.out.print(", Description: " + description);
                System.out.print(", Featured: " + isFeatured);
                System.out.print(", Image: " + image);
                System.out.print(", Price: " + price);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    @Override
    public void updateContent() {
        Scanner sc = new Scanner(System.in);
        int updateMenu = 0;
        System.out.println("Choose an event number to update: ");
        outputDB();
        updateMenu = sc.nextInt();

    }

    @Override
    public void menuOutput() {
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        while (menuChoice != 3) {
            System.out.println("\n***************************");
            System.out.println(  "*********Main Menu*********");
            System.out.println("1. List content");
            System.out.println("2. Add content");
            System.out.println("3. Exit");
            System.out.println("***************************\n");
            menuChoice = sc.nextInt();
            switch (menuChoice) {
                case 1: outputDB();break;
                case 2: updateContent();break;
            }
        }

    }
}
