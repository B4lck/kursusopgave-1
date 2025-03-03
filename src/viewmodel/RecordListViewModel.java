package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import model.*;
import model.Record;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecordListViewModel implements PropertyChangeListener {
    private ObservableList<SimpleRecordViewModel> list;
    private ObjectProperty<SimpleRecordViewModel> selectedRecordProperty;
    private Model model;
    private ViewState viewState;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        loadRecordList();
    }

    public RecordListViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
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
        selectedRecordProperty.setValue(recordViewModel);
        viewState.setSelectedRecord(recordViewModel.getRecord());
    }

    public void addEditRecord() {
        // Åben nyt vindue
    }

    public void removeRecord() {
        // Alert - Hey då!
        viewState.setRemoveRecord(true);
    }

    public void loanReserveReturnRecord() {
        Record record = viewState.getSelectedRecord();

        if (record.getState().getClass().getName().equals(RecordAvailableState.class.getName())) {
            // Hvis den er tilgængelig
            record.lendRecord(viewState.getUsername());
        } else if(record.getState().getClass().getName().equals(RecordLendedState.class.getName()) && viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er udlejet, og lejeren har trykket
            record.returnRecord();
        } else if (record.getState().getClass().getName().equals(RecordLendedState.class.getName()) && !viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er udlejet, og en anden har trykket
            record.reserveRecord(viewState.getUsername());
        } else if (record.getState().getClass().getName().equals(RecordReservedState.class.getName()) && viewState.getUsername().equals(record.getLendedToUsername())) {
            // Hvis den er reserveret, og lejeren har trykket
            record.returnRecord();
        } else {
            throw new IllegalStateException("Der foregår noget mystisk");
        }
    }

    public void setCurrentUser(String username) {
        viewState.setUsername(username);
    }
}

