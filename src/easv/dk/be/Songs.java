package easv.dk.be;

public class Songs {
        private int id;
        private String title;
        private int IDinList = 0;
        private String artist;
        private String category;
        private int time;
        private String fileurl;
        private int position;

        public Songs(String title, String artist, String category, int time, String fileurl, int id) {
                this.title = title;
                this.artist = artist;
                this.category = category;
                this.time = time;
                this.fileurl = fileurl;
                this.id = id;
        }

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

        public int getTime() {
                return time;
        }

        public void setTime(int time) {
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

        public int getIDinsideList() {return IDinList;}

        public void setIDinsideList(int IDinsideList) {this.IDinList = IDinsideList;}


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