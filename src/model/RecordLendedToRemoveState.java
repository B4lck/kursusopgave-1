package model;

public class RecordLendedToRemoveState implements RecordState {
    private Record record;

    public RecordLendedToRemoveState(Record record) {
        this.record = record;
    }

    @Override
    public void lendRecord(String username) {
        throw new IllegalStateException("Pladen skal fjernes, og kan derfor ikke lånes");
    }

    @Override
    public void reserveRecord(String username) {
        throw new IllegalStateException("Pladen skal fjernes, og kan derfor ikke reserveres");
    }

    @Override
    public void removeRecord() {
        throw new IllegalStateException("Pladen skal allerede fjernes");
    }

    @Override
    public void returnRecord() {
        record.setLendedTo(null);
        record.setState(new RecordLendedToRemoveState(record));
    }
}
