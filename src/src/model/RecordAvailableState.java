package model;

public class RecordAvailableState implements RecordState {
    private Record record;

    public RecordAvailableState(Record record) {
        this.record = record;
    }

    @Override
    public void lend(String username) {
        record.setState(new RecordLendedState(record, username));
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
