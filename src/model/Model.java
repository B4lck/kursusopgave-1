package model;

import java.util.ArrayList;

public interface Model extends PropertyChangeSubject {

    Record getRecord(int index);
    ArrayList<Record> getAllRecords();
    void update();
    void addRecord(Record record);
    void removeRecord(Record record);
}
