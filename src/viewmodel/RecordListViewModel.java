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

    private StringProperty userNameProperty = new SimpleStringProperty();

    private StringProperty errorProperty = new SimpleStringProperty();
    private ObjectProperty<Boolean> canEditProperty = new SimpleObjectProperty<>();
    private StringProperty loanReserveReturnTextProperty = new SimpleStringProperty();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        clear();
    }

    public RecordListViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;

        this.model.addListener(this);

        selectedRecordProperty.addListener((evt, oldValue, newValue) -> {
            setSelectedRecord(newValue);
        });

        clear();
    }

    public void clear() {
        list.clear();
        canEditProperty.set(false);
        loadRecordList();
    }

    private void loadRecordList() {
        for (Record record : model.getAllRecords()) {
            this.list.add(new SimpleRecordViewModel(record));
        }
    }

    public void setSelectedRecord(SimpleRecordViewModel recordViewModel) {
        viewState.setSelectedRecord(recordViewModel == null ? null : recordViewModel.getRecord());

        canEditProperty.set(recordViewModel != null);
    }

    public void addEditRecord() {
    }

    public void removeRecord() {
        viewState.setRemoveRecord(true);
        clear();
    }

    public void loanReserveReturnRecord() {
        Record record = viewState.getSelectedRecord();

        String user = userNameProperty.get();

        try {
            if (record.getState().getClass().equals(RecordAvailableState.class)) {
                // Hvis den er tilgængelig
                record.lendRecord(user);
            } else if (record.getState().getClass().equals(RecordLendedState.class) && user.equals(record.getLentTo())) {
                // Hvis den er udlejet, og lejeren har trykket
                record.returnRecord();
            } else if (record.getState().getClass().equals(RecordLendedState.class) && !user.equals(record.getLentTo())) {
                // Hvis den er udlejet, og en anden har trykket
                record.reserveRecord(user);
            } else if (record.getState().getClass().equals(RecordReservedState.class) && user.equals(record.getLentTo())) {
                // Hvis den er reserveret, og lejeren har trykket
                record.returnRecord();
            } else {
                throw new IllegalStateException("Der foregår noget mystisk");
            }
            clear();
        } catch (Exception e) {
            errorProperty.set(e.getMessage());
        }
    }

    public ObservableList<SimpleRecordViewModel> getList() {
        return list;
    }

    public ObjectProperty<SimpleRecordViewModel> getSelectedRecordProperty() {
        return selectedRecordProperty;
    }

    public StringProperty getUserNameProperty() {
        return userNameProperty;
    }

    public StringProperty getErrorProperty() {
        return errorProperty;
    }

    public ObjectProperty<Boolean> getCanEditProperty() {
        return canEditProperty;
    }

    public StringProperty getLoanReserveReturnTextProperty() {
        return loanReserveReturnTextProperty;
    }
}

