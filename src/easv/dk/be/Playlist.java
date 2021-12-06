package easv.dk.be;

import java.util.ArrayList;
import java.util.List;

public class Playlist{
        private int id;
        private String name;
        private int totalSongs;
        private int totalTime;
        private List<Songs> songs = new ArrayList();

        public Playlist(int id, String name,int totalTime, int totalSongs) {
            this.id = id;
            this.name = name;
            this.totalTime = totalTime;
            this.totalSongs = totalSongs;

        }

        public void addSongs(List<Songs> songs){
            this.songs = songs;
        }

        public List<Songs> getAllSongsOnPlaylist(){
            return songs;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public int getTotalSongs() {
            return totalSongs;
        }

        public void setTotalSongs(int totalSongs) {
            this.totalSongs = totalSongs;
        }

        public String getTotalTime() {
            int seconds = (int) (totalTime / 1000) % 60 ;
            int minutes = (int) ((totalTime / (1000*60)) % 60);
            int hours   = (int) ((totalTime / (1000*60*60)) % 24);
            return hours+":"+minutes+":"+seconds;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }

        @Override
        public String toString() {
            return name;
        }
}
