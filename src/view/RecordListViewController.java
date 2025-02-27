package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewmodel.SimpleRecordViewModel;

public class RecordListViewController extends ViewController {
    @FXML
    private TableView<SimpleRecordViewModel> recordsTable;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> titleColumn;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> artistColumn;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> yearColumn;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> loanStateColumn;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private Button addEditButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button loanReserveReturnButton;

    @Override
    protected void init() {

    }
}
