/*
 * This is a class that tests to make sure PokerStats.java has all the required methods.
 * IF THIS CLASS DOES NOT COMPILE AND RUN WITH YOUR PokerStats.java, THEN YOUR SCORE ON
 * THE ASSIGNMENT WILL BE ZERO.  Please don't underestimate the importance of following specifications.
 * 
 * DON'T CHANGE THIS FILE.
 */
public class PokerStatsTester {

	public static void main(String[] args) {
	
		int i = PokerStats.evaluateOneHandOfPoker();
		Card[] cards = { new Card(Card.ACE, Card.CLUBS),
				new Card(Card.ACE, Card.HEARTS),
				new Card(Card.KING, Card.CLUBS),
				new Card(Card.ACE, Card.SPADES),
				new Card(Card.ACE, Card.DIAMONDS), };

		PokerStats.sort(cards);
		PokerStats.printHand(cards);

		boolean b;
		b = PokerStats.hasFlush(cards);
		b = PokerStats.hasFourOfAKind(cards);
		b = PokerStats.hasFullHouse(cards);
		b = PokerStats.hasOnePair(cards);
		b = PokerStats.hasRoyalFlush(cards);
		b = PokerStats.hasStraight(cards);
		b = PokerStats.hasStraightFlush(cards);
		b = PokerStats.hasThreeOfAKind(cards);
		b = PokerStats.hasTwoPair(cards);

		PokerStats.showStats(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		System.out.println("If you see this message, your program"
				+ " has all the required methods.");
		System.out.println("Note that this doesn't test that your"
				+ " methods do the right thing...only that the methods exist.");

	}

}
