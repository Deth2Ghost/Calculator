package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class Calculator {
	String temp = "0";
	String displayT = "";
	String memoryPlus;
	String memoryMinus;
	double memory;
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
	public void initialize() {

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				frame.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyChar() == '7'){
							if (znak != "0") {
								display.setText(displayT + "7");
								displayT = display.getText();
								tempField.setText(temp + znak + displayT);
							}
							if (displayT == "" && temp != "0") {
								display.setText(temp + "7");
								temp = display.getText();
								tempField.setText(temp);
							}
							if (temp == "0") {
								display.setText("7");
								temp = display.getText();
								tempField.setText(temp);
							}
						}
					}
				});
			}
		});
		
	
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Calculator.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		frame.setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440");
		frame.setResizable(false);
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
				memory = 0;
				memoryMinus = "";
				memoryPlus = "";
			}
		});
		btnNewButton.setBounds(10, 57, 60, 23);
		panelButtons.add(btnNewButton);

		JButton btnMr = new JButton("MR");
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (memory != 0){
				if (znak != "0"){
					if (memory%1 > 0){
					displayT=Double.toString(memory);
					}else{
						displayT=Integer.toString((int) memory);
					}
					display.setText(displayT);
					tempField.setText(temp+znak+displayT);
				}else{
					if (memory%1 > 0){
						temp=Double.toString(memory);
						}else{
							temp=Integer.toString((int) memory);
						}
					display.setText(temp);
					tempField.setText(temp);
					}
				temp="0";
				displayT="";
			}}
		});
		btnMr.setBounds(80, 57, 60, 23);
		panelButtons.add(btnMr);

		JButton btnM = new JButton("M+");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak != "0"){
					memoryPlus=displayT;
					
				}else{
					memoryPlus=temp;
				}
				memory = memory + Double.parseDouble(memoryPlus);
			}
		});
		btnM.setBounds(150, 57, 60, 23);
		panelButtons.add(btnM);

		JButton btnM_1 = new JButton("M-");
		btnM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak != "0"){
					memoryMinus=Double.toString(Math.abs(Double.parseDouble(displayT)));
				}else{
					memoryMinus=Double.toString(Math.abs(Double.parseDouble(temp)));;
				}
				memory = memory - Double.parseDouble(memoryMinus);
			}
		});
		btnM_1.setBounds(220, 57, 60, 23);
		panelButtons.add(btnM_1);
		// konec zapominanie
		// Znaki deystviya

		JButton button = new JButton("/");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak == "/" || znak == "*" || znak == "-" || znak == "+"){
					var1 = Double.parseDouble(temp);
					var2 = Double.parseDouble(displayT);
					switch (znak) {
					case "+":
						result = var1 + var2;
						break;
					case "-":
						result = var1 - var2;
						break;
					case "*":
						result = var1 * var2;
						break;
					case "/":
						result = var1 / var2;
						break;
					default:
						break;
					}
					if (result%1>0){
					temp = Double.toString(result);
					}else{
						temp = Integer.toString((int)result);	
					}
					displayT = "";
				}
				znak = "/";
				display.setText(znak);
				
				if (result != 0 && temp == "0") {
					display.setText(Double.toString(result));
					temp = display.getText();
				}
				if (znak != "0" && znak != "/" && znak != "*" && znak != "-" && znak != "+") {
					tempField.setText(temp + znak + displayT);
				} else {
					tempField.setText(temp + znak);
				}
				

			}
		});
		button.setBounds(220, 137, 60, 23);
		panelButtons.add(button);

		JButton btnX = new JButton("*");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak == "/" || znak == "*" || znak == "-" || znak == "+"){
					var1 = Double.parseDouble(temp);
					var2 = Double.parseDouble(displayT);
					switch (znak) {
					case "+":
						result = var1 + var2;
						break;
					case "-":
						result = var1 - var2;
						break;
					case "*":
						result = var1 * var2;
						break;
					case "/":
						result = var1 / var2;
						break;
					default:
						break;
					}
					if (result%1>0){
					temp = Double.toString(result);
					}else{
						temp = Integer.toString((int)result);	
					}
					displayT = "";
				}
				znak = "*";
				display.setText(znak);
				
				if (result != 0 && temp == "0") {
					display.setText(Double.toString(result));
					temp = display.getText();
				}
				if (znak != "0") {
					tempField.setText(temp + znak + displayT);
				} else {
					tempField.setText(temp + znak);
				}
			}
		});
		btnX.setBounds(220, 171, 60, 23);
		panelButtons.add(btnX);

		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak == "/" || znak == "*" || znak == "-" || znak == "+"){
					var1 = Double.parseDouble(temp);
					var2 = Double.parseDouble(displayT);
					switch (znak) {
					case "+":
						result = var1 + var2;
						break;
					case "-":
						result = var1 - var2;
						break;
					case "*":
						result = var1 * var2;
						break;
					case "/":
						result = var1 / var2;
						break;
					default:
						break;
					}
					if (result%1>0){
					temp = Double.toString(result);
					}else{
						temp = Integer.toString((int)result);	
					}
					displayT = "";
				}
				znak = "-";
				display.setText(znak);
				
				if (result != 0 && temp == "0") {
					display.setText(Double.toString(result));
					temp = display.getText();
				}
				if (znak != "0") {
					tempField.setText(temp + znak + displayT);
				} else {
					tempField.setText(temp + znak);
				}

			}
		});
		button_2.setBounds(220, 205, 60, 23);
		panelButtons.add(button_2);

		JButton button_3 = new JButton("+");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak == "/" || znak == "*" || znak == "-" || znak == "+"){
					var1 = Double.parseDouble(temp);
					var2 = Double.parseDouble(displayT);
					switch (znak) {
					case "+":
						result = var1 + var2;
						break;
					case "-":
						result = var1 - var2;
						break;
					case "*":
						result = var1 * var2;
						break;
					case "/":
						result = var1 / var2;
						break;
					default:
						break;
					}
					if (result%1>0){
					temp = Double.toString(result);
					}else{
						temp = Integer.toString((int)result);	
					}
					displayT = "";
				}
				znak = "+";
				display.setText(znak);
				
				if (result != 0 && temp == "0") {
					display.setText(Double.toString(result));
					temp = display.getText();
				}
				if (znak != "0") {
					tempField.setText(temp + znak + displayT);
				} else {
					tempField.setText(temp + znak);
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
				if (znak != "0") {
					display.setText(displayT + "7");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "7");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("7");
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
				if (znak != "0") {
					display.setText(displayT + "8");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "8");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("8");
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
				if (znak != "0") {
					display.setText(displayT + "9");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "9");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("9");
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
				if (znak != "0") {
					display.setText(displayT + "6");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "6");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("6");
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
				if (znak != "0") {
					display.setText(displayT + "5");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "5");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("5");
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
				if (znak != "0") {
					display.setText(displayT + "4");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "4");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("4");
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
				if (znak != "0") {
					display.setText(displayT + "3");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "3");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("3");
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
				if (znak != "0") {
					display.setText(displayT + "2");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "2");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("2");
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
				if (znak != "0") {
					display.setText(displayT + "1");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "1");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText("1");
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
				if (znak != "0") {
					display.setText(displayT + "0");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);
				}
				if (displayT == "" && temp != "0") {
					display.setText(temp + "0");
					temp = display.getText();
					tempField.setText(temp);
				}
				if (temp == "0") {
					display.setText(temp);
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
				if (znak != "0" && display.getText().charAt(display.getText().length() - 1) != '.') {
					if (displayT == "") {
						displayT = "0";
					}
					display.setText(displayT + ".");
					displayT = display.getText();
					tempField.setText(temp + znak + displayT);

				}
				if (displayT == "" && temp != "0" && display.getText().charAt(display.getText().length() - 1) != '.') {
					display.setText(temp + ".");
					temp = display.getText();
					tempField.setText(temp);

				}
				if (temp == "0" && display.getText().charAt(display.getText().length() - 1) != '.') {
					display.setText(temp + ".");
					temp = display.getText();
					tempField.setText(temp);

				}
			}
		});
		button_13.setBounds(10, 239, 60, 23);
		panelButtons.add(button_13);
		// Knopka +-
		JButton button_14 = new JButton("\u2213");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak != "0") {
					if (displayT.charAt(0) == '-'){
						double minus;
						minus = Math.abs(Double.parseDouble(displayT));
						displayT = Double.toString(minus);
						display.setText(displayT);
						tempField.setText(temp + znak + displayT);
					}else{
					if (displayT.charAt(0) != '-' && displayT.charAt(0) != '0' && displayT != "") {
					String minus;
					minus = "-" + displayT;
					displayT = minus;
					display.setText(displayT);
					tempField.setText(temp + znak + displayT);
				}
					}
				} else {
					if (temp.charAt(0) == '-' ){
						int i = -1;
						String Ltemp = Double.toString((Double.parseDouble(temp)*i));
						temp = Ltemp;
						display.setText(temp);
						tempField.setText(temp);
					}else{
						if ( temp !="0"){
						String minus;
						minus = "-" + temp;
						temp = minus;
						display.setText(temp);
						tempField.setText(temp);
					}}
					
				}
			}
		});
		button_14.setBounds(220, 91, 60, 23);
		panelButtons.add(button_14);

		JButton button_15 = new JButton("=");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var1 = Double.parseDouble(temp);
				var2 = Double.parseDouble(displayT);
				switch (znak) {
				case "+":
					result = var1 + var2;
					break;
				case "-":
					result = var1 - var2;
					break;
				case "*":
					result = var1 * var2;
					break;
				case "/":
					result = var1 / var2;
					break;
				default:
					break;
				}
				if (result%1 > 0){
					display.setText(Double.toString(result));
					tempField.setText(temp + znak + displayT + "=" + Double.toString(result));
					}else{
						display.setText(Integer.toString((int) result));
						tempField.setText(temp + znak + displayT + "=" + (Integer.toString((int) result)));
					}
				
				znak = "0";
				temp = "0";
				displayT = "";

			}
		});
		button_15.setBounds(150, 239, 60, 23);
		panelButtons.add(button_15);
		// konec ZApyataya, smena znaka, ravno

		// Ochistit` poslednee, ochistit` vse, backspace
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(znak !="0"){
						displayT = "";
						tempField.setText(temp+znak+displayT);
						display.setText("0");
				}else{
					temp = "0";
					tempField.setText("");
					display.setText("0");
				}
			}
		});
		btnCe.setBounds(80, 91, 60, 23);
		panelButtons.add(btnCe);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("0");
				tempField.setText("");
				temp = "0";
				displayT = "";
				znak = "0";
				result = 0;
			}
		});
		btnC.setBounds(10, 91, 60, 23);
		panelButtons.add(btnC);
		// Backspace
		JButton button_16 = new JButton("\u21D0");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (znak != "0" && displayT != ""){
					displayT = displayT.substring(0, displayT.length()-1);;
					display.setText(displayT);
					tempField.setText(temp+znak+displayT);
				}else{
					temp = temp.substring(0, temp.length()-1);
					display.setText(temp);
					tempField.setText(temp);
				}
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
