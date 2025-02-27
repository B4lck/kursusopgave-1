package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class ManageRecordViewModel {
    private StringProperty manageHeaderTitleProperty;
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private IntegerProperty yearProperty;
    private StringProperty stateProperty;
    private ObjectProperty<Boolean> editableProperty;
}
