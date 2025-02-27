package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;

public class RecordListViewModel {
    private ObservableList<SimpleRecordViewModel> list;
    private ObjectProperty<SimpleRecordViewModel> selectedRecordProperty;

}
