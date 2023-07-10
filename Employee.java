import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;
import java.awt.Color;
import java.awt.SystemColor;

public class Employee {

	private static final int JOptionPane_OK_Option = 0;
	private JFrame frame;
	private JTextField jtxtEmpID;
	private JTable table;
	private JTextField jtxtfn;
	private JTextField jtxtsn;
	private JTextField jtxtgen;
	private JTextField jtxtmob;
	private JTextField jtxsal;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public void updateTable() {
		conn = EmployeeData.ConnectDB();
		if (conn != null) {
			String sql = "Select Employee ID, First Name, Surname, Gender, Mobile Number, Salary";
	    
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Object[] columnData = new Object[6];
			while(rs.next()) {
				columnData [0] = rs.getString("Employee ID");
				columnData [1] = rs.getString("Employee ID");
				columnData [2] = rs.getString("Employee ID");
				columnData [3] = rs.getString("Employee ID");
				columnData [4] = rs.getString("Employee ID");
				columnData [5] = rs.getString("Employee ID");
				
				model.addRow(columnData);
			}
			}
		catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
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
	public Employee() {
		initialize();
		conn = EmployeeData.ConnectDB();
		Object col[] = {"Employee ID", "First Name", "Surname", "Gender", "Mobile Number", "Salary"};
		model.setColumnIdentifiers(col);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLUE);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.setBounds(0, 0, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 68, 115, 30);
		frame.getContentPane().add(lblNewLabel);
		
		jtxtEmpID = new JTextField();
		jtxtEmpID.setForeground(Color.BLACK);
		jtxtEmpID.setBackground(Color.WHITE);
		jtxtEmpID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtEmpID.setBounds(221, 67, 178, 33);
		frame.getContentPane().add(jtxtEmpID);
		jtxtEmpID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(459, 121, 503, 335);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "First Name", "Surname", "Gender", "Mobile No", "Salary"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(64, 122, 115, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		jtxtfn = new JTextField();
		jtxtfn.setForeground(Color.BLACK);
		jtxtfn.setBackground(Color.WHITE);
		jtxtfn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtfn.setColumns(10);
		jtxtfn.setBounds(221, 121, 178, 33);
		frame.getContentPane().add(jtxtfn);
		
		JLabel lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(64, 175, 115, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		jtxtsn = new JTextField();
		jtxtsn.setForeground(Color.BLACK);
		jtxtsn.setBackground(Color.WHITE);
		jtxtsn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtsn.setColumns(10);
		jtxtsn.setBounds(221, 174, 178, 33);
		frame.getContentPane().add(jtxtsn);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(64, 232, 115, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		jtxtgen = new JTextField();
		jtxtgen.setForeground(Color.BLACK);
		jtxtgen.setBackground(Color.WHITE);
		jtxtgen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtgen.setColumns(10);
		jtxtgen.setBounds(221, 231, 178, 33);
		frame.getContentPane().add(jtxtgen);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile Number");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(64, 288, 115, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		jtxtmob = new JTextField();
		jtxtmob.setForeground(Color.BLACK);
		jtxtmob.setBackground(Color.WHITE);
		jtxtmob.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxtmob.setColumns(10);
		jtxtmob.setBounds(221, 287, 178, 33);
		frame.getContentPane().add(jtxtmob);
						
		JLabel lblNewLabel_5 = new JLabel("Salary");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(64, 345, 115, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		jtxsal = new JTextField();
		jtxsal.setForeground(Color.BLACK);
		jtxsal.setBackground(Color.WHITE);
		jtxsal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtxsal.setColumns(10);
		jtxsal.setBounds(221, 344, 178, 33);
		frame.getContentPane().add(jtxsal);
		
		JButton btnAdd = new JButton("Add to Database");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT into employee(Employee ID, First Name, Surname, Gender, Mobile Number, Salary)"
						+ "VALUES(?, ?, ?, ?, ?, ?)";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,  jtxtEmpID.getText());
					pst.setString(2,  jtxtfn.getText());
					pst.setString(3,  jtxtsn.getText());
					pst.setString(4,  jtxtgen.getText());
					pst.setString(5,  jtxtmob.getText());
					pst.setString(6,  jtxsal.getText());
					
					pst.execute();
					
					rs.close();
					pst.close();
				}
				catch(Exception ev) {
					JOptionPane.showMessageDialog(null, "System will be updated.");
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						jtxtEmpID.getText(),
						jtxtfn.getText(),
						jtxtsn.getText(),
						jtxtgen.getText(),
						jtxtmob.getText(),
						jtxsal.getText()						
				});
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Membership Update Confirmed", "Employee Management System", 
								JOptionPane.OK_OPTION);
					}
				}
					String mobno = jtxtmob.getText();
					if (mobno.length() == 10) {
						jtxtmob.setBackground(Color.green);
					}
					else {
						jtxtmob.setBackground(Color.red);
					}
					String fname = jtxtfn.getText();
					char a[] = fname.toCharArray();
					for(int i = 0; i <= fname.length(); i++) {
					   char b = a[i];
					   if ((b >= 'A' && b <= 'Z') ||( b >= 'a' && b <= 'z')) {
						   jtxtfn.setBackground(Color.green);
					}
					   else {
							jtxtfn.setBackground(Color.red);
							JOptionPane.showMessageDialog(frame,  "Enter valid data", "Employee Management System", JOptionPane_OK_Option );
						}
					   }
					String sname = jtxtsn.getText();
					char c[] = sname.toCharArray();
					for(int i = 0; i <= sname.length(); i++) {
					   char d = c[i];
					   if ((d >= 'A' && d <= 'Z') ||( d >= 'a' && d <= 'z')) {
						   jtxtsn.setBackground(Color.green);
					}
					   else {
							jtxtsn.setBackground(Color.red);
							JOptionPane.showMessageDialog(frame,  "Enter valid data", "Employee Management System", JOptionPane_OK_Option );
						}
					   }
				}		
		});
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdd.setBounds(64, 503, 189, 42);
		frame.getContentPane().add(btnAdd);		
		JButton btnPrint = new JButton("Print Data");
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setForeground(Color.BLACK);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in Progress.");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				try {
					table.print();
				}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("No Printer available", ev.getMessage());
				}			
			}
		});
		btnPrint.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPrint.setBounds(289, 503, 183, 42);
		frame.getContentPane().add(btnPrint);
		
		JButton btnReset = new JButton("Reset ");
		btnReset.setBackground(Color.WHITE);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtEmpID.setText(null);
				jtxtfn.setText(null);
				jtxtsn.setText(null);
				jtxtgen.setText(null);
				jtxtmob.setText(null);
				jtxsal.setText(null);
			}
		});
		btnReset.setBounds(508, 503, 178, 42);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(Color.BLACK);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Do you want to Exit?", "Employee Management Sytem", 
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExit.setBounds(719, 503, 178, 42);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_6 = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		lblNewLabel_6.setBackground(Color.RED);
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setBounds(121, 10, 610, 35);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
