package model;

public class RecordLendedState implements RecordState {
    private Record record;

    public RecordLendedState(Record record, String lendTo) {
        this.record = record;
        // Entry
        record.setLentTo(lendTo);
    }

    @Override
    public void lendRecord(String username) {
        throw new IllegalStateException("Pladen er allerede udlånt");
    }

    @Override
    public void reserveRecord(String username) {
        record.setState(new RecordReservedState(record, username));
    }

    @Override
    public void removeRecord() {
        record.setState(new RecordLendedToRemoveState(record));
    }

    @Override
    public void returnRecord() {
        record.setLentTo(null);
        record.setState(new RecordAvailableState(record));
    }

    @Override
    public String toString() {
        return "Udlånt";
    }
}
