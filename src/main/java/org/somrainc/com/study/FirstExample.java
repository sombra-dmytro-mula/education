package org.somrainc.com.study;

import java.sql.*;

public class FirstExample {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            transaction(conn);

////            update(conn);
//            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
//
//            PreparedStatement preparedStatement = conn.prepareStatement("insert into test values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setInt(1, 8);
//            preparedStatement.setString(2, "teste");
//            preparedStatement.setInt(3, 1);
//            int execute = preparedStatement.executeUpdate();
//            //STEP 5: Extract data from result set
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            while(generatedKeys.next()){
//                //Retrieve by column name
//                int id  = generatedKeys.getInt(1);
////                String name = generatedKeys.getString("name");
//
//                //Display values
//                System.out.print("ID: " + id);
////                System.out.print(", Age: " + name);
//            }
//            //STEP 6: Clean-up environment
//            rs.close();
//            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void update(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("update test set name='updated1' where id=1");
    }

    public static void transaction(Connection conn) throws SQLException {
        conn.setAutoCommit(false);

        Statement statement = conn.createStatement();
        statement.executeUpdate("INSERT INTO test values (1,'er',1)");

        Statement statement1 = conn.createStatement();
        statement.executeUpdate("INSERT INTO test values (2,'er3',1)");

        conn.commit();
    }

    public static void streamingMode(Connection conn) throws SQLException {
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        Statement statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        statement.setFetchSize(Integer.MIN_VALUE);
    }


}
