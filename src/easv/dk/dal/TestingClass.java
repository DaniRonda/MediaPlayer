package easv.dk.dal;

import easv.dk.be.Songs;

public class TestingClass {

    public static void main(String[] args) {
        deletesong();

    }

    public static void deletesong() {
        SongDAO_DB db = new SongDAO_DB();
        Songs s = new Songs(1, "Antes muerta que sencilla","María Isabel", "lameo2","2.32", "oleoleloscaracole.com");
        db.deleteSongs(s);

    }

}