import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class CookieMain {
	
	JLabel counterLabel, perSecLabel;
	JButton button1, button2, button3, button4, button5;
	int cookieCounter, timerSpeed, cursorNumber, cursorPrice, grandpaNumber, grandpaPrice, farmNumber, farmPrice, factoryNumber, factoryPrice;
	double perSecond;
	boolean timerOn, grandpaUnlocked, farmUnlocked, factoryUnlocked;
	Font font1, font2;
	CookieHandler cHandler = new CookieHandler();
	Timer timer;
	JTextArea messageTxt;
	MouseHandler mHandler = new MouseHandler();

	public static void main(String[] args) {
		
		new CookieMain();
		
	}
	
	public CookieMain() {
		timerOn = false;
		perSecond = 0;
		cookieCounter = 0;
		cursorNumber = 0;
		cursorPrice = 10;
		grandpaNumber = 0;
		grandpaPrice = 100;
		grandpaUnlocked = false;
		factoryNumber = 0;
		farmPrice = 250;
		farmUnlocked = false;
		factoryNumber = 0;
		factoryPrice = 500;
		factoryUnlocked = false;
		
		createFont();
		createUI();
	}
	
	public void createFont() {
		font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 15);
	}
	
	public void createUI() {
		// Window size etc.
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		window.getContentPane().setBackground(Color.black);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setLayout(null);
		
		// Cookie Panel
		JPanel cookiePanel = new JPanel();
		cookiePanel.setBounds(100, 220, 200, 200);
		cookiePanel.setBackground(Color.black);
		window.add(cookiePanel);
		
		// Cookie Button
		ImageIcon cookie = new ImageIcon(getClass().getClassLoader().getResource("cookie.png"));
		
		JButton cookieButton = new JButton();
		cookieButton.setBackground(Color.black);
		cookieButton.setFocusPainted(false);
		cookieButton.setBorder(null);
		cookieButton.setIcon(cookie);
		cookieButton.addActionListener(cHandler);
		cookieButton.setActionCommand("cookie");
		cookieButton.setContentAreaFilled(false);
		cookiePanel.add(cookieButton);
		
		// Counter
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100, 100, 200, 100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(2, 1));
		window.add(counterPanel);
		
		// Counter Labels
		counterLabel = new JLabel(cookieCounter + " cookies");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.white);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);
		
		// Item Panel
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		 
		// Easter Egg Panel
		JPanel eggPanel = new JPanel();
		eggPanel.setBounds(780, 559, 5, 5);
		eggPanel.setBackground(Color.black);
		eggPanel.setLayout(new GridLayout(1, 1));
		window.add(eggPanel);
		
		// Item buttons
		//button1
			button1 = new JButton("Cursor");
			button1.setFont(font1);
			button1.setFocusPainted(false);
			button1.addActionListener(cHandler);
			button1.setActionCommand("Cursor");
			button1.addMouseListener(mHandler);
			itemPanel.add(button1);
		//button2
			button2 = new JButton("?");
			button2.setFont(font1);
			button2.setFocusPainted(false);
			button2.addActionListener(cHandler);
			button2.setActionCommand("Grandpa");
			button2.addMouseListener(mHandler);
			itemPanel.add(button2);
		//button3
			button3 = new JButton("?");
			button3.setFont(font1);
			button3.setFocusPainted(false);
			button3.addActionListener(cHandler);
			button3.setActionCommand("Farm");
			button3.addMouseListener(mHandler);
			itemPanel.add(button3);
		//button4
			button4 = new JButton("?");
			button4.setFont(font1);
			button4.setFocusPainted(false);
			button4.addActionListener(cHandler);
			button4.setActionCommand("Factory");
			button4.addMouseListener(mHandler);
			itemPanel.add(button4);
		//button5 (easter egg)
			button5 = new JButton();
			button5.setBackground(Color.green);
			button5.setFont(font1);
			button5.setFocusPainted(false);
			button5.addActionListener(cHandler);
			button5.setActionCommand("egg");
			button5.addMouseListener(mHandler);
			eggPanel.add(button5);
			
		// Message box for items
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(500, 70, 250, 150);
		messagePanel.setBackground(Color.black);
		window.add(messagePanel);
		
		messageTxt = new JTextArea();
		messageTxt.setBounds(500, 70, 250, 150);
		messageTxt.setForeground(Color.white);
		messageTxt.setBackground(Color.black);
		messageTxt.setFont(font2);
		messageTxt.setLineWrap(true);
		messageTxt.setWrapStyleWord(true);
		messageTxt.setEditable(false);
		messagePanel.add(messageTxt);
		
		// Window shown
		window.setVisible(true);
	}
	
	public void setTimer() {
		timer = new Timer(timerSpeed, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				
				if (grandpaUnlocked == false) {
					if (cookieCounter >= 100) {
						grandpaUnlocked = true;
						button2.setText("Grandpa " + "(" + grandpaNumber + ")");
					}
				}
				if (farmUnlocked == false) {
					if (cookieCounter >= 250) {
						farmUnlocked = true;
						button3.setText("Farm " + "(" + farmNumber + ")");
					}
				}
				if (factoryUnlocked == false) {
					if (cookieCounter >= 500) {
						factoryUnlocked = true;
						button4.setText("Factory " + "(" + factoryNumber + ")");
					}
				}
			}
		});
	}
	
	// Timer
	public void timerUpdate() {
		if (timerOn == false) {
			timerOn = true;
		}
		else if (timerOn == true) {
			timer.stop();
		}
		
		double speed = 1/perSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String s = String.format("%.1f", perSecond);
		perSecLabel.setText("per second: " + s);
		
		setTimer();
		timer.start();
	}
	
	// Cookie Clicker events
	public class CookieHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			
			switch(action) {
			case "cookie":
				cookieCounter++;
				counterLabel.setText(cookieCounter + " cookies");
				break;
			case "Cursor":
				if (cookieCounter >= cursorPrice) {
					cookieCounter -= cursorPrice;
					cursorPrice += 5;
					counterLabel.setText(cookieCounter + " cookies");
					
					cursorNumber++;
					button1.setText("Cursor (" + cursorNumber + ")");
					messageTxt.setText("Cursor - [price: " + cursorPrice + "] \nAutoclicks once every 10 seconds!");
					perSecond = perSecond + 0.1;
					timerUpdate();
				}
				else {
					messageTxt.setText("You need more cookies!");
				}
				break;
			case "Grandpa":
				if (cookieCounter >= grandpaPrice) {
					cookieCounter -= grandpaPrice;
					grandpaPrice += 50;
					counterLabel.setText(cookieCounter + " cookies");
					
					grandpaNumber++;
					button2.setText("Grandpa (" + grandpaNumber + ")");
					messageTxt.setText("Grandpa - [price: " + grandpaPrice + "] \nEach grandpa bakes 1 cookie per second!");
					perSecond += 1;
					timerUpdate();
				}
				else {
					messageTxt.setText("You need more cookies!");
				}
				break;
			case "Farm":
				if (cookieCounter >= farmPrice) {
					cookieCounter -= farmPrice;
					farmPrice += 250;
					counterLabel.setText(cookieCounter + " cookies");
					
					farmNumber++;
					button3.setText("Farm (" + farmNumber + ")");
					messageTxt.setText("Farm - [price: " + farmPrice + "] \nThe farm can collect 5 cookies per second!");
					perSecond += 5;
					timerUpdate();
				}
				else {
					messageTxt.setText("You need more cookies!");
				}
				break;
			case "Factory":
				if (cookieCounter >= factoryPrice) {
					cookieCounter -= factoryPrice;
					factoryPrice += 500;
					counterLabel.setText(cookieCounter + " cookies");
					
					factoryNumber++;
					button4.setText("Factory (" + factoryNumber + ")");
					messageTxt.setText("Factory - [price: " + factoryPrice + "] \nA factory produces 10 cookies per seconds!");
					perSecond += 10;
					timerUpdate();
				}
				else {
					messageTxt.setText("You need more cookies!");
				}
				break;
			case "egg":
				messageTxt.setText("Congrats, you found the Easter Egg!");
				cookieCounter += 10000;
				counterLabel.setText(cookieCounter + " cookies");
				break;
			}
			
		}
	}
	
	// MouseListener for itemboxes
	public class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// must have for class to work
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// must have for class to work
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// must have for class to work
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			
			if (button == button1) {
				messageTxt.setText("Cursor - [price: " + cursorPrice + "] \nAutoclicks once every 10 seconds");
			}
			else if (button == button2) {
				if (grandpaUnlocked == false) {
					messageTxt.setText("This item is currently locked!");
				}
				else {
					messageTxt.setText("Grandpa - [price: " + grandpaPrice + "] \nEach grandpa bakes 1 cookie per second");
				}
			}
			else if (button == button3) {
				if (farmUnlocked == false) {
					messageTxt.setText("This item is currently locked!");
				}
				else {
					messageTxt.setText("Farm - [price: " + farmPrice + "] \nThe farm can collect 5 cookies per second!");
				}
			}
			else if (button == button4) {
				if (factoryUnlocked == false) {
					messageTxt.setText("This item is currently locked!");
				}
				else {
					messageTxt.setText("Factory - [price: " + factoryPrice + "] \nA factory produces 10 cookies per seconds!");
				}
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			
			if (button == button1 || button == button2 || button == button3 || button == button4) {
				messageTxt.setText(null);
			}
		}
	}
	
}
