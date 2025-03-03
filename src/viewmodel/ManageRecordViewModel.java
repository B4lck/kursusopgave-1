package viewmodel;

import javafx.beans.property.*;
import model.Model;
import model.Record;

public class ManageRecordViewModel {
    private StringProperty manageHeaderTitleProperty = new SimpleStringProperty();
    private StringProperty titleProperty = new SimpleStringProperty();
    private StringProperty artistProperty = new SimpleStringProperty();
    private IntegerProperty yearProperty = new SimpleIntegerProperty();
    private StringProperty stateProperty = new SimpleStringProperty();
    private ObjectProperty<Boolean> editableProperty = new SimpleObjectProperty<>();
    private StringProperty errorProperty = new SimpleStringProperty();

    private Model model;
    private ViewState viewState;

    public ManageRecordViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
    }

    public void reset() {
        if (this.viewState.isRemoveRecord()) {
            // Fjern
            manageHeaderTitleProperty.set("Fjern " + this.viewState.getSelectedRecord().getTitle());
        } else if (this.viewState.getSelectedRecord() != null) {
            // Rediger
            manageHeaderTitleProperty.set("Rediger " + this.viewState.getSelectedRecord().getTitle());
            titleProperty.setValue(this.viewState.getSelectedRecord().getTitle());
            artistProperty.setValue(this.viewState.getSelectedRecord().getArtist());
            yearProperty.setValue(this.viewState.getSelectedRecord().getYear());
            stateProperty.setValue(this.viewState.getSelectedRecord().getState().getClass().getSimpleName());
        } else {
            // Opret
            manageHeaderTitleProperty.set("Opret ny rekord");
            titleProperty.setValue("");
            artistProperty.setValue("");
            yearProperty.setValue(0);
            stateProperty.setValue("");
        }

        editableProperty.set(!this.viewState.isRemoveRecord());
    }

    public void updateRecord() {
        Record record = this.viewState.getSelectedRecord();
        record.set(titleProperty.get(), artistProperty.get(), yearProperty.get());
    }

    private void createRecord() {
        model.addRecord(new Record(titleProperty.get(), artistProperty.get(), yearProperty.get()));
    }

    public void removeRecord() {
        Record record = this.viewState.getSelectedRecord();
        model.removeRecord(record);
    }

    public void accept() {
        if (this.viewState.isRemoveRecord()) {
            removeRecord();
        } else if (this.viewState.getSelectedRecord() != null) {
            updateRecord();
        } else {
            createRecord();
        }
    }

    public StringProperty getManageHeaderTitleProperty() {
        return manageHeaderTitleProperty;
    }

    public StringProperty getArtistProperty() {
        return artistProperty;
    }

    public IntegerProperty getYearProperty() {
        return yearProperty;
    }

    public StringProperty getTitleProperty() {
        return titleProperty;
    }

    public StringProperty getStateProperty() {
        return stateProperty;
    }

    public ObjectProperty<Boolean> getEditableProperty() {
        return editableProperty;
    }

    public StringProperty getErrorProperty() {
        return errorProperty;
    }

}
