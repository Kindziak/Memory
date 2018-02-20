package memory;

import java.awt.Dimension;

public class Main {
    
	public static void main(String[] args){
        Game b = new Game(); // nowa gra, która jest takim jakby nowym wyłożeniem
        b.setPreferredSize(new Dimension(500,500)); // ustawienie rozmiaru; 500 szerokości, 500 wysokości
        b.pack(); // automatyczne dopasowanie do rozmarów dodanych komponentów 
        b.setVisible(true); // ustawienie widoczności komponentów na true
    }   
    
}