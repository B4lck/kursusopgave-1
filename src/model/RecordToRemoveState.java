package model;

public class RecordToRemoveState implements RecordState {
    private Record record;

    public RecordToRemoveState(Record record) {
        this.record = record;
    }

    @Override
    public void lend(String username) {

    }

    @Override
    public void reserve(String username) {

    }

    @Override
    public void remove() {

    }

    @Override
    public void returnRecord() {

    }
}
