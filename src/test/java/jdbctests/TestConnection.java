package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@34.232.77.111:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

        //next() --> move pointer to next row
        resultSet.next();

        //getting information with column name
        System.out.println(resultSet.getString("region_name"));
        // getting information with column index(starts from 1)
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.getString(2));

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
