package memory;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")

public class Game extends JFrame {

	static String files[] = {"Chile.png","Chad.png","Bulgaria.png","Botswana.png","Algeria.png","Albania.png","Angola.png","Aruba.png","Austria.png","Barbados.png"};
	private Timer timer;
    private Card selectedCard; // karta wybrana, ale nie zapami�tana
    private Card card1; // karta pierwsza wybrana
    private Card card2; // karta druga wybrana
    private Player player;
    private Options options;
    private PlayerBar playerBar;
    private int pairs; // ilo�� par kart
    private List<Card> cards;
    private List<Integer> cardsNumbers;
    // private int disabledCards; do wersji alternatywnej

    public Game() {
    	this.player = new Player();
        this.options = new Options();
        this.playerBar = new PlayerBar(this.player);
    	this.pairs = this.options.getCardsAmount();
        this.cards = new ArrayList<Card>();
        this.cardsNumbers = new ArrayList<Integer>();
        // this.disabledCards = 0; do wersji alternatywnej
        initializeComponents();
    }
    
    
    private void initializeComponents() {
    	for(int i=0 ; i<this.pairs ; i++) { // dodanie do listy numer�w kart
            this.cardsNumbers.add(i); // pojawia si� dwa razy, poniewa� musimy mie� po dwie karty takie same
            this.cardsNumbers.add(i);
        }
        
        Collections.shuffle(this.cardsNumbers); // tasuje karty, czyli randomowo ustawia numery kart w li�cie

        for(int number : this.cardsNumbers) { // przechodzi po numerach karty
            Card c = new Card(number); // powstaje nowa karta
            c.addActionListener(new ActionListener() { // dodaje akcje do klikni�cia
                public void actionPerformed(ActionEvent a) {
                    selectedCard = c; // wybrana karta
                    turnCard(); // obraca kart�
                }
            });
            this.cards.add(c); // dodaje do listy wszystkich kart
        }
        
        this.timer = new Timer(100, new ActionListener() { // ustawia timer
            public void actionPerformed(ActionEvent a) {
            	isTheSameCards(); // sprawdzenie czy obie karty sa takie same
            }
        });
        timer.setRepeats(false); // timer stopuje si� po tym jak zrobi akcje 
        
        initializePanel(); // inicjalizuje ca�y widoczny panel
    }
    
    private void initializePanel() {
        setLayout(new BorderLayout()); // nowy rozk�ad panelu
        setDefaultCloseOperation(EXIT_ON_CLOSE); // kiedy gracz zamyka panel, gra si� ko�czy
        JPanel top = this.playerBar.paint(); // robi pasek u g�ry z danymi gracza
        add(top, BorderLayout.NORTH); // dodaje panel do gory g��wnego panelu
        JPanel field = initializeField(); // inicjalizuje centralne pole
        add(field,  BorderLayout.CENTER); // dodaje panel do centralnej cze�ci
        setTitle("Memory"); // ustawia tytu�
    }
    
    private JPanel initializeField() { // inicjalizuje centalna
    	JPanel field = new JPanel();
    	field.setLayout(new GridLayout(4,3)); // ustawia uklad potencjalny kart
    	for(Card c : cards) {
            field.add(c); // dodaje karty do panelu
        }
    	return field;
    }

    public void turnCard() {
        if(card1==null && card2==null) { // je�eli to pierwsza wybrana karta
            card1 = selectedCard; // przypisujemy do karty pierwszej
            ImageIcon icon = new ImageIcon(files[card1.getNumber()]); // nowy obrazek
            card1.setIcon(icon); // dajemy karcie obrazek
        }
        if(card1!=null && card1!=selectedCard && card2==null) { // je�eli to druga karta
            card2 = selectedCard; // przypisujemy do karty drugiej
            ImageIcon icon = new ImageIcon(files[card2.getNumber()]); // nowy obrazek
            card2.setIcon(icon); // dajemy karcie obrazek
            timer.start(); // w��czamy czas, gdzie sprawdzane jest czy karty pasuj� do siebie
        }
    }

    public void isTheSameCards() {
        if(card1.getNumber()==card2.getNumber()) { // sprawdzenie czy numery kart s� sobie r�wne
            card1.setEnabled(false); // wy��czenie przycisku
            card1.setMatchingCard(true); // ustawienie, �e znaleziono dwie takie same karty
            card2.setEnabled(false); // wy��czenie przycisku
            card2.setMatchingCard(true); // ustawienie, �e znaleziono dwie takie same karty
            if (this.isGameEnds()){ // czy to koniec gry
                JOptionPane.showMessageDialog(this, "Wygra�e�!"); // koniec gry
                System.exit(0); // wyj�cie z gry
            }
            
            // ----------- wersja alternatywna
            /*disabledCards ++;
            if(this.disabledCards==this.options.getCardsAmount()) {
            	JOptionPane.showMessageDialog(this, "Wygra�e�!"); // koniec gry
                System.exit(0); // wyj�cie z gry
            }*/
            
        }
        else {
        	ImageIcon icon = new ImageIcon("closed.jpg"); // ustawienie icony karty na zas�oni�t�
            card1.setIcon(icon);
            card2.setIcon(icon);
        }
        card1 = null; // zresetowanie karty, aby mo�na by�o pobra� nowe do dalszej gry
        card2 = null; // zresetowanie karty, aby mo�na by�o pobra� nowe do dalszej gry
    }

    public boolean isGameEnds() {
        for(Card card: this.cards) { // przej�cie po wszystkich kartach
            if(card.getMatchingCard()==false) { // sprawdzenie czy kt�ra� karta jest jeszcze niedopasowana
                return false; // jak niedopasowana to gra idzie dalej
            }
        }
        return true; // wszystkie dopasowane, wi�c koniec gry
    }

}