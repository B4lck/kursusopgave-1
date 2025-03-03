package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.Record;

public class ManageRecordViewModel {
    private StringProperty manageHeaderTitleProperty;
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty stateProperty;
    private ObjectProperty<Boolean> editableProperty;
    private Model model;
    private ViewState viewState;

    public ManageRecordViewModel(Model model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
    }

    public void updateRecord() {
        Record record = this.viewState.getSelectedRecord();

        if (record == null) {
            createRecord();
        }
        else {
            record.set(titleProperty.get(), artistProperty.get(), yearProperty.get());
        }
    }

    private void createRecord() {
        model.addRecord(new Record(titleProperty.get(), artistProperty.get(), yearProperty.get()));
    }

    public void removeRecord() {
        Record record = this.viewState.getSelectedRecord();
        model.removeRecord(record);
    }
}
