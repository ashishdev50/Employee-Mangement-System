package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputFilter.Status;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	public static JTextField textField_username;
	public static JTextField passwordField;
	public static String photo;
	String password;
	String userName;
	String Fullname;
	static String Supportname;
	static String Supportemail;
	JButton logbtn;
	JButton ff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 * 
	 */

	PreparedStatement parp;
	Connection connection;
	String osName = System.getProperty("os.name");
	public static String username, pass, Status;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(316, 71, 242, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(169, 186, 101, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(169, 289, 101, 32);
		contentPane.add(lblNewLabel_1_1);

		textField_username = new JTextField();
		textField_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
					
					
				}

			}

		});
		textField_username.setBounds(299, 194, 210, 32);
		contentPane.add(textField_username);
		textField_username.setColumns(10);

		passwordField = new JTextField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				
					logbtn.doClick();
//		
					

				}

			}
		});
		passwordField.setColumns(10);
		passwordField.setBounds(299, 297, 210, 32);
		contentPane.add(passwordField);

		JButton ff = logbtn;
		logbtn = new JButton("Login");

		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userName = textField_username.getText();
				password = passwordField.getText();
				try {
					Connection connection = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system", "root", "1234");

					PreparedStatement st = (PreparedStatement) connection.prepareStatement(
							"Select username, password,email,phoneno, eid,name,images from user where username=? and password=?");

					st.setString(1, userName);
					st.setString(2, password);
					ResultSet rs = st.executeQuery();
					if (rs.next()) {

						if (username == "admin" || password == "pass") {

							EmployeeMangementSystem ah = new EmployeeMangementSystem();

							ah.setTitle("Welcome");
							ah.setVisible(true);
						} else {

						}

						userprofile us = new userprofile();

						Fullname = rs.getString("name");
						us.lblNewLabel_fullname.setText(Fullname);
						System.out.println(Fullname);
						Supportname = Fullname;

						String Phone = rs.getString("phoneno");
						us.lblNewLabel_Phone.setText(Phone);
						System.out.println(Phone);

						String Username = rs.getString("username");
						us.lblNewLabel_uname.setText(Username);
						System.out.println(Username);

						String ID = rs.getString("eid");
						us.lblNewLabel_Id.setText(ID);

						String email = rs.getString("email");
						System.out.println(email);
						us.lblNewLabel_email.setText(email);
						Supportemail = email;

						photo = rs.getString("images");
						System.out.println(photo);
						ImageIcon ii = new ImageIcon(photo);
//			           Resize image to fit jlabel
						Image image = ii.getImage().getScaledInstance(us.lblNewLabel_imagedisplay.getWidth(),
								us.lblNewLabel_imagedisplay.getHeight(), Image.SCALE_SMOOTH);

						us.lblNewLabel_imagedisplay.setIcon(new ImageIcon(image));
						// System.out.println(newiicon);

						//////////////// support mail and name.///////////////

						Support sp = new Support();
						String Supportname = rs.getString("name");
						sp.lblNewLabel_1_SuppName.setText(Supportname);

						us.setTitle("Welcome");
						us.setVisible(true);

						JOptionPane.showMessageDialog(logbtn, "You have successfully logged in");
						dispose();
					} else {
						JOptionPane.showMessageDialog(logbtn, "Wrong Username & Password");
					}
				} catch (Exception sqlException) {
					sqlException.printStackTrace();
				}

				System.out.println("xnnx");

				username = textField_username.getText();
				pass = passwordField.getText();
				Status = "login";

				try {
					java.util.Date date = new java.util.Date();

					Date sqldate = new java.sql.Date(date.getTime());
					long sec = System.currentTimeMillis();
					Timestamp timestamp = new Timestamp(sec);

					System.out.println(timestamp);
					InetAddress address = InetAddress.getLocalHost();

					String ipadd = address.getHostAddress();
					System.out.println(address.getHostAddress());

					String devicename = address.getHostName();
					System.out.println(address.getHostName());

					Connection connection = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system", "root", "1234");

					parp = connection.prepareStatement(
							"insert into login_detail (username,password,date_Time,Status,IP_Address,devicename) values (?,?,?,?,?,?)");

					parp.setString(1, username);
					parp.setString(2, password);
					parp.setString(4, Status);
					parp.setTimestamp(3, timestamp);
					parp.setString(5, ipadd);
					parp.setString(6, devicename);
					parp.executeUpdate();

					System.out.println(parp);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		logbtn.setBounds(213, 417, 119, 32);
		contentPane.add(logbtn);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Register ");
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
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(395, 421, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				home_Page hp = new home_Page();
				hp.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(34, 29, 87, 31);
		contentPane.add(btnNewButton);

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
