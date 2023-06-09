package Homework4;

import java.util.Random;

public class RedBlackTreeWork {
    private static Random random = new Random();
    public static void main(String[] args) {

        RedBlackTree<Integer> redblacktree;
        int number;
        int testAmount;

        for(int i = 0; i < 5; i++) {
            try {
                System.out.println("\n\nStart test #" + i);
                redblacktree = new RedBlackTree<Integer>();

                testAmount = random.nextInt(10 - 1) + 1;

                System.out.println(" Insertion [" + testAmount + "]:");
                for(int j = 0; j < testAmount; j++) {
                    number = random.nextInt(15);
                    System.out.println("  Insert " + number + " into tree");
                    redblacktree.add(number);
                }
            }
            catch(Exception e) {
                System.out.println("Got error: " + e.getMessage());
            }
        }
        System.out.println("\nRBT testing is over!\n\n");

    }
}