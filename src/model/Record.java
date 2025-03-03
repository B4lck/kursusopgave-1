package model;

public class Record {
    private String title;
    private String artist;
    private int year;
    private RecordState state;

    // TILFØJ TIL UML
    private String lendedToUsername;
    private boolean remove = false;

    public Record(String title, String artist, int year) {
        set(title, artist, year);
    }

    // TILFØJ TIL UML
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

    // OPDATER UML
    public void lendRecord(String username) {
        state.lendRecord(username);
    }

    // OPDATER UML
    public void reserveRecord(String username) {
        state.reserveRecord(username);
    }

    // OPDATER UML
    public void removeRecord() {
        state.removeRecord();
    }

    // OPDATER UML
    public void returnRecord() {
        state.returnRecord();
    }

    // OPDATER UML
    public void setLendedTo(String lendTo) {
        this.lendedToUsername = lendTo;
    }

    // OPDATER UML
    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public String getLendedToUsername() {
        return this.lendedToUsername;
    }
}
