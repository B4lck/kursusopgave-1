package model;

public interface RecordState {
    void lend(String username);
    void reserve(String username);
    void remove();
    void returnRecord();
}
