/**
 * @author Madhusoodan
 * 
 */
public class Card {
	int suit;
	int rank;

	/***
	 * Constructor 1. No Argument
	 */
	public Card() {
		this.suit = 0;
		this.rank = 0;
	}

	/***
	 * Constructor 2.
	 * 
	 * @param suit
	 *            - Suit of the Card
	 * @param rank
	 *            - Rank of the category of card.
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/***
	 * printCards :- This method prints cards and its status.
	 * 
	 * @param c
	 */
	public static void printCard(Card c) {
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "Jack", "Queen", "King" };

		System.out.println(ranks[c.rank] + " of " + suits[c.suit]);
	}

	/**
	 * Shallow Equality comparison.
	 * 
	 * @param card1
	 * @param card2
	 */
	public static void sameCard(Card card1, Card card2) {
		if (card1 == card2) {
			System.out.println("card1 and card2 are same object.");
		}
	}

	/***
	 * Deep Equality comparison.
	 * 
	 * @param c1
	 *            First Card to compare.
	 * @param c2
	 *            First Card to compare.
	 * @return boolean value true or false
	 */
	public static boolean sameCard1(Card c1, Card c2) {
		return (c1.suit == c2.suit && c1.rank == c2.rank);
	}

	/***
	 * Compare card Method.
	 * 
	 * @param c1
	 *            Card Object
	 * @param c2
	 *            Card Object
	 * @return integer
	 */
	public static int compareCard(Card c1, Card c2) {
		if (c1.suit > c2.suit) {
			return 1;
		}
		if (c1.suit < c2.suit) {
			return -1;
		}

		if (c1.rank > c2.rank) {
			return 1;
		}
		if (c1.rank < c2.rank) {
			return -1;
		}
		return 0;
	}

	/**
	 * Build Deck Method. Builds Deck of Cards.
	 * 
	 * @return Returns a full deck of cards.
	 */
	public static Card[] buildDeck() {
		Card[] deck = new Card[52];
		int index = 0;

		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				deck[index] = new Card(suit, rank);
				index++;
			}
		}
		return deck;
	}

	/**
	 * Prints entire deck of the cards.
	 * 
	 * @param deck
	 *            Input deck
	 */
	public static void printDeck(Card[] deck) {
		for (int i = 0; i < deck.length; i++) {
			printCard(deck[i]);
		}
	}

	/**
	 * @param deck
	 *            Input Deck of the cards
	 * @param card
	 *            The card to find.
	 * @return If card is found, returns rank of the card, else -1.
	 */
	public static int findCard(Card[] deck, Card card) {
		for (int i = 0; i < deck.length; i++) {
			if (sameCard1(deck[i], card)) {
				return i;
			}
		}
		return -1;
	}
}
