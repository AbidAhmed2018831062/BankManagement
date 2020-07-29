package StudentManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Group;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Account extends JFrame {

	private JFrame frmBankmanagement;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private ButtonGroup grp;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	private JTextField textField_9;
	/**
	 * Launch the application.
	 */
	public void account()
	{
		Random ra=new Random();
		int e;
		while(true)
		{
			e=ra.nextInt(2000);
			if(e>=1000)
				break;
				
		}
		textField.setText(""+e);
		
		
	}
	public void mirno()
	{
		Random ra=new Random();
		int e;
		while(true)
		{
			e=ra.nextInt(2000);
			if(e>=1000)
				break;
				
		}
		textField_1.setText(""+e);
		
		
	}
	public void pin()
	{
		Random ra=new Random();
		int e;
		while(true)
		{
			e=ra.nextInt(2000);
			if(e>=1000)
				break;
				
		}
		textField_2.setText(""+e);
		
		
	}
	public void Bal()
	{
		String sql="insert into Balance(Name,Acc,Balance,MirNo) values(?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,textField_3.getText());
			ps.setString(2,textField.getText());
			ps.setString(3,textField_9.getText());
			ps.setString(4,textField_2.getText());
			ps.execute();
			}
		catch(Exception ae)
		{
			JOptionPane.showMessageDialog(null,ae);
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
					window.frmBankmanagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account() {
		initialize();
		conn=sqlcoonection.making();
		account();
		mirno();
		pin();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("abid");
		frmBankmanagement = new JFrame();
		frmBankmanagement.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eee images\\index.png"));
		frmBankmanagement.setTitle("BankManagement");
		frmBankmanagement.setResizable(false);
		frmBankmanagement.setVisible(true);
		frmBankmanagement.setBounds(400, 100, 1094, 786);
		frmBankmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankmanagement.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account No:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(175, 210, 135, 32);
		frmBankmanagement.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMirNo = new JLabel("Mir No:");
		lblMirNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMirNo.setBounds(175, 277, 118, 32);
		frmBankmanagement.getContentPane().add(lblMirNo);
		
		JLabel lblPin = new JLabel("Pin:");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPin.setBounds(175, 332, 118, 32);
		frmBankmanagement.getContentPane().add(lblPin);
		
		JLabel lblAddress = new JLabel("Account Type:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddress.setBounds(142, 387, 168, 32);
		frmBankmanagement.getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Gender:");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPhone.setBounds(175, 442, 118, 32);
		frmBankmanagement.getContentPane().add(lblPhone);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddress_1.setBounds(175, 511, 118, 32);
		frmBankmanagement.getContentPane().add(lblAddress_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField.setBounds(359, 210, 157, 32);
		frmBankmanagement.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(359, 277, 157, 32);
		frmBankmanagement.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(359, 341, 157, 32);
		frmBankmanagement.getContentPane().add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(359, 520, 157, 32);
		frmBankmanagement.getContentPane().add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select ", "Savings", "Current"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		comboBox.setEditable(true);
		comboBox.setBounds(359, 396, 157, 32);
		frmBankmanagement.getContentPane().add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnNewRadioButton.setBounds(349, 450, 88, 25);
		frmBankmanagement.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("FeMale");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		rdbtnFemale.setBounds(441, 450, 118, 25);
		frmBankmanagement.getContentPane().add(rdbtnFemale);
		grp=new ButtonGroup();
		grp.add(rdbtnFemale);
		grp.add(rdbtnNewRadioButton);
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName.setBounds(628, 210, 118, 32);
		frmBankmanagement.getContentPane().add(lblName);
		
		JLabel lblDob = new JLabel("D.O.B:");
		lblDob.setHorizontalAlignment(SwingConstants.CENTER);
		lblDob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDob.setBounds(628, 277, 118, 32);
		frmBankmanagement.getContentPane().add(lblDob);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMobile.setBounds(628, 341, 118, 32);
		frmBankmanagement.getContentPane().add(lblMobile);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblQuestion.setBounds(628, 399, 118, 32);
		frmBankmanagement.getContentPane().add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAnswer.setBounds(628, 454, 118, 32);
		frmBankmanagement.getContentPane().add(lblAnswer);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(777, 210, 157, 32);
		frmBankmanagement.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(777, 280, 157, 32);
		frmBankmanagement.getContentPane().add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_6.setColumns(10);
		textField_6.setBounds(777, 341, 157, 32);
		frmBankmanagement.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_7.setColumns(10);
		textField_7.setBounds(777, 396, 157, 32);
		frmBankmanagement.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_8.setColumns(10);
		textField_8.setBounds(777, 451, 157, 32);
		frmBankmanagement.getContentPane().add(textField_8);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sql="insert into Account(Acc,Name,Pin,DOB,Mic,Acc_Type,Gender,Mob,Address,Secq,SecA,Balance) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			System.out.println("Abid1");
			ps=conn.prepareStatement(sql);
			System.out.println("Abid1");
			ps.setString(1, textField.getText());
			ps.setString(2, textField_3.getText());
			ps.setString(3, textField_2.getText());
			ps.setString(4, textField_4.getText());
			ps.setString(5, textField_5.getText());
		//	ps.setString(6, textField.getText());
		//	ps.setString(, textField_1.getText());
			ps.setString(6, (String) comboBox.getSelectedItem());
			ps.setString(7, (String) grp.getSelection().getActionCommand());
			System.out.println("Abid1");
			ps.setString(8, textField_6.getText());
			ps.setString(9, textField_5.getText());
			ps.setString(10, textField_7.getText());
			ps.setString(11, textField_8.getText());
			ps.setString(12, textField_9.getText());
		//	ps.setString(14, textField_9.getText());
			ps.execute();
			JOptionPane.showMessageDialog(null,"Your Account Has Been Created Successfully");
			Bal();
		}
		catch(Exception ae) {
			JOptionPane.showMessageDialog(null,ae);
		}
			}
		});
		btnNewButton.setBounds(258, 599, 97, 25);
		frmBankmanagement.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				landingPage ld=new landingPage();
				ld.setVisible(true);
			}
		});
		btnBack.setBounds(422, 599, 97, 25);
		frmBankmanagement.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
			}
		});
		btnClear.setBounds(562, 599, 97, 25);
		frmBankmanagement.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_2 = new JLabel("Thank You for Using Our Service");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(234, 675, 545, 16);
		frmBankmanagement.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("iBanking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(163, 33, 654, 128);
		frmBankmanagement.getContentPane().add(lblNewLabel);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblBalance.setBounds(628, 523, 118, 32);
		frmBankmanagement.getContentPane().add(lblBalance);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_9.setColumns(10);
		textField_9.setBounds(777, 520, 157, 32);
		frmBankmanagement.getContentPane().add(textField_9);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4), "NewAccount", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(43, 38, 1004, 669);
		frmBankmanagement.getContentPane().add(panel);
	}
}
