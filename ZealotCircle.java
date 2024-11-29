//ZealotCircle.java
//Serpa Chaves:Thais:A00462622:u34
//Submission 05
//Solving the Josephus Problem

/*
 * Program works as expected
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
 * A class for creating a "circle of zealots" in which every nth zealot is
 * eliminated until only one remains (and survives), and advising a particular
 * member of that circle (Josephus, or "Joe") which position he should occupy
 * to avoid elimination.
 */
public class ZealotCircle
{
    private static final String[] ZEALOT_NAMES =
    {
        "Ace", "Ada", "Ali", "Amy", "Ann", "Art", "Ava", "Bea", "Ben", "Bob",
        "Boz", "Cal", "Cam", "Dag", "Dan", "Deb", "Don", "Dot", "Eva", "Eve",
        "Fay", "Gil", "Guy", "Hal", "Ian", "Jan", "Jim", "Joe", "Kay", "Ken",
        "Kim", "Liz", "Mac", "Nan", "Ora", "Pam", "Red", "Rex", "Rik", "Rip",
        "Rob", "Rod", "Ron", "Roy", "Sam", "Tim", "Tom", "Uma", "Val", "Wes"
    };

    private Node head;
    private int size;
    private int eliminationGap;

    /*
     * A simple Node class containing String data for a name.
     */
    private class Node
    {
        String name;
        Node next;

        public Node(String name)
        {
            this.name = name;
        }
    }

    /*
     * Constructor to create a circle of zealots whose names have been chosen
     * from a collection of 50 3-character first names.
     *
     * @param numberOfZealots The number of zealots in the circle.
     * @param eliminationGap The gap between zealots to be eliminated.
     * @param seed The seed to initialize the random generator.
     */
    public ZealotCircle(int numberOfZealots, int eliminationGap, int seed)
    {
        this.eliminationGap = eliminationGap;

        // Shuffle names
        List<String> shuffledNames =
            new ArrayList<>(Arrays.asList(ZEALOT_NAMES));
        Collections.shuffle(shuffledNames, new Random(seed));

        head = new Node(shuffledNames.get(numberOfZealots - 1));

        // Create circular linked list
        head = new Node(shuffledNames.get(0));
        Node current = head;
        for (int i = 1; i < numberOfZealots; i++)
        {
            current.next = new Node(shuffledNames.get(i));
            current = current.next;
        }
        current.next = head; // Complete the circle
        size = numberOfZealots;
    }

    /*
     * Displays the names of all current zealots in their current order,
     * 15 per line.
     */
    public void displayAllZealots()
    {
        System.out.println("\nHere is the full \"circle of zealots\", "
                           + " including our friend Joe:");
        Node current = head;
        int count = 0;
        do
        {
            System.out.print(current.name + " ");
            current = current.next;
            count++;
            if (count % 15 == 0)
            {
                System.out.println();
            }
        }
        while (current != head);
        System.out.println();
    }

    /*
     * Eliminates all but the last zealot, which is thus the one in the
     * position that Josephus (Joe) should be occupying when the process
     * starts, and advises Josephus accordingly.
     */
    public void eliminateZealots()
    {
        System.out.println("\nThe elimination gap is " + eliminationGap +
                           " and now we start the elimination:");
        System.out.println("");
        Node previous = head;
        while (previous.next != head)
        {
            previous = previous.next;
        }

        while (size > 1)
        {
            for (int i = 1; i < eliminationGap; i++)
            {
                previous = previous.next;
            }
            Node victim = previous.next;
            System.out.println("The current victim is " + victim.name +
                               " and here are the remaining zealots:");
            previous.next = victim.next;
            if (victim == head)
            {
                head = victim.next;
            }
            size--;

            // Print remaining zealots
            Node current = head;
            int count = 0;
            do
            {
                System.out.print(current.name + " ");
                current = current.next;
                count++;
                if (count % 15 == 0)
                {
                    System.out.println();
                }
            }
            while (current != head);
            System.out.println();
            Utils.pause();
        }
    }

    /*
     * Advises Josephus (Joe) with whom to switch, or to stay where he is.
     */
    public void adviseJosephus()
    {
        if (head.name.equals("Joe"))
        {
            System.out.println("Tell our ol' buddy Joe to stay put.");
        }
        else
        {
            System.out.println("Tell Joe he'd better exchange positions with "
                               + head.name + ".");
        }
        Utils.pause();
    }
}
