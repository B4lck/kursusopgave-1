package model;

public interface RecordState {
    void lendRecord(String username);
    void reserveRecord(String username);
    void removeRecord();
    void returnRecord();
    String toString();
}
