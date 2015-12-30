package com.example.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.example.util.Ppt;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ImageCheck {

	private JFrame frame;
	private JTextField textField;
	//private JTextField textField_1;
	private JTextArea textArea;
	private static String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		path=args[0];
		//path="F:/IITB/Ocean currents";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageCheck window = new ImageCheck();
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
	public ImageCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 376, 307);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Check Image Quality");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 25, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 20, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PPI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 27, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("300");
		springLayout.putConstraint(SpringLayout.WEST, textField, 18, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblNewLabel_1);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ppi=Integer.parseInt(textField.getText());
				String text=new Ppt(path).imageCheck(ppi);
				textArea.setText(text);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 28, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheck, 0, SpringLayout.SOUTH, lblNewLabel_1);
		frame.getContentPane().add(btnCheck);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 37, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 29, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -37, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, btnCheck);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
	}
}
