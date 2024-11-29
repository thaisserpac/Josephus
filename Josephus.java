//Josephus.java
//Serpa Chaves:Thais:u34
//Submission 05
//Solving the Josephus Problem

/*
 * Program works as expected
 */

/*
 * The driver class for the Josephus problem
 */

public class Josephus {

    public static void main(String[] args) {
        // If no arguments are provided, display the opening screen and
        // description
        if (args.length == 0) {
            OpeningScreen openingScreen = new OpeningScreen(
                    "Serpa Chaves:Thais:A00462622:u34",
                    "Submission 05",
                    "Solving the Josephus Problem");
            openingScreen.display();

            // Display program description
            TextItems textItem = new TextItems(
                    Josephus.class.getResourceAsStream("Josephus.txt"));
            textItem.displayItem("ProgramDescription");
            return;
        }
        // Variables
        int numberOfZealots;
        int eliminationGap;
        int seed = 0;

        // If 2 or 3 arguments are provided solve the problem
        if (args.length == 2 || args.length == 3) {
            numberOfZealots = Integer.parseInt(args[0]);
            eliminationGap = Integer.parseInt(args[1]);
            if (args.length == 3) {
                seed = Integer.parseInt(args[2]);
            }

            ZealotCircle circle = new ZealotCircle(numberOfZealots, eliminationGap, seed);

            circle.displayAllZealots();

            circle.eliminateZealots();

            circle.adviseJosephus();
        }
    }
}
