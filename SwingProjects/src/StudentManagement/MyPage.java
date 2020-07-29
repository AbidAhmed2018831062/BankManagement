package StudentManagement;

import java.awt.EventQueue;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import java.util.*;
import java.awt.Toolkit;
public class MyPage extends JFrame{

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
     private JTextField textField_9;
     private JTextField textField_10;
     private JTextField textField_11;
     private JTextField textField_12;
     private JTextField textField_13;
     private JTextField textField_14;
     private JTextField textField_15;
     private JTextField textField_16;
     private JTextField textField_17;
     private JTextField textField_18;
     private JTextField textField_19;
     int amount;
     private JTextField textField_20;
     private JTextField textField_21;
     private JTextField textField_22;
     private JTextField textField_23;
     private JTextField textField_24;
     private JTextField textField_25;
     private JTextField textField_26;
     private JTextField textField_27;
     private JTextField textField_28;
     private JPasswordField passwordField;
     private JPasswordField passwordField_1;
     private JPasswordField passwordField_2;
     
public void deductBalance() {
	int add1=Integer.parseInt(textField_16.getText());
	int add2=Integer.parseInt(textField_17.getText());
	int add3=add1-add2;
	String sql="update Account set Balance=' "+add3+" 'where Acc='"+textField_14.getText()+"'";
	try {
		ps=conn.prepareStatement(sql);
		ps.execute();
		String sql1="update Balance set Balance=' "+add3+" 'where Acc='"+textField_14.getText()+"'";
		ps=conn.prepareStatement(sql1);
		ps.execute();
	}
	catch(Exception ae)
	{
		
	}
}
public void 	updateTransaction(String s,String p) {
	String sql2="select*from Account where Acc=?";
	String ui="";
	try {
		ps=conn.prepareStatement(sql2);
		ps.setString(1,p);
		rs=ps.executeQuery();
		if(rs.next())
		{
			 ui=rs.getString("tra");
			 System.out.println(ui);
			 ps.close();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Enter Correct Account Number");
		}
	}
	catch(Exception ae)
	{
		
	}
	String add1=ui+s+"\n";
	System.out.println(add1);
	
	String sql3="update Account set tra='"+add1+"'where Acc='"+p+"'";
	try {
		ps=conn.prepareStatement(sql3);
		ps.execute();
	}
	catch(Exception ae)
	{
		
	}
	
}
public void addBalance()
{
	
	//int add1=Integer.parseInt(textField_16.getText());
	int add2=Integer.parseInt(textField_17.getText());
	int add3=amount+add2;
	String sql="update Account set Balance=' "+add3+" 'where Acc='"+textField_19.getText()+"'";
	try {
		ps=conn.prepareStatement(sql);
		ps.execute();
		String sql1="update Balance set Balance=' "+add3+" 'where Acc='"+textField_19.getText()+"'";
		ps=conn.prepareStatement(sql1);
		ps.execute();
		JOptionPane.showMessageDialog(null,"Transfer Successful");
	}
	catch(Exception ae)
	{
		JOptionPane.showMessageDialog(null,"Enter correct account number");
	}
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
		System.out.println("Abid");
		initialize();
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Abid");
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eee images\\index.png"));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(400, 100, 1048, 786);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("BankManagement");
		
		JLabel lblNewLabel = new JLabel("iBanking");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(94, 26, 244, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(583, 62, 116, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.activeCaption);
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4), "Everything", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_9.setBounds(33, 13, 971, 713);
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		textField_8 = new JTextField();
		textField_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Account where Acc=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField_8.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
					String add1=rs.getString("Name");
					textField.setText(add1);
					String add2=rs.getString("Acc");
					textField_4.setText(add2);
					String add3=rs.getString("DOB");
					textField_1.setText(add3);
					String add4=rs.getString("Address");
					textField_2.setText(add4);
					String add5=rs.getString("Gender");
					textField_3.setText(add5);
					String add6=rs.getString("Acc_Type");
					textField_5.setText(add6);
					String add7=rs.getString("Mob");
					textField_6.setText(add7);
					String add8=rs.getString("Secq");
					textField_7.setText(add8);
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
		textField_8.setBounds(684, 54, 200, 32);
		panel_9.add(textField_8);
		textField_8.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 150, 900, 550);
		panel_9.add(tabbedPane);
		tabbedPane.setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Profile", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setBounds(30, 37, 80, 31);
		panel.add(lblNewLabel_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(455, 8, 10, 10);
		panel.add(panel_10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDob.setBounds(30, 84, 80, 31);
		panel.add(lblDob);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddress.setBounds(30, 134, 93, 31);
		panel.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGender.setBounds(30, 190, 80, 31);
		panel.add(lblGender);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField.setBounds(146, 37, 196, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(146, 92, 196, 31);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 142, 196, 31);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(146, 198, 196, 31);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(687, 37, 196, 31);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(687, 92, 196, 31);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(687, 142, 196, 31);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(687, 190, 196, 31);
		panel.add(textField_7);
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAccountNo.setBounds(488, 37, 149, 31);
		panel.add(lblAccountNo);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAccountType.setBounds(476, 84, 164, 31);
		panel.add(lblAccountType);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMobile.setBounds(517, 134, 80, 31);
		panel.add(lblMobile);
		
		JLabel lblSecQ = new JLabel("Sec Q");
		lblSecQ.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblSecQ.setBounds(517, 190, 80, 31);
		panel.add(lblSecQ);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			///	textField.setEditable(true);
			//	textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				//textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				
			}
		});
		btnNewButton.setBounds(517, 297, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String add1=textField_2.getText();
			String add2=textField_3.getText();
			String add3=textField_6.getText();
			String add4=textField_7.getText();
			String add5=textField_4.getText();
			String sql="update Account set Address='"+add1+"',Gender='"+add2+"',Mob='"+add3+"',Secq='"+add4+"'where Acc='"+add5+"'";
				try {
					ps=conn.prepareStatement(sql);
					ps.execute();
					JOptionPane.showMessageDialog(null,"Profile Updated");
					
					}catch(Exception ae)
				{
						JOptionPane.showMessageDialog(null,ae);
						
				}
			}
		});
		btnSave.setBounds(633, 297, 97, 25);
		panel.add(btnSave);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Deposit", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAccno = new JLabel("Acc No");
		lblAccno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAccno.setBounds(162, 109, 80, 31);
		panel_1.add(lblAccno);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_9.setColumns(10);
		textField_9.setBounds(278, 109, 196, 31);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_10.setColumns(10);
		textField_10.setBounds(278, 177, 196, 31);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(278, 247, 196, 31);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(278, 320, 196, 31);
		textField_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int we=Integer.parseInt(textField_12.getText());
				int exist=Integer.parseInt(textField_11.getText());
				we+=exist;
				textField_13.setText(""+we);
				
				
			}});
		panel_1.add(textField_12);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName.setBounds(162, 177, 80, 31);
		panel_1.add(lblName);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalAmount.setBounds(70, 247, 196, 31);
		panel_1.add(lblTotalAmount);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDeposit.setBounds(125, 320, 107, 31);
		panel_1.add(lblDeposit);
		
		JButton btnNewButton_1 = new JButton("Search Acc");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Account where Acc=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField_9.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
					String add1=rs.getString("Name");
					textField_10.setText(add1);
					String add2=rs.getString("Balance");
					textField_11.setText(add2);
					textField_12.setEditable(true);
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
		btnNewButton_1.setBounds(548, 109, 118, 25);
		panel_1.add(btnNewButton_1);
		
		JLabel lblTotalAmountafterdeposit = new JLabel("Total AmountNow");
		lblTotalAmountafterdeposit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalAmountafterdeposit.setBounds(33, 392, 209, 59);
		panel_1.add(lblTotalAmountafterdeposit);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_13.setColumns(10);
		textField_13.setBounds(278, 398, 196, 31);
		panel_1.add(textField_13);
		
		JButton btnDeposut = new JButton("Deposit");
		btnDeposut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add1=textField_13.getText();
				String add2=textField_9.getText();
		
				String sql="update Account set Balance='"+add1+"' where Acc='"+add2+"'";	
					try {
						ps=conn.prepareStatement(sql);
						ps.execute();
						JOptionPane.showMessageDialog(null,"Deposited Successfully");
						String sql1="update Balance set Balance='"+add1+"' where Acc='"+add2+"'";	
						ps=conn.prepareStatement(sql1);
						ps.execute();
					  String j=textField_12.getText();
						updateTransaction("\nYou have deposited "+j+"taka to your account",textField_9.getText());
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textField_12.setText("");
						textField_13.setText("");
						}catch(Exception ae)
					{
							JOptionPane.showMessageDialog(null,ae);
							
					}
			}
		});
		btnDeposut.setBounds(569, 405, 118, 25);
		panel_1.add(btnDeposut);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Transfer", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Acc No");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(196, 67, 80, 31);
		panel_2.add(label);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName_1.setBounds(196, 126, 80, 31);
		panel_2.add(lblName_1);
		
		JLabel lblTotalAmount_2 = new JLabel("Total Amount");
		lblTotalAmount_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalAmount_2.setBounds(121, 192, 166, 31);
		panel_2.add(lblTotalAmount_2);
		
		JLabel lblTransferAmount = new JLabel("Transfer Amount");
		lblTransferAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTransferAmount.setBounds(84, 256, 191, 31);
		panel_2.add(lblTransferAmount);
		
		JLabel lblTotalAmount_1 = new JLabel("Total Amount");
		lblTotalAmount_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalAmount_1.setBounds(110, 317, 166, 31);
		panel_2.add(lblTotalAmount_1);
		
		JLabel lblCreditAccount = new JLabel("Credit Account");
		lblCreditAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblCreditAccount.setBounds(98, 380, 178, 31);
		panel_2.add(lblCreditAccount);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_14.setColumns(10);
		textField_14.setBounds(306, 67, 196, 31);
		panel_2.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_15.setColumns(10);
		textField_15.setBounds(306, 134, 196, 31);
		panel_2.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_16.setColumns(10);
		textField_16.setBounds(306, 200, 196, 31);
		panel_2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int min=Integer.parseInt(textField_16.getText());
			int max=Integer.parseInt(textField_17.getText());
			if(max>min)
			{
				JOptionPane.showMessageDialog(null,"You don't have sufficient balance");
				textField_17.setText("");
				textField_19.setEditable(false);
				
			}
			else {
				int r=min-max;
				textField_18.setText(""+r);
				textField_19.setEditable(true);
			}
			}
		});
		textField_17.setEditable(false);
		textField_17.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_17.setColumns(10);
		textField_17.setBounds(306, 264, 196, 31);
		panel_2.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_18.setColumns(10);
		textField_18.setBounds(306, 325, 196, 31);
		panel_2.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_19.setColumns(10);
		textField_19.setBounds(306, 388, 196, 31);
		panel_2.add(textField_19);
		textField_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		String sql2="select*from Account where Acc=?";
		
		try {
			ps=conn.prepareStatement(sql2);
			ps.setString(1,textField_19.getText());
			rs=ps.executeQuery();
			if(rs.next())
			{
				amount=rs.getInt("Balance");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter Correct Account Number");
			}
		}
		catch(Exception ae)
		{
			
		}
			}});
		
		JButton button = new JButton("Search Acc");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Account where Acc=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField_14.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
					String add1=rs.getString("Name");
					textField_15.setText(add1);
					String add2=rs.getString("Balance");
					textField_16.setText(add2);
					textField_17.setEditable(true);
					textField_19.setEditable(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Correct Account Number");
					}
					}catch(Exception ae)
				{
						JOptionPane.showMessageDialog(null,ae);
				}
				
						
					}
				});
		button.setBounds(571, 67, 118, 25);
		panel_2.add(button);
		
		JButton btnRansfer = new JButton("Transfer");
		btnRansfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deductBalance();
				addBalance();
		String s="\n"+"You have transfered "+textField_17.getText()+"taka to id= "+textField_19.getText()+" account";
		 
			updateTransaction(s,textField_14.getText());
			textField_14.setText("");
			textField_15.setText("");
			textField_16.setText("");
			textField_17.setText("");
			textField_18.setText("");
			textField_19.setText("");
			}
		});
		btnRansfer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnRansfer.setBounds(495, 455, 118, 25);
		panel_2.add(btnRansfer);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Withdraw", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("Acc No");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(173, 59, 80, 31);
		panel_3.add(label_1);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName_2.setBounds(173, 122, 80, 31);
		panel_3.add(lblName_2);
		
		JLabel lblTotalAmount_3 = new JLabel("Total Amount");
		lblTotalAmount_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalAmount_3.setBounds(94, 177, 159, 31);
		panel_3.add(lblTotalAmount_3);
		
		JLabel lblWithdrawalAmount = new JLabel("Withdrawal Amount");
		lblWithdrawalAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblWithdrawalAmount.setBounds(23, 243, 230, 31);
		panel_3.add(lblWithdrawalAmount);
		
		JLabel lblRemaining = new JLabel("Remaining");
		lblRemaining.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRemaining.setBounds(124, 303, 129, 31);
		panel_3.add(lblRemaining);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_20.setColumns(10);
		textField_20.setBounds(303, 59, 196, 31);
		panel_3.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_21.setColumns(10);
		textField_21.setBounds(303, 122, 196, 31);
		panel_3.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_22.setColumns(10);
		textField_22.setBounds(303, 177, 196, 31);
		panel_3.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_23.setColumns(10);
		textField_23.setBounds(303, 251, 196, 31);
		textField_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int min=Integer.parseInt(textField_22.getText());
			int max=Integer.parseInt(textField_23.getText());
			if(max>min)
			{
				JOptionPane.showMessageDialog(null,"You don't have sufficient balance");
				textField_23.setText("");
				//textField_19.setEditable(false);
				
			}
			else {
				int r=min-max;
				textField_24.setText(""+r);
				//textField_19.setEditable(true);
			}
			}
		});
		panel_3.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_24.setColumns(10);
		textField_24.setBounds(303, 303, 196, 31);
		panel_3.add(textField_24);
		
		JButton button_1 = new JButton("Search Acc");
		button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sql="select * from Account where Acc=?";
						try {
							ps=conn.prepareStatement(sql);
							ps.setString(1, textField_20.getText());
							rs=ps.executeQuery();
							if(rs.next()) {
							String add1=rs.getString("Name");
							textField_21.setText(add1);
							String add2=rs.getString("Balance");
							textField_22.setText(add2);
							textField_23.setEditable(true);
							textField_19.setEditable(true);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter Correct Account Number");
							}
							}catch(Exception ae)
						{
								JOptionPane.showMessageDialog(null,ae);
						}
						
								
					}});
		button_1.setBounds(571, 59, 118, 25);
		panel_3.add(button_1);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int add1=Integer.parseInt(textField_22.getText());
				int add2=Integer.parseInt(textField_23.getText());
				int add3=add1-add2;
				String sql="update Account set Balance=' "+add3+" 'where Acc='"+textField_20.getText()+"'";
				try {
					ps=conn.prepareStatement(sql);
					ps.execute();
					String sql1="update Balance set Balance=' "+add3+" 'where Acc='"+textField_20.getText()+"'";
					ps=conn.prepareStatement(sql1);
					ps.execute();
					String s="\n"+"You have withdrawn "+textField_23.getText()+" taka from your account";
					  JOptionPane.showMessageDialog(null, "Withdrawn Successful");
						updateTransaction(s,textField_20.getText());
						textField_20.setText("");
						textField_21.setText("");
						textField_22.setText("");
						textField_24.setText("");
						textField_23.setText("");
				}
				catch(Exception ae)
				{
					
				}
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnWithdraw.setBounds(446, 375, 129, 40);
		panel_3.add(btnWithdraw);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("View Balance", null, panel_6, null);
		panel_6.setLayout(null);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_25.setColumns(10);
		textField_25.setBounds(299, 177, 196, 31);
		panel_6.add(textField_25);
		
		JLabel label_2 = new JLabel("Acc No");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_2.setBounds(162, 177, 80, 31);
		panel_6.add(label_2);
		
		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_26.setColumns(10);
		textField_26.setBounds(299, 248, 196, 31);
		panel_6.add(textField_26);
		
		JLabel lblName_3 = new JLabel("Name");
		lblName_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName_3.setBounds(162, 248, 80, 31);
		panel_6.add(lblName_3);
		
		textField_27 = new JTextField();
		textField_27.setEditable(false);
		textField_27.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_27.setColumns(10);
		textField_27.setBounds(299, 313, 196, 31);
		panel_6.add(textField_27);
		
		JLabel lblTotalBalance = new JLabel("Total Balance");
		lblTotalBalance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTotalBalance.setBounds(93, 313, 149, 31);
		panel_6.add(lblTotalBalance);
		
		JButton btnNewButton_3 = new JButton("Search Acc");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Account where Acc=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField_25.getText());
					rs=ps.executeQuery();
					if(rs.next()) {
					String add1=rs.getString("Name");
					textField_26.setText(add1);
					String add2=rs.getString("Balance");
					textField_27.setText(add2);
				//	textField_12.setEditable(true);
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
		btnNewButton_3.setBounds(546, 177, 97, 25);
		panel_6.add(btnNewButton_3);
		
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Change Pin", null, panel_7, null);
		panel_7.setLayout(null);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_28.setColumns(10);
		textField_28.setBounds(366, 88, 196, 31);
		panel_7.add(textField_28);
		
		JLabel label_3 = new JLabel("Acc No");
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_3.setBounds(218, 88, 80, 31);
		panel_7.add(label_3);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPin.setBounds(250, 156, 80, 31);
		panel_7.add(lblPin);
		
		JLabel lblNewPin = new JLabel("New Pin");
		lblNewPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewPin.setBounds(195, 230, 103, 31);
		panel_7.add(lblNewPin);
		
		JLabel lblRetype = new JLabel("Re-Type");
		lblRetype.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRetype.setBounds(195, 302, 103, 31);
		panel_7.add(lblRetype);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('+');
		passwordField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		passwordField.setBounds(366, 160, 196, 30);
		panel_7.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		passwordField_1.setEchoChar('+');
		passwordField_1.setEditable(false);
		passwordField_1.setBounds(366, 234, 196, 30);
		panel_7.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setEchoChar('+');
		passwordField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		passwordField_2.setEditable(false);
		passwordField_2.setBounds(366, 306, 196, 30);
		panel_7.add(passwordField_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Tarnsaction History", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Watch Transaction HIstory Here");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_3.setBounds(65, 116, 389, 35);
		panel_5.add(lblNewLabel_3);
		JButton btnNewButton_2 = new JButton("Click Here");
		btnNewButton_2.setFont(new Font("Tahom60", Font.BOLD | Font.ITALIC, 22));
		btnNewButton_2.setBounds(496, 125, 145, 25);
		panel_5.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Transaction ob=new Transaction();
			}
		});
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("About", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Developer:");
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_4.setBounds(551, 84, 129, 35);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("F:\\eee images\\64913346_438487603371297_664285347378626560_o.jpg"));
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		label_5.setBounds(23, 45, 380, 381);
		panel_4.add(label_5);
		
		JLabel lblAbidAhmed = new JLabel("Abid Ahmed");
		lblAbidAhmed.setForeground(Color.RED);
		lblAbidAhmed.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAbidAhmed.setBounds(717, 84, 147, 35);
		panel_4.add(lblAbidAhmed);
		
		JLabel lblUniversity = new JLabel("University:");
		lblUniversity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblUniversity.setBounds(551, 157, 129, 35);
		panel_4.add(lblUniversity);
		
		JLabel lblSust = new JLabel("SUST");
		lblSust.setForeground(Color.RED);
		lblSust.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblSust.setBounds(717, 157, 147, 35);
		panel_4.add(lblSust);
		
		JLabel lblDepartment = new JLabel("DepartMent:");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDepartment.setBounds(540, 218, 147, 35);
		panel_4.add(lblDepartment);
		
		JLabel lblSoftware = new JLabel("Software");
		lblSoftware.setForeground(Color.RED);
		lblSoftware.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblSoftware.setBounds(717, 218, 147, 35);
		panel_4.add(lblSoftware);
		
		JLabel lblHometown = new JLabel("HomeTown:");
		lblHometown.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblHometown.setBounds(551, 277, 147, 35);
		panel_4.add(lblHometown);
		
		JLabel lblSylhet = new JLabel("Sylhet");
		lblSylhet.setForeground(Color.RED);
		lblSylhet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblSylhet.setBounds(717, 277, 147, 35);
		panel_4.add(lblSylhet);
		
		
	}
}
