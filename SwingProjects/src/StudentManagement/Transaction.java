package StudentManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Transaction extends JFrame{

	private JFrame frmBankmaanagement;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	private JTextArea textArea;
	
	public void setTextField()
	{
		String sql="select * from Account where Acc=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,textField.getText());
			rs=ps.executeQuery();
			if(rs.next())
		{
			String spo=rs.getString("tra");
			System.out.println(spo);
			textArea.setText(spo);
			
		}
			else
			{
				
			}
		
		}catch(Exception e)
	{
		
	}
}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction window = new Transaction();
					window.frmBankmaanagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transaction() {
		//System.out.println("Abid123456");
		initialize();
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize()  {
		frmBankmaanagement = new JFrame();
		frmBankmaanagement.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eee images\\index.png"));
		frmBankmaanagement.setTitle("BankManagement");
		frmBankmaanagement.setResizable(false);
		frmBankmaanagement.setBackground(Color.CYAN);
		frmBankmaanagement.setBounds(400, 100, 1047, 785);
		frmBankmaanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankmaanagement.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4), "Transaction HIstory", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		frmBankmaanagement.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(181, 212, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPin.setBounds(181, 258, 56, 16);
		panel.add(lblPin);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		textField.setBounds(313, 206, 132, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		passwordField.setBounds(313, 252, 132, 29);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("LogIn");
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
						rs.close();
						ps.close();
						setTextField();
						
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
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(467, 302, 97, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("iBanking");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_2.setBounds(254, 59, 494, 95);
		panel.add(lblNewLabel_2);
		 textArea = new JTextArea();
		 textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 20));
		JScrollPane scrollBar = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setBounds(12, 379, 987, 346);
		panel.add(scrollBar);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankmaanagement.setVisible(false);
				MyPage ob=new MyPage();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnBack.setBounds(576, 302, 97, 25);
		panel.add(btnBack);
		
		 
		//scrollBar.add(textArea);
		
	}
}