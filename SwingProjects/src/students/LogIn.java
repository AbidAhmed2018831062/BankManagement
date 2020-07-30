package students;
import java.sql.*;
import java.util.Random;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.UIManager;

//import StudentManagement.Loading;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
	private JFrame frmStudentManagement;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	public int OTP()
	{
		Random ran=new Random();
		int p=0;
		while(true)
		{
			p=ran.nextInt(9999);
			if(p>=1000)
				break;
		}
		return p;
	}
	public void sendEmail2(String s,String otp)
	{
		SendingPin ob=new SendingPin(s,otp);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frmStudentManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		
		initialize();
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentManagement = new JFrame();
		frmStudentManagement.setTitle("Student Management");
		frmStudentManagement.setBounds(400, 100, 1314, 866);
		Color c=new Color(174,67,154);
	frmStudentManagement.getContentPane().setBackground(c);
	frmStudentManagement.getContentPane().setLayout(null);
	frmStudentManagement.setVisible(true);
	JPanel panel = new JPanel();
	Color c1=new Color(220,62,121);
	panel.setBackground(c1);
	panel.setBounds(599, 278, 695, 324);
	frmStudentManagement.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel lblPin = new JLabel("");
	lblPin.setBackground(new Color(240, 240, 240));
	lblPin.setIcon(new ImageIcon("F:\\imagesandicons\\256-2560208_person-icon-black-png-transparent-png.jpg"));
	lblPin.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPin.setForeground(Color.WHITE);
	lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	lblPin.setBounds(120, 57, 127, 28);
	panel.add(lblPin);
	
	txtUsername = new JTextField();
	txtUsername.setToolTipText("username");
	txtUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	txtUsername.setBounds(248, 57, 167, 28);
	panel.add(txtUsername);
	txtUsername.setColumns(10);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon("F:\\imagesandicons\\index.jpg"));
	label.setHorizontalAlignment(SwingConstants.RIGHT);
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	label.setBackground(SystemColor.menu);
	label.setBounds(120, 98, 127, 28);
	panel.add(label);
	
	passwordField = new JPasswordField();
	passwordField.setToolTipText("Password");
	passwordField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	passwordField.setBounds(248, 98, 167, 28);
	panel.add(passwordField);
	Color c3=new Color(180,53,218);
	JButton btnNewButton = new JButton("LogIn");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String sql="SELECT * FROM Information where id=? and pin=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, txtUsername.getText());
				ps.setString(2, passwordField .getText());
				
				rs=ps.executeQuery();
			
		if(rs.next())
		{
			setVisible(false);
			String we=rs.getString("two");
		    String wer=rs.getString("email");
			if(we.equals("yes"))
			{
				int otp=OTP();
				sendEmail2(wer,""+otp);
				frmStudentManagement.setVisible(false);
				Security ob=new Security(""+otp);
			}
			else {
			String s=rs.getString("Name");
			frmStudentManagement.setVisible(false);
			Loading ob=new Loading();
			ob.setUploading1();
			rs.close();
			ps.close();
			}
			
		}
			else
			{
				JOptionPane.showMessageDialog(null,"Incorrect pin/user name");
			}
			
			}
			catch(Exception ae){
				JOptionPane.showMessageDialog(null,ae);
				
			}
			finally {
				try {
					rs.close();
					ps.close();
					}
			
			catch(Exception ae){
				//JOptionPane.showMessageDialog(null,"Sorry For Inconviniecne ,We will look towards it immediately");
				
			}
			
		}
		}
		
	});
	btnNewButton.setForeground(UIManager.getColor("Button.highlight"));
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	btnNewButton.setBackground(c3);
	btnNewButton.setBounds(143, 149, 329, 28);
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Forgotten Password?");
	btnNewButton_1.setBackground(c3);
	btnNewButton_1.setForeground(UIManager.getColor("Button.highlight"));
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1.setBounds(394, 190, 239, 25);
	panel.add(btnNewButton_1);
	
	JLabel lblNewLabel = new JLabel("Don't Have An Account? Sign Up Here");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
	lblNewLabel.setBounds(100, 397, 350, 16);
	panel.add(lblNewLabel);
	
	JButton btnSignUp = new JButton("Sign Up");
	btnSignUp.setForeground(Color.WHITE);
	btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnSignUp.setBackground(new Color(180, 53, 218));
	btnSignUp.setBounds(462, 393, 127, 25);
	panel.add(btnSignUp);
	
	JLabel lblNewLabel_3 = new JLabel("Don't Have An Account?");
	lblNewLabel_3.setForeground(UIManager.getColor("Button.highlight"));
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	lblNewLabel_3.setBounds(161, 295, 299, 16);
	panel.add(lblNewLabel_3);
	
	JButton btnSignUp_1 = new JButton("Sign Up");
	btnSignUp_1.setForeground(Color.WHITE);
	btnSignUp_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnSignUp_1.setBackground(new Color(180, 53, 218));
	btnSignUp_1.setBounds(462, 293, 127, 25);
	panel.add(btnSignUp_1);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setIcon(new ImageIcon("F:\\imagesandicons\\images.jpg"));
	lblNewLabel_1.setBounds(396, 30, 535, 179);
	frmStudentManagement.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setIcon(new ImageIcon("F:\\imagesandicons\\maxresdefault.jpg"));
	lblNewLabel_2.setBounds(22, 217, 575, 440);
	frmStudentManagement.getContentPane().add(lblNewLabel_2);
	frmStudentManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
