package model;

public class RecordLendedState implements RecordState{
    private String lendedTo;
    private Record record;

    public RecordLendedState(Record record, String lendTo) {
        this.lendedTo = lendTo;
        this.record = record;
    }

    @Override
    public void lend(String username) {

    }

    @Override
    public void reserve(String username) {
        record.setState(new RecordReservedState(record, this.lendedTo, username));
    }

    @Override
    public void remove() {
        record.setState(new RecordToRemoveState(record));
    }

    @Override
    public void returnRecord() {

    }
}
