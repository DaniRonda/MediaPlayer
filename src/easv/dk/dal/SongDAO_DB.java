package easv.dk.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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

    public void createSong(Songs song) {
        String sql = "insert into Songs (title,artist,category,timeof,fileurl) values (?,?,?,?,?)";

        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, song.getTitle());
            p.setString(2, song.getArtist());
            p.setString(3, song.getCategory());
            p.setString(4, song.getTime());
            p.setString(5, song.getFileurl());
            p.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editSong(Songs song) {
        String sql = "update Songs set title=? , artist=? , category=? , timeof=? , fileurl=? where id=?";
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, song.getTitle());
            p.setString(2, song.getArtist());
            p.setString(3, song.getCategory());
            p.setString(4, song.getTime());
            p.setString(5, song.getFileurl());
            p.setInt(6, song.getId());
            p.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteSongs(Songs song) {
        String sql = " DELETE FROM Songs WHERE id = ?";

        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);

            p.setInt(1,song.getId());
            p.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}