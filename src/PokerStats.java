/**
 * This class utilizes the classes Card and Deck to generate a user specified amount of
 *  five card poker hands, analyze the cards, and return statistics based upon
 *  the many results.
 *  @author Nathan Anneken
 *  @version 1.0
 */

import java.util.*;
public class PokerStats {
	// Constants to define the various hand types
	public static final int ROYAL_FLUSH = 9;
	public static final int STRAIGHT_FLUSH = 8;
	public static final int FOUR_OF_A_KIND = 7;
	public static final int FULL_HOUSE = 6;
	public static final int FLUSH = 5;
	public static final int STRAIGHT = 4;
	public static final int THREE_OF_A_KIND = 3;
	public static final int TWO_PAIR = 2;
	public static final int ONE_PAIR = 1;
	public static final int LOSER = 0;
	
	/**
	 * Deals a hand of poker, and returns an int 
	 * representing the type of hand that was dealt. 
	 * @return an int representing the kind of hand that was dealt.
	 */
	
	public static int evaluateOneHandOfPoker()
	{
		//generate and shuffle deck
		Deck deck = new Deck();
		deck.reset();
		deck.shuffle();
		//Begin generating 5 card hands
		Card firstCard = deck.deal();
		Card secondCard = deck.deal();
		Card thirdCard = deck.deal();
		Card fourthCard = deck.deal();
		Card fifthCard = deck.deal();
		//Create an array with hand card values
		Card[] hand = {firstCard, secondCard, thirdCard, fourthCard, fifthCard};
		//Checks the possible card orders from highest rank to lowest rank 
		if(hasRoyalFlush(hand))
			return ROYAL_FLUSH;
		if(hasStraightFlush(hand))
			return STRAIGHT_FLUSH;
		if(hasFourOfAKind(hand))
			return FOUR_OF_A_KIND;
		if(hasFullHouse(hand))
			return FULL_HOUSE;
		if(hasFlush(hand))
			return FLUSH;
		if(hasStraight(hand))
			return STRAIGHT;
		if(hasThreeOfAKind(hand))
			return THREE_OF_A_KIND;
		if(hasTwoPair(hand))
			return TWO_PAIR;
		if(hasOnePair(hand))
			return ONE_PAIR;
		else 
			return LOSER;
		
	} //end evaluateOneHandOfPoker
	
	/**
	 * returns whether the hand contains a flush (all 5 cards having the same suit)
	 * @param hand an array of five cards
	 * @return true if the hand contains a flush, and false otherwise
	 */
	
	public static boolean hasFlush(Card[] hand)
	{
		 int count;
	     boolean swap = true;      
	     while ( swap )
	     {
	            swap= false;    
	            for( count=0;  count < hand.length-1;  count++ )
	            {
	            	//checks to see if card suit is greater than the next card suit
	                   if ( hand[ count ].getSuit() > hand[count+1].getSuit() ) 
	                   {
	                	   	
	                        Card tempSpace = new Card(hand[ count ]);              
	                        hand[ count ] = hand[ count+1 ];
	                        hand[ count+1 ] = tempSpace;
	                        swap = true; //if a swap is made, sorting continues              
	                  } //end if 
	            } // end for
	      } //end while
	
	if(hand[0].getSuit()==hand[4].getSuit()) //checks to see if all suits are the same
		return true;
	else 
		return false;
	} //end hasFlush
	
	/**
	 * returns whether the hand contains 4 cards with the same value
	 * @param hand an array of 5 cards
	 * @return true if the hand contains 4 of a kind, and false otherwise
	 */
	
	public static boolean hasFourOfAKind(Card[] hand)
	{
		sort(hand); //sorts cards by numeric value 
		if(hand[0].getValue()==hand[3].getValue()||hand[1].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	} //end hasFourOfAKind
	
	/**
	 * returns whether the hand contains a full house 
	 * (3 of a kind in one value, and a pair of another value)
	 * @param hand an array of 5 cards
	 * @return true if the hand contains a full house, and false otherwise
	 */
	
	public static boolean hasFullHouse(Card[] hand)
	{
		sort(hand); //sorts hands by numeric value
		
		if(hand[0].getValue()==hand[1].getValue()&&
			hand[2].getValue()==hand[4].getValue())
			return true;
		if(hand[0].getValue()==hand[2].getValue()&&
			hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	} //end hasFullHouse
	
	/**
	 * returns whether the hand contains a pair of cards with the same value. 
	 * Note that a hand with 4 of a kind or a full house or 3 of a kind also contains a pair.
	 * @param hand an array of 5 cards
	 * @return true if the hand contains a pair of matching values, and false otherwise
	 */
	
	public static boolean hasOnePair(Card[] hand)
	{
		sort(hand); //sorts hand by numeric value
		if(hand[0].getValue()==hand[1].getValue()||hand[1].getValue()==hand[2].getValue()||
			hand[2].getValue()==hand[3].getValue()||hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	} //end hasOnePair
	
	/**
	 * returns whether the hand contains a royal flush (an Ace-high straight flush)
	 * @param hand an array of 5 cards
	 * @return true if the hand contains a royal flush, and false otherwise
	 */
	
	public static boolean hasRoyalFlush(Card[] hand)
	{
		boolean Flush = hasFlush(hand); //checks to see if the cards have the same suit
		sort(hand); //sorts hand by numeric value
		if((Flush) && (hand[0].getValue()==1) && (hand[1].getValue()==10))
			return true;
		else
			return false;
	} //end hasRoyalFlush
	
	/**
	 * returns whether the hand contains a straight (5 cards in sequence).
	 * @param hand an array of 5 cards
	 * @return true if the hand contains a straight, and false otherwise
	 */
	
	public static boolean hasStraight(Card[] hand)
	{
		sort(hand); //sorts hand by numeric value
		if((((hand[0].getValue()+1==hand[1].getValue())&&(hand[1].getValue()+1==hand[2].getValue())&&
			(hand[2].getValue()+1==hand[3].getValue())&&(hand[3].getValue()+1==hand[4].getValue())))
			||(((hand[0].getValue()==1) && (hand[1].getValue()==10))))
			return true;
		else
			return false;
	} //end hasStraight
	
	/**
	 * returns whether the hand contains a straight flush (both a straight and a flush)
	 * @param hand an array of 5 cards
	 * @return true if the hand contains a straight flush, and false otherwise
	 */
	
	public static boolean hasStraightFlush(Card[] hand)
	{
		boolean Flush = hasFlush(hand); //checks to see if cards have same suit
		boolean Straight = hasStraight(hand); //checks to see if cards are sequential
		if(Flush&&Straight)
			return true;
		else
			return false;
	} //end hasStraightFlush
	
	/**
	 * returns whether the hand contains 3 cards with the same value. 
	 * Note that a hand with 4 of a kind or a full house also contains 3 of a kind.
	 * @param hand an array of 5 cards
	 * @return true if the hand contains 3 of a kind, and false otherwise
	 */
	
	public static boolean hasThreeOfAKind(Card[] hand)
	{
		sort(hand); //sorts hands by card value
		if(hand[0].getValue()==hand[2].getValue()||hand[1].getValue()==hand[3].getValue()||
			hand[2].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	} //end hasThreeOfAKind
	
	/**
	 * returns whether the hand contains 2 pairs of matching values.
	 * @param hand an array of 5 cards
	 * @return true if the hand contains 2 pairs, and false otherwise
	 */
	
	public static boolean hasTwoPair(Card[] hand)
	{
		sort(hand); //sorts hand by numeric value
		if((hand[0].getValue()==hand[1].getValue()&& hand[2].getValue()==hand[3].getValue())||
			(hand[0].getValue()==hand[1].getValue()&& hand[3].getValue()==hand[4].getValue())||
			hand[2].getValue()==hand[3].getValue()&&hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	} //end hasTwoPair
	public static void main(String[] args)
	{
		long startTime = System.nanoTime(); //starts timer
		Scanner input = new Scanner(System.in);
		int[] stats = new int[10]; //array for tracking hand ranks results
		int typeOfHand=0, userInput=0, numberOfHands=0;
		System.out.print("How many poker hands should I deal? ");
		userInput = input.nextInt();
		while(numberOfHands<userInput)
		{
			typeOfHand = evaluateOneHandOfPoker(); //Determines hand rank
			stats[typeOfHand]++;
			numberOfHands=numberOfHands+1;
		} //end while
		showStats(stats); //prints hand rank stats
		long endTime = System.nanoTime(); //ends time
		long duration = endTime - startTime;
		//Prints time
		System.out.println(userInput+" analized in "+(duration/1000000000.0)+" seconds.");
	} //end main
	
	/**
	 * Prints a String representation of a given hand
	 */
	
	public static void printHand(Card[] hand)
	{
		for(int temp=0; temp<5; temp++)
			System.out.println(hand[temp]);
	} //end printHand
	
	/**
	 * Prints statistics from multiple trials of evaluated poker hands.
	 * @param stats the pokerhand data, with frequency data ordered as follows: 
	 * losing hands, one pair, two pair, three of a kind, straight, 
	 * flush, full house, four of a kind, straight flush, royal flush.
	 */
	
	public static void showStats(int[] stats)
	{
		int total=0, arrayNumber;
		for(arrayNumber=0; arrayNumber<stats.length-1; arrayNumber++)
			total = total + stats[arrayNumber];
		double percentL = ((double)stats[0]/(double)total)*100;
		double percentO =((double)stats[1]/(double)total)*100;
		double percentT =((double)stats[2]/(double)total)*100;
		double percentTh =((double)stats[3]/(double)total)*100;
		double percentS =((double)stats[4]/(double)total)*100;
		double percentF =((double)stats[5]/(double)total)*100;
		double percentFull =((double)stats[6]/(double)total)*100;
		double percentFour =((double)stats[7]/(double)total)*100;
		double percentStraightF =((double)stats[8]/(double)total)*100;
		double percentR =((double)stats[9]/(double)total)*100;
		System.out.printf("%16s:%8d %10.5f%%%n", "Loser", stats[0], percentL);
		System.out.printf("%16s:%8d %10.5f%%%n", "One Pair", stats[1], percentO);
		System.out.printf("%16s:%8d %10.5f%%%n", "Two Pair", stats[2], percentT);
		System.out.printf("%16s:%8d %10.5f%%%n", "Three of a Kind", stats[3], percentTh);
		System.out.printf("%16s:%8d %10.5f%%%n", "Straight", stats[4], percentS);
		System.out.printf("%16s:%8d %10.5f%%%n", "Flush", stats[5], percentF);
		System.out.printf("%16s:%8d %10.5f%%%n", "Full House", stats[6], percentFull);
		System.out.printf("%16s:%8d %10.5f%%%n", "Four of a Kind", stats[7], percentFour);
		System.out.printf("%16s:%8d %10.5f%%%n", "Straight Flush", stats[8], percentStraightF);
		System.out.printf("%16s:%8d %10.5f%%%n", "Royal Flush", stats[9], percentR);
		System.out.println("----------------------------------------------");
		
	} //end showStats
	
	/**
	 * Sorts the cards by value, completely ignoring suits.
	 * @param hand an array of cards to be sorted
	 */
	
	public static void sort(Card[] hand)
	{
		int count;
	     boolean swap = true;      
	  

	     while ( swap )
	     {
	            swap= false;    
	            for( count=0;  count < hand.length-1;  count++ )
	            {
	                   if ( hand[ count ].getValue() > hand[count+1].getValue() )   
	                   {
	                	   	
	                        Card tempSpace = new Card(hand[ count ]);              
	                        hand[ count ] = hand[ count+1 ];
	                        hand[ count+1 ] = tempSpace;
	                        swap = true;               
	                  } //end if
	            } //end for
	      } //end while
			
	} //end sort
	
} //end PokerStats

