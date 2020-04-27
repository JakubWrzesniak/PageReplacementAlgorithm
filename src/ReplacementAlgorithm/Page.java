package ReplacementAlgorithm;

public class Page implements Comparable<Page> {
    private int number;
    private boolean mifBit; // Bit modyfikacji
    private int reference;

    public Page(int number, boolean mifBit, int reference) {
        this.number = number;
        this.mifBit = mifBit;
        this.reference = reference;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isMifBit() {
        return mifBit;
    }

    public void setMifBit(boolean mifBit) {
        this.mifBit = mifBit;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        Page p = (Page) obj;
        return this.number == ((Page) obj).getNumber() ;
    }

    @Override
    public int compareTo(Page o) {
        if(this.number == o.getNumber())
            return 0;
        if(this.number<o.getNumber())
            return -1;
        else
            return 1;
    }

    @Override
    public String toString() {
        return number + " ";
    }
}
