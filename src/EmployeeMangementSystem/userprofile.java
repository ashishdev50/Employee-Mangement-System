package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class userprofile extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_email;
	JLabel lblNewLabel_imagedisplay;

	JLabel lblNewLabel;
	JLabel lblProfile;
	JLabel lblName;
	JLabel lblProfile_2;
	JLabel lblProfile_1;
	JLabel lblProfile_3;
	JLabel lblNewLabel_Phone;
	JLabel lblNewLabel_Id;
	JLabel lblProfile_4;
	JLabel lblNewLabel_uname;
	JLabel lblNewLabel_fullname;
	static String inputtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userprofile frame = new userprofile();
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
	ResultSet rs;
	JButton btnNewButton;

	public userprofile() throws SQLException, Exception {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel_imagedisplay = new JLabel();
		lblNewLabel_imagedisplay.setBounds(587, 124, 307, 254);
		contentPane.add(lblNewLabel_imagedisplay);

		lblNewLabel_email = new JLabel("");
		lblNewLabel_email.setForeground(Color.BLACK);
		lblNewLabel_email.setBackground(Color.ORANGE);
		lblNewLabel_email.setBounds(216, 235, 375, 49);
		contentPane.add(lblNewLabel_email);

		lblNewLabel = new JLabel("ProfilePhoto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(587, 92, 124, 22);
		contentPane.add(lblNewLabel);

		lblProfile = new JLabel("Employee Profile");
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile.setBounds(349, 28, 208, 22);
		contentPane.add(lblProfile);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(29, 170, 124, 22);
		contentPane.add(lblName);

		lblProfile_2 = new JLabel("email");
		lblProfile_2.setBackground(Color.PINK);
		lblProfile_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile_2.setBounds(29, 249, 124, 22);
		contentPane.add(lblProfile_2);

		lblProfile_1 = new JLabel("Phone");
		lblProfile_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile_1.setBackground(Color.PINK);
		lblProfile_1.setBounds(29, 329, 124, 22);
		contentPane.add(lblProfile_1);

		lblProfile_3 = new JLabel("Id");
		lblProfile_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile_3.setBackground(Color.PINK);
		lblProfile_3.setBounds(29, 475, 124, 22);
		contentPane.add(lblProfile_3);

		lblNewLabel_Phone = new JLabel("eer");
		lblNewLabel_Phone.setForeground(Color.BLACK);
		lblNewLabel_Phone.setBackground(Color.ORANGE);
		lblNewLabel_Phone.setBounds(219, 319, 338, 49);
		contentPane.add(lblNewLabel_Phone);

		lblNewLabel_Id = new JLabel("");
		lblNewLabel_Id.setForeground(Color.BLACK);
		lblNewLabel_Id.setBackground(Color.ORANGE);
		lblNewLabel_Id.setBounds(216, 465, 210, 49);
		contentPane.add(lblNewLabel_Id);

		lblProfile_4 = new JLabel("username");
		lblProfile_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProfile_4.setBackground(Color.PINK);
		lblProfile_4.setBounds(29, 402, 124, 22);
		contentPane.add(lblProfile_4);

		lblNewLabel_uname = new JLabel("rrr");
		lblNewLabel_uname.setForeground(Color.BLACK);
		lblNewLabel_uname.setBackground(Color.ORANGE);
		lblNewLabel_uname.setBounds(216, 392, 307, 49);
		contentPane.add(lblNewLabel_uname);

		lblNewLabel_fullname = new JLabel("");
		lblNewLabel_fullname.setForeground(Color.BLACK);
		lblNewLabel_fullname.setBackground(Color.ORANGE);
		lblNewLabel_fullname.setBounds(216, 160, 307, 49);
		contentPane.add(lblNewLabel_fullname);

		btnNewButton = new JButton("LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
				// JOptionPane.setRootFrame(null);
				if (a == JOptionPane.YES_OPTION) {
					dispose();
					home_Page obj = new home_Page();
					obj.setTitle("Home Page");
					obj.setVisible(true);

					System.out.println("xnnx");
					String Status = "logout";

					try {
						java.util.Date date = new java.util.Date();

						Date sqldate = new java.sql.Date(date.getTime());
						long sec = System.currentTimeMillis();
						Timestamp timestamp = new Timestamp(sec);

						System.out.println(timestamp);
						InetAddress address = InetAddress.getLocalHost();
						String devicename = address.getHostName();
						System.out.println(address.getHostName());

						String ipadd = address.getHostAddress();
						System.out.println(address.getHostAddress());

						Connection connection = (Connection) DriverManager
								.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system", "root", "1234");

						parp = connection.prepareStatement(
								"insert into login_detail (username,password,date_Time,Status,IP_Address,devicename) values (?,?,?,?,?,?)");
						;

						int username = 0;

						Login l = new Login();
						// l.textField_username = username;

						parp.setString(1, l.username);
						parp.setString(2, l.pass);
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

				} else if (a == JOptionPane.NO_OPTION) {
					try {
						EmployeeMangementSystem employeeMangementSystem = new EmployeeMangementSystem();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(791, 32, 90, 30);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Support");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {


					System.out.println("dcer");
					Support sp = new Support();
					sp.setVisible(true);
					Login lg = new Login();
					sp.lblNewLabel_1_SuppName.setText(lg.Supportname);
					sp.lblNewLabel_SuppEmail.setText(lg.Supportemail);

					dispose();

				}

			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//////////////// support mail and name.///////////////

				Support sp = new Support();
				sp.setVisible(true);
				Login lg = new Login();
				sp.lblNewLabel_1_SuppName.setText(lg.Supportname);
				sp.lblNewLabel_SuppEmail.setText(lg.Supportemail);

				dispose();
			}
		});
		btnNewButton_1.setBounds(714, 479, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton ff = btnNewButton_1;

	}
}
