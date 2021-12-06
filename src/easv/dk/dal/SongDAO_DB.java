package easv.dk.dal;

import easv.dk.be.Songs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO_DB {
    private static MyDatabaseConnector databaseConnector;

    public SongDAO_DB() {
        databaseConnector = new MyDatabaseConnector();
    }

    public static List<Songs> getAllSongs() throws SQLException {

        ArrayList<Songs> allSongs = new ArrayList<>();


        try (Connection connection = databaseConnector.getConnection()) {

            String sql = "SELECT * FROM Songs;";

            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String Title = resultSet.getString("Title");
                    String Artist = resultSet.getString("Artist");
                    String Category = resultSet.getString("Category");
                    String Time = resultSet.getString("Timeof");
                    String FileURL = resultSet.getString("fileurl");

                    Songs songs = new Songs(id, Title, Artist, Category, Time, FileURL);
                    allSongs.add(songs);
                }

            }
        }
        return allSongs;
    }

    public static void main(String[] args) throws SQLException {
        SongDAO_DB songDAO_db = new SongDAO_DB();
        List<Songs> allSongs = songDAO_db.getAllSongs();
        System.out.println(allSongs);
    }
}