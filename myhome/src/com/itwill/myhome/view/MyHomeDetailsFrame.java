package com.itwill.myhome.view;

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
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;

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
	private JButton btnUpdate;
	private JButton btnCancel;
	private MyHomeDao dao = MyHomeDao.getInstance();
	private int MyHomeId;
	private Component parent;
	private UpdateNotify app;
	private JLabel lblAddress;
	private JLabel lblWay;
	private JLabel lblRoom;
	private JLabel lblFeet;
	private List<MyHome> myhome;
	private JTextArea textContent;
	private JLabel lblAddress_1;
	private JComboBox comboBoxCity;
	private JComboBox comboBoxBorough;
	/**
	 * Launch the application.
	 */
	public static void showMyHomeDetailsFrame(Component parent, int MyHomeId, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHomeDetailsFrame frame = new MyHomeDetailsFrame(parent, MyHomeId,app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MyHomeDetailsFrame(Component parent, int MyHomeId, UpdateNotify app) {
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
		setTitle("상세보기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parent != null) {
			x = parent.getX(); 
			y = parent.getY(); 
		}
		
		setBounds(x, y, 450, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddress = new JLabel("상세주소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblAddress.setBounds(12, 95, 90, 40);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(114, 95, 272, 40);
		contentPane.add(textAddress);
		
		lblWay = new JLabel("방향");
		lblWay.setHorizontalAlignment(SwingConstants.CENTER);
		lblWay.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblWay.setBounds(12, 145, 50, 40);
		contentPane.add(lblWay);
		
		textWay = new JTextField();
		textWay.setColumns(10);
		textWay.setBounds(74, 147, 50, 40);
		contentPane.add(textWay);
		
		lblRoom = new JLabel("방 개수");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblRoom.setBounds(135, 145, 63, 40);
		contentPane.add(lblRoom);
		
		textRoomCount = new JTextField();
		textRoomCount.setColumns(10);
		textRoomCount.setBounds(210, 147, 50, 40);
		contentPane.add(textRoomCount);
		
		lblFeet = new JLabel("평수");
		lblFeet.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeet.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblFeet.setBounds(272, 147, 50, 40);
		contentPane.add(lblFeet);
		
		textFeet = new JTextField();
		textFeet.setColumns(10);
		textFeet.setBounds(336, 149, 50, 40);
		contentPane.add(textFeet);
		
		lblOption = new JLabel("옵션");
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblOption.setBounds(175, 183, 63, 40);
		contentPane.add(lblOption);
		
		panel = new JPanel();
		panel.setBounds(12, 233, 410, 40);
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 283, 403, 292);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		scrollPane.setViewportView(textContent);
		textContent.setLineWrap(true);
		textContent.setWrapStyleWord(true);
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMyHome(MyHomeId);
			}
		});

			
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnUpdate.setBounds(74, 585, 100, 40);
		contentPane.add(btnUpdate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCancel.setBounds(250, 585, 100, 40);
		contentPane.add(btnCancel);
		
		lblAddress_1 = new JLabel("주소");
		lblAddress_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress_1.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblAddress_1.setBounds(12, 27, 73, 40);
		contentPane.add(lblAddress_1);
		
		comboBoxCity = new JComboBox();
		
		comboBoxCity.setBounds(114, 37, 110, 23);
		List<String> cities = dao.getcities();
		for(String s : cities) {
			comboBoxCity.addItem(s);
		}
		contentPane.add(comboBoxCity);
		
		comboBoxBorough = new JComboBox();
		comboBoxCity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCity = (String) comboBoxCity.getSelectedItem();
				if (selectedCity != null) {
					List<String> boroughs = dao.getborough(selectedCity);
					comboBoxBorough.removeAllItems();
					for (String s : boroughs) {
						comboBoxBorough.addItem(s);
			}
		}
			}
		});
		comboBoxBorough.setBounds(250, 37, 165, 23);
		contentPane.add(comboBoxBorough);
	}
	private void initializeMyHome() {
		MyHome myhome = dao.read(MyHomeId);
		if (myhome == null) return;
		
		textAddress.setText(myhome.getAddress());
		textWay.setText(myhome.getWay());
		textFeet.setText(myhome.getFeet());
		textRoomCount.setText(myhome.getRoom_count());
		textContent.setText(myhome.getContent());
		cbWasher.setSelected(myhome.isOption1());
		cbFridge.setSelected(myhome.isOption2());
		cbAir.setSelected(myhome.isOption3());
		cbOven.setSelected(myhome.isOption4());
		cbInduction.setSelected(myhome.isOption5());
		comboBoxCity.setSelectedItem(myhome.getCity());
		comboBoxBorough.setSelectedItem(myhome.getBorough());
	}
	private void updateMyHome(int id) {
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
        String city = (String) comboBoxCity.getSelectedItem();
        String borough = (String) comboBoxBorough.getSelectedItem();
        
        MyHome myhome = new MyHome(id, address, way, feet, roomcount, content, option1, option2, option3, option4, option5, city, borough);
		int result = dao.update(myhome,id);
        if (result == 1) {
            app.notifyUpdateSuccess();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "업데이트 실패");
        }
    }
}
