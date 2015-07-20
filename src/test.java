
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Deck deck = new Deck();
		int count1=0, count2=0,count3=0, count4=0, count5=0, count6=0, count7=0, count8=0, count9=0;
		for(int a=0; a<1; a++)
		{
		deck.reset();
		deck.shuffle();
		Card firstCard = deck.deal();
		Card secondCard = deck.deal();
		Card thirdCard = deck.deal();
		Card fourthCard = deck.deal();
		Card fifthCard = deck.deal();
		Card[] hand = {firstCard, secondCard, thirdCard, fourthCard, fifthCard};
		boolean f = hasFlush(hand);
		boolean g = hasFourOfAKind(hand);
		boolean h = hasFullHouse(hand);
		boolean i = hasOnePair(hand);
		boolean j = hasRoyalFlush(hand);
		boolean k = hasStraight(hand);
		boolean l = hasStraightFlush(hand);
		boolean m = hasThreeOfAKind(hand);
		boolean n = hasTwoPair(hand);
		if(f)
			count1=count1+1;
		if(g)
			count2=count2+1;
		if(h)
			count3=count3+1;
		if(i)
			count4=count4+1;
		if(j)
			count5=count5+1;
		if(k)
			count6=count6+1;
		if(l)
			count7=count7+1;
		if(m)
			count8=count8+1;
		if(n)
			count9=count9+1;
		}
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
		System.out.println(count6);
		System.out.println(count7);
		System.out.println(count8);
		System.out.println(count9);
	}
	public static boolean hasFlush(Card[] hand)
	{
		   int count;
		     boolean swap = true;      
		  

		     while ( swap )
		     {
		            swap= false;    
		            for( count=0;  count < hand.length-1;  count++ )
		            {
		                   if ( hand[ count ].getSuit() > hand[count+1].getSuit() )   
		                   {
		                	   	
		                        Card tempSpace = new Card(hand[ count ]);              
		                        hand[ count ] = hand[ count+1 ];
		                        hand[ count+1 ] = tempSpace;
		                        swap = true;               
		                  } 
		            } 
		      }
		
		if(hand[0].getSuit()==hand[4].getSuit())
			return true;
		else 
			return false;
	
	}
	public static boolean hasFourOfAKind(Card[] hand)
	{
		BubbleSort(hand);
		if(hand[0].getValue()==hand[3].getValue()||hand[1].getValue()==hand[4].getValue())
			return true;
		else
			return false;
			}
	public static boolean hasFullHouse(Card[] hand)
	{
		
		BubbleSort(hand);
		
		if(hand[0].getValue()==hand[1].getValue()&&hand[2].getValue()==hand[4].getValue())
			return true;
		if(hand[0].getValue()==hand[2].getValue()&&hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	}
	public static boolean hasOnePair(Card[] hand)
	{
		
		BubbleSort(hand);
		if(hand[0].getValue()==hand[1].getValue()||hand[1].getValue()==hand[2].getValue()||
			hand[2].getValue()==hand[3].getValue()||hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	}
	public static boolean hasRoyalFlush(Card[] hand)
	{
		boolean f = hasFlush(hand);
	
			if((f) && (hand[0].getValue()==1) && (hand[1].getValue()==10))
				return true;
			else
				return false;
	}
	public static boolean hasStraight(Card[] hand)
	{
		BubbleSort(hand);
		if((hand[0].getValue()+1==hand[1].getValue()&&hand[1].getValue()+1==hand[2].getValue()&&
			hand[2].getValue()+1==hand[3].getValue()&&hand[3].getValue()+1==hand[4].getValue())
			||(hand[0].getValue()==1 && hand[1].getValue()==10))
			return true;
		else
			return false;
	}
	public static boolean hasStraightFlush(Card[] hand)
	{
		boolean Flush = hasFlush(hand);
		boolean Straight = hasStraight(hand);
		if(Flush&&Straight)
			return true;
		else
			return false;
	}
	public static boolean hasThreeOfAKind(Card[] hand)
	{
		BubbleSort(hand);
		if(hand[0].getValue()==hand[2].getValue()||hand[1].getValue()==hand[3].getValue()||
			hand[2].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	}
	public static boolean hasTwoPair(Card[] hand)
	{
		BubbleSort(hand);
		if((hand[0].getValue()==hand[1].getValue()&& hand[2].getValue()==hand[3].getValue())||
			(hand[0].getValue()==hand[1].getValue()&& hand[3].getValue()==hand[4].getValue())||
			hand[2].getValue()==hand[3].getValue()&&hand[3].getValue()==hand[4].getValue())
			return true;
		else
			return false;
	}
	public static void BubbleSort( Card [ ] hand )
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
	                  } 
	            } 
	      }
	    
	}
	} 



