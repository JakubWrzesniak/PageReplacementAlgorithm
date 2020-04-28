package ReplacementAlgorithm;

import java.util.*;

public abstract class Algorithm {

    public static int FIFO(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        int head = 0;
        int counter =0;

        PrintInitialTable("FIFO",INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            Page p = iterator.next();
            if(!PageIsInFrames(p,frames)){
                frames[head++] = p;
                head %= INITIAL_FRAME_SIZE;
                counter++;
            }
            PrintPagesStatus(p,frames);
        }
        return counter;
    }
    public static int OPT(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        int counter = 0;
        int head = 0;
        int number = 0;

        PrintInitialTable("OPT",INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            Page p = iterator.next();
            if(!PageIsInFrames(p,frames)){
                if(frames[frames.length-1]==null)
                    frames[head++] = p;
                else{
                    int pos = FindPosOfTheLatestPage(pagesReferences.subList(number,pagesReferences.size()),frames);
                    if(pos != -1)
                        frames[pos] = p;
                    else
                        frames[head++] = p;
                }
                head %= INITIAL_FRAME_SIZE;
                counter++;
            }
            PrintPagesStatus(p,frames);
            number++;
        }
        return counter;
    }
    public static int LRU(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        ArrayList<Page> temp = new ArrayList<>();
        int counter = 0;
        int head = 0;
        int number = 1;

        PrintInitialTable("LRU",INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            Page p = iterator.next();
            if(!PageIsInFrames(p,frames)) {
                p.setTimeOfLastWork(number);
                if(frames[frames.length-1]==null) {
                    frames[head++] = p;
                    head %= INITIAL_FRAME_SIZE;
                }else{
                    temp.addAll(Arrays.asList(frames));
                    Collections.sort(temp);
                    for(int i = 0 ; i < frames.length ;i ++)
                        if(frames[i].equals(temp.get(0)))
                            frames[i] = p;
                    temp.clear();
                }
                counter++;
            }
            else{
                for(Page page : frames){
                    try {
                        if (page.equals(p))
                            page.setTimeOfLastWork(number);
                    }catch (NullPointerException e){}
                }
            }
            PrintPagesStatus(p,frames);
            number++;
        }
        return counter;
    }

    public static int aLRU(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        Stos<Page> stos = new Stos<>();
        Page p, temp;
        int head = 0;
        int counter =0;

        PrintInitialTable("aLRU",INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            p = iterator.next();
            if(!PageIsInFrames(p ,frames)){
                if(frames[frames.length-1] == null){
                    frames[head++] = p;
                    head %= INITIAL_FRAME_SIZE;
                }else{
                    Page tempPage;
                    temp = null;
                    while (temp == null){
                        if(stos.get(0).isMifBit()){
                            tempPage = stos.pop();
                            tempPage.setMifBit(false);
                            stos.add(tempPage);
                        }else{
                            temp = stos.pop();
                        }
                    }
                    for(int i = 0 ; i < frames.length ; i++)
                        if(frames[i].equals(temp))
                            frames[i] = p;
                }
                stos.add(p);
                counter++;
            }else{
                int pos = stos.conatains(p);
                stos.get(pos).setMifBit(true);
            }
            PrintPagesStatus(p, frames);
        }
        return counter;
    }


    public static int RAND(ArrayList<Page> pagesReferences, int INITIAL_FRAME_SIZE){
        Page[] frames = new Page[INITIAL_FRAME_SIZE];
        ListIterator<Page> iterator = pagesReferences.listIterator();
        int head = 0;
        Random random = new Random();
        int counter = 0;

        PrintInitialTable("RAND",INITIAL_FRAME_SIZE);

        while (iterator.hasNext()){
            Page p = iterator.next();
            if(!PageIsInFrames(p,frames)){
                if(frames[frames.length-1] == null){
                    frames[head++] = p;
                    head %= INITIAL_FRAME_SIZE;
                }else
                    frames[random.nextInt(INITIAL_FRAME_SIZE-1)+1] = p;
                counter++;
            }
            PrintPagesStatus(p,frames);
        }


        return counter;
    }

    private static boolean PageIsInFrames(Page p, Page[] frames) {
        for(int i = 0 ; i < frames.length ; i++ ){
            try {
                if (frames[i].equals(p))
                    return true;
                }catch (NullPointerException e) {
                    return false;
                }
            }
        return false;
    }

    private static int FindPosOfTheLatestPage(List<Page> pages, Page[] frames){
        ArrayList<Page> temp = new ArrayList<>();
        Iterator<Page> iterator = pages.iterator();

        temp.addAll(Arrays.asList(frames));

        while(iterator.hasNext() && temp.size()>1){
            temp.remove(iterator.next());
        }

        if(temp.size()==1) {
            for (int i = 0; i < frames.length; i++) {
                if(frames[i] == temp.get(0))
                    return i;
            }
        }
        return -1;
    }

    private static void PrintInitialTable(String name,int INITIAL_FRAME_SIZE){
        System.out.println(name + " " + INITIAL_FRAME_SIZE);
        System.out.print("Ref|");
        for(int i = 0 ; i < INITIAL_FRAME_SIZE ;i++)
            System.out.print("Fr"+ (i+1) + " | ");
        System.out.print("\n");
    }

    private static void PrintPagesStatus(Page p, Page[] frames){
        System.out.print(" "+p+"| ");
        for(int i = 0; i < frames.length; i++ ){
            if(frames[i] == null)
                System.out.print("  ");
            else
                System.out.print(frames[i]+" | ");
        }
        System.out.print("\n");
    }
}
