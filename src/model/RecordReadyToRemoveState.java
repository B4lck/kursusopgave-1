package model;

public class RecordReadyToRemoveState implements RecordState {
    private Record record;

    public RecordReadyToRemoveState(Record record) {
        this.record = record;
        record.setRemove(true);
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
        throw new IllegalStateException("Pladen skal allerede fjernes");
    }

    @Override
    public String toString() {
        return "Fjernes";
    }
}
