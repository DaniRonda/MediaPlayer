package easv.dk.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import easv.dk.be.Playlist;
import easv.dk.be.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaylistDAO_DB {

    private static MyDatabaseConnector databaseConnector;
    public PlaylistDAO_DB() {
        databaseConnector = new MyDatabaseConnector();
    }

    public static List<Playlist> getAllSongs() throws SQLException {
        ArrayList<Playlist> allPlaylist = new ArrayList<>();
        String sql = "SELECT * FROM Playlist;";

        try (Connection connection = databaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String Name = resultSet.getString("Name");
                    int TotalTime = resultSet.getInt("TotalTime");
                    int TotalSongs = resultSet.getInt("TotalSongs");

                    Playlist playlist = new Playlist(id,Name, TotalTime, TotalSongs);
                    allPlaylist.add(playlist);
                }

            }
        }
        return allPlaylist;
    }

    public void createPlaylist(Playlist playlist) {
        String sql = "INSERT INTO Playlist (name) values (?)";
        try ( Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, playlist.getName());
            p.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void editPlaylist (Playlist playlist){
    String sql = "UPDATE Playlist SET name=? WHERE id=?";
    try (Connection con = databaseConnector.getConnection()){
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1,playlist.getName());
        p.setInt(2, playlist.getId());
        p.executeUpdate();

    } catch (SQLServerException throwables) {
        throwables.printStackTrace();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    }

    public void deletePlaylist (Playlist playlist){
        String sql = " DELETE FROM Playlist WHERE id = ?";
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1,playlist.getId());
            p.executeUpdate();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }
