package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

public class home_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_Page frame = new home_Page();
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

	public home_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Register");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Register register = new Register();
				register.show();
				dispose();

			}
		});
		rdbtnNewRadioButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Register register = new Register();
					register.show();
					dispose();

				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
		rdbtnNewRadioButton.setBounds(264, 218, 103, 21);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnLogin = new JRadioButton("Login");
		rdbtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Login l = new Login();
				l.show();
				dispose();
			}
		});
		rdbtnLogin.setVerticalAlignment(SwingConstants.TOP);
		rdbtnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnLogin.setBounds(440, 218, 103, 21);
		contentPane.add(rdbtnLogin);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ashish\\Downloads\\Free-Images-HD-Book-Wallpapers.jpg"));
		lblNewLabel.setBounds(26, 20, 961, 485);
		contentPane.add(lblNewLabel);

	}
}
