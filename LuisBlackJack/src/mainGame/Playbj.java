package mainGame;
//This part of code makes sure that the rules are set for blackjack and the values of the cards 
import java.util.ArrayList;


public class Playbj	{

	private boolean bust=false;
	private int CardTotal=0; //Everyone at the beginning starts with a Value of 0 until they receive cards

	private ArrayList<String> Cards; //All my cards values stored 
	private ArrayList<String> Aces;


	public Playbj(String c1, String c2) {
		Cards = new ArrayList();
		Aces = new ArrayList();

		if (c1 == "Ace") {
			Aces.add(c1);
		}
		else{
			Cards.add(c1);
		}

		if (c2 == "Ace") {
			Aces.add(c2);
		}
		else {
			Cards.add(c2);
		}

		SetTotal();

	}//end Constructor


public int GetCardTotal() {
	return CardTotal;
}

public void CardHit(String ca){

	if (ca == "Ace") {
		Aces.add("Ace");
	}
	else{
		Cards.add(ca);
	}

	if(Aces.size() != 0){
		SetTotal();
	}
    //If the player gets one of these cards they get a 10+ added on
	else if (ca == "Jack" || ca =="Queen" || ca =="King"){

		CardTotal += 10;
	}

	else {
		CardTotal += Integer.parseInt(ca);
	}


	CheckBust();


}

//The values of the higher cards like Jack, Queen and King
private void SetTotal() {

	CardTotal = 0;
	for(String c : Cards){
		if (c == "Jack" || c =="Queen" || c =="King"){
			CardTotal += 10;
		}

		else{
			CardTotal += Integer.parseInt(c);
		}

	}

	for(String a : Aces){
		if (CardTotal <= 10){
			CardTotal += 11;
		}
		else { 
			CardTotal += 1;
		}

	}
}//end ace total

//This code makes sure that if the player has a value higher than 21 then they lose
public boolean CheckBust(){
	if(CardTotal > 21){
		bust = true;
	}

	else {
		bust = false;
	}

	return bust;
}





}