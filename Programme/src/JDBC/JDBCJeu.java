package JDBC;

import java.sql.*;              // Use classes in java.sql package
 
// JDK 6 and above

/**
 * 
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * @version 1.0
 *
 */
public class JDBCJeu {   // Save as JdbcSelectTest.java
   public static void main(String[] args) throws ClassNotFoundException {
      Connection conn = null;
      Statement  stmt = null;
      try {
    	   // Step 0: Load Database driver
    	   Class.forName("com.mysql.jdbc.Driver");           // for MySQL
    	   		// http://www.ntu.edu.sg/home/ehchua/programming/java/JDBC_Basic.html --> un peu avant moitié de la page !!
    	   // Step 1: Allocate a database "Connection" object
         conn = DriverManager.getConnection(
               "jdbc:mysql://169.254.123.204:8888/ebookshop", "myUser", "essai"); // MySQL
 
         // Step 2: Allocate a "Statement" object in the Connection
         stmt = conn.createStatement();
         									// A PARTIR D'ICI, FAUT TOUT MODIFIER !
         // Step 3: Execute a SQL SELECT query, the query result
         //  is returned in a "ResultSet" object.
         String strSelect = "select title, price, qty from books";
         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
         System.out.println();
 
         ResultSet rset = stmt.executeQuery(strSelect);
 
         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
         //  For each row, retrieve the contents of the cells with getXxx(columnName).
         System.out.println("The records selected are:");
         int rowCount = 0;
         while(rset.next()) {   // Move the cursor to the next row
            String title = rset.getString("title");
            double price = rset.getDouble("price");
            int    qty   = rset.getInt("qty");
            System.out.println(title + ", " + price + ", " + qty);
            ++rowCount;
         }
         System.out.println("Total number of records = " + rowCount);
 
      } catch(SQLException ex) {
         ex.printStackTrace();
      } finally {
         // Step 5: Always free resources
         try {
            if (stmt != null) stmt.close();  // This closes ResultSet too
            if (conn != null) conn.close();
         } catch(SQLException ex) {
            ex.printStackTrace();
         }
      }
   }
}