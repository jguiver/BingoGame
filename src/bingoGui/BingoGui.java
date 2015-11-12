package bingoGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BingoGui extends JFrame {

	private JPanel contentPane;
	private JButton[][] buttons = new JButton[5][5];
	private int[][] numbers;
	private int currentNumber = 9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int[][] nums = new int[5][5];
				for(int i = 0; i < 5; i++){
					for(int j = 0; j < 5; j++){
						
						nums[i][j] = (5 * i + 1) + j;
					}
				}
				try {
					
					BingoGui frame = new BingoGui(nums);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BingoGui(final int[][] numbers) {
		
		this.numbers = numbers;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(128, 128, 128));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(5, 5, 10, 10));

		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				
				final int y = i;
				final int x = j;
				buttons[i][j] = new JButton();
				panelMain.add(buttons[i][j]);
				buttons[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						String test = Integer.toString(numbers[y][x]);
						if(currentNumber == numbers[y][x])
							buttons[y][x].setText(test);
					}});
				
			}
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblB);

		JLabel lblI = new JLabel("I");
		lblI.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblI);

		JLabel lblN = new JLabel("N");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblN);

		JLabel lblG = new JLabel("G");
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblG);

		JLabel lblO = new JLabel("O");
		lblO.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblO);
	}
	
	public void setCurrentNumber(int newNumber){
		
		currentNumber = newNumber; 
	}

}

