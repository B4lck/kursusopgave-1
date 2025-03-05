package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewmodel.ManageRecordViewModel;

public class ManageRecordViewController extends ViewController<ManageRecordViewModel> {
    @FXML
    private Label headerTitle;
    @FXML
    private TextField titleField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField yearField;
    @FXML
    private Label stateProperty;
    @FXML
    private Label errorLabel;
    @FXML
    private Button acceptButton;

    public void reset() {
        getViewModel().reset();
    }

    @Override
    protected void init() {
        headerTitle.textProperty().bind(getViewModel().getManageHeaderTitleProperty());
        titleField.textProperty().bindBidirectional(getViewModel().getTitleProperty());
        artistField.textProperty().bindBidirectional(getViewModel().getArtistProperty());
        Bindings.bindBidirectional(yearField.textProperty(), getViewModel().getYearProperty(), new StringIntegerConverter(0));
        stateProperty.textProperty().bind(getViewModel().getStateProperty());
        errorLabel.textProperty().bind(getViewModel().getErrorProperty());
        acceptButton.textProperty().bind(getViewModel().getAcceptTextProperty());

        getViewModel().getEditableProperty().addListener((evt, oldValue, newValue) -> {
            titleField.setDisable(!newValue);
            artistField.setDisable(!newValue);
            yearField.setDisable(!newValue);
        });
    }

    @FXML
    private void update() {
        getViewModel().accept();
        getViewHandler().openView(ViewID.RECORD_LIST);
    }

    @FXML
    private void cancel() {
        getViewHandler().openView(ViewID.RECORD_LIST);
    }

}
