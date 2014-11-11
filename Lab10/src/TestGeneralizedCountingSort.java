import java.util.Arrays;
import java.util.Random;

public class TestGeneralizedCountingSort {

	public static void main(String[] args) throws CardException {
		//Creating smaller array of random cards
		NewCard[] cardsToSort = new NewCard[10];

		for (int i = 0; i < 10 ; i++){
			cardsToSort[i] = randomCard();
		}

		CountingSorter.countingSort(cardsToSort);
		//After sorting, prints cards in order
		
		for (NewCard card : cardsToSort){
			System.out.println(card);
		}

		//Makes larger array of random cards
		NewCard[] largerCardsToSort = new NewCard[100000];
		
		for (int i = 0; i < 100000 ; i++){
			largerCardsToSort[i] = randomCard();
		}
		//Created a clone or the larger array
		NewCard[] largerCardsToSort2 = largerCardsToSort.clone();
		CountingSorter.countingSort(largerCardsToSort);
		//Used Java's built in sort to compare our sort to the built in sort
		Arrays.sort(largerCardsToSort2);
		System.out.println(Arrays.equals(largerCardsToSort2, largerCardsToSort));
	}

	static NewCard randomCard() throws CardException{
		Random rand = new Random();

		int suit = rand.nextInt(4);
		String suitToReturn = "";

		if (suit == 0) {
			suitToReturn = "Hearts";
		} else if (suit == 1) {
			suitToReturn = "Spades";
		} else if (suit == 2) {
			suitToReturn = "Diamonds";
		} else if (suit == 3) {
			suitToReturn = "Clubs";
		}

		int value = rand.nextInt(13) + 2;
		
		String cardNumber = "";
		
		if(value == 14){
			cardNumber = "A";
		}else if(value == 13){
			cardNumber = "K";
		}else if(value == 12){
			cardNumber = "Q";
		}else if(value == 11){
			cardNumber = "J";
		}else{
		cardNumber =  ""+value+"";
		}
		
		return new NewCard(suitToReturn, cardNumber);
	}
}