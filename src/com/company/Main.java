package com.company;

import ReplacementAlgorithm.Simulation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer[] INITIAL_FRAME_SIZE;
        int numberOfPages;
        int range;
        int numberOfFrames;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dla ilu wartosci ramek ma być wykonana symulacja");
        numberOfFrames = scanner.nextInt();
        INITIAL_FRAME_SIZE = new Integer[numberOfFrames];
        for(int i = 0 ; i < numberOfFrames ; i++){
            System.out.println("Podaj ilość ramek : ");
            INITIAL_FRAME_SIZE[i] = scanner.nextInt();
        }
        System.out.println("Podaj ilość stron : ");
        numberOfPages = scanner.nextInt();
        System.out.println("Podaj zakres stron : ");
        range = scanner.nextInt();

        Simulation simulation = new Simulation(INITIAL_FRAME_SIZE,numberOfPages,range);
        simulation.RunAlgorithms();
        simulation.showResults();
    }
}