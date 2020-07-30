package students;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Random;
public class NewAccount {

	private JFrame frame;
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
    private Connection conn;
    String h=null;
    private PreparedStatement ps;
      private ResultSet rs;
      private JTextField txtYesOrNo;
    public void sendEmail()
    {
    	SendingEmail1 ob=new SendingEmail1(h);
    }
	public void getUserId()
	{
		Random rd=new Random();
		int p=0;
		while(true)
		{
			p=rd.nextInt(9999);
			if(p>=1000)
				break;
		}
		textField.setText(""+p);
		
	}
	public void getPin()
	{
		Random rd=new Random();
		int p=0;
		while(true)
		{
			p=rd.nextInt(9999);
			if(p>=1000)
				break;
		}
		textField_1.setText(""+p);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccount window = new NewAccount();
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
	public NewAccount() {
		initialize();
		getUserId();
		getPin();
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color c=new Color(174,67,154);
		Color c1=new Color(220,62,121);
		frame = new JFrame();
		frame.getContentPane().setBackground(c);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("SUST STUDENT MANAGEMNT");
		label.setIcon(new ImageIcon("F:\\imagesandicons\\Shahjalal_University_of_Science_and_Technology_logo.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label.setBounds(204, 44, 779, 111);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(c1);
		panel.setBounds(12, 197, 1245, 539);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("User ID:");
		label_1.setBounds(173, 103, 92, 27);
		label_1.setForeground(new Color(245, 255, 250));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		panel.add(label_1);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setForeground(new Color(245, 255, 250));
		lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPin.setBounds(173, 181, 122, 36);
		panel.add(lblPin);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(245, 255, 250));
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblName.setBounds(173, 251, 122, 36);
		panel.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(245, 255, 250));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblFathersName.setBounds(103, 328, 192, 36);
		panel.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setForeground(new Color(245, 255, 250));
		lblMothersName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMothersName.setBounds(103, 404, 202, 36);
		panel.add(lblMothersName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setForeground(new Color(245, 255, 250));
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDateOfBirth.setBounds(605, 94, 144, 36);
		panel.add(lblDateOfBirth);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(245, 255, 250));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblEmail.setBounds(627, 181, 122, 36);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(245, 255, 250));
		lblPhone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPhone.setBounds(627, 265, 122, 36);
		panel.add(lblPhone);
		
		JLabel lblRoll = new JLabel("Roll");
		lblRoll.setForeground(new Color(245, 255, 250));
		lblRoll.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRoll.setBounds(627, 354, 122, 36);
		panel.add(lblRoll);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(245, 255, 250));
		lblGender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGender.setBounds(627, 416, 122, 36);
		panel.add(lblGender);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField.setColumns(10);
		textField.setBounds(313, 94, 165, 36);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(313, 181, 165, 36);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 0));
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(313, 252, 165, 36);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 0));
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(313, 329, 165, 36);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 0));
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(313, 405, 165, 36);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 0));
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(783, 94, 165, 36);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 0));
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_6.setColumns(10);
		textField_6.setBounds(783, 181, 165, 36);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(0, 0, 0));
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_7.setColumns(10);
		textField_7.setBounds(783, 276, 165, 36);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(0, 0, 0));
		textField_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_8.setColumns(10);
		textField_8.setBounds(783, 355, 165, 36);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setForeground(new Color(0, 0, 0));
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField_9.setColumns(10);
		textField_9.setBounds(783, 417, 165, 36);
		panel.add(textField_9);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="insert into Information(id,pin,name,fan,man,dob,email,mob,roll,gender,two) values(?,?,?,?,?,?,?,?,?,?,?)";
				try {
					System.out.println("Abid1");
					ps=conn.prepareStatement(sql);
					System.out.println("Abid1");
					ps.setString(1, textField.getText());
					ps.setString(2, textField_1.getText());
					ps.setString(3, textField_2.getText());
					ps.setString(4, textField_3.getText());
					ps.setString(5, textField_4.getText());
				//	ps.setString(6, textField.getText());
				//	ps.setString(, textField_1.getText());
					System.out.println("Abid1");
					ps.setString(6, textField_5.getText());
					ps.setString(7, textField_6.getText());
					ps.setString(8, textField_7.getText());
					ps.setString(9, textField_8.getText());
					ps.setString(10, textField_9.getText());
					ps.setString(11, txtYesOrNo.getText());
				//	ps.setString(14, textField_9.getText());
					ps.execute();
					JOptionPane.showMessageDialog(null,"Your Account Has Been Created Successfully");
					//Bal();
					h=textField_6.getText();
					sendEmail();

				}
				catch(Exception ae) {
					JOptionPane.showMessageDialog(null,ae);
				}
					
			}
		});
		btnCreate.setForeground(new Color(245, 255, 250));
		btnCreate.setBackground(new Color(174, 67, 154));
		btnCreate.setBounds(994, 501, 97, 25);
		panel.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LogIn ob=new LogIn();
				
			}
		});
		btnBack.setForeground(new Color(245, 255, 250));
		btnBack.setBackground(new Color(174, 67, 154));
		btnBack.setBounds(1125, 501, 97, 25);
		panel.add(btnBack);
		
		JLabel lblTwoFactorAuthentication = new JLabel("Two factor Authentication");
		lblTwoFactorAuthentication.setForeground(new Color(245, 255, 250));
		lblTwoFactorAuthentication.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTwoFactorAuthentication.setBounds(12, 490, 293, 36);
		panel.add(lblTwoFactorAuthentication);
		
		txtYesOrNo = new JTextField();
		txtYesOrNo.setText("yes or no");
		txtYesOrNo.setForeground(Color.BLACK);
		txtYesOrNo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		txtYesOrNo.setColumns(10);
		txtYesOrNo.setBounds(313, 490, 165, 36);
		panel.add(txtYesOrNo);
		frame.setBounds(400, 100, 1287, 866);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
