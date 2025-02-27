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
        update();
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
    @Override
    public void update() {
        for (int i = records.size()-1 ; i >= 0; i--) {
            if (records.get(i).isRemove()){
                records.remove(i);
            }
        }
    }
}
