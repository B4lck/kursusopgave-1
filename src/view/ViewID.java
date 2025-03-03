package view;

public enum ViewID {
    RECORD_LIST("RecordListView.fxml"), MANAGE_RECORD("ManageRecordView.fxml");

    private final String filename;

    private ViewID(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
