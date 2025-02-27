package model;

public class RecordReservedState implements RecordState{
    private String reservedFor;
    private String lendedTo;
    private Record record;

    public RecordReservedState(Record record, String lendTo, String reserveFor) {
        this.lendedTo = lendTo;
        this.record = record;
        this.reservedFor = reserveFor;
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
