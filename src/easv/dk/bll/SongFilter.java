package easv.dk.bll;

import easv.dk.be.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongFilter {

    private ObservableList<Songs> temp = FXCollections.observableArrayList();

    /*
    Searches trough all song titles and gets all items that start with specifies string
     */
    public ObservableList<Songs> search(ObservableList<Songs> items, String text) {
        temp.clear();
        for (Songs item : items) {
            if (item.getTitle().toLowerCase().startsWith(text.toLowerCase())) {
                temp.add(item);
            }
        }
        return temp;
    }

}