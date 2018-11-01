import java.sql.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class Events implements EventInterface {

    @Override
    public List<Events> eventList() {
        return null;
    }

    public void addContent() {
        final String DB_URL = "jdbc:derby:C:/Users/BaneCat/Downloads/Distributed-master/Distributed-master/Project5DB/Project5DB";
        Scanner sc = new Scanner(System.in);
        Statement stmt = null;
        Connection conn = null;

        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sqlGetRows;
            sqlGetRows = "SELECT COUNT(*) as rowcount FROM EVENTS";
            ResultSet rsRows = stmt.executeQuery(sqlGetRows);
            rsRows.next();
            int rowCount = rsRows.getInt(1);
            System.out.println("Event Table | Number of Rows: " + rowCount);

            String sqlGetCols;
            sqlGetCols = "SELECT * FROM EVENTS";
            ResultSet rsCols = stmt.executeQuery(sqlGetCols);
            ResultSetMetaData rsmd = rsCols.getMetaData();
            int colCount = rsmd.getColumnCount();
            System.out.println("Event Table | Number of Columns: " + colCount);

            String name = "";
            String description = "";
            double price = 0;
            Boolean isFeatured;
            String image = "";
            String stuff = "";

            int productNumber = rowCount + 1;

            for(int i = 2; i <= colCount; i++) {
                switch(i){
                    case 2 : { System.out.println("Enter the name of the Product: "); name = sc.nextLine(); break; }
                    case 3 : { System.out.println("Enter the description of the Product: "); description = sc.nextLine(); break; }
                    case 4 : { System.out.println("Enter the price of the product: "); price = sc.nextDouble(); break; }
                    case 5 : { System.out.println("Is the product featured? (yes or no):"); sc.nextLine(); stuff = sc.nextLine(); break; }
                    case 6 : { System.out.println("Enter the image url: "); image = sc.nextLine(); break; }
                }
            }

            switch(stuff) {
                case "yes" : isFeatured = true; break;
                case "no" : isFeatured = false; break;
                case "" : isFeatured = false; break;
                default : isFeatured = false;
            }

            EventBean eb = new EventBean(productNumber, name, description, price, isFeatured, image);
           /* stmt.executeUpdate("INSERT INTO EVENTS VALUES ('"+productNumber+"', '"+name+"', '"+description+"', '"+price+"', '"+isFeatured+"', '"+image+"') "); */

            String sql = MessageFormat.format("INSERT INTO EVENTS VALUES ({0}, {1}, {2}, {3}, {4}, {5})", productNumber, name, description, isFeatured, image, price);
            stmt.executeUpdate(sql);

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
        final String DB_URL = "jdbc:derby:C:/Users/BaneCat/Downloads/Distributed-master/Distributed-master/Project5DB/Project5DB";
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
                case 2: addContent();break;
            }
        }

    }
}
