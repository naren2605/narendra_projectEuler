package dev.euler.prob54;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import dev.Utils;

import edu.naren.Sorting;

public class PokerHands {
	
	
	public static enum CardValue {
		ACE(12,"A"),TWO(0,"2"),THREE(1,"3"),FOUR(2,"4"),FIVE(3,"5"),SIX(4,"6"),SEVEN(5,"7"),EIGHT(6,"8"),NINE(7,"9"),TEN(8,"T"),JACK(9,"J"),QUEEN(10,"Q"),KING(11,"K"),INVALID(-1);
		final private Integer valueOfCard;
		public static final List<CardValue> list=new ArrayList<CardValue>();
		final private String string;
		private CardValue(Integer valueOfCard) {
			this.string=""+valueOfCard;
			this.valueOfCard=valueOfCard;
		}
        private CardValue(Integer valueOfCard,String string) {
			this.string=string;
			this.valueOfCard=valueOfCard;
		}

	public static int compare(CardValue card1,CardValue card2) {
		if(card1.valueOfCard>=card2.valueOfCard){
			return 1;
		}
		else{
			return -1;
		}
		
		
	}
	public int comp(CardValue card){
		return compare(this, card);
	}
	
	private static CardValue getCardValue(String s) {
		CardValue c=INVALID;
		if(s.equals("14")||s.equals("A")){
			c=ACE;
		}else if(s.equals("2")){
			c=TWO;
		}else if(s.equals("3")){
			c=THREE;
		}else if(s.equals("4")){
			c=FOUR;
		}else if(s.equals("5")){
			c=FIVE;
		}else if(s.equals("6")){
			c=SIX;
		}else if(s.equals("7")){
			c=SEVEN;
		}else if(s.equals("8")){
			c=EIGHT;
		}else if(s.equals("9")){
			c=NINE;
		}else if(s.equals("10")||s.equals("T")){
			c=TEN;
		}else if(s.equals("11")||s.equals("J")){
			c=JACK;
		}else if(s.equals("12")||s.equals("Q")){
			c=QUEEN;
		}else if(s.equals("13")||s.equals("K")){
			c=KING;
		}

		
		return c;
	}
	}
	public static enum CardType{
		
		CLUB("C",0),
		SPADE("S",1),
		HEARTS("H",2),
		DIAMONDS("D",3),
		INVALID("I",4);
		public final String string;
		public final Integer value;
		private CardType(String s,Integer val) {
			this.value=val;
			this.string=s;
		}
		private static CardType getCardType(String s) {
			CardType c=INVALID;
			if(s.equals("C")){
				c=CLUB;
			}
			else if(s.equals("S")){
				c=SPADE;
			}
			else if(s.equals("H")){
				c=HEARTS;
			}
			else if(s.equals("D")){
	           c=DIAMONDS;
            }
			
			return  c;

		}
		private static CardType getCardType(Integer i) {
			CardType c=INVALID;
			if(i==0){
				c=CLUB;
			}
			else if(i==1){
				c=SPADE;
			}
			else if(i==2){
				c=HEARTS;
			}
			else if(i==3){
	           c=DIAMONDS;
            }
			
			return  c;

		}
	}
	
	public static class Card{
		final CardType cardtype;
		final CardValue value;
		public Card(String s) {
			this.cardtype=CardType.getCardType(s.substring(1));
			this.value=CardValue.getCardValue(s.substring(0,1));
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.value.string+this.cardtype.string;
		}
	}
	
	public static enum Hand{
		/**
		 * Highest value card.
		 */
		HIGH_CARD(0),
		/**
		 * Two cards of the same value.
		 */
		ONE_PAIR(1),
		/**
		 * Two different pairs
		 */
		TWO_PAIRS(2),
		/**
		 * Three cards of the same value
		 */
		THREE_OF_A_KIND(3),
		/**
		 * All cards are consecutive values
		 */
		STRAIGHT(4),
		/**
		 * All cards of the same suit
		 */
		FLUSH(5),
		/**
		 * Three of a kind and a pair
		 */
		FULL_HOUSE(6),
		/**
		 * Four cards of the same value
		 */
		FOUR_OF_A_KIND(7),
		/**
		 * All cards are consecutive values of same suit
		 */
		STRAIGHT_FLUSH(8),
		/**
		 * Ten, Jack, Queen, King, Ace, in same suit
		 */
		ROYAL_FLUSH(9),
		/**
		 * INVALID HAND
		 */
		INVALID_HAND(-1);
		;
		final Integer priority;
		private Hand(Integer value) {
			this.priority=value;
		}
		
	}
	
	public static class Game{
		List<Card> cards = new ArrayList<PokerHands.Card>();
		public final Hand hand;
		public static final Integer royalflush=CardValue.JACK.valueOfCard+CardValue.TEN.valueOfCard+CardValue.QUEEN.valueOfCard+CardValue.KING.valueOfCard+CardValue.ACE.valueOfCard;
		public Game(String game) {
			String str[]=game.split(" ");
			for(String st:str){
				cards.add(new Card(st));
			}
			hand=this.finalizeHand();
			
		}
		
		
		public Hand finalizeHand(){
		
			int totalCardValue=0;
			int consecutives=1;
			int[] cardtypes=new int[4];
			int[] values=new int[13];
			Collections.sort(cards, new Comparator<Card>() {
				public int compare(Card o1, Card o2) {
					return CardValue.compare(o1.value, o2.value);
				}
			});
			//System.err.println(cards);
			int size=cards.size();
			boolean isFourOfKind=false;
			boolean isThree=false;
			boolean isPair=false;
			boolean isTwoPair=false;
			int pairCard = -1;
			for(int i=0;i<size;i++){
				Card card=cards.get(i);
				cardtypes[card.cardtype.value]=cardtypes[card.cardtype.value]+1;
				values[card.value.valueOfCard]=values[card.value.valueOfCard]+1;
				totalCardValue=totalCardValue+card.value.valueOfCard;
				if(values[card.value.valueOfCard]>=4){
					isFourOfKind=true;
				}
				if(values[card.value.valueOfCard]==3){
					isThree=true;
				}
				if(values[card.value.valueOfCard]==2){
					isPair=true;
					if(pairCard==-1){
						pairCard=card.value.valueOfCard;	
					}
					if(pairCard!=card.value.valueOfCard){
						isTwoPair=true;
					}
				}
				
                
				if(i<size-1&&consecutives==1){
					consecutives=consecutives*(cards.get(i+1).value.valueOfCard-card.value.valueOfCard);
				}
				
				//System.out.println(card);
				
			}
			
			for(int type:cardtypes){
				
				if(type==5&&totalCardValue==royalflush){
					return Hand.ROYAL_FLUSH;
				}
				if(type==5&&consecutives==1){
					return Hand.STRAIGHT_FLUSH;
				}
			}
			if(isFourOfKind){
				return Hand.FOUR_OF_A_KIND;
			}
			if(isThree){
				for(int i:values){
					if(i==2){
					return Hand.FULL_HOUSE;	
					}
				}
			}
			for(int i:cardtypes){
				if(i==5){
					return Hand.FLUSH;
				}
			}
			
			if(consecutives==1){
				return Hand.STRAIGHT;
				
			}
			if(isThree){
				return Hand.THREE_OF_A_KIND;
			}
			if(isTwoPair){
				return Hand.TWO_PAIRS;
			}
			if(isPair){
				return Hand.ONE_PAIR;
			}
			else{
				return Hand.HIGH_CARD;
			}
			
		}
		
		
		
		@Override
		public String toString() {
			System.out.println("HAND : "+hand);
			return cards.toString();
		}
	}

	
	public static  boolean willPlayer1win(Game g1,Game g2){
		if(g1.hand.priority>g2.hand.priority){
			System.out.println("player 1 : "+g1.cards+":"+g2.cards+" "+g1.hand);
			return true;
		}
		else if(g1.hand.priority==g2.hand.priority){
			int[] p1values=new int[13];
			int[] p2values=new int[13];

			int p1s=0;
			int p2s=0;
			for(int i=0;i<5;i++){
				p1values[g1.cards.get(i).value.valueOfCard]=p1values[g1.cards.get(i).value.valueOfCard]+1;
				p2values[g2.cards.get(i).value.valueOfCard]=p1values[g2.cards.get(i).value.valueOfCard]+1;
			}
			for(int i=0;i<13;i++){
				
			}
			switch(g1.hand){
			case ROYAL_FLUSH:
				break;
			case STRAIGHT_FLUSH:
				break;
			case FOUR_OF_A_KIND:

				break;
			case FULL_HOUSE:
				break;
			case FLUSH:
				break;
			case STRAIGHT:
				break;
			case THREE_OF_A_KIND:
				break;
			case TWO_PAIRS:
				break;
			case ONE_PAIR:
				break;
			case HIGH_CARD:
				break;
			}
			
			
			
			for(int i=4;i>=0;i--){
				if(g1.cards.get(i).value.valueOfCard>g2.cards.get(i).value.valueOfCard){
					System.out.println("player 1 : "+g1.cards+":"+g2.cards+" "+g1.hand+" HIGHESTT");
					return true;
				}	
				else if(g1.cards.get(i).value.valueOfCard<g2.cards.get(i).value.valueOfCard){
					System.out.println("player 2 : "+g1.cards+":"+g2.cards+" "+g2.hand+" HIGHESTT");
					return false;
				}
				else{
					continue;
				}
			}
			
			return false;
		}
		else{
			System.out.println("player 2 : "+g1.cards+":"+g2.cards+" "+g2.hand);
			return false;
		}
	}
	
	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Game g1=new Game("4D 6S 9H QH QC");
Game g2=new Game("3D 6D 7H QD QS");
String pokerdata=Utils.getStringDataFromFileWithNewLine(new File("p054_poker.txt"));
String[] entries=pokerdata.split("\\n");
System.out.println();
int wins=0;
System.out.println(new Date());
for(String data:entries){
	if(willPlayer1win(new Game(data.substring(0,15).trim()),new Game(data.substring(15).trim()))){
		wins++;
	}	
}
System.out.println(wins);
System.out.println(new Date());
//System.out.println(willPlayer1win(g1, g2));


	}
	
	
	

}
