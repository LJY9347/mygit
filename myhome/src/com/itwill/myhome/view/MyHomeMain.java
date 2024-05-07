package com.itwill.myhome.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itwill.myhome.controller.MyHomeDao;
import com.itwill.myhome.model.MyHome;
import com.itwill.myhome.view.MyHomeCreateFrame.CreateNotify;
import com.itwill.myhome.view.MyHomeDetailsFrame.UpdateNotify;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MyHomeMain implements UpdateNotify,CreateNotify {

	private static final String[] COL_NAMES = {"주소","방향","평수","방 개수"};

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel searchPanel;
	private JPanel buttonPanel;
	private JLabel lblList;
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnDetails;
	private JButton btnReadAll;
	private JTextField textSearchKeyword;
	private JComboBox comboBox;
	private DefaultTableModel tableModel;
	private MyHomeDao dao = MyHomeDao.getInstance();
	private int x = 0;
	private List<MyHome> myhome;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyHomeMain window = new MyHomeMain();
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
	public MyHomeMain() {
		initialize();
		initializeTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("집 리스트");
		
		lblList = new JLabel("집 리스트");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setFont(new Font("D2Coding", Font.PLAIN, 28));
		lblList.setBounds(0, 0, 684, 51);
		frame.getContentPane().add(lblList);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 662, 336);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		tableModel = new DefaultTableModel(null, COL_NAMES);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 407, 660, 90);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		btnReadAll = new JButton("목록보기");
		btnReadAll.addActionListener((e) -> initializeTable());
		btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnReadAll.setBounds(35, 10, 125, 75);
		buttonPanel.add(btnReadAll);
		
		btnCreate = new JButton("새 집추가");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyHomeCreateFrame.showMyHomeCreateFrame(frame, MyHomeMain.this);
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnCreate.setBounds(190, 10, 125, 75);
		buttonPanel.add(btnCreate);
		
		btnDetails = new JButton("상세보기");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDetaisFrame();
			}
		});
		btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 22));
		btnDetails.setBounds(350, 10, 125, 75);
		buttonPanel.add(btnDetails);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener((e) -> deleteMyHome());

		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
		btnDelete.setBounds(500, 10, 125, 75);
		buttonPanel.add(btnDelete);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(10, 511, 660, 90);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"주소", "평수"}));
		comboBox.setBounds(50, 23, 126, 40);
		searchPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(232, 11, 10, 10);
		searchPanel.add(panel);
		
		textSearchKeyword = new JTextField();
		textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textSearchKeyword.setBounds(188, 24, 290, 40);
		searchPanel.add(textSearchKeyword);
		textSearchKeyword.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> search());
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 20));
		btnSearch.setBounds(509, 14, 103, 58);
		searchPanel.add(btnSearch);
	}
	private void initializeTable() {
		myhome = dao.read();
		resetTable(myhome);
	}
	private void resetTable(List<MyHome> myhome) {
		tableModel = new DefaultTableModel(null, COL_NAMES);
		for (MyHome b : myhome) {
			Object row[] = { b.getAddress(),b.getWay(),b.getFeet(),b.getRoom_count()				
			};
			tableModel.addRow(row);		
		}
		table.setModel(tableModel);		
	}
	private void showDetaisFrame() {
		int index = table.getSelectedRow();
		 if (index == -1) { 
	            JOptionPane.showMessageDialog(
	                    frame, 
	                    "상세보기할 행을 먼저 선택하세요.", 
	                    "경고", 
	                    JOptionPane.WARNING_MESSAGE);
	            return;
	        }
		 int id = myhome.get(index).getId();
		MyHomeDetailsFrame.showMyHomeDetailsFrame(frame,id,MyHomeMain.this);
		
	}

	@Override
	public void notifyUpdateSuccess() {
		initializeTable();
        JOptionPane.showMessageDialog(frame, "업데이트 성공!");		
	}

	@Override
	public void notifyCreateSuccess() {
		initializeTable();
        JOptionPane.showMessageDialog(frame, "새 집정보 등록 성공!");
		
	}
	private void deleteMyHome() {
        int index = table.getSelectedRow();
        if (index == -1) { 
            JOptionPane.showMessageDialog(
                    frame, 
                    "삭제할 행을 먼저 선택하세요.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        	int id = myhome.get(index).getId();
        	int result = dao.delete(id);
            if (result == 1) {
                initializeTable(); 
                JOptionPane.showMessageDialog(frame, "삭제 성공!");
            } else {
                JOptionPane.showMessageDialog(frame, "삭제 실패!");
            }
        }	
	}
	private void search() {
        int type = comboBox.getSelectedIndex(); 
        String keyword = textSearchKeyword.getText();
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, 
                    "검색어를 입력하세요.", 
                    "경고", JOptionPane.WARNING_MESSAGE);
            textSearchKeyword.requestFocus();            
            return;
        }
        List<MyHome> blogs = dao.search(type, keyword);
        resetTable(blogs);
        textSearchKeyword.setText("");
    }
}
