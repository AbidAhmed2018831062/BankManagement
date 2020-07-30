package students;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

//import StudentManagement.MyPage;

import java.awt.Font;
import javax.swing.ImageIcon;

public class Loading extends JFrame implements Runnable{
    
	Thread th;
	private JFrame frame;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    JProgressBar progressBar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading window = new Loading();
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
	public Loading() {
		initialize();
		conn=sqlcoonection.making();
		th=new Thread((Runnable)this);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color c1=new Color(220,62,121);
		frame = new JFrame();
		frame.getContentPane().setBackground(c1);
		frame.setBounds(400, 100, 1287, 866);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Color c=new Color(174,67,154);
		JPanel panel = new JPanel();
		panel.setBackground(c);
		panel.setBounds(323, 111, 609, 643);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setVisible(true);
		
		 progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		//progressBar.setBackground(c);
		progressBar.setForeground(new Color(0, 255, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(147, 150, 292, 36);
		panel.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("Redirecting");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(226, 198, 142, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Loading, Please Wait");
		lblNewLabel_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(181, 263, 269, 68);
		panel.add(lblNewLabel_1);
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
				setVisible(false);
			MyPage ob=new MyPage();
		//	ob.setVisible(true);
				break;
				
			}
			Thread.sleep(50);
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
	}


	public void setUploading1() {
		//frame.setVisible(false);
		th.start();
		
	}

}
