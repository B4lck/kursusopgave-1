package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Record;

public class SimpleRecordViewModel {
    private Record record;
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty stateProperty;

    public SimpleRecordViewModel(Record record) {
        this.record = record;

        titleProperty = new SimpleStringProperty();
        artistProperty = new SimpleStringProperty();
        yearProperty = new SimpleIntegerProperty();
        stateProperty = new SimpleStringProperty();

        update();
    }

    public void update() {
        this.titleProperty.setValue(record.getTitle());
        this.artistProperty.setValue(record.getArtist());
        this.yearProperty.setValue(record.getYear());
        this.stateProperty.setValue(record.getState().toString());
    }

    public StringProperty getTitleProperty() {
        return titleProperty;
    }

    public StringProperty getArtistProperty() {
        return artistProperty;
    }

    public IntegerProperty getYearProperty() {
        return yearProperty;
    }

    public StringProperty getStateProperty() {
        return stateProperty;
    }

    public Record getRecord() {
        return this.record;
    }
}
