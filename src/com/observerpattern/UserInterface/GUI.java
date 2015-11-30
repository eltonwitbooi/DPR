package com.observerpattern.UserInterface;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.observerpattern.MovieRaterManager;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JList<String> list;
	protected JList<String> list_2;
	protected JTextPane textPane;

	protected MovieRaterManager mvr;
	private Actions act;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			GUI frame = this;
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public GUI(MovieRaterManager mvr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 441);

		this.act = new Actions();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);

		JMenuItem mntmUser = new JMenuItem("User");
		mnNew.add(mntmUser);

		JMenuItem mntmMedia = new JMenuItem("Media");
		mnNew.add(mntmMedia);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		list = new JList<>();
		list.setBounds(12, 47, 191, 137);
		panel.add(list);

		DefaultListModel<String> model = new DefaultListModel<>();

		for (int i = 0; i < mvr.getUsers().size(); i++) {
			model.addElement(mvr.getUsers().get(i).getEmail());
		}
		list.setModel(model);

		list_2 = new JList<>();

		list_2.setBounds(215, 47, 198, 137);
		panel.add(list_2);

		DefaultListModel<String> model2 = new DefaultListModel<>();
		for (int i = 0; i < mvr.getMedias().size(); i++) {
			model2.addElement(mvr.getMedias().get(i).getName());
		}

		// model2.addElement("AMedia/
		list_2.setModel(model2);

		JButton btnNewButton_1 = new JButton("Create an observer for user");
		btnNewButton_1.addMouseListener(this.act);
		btnNewButton_1.setBounds(12, 191, 401, 25);
		panel.add(btnNewButton_1);

		JLabel lblUsers = new JLabel("Users");
		lblUsers.setBounds(12, 20, 70, 15);
		panel.add(lblUsers);

		JLabel lblMovies = new JLabel("Medias (Movies, Audios...)");
		lblMovies.setBounds(215, 12, 198, 34);
		panel.add(lblMovies);

		JButton btnRemoveObserverFor = new JButton("Remove observer from user");
		btnRemoveObserverFor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mvr.removeObserverFromSubject(list.getSelectedValue(), list_2.getSelectedValue());
				textPane.setText(textPane.getText() + list.getSelectedValue() + " is NOT following"
						+ list_2.getSelectedValue() + ";\n");
			}
		});
		btnRemoveObserverFor.setBounds(12, 224, 401, 25);
		panel.add(btnRemoveObserverFor);

		textPane = new JTextPane();
		textPane.setBounds(12, 255, 399, 119);
		panel.add(textPane);

		this.mvr = mvr;

	}

	/**
	 * Follow action
	 */
	public class Actions extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			if (list.getSelectedIndex() != -1 || list_2.getSelectedIndex() != -1) {
				mvr.addObserverToSubject(list.getSelectedValue(), list_2.getSelectedValue());
				textPane.setText(textPane.getText() + list.getSelectedValue() + " is now following"
						+ list_2.getSelectedValue() + ";\n");
			} else {
				System.out.println("Please select two values");
			}

		}
	}
}
