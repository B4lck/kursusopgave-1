package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class RecordLibrary implements Model, PropertyChangeSubject {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private ArrayList<Record> records = new ArrayList<>();

    @Override
    public Record getRecord(int index) {
        return records.get(index);
    }


    @Override
    public ArrayList<Record> getAllRecords() {
        removeAllToRemoveRecord();
        return records;
    }

    @Override
    public void addRecord(Record record) {
        this.records.add(record);
        support.firePropertyChange("Add", null, record);
    }

    @Override
    public void removeRecord(Record record) {
        record.removeRecord();
    }

    private void removeAllToRemoveRecord() {
        for (int i = records.size() - 1; i >= 0; i--) {
            if (records.get(i).isRemove()) {
                support.firePropertyChange("Remove", records.get(i), null);
                records.remove(i);
            }
        }
    }

    @Override
    public void update() {
        support.firePropertyChange("Update", false, true);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
