package memory;

import javax.swing.JOptionPane;

public class Options {
	
	private int cardsAmount; // ilo�� kart danej opcji
	private String option; // wyb�r opcji
	
	public Options() {
		boolean isOk = false; // zmienna potrzebna do zrobienia p�tli, w kt�rej sprawdzamy, czy dobrze wpisali
		while (isOk==false) {
			this.option = JOptionPane.showInputDialog(null,"Wybierz poziom gry: 1-�atwy, 2-�redni, 3-Trudny.","Pytanie",JOptionPane.QUESTION_MESSAGE);
			if (this.option.equals("1")) {
				this.cardsAmount=4; // gdy jest opcja �atwa to s� 4 r�ne karty
				isOk=true; // do wyjscia z p�tli
			}
			else if(this.option.equals("2")) {
				this.cardsAmount=6; // gdy jest opcja �rednia to jest 6 r�ne karty
				isOk=true; // do wyjscia z p�tli
			}
			else if(this.option.equals("3")) {
				this.cardsAmount=10; // gdy jest opcja trudna to jest 10 r�ne karty
				isOk=true; // do wyjscia z p�tli
			}
			else {
				JOptionPane.showMessageDialog(null,"Wpisa�e� z�� cyfr�.");
				// wy�wietla, �e gracz poda� z�� cyfre
			}
		}
	}
	
	
	public int getCardsAmount() {
		return this.cardsAmount; // pobieraie ilo�� kart; potrzebne jest to do wybrania ile kart trzeba stworzy�
	}
	
	/*public String getOption() {
		return this.option; // pobieranie opcji; raczej nie potrzebne do tej gry
	}	*/

}