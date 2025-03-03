package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import model.Record;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecordListViewModel implements PropertyChangeListener {
    private ObservableList<SimpleRecordViewModel> list = FXCollections.observableArrayList();
    private ObjectProperty<SimpleRecordViewModel> selectedRecordProperty = new SimpleObjectProperty<>();
    private Model model;
    private ViewState viewState;

    private StringProperty username = new SimpleStringProperty();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        loadRecordList();
    }

    public RecordListViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;

        this.model.addListener(this);

        loadRecordList();
    }

    public void clear() {
        list.clear();
    }

    private void loadRecordList() {
        clear();
        for (Record record : model.getAllRecords()) {
            this.list.add(new SimpleRecordViewModel(record));
        }
    }

    public void setSelectedRecord(SimpleRecordViewModel recordViewModel) {
        viewState.setSelectedRecord(recordViewModel.getRecord());
    }

    public void addEditRecord() {
        setSelectedRecord(selectedRecordProperty.get());
    }

    public void removeRecord() {
        setSelectedRecord(selectedRecordProperty.get());
        viewState.setRemoveRecord(true);
    }

    public void loanReserveReturnRecord() {
        Record record = viewState.getSelectedRecord();

        if (record.getState().getClass().equals(RecordAvailableState.class)) {
            // Hvis den er tilgængelig
            record.lendRecord(viewState.getUsername());
        } else if(record.getState().getClass().equals(RecordLendedState.class) && viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er udlejet, og lejeren har trykket
            record.returnRecord();
        } else if (record.getState().getClass().equals(RecordLendedState.class) && !viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er udlejet, og en anden har trykket
            record.reserveRecord(viewState.getUsername());
        } else if (record.getState().getClass().equals(RecordReservedState.class) && viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er reserveret, og lejeren har trykket
            record.returnRecord();
        } else {
            throw new IllegalStateException("Der foregår noget mystisk");
        }
    }

    public void setCurrentUser() {
        viewState.setUsername(username.get());
    }

    public ObservableList<SimpleRecordViewModel> getList() {
        return list;
    }

    public ObjectProperty<SimpleRecordViewModel> getSelectedRecordProperty() {
        return selectedRecordProperty;
    }
}

