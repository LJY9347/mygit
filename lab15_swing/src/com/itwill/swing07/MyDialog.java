package com.itwill.swing07;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton okButton;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void showMyDialog() {
		try {
			MyDialog dialog = new MyDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyDialog() {
		initialize();
	}

	private void initialize() {
		// 다이얼로그의 좌표(x, y)와 크기(width, height)
		setBounds(100, 100, 647, 644);
		
		// setBounds의 (x, y) 좌표를 무시하고 항상 스크린의 가운데에 위치.
		setLocationRelativeTo(null);

		// 다이얼로그의 닫기 버튼(X)의 기본 동작을 설정:
		// DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고, 메인 프로세스는 계속 실행
		// EXIT_ON_CLOSE: 현재 다이얼로그와 함께 메인 프로세스까지 종료
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// getContentPane(): 컨텐트 영역 & 버튼 영역
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(22, 23, 121, 54);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 130, 260, 89);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(22, 258, 121, 89);
		contentPanel.add(btnNewButton);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		okButton = new JButton("OK");
		okButton.setFont(new Font("D2Coding", Font.PLAIN, 20));
		okButton.setActionCommand("OK");
		buttonPanel.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("D2Coding", Font.PLAIN, 20));
		cancelButton.setActionCommand("Cancel");
		buttonPanel.add(cancelButton);

	} // end initialize

}
