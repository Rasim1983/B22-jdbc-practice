package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {

    String dbUrl = "jdbc:oracle:thin:@34.232.77.111:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // move to first row

//        resultSet.next();
//        System.out.println(resultSet.getString(2));

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) +
                    " - " + resultSet.getInt(3) + " - " + resultSet.getInt(4));
        }


        resultSet = statement.executeQuery("SELECT * FROM regions");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        }


        resultSet.close();
        statement.close();
        connection.close();
    }

    @DisplayName("Result set methods")
    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        resultSet.last();
        System.out.println(resultSet.getRow());

        //to move before first row after we use .last method
        resultSet.beforeFirst();

        //print all secon column information
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test3() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        //get the database related data inside the dbMetedata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());

        //get the resultsetmetadata //rsmd
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //how many columns we have ?
        int colCount = rsMetadata.getColumnCount();
        System.out.println(colCount);

        //getting column names
        System.out.println(rsMetadata.getColumnName(1));
        System.out.println(rsMetadata.getColumnName(2));


        for (int i = 1; i <=colCount ; i++) {
            System.out.println(rsMetadata.getColumnName(i));

        }


        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

}
