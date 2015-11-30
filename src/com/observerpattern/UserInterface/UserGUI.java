package com.observerpattern.UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.observerpattern.IObserver;
import com.observerpattern.ISubject;
import com.observerpattern.IUser;
import com.observerpattern.MovieRaterManager;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTextArea;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblLastUpdate ;
	private JTextField textField;
	private JComboBox comboBox ;
	private JTextArea textArea;
	
	private IUser user;
	/**
	 * Launch the application.
	 */
	public void run(UserGUI frame) {
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public UserGUI(IUser user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMovies = new JLabel("Movies");
		lblMovies.setBounds(26, 12, 70, 15);
		contentPane.add(lblMovies);
		
		JButton btnNewButton_1 = new JButton("Grade");
		
		btnNewButton_1.setBounds(26, 83, 372, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblUser = new JLabel("User: " + user.getEmail());
		lblUser.setBounds(26, 120, 156, 15);
		contentPane.add(lblUser);
		
		lblLastUpdate = new JLabel("Last Update :");
		lblLastUpdate.setBounds(178, 120, 238, 15);
		contentPane.add(lblLastUpdate);
		
		comboBox = new JComboBox();
		comboBox.setBounds(26, 54, 177, 25);
	
		
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(215, 57, 183, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(26, 147, 381, 108);
		contentPane.add(textArea);
		
		this.user = user;
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String movieName = (String) comboBox.getSelectedItem();
				int grade = Integer.parseInt(textField.getText());
				//System.out.println(movieName);
				user.rate(movieName, grade);
				
			}
		});
	}
	
	public void notifyChange(ISubject s){
		String str = this.textArea.getText();
		this.textArea.setText(s.getName() + " has been rated." + str + " \n");
		lblLastUpdate.setText( lblLastUpdate.getText() + " : " + new Date().toString());
	}
	
	
	public void addMedia(String media){
		this.comboBox.addItem(media);
	}
	
	public void removeMedia(String media){
		this.comboBox.removeItem(media);
	}
}
