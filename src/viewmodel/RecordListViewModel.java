package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import model.Model;

import javax.swing.text.View;

public class RecordListViewModel {
    private ObservableList<SimpleRecordViewModel> list;
    private ObjectProperty<SimpleRecordViewModel> selectedRecordProperty;
    private Model model;
    private ViewState viewState;

    public RecordListViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
    }
}
