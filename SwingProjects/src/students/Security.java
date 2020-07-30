package students;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Security {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Security window = new Security("");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public Security(String otp) {
		initialize(otp);
		conn=sqlcoonection.making();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String otp) {
		frame = new JFrame();
		frame.setBounds(400, 100, 1287, 866);
		Color c1=new Color(220,62,121);
		Color c=new Color(174,67,154);
		frame.getContentPane().setBackground(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Type the 4 digit code we sent to your email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(254, 358, 484, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("SUST STUDENT MANAGEMNT");
		label.setIcon(new ImageIcon("F:\\imagesandicons\\Shahjalal_University_of_Science_and_Technology_logo.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(245, 255, 250));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		label.setBounds(227, 108, 779, 111);
		frame.getContentPane().add(label);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		passwordField.setBounds(825, 381, 250, 30);
		frame.getContentPane().add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBackground(c1);
		panel.setBounds(109, 276, 1131, 454);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(otp)) {
					frame.setVisible(false);
					Loading ob=new Loading();
					ob.setUploading1();
				}
			}
		});
		btnEnter.setForeground(new Color(245, 255, 250));
		btnEnter.setBackground(new Color(174, 67, 154));
		btnEnter.setBounds(935, 180, 97, 25);
		panel.add(btnEnter);
	}
}
