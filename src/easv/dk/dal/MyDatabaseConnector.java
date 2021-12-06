package easv.dk.dal;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

    public class MyDatabaseConnector {

        private SQLServerDataSource dataSource;

        public  MyDatabaseConnector()
        {

            dataSource = new SQLServerDataSource();
            dataSource.setDatabaseName("mp3Player");
            dataSource.setUser("CSe21B_9");
            dataSource.setPassword("CSe21B_9");
            dataSource.setPortNumber(1433);
            dataSource.setServerName("10.176.111.31");
        }
        public Connection getConnection() throws SQLServerException {
            return dataSource.getConnection();
        }

        public static void main(String[] args) throws SQLException {

            MyDatabaseConnector databaseConnector = new MyDatabaseConnector();

            try  (Connection connection = databaseConnector.getConnection()){
                System.out.println("Is it Open " + !connection.isClosed());
            }
        }

    }

