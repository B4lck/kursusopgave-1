package viewmodel;

import model.Record;

public class ViewState {
    private Record selectedRecord;
    private boolean removeRecord;
    private String username;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

}
