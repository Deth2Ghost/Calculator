package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JMenu;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class Calculator {
	String temp = "0";
	String displayT = "";
	double result = 0;
	double var1 = 0;
	double var2 = 0;
	String znak = "0";
	boolean flag = true;
	private JFrame frame;
	private JTextField display;
	private JTextField tempField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				frame.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						super.keyTyped(e);

						switch (e.getKeyChar()) {
						case 0:
							if (display.getText().charAt(0) == 0) {
								display.setText("0");
							} else {
								display.setText(displayT + "0");
							}
							break;
						case 1:
							display.setText(displayT + "1");
							break;
						case 2:
							display.setText(displayT + "2");
							break;
						case 3:
							display.setText(displayT + "3");
							break;
						case 4:
							display.setText(displayT + "4");
							break;
						case 5:
							display.setText(displayT + "5");
							break;
						case 6:
							display.setText(displayT + "6");
							break;
						case 7:
							display.setText(displayT + "7");
							break;
						case 8:
							display.setText(displayT + "8");
							break;
						case 9:
							display.setText(displayT + "9");
							break;

						}
					}
				});
			}
		});
		frame.setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440");

		frame.setBounds(100, 100, 303, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelVisible = new JPanel();
		frame.getContentPane().add(panelVisible, BorderLayout.NORTH);
		panelVisible.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		tempField = new JTextField();
		tempField.setEditable(false);
		panelVisible.add(tempField);
		tempField.setColumns(25);

		JPanel panelButtons = new JPanel();

		frame.getContentPane().add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(null);
		// Zapominanie
		JButton btnNewButton = new JButton("MC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 57, 60, 23);
		panelButtons.add(btnNewButton);

		JButton btnMr = new JButton("MR");
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMr.setBounds(80, 57, 60, 23);
		panelButtons.add(btnMr);

		JButton btnM = new JButton("M+");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnM.setBounds(150, 57, 60, 23);
		panelButtons.add(btnM);

		JButton btnM_1 = new JButton("M-");
		btnM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnM_1.setBounds(220, 57, 60, 23);
		panelButtons.add(btnM_1);
		// konec zapominanie
		// Znaki deystviya

		JButton button = new JButton("/");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				znak = "/";
				display.setText(znak);
				var1 = Double.parseDouble(temp);
				if (znak != "0"){
				tempField.setText(temp+znak+displayT);	
				}
				else{
				tempField.setText(temp + " / ");
				}

			}
		});
		button.setBounds(220, 137, 60, 23);
		panelButtons.add(button);

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				znak = "*";
				display.setText("X");
				var1 = Double.parseDouble(temp);
				if (znak != "0"){
				tempField.setText(temp+"X"+displayT);	
				}
				else{
				tempField.setText(temp + " X ");
				}

			}
		});
		btnX.setBounds(220, 171, 60, 23);
		panelButtons.add(btnX);

		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				znak = "-";
				display.setText(znak);
				var1 = Double.parseDouble(temp);
				if (znak != "0"){
				tempField.setText(temp+znak+displayT);	
				}
				else{
				tempField.setText(temp + " - ");
				}

			}
		});
		button_2.setBounds(220, 205, 60, 23);
		panelButtons.add(button_2);

		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				display.setText("+");
				znak = "+";
				
				var1 = Double.parseDouble(temp);
				if (znak != "0"){
				tempField.setText(temp+znak+displayT);	
				}
				else{
				tempField.setText(temp + " + ");
				}

			}
		});
		button_3.setBounds(220, 239, 60, 23);
		panelButtons.add(button_3);

		// konec znakov

		// Panel cifr
		JButton button_1 = new JButton("7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (temp == "0") {
					display.setText("7");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "7");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					
					display.setText(temp + "7");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_1.setBounds(10, 137, 60, 23);
		panelButtons.add(button_1);

		JButton button_4 = new JButton("8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("8");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "8");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "8");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_4.setBounds(80, 137, 60, 23);
		panelButtons.add(button_4);

		JButton button_5 = new JButton("9");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("9");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "9");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "9");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_5.setBounds(150, 137, 60, 23);
		panelButtons.add(button_5);

		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "6") {
					display.setText("6");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "6");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "6");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_6.setBounds(150, 171, 60, 23);
		panelButtons.add(button_6);

		JButton button_7 = new JButton("5");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("5");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "5");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}else{
					display.setText(temp + "5");
					temp = display.getText();
					tempField.setText(temp);
				}
				
			}
		});
		button_7.setBounds(80, 171, 60, 23);
		panelButtons.add(button_7);

		JButton button_8 = new JButton("4");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("4");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "4");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "4");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_8.setBounds(10, 171, 60, 23);
		panelButtons.add(button_8);

		JButton button_9 = new JButton("3");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("3");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "3");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "3");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_9.setBounds(150, 205, 60, 23);
		panelButtons.add(button_9);

		JButton button_10 = new JButton("2");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("2");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "2");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "2");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_10.setBounds(80, 205, 60, 23);
		panelButtons.add(button_10);

		JButton button_11 = new JButton("1");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("1");
					temp = display.getText();
					tempField.setText(temp);
				} 
				if (znak != "0"){
					display.setText(displayT + "1");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp + "1");
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_11.setBounds(10, 205, 60, 23);
		panelButtons.add(button_11);

		JButton button_12 = new JButton("0");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp == "0") {
					display.setText("0");
					temp = display.getText();
					
				} 
				if (znak != "0"){
					display.setText(displayT + "0");
					displayT = display.getText();
					tempField.setText(temp+znak+displayT);
				}
				else{
					display.setText(temp);
					temp = display.getText();
					tempField.setText(temp);
				}
			}
		});
		button_12.setBounds(80, 239, 60, 23);
		panelButtons.add(button_12);
		// konec cifr

		// ZApyataya, smena znaka, ravno

		JButton button_13 = new JButton(",");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_13.setBounds(10, 239, 60, 23);
		panelButtons.add(button_13);

		JButton button_14 = new JButton("\u2213");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_14.setBounds(220, 91, 60, 23);
		panelButtons.add(button_14);

		JButton button_15 = new JButton("=");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var1 = Double.parseDouble(temp);
				var2 = Double.parseDouble(displayT);
				switch(znak){
				case "+": result = var1 + var2;break;
				case "-": result = var1 - var2;break;
				case "*": result = var1 * var2;break;
				case "/": result = var1 / var2;break;
				default: break;
				}
				display.setText(Double.toString(result));

			}
		});
		button_15.setBounds(150, 239, 60, 23);
		panelButtons.add(button_15);
		// konec ZApyataya, smena znaka, ravno

		// Ochistit` poslednee, ochistit` vse, backspace
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCe.setBounds(10, 91, 60, 23);
		panelButtons.add(btnCe);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("0");
				tempField.setText("");
				temp = "0";
				displayT = "0";
				znak = "0";
			}
		});
		btnC.setBounds(80, 91, 60, 23);
		panelButtons.add(btnC);

		JButton button_16 = new JButton("\u21D0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_16.setBounds(150, 91, 60, 23);
		panelButtons.add(button_16);

		display = new JTextField();
		display.setBounds(10, 26, 270, 20);
		panelButtons.add(display);
		display.setColumns(30);
		display.setText("0");
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setEditable(false);
		// konec Ochistit` poslednee, ochistit` vse, backspace
	}
}
