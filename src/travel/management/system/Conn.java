package travel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "ISHwar0766");

            // Create statement
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
