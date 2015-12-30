package com.example.gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class AddNarration {

	private JFrame frame;
	private JRadioButton wordButton,noneButton,noteButton;
	public static String path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		path=args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNarration window = new AddNarration();
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
	public AddNarration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Add Narration");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 32, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 35, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Retrieve Speaker's Notes From:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 35, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		
		wordButton = new JRadioButton("Retrieve from Document");
		springLayout.putConstraint(SpringLayout.NORTH, wordButton, 16, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, wordButton, 0, SpringLayout.WEST, lblNewLabel);
	    wordButton.setMnemonic(KeyEvent.VK_B);
	    wordButton.setActionCommand("Retrieve from Word Document");
	    wordButton.setSelected(true);
	    wordButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //textField.setEditable(true);

	        }
	    });


	    noteButton = new JRadioButton("Retrieve from Speaker's Notes");
	    springLayout.putConstraint(SpringLayout.NORTH, noteButton, 5, SpringLayout.SOUTH, wordButton);
	    springLayout.putConstraint(SpringLayout.WEST, noteButton, 0, SpringLayout.WEST, lblNewLabel);
	    noteButton.setMnemonic(KeyEvent.VK_C);
	    noteButton.setActionCommand("Retrieve from Speaker's Notes");
	    noteButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //textField.setEditable(true);

	        }
	    });
	    
	    
	    noneButton = new JRadioButton("No Thanks");
	    springLayout.putConstraint(SpringLayout.NORTH, noneButton, 8, SpringLayout.SOUTH, noteButton);
	    springLayout.putConstraint(SpringLayout.WEST, noneButton, 0, SpringLayout.WEST, lblNewLabel);
	    noneButton.setMnemonic(KeyEvent.VK_D);
	    noneButton.setActionCommand("No Thanks");
	    noneButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //textField.setEditable(true);

	        }
	    });
	    
		ButtonGroup group = new ButtonGroup();
	    group.add(wordButton);
	    group.add(noteButton);
	    group.add(noneButton);
	    
	    frame.getContentPane().add(wordButton);
	    frame.getContentPane().add(noteButton);
	    frame.getContentPane().add(noneButton);
	    
	    JButton btnNewButton = new JButton("Next");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String opt="1";
	    		if(wordButton.isSelected())
	    		{
	    			opt="1";
	    		}
	    		else if(noteButton.isSelected())
	    		{
	    			opt="2";
	    		}
	    		else if(noneButton.isSelected())
	    		{
	    			opt="3";
	    		}
	    		Narration.main(new String[]{path,opt});
	    		
	    	}
	    });
	    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -30, SpringLayout.SOUTH, frame.getContentPane());
	    springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -69, SpringLayout.EAST, frame.getContentPane());
	    frame.getContentPane().add(btnNewButton);

	}

}
