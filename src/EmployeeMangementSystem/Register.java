package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.ImageView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.InetAddress;

import javax.imageio.IIOImage;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_email;
	private JTextField textField_phone;
	private JTextField textField_username;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	private JTextField textField_filepath;
	String Gender;
	String osName = System.getProperty("os.name");
	public static String username, pass, Status;
	public Register() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("register page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(259, 20, 352, 56);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(123, 132, 112, 38);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabelImage = new JLabel("");
		lblNewLabelImage.setForeground(Color.WHITE);
		lblNewLabelImage.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabelImage.setBackground(Color.BLUE);
		lblNewLabelImage.setBounds(664, 51, 310, 222);
		contentPane.add(lblNewLabelImage);

		JLabel lblNewLabel_1_1 = new JLabel("email");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(123, 200, 112, 38);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("username");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(123, 331, 112, 38);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("phone no");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(123, 271, 112, 38);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("password");
		lblNewLabel_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(123, 389, 112, 38);
		contentPane.add(lblNewLabel_1_1_3);

		textField_name = new JTextField();
		textField_name.setBounds(287, 135, 318, 38);
		contentPane.add(textField_name);
		textField_name.setColumns(10);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(287, 200, 318, 38);
		contentPane.add(textField_email);

		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(287, 274, 318, 38);
		contentPane.add(textField_phone);

		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(287, 343, 318, 38);
		contentPane.add(textField_username);

		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(287, 401, 318, 38);
		contentPane.add(textField_password);

		JButton btnNewButton = new JButton("register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, username, password, phoneno, email, male, female, image;

				name = textField_name.getText();
				username = textField_username.getText();
				password = textField_password.getText();
				phoneno = textField_phone.getText();

			
				image = textField_filepath.getText();
			//	image = image.replace("\\","\\\\");
				email = textField_email.getText();

				try {
					java.util.Date date = new java.util.Date();

					Date sqldate = new java.sql.Date(date.getTime());
					long sec = System.currentTimeMillis();
					Timestamp timestamp = new Timestamp(sec);
					System.out.println(timestamp);
					parp = connection.prepareStatement(
							"insert into user (username,password,name,email,phoneno,account_date_Time,images,gender) values (?,?,?,?,?,?,?,?)");
					parp.setString(3, name);
					parp.setString(1, username);
					parp.setString(2, password);
					parp.setString(5, phoneno);
					parp.setString(4, email);
					parp.setTimestamp(6, timestamp);
					parp.setString(7, image);
					parp.setString(8, Gender);
					parp.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "regi......");
					System.out.println("regi................");


					textField_name.requestFocus();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				System.out.println("xnnx");

				username = textField_username.getText();
				pass = textField_password.getText();
				Status = "Register";

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
					textField_name.setText("");
					textField_username.setText("");

					textField_password.setText("");

					textField_phone.setText("");

					textField_email.setText("");

					textField_name.requestFocus();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(214, 579, 112, 27);
		contentPane.add(btnNewButton);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Login");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Login login = new Login();
				login.show();
				dispose();
			}
		});
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		rdbtnNewRadioButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login login = new Login();
					login.show();
					dispose();
				}

			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(503, 582, 103, 21);
		contentPane.add(rdbtnNewRadioButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					home_Page home_Page = new home_Page();
					home_Page.show();
					dispose();
				
			}
		});
		lblNewLabel_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					home_Page home_Page = new home_Page();
					home_Page.show();
					dispose();
				}
				
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ashish\\Downloads\\icons8-left-arrow-50.png"));
		lblNewLabel_2.setBounds(33, 38, 52, 21);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Gender");
		lblNewLabel_1_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3_1.setBounds(123, 479, 112, 38);
		contentPane.add(lblNewLabel_1_1_3_1);

		JRadioButton rdbtnNewRadioButton_male = new JRadioButton("male");
		rdbtnNewRadioButton_male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gender ="male";
			}
		});
		rdbtnNewRadioButton_male.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_male.setBounds(263, 490, 103, 21);
		contentPane.add(rdbtnNewRadioButton_male);

		JRadioButton rdbtnNewRadioButton_1_female = new JRadioButton("female");
		rdbtnNewRadioButton_1_female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gender = "female";
			}
		});
		rdbtnNewRadioButton_1_female.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_female.setBounds(394, 490, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1_female);

		JButton btnNewButton_1 = new JButton("Attached Photo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
				
				
				
				
				   // TODO add your handling code here:
			       JFileChooser browseImageFile = new JFileChooser();
			       //Filter image extensions
			       FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
			       browseImageFile.addChoosableFileFilter(fnef);
			       int showOpenDialogue = browseImageFile.showOpenDialog(null);
			        
			       if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
			           File selectedImageFile = browseImageFile.getSelectedFile();
			           String filename = selectedImageFile.getAbsolutePath();
						textField_filepath.setText(filename);
			           //Display image on jlable
			           ImageIcon ii = new ImageIcon(filename);
//			           Resize image to fit jlabel
			           Image image = ii.getImage().getScaledInstance(lblNewLabelImage.getWidth(), lblNewLabelImage.getHeight(), Image.SCALE_SMOOTH);
			            
			           lblNewLabelImage.setIcon(new ImageIcon(image));
			       }
				
				
				
				
				
				
				
				
				
//				JFileChooser chooser = new JFileChooser();
//				
//				chooser.showOpenDialog(null);
//				File f = chooser.getSelectedFile();
//				String filename = f.getAbsolutePath();
//				textField_filepath.setText(filename);
//				Image getAbsoultePath = null;
//				ImageIcon icon = new ImageIcon(filename);
//
//				Image imageView = icon.getImage().getScaledInstance(Image.SCALE_SMOOTH, lblNewLabelImage.getWidth(),lblNewLabelImage.getHeight());
//				lblNewLabelImage.setIcon(new ImageIcon(imageView));
			}
		});
		btnNewButton_1.setBounds(796, 342, 155, 38);
		contentPane.add(btnNewButton_1);

		textField_filepath = new JTextField();
		textField_filepath.setBounds(777, 295, 174, 19);
		contentPane.add(textField_filepath);
		textField_filepath.setColumns(10);

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
