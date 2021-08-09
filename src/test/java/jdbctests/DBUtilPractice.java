package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1() throws SQLException {
        DBUtils.createConnection();
        String query = "SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <6";
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> row : queryData) {
            System.out.println(row);

        }

        DBUtils.destroy();


    }

    @Test
    public void test2(){

        DBUtils.createConnection();
        String query = "SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <2";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        System.out.println(rowMap);

        DBUtils.destroy();


    }
}
