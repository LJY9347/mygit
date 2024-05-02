package com.itwill.myhome.view;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.myhome.controller.MyHomeDao;
import com.itwill.myhome.model.MyHome;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyHomeCreateFrame extends JFrame {
	
	public interface CreateNotify {
		void notifyCreateSuccess();
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAddress;
	private JLabel lblAddress;
	private JTextField textWay;
	private JTextField textRoomCount;
	private JTextField textFeet;
	private JCheckBox cbInduction;
	private JCheckBox cbOven;
	private JCheckBox cbAir;
	private JCheckBox cbFridge;
	private JCheckBox cbWasher;
	private JPanel cbPanel;
	private JLabel lblOption;
	private JLabel lblWay;
	private JLabel lblRoom;
	private JLabel lblFeet;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextArea textContent;
	private JScrollPane scrollPane;
	private MyHomeDao dao = MyHomeDao.getInstance();
	private Component parent;
	private CreateNotify app;
	
	public static void showMyHomeCreateFrame(Component parent, CreateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHomeCreateFrame frame = new MyHomeCreateFrame(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private MyHomeCreateFrame(Component parent, CreateNotify app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}


	public void initialize() {
		setTitle("새 집추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX(); 
			y = parent.getY(); 
		}
		
		setBounds(x, y, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);

		lblAddress = new JLabel("주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblAddress.setBounds(12, 10, 100, 40);
		getContentPane().add(lblAddress);

		textAddress = new JTextField();
		textAddress.setBounds(12, 60, 540, 40);
		getContentPane().add(textAddress);
		textAddress.setColumns(10);

		lblWay = new JLabel("방향");
		lblWay.setHorizontalAlignment(SwingConstants.CENTER);
		lblWay.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblWay.setBounds(12, 110, 70, 40);
		getContentPane().add(lblWay);

		lblRoom = new JLabel("방 개수");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblRoom.setBounds(176, 110, 70, 40);
		getContentPane().add(lblRoom);

		lblFeet = new JLabel("평수");
		lblFeet.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeet.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblFeet.setBounds(340, 110, 70, 40);
		getContentPane().add(lblFeet);

		textWay = new JTextField();
		textWay.setBounds(94, 110, 70, 40);
		getContentPane().add(textWay);
		textWay.setColumns(10);

		textRoomCount = new JTextField();
		textRoomCount.setColumns(10);
		textRoomCount.setBounds(258, 112, 70, 40);
		getContentPane().add(textRoomCount);

		textFeet = new JTextField();
		textFeet.setColumns(10);
		textFeet.setBounds(422, 110, 70, 40);
		getContentPane().add(textFeet);

		lblOption = new JLabel("옵션");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblOption.setBounds(258, 162, 70, 40);
		getContentPane().add(lblOption);

		cbPanel = new JPanel();
		cbPanel.setBounds(12, 212, 540, 40);
		getContentPane().add(cbPanel);

		cbWasher = new JCheckBox("세탁기");
		cbWasher.setFont(new Font("D2Coding", Font.PLAIN, 18));
		cbPanel.add(cbWasher);

		cbFridge = new JCheckBox("냉장고");
		cbFridge.setFont(new Font("D2Coding", Font.PLAIN, 18));
		cbPanel.add(cbFridge);

		cbAir = new JCheckBox("에어컨");
		cbAir.setFont(new Font("D2Coding", Font.PLAIN, 18));
		cbPanel.add(cbAir);

		cbOven = new JCheckBox("전자레인지");
		cbOven.setFont(new Font("D2Coding", Font.PLAIN, 18));
		cbPanel.add(cbOven);

		cbInduction = new JCheckBox("인덕션");
		cbInduction.setFont(new Font("D2Coding", Font.PLAIN, 18));
		cbPanel.add(cbInduction);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 262, 540, 280);
		getContentPane().add(scrollPane);

		textContent = new JTextArea();
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
		scrollPane.setViewportView(textContent);

		btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewHome();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnSave.setBounds(134, 561, 100, 40);
		getContentPane().add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCancel.setBounds(319, 561, 100, 40);
		getContentPane().add(btnCancel);
	}

	
	
	private void createNewHome() {
		String address = textAddress.getText();
		String way = textWay.getText();
		String feet = textFeet.getText();
		String roomcount = textRoomCount.getText();
		String content = textContent.getText();
		boolean option1 = cbWasher.isSelected();
		boolean option2 = cbFridge.isSelected();
		boolean option3 = cbAir.isSelected();
		boolean option4 = cbOven.isSelected();
		boolean option5 = cbInduction.isSelected();
		
		MyHome myhome = new MyHome(0, address, way, feet, roomcount, content, option1, option2, option3, option4, option5);
		int result = dao.create(myhome);
		if (result == 1) {
			app.notifyCreateSuccess();
			dispose();
		} else {
			JOptionPane.showMessageDialog(MyHomeCreateFrame.this, "INSERT 실패");
		}
	}
	
}
