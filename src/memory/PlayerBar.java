package memory;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerBar {
	
	private Player player; // gracz, kt�ry b�dzie gra�; b�dzie si� wy�wietla�o u g�ry gry
	
	public PlayerBar(Player player) {
		this.player = player; // ustawienie gracza
	}
	
	
	public JPanel paint() {
		JPanel top = initializeTop(); // zainicjalizowanie g�rego paska
		return top; // zwraca g�rny pasek jako JPanel, aby doda� do g��wnego panelu jako cz�� north
	}
	
	private JPanel initializeTop() {
		JPanel top = new JPanel();  // nowy panel
		top.setLayout(new GridLayout(1,1)); // uklad, czyli 1 wiersz i kolumna
		JLabel name = new JLabel(); // nowa etykieta
		name.setText("Nazwa gracza: " + this.player.getPlayerName()); // wpisanie tekstu do etykiety, czyli nazw� gracza
		top.add(name); // dodanie do panelu etykiety
		return top;
	}
	
}