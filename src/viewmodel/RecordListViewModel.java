package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import model.Model;

public class RecordListViewModel {
    private ObservableList<SimpleRecordViewModel> list;
    private ObjectProperty<SimpleRecordViewModel> selectedRecordProperty;

}
