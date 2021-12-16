package easv.dk.be;

import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private int totalSongs;
    private int totalTime;
    private List<Songs> songList;

    public Playlist(int totalSongs, int totalTime, String name, int id) {
        this.id = id;
        this.name = name;
        this.totalTime = totalTime;
        this.totalSongs = totalSongs;

    }

    public int getId() {
        return id;
    }

    public List<Songs> getSongList() {
        return songList;
    }

    public void setSongList(List<Songs> songList) {
        this.songList = songList;
    }

    public int getSongCount() {
        return totalSongs;
    }

    public void setTotalSongs(int totalSongs) {
        this.totalSongs = totalSongs;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Name=" + name + "Total song count =" + totalSongs + ", Total play Time=" + totalTime;
    }

}

