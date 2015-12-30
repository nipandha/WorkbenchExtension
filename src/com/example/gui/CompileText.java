package com.example.gui;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.*;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.example.util.Ppt;

import static javax.swing.ScrollPaneConstants.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class CompileText {

	private JFrame frame;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JScrollPane scrollPane_1,scrollPane_2,scrollPane_3;
	private JList fontList,fontHeadingList,fontTextList;
	private static String path;
	private List<String> must;
	private List<String> mustnot;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		path=args[0];
		//path="F:/IITB/Ocean currents";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompileText window = new CompileText();
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
	public CompileText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 564);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblCompileText = new JLabel("Compile Text");
		lblCompileText.setFont(new Font("Tahoma", Font.PLAIN, 21));
		springLayout.putConstraint(SpringLayout.NORTH, lblCompileText, 43, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCompileText, 36, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblCompileText);
		
		JLabel lblNewLabel = new JLabel("Output");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 71, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -237, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Standardize Font");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 28, SpringLayout.SOUTH, lblCompileText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblCompileText);
		frame.getContentPane().add(lblNewLabel_1);
		
		textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 150, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, frame.getContentPane());
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Headings");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblCompileText);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mandatory Headings");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -235, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -6, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblCompileText);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Headings Not Recommended");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, lblNewLabel_3);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 296, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblCompileText);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 32, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, textField, 61, SpringLayout.EAST, lblCompileText);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 117, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -118, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("+");
		springLayout.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, button, 6, SpringLayout.EAST, textField);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("+");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 6, SpringLayout.EAST, textField_1);
		frame.getContentPane().add(button_1);
		
		JTextArea textArea_1 = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea_1, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textArea_1, 0, SpringLayout.WEST, lblCompileText);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_1, 141, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, textArea_1, 0, SpringLayout.EAST, textField);
		frame.getContentPane().add(textArea_1);
		must = new ArrayList<String>();;
		must.add("Creative Commons License");
		must.add("Learning objectives");
		must.add("System requirements");
		must.add("Assignment");
		must.add("Acknowledgement");
		String res="";
		for(int i=0;i<must.size();i++)
		{
			res+=must.get(i);
			res+="\n";
		}
		textArea_1.setText(res); 
		
		JTextArea textArea_2 = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea_2, 6, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, textArea_2, 117, SpringLayout.EAST, textArea_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea_2, 141, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textArea_2, 291, SpringLayout.EAST, textArea_1);
		frame.getContentPane().add(textArea_2);
		mustnot = new ArrayList<String>();
		mustnot.add("Heading");
		mustnot.add("Enter text here");
		
		String res1="";
		for(int i=0;i<mustnot.size();i++)
		{
			res1+=mustnot.get(i);
			res1+="\n";
		}
		textArea_2.setText(res1);
		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String res=new Ppt(path).checkmustHeadings(must);
				textArea.append(res);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCheck, 6, SpringLayout.SOUTH, textArea_1);
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 0, SpringLayout.WEST, lblCompileText);
		frame.getContentPane().add(btnCheck);
		
		JButton btnCheck_1 = new JButton("Check");
		btnCheck_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res=new Ppt(path).checkmustnotHeadings(must);
				textArea.append(res);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCheck_1, 6, SpringLayout.SOUTH, textArea_2);
		springLayout.putConstraint(SpringLayout.WEST, btnCheck_1, 0, SpringLayout.WEST, textField_1);
		frame.getContentPane().add(btnCheck_1);
		
		JLabel lblNewLabel_5 = new JLabel("Font Type");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 18, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblCompileText);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Heading Size");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 6, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblCompileText);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Text Size");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 7, SpringLayout.SOUTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblCompileText);
		frame.getContentPane().add(lblNewLabel_7);
		

		JButton btnNewButton_1 = new JButton("Compile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String res=new Ppt(path).getBullets();
				textArea.setText(res);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);
		
		String fonts[] = 
      	      GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      String fontSize[]={"1","2","3","4","5","6","7","8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
      fontList = new JList(fonts);
      fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      fontList.setValueIsAdjusting(true);
      fontHeadingList = new JList(fontSize);
      fontTextList=new JList(fontSize);

      fontList.setVisibleRowCount(1);
      fontList.addListSelectionListener(new ListSelectionListener()
      {
  		
  		@Override
  		public void valueChanged(ListSelectionEvent e) {
  			String fontname=fontList.getSelectedValue().toString();
  			
  		}
      });
      fontHeadingList.setVisibleRowCount(1);
      fontHeadingList.setSelectedIndex(14);
      fontHeadingList.addListSelectionListener(new ListSelectionListener()
      {
  		
  		@Override
  		public void valueChanged(ListSelectionEvent e) {
  			String headingsize=fontHeadingList.getSelectedValue().toString();
  			
  		}
      });
      fontTextList.setVisibleRowCount(1);
      fontTextList.addListSelectionListener(new ListSelectionListener()
      {
  		
  		@Override
  		public void valueChanged(ListSelectionEvent e) {
  			String textsize=fontTextList.getSelectedValue().toString();
  			
  		}
      });
      scrollPane_1 = new JScrollPane(fontList);
      springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 2, SpringLayout.NORTH, lblNewLabel_5);
      springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 16, SpringLayout.EAST, lblNewLabel_5);

      scrollPane_1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane_2 = new JScrollPane(fontHeadingList);
      springLayout.putConstraint(SpringLayout.NORTH, scrollPane_2, 2, SpringLayout.NORTH, lblNewLabel_6);
      springLayout.putConstraint(SpringLayout.WEST, scrollPane_2, 32, SpringLayout.EAST, lblNewLabel_6);
      
      scrollPane_3 = new JScrollPane(fontTextList);
      springLayout.putConstraint(SpringLayout.NORTH, scrollPane_3, 2, SpringLayout.NORTH, lblNewLabel_7);
      springLayout.putConstraint(SpringLayout.WEST, scrollPane_3, 0, SpringLayout.WEST, scrollPane_2);
      
      frame.getContentPane().add(scrollPane_1);
      frame.getContentPane().add(scrollPane_2);
      frame.getContentPane().add(scrollPane_3);
      
      JButton btnApply = new JButton("Apply");
      btnApply.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String fontname=fontList.getSelectedValue().toString();
      		int heading=Integer.parseInt(fontHeadingList.getSelectedValue().toString());
      		int text=Integer.parseInt(fontTextList.getSelectedValue().toString());
      		new Ppt(path).adjustFont(fontname, heading,text);
      	}
      });
      springLayout.putConstraint(SpringLayout.NORTH, btnApply, 44, SpringLayout.SOUTH, scrollPane_1);
      springLayout.putConstraint(SpringLayout.EAST, btnApply, 0, SpringLayout.EAST, scrollPane_1);
      frame.getContentPane().add(btnApply);
	}
}
