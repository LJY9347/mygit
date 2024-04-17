package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("Private");
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		rbPrivate.setSelected(true);
		buttonGroup.add(rbPrivate);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPrivate.setBounds(8, 6, 136, 50);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("Package");
		rbPackage.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);				
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPackage.setBounds(148, 6, 136, 50);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("Protected");
		rbProtected.addActionListener((d) -> handleRadioButtonClick(d));
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbProtected.setBounds(288, 6, 136, 50);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("Public");
		rbPublic.addActionListener(this::handleRadioButtonClick);
		// AppMain06.this::handleRadioButtonClick
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 20));
		rbPublic.setBounds(428, 6, 136, 50);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);	
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbAbstract.setBounds(8, 70, 136, 50);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener((x) -> handleCheckBoxClick(x));
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbFinal.setBounds(148, 70, 136, 50);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(this::handleCheckBoxClick);
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cbStatic.setBounds(288, 70, 136, 50);
		frame.getContentPane().add(cbStatic);
		
		//
		comboBox = new JComboBox<>(); // new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleComboBoxChange(e);
			}
		});
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
		final String [] emails = {"naver.com", "gmail.com", "kakao.com", "yahoo.com"};
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(emails);

		comboBox.setModel(model);
		comboBox.setBounds(8, 153, 363, 40);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener((e) -> handleButtonClick());
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnInfo.setBounds(383, 153, 107, 40);
		frame.getContentPane().add(btnInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 224, 477, 359);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding ligature", Font.PLAIN, 30));
		scrollPane.setViewportView(textArea);
	}

	private void handleButtonClick() {
		// JTextArea에 출력할 문자열들을 붙여나갈(append) 문자열 버퍼.
		StringBuffer buffer = new StringBuffer();
		
		// 어떤 라디오버튼이 선택됐는지 찾기.
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오버튼 선택됨.\n");
		
		// 어떤 체크박스들이 선택됐는지 찾기.
		if(cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbStatic.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");
		
		// 콤보박스에서 선택된 아이템은 무엇인지 찾기.
		Object selectedItem = comboBox.getSelectedItem();
		buffer.append(selectedItem).append(" 콤보박스 아이템 선택됨.\n");
		
		// 문자열 버퍼의 내용을 JTextArea에 씀.
		textArea.setText(buffer.toString());
	}

	private void handleComboBoxChange(ActionEvent esd) {
		// 이벤트가 발생한 컴포넌트(JComboBox) 찾기
		JComboBox<String> combo = (JComboBox<String>) esd.getSource();
		
		// 콤보박스에서 선택된 아이템 찾기
		int index = combo.getSelectedIndex(); // 콤보박스에서 선택된 아이템의 인덱스
		String item = (String) combo.getSelectedItem(); // 콤보박스에서 선택된 아이템
		
		// JTextArea에 정보 출력
		textArea.setText(index + ": " + item);	
	}

	private void handleCheckBoxClick(ActionEvent a) {
		// 3개의 체크박스들 중에서 누가 클릭됐는지 찾기.
		JCheckBox cb = (JCheckBox) a.getSource();
		String text = cb.getText();
		boolean selected = cb.isSelected();
		textArea.setText(text + ": " + selected);
	}

	private void handleRadioButtonClick(ActionEvent event) {
		// 4개의 라디오버튼들 중에서 누가 클릭됐는지 찾기.
		JRadioButton rb = (JRadioButton) event.getSource();	//getSource의 리턴타입이 Object
		String text = rb.getText(); // 이벤트가 발생한 라디오버튼의 텍스트
		boolean selected = rb.isSelected(); // 이벤트가 발생한 라디오버튼의 선택 여부
		textArea.setText(text + ": " + selected);
		
	}
}
