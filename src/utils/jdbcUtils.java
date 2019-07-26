

package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbcUtils {


    public static Connection getConnection() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource("mysql");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        return connection;
    }
    public static void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


