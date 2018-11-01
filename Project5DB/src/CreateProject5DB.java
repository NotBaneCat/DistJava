

import java.sql.*;

public class CreateProject5DB
{
    public CreateProject5DB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:Project5DB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Coffee table.
            buildEventsTable(conn);
            insertEventsTable(conn);
            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Game Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables...");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the table.
                stmt.execute("DROP TABLE CART");
                System.out.println("CART table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Game table.
                stmt.execute("DROP TABLE EVENTS");
                System.out.println("Games table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildEventsTable method creates the
     * Game table and adds some rows to it.
     */
    public void buildEventsTable(Connection conn) throws SQLException {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE EVENTS (" +
                    "ProductNumber INT NOT NULL PRIMARY KEY, " +
                    "Name VARCHAR(50), " +
                    "Description VARCHAR (600), " +
                    "isFeatured BOOLEAN, " +
                    "Image VARCHAR (40), " +
                    "Price DOUBLE " +
                    ")");
            System.out.println("GAMES table created.");
        } catch (SQLException ex)
        {
            System.out.println("Game Table Creation ERROR: " + ex.getMessage());
        }
    }
    private void insertEventsTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            // Insert row #1.
            stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                    "(1, " +
                    "'The Witcher 3', " +
                    "'Adventure 3rd Person', " +
                    "true, " +
                    "'WitcherBanner', " +
                    "10.00)");

            // Insert row #2.
            stmt.executeUpdate("INSERT INTO EVENTS VALUES" +
                    "(2, " +
                    "'CSGO', " +
                    "'Action First Person', " +
                    "true, " +
                    "'CSGOBanner', " +
                    "12.00)");
            System.out.println("Game Table rows inserted.");
        }  catch (SQLException ex)
        {
            System.out.println("Game Table INSERT ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCartTable method creates the
     * CART table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE CART" +
                    "( CustomerNumber INT NOT NULL PRIMARY KEY, " +
                    "  ProductNumber INT NOT NULL )");



            System.out.println("CART table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            // Add some rows to the new table.
            stmt.executeUpdate("INSERT INTO CART VALUES" +
                    "(101, 1)");

            System.out.println("CART Table rows inserted.");
        } catch (SQLException ex)
        {
            System.out.println("CART INSERT ERROR: " + ex.getMessage());
        }
    }

}