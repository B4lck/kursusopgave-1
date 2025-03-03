package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import model.Model;

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
}
