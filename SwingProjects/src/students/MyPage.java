package students;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import StudentManagement.landingPage;

import javax.swing.ListSelectionModel;

public class MyPage {

	private JFrame frame;
     private Connection conn;
     private PreparedStatement ps;
     private ResultSet rs;
     private JTextField textField;
     private JTextField textField_1;
     private JTextField textField_2;
     private JTextField textField_3;
     private JTextField textField_4;
     private JTextField textField_5;
     private JTextField textField_6;
     private JTextField textField_7;
     private JTextField textField_8;
     private JTable table;
     DefaultTableModel model;
     private JTextField textField_9;
     private JTextField textField_10;
     private JTextField textField_11;
     private JTextField textField_12;
     private JTextField textField_13;
     String h=null;
	/**
	 * Launch the application.
	 */
   public void updatePin()
   {
	  SendingEmail ema=new SendingEmail(h);
   }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage window = new MyPage();
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
	public MyPage() {
		initialize();
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color c=new Color(174,67,154);
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\imagesandicons\\Shahjalal_University_of_Science_and_Technology_logo.png"));
		Color c1=new Color(220,62,121);
		frame.getContentPane().setBackground(c);
		frame.setVisible(true);
		frame.setBounds(400, 100, 1287, 866);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SUST STUDENT MANAGEMNT");
		lblNewLabel.setIcon(new ImageIcon("F:\\imagesandicons\\Shahjalal_University_of_Science_and_Technology_logo.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(207, 44, 779, 111);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 255, 255));
		tabbedPane.setBounds(22, 190, 1235, 538);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(c1);
		tabbedPane.addTab("Infromation", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1.setBounds(162, 75, 122, 36);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField.setBounds(296, 75, 233, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.setBackground(c);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Information where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, textField.getText());
			rs=ps.executeQuery();
			if(rs.next()) {
	        	String add1=rs.getString("name");
		textField_1.setText(add1);
			String add2=rs.getString("fan");
			textField_2.setText(add2);
			add2=rs.getString("man");
			textField_3.setText(add2);
			add2=rs.getString("dob");
			textField_4.setText(add2);
			add2=rs.getString("email");
			textField_5.setText(add2);
			add2=rs.getString("roll");
			textField_9.setText(add2);
			add2=rs.getString("mob");
			textField_7.setText(add2);
			add2=rs.getString("gender");
			textField_6.setText(add2);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter Correct Acc Number");
			}
			}catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null,ae);
		}	
		}
			
		});
		btnNewButton.setBounds(406, 124, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(245, 255, 250));
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName.setBounds(162, 172, 122, 36);
		panel.add(lblName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(new Color(245, 255, 250));
		lblDob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDob.setBounds(162, 264, 122, 36);
		panel.add(lblDob);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(245, 255, 250));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblFathersName.setBounds(119, 354, 165, 36);
		panel.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setForeground(new Color(245, 255, 250));
		lblMothersName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMothersName.setBounds(101, 434, 183, 36);
		panel.add(lblMothersName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(245, 255, 250));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblEmail.setBounds(745, 63, 122, 36);
		panel.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(245, 255, 250));
		lblGender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGender.setBounds(745, 128, 122, 36);
		panel.add(lblGender);
		
		JLabel lblRoll = new JLabel("Phone");
		lblRoll.setForeground(new Color(245, 255, 250));
		lblRoll.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRoll.setBounds(745, 211, 122, 36);
		panel.add(lblRoll);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(296, 183, 233, 36);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(296, 275, 233, 36);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setForeground(Color.BLACK);
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(296, 365, 233, 36);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(296, 434, 233, 36);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setForeground(Color.BLACK);
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(894, 63, 266, 36);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setForeground(Color.BLACK);
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_6.setColumns(10);
		textField_6.setBounds(894, 140, 266, 36);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setForeground(Color.BLACK);
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_7.setColumns(10);
		textField_7.setBounds(894, 222, 266, 36);
		panel.add(textField_7);
		
		JLabel lblRoll_1 = new JLabel("Roll");
		lblRoll_1.setForeground(new Color(245, 255, 250));
		lblRoll_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRoll_1.setBounds(745, 319, 122, 36);
		panel.add(lblRoll_1);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.BLACK);
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(894, 319, 266, 36);
		panel.add(textField_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(c1);
		tabbedPane.addTab("Result", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Result where id=?";
				try {
					ps=conn.prepareStatement(sql);
				ps.setString(1, textField_8.getText());
					rs=ps.executeQuery();
					if(rs.next())
					{
						
				//	table.setBounds(45, 162, 1151, 301);
				    String s=rs.getString("Math");
				    String row[]=new String[7];
				    row[0]=s;
				    s=rs.getString("Java");
				    row[1]=s;
				    s=rs.getString("Physics");
				    row[2]=s;
				    s=rs.getString("English");
				    row[3]=s;
				    s=rs.getString("Cprog");
				    row[4]=s;
				    s=rs.getString("Cse");
				    row[5]=s;
				    s=rs.getString("id");
				    row[6]=s;
				    model.addRow(row);
				    
				    
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Correct User id");
					}
				}catch(Exception ae) {
					
				}
			}
		});
		button.setForeground(new Color(245, 255, 250));
		button.setBackground(new Color(174, 67, 154));
		button.setBounds(645, 73, 97, 25);
		panel_1.add(button);
		
		JLabel label = new JLabel("User ID:");
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(204, 60, 122, 36);
		panel_1.add(label);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(0, 0, 0));
		textField_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_8.setColumns(10);
		textField_8.setBounds(328, 62, 165, 36);
		panel_1.add(textField_8);
		
		table = new JTable();
		table.setForeground(new Color(255, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,13));
		
		String col[]= {"Math","Java","Physics","English","C Programming","Cse","Id"};
		model=new DefaultTableModel();
	//	model =new DefaultTableModel();
		model.setColumnIdentifiers(col);
         table.setModel(model);
		table.setSelectionBackground(Color.GREEN);
		table.setBackground(Color.CYAN);
		//table.setFont(f);
		JScrollPane jsp=new JScrollPane(table);
   ///	model.setFont(f);
		jsp.setBounds(45, 162, 1151, 301);
		table.setRowHeight(50);
		//table.setLayout(flow);
		panel_1.add(jsp);
		
		//panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		tabbedPane.addTab("BankAccount", null, panel_2, null);
		panel_2.setBackground(c1);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LogIn to your bank account here");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setBounds(239, 189, 410, 41);
		panel_2.add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				landingPage ob=new landingPage();
				
			}
		});
		btnLogin.setForeground(new Color(245, 255, 250));
		btnLogin.setBackground(new Color(174, 67, 154));
		btnLogin.setBounds(685, 201, 97, 25);
		panel_2.add(btnLogin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(c1);
		tabbedPane.addTab("ChangePin", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("User ID:");
		label_1.setForeground(new Color(245, 255, 250));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(187, 81, 122, 36);
		panel_3.add(label_1);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.BLACK);
		textField_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_10.setColumns(10);
		textField_10.setBounds(321, 81, 165, 36);
		panel_3.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.BLACK);
		textField_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_11.setColumns(10);
		textField_11.setBounds(321, 187, 165, 36);
		panel_3.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setForeground(Color.BLACK);
		textField_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_12.setColumns(10);
		textField_12.setBounds(321, 289, 165, 36);
		panel_3.add(textField_12);
		textField_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Information where id=? and pin=?";
				try {
				//	System.out.println("abid");
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField_10.getText());
					ps.setString(2, textField_11.getText());
					rs=ps.executeQuery();
					if(rs.next())
					{
				//		System.out.println("abid1");
						textField_12.setEditable(true);
						textField_13.setEditable(true);
						h=rs.getString("email");
						ps.close();
						rs.close();
						//updatePin();
					}else
					{
						JOptionPane.showMessageDialog(null,"Incorrect pin/user id");
					}
				}catch(Exception ae)
				{
					JOptionPane.showMessageDialog(null,ae);
				}
			}});
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setForeground(Color.BLACK);
		textField_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_13.setColumns(10);
		
		textField_13.setBounds(321, 381, 165, 36);
		textField_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add1=textField_12.getText();
				String add2=textField_13.getText();
				if(add1.equals(add2)) {
				try {
					String sql1="update Information set  pin='"+add1+"'where id='"+textField_10.getText()+"'";
					ps=conn.prepareStatement(sql1);
					ps.execute();
					JOptionPane.showMessageDialog(null,"Password Changed");
					updatePin();
				}catch(Exception ae) {
				JOptionPane.showMessageDialog(null,ae);
				}
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Passwords DO not Match");
			}
				
			}});
		panel_3.add(textField_13);
		JLabel lblPin = new JLabel("Pin");
		lblPin.setForeground(new Color(245, 255, 250));
		lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPin.setBounds(187, 187, 122, 36);
		panel_3.add(lblPin);
		
		JLabel lblNewPin = new JLabel("New Pin");
		lblNewPin.setForeground(new Color(245, 255, 250));
		lblNewPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewPin.setBounds(187, 289, 122, 36);
		panel_3.add(lblNewPin);
		
		JLabel lblRetypeNewPin = new JLabel("Retype new pin");
		lblRetypeNewPin.setForeground(new Color(245, 255, 250));
		lblRetypeNewPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRetypeNewPin.setBounds(107, 381, 202, 36);
		panel_3.add(lblRetypeNewPin);
	}
}
