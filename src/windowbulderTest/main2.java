package windowbulderTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class main2 extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main2() {
		setTitle("\uC544\uB450\uC815\uBCF5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton p01 = new JButton("");
		p01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new coding_2().setVisible(true);
				dispose();
			}
		});
		p01.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (1).jpg"));
		p01.setBackground(new Color(249, 249, 249));
		p01.setBounds(23, 59, 150, 150);
		contentPane.add(p01);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1.setBounds(97, 219, 150, 150);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1_1.setBounds(243, 59, 150, 150);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1_1_1.setBounds(320, 219, 150, 150);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton bt_qna = new JButton("");
		bt_qna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DM().setVisible(true);
				dispose();
			}
		});
		bt_qna.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBB38\uC758\uD558\uAE30-001.png"));
		bt_qna.setBounds(405, 45, 85, 32);
		contentPane.add(bt_qna);
		
		
		
		
		//�α� �ƿ� ��ư
		JButton bt_logout = new JButton("");
		bt_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});		
		bt_logout.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uB85C\uADF8\uC544\uC6C3-001.jpg"));
		bt_logout.setBounds(406, 10, 85, 32);
		contentPane.add(bt_logout);
		
		
		
		JButton bt_orderSelect = new JButton("");
		bt_orderSelect.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001.png"));
		bt_orderSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new test1().setVisible(true);
				dispose();
			}
		});
		bt_orderSelect.setBounds(405, 80, 85, 32);
		contentPane.add(bt_orderSelect);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(23, 10, 370, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\제목을 입력해주세요_-001 (10).png"));
		lblNewLabel.setBounds(0, 0, 370, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("�޸տ�����", Font.BOLD, 28));
		
		
		
		
		JButton bt_next = new JButton("");
		bt_next.setForeground(new Color(255, 255, 255));
		bt_next.setBackground(new Color(255, 255, 255));
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main().setVisible(true);
				dispose();
			}
		});
		bt_next.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (39).jpg"));
		bt_next.setFont(new Font("����", Font.PLAIN, 8));
		bt_next.setBounds(320, 391, 162, 43);
		contentPane.add(bt_next);
		
		
		
		
		
		Panel panel_1 = new Panel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(243, 243, 243));
		panel_1.setBounds(10, 391, 272, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\3-001 (3).jpg"));
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("�޸տ�����", Font.BOLD, 10));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(0, 0, 272, 43);
		panel_1.add(lblNewLabel_1_1);
		
		JButton bt_search = new JButton("");
		bt_search.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001 (3).jpg"));
		bt_search.setSelectedIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001 (3).jpg"));
		bt_search.setBounds(405, 175, 85, 32);
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main().setVisible(true);
				dispose();
			}
		});
		contentPane.add(bt_search);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
