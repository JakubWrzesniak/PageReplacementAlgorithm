package ReplacementAlgorithm;

import java.util.*;

import static ReplacementAlgorithm.Algorithm.*;

public class Simulation {

    Integer[] INITIAL_FRAME_SIZE;
    ArrayList<Page> pages;
    HashMap<String, Integer> pageLacks;

    public Simulation(Integer[] INITIAL_FRAME_SIZE, int numberOfPages,int range) {
        this.INITIAL_FRAME_SIZE = INITIAL_FRAME_SIZE;
        pages = new ArrayList<>();
        pageLacks = new HashMap<>();
        CreateRandomPages(numberOfPages,range);
        System.out.println(pages);
    }

    public void RunAlgorithms() {
        for(Integer i : INITIAL_FRAME_SIZE) {
            pageLacks.put("FIFO "+ i, FIFO(pages, i));
            pageLacks.put("OPT " + i, OPT(pages, i));
            pageLacks.put("LRU " + i, LRU(pages, i));
            pageLacks.put("aLRU " + i, aLRU(pages, i));
            pageLacks.put("RAND " + i, RAND(pages, i));
        }
    }

    public void showResults(){
        ArrayList<String> list = new ArrayList<>();
        Set entrySet = pageLacks.entrySet();
        Iterator iterator = entrySet.iterator();
        System.out.println("Results : ");

        while (iterator.hasNext()){
            Map.Entry me = (Map.Entry) iterator.next();
            list.add(me.getKey()+ " : " + me.getValue());
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }

    private void CreateRandomPages(int numberOfPages, int range){
        Random r = new Random();
        for (int i = 0 ; i < numberOfPages; i++)
            pages.add(new Page(r.nextInt(range)+1,true,0));
    }
}
