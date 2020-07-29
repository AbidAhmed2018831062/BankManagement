package StudentManagement;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.awt.SystemColor;
import java.awt.Toolkit;
public class Loading extends JFrame implements Runnable{

	private JFrame frmBankmanagement;
	Thread th;
    Connection conn;
    private JProgressBar  progressBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
					window.frmBankmanagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Loading() {
		initialize();
		conn=sqlcoonection.making();
		th=new Thread((Runnable)this);
		
	}
	private void initialize() {
		frmBankmanagement = new JFrame();
		frmBankmanagement.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eee images\\index.png"));
		frmBankmanagement.setTitle("BankMAnagement");
		frmBankmanagement.setResizable(false);
		frmBankmanagement.getContentPane().setBackground(Color.CYAN);
		frmBankmanagement.setBounds(400, 100, 1048, 786);
		frmBankmanagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankmanagement.getContentPane().setLayout(null);
		frmBankmanagement.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255), 4), "Loading", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(184, 74, 670, 570);
		frmBankmanagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("iBanking");
		label.setBounds(200, 50, 255, 102);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));
		
		 progressBar = new JProgressBar();
		 progressBar.setBounds(184, 219, 307, 83);
		 panel.add(progressBar);
		 progressBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		 progressBar.setStringPainted(true);
		 
		 JLabel lblNewLabel = new JLabel( "Loading Please Wait");
		 lblNewLabel.setBounds(184, 443, 319, 29);
		 panel.add(lblNewLabel);
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		 
		 JLabel lblNewLabel_1 = new JLabel("Redirecting");
		 lblNewLabel_1.setBounds(297, 341, 94, 16);
		 panel.add(lblNewLabel_1);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2 = new JLabel("This software is safe and all information are encrypted.");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(257, 687, 582, 16);
		frmBankmanagement.getContentPane().add(lblNewLabel_2);
	}
	public void run()
	{
		try {
		for(int i=0;i<=progressBar.getMaximum();i=i+1)
		{
			int m= progressBar.getMaximum();
		System.out.println(i);
			if(i<progressBar.getMaximum())
			{
				 progressBar.setValue(i);
				 //n=i+1;
			}
			else
			{
			//	i=1000;
				 progressBar.setValue(i);
				frmBankmanagement.setVisible(false);
				MyPage ob=new MyPage();
			//ob.setVisible(true);
				break;
				
			}
			Thread.sleep(50);
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
	}


	public void setUploading() {
		//frame.setVisible(false);
		th.start();
		
	}

}
