package easv.dk.be;

public class Songs {
        private int id;
        private String title;

        public Songs(int id, String title, String artist, String category, String time, String fileurl) {
                this.id = id;
                this.title = title;
                this.artist = artist;
                this.category = category;
                this.time = time;
                this.fileurl = fileurl;
        }

        private String artist;
        private String category;
        private String time;
        private String fileurl;
        private int position;



        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getArtist() {
                return artist;
        }

        public void setArtist(String artist) {
                this.artist = artist;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getTime() {
                return time;
        }

        public void setTime(String time) {
                this.time = time;
        }

        public String getFileurl() {
                return fileurl;
        }

        public void setFileurl(String fileurl) {
                this.fileurl = fileurl;
        }

        public int getPosition() {
                return position;
        }

        public void setPosition(int position) {
                this.position = position;
        }

        @Override
        public String toString() {
                return "Songs{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", artist='" + artist + '\'' +
                        ", category='" + category + '\'' +
                        ", time='" + time + '\'' +
                        ", fileurl='" + fileurl + '\'' +
                        ", position=" + position +
                        '}';
        }
}