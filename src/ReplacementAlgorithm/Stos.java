package ReplacementAlgorithm;

import java.util.ArrayList;
import java.util.Objects;

public class Stos <E> {
    private ArrayList<E> stos;

    public Stos(){
        stos = new ArrayList<>();
    }

    public E pop() throws IndexOutOfBoundsException {
        E t = stos.get(0);
        stos.remove(0);
        return t ;
    }

    public boolean add(E elem){
        if(conatains(elem)==-1){
            stos.add(elem);
            return true;
        }
        return false;
    }

    public int conatains(E elem){
        if(stos.size()>0) {
            for (int i = 0; i < stos.size(); i++) {
                if (stos.get(i).equals(elem))
                    return i;
            }
        }
        return -1;
    }

    public E get(E elem) throws IndexOutOfBoundsException{
        return stos.get(conatains(elem));
    }

    public E get(int pos) throws IndexOutOfBoundsException{
        return stos.get(pos);
    }

    @Override
    public String toString() {
        return "Stos" + stos;
    }
}
