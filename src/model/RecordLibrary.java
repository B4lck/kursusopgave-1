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
        update();
        return records;
    }

    @Override
    public void addRecord(Record record) {
        this.records.add(record);
        support.firePropertyChange("Added Record", null, record);
    }

    @Override
    public void removeRecord(Record record) {
        this.records.remove(record);
        support.firePropertyChange("Removed Record", record, null);
    }

    @Override
    public void update() {
        for (int i = records.size() - 1; i >= 0; i--) {
            if (records.get(i).isRemove()) {
                records.remove(i);
            }
        }
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
