package com.itwill.myhome.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.myhome.controller.MyHomeDao;
import com.itwill.myhome.model.MyHome;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyHomeDetailsFrame extends JFrame {
	public interface UpdateNotify {
        public void notifyUpdateSuccess();
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAddress;
	private JTextField textWay;
	private JTextField textRoomCount;
	private JTextField textFeet;
	private JLabel lblOption;
	private JPanel panel;
	private JCheckBox cbWasher;
	private JCheckBox cbFridge;
	private JCheckBox cbAir;
	private JCheckBox cbOven;
	private JCheckBox cbInduction;
	private JScrollPane scrollPane;
	private JTextField textContent;
	private JButton btnUpdate;
	private JButton btnCancel;
	private MyHomeDao dao = MyHomeDao.getInstance();
	private int MyHomeId;
	private Component parent;
	private UpdateNotify app;

	/**
	 * Launch the application.
	 */
	public static void showMyHomeDetailsFrame(Component parent, int MyHomeId, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHomeDetailsFrame frame = new MyHomeDetailsFrame(parent,MyHomeId,app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MyHomeDetailsFrame(Component parent,int MyHomeId, UpdateNotify app) {
		this.parent = parent;
		this.MyHomeId = MyHomeId;
		this.app = app;
		initialize();
		initializeMyHome();
	}
	
	
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblAddress.setBounds(0, 10, 90, 40);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(102, 12, 313, 40);
		contentPane.add(textAddress);
		
		JLabel lblWay = new JLabel("방향");
		lblWay.setHorizontalAlignment(SwingConstants.CENTER);
		lblWay.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblWay.setBounds(12, 60, 50, 40);
		contentPane.add(lblWay);
		
		textWay = new JTextField();
		textWay.setColumns(10);
		textWay.setBounds(74, 62, 50, 40);
		contentPane.add(textWay);
		
		JLabel lblRoom = new JLabel("방 개수");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblRoom.setBounds(136, 60, 63, 40);
		contentPane.add(lblRoom);
		
		textRoomCount = new JTextField();
		textRoomCount.setColumns(10);
		textRoomCount.setBounds(211, 62, 50, 40);
		contentPane.add(textRoomCount);
		
		JLabel lblFeet = new JLabel("평수");
		lblFeet.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeet.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblFeet.setBounds(273, 62, 50, 40);
		contentPane.add(lblFeet);
		
		textFeet = new JTextField();
		textFeet.setColumns(10);
		textFeet.setBounds(335, 62, 50, 40);
		contentPane.add(textFeet);
		
		lblOption = new JLabel("옵션");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblOption.setBounds(172, 110, 63, 40);
		contentPane.add(lblOption);
		
		panel = new JPanel();
		panel.setBounds(12, 160, 410, 40);
		contentPane.add(panel);
		
		cbWasher = new JCheckBox("세탁기");
		cbWasher.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel.add(cbWasher);
		
		cbFridge = new JCheckBox("냉장고");
		cbFridge.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel.add(cbFridge);
		
		cbAir = new JCheckBox("에어컨");
		cbAir.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel.add(cbAir);
		
		cbOven = new JCheckBox("전자레인지");
		cbOven.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel.add(cbOven);
		
		cbInduction = new JCheckBox("인덕션");
		cbInduction.setFont(new Font("D2Coding", Font.PLAIN, 12));
		panel.add(cbInduction);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 210, 403, 292);
		contentPane.add(scrollPane);
		
		textContent = new JTextField();
		scrollPane.setViewportView(textContent);
		textContent.setColumns(10);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnUpdate.setBounds(74, 533, 100, 40);
		contentPane.add(btnUpdate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCancel.setBounds(252, 533, 100, 40);
		contentPane.add(btnCancel);
	}
	private void initializeMyHome() {
		MyHome myhome = dao.read(MyHomeId);
		if (myhome == null) return;
		
		textContent.setText(myhome.getContent());
		textAddress.setText(myhome.getAddress());
		textWay.setText(myhome.getWay());
		textRoomCount.setText(myhome.getRoom_count());
		textFeet.setText(myhome.getFeet());
		cbWasher.setSelected(myhome.isOption1());
		cbFridge.setSelected(myhome.isOption2());
		cbAir.setSelected(myhome.isOption3());
		cbOven.setSelected(myhome.isOption4());
		cbInduction.setSelected(myhome.isOption5());
	}
}
