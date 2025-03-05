package viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
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
    private StringProperty acceptTextProperty = new SimpleStringProperty();

    private Model model;
    private ViewState viewState;

    public ManageRecordViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
    }

    public void reset() {
        if (this.viewState.getSelectedRecord() != null) {
            titleProperty.setValue(this.viewState.getSelectedRecord().getTitle());
            artistProperty.setValue(this.viewState.getSelectedRecord().getArtist());
            yearProperty.setValue(this.viewState.getSelectedRecord().getYear());
            stateProperty.setValue(this.viewState.getSelectedRecord().getState().toString());
        } else {
            titleProperty.setValue("");
            artistProperty.setValue("");
            yearProperty.setValue(0);
            stateProperty.setValue("");
        }

        if (this.viewState.isRemoveRecord()) {
            // Fjern
            manageHeaderTitleProperty.set("Fjern " + this.viewState.getSelectedRecord().getTitle());
            acceptTextProperty.setValue("Fjern");
        } else if (this.viewState.getSelectedRecord() != null) {
            // Rediger
            manageHeaderTitleProperty.set("Rediger " + this.viewState.getSelectedRecord().getTitle());
            acceptTextProperty.setValue("Gem");
        } else {
            // Opret
            manageHeaderTitleProperty.set("Opret ny rekord");
            acceptTextProperty.setValue("Opret");
        }

        editableProperty.set(!this.viewState.isRemoveRecord());
    }

    private void updateRecord() {
        Record record = this.viewState.getSelectedRecord();
        record.set(titleProperty.get(), artistProperty.get(), yearProperty.get());
    }

    private void createRecord() {
        model.addRecord(new Record(titleProperty.get(), artistProperty.get(), yearProperty.get()));
    }

    private void removeRecord() {
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

    public StringProperty getAcceptTextProperty() {
        return acceptTextProperty;
    }
}
