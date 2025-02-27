package model;

public class RecordReservedState implements RecordState{
    private String reservedFor;
    private Record record;

    public RecordReservedState(Record record, String reserveFor) {
        this.record = record;
        this.reservedFor = reserveFor;
    }

    @Override
    public void lendRecord(String username) {
        throw new IllegalStateException("Pladen er allerede udlånt");
    }

    @Override
    public void reserveRecord(String username) {
        throw new IllegalStateException("Pladen er allerede reserveret");
    }

    @Override
    public void removeRecord() {
        record.setState(new RecordLendedToRemoveState(record));
    }

    @Override
    public void returnRecord() {
        record.setState(new RecordLendedState(record, reservedFor));
    }
}
