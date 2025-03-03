package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class SimpleRecordViewModel {
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty stateProperty;

    public SimpleRecordViewModel() {}

    public String getTitleProperty() {
        return titleProperty.get();
    }

    public String getArtistProperty() {
        return artistProperty.get();
    }

    public int getYearProperty() {
        return yearProperty.get();
    }

    public String getStateProperty() {
        return stateProperty.get();
    }
}
