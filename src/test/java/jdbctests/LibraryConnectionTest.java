package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryConnectionTest {
    String dbUrl = "jdbc:mysql://3.89.251.99:3306/library1";
    String dbUsername = "library1_client";
    String dbPassword = "WVF4NdGXCKHeE6VQ";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

        resultSet.next();

        System.out.println(resultSet.getString(2));

        resultSet.close();
        statement.close();
        connection.close();

    }
}
