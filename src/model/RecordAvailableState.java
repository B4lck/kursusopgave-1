package model;

/**
 * State hvor pladen ikke er lånt, og kan lånes.
 */
public class RecordAvailableState implements RecordState {
    private final Record record;

    public RecordAvailableState(Record record) {
        this.record = record;
    }

    @Override
    public void lendRecord(String username) {
        record.setState(new RecordLendedState(record, username));
    }

    @Override
    public void reserveRecord(String username) {
        throw new IllegalStateException("Pladen er ikke lånt");
    }

    @Override
    public void removeRecord() {
        record.setState(new RecordReadyToRemoveState(record));
    }

    @Override
    public void returnRecord() {
        throw new IllegalStateException("Pladen er ikke lånt");
    }
}
