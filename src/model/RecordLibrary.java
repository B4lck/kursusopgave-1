package model;

import java.util.ArrayList;

public class RecordLibrary implements Model{
    private ArrayList<Record> records = new ArrayList<>();

    @Override
    public Record getRecord(int index) {
        return records.get(index);
    }

    @Override
    public ArrayList<Record> getAllRecords() {
        return records;
    }

    @Override
    public void addRecord(Record record) {
        this.records.add(record);
    }

    @Override
    public void removeRecord(Record record) {
        this.records.remove(record);
    }
}
