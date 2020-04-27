package ReplacementAlgorithm;

import java.util.ArrayList;
import java.util.Random;

import static ReplacementAlgorithm.Algorithm.*;

public class Simulation {

    final int INITIAL_FRAME_SIZE;
    ArrayList<Page> pages;

    public Simulation(int INITIAL_FRAME_SIZE, int numberOfPages) {
        this.INITIAL_FRAME_SIZE = INITIAL_FRAME_SIZE;
        pages = new ArrayList<>();
        CreateRandomPages(numberOfPages);
        System.out.println(pages);
    }

    public void RunAlgorithms(){
        FIFO(pages, INITIAL_FRAME_SIZE);
        OPT(pages,INITIAL_FRAME_SIZE);
        LRU(pages,INITIAL_FRAME_SIZE);
        aLRU(pages,INITIAL_FRAME_SIZE);
    }

    private void CreateRandomPages(int numberOfPages){
        Random r = new Random();
        for (int i = 0 ; i < numberOfPages; i++)
            pages.add(new Page(r.nextInt((int) (numberOfPages/1.5))+1,true,0));
    }
}
