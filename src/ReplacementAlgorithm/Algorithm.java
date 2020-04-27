package ReplacementAlgorithm;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

public abstract class Algorithm {

    public static int FIFO(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        int head = 0;
        int counter =0;

        PrintInitialTable(INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            Page p = iterator.next();
            if(!IfPageIsInFrames(p,frames)){
                frames[head++] = p;
                head %= INITIAL_FRAME_SIZE;
                counter++;
            }
            PrintPagesStatus(p,frames);
        }
        return counter;
    }
    public static int OPT(){
        return 0;
    }
    public static int LRU(){
        return 0;
    }

    public static int aLRU(){
        return 0;
    }

    public static int RAND(){
        return 0;
    }

    private static boolean IfPageIsInFrames(Page p, Page[] frames) {
        for(int i = 0 ; i < frames.length ; i++ ){
            try {
                if (frames[i].compareTo(p) == 0)
                    return true;
                }catch (NullPointerException e) {
                    return false;
                }
            }
        return false;
    }

    private static void PrintInitialTable(int INITIAL_FRAME_SIZE){
        System.out.print("Reference | ");
        for(int i = 0 ; i < INITIAL_FRAME_SIZE ;i++)
            System.out.print("Frame "+ i + " | ");
        System.out.print("\n");
    }

    private static void PrintPagesStatus(Page p, Page[] frames){
        System.out.print("    "+p+"        ");
        for(int i = 0; i < frames.length; i++ ){
            if(frames[i] == null)
                System.out.print("         ");
            else
                System.out.print(frames[i]+"        ");
        }
        System.out.print("\n");
    }
}
