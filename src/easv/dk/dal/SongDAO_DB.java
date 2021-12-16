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
            ResultSet rs = statement.executeQuery(sql);
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Songs son = new Songs(rs.getString("Title"), rs.getString("Artist"), rs.getString("Category"), rs.getInt("Time"), rs.getString("Fileurl"), rs.getInt("Id"));
                    allSongs.add(son);
                }
            }
        }
        return allSongs;

    }

    public Songs createSong(String title, String artist, String category, int time, String fileurl) {
        String sql = "INSERT INTO Song(name,artist,category,time,url) VALUES (?,?,?,?,?)";
        try (Connection con = databaseConnector.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, category);
            ps.setInt(4, time);
            ps.setString(5, fileurl);
            ps.addBatch();
            ps.executeBatch();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Songs son = new Songs(title, artist, category, time, fileurl, getNewestSongID());
        return son;
    }

    public Songs editSong(Songs song, String title, String artist, String category, int time, String fileurl) {
        try (Connection con = databaseConnector.getConnection()) {
                String query = "UPDATE Song SET name = ?,artist = ?,category = ?,time = ?,url = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, category);
            ps.setInt(4, time);
            ps.setString(5, fileurl);
            ps.setInt(6, song.getId());
            ps.executeUpdate();
            Songs son = new Songs(title, artist, category, time, fileurl, song.getId());
            return son;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void deleteSong(Songs songToDelete) {
        try (Connection con = databaseConnector.getConnection()) {
            String query = "DELETE from Song WHERE id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, songToDelete.getId());
            preparedStmt.execute();
        } catch (SQLServerException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private int getNewestSongID() {
        int newestID = -1;
        try (Connection con = databaseConnector.getConnection()) {
            String query = "SELECT TOP(1) * FROM Song ORDER BY id DESC";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                newestID = rs.getInt("id");
            }
            return newestID;
        } catch (SQLServerException ex) {
            System.out.println(ex);
            return newestID;
        } catch (SQLException ex) {
            System.out.println(ex);
            return newestID;
        }
    }
}
