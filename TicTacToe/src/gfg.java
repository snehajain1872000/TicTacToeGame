
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
public class gfg {

	public static void main(String[] args) {
		
		new TicTacToe1();

	}
}

class TicTacToe1 implements ActionListener {
	
	Random random = new Random();
	Timer timer = new Timer();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	boolean tie = true;
	int turns = 0;
	
	TicTacToe1() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setTitle("Tic Tac Toe");
		
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic Tac Toe");
		textfield.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		
		buttonPanel.setLayout(new GridLayout(3, 3));
		
		for (int i = 0; i < 9; i++) {
			
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].setEnabled(false);
			buttons[i].addActionListener(this);
			
		}
		
		titlePanel.add(textfield);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		firstTurn();	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						turns++;
						player1Turn = false;
						textfield.setText("O's turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						turns++;
						player1Turn = true;
						textfield.setText("X's turn");
						check();
					}	
				}
			}
		}
	}
	
	public void firstTurn() {
		
		timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  if(random.nextInt(2)==0) {
						player1Turn = true;
						textfield.setText("X's turn");
				  }
				  else {
						player1Turn = false;
						textfield.setText("O's turn");
				  }  
				  for (int i = 0; i < 9; i++) {
						buttons[i].setEnabled(true);
				  }
			  }
		}, 3000);	
	}
	
	public void check() {
		
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xWins(0, 1, 2); tie = false;
		} if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xWins(3, 4, 5); tie = false;
		} if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(6, 7, 8); tie = false;
		} if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(0, 3, 6); tie = false;
		} if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xWins(1, 4, 7); tie = false;
		} if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(2, 5, 8); tie = false;
		} if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(0, 4, 8); tie = false;
		} if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(2, 4, 6); tie = false;
		} 
		
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oWins(0, 1, 2); tie = false;
		} if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oWins(3, 4, 5); tie = false;
		} if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(6, 7, 8); tie = false;
		} if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(0, 3, 6); tie = false;
		} if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oWins(1, 4, 7); tie = false;
		} if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(2, 5, 8); tie = false;
		} if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(0, 4, 8); tie = false;
		} if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(2, 4, 6); tie = false;
		}	
		
		if(tie && turns == 9) {
			tie();
		}
	}
	
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins!");
		resetting();
	}
	
	public void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);	
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins!");	
		resetting();
	}
	
	public void tie() {
		
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Tie!");	
		resetting();
		
	}
	
	public void resetting() {
		
		firstTurn();
		timer.schedule(new TimerTask() {
			
			  @Override
			  public void run() {
				  for (int i = 0; i < 9; i++) {
					  buttons[i].setEnabled(true);
					  buttons[i].setText("");
					  buttons[i].setBackground(null);
				  }
			  }
		}, 3000);	
	}
}
