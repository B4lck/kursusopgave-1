package model;

public class Record {
    private String title;
    private String artist;
    private int year;
    private RecordState state;
    private String lentTo;
    private boolean remove = false;

    public Record(String title, String artist, int year) {
        set(title, artist, year);
    }

    public void set(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.state = new RecordAvailableState(this);
    }

    public void setState(RecordState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public RecordState getState() {
        return state;
    }

    public boolean isRemove() {
        return remove;
    }

    public void lendRecord(String username) {
        state.lendRecord(username);
    }

    public void reserveRecord(String username) {
        state.reserveRecord(username);
    }

    public void removeRecord() {
        state.removeRecord();
    }

    public void returnRecord() {
        state.returnRecord();
    }

    public void setLentTo(String lendTo) {
        this.lentTo = lendTo;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public String getLentTo() {
        return this.lentTo;
    }
}
