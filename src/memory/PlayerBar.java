package memory;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerBar {
	
	private Player player; // gracz, który bêdzie gra³; bêdzie siê wyœwietla³o u góry gry
	
	public PlayerBar(Player player) {
		this.player = player; // ustawienie gracza
	}
	
	
	public JPanel paint() {
		JPanel top = initializeTop(); // zainicjalizowanie górego paska
		return top; // zwraca górny pasek jako JPanel, aby dodaæ do g³ównego panelu jako czêœæ north
	}
	
	private JPanel initializeTop() {
		JPanel top = new JPanel();  // nowy panel
		top.setLayout(new GridLayout(1,1)); // uklad, czyli 1 wiersz i kolumna
		JLabel name = new JLabel(); // nowa etykieta
		name.setText("Nazwa gracza: " + this.player.getPlayerName()); // wpisanie tekstu do etykiety, czyli nazwê gracza
		top.add(name); // dodanie do panelu etykiety
		return top;
	}
	
}