public class MyDate {
    private short day;
    private short month;
    private short year;

    public MyDate() {}
    
    public MyDate(short day, short month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Convenience constructor that accepts int parameters.  Values are
     * cast to short to match the internal representation.
     */
    public MyDate(int day, int month, int year) {
        this((short) day, (short) month, (short) year);
    }

    public MyDate(MyDate p_mydate) {
        this.day = p_mydate.day;
        this.month = p_mydate.month;
        this.year = p_mydate.year;
    }

    @Override
    public String toString() {
        // simply format the three fields; using String.valueOf to avoid
        // recursive calls to this.toString()
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }
}
