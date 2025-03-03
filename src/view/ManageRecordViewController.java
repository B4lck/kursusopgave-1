package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewmodel.ManageRecordViewModel;

public class ManageRecordViewController extends ViewController{
    private ManageRecordViewModel manageRecordViewModel;
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

    public void reset() {

    }

    @Override
    protected void init() {
        titleField.textProperty().bindBidirectional(manageRecordViewModel.getTitleProperty());
        artistField.textProperty().bindBidirectional(manageRecordViewModel.getArtistProperty());

    }

    @FXML
    private void update() {

    }

    @FXML
    private void cancel() {
        getViewHandler().openView(ViewID.RECORD_LIST);
    }

}
