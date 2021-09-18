/*
 * Copyright (c) 2017. Phasmid Software
 */

package Assignment1.Assignment1;
import java.util.Random;


public class RandomWalk {

    int x = 0;
    int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // TO BE IMPLEMENTED
    	x += dx;
    	y += dy;
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private  void randomWalk(int m) {
        // TO BE IMPLEMENTED
    	if(m<=0) {
    		return;
    	}
    	for(int i=0;i<m;i++) {
    		randomMove();
    	}
    }

    /**
     * Private method to generate a random move according to the rules of the
     * situation. That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the
     * drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        return Math.sqrt(x*x+y*y);
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance / n;
    }

    public static void main(String[] args) {
    	//Generate Graph to show the relationship between steps and distance
    	for(int i=0;i<1000;i++) {
    		RandomWalk rw = new RandomWalk();
    		rw.randomWalk(i);
    		//System.out.println(i);
    		System.out.println(rw.distance());
    	}
    	//Generate the main distance when input steps and experiment times
    	System.out.println("We walked 25 steps in 60 experiments and the mean distance is  "+randomWalkMulti(25,100));
    	System.out.println("We walked 100 steps in 60 experiments and the mean distance is  "+randomWalkMulti(100,100));
    	System.out.println("We walked 1600 steps in 60 experiments and the mean distance is  "+randomWalkMulti(1600,100));
    	System.out.println("We walked 160000 steps in 60 experiments and the mean distance is  "+randomWalkMulti(160000,100));
    	System.out.println("We walked 250000 steps in 60 experiments and the mean distance is  "+randomWalkMulti(250000,100));
    	System.out.println("We walked 1000000 steps in 60 experiments and the mean distance is  "+randomWalkMulti(1000000,100));

    	
    }

}
