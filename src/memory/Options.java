package memory;

import javax.swing.JOptionPane;

public class Options {
	
	private int cardsAmount; // iloœæ kart danej opcji
	private String option; // wybór opcji
	
	public Options() {
		boolean isOk = false; // zmienna potrzebna do zrobienia pêtli, w której sprawdzamy, czy dobrze wpisali
		while (isOk==false) {
			this.option = JOptionPane.showInputDialog(null,"Wybierz poziom gry: 1-£atwy, 2-Œredni, 3-Trudny.","Pytanie",JOptionPane.QUESTION_MESSAGE);
			if (this.option.equals("1")) {
				this.cardsAmount=4; // gdy jest opcja ³atwa to s¹ 4 ró¿ne karty
				isOk=true; // do wyjscia z pêtli
			}
			else if(this.option.equals("2")) {
				this.cardsAmount=6; // gdy jest opcja œrednia to jest 6 ró¿ne karty
				isOk=true; // do wyjscia z pêtli
			}
			else if(this.option.equals("3")) {
				this.cardsAmount=10; // gdy jest opcja trudna to jest 10 ró¿ne karty
				isOk=true; // do wyjscia z pêtli
			}
			else {
				JOptionPane.showMessageDialog(null,"Wpisa³eœ z³¹ cyfrê.");
				// wyœwietla, ¿e gracz poda³ z³¹ cyfre
			}
		}
	}
	
	
	public int getCardsAmount() {
		return this.cardsAmount; // pobieraie iloœæ kart; potrzebne jest to do wybrania ile kart trzeba stworzyæ
	}
	
	/*public String getOption() {
		return this.option; // pobieranie opcji; raczej nie potrzebne do tej gry
	}	*/

}