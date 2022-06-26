package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class Support extends JFrame  {

	private JPanel contentPane;
	private JTextField textField_quiey;
	JLabel lblNewLabel_SuppEmail;
	JLabel lblNewLabel_1_SuppName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Support frame = new Support();
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
	PreparedStatement parp;
	Connection connection;

	public Support() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			home_Page hp = new home_Page();
			hp.setVisible(true);
			dispose();
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(22, 33, 87, 31);
		contentPane.add(btnNewButton);

		textField_quiey = new JTextField();
		textField_quiey.setBounds(206, 348, 367, 87);
		contentPane.add(textField_quiey);
		textField_quiey.setColumns(10);

		lblNewLabel_SuppEmail = new JLabel();
		lblNewLabel_SuppEmail.setBounds(206, 243, 367, 42);
		contentPane.add(lblNewLabel_SuppEmail);

		lblNewLabel_1_SuppName = new JLabel();
		lblNewLabel_1_SuppName.setBounds(206, 167, 367, 42);
		contentPane.add(lblNewLabel_1_SuppName);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(lblNewLabel_2.getFont().deriveFont(lblNewLabel_2.getFont().getSize() + 8f));
		lblNewLabel_2.setBounds(22, 167, 103, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(lblNewLabel_2_1.getFont().deriveFont(lblNewLabel_2_1.getFont().getSize() + 8f));
		lblNewLabel_2_1.setBounds(22, 246, 103, 31);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Write Quirey Here");
		lblNewLabel_2_2.setFont(lblNewLabel_2_2.getFont().deriveFont(lblNewLabel_2_2.getFont().getSize() + 8f));
		lblNewLabel_2_2.setBounds(22, 307, 162, 127);
		contentPane.add(lblNewLabel_2_2);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String quirey;

				quirey = textField_quiey.getText();

				try {
					java.util.Date date = new java.util.Date();

					Date sqldate = new java.sql.Date(date.getTime());
					long sec = System.currentTimeMillis();
					Timestamp timestamp = new Timestamp(sec);
					System.out.println(timestamp);
					parp = connection.prepareStatement(
							"insert into quireyuser (name,email,quiery,datetime) values (?,?,?,?)");

					Login lg = new Login();
					parp.setString(1, lg.Supportname);
					parp.setString(2, lg.Supportemail);
					parp.setString(3, quirey);
					parp.setTimestamp(4, timestamp);
					parp.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "Quirey Submitted");
					System.out.println("regi................");

					textField_quiey.requestFocus();
					textField_quiey.setText("");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(271, 490, 112, 31);
		contentPane.add(btnNewButton_1);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system", "root",
					"1234");
			System.out.println("connect");

			// Date date = new Date();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
