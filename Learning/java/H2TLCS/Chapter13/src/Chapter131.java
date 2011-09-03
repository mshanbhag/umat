/***
 * Main Method.
 */
public class Chapter131 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        /***
         * Object Declaration.
         */
        Card card = new Card(1, 11);

        Card.printCard(card);

        /***
         * same card methods called as "shallow equality".
         */
        Card card1 = new Card(1, 11);
        Card card2 = new Card(1, 11);

        if (Card.sameCard1(card1, card2)) {
            System.out.println("card1 and card2 are same object.");
        }
        Card[] deck = new Card[52];
        int index = 0;

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck[index] = new Card(suit, rank);
                index++;
            }
        }
        System.out.println(deck[2].rank);
    }
}
