package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewmodel.RecordListViewModel;
import viewmodel.SimpleRecordViewModel;

public class RecordListViewController extends ViewController<RecordListViewModel> {
    @FXML
    private TableView<SimpleRecordViewModel> recordsTable;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> titleColumn;
    @FXML
    private TableColumn<SimpleRecordViewModel, String> artistColumn;
    @FXML
    private TableColumn<SimpleRecordViewModel, Number> yearColumn;
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

    public void reset() {
        getViewModel().clear();
    }

    @Override
    protected void init() {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().getTitleProperty());
        artistColumn.setCellValueFactory(cellData -> cellData.getValue().getArtistProperty());
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYearProperty());
        loanStateColumn.setCellValueFactory(cellData -> cellData.getValue().getStateProperty());
        recordsTable.setItems(getViewModel().getList());

        usernameField.textProperty().bindBidirectional(getViewModel().getUserNameProperty());

        getViewModel().getSelectedRecordProperty().bind(recordsTable.getSelectionModel().selectedItemProperty());

        getViewModel().getCanEditProperty().addListener((evt, oldValue, newValue) -> {
            addEditButton.setText(newValue ? "Rediger" : "Tilføj");
            removeButton.setDisable(!newValue);
            loanReserveReturnButton.setDisable(!newValue);
        });

        loanReserveReturnButton.textProperty().bind(getViewModel().getLoanReserveReturnTextProperty());
    }

    @FXML
    private void addEdit() {
        getViewModel().addEditRecord();
        getViewHandler().openView(ViewID.MANAGE_RECORD);
    }

    @FXML
    private void remove() {
        getViewModel().removeRecord();
        getViewHandler().openView(ViewID.MANAGE_RECORD);
    }

    @FXML
    private void loanReserveReturn() {
        getViewModel().loanReserveReturnRecord();
    }
}
