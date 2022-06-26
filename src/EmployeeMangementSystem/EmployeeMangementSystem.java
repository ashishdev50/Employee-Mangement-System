package EmployeeMangementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;

import javax.swing.border.MatteBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeMangementSystem extends JFrame {

	private JPanel contentPane;
	private JTextField txtTxtname;
	private JTextField txtTxtsurname;
	private JTextField txtTxtmobno;
	private static JTextField txtTxtsalary;
	private JTable table;
	JLabel labelusername;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMangementSystem frame = new EmployeeMangementSystem();
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
	
	public EmployeeMangementSystem() throws Exception {
		
		
		
		
		

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		 labelusername = new JLabel();
		labelusername.setBounds(570, 78, 171, 28);
		contentPane.add(labelusername);
		
		JLabel lblNewLabel = new JLabel(" Name");
		lblNewLabel.setBounds(45, 134, 84, 28);
		contentPane.add(lblNewLabel);

		txtTxtname = new JTextField();
		txtTxtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtTxtsurname.requestFocus();
				}
			}
		});
		txtTxtname.setBounds(162, 139, 146, 28);
		contentPane.add(txtTxtname);
		txtTxtname.setColumns(10);

		JLabel lblSurname = new JLabel("username");
		lblSurname.setBounds(45, 220, 84, 28);
		contentPane.add(lblSurname);

		txtTxtsurname = new JTextField();
		txtTxtsurname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtTxtmobno.requestFocus();
				}
			}
		});
		txtTxtsurname.setColumns(10);
		txtTxtsurname.setBounds(162, 225, 146, 28);
		contentPane.add(txtTxtsurname);

		JLabel lblMobNo = new JLabel("password");
		lblMobNo.setBounds(45, 299, 84, 28);
		contentPane.add(lblMobNo);

		JLabel lblSalary = new JLabel("phone");
		lblSalary.setBounds(45, 369, 84, 28);
		contentPane.add(lblSalary);

		txtTxtmobno = new JTextField();
		txtTxtmobno.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtTxtsalary.requestFocus();
				}
			}
		});
		txtTxtmobno.setColumns(10);
		txtTxtmobno.setBounds(162, 304, 146, 28);
		contentPane.add(txtTxtmobno);

		txtTxtsalary = new JTextField();
		txtTxtsalary.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("enter key pressed");
					String ename, esurrname, emobno, esalary;

					ename = txtTxtname.getText();
					esurrname = txtTxtsurname.getText();
					emobno = txtTxtmobno.getText();
					esalary = txtTxtsalary.getText();

					try {
						parp = connection.prepareStatement(
								"insert into record (ename,esurrname,emobno,esalary) values (?,?,?,?)");
						parp.setString(1, ename);
						parp.setString(2, esurrname);
						parp.setString(3, emobno);
						parp.setString(4, esalary);

						parp.executeUpdate();
						JOptionPane.showMessageDialog(txtTxtsalary, "record save");
						System.out.println("record save");
						tableshow();

						txtTxtname.setText("");
						txtTxtsurname.setText("");
						txtTxtmobno.setText("");
						txtTxtsalary.setText("");
						txtTxtname.requestFocus();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
			
		});
		txtTxtsalary.setColumns(10);
		txtTxtsalary.setBounds(162, 370, 146, 28);
		contentPane.add(txtTxtsalary);

		JButton btnNewButton = new JButton("Save");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ename, esurrname, emobno, esalary;

				ename = txtTxtname.getText();
				esurrname = txtTxtsurname.getText();
				emobno = txtTxtmobno.getText();
				esalary = txtTxtsalary.getText();

				try {
					parp = connection
							.prepareStatement("insert into record (ename,esurrname,emobno,esalary) values (?,?,?,?)");
					parp.setString(1, ename);
					parp.setString(2, esurrname);
					parp.setString(3, emobno);
					parp.setString(4, esalary);

					parp.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "record save");
					System.out.println("record save");
					tableshow();

					txtTxtname.setText("");
					txtTxtsurname.setText("");
					txtTxtmobno.setText("");
					txtTxtsalary.setText("");
					txtTxtname.requestFocus();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
		});
		btnNewButton.setBounds(60, 443, 85, 21);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		scrollPane.setBounds(350, 89, 637, 375);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_DELETE) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectindex = table.getSelectedRow();
					int id = Integer.parseInt(model.getValueAt(selectindex, 0).toString());

					try {
						parp = connection.prepareStatement("delete from  record   where id =?");

						parp.setInt(1, id);

						parp.executeUpdate();
						JOptionPane.showMessageDialog(table, "delete");
						System.out.println("record update");

						tableshow();

						txtTxtname.setText("");
						txtTxtsurname.setText("");
						txtTxtmobno.setText("");
						txtTxtsalary.setText("");
						txtTxtname.requestFocus();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setToolTipText("");
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectindex = table.getSelectedRow();
				int id = Integer.parseInt(model.getValueAt(selectindex, 0).toString());
				txtTxtname.setText(model.getValueAt(selectindex, 1).toString());

				txtTxtsurname.setText(model.getValueAt(selectindex, 2).toString());

				txtTxtmobno.setText(model.getValueAt(selectindex, 3).toString());

				txtTxtsalary.setText(model.getValueAt(selectindex, 4).toString());
			}
		});
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", "", null, null, null},
			},
			new String[] {
				"id", "name", "username", "password", "email", "Phone", "AGDATE", "Gender"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(76);

		JButton btnNewButton_1 = new JButton("edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectindex = table.getSelectedRow();
				int id = Integer.parseInt(model.getValueAt(selectindex, 0).toString());

				String ename, esurrname, emobno, esalary;

				ename = txtTxtname.getText();
				esurrname = txtTxtsurname.getText();
				emobno = txtTxtmobno.getText();
				esalary = txtTxtsalary.getText();

				try {
					parp = connection.prepareStatement(
							"update  record set ename =?,esurrname=?,emobno=?,esalary=?  where id =?");
					parp.setString(1, ename);
					parp.setString(2, esurrname);
					parp.setString(3, emobno);
					parp.setString(4, esalary);
					parp.setInt(5, id);

					parp.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton_1, "recordupdate");
					System.out.println("record update");

					tableshow();

					txtTxtname.setText("");
					txtTxtsurname.setText("");
					txtTxtmobno.setText("");
					txtTxtsalary.setText("");
					txtTxtname.requestFocus();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(160, 443, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectindex = table.getSelectedRow();
				int id = Integer.parseInt(model.getValueAt(selectindex, 0).toString());

				try {
					parp = connection.prepareStatement("delete from  record   where id =?");

					parp.setInt(1, id);

					parp.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton_2, "delete");
					System.out.println("record update");

					tableshow();

					txtTxtname.setText("");
					txtTxtsurname.setText("");
					txtTxtmobno.setText("");
					txtTxtsalary.setText("");
					txtTxtname.requestFocus();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(255, 443, 85, 21);
		contentPane.add(btnNewButton_2);

	
		
	

		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setBounds(10, 10, 62, 30);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton_LogOut = new JButton("Logout");
		btnNewButton_LogOut.addActionListener(new ActionListener() {
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
						
					String	ipadd= address.getHostAddress();
						System.out.println(address.getHostAddress());
						
						 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system",
			                        "root", "1234");

						parp = connection.prepareStatement(
								"insert into login_detail (username,password,date_Time,Status,IP_Address,devicename) values (?,?,?,?,?,?)");
					;
					
					int username = 0;
					
					Login l = new Login();
		//	l.textField_username = username;
					
					
					parp.setString(1, l.username);
					parp.setString(2, "");
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

				else if (a == JOptionPane.NO_OPTION) {
					try {
						EmployeeMangementSystem employeeMangementSystem = new EmployeeMangementSystem();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					
					
				
					

				}
		

			}
		});
		btnNewButton_LogOut.setBounds(679, 15, 85, 21);
		contentPane.add(btnNewButton_LogOut);
		
	

		/////// jJCBC CODE

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_mangement_system", "root",
				"1234");
		System.out.println("connect");
		tableshow();

		

		
		
		
		
		
			
			
		
		
	}


	public void tableshow() throws Exception {

		int cc;
		parp = connection.prepareStatement("SELECT * FROM user;");

		ResultSet resultSet = parp.executeQuery();
		ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
		cc = rsmd.getColumnCount();
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(1);

		while (resultSet.next()) {

			Vector<String> v2 = new Vector<String>();

			for (int i = 1; i <= cc; i++) {
				v2.add(resultSet.getString("eid"));
				v2.add(resultSet.getString("name"));
				v2.add(resultSet.getString("username"));
				v2.add(resultSet.getString("password"));
				v2.add(resultSet.getString("email"));
				v2.add(resultSet.getString("phoneno"));
				v2.add(resultSet.getString("account_date_Time"));
				v2.add(resultSet.getString("gender"));

			}

			dft.addRow(v2);
		}

	}
}
