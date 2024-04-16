package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JLabel lblName;
	private JLabel lblnumber;
	private JLabel lblEmail;
	private JTextField textname;
	private JTextField textphone;
	private JTextField textemail;
	private JTextArea textArea;
	private JButton btnsave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblName.setBounds(46, 50, 160, 53);
		frame.getContentPane().add(lblName);
		
		lblnumber = new JLabel("전화번호");
		lblnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumber.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblnumber.setBounds(46, 128, 160, 53);
		frame.getContentPane().add(lblnumber);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblEmail.setBounds(46, 211, 160, 53);
		frame.getContentPane().add(lblEmail);
		
		textname = new JTextField();
		textname.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textname.setBounds(258, 50, 313, 53);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		textphone = new JTextField();
		textphone.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textphone.setColumns(10);
		textphone.setBounds(258, 128, 313, 53);
		frame.getContentPane().add(textphone);
		
		textemail = new JTextField();
		textemail.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textemail.setColumns(10);
		textemail.setBounds(258, 211, 313, 53);
		frame.getContentPane().add(textemail);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 32));
		textArea.setBounds(85, 389, 466, 165);
		frame.getContentPane().add(textArea);
		
		btnsave = new JButton("입력");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textname.getText();
				String phone = textphone.getText();
				String email = textemail.getText();
				String member = String.format("이름:%s\n전화번호:%s\n이메일:%s\n", name, phone, email);
				textArea.setText(member);
				textname.setText("");
				textphone.setText("");
				textemail.setText("");
			}
		});
		btnsave.setFont(new Font("D2Coding", Font.PLAIN, 32));
		btnsave.setBounds(164, 288, 275, 75);
		frame.getContentPane().add(btnsave);
	}

}
