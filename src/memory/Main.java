package memory;

import java.awt.Dimension;

public class Main {
    
	public static void main(String[] args){
        Game b = new Game(); // nowa gra, kt�ra jest takim jakby nowym wy�o�eniem
        b.setPreferredSize(new Dimension(500,500)); // ustawienie rozmiaru; 500 szeroko�ci, 500 wysoko�ci
        b.pack(); // automatyczne dopasowanie do rozmar�w dodanych komponent�w 
        b.setVisible(true); // ustawienie widoczno�ci komponent�w na true
    }   
    
}