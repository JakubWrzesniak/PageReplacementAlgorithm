package ReplacementAlgorithm;

public class Page implements Comparable<Page> {
    private int number;
    private boolean mifBit; // Bit modyfikacji
    private int timeOfLastWork;

    public Page(int number, boolean mifBit, int timeOfLastWork) {
        this.number = number;
        this.mifBit = mifBit;
        this.timeOfLastWork = timeOfLastWork;
    }

    public int getNumber() {
        return number;
    }


    public boolean isMifBit() {
        return mifBit;
    }

    public void setMifBit(boolean mifBit) {
        this.mifBit = mifBit;
    }

    public int getTimeOfLastWork() {
        return timeOfLastWork;
    }

    public void setTimeOfLastWork(int timeOfLastWork) {
        this.timeOfLastWork = timeOfLastWork;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((Page) obj).getNumber() ;
    }

    @Override
    public int compareTo(Page o) {
        if(this.timeOfLastWork == o.getTimeOfLastWork())
            return 0;
        if(this.timeOfLastWork<o.getTimeOfLastWork())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return number + " " ;
    }
}
