package model;

import com.ibm.db2.jcc.*;
import java.sql.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.google.cloud.sql.mysql.SocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    String DB_USER = "root";
    String DB_PASS = "Bex0Kb9x3rceJ87z MowICs9nJdwL4HDC";

    static {
        String DB_USER = "root";
        String DB_PASS = "Bex0Kb9x3rceJ87z";
        String DB_NAME = "ryan-love";
        String CLOUD_SQL_CONNECTION_NAME = "principal-bird-264410:europe-west1:ryan-love";
            DB2SimpleDataSource dbds=new DB2SimpleDataSource();

        config.setJdbcUrl("jdbc:mysql://"+ "films");
        config.setUsername("root"); // e.g. "root", "postgres"
        config.setPassword("MowICs9nJdwL4HDC"); // e.g. "my-password"
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
        config.addDataSourceProperty("cloudSqlInstance", "film-web-application:europe-west1:ryan-love");
        config.addDataSourceProperty("useSSL", "false");

        config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            dataSource = new HikariDataSource(config);

    }

    public static Connection getConnection() throws SQLException {
        System.out.println("about to return connection "+ dataSource.isRunning());
        System.out.println("Thread "+ dataSource.getMaximumPoolSize());
        return dataSource.getConnection();
    }




    private DataSource(){}


}
