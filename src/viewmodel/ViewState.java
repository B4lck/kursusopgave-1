package viewmodel;

public class ViewState {
    private Record selectedRecord;
    private boolean removeRecord;
    private ManageRecordViewModel manageRecordViewModel;

    public Record getSelectedRecord() {
        return selectedRecord;
    }

    public boolean isRemoveRecord() {
        return removeRecord;
    }

    public void setSelectedRecord(Record selectedRecord) {
        this.selectedRecord = selectedRecord;
    }

    public void setRemoveRecord(boolean removeRecord) {
        this.removeRecord = removeRecord;
    }
}
