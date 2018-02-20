package memory;

import javax.swing.JButton; // karta bêdzie przyciskiem

@SuppressWarnings("serial")

public class Card extends JButton {
	
	private int number; // numer karty 
    private boolean matchingCard; // czy znaleziono drug¹ tak¹ sam¹ kartê

    public Card (int number) {
    	this.number = number; // przypisujemy karcie numer
    	this.matchingCard = false; // na pocz¹tku ustawiamy, ¿e nie znaleziono
    }
    
    
    public void setMatchingCard(boolean matchingCard) {
        this.matchingCard = matchingCard; // ustawianie czy znaleziono kartê; w tej grze przestawianie na true, ¿e j¹ znaleziono
    }

    /*public void setNumber(int number) {
    	this.number = number; // ustawianie numeru; w tej grze raczej nie potrzebne
	}*/
    
    public boolean getMatchingCard() {
        return this.matchingCard; // pobieranie czy znaleniono drug¹ taka sam¹; potrzebne do sprawdzenia czy koniec gry
    }

    public int getNumber() {
        return this.number; // pobieranie numeru; potrzebne do sprawdzenia czy karty s¹ takie same
    }

}