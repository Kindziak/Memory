package memory;

import javax.swing.JOptionPane; // potrzebne do wprowadzenia nazwy gracza

public class Player {
	
	private String playerName; // nazwa gracza
	
	public Player() {
		this.playerName = JOptionPane.showInputDialog(null,"Podaj nazwê gracza","Pytanie",JOptionPane.QUESTION_MESSAGE);
		// pokazanie okienka z wprowadzeniem nazwy gracza
	}
	
	
	/*public void setPlayerName(String playerName) {
		this.playerName = playerName; // ustawienie nazwy gracza; w tej grze raczej nie potrzebne
	}*/
	
	public String getPlayerName() {
		return this.playerName; // pobranie nazwy gracza; potrzebne do wyswietlenia na pasku u góry gry
	}
	
}