package com.example.gui;

import java.awt.EventQueue;

import com.example.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;



import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Narration {
	final int bufSize = 16384;


	private static String path,opt;  
	private JFrame frame;
	private JList slideList;
	private JScrollPane scrollPane_1;
	//private String[] notes=new String[20];
	private JTextArea textArea;
	private int slideno;
	private JButton btnNewButton;
	private JButton btnRecord;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		path=args[0];//"F:/IITB/Ocean currents";
		opt=args[1];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Narration window = new Narration();
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
	public Narration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 312);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 168, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 491, SpringLayout.WEST, frame.getContentPane());
		//textArea.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 34, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, 35, SpringLayout.WEST, frame.getContentPane());
		textArea.setWrapStyleWord(true);
                textArea.setText("");
		//textArea.setText(path);
		frame.getContentPane().add(textArea);
		//scrollPane_1.setVisible(false);
		if(opt.equals("2"))
		{
			
			//scrollPane_1.setVisible(true);
		}
		
		btnRecord = new JButton("Record");
		springLayout.putConstraint(SpringLayout.NORTH, btnRecord, 22, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, btnRecord, 35, SpringLayout.WEST, frame.getContentPane());
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int slideno = slideList.getSelectedIndex() +1;
				String slide=Integer.toString(slideno);
				String newpath=new File(path,"presentation").getAbsolutePath();
				SimpleSoundCapture.main(new String[]{newpath,slide});
				frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnRecord);
		String Slides[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	      slideList = new JList(Slides);
	      slideList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	      slideList.setValueIsAdjusting(true);


	      slideList.setVisibleRowCount(1);
	      slideList.addListSelectionListener(new ListSelectionListener()
	      {
	  		
	  		@Override
	  		public void valueChanged(ListSelectionEvent e) {
	  			
	  		}
	      });
	      scrollPane_1 = new JScrollPane(slideList);
	      springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 67, SpringLayout.NORTH, frame.getContentPane());
	      springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -10, SpringLayout.EAST, frame.getContentPane());
	      frame.getContentPane().add(scrollPane_1);
	      
	      btnNewButton = new JButton("Show for Slide:");
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		int slideno = slideList.getSelectedIndex() +1;
	      		try{
	      			
	      			String notes=new Ppt(path).getNotes(80,slideno);
	      			System.out.println(notes);
	      			//String slide=slideList.getSelectedValue().toString();
	      			textArea.setText(notes);
	      			
	      		}
				catch(Exception ex)
	      		{
					ex.printStackTrace();
	      		}
	      	
	  			
                                ///frame.getContentPane().add(textArea);
	      	}
	      });
	      springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 1, SpringLayout.NORTH, textArea);
	      springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, frame.getContentPane());
	      frame.getContentPane().add(btnNewButton);
	}

}