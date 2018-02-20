package memory;

import javax.swing.JButton; // karta b�dzie przyciskiem

@SuppressWarnings("serial")

public class Card extends JButton {
	
	private int number; // numer karty 
    private boolean matchingCard; // czy znaleziono drug� tak� sam� kart�

    public Card (int number) {
    	this.number = number; // przypisujemy karcie numer
    	this.matchingCard = false; // na pocz�tku ustawiamy, �e nie znaleziono
    }
    
    
    public void setMatchingCard(boolean matchingCard) {
        this.matchingCard = matchingCard; // ustawianie czy znaleziono kart�; w tej grze przestawianie na true, �e j� znaleziono
    }

    /*public void setNumber(int number) {
    	this.number = number; // ustawianie numeru; w tej grze raczej nie potrzebne
	}*/
    
    public boolean getMatchingCard() {
        return this.matchingCard; // pobieranie czy znaleniono drug� taka sam�; potrzebne do sprawdzenia czy koniec gry
    }

    public int getNumber() {
        return this.number; // pobieranie numeru; potrzebne do sprawdzenia czy karty s� takie same
    }

}