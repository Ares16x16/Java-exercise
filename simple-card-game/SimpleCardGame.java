import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.util.*;

/* 1: Club
 * 2: Spade
 * 3: Square
 * 4: Heart
 * 
 * This class creates a simple card game 
 * @author Lo Tsz Yin
 * @version 1.0
 */

public class SimpleCardGame extends JFrame implements ActionListener {
	
	static JMenuBar mb;
	static JMenu m;
	static JMenuItem exit;
	
	boolean gameStarted = false;
	boolean win = false;
	
	//initialize player stat
	int moneyOwn = 100;
	int playerBet = 0;
	int chanceOfchangingCards = 0;
	boolean card1IsChanged = false;
	boolean card2IsChanged = false;
	boolean card3IsChanged = false;
	
	//dealer deck
	public static ArrayList<String> dealerDeck = new ArrayList<String>();
	
	//player deck
	public static ArrayList<String> playerDeck = new ArrayList<String>();
	
	//initialize player deck
	public static ArrayList<String> deck = new ArrayList<String>();
	static {
		deck.add("card_11.gif");
		deck.add("card_12.gif");
		deck.add("card_13.gif");
		deck.add("card_14.gif");
		deck.add("card_15.gif");
		deck.add("card_16.gif");
		deck.add("card_17.gif");
		deck.add("card_18.gif");
		deck.add("card_19.gif");
		deck.add("card_110.gif");
		deck.add("card_111.gif");
		deck.add("card_112.gif");
		deck.add("card_113.gif");
	
		deck.add("card_21.gif");
		deck.add("card_22.gif");
		deck.add("card_23.gif");
		deck.add("card_24.gif");
		deck.add("card_25.gif");
		deck.add("card_26.gif");
		deck.add("card_27.gif");
		deck.add("card_28.gif");
		deck.add("card_29.gif");
		deck.add("card_210.gif");
		deck.add("card_211.gif");
		deck.add("card_212.gif");
		deck.add("card_213.gif");
		
		deck.add("card_31.gif");
		deck.add("card_32.gif");
		deck.add("card_33.gif");
		deck.add("card_34.gif");
		deck.add("card_35.gif");
		deck.add("card_36.gif");
		deck.add("card_37.gif");
		deck.add("card_38.gif");
		deck.add("card_39.gif");
		deck.add("card_310.gif");
		deck.add("card_311.gif");
		deck.add("card_312.gif");
		deck.add("card_313.gif");
		
		deck.add("card_41.gif");
		deck.add("card_42.gif");
		deck.add("card_43.gif");
		deck.add("card_44.gif");
		deck.add("card_45.gif");
		deck.add("card_46.gif");
		deck.add("card_47.gif");
		deck.add("card_48.gif");
		deck.add("card_49.gif");
		deck.add("card_410.gif");
		deck.add("card_411.gif");
		deck.add("card_412.gif");
		deck.add("card_413.gif");
	}
	
	/*
	 * this method run the game by initializing both deck and create gui afterwards
	 */
    public static void main(String args[]){   	
    	SimpleCardGame gui = new SimpleCardGame();
    	gui.shuffle();
    	
    	//initialize dealer deck
    	for (int i = 0; i < 3; i++) {
    		gui.deal1cardToDealer();
    	}
    	
    	//initialize player deck
    	for (int i = 0; i < 3; i++) {
    		gui.deal1cardToPlayer();
    	}
    	gui.go();
    }
    
	/*
	 * this method create the gui and control the main function of the game like button start and result etc.
	 */
    public void go() { 
    	
    	//initialize 
    	
    	JLabel label_Image1 = new JLabel();
        JLabel label_Image2 = new JLabel();
        JLabel label_Image3 = new JLabel();
        JLabel label_Image4 = new JLabel();
        JLabel label_Image5 = new JLabel();
        JLabel label_Image6 = new JLabel();
      
        JButton btn_rpcard1 = new JButton("Replace Card 1");
        JButton btn_rpcard2 = new JButton("Replace Card 2");
        JButton btn_rpcard3 = new JButton("Replace Card 3");
        JButton btn_start = new JButton("Start");
        JButton btn_result = new JButton("Result");
        
        
        JLabel label_bet = new JLabel();
        JLabel label_info = new JLabel();
        JLabel label_money = new JLabel();
        JLabel label_moneyOwn = new JLabel();
        
        JTextField txt_inputbet = new JTextField(10);
        
        //dealer cards
        ImageIcon Image1 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image2 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image3 = new ImageIcon("Images/card_back.gif");
        
        //player cards
        ImageIcon Image4 = new ImageIcon("Images/card_back.gif");
        ImageIcon Image5 = new ImageIcon("Images/card_back.gif");
      	ImageIcon Image6 = new ImageIcon("Images/card_back.gif");
      	
      	label_Image1.setIcon(Image1);
      	label_Image2.setIcon(Image2);
      	label_Image3.setIcon(Image3);
      	label_Image4.setIcon(Image4);
      	label_Image5.setIcon(Image5);
      	label_Image6.setIcon(Image6);
      	
        JPanel MainPanel = new JPanel();
        JPanel DealerPanel = new JPanel();
        JPanel PlayerPanel = new JPanel();
        JPanel RpCardBtnPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InfoPanel = new JPanel();
        
        //DealerPanel layout
      	DealerPanel.add(label_Image1);
      	DealerPanel.add(label_Image2);
      	DealerPanel.add(label_Image3);
      	
      	//PlayerPanel layout
      	PlayerPanel.add(label_Image4);
      	PlayerPanel.add(label_Image5);
      	PlayerPanel.add(label_Image6);
      	
      	//RpCardBtnPanel layout
      	RpCardBtnPanel.add(btn_rpcard1);
      	RpCardBtnPanel.add(btn_rpcard2);
      	RpCardBtnPanel.add(btn_rpcard3);
      	
      	btn_rpcard1.setOpaque(false);
      	btn_rpcard1.setContentAreaFilled(false);
      	btn_rpcard2.setOpaque(false);
      	btn_rpcard2.setContentAreaFilled(false);
      	btn_rpcard3.setOpaque(false);
      	btn_rpcard3.setContentAreaFilled(false);
      	
      	//replace cards
      	/*
    	 * this method is the action listener of the button replace card 1 and it replaces the card
    	 *  @param e
    	 */
      	btn_rpcard1.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			if (!card1IsChanged && chanceOfchangingCards < 2 && gameStarted) {
      				playerDeck.set(0, deck.get(0));
      				deck.remove(0);
      				ImageIcon Image = new ImageIcon("Images/" + playerDeck.get(0));
      				label_Image4.setIcon(Image);
      				card1IsChanged = true;
      				chanceOfchangingCards += 1;
      				
      				//System.out.println("Deck: " + deck);
      		      	//System.out.println("Player: " + playerDeck);
      		      	//System.out.println("Dealer: " + dealerDeck);
      		      	//System.out.println("Game Started? " + gameStarted);
      			}
      		}
      	});
      	
      	/*
    	 * this method is the action listener of the button replace card 2 and it replaces the card
    	 *  @param e
    	 */
      	btn_rpcard2.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			if (!card2IsChanged && chanceOfchangingCards < 2 && gameStarted) {
      				playerDeck.set(1, deck.get(0));
      				deck.remove(0);
      				ImageIcon Image = new ImageIcon("Images/" + playerDeck.get(1));
      				label_Image5.setIcon(Image);
      				card2IsChanged = true;
      				chanceOfchangingCards += 1;
      				
      				//System.out.println("Deck: " + deck);
      		      	//System.out.println("Player: " + playerDeck);
      		      	//System.out.println("Dealer: " + dealerDeck);
      		      	//System.out.println("Game Started? " + gameStarted);
      			}
      		}
      	});
      	
      	/*
    	 * this method is the action listener of the button replace card 3 and it replaces the card
    	 *  @param e
    	 */
      	btn_rpcard3.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			if (!card3IsChanged && chanceOfchangingCards < 2 && gameStarted) {
      				playerDeck.set(2, deck.get(0));
      				deck.remove(0);
      				ImageIcon Image = new ImageIcon("Images/" + playerDeck.get(2));
      				label_Image6.setIcon(Image);
      				card3IsChanged = true;
      				chanceOfchangingCards += 1;
      				
      				//System.out.println("Deck: " + deck);
      		      	//System.out.println("Player: " + playerDeck);
      		      	//System.out.println("Dealer: " + dealerDeck);
      		      	//System.out.println("Game Started? " + gameStarted);
      			}
      		}
      	});
      	//ButtonPanel layout
      	ButtonPanel.add(label_bet);
      	label_bet.setText("Bet:$");
      	ButtonPanel.add(txt_inputbet);
      	ButtonPanel.add(btn_start);
      	ButtonPanel.add(btn_result);
      	
      	//start
      	/*
    	 * this method is the action listener of the button start 
    	 * it replace the image according to player hand and start the game
    	 *  @param e
    	 */
      	btn_start.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			if (!gameStarted){
	      			if (Integer.valueOf(txt_inputbet.getText()) <= moneyOwn) {
	      				ImageIcon ImageX = new ImageIcon("Images/" + playerDeck.get(0));
		      			ImageIcon ImageY = new ImageIcon("Images/" + playerDeck.get(1));
		      			ImageIcon ImageZ = new ImageIcon("Images/" + playerDeck.get(2));
		      			label_Image4.setIcon(ImageX);
		      			label_Image5.setIcon(ImageY);
		      			label_Image6.setIcon(ImageZ);
	      				label_money.setText(txt_inputbet.getText());
		      			playerBet = Integer.valueOf(txt_inputbet.getText());
		      			label_info.setText("Your current bet is: $");
		      			gameStarted = true;
	      			}
	      			//System.out.println("Game Started? " + gameStarted);
      			}
      		}
      	});
      	
      	//result
      	/*
    	 * this method is the action listener of the button result 
    	 * it replace the image according to dealer hand and end the game
    	 * and check the wether the player win or not at the end
    	 * 
    	 * @param e
    	 */
      	btn_result.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			if (gameStarted){
      				gameStarted = false;
	      			ImageIcon ImageX = new ImageIcon("Images/" + dealerDeck.get(0));
	      			ImageIcon ImageY = new ImageIcon("Images/" + dealerDeck.get(1));
	      			ImageIcon ImageZ = new ImageIcon("Images/" + dealerDeck.get(2));
	      			label_Image1.setIcon(ImageX);
	      			label_Image2.setIcon(ImageY);
	      			label_Image3.setIcon(ImageZ);
	      			//System.out.println("Game Started? " + gameStarted);
	      			
	      			//check win
	      			int dealerSpecial = 0;
	      			int playerSpecial = 0;
	      			
	      			//check player special cards
	      			for (int i=0;i<3;i++) {
	      				if (playerDeck.get(i).length() == 12 && playerDeck.get(i).charAt(7) != '0') {
	      					playerSpecial += 1;
	      				}
	      			}
	      			//check dealer special cards
	      			for (int i=0;i<3;i++) {
	      				if (dealerDeck.get(i).length() == 12 && dealerDeck.get(i).charAt(7) != '0') {
	      					dealerSpecial += 1;
	      				}
	      			}
	      			//System.out.println("playerSpecial: " + playerSpecial);
	      			//System.out.println("dealerSpecial: " + dealerSpecial);
	      			
	      			//if same no. of special cards
	      			int playerCardFaceValue = 0;
	      			int dealerCardFaceValue = 0;
	      			
	      			if (playerSpecial > dealerSpecial) {
	      				win = true;
	      			}
	      			else if (playerSpecial < dealerSpecial) {
	      				win = false;
	      			}
	      			else if (playerSpecial == dealerSpecial) {		
	      				//check player card value	
	      				for (int i=0;i<3;i++) {
	      					if (playerDeck.get(i).length() != 12) {
	      						playerCardFaceValue += Character.getNumericValue(playerDeck.get(i).charAt(6));
	      						
	      					}else if(playerDeck.get(i).length() == 12 && playerDeck.get(i).charAt(7) == 0){
	      						playerCardFaceValue += 10;
	      					}
	      					//System.out.println("playerCardFaceValue: " + playerCardFaceValue);
	      				}
	      				//find remainder of card value
	      				playerCardFaceValue = playerCardFaceValue % 10;
	      				
		      			//check dealer card value
		      			for (int i=0;i<3;i++) {
		      				if (dealerDeck.get(i).length() != 12) {
		      					dealerCardFaceValue += Character.getNumericValue(dealerDeck.get(i).charAt(6));
		      				}else if(dealerDeck.get(i).length() == 12 && dealerDeck.get(i).charAt(7) == 0){
		      					dealerCardFaceValue += 10;
	      					}
		      				//System.out.println("dealerCardFaceValue: " + dealerCardFaceValue);
		      			}
		      			
		      			//find remainder of card value
		      			dealerCardFaceValue = dealerCardFaceValue % 10;
		      			
		      			//System.out.println("playerCardFaceValue: " + playerCardFaceValue);
		      			//System.out.println("dealerCardFaceValue: " + dealerCardFaceValue);
		      			
		      			if (playerCardFaceValue > dealerCardFaceValue) {
		      				win = true;
		      			}else{
		      				win = false;
		      			}
		      				
	      			}
      			
	      			//System.out.println("win: " + win);
	      			JFrame popUpMsg = new JFrame();
	      			if (win && moneyOwn > 0) {		
	      		        JOptionPane.showMessageDialog(popUpMsg, "Congratulations! You win this round!");
	      		        moneyOwn += playerBet;
	      		        
		      		      label_moneyOwn.setText("Amount of money you have: $" + moneyOwn);
		      		      chanceOfchangingCards = 0;
		      		      playerBet = 0;
		      			  card1IsChanged = false;
		      			  card2IsChanged = false;
		      			  card3IsChanged = false;
		      			  gameStarted = false;
		      			  win = false;
		      			  
		      			  //reset
		      		      dealerDeck.clear();
		      		      playerDeck.clear();
		      		      deck.clear();
		      		      
		      		      deck.add("card_11.gif");
		      		      deck.add("card_12.gif");
		      		      deck.add("card_13.gif");
		      		      deck.add("card_14.gif");
		      		      deck.add("card_15.gif");
		      		      deck.add("card_16.gif");
		      		      deck.add("card_17.gif");
		      		      deck.add("card_18.gif");
		      		      deck.add("card_19.gif");
		      		      deck.add("card_110.gif");
		      		      deck.add("card_111.gif");
		      		      deck.add("card_112.gif");
		      		      deck.add("card_113.gif");
		      		
		      		      deck.add("card_21.gif");
		      		      deck.add("card_22.gif");
		      		      deck.add("card_23.gif");
		      		      deck.add("card_24.gif");
		      		      deck.add("card_25.gif");
		      		      deck.add("card_26.gif");
		      		      deck.add("card_27.gif");
		      		      deck.add("card_28.gif");
		      		      deck.add("card_29.gif");
		      		      deck.add("card_210.gif");
		      		      deck.add("card_211.gif");
		      		      deck.add("card_212.gif");
		      		      deck.add("card_213.gif");
		      			
		      		      deck.add("card_31.gif");
		      		      deck.add("card_32.gif");
		      		      deck.add("card_33.gif");
		      		      deck.add("card_34.gif");
		      		      deck.add("card_35.gif");
		      		      deck.add("card_36.gif");
		      		      deck.add("card_37.gif");
		      		      deck.add("card_38.gif");
		      		      deck.add("card_39.gif");
		      		      deck.add("card_310.gif");
		      		      deck.add("card_311.gif");
		      		      deck.add("card_312.gif");
		      		      deck.add("card_313.gif");
		      			
		      		      deck.add("card_41.gif");
		      		      deck.add("card_42.gif");
		      		      deck.add("card_43.gif");
		      		      deck.add("card_44.gif");
		      		      deck.add("card_45.gif");
		      		      deck.add("card_46.gif");
		      		      deck.add("card_47.gif");
		      		      deck.add("card_48.gif");
		      		      deck.add("card_49.gif");
		      		      deck.add("card_410.gif");
		      		      deck.add("card_411.gif");
		      		      deck.add("card_412.gif");
		      		      deck.add("card_413.gif");
		      		      
		      		    shuffle();
		      		    deal1cardToDealer();
	        			deal1cardToDealer();
	        			deal1cardToDealer();
	        			deal1cardToPlayer();
	        			deal1cardToPlayer();
	        			deal1cardToPlayer();
	        			
	        			//reset image
	        			label_Image1.setIcon(Image1);
	        	      	label_Image2.setIcon(Image2);
	        	      	label_Image3.setIcon(Image3);
	        	      	label_Image4.setIcon(Image4);
	        	      	label_Image5.setIcon(Image5);
	        	      	label_Image6.setIcon(Image6);
	      		      
	      		      
	      			}else if (!win && moneyOwn > 0) {
	      				
	      				moneyOwn -= playerBet;
	      				if (moneyOwn <= 0) {
	      					btn_start.setEnabled(false);
	      					btn_result.setEnabled(false);
	      					btn_rpcard1.setEnabled(false);
	      					btn_rpcard2.setEnabled(false);
	      					btn_rpcard3.setEnabled(false);
	      					label_info.setText("");
	      					label_money.setText("");
		      				label_moneyOwn.setText("You have no more money! Please start a new game!");
		      				
		      				JOptionPane.showMessageDialog(popUpMsg, "Game over!\nYou have no more money!\nPlease start a new game!");
		      				

		      		    }else if (moneyOwn > 0) {
		      				JOptionPane.showMessageDialog(popUpMsg, "Sorry! The Dealer wins this round!");
		      				label_moneyOwn.setText("Amount of money you have: $" + moneyOwn);
		      				chanceOfchangingCards = 0;
		      				playerBet = 0;
		        			card1IsChanged = false;
		        			card2IsChanged = false;
		        			card3IsChanged = false;
		        			gameStarted = false;
		        			win = false;
		        			
		        			//reset
		      				dealerDeck.clear();
		        		    playerDeck.clear();
		        		    deck.clear();
		        		    
		        		    deck.add("card_11.gif");
		        			deck.add("card_12.gif");
		        			deck.add("card_13.gif");
		        			deck.add("card_14.gif");
		        			deck.add("card_15.gif");
		        			deck.add("card_16.gif");
		        			deck.add("card_17.gif");
		        			deck.add("card_18.gif");
		        			deck.add("card_19.gif");
		        			deck.add("card_110.gif");
		        			deck.add("card_111.gif");
		        			deck.add("card_112.gif");
		        			deck.add("card_113.gif");
		        		
		        			deck.add("card_21.gif");
		        			deck.add("card_22.gif");
		        			deck.add("card_23.gif");
		        			deck.add("card_24.gif");
		        			deck.add("card_25.gif");
		        			deck.add("card_26.gif");
		        			deck.add("card_27.gif");
		        			deck.add("card_28.gif");
		        			deck.add("card_29.gif");
		        			deck.add("card_210.gif");
		        			deck.add("card_211.gif");
		        			deck.add("card_212.gif");
		        			deck.add("card_213.gif");
		        			
		        			deck.add("card_31.gif");
		        			deck.add("card_32.gif");
		        			deck.add("card_33.gif");
		        			deck.add("card_34.gif");
		        			deck.add("card_35.gif");
		        			deck.add("card_36.gif");
		        			deck.add("card_37.gif");
		        			deck.add("card_38.gif");
		        			deck.add("card_39.gif");
		        			deck.add("card_310.gif");
		        			deck.add("card_311.gif");
		        			deck.add("card_312.gif");
		        			deck.add("card_313.gif");
		        			
		        			deck.add("card_41.gif");
		        			deck.add("card_42.gif");
		        			deck.add("card_43.gif");
		        			deck.add("card_44.gif");
		        			deck.add("card_45.gif");
		        			deck.add("card_46.gif");
		        			deck.add("card_47.gif");
		        			deck.add("card_48.gif");
		        			deck.add("card_49.gif");
		        			deck.add("card_410.gif");
		        			deck.add("card_411.gif");
		        			deck.add("card_412.gif");
		        			deck.add("card_413.gif");
		        			
		        			shuffle();
		        			deal1cardToDealer();
		        			deal1cardToDealer();
		        			deal1cardToDealer();
		        			deal1cardToPlayer();
		        			deal1cardToPlayer();
		        			deal1cardToPlayer();
		        			
		        			//reset image
		        			label_Image1.setIcon(Image1);
		        	      	label_Image2.setIcon(Image2);
		        	      	label_Image3.setIcon(Image3);
		        	      	label_Image4.setIcon(Image4);
		        	      	label_Image5.setIcon(Image5);
		        	      	label_Image6.setIcon(Image6);
		      			}
	      			}
	      			
      			}	
      		}
      	});
      	
      	//InfoPanel layout	
      	
      	InfoPanel.add(label_info);
      	label_info.setText("Please place your bet!");
      	InfoPanel.add(label_money);
      	InfoPanel.add(label_moneyOwn);
      	label_moneyOwn.setText("Amount of money you have: $" + moneyOwn);
      	
      	
      
      	//mainPanel layout
      	MainPanel.setLayout(new GridLayout(5,1));
      	MainPanel.add(DealerPanel);
      	MainPanel.add(PlayerPanel);
      	MainPanel.add(RpCardBtnPanel);
      	MainPanel.add(ButtonPanel);
      	MainPanel.add(InfoPanel);

      	// Optional background color setting
      	
      	DealerPanel.setBackground(Color.green);
      	PlayerPanel.setBackground(Color.green);
      	RpCardBtnPanel.setBackground(Color.green);
      	JFrame frame = new JFrame();
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	
      	mb = new JMenuBar();
        m = new JMenu("Control");
        exit = new JMenuItem("Exit");
        m.add(exit);
        mb.add(m);
        
        /*
         * this method exit the game if the menu item is pressed
         * @param e
         */
        exit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        } );
        
        frame.setJMenuBar(mb);
      	frame.getContentPane().add(MainPanel);
      	frame.setTitle("A Simple Card Game");
      	frame.setSize(400, 700);
      	frame.setVisible(true);
      	
        
      	//debug
      	//System.out.println("Deck: " + deck);
      	//System.out.println("Dealer: " + dealerDeck);
      	//System.out.println("Player: " + playerDeck);   	
      	//System.out.println("Game Started? " + gameStarted);
    }
    
    /*
     * this method shuffle the deck
     */
    public void shuffle() {
    	Collections.shuffle(deck);
    }
    
    /*
     * this method deal one card to the dealer deck
     */
    public void deal1cardToDealer() {
    	dealerDeck.add(deck.get(0));
    	deck.remove(0);
    }
    
    
    
    /*
     * this method deal one card to the player deck
     */
    public void deal1cardToPlayer() {
	   	playerDeck.add(deck.get(0));
	   	deck.remove(0);
   }
    
 

}
