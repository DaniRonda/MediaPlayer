package easv.dk.dal;

import easv.dk.be.Songs;

public class TestingClass {

    public static void main(String[] args) {
        deletesong();

    }

    public static void deletesong() {
        SongDAO_DB db = new SongDAO_DB();
        Songs s = new Songs("mira intelij","tecojoytereviento","yluegoatumadre",3,"aveono",1);
        db.deleteSong(s);

    }

}