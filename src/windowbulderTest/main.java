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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class main extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
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
	public main() {
		setTitle("\uC544\uB450\uC815\uBCF5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton pr01 = new JButton("");
		pr01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new coding_1().setVisible(true);
				dispose();
			}
		});
		pr01.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001.jpg"));
		pr01.setBackground(new Color(249, 249, 249));
		pr01.setBounds(23, 71, 150, 150);
		contentPane.add(pr01);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1.setBounds(547, 231, 150, 150);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1_1.setBounds(375, 231, 150, 150);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC0C1\uD488\uC900\uBE44\uC911-001 (1).jpg"));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(249, 249, 249));
		btnNewButton_1_1_1.setBounds(197, 231, 150, 150);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton bt_qna = new JButton("");
		bt_qna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DM().setVisible(true);
				dispose();
			}
		});
		bt_qna.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBB38\uC758\uD558\uAE30-001.png"));
		bt_qna.setBounds(716, 52, 85, 32);
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
		bt_logout.setBounds(716, 10, 85, 32);
		contentPane.add(bt_logout);
		
		
		
		JButton bt_orderSelect = new JButton("");
		bt_orderSelect.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001.png"));
		bt_orderSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new test1().setVisible(true);
				dispose();
			}
		});
		bt_orderSelect.setBounds(716, 94, 85, 32);
		contentPane.add(bt_orderSelect);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(23, 10, 370, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\제목을 입력해주세요_-001 (22).jpg"));
		lblNewLabel.setBounds(0, 0, 370, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("�޸տ�����", Font.BOLD, 28));
		
		
		
		
		JButton bt_next = new JButton("");
		bt_next.setForeground(new Color(255, 255, 255));
		bt_next.setBackground(new Color(224, 255, 255));
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main2().setVisible(true);
				dispose();
			}
		});
		bt_next.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\제목을 입력해주세요_-001 (22).png"));
		bt_next.setFont(new Font("����", Font.PLAIN, 8));
		bt_next.setBounds(596, 410, 205, 43);
		contentPane.add(bt_next);
		
		JButton bt_search = new JButton("");
		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search().setVisible(true);
				dispose();
			}
		});
		bt_search.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001 (3).jpg"));
		bt_search.setBounds(715, 175, 86, 32);
		contentPane.add(bt_search);
		
		JButton pr05 = new JButton("");
		pr05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pr05.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\기타-001 (1).png"));
		pr05.setSelectedIcon(null);
		pr05.setBackground(new Color(249, 249, 249));
		pr05.setBounds(23, 231, 150, 150);
		contentPane.add(pr05);
		
		JButton pr03 = new JButton("");
		pr03.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\기타-001 (2).png"));
		pr03.setBackground(new Color(249, 249, 249));
		pr03.setBounds(375, 71, 150, 150);
		pr03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new coding_3().setVisible(true);
				dispose();
			}
		});
		contentPane.add(pr03);
		
		JButton pr04 = new JButton("");
		pr04.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\기타-001 (3).png"));
		pr04.setBackground(new Color(249, 249, 249));
		pr04.setBounds(547, 71, 150, 150);
		contentPane.add(pr04);
		
		JButton pr02 = new JButton("");
		pr02.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\자율주행카-001 (1).jpg"));
		pr02.setBackground(new Color(249, 249, 249));
		pr02.setBounds(197, 71, 150, 150);		
		pr02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new coding_2().setVisible(true);
				dispose();
			}
			});
		contentPane.add(pr02);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(10, 410, 272, 43);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\3-001 (3).jpg"));
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("�޸տ�����", Font.BOLD, 10));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		
		JButton member = new JButton("MY");
		member.setBounds(709, 231, 97, 23);
		contentPane.add(member);
		member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AA().setVisible(true);
				dispose();
			}
			});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
