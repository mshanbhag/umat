package com.ashlar;


/**
 * Class describing behaviour of the dog.
 * 
 * @author Madhusoodan
 * 
 */
public class Dog {
    int size;
    String name;

    /**
     * Bark with no arguments
     */
    void bark() {
        if (size > 60) {
            System.out.println("Woff! Woff !");
        }
        if (size > 14) {
            System.out.println("Ruff! Ruff!");
        }
        if (size < 14) {
            System.out.println("Yip! Yip!");
        }
    }

    /**
     * How many times to bark.
     * 
     * @param i
     *            :- Times to bark
     */

    void bark(int i) {
        while (i > 0) {
            if (size > 60) {
                System.out.println("Woff! Woff !");
            }
            if (size > 14) {
                System.out.println("Ruff! Ruff!");
            }
            if (size < 14) {
                System.out.println("Yip! Yip!");
            }
            i = i - 1;
        }
    }
}
