package StudentManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.Toolkit;
public class landingPage extends JFrame {

	private JFrame frmBankmanagement;
	private JTextField textField;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	private JPasswordField passwordField;
	static String tra;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	for(javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels())
					landingPage window = new landingPage();
					window.frmBankmanagement.setVisible(true);
					//UIManager.setLookAndFeel("com.jtatto.plaf.smart.SmartLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public landingPage() {
		initialize();
		conn=sqlcoonection.making();
		//setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankmanagement = new JFrame();
		frmBankmanagement.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eee images\\index.png"));
		frmBankmanagement.setTitle("BankManagement");
		frmBankmanagement.setResizable(false);
		frmBankmanagement.getContentPane().setForeground(new Color(0, 0, 0));
		frmBankmanagement.setBackground(new Color(240, 240, 240));
		frmBankmanagement.getContentPane().setBackground(Color.CYAN);
		frmBankmanagement.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		frmBankmanagement.setBounds(400, 100, 1048, 786);
		frmBankmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankmanagement.getContentPane().setLayout(null);
		frmBankmanagement.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4), "Authentication", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(173, 140, 636, 446);
		frmBankmanagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("iBanking");
		lblNewLabel.setBounds(156, 45, 291, 77);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnClear = new JButton("New Account");
		btnClear.setBounds(327, 377, 141, 25);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Account ld=new Account();
				//ld.setVisible(true);
				frmBankmanagement.setVisible(false);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBounds(175, 375, 124, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="SELECT * FROM Account where Acc=? and Pin=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, textField.getText());
					ps.setString(2, passwordField .getText());
					
					rs=ps.executeQuery();
				
			if(rs.next())
			{
				setVisible(false);
				String s=rs.getString("Name");
				Loading ob=new Loading();
				frmBankmanagement.setVisible(false);
				ob.setUploading();
				rs.close();
				ps.close();
				
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 270, 166, 41);
		panel.add(passwordField);
		passwordField.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 22));
		
		JLabel lblNewLabel_2 = new JLabel("Enter Your Pin:");
		lblNewLabel_2.setBounds(49, 268, 177, 41);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		
		textField = new JTextField();
		textField.setBounds(275, 191, 166, 35);
		panel.add(textField);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your User Id:");
		lblNewLabel_1.setBounds(12, 188, 228, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	}
}
