package windowbulderTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.SystemColor;

public class coding_3 extends JFrame implements ActionListener {
	int i = 0;
	private JPanel contentPane;
	private JTextField result2;
	JSpinner spinner;

	JButton bt_order, other;
	
	private int price = 10500;
	private int o_num, sum;
	private String o_sum;

	public static String p_name3  = "브루스 라디오";
	public static String onum;
	public static String oprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coding_3 frame = new coding_3();
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
	public coding_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Desktop\\상품관련\\물품사진\\마이마이 브루투스\\KakaoTalk_20220524_124450265_05-removebg-preview.png"));
		lblNewLabel_1.setBounds(23, 69, 300, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("[아두이노] 브루스 라디오");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(23, 10, 460, 59);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(null);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 30));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (9).jpg"));
		lblNewLabel_2_1.setBounds(329, 173, 59, 33);
		contentPane.add(lblNewLabel_2_1);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("spinner value : "+spinner.getValue());
//				o_num = (int) spinner.getValue();
				//�켱 �ش� ������Ʈ�� String���� ��ȯ�� �� Integer.parseInt
				o_num= Integer.parseInt(String.valueOf(spinner.getValue()));
				onum=String.valueOf(spinner.getValue());
				sum = price * o_num;
		        System.out.println(sum);
				System.out.println(onum);
				o_sum = String.valueOf(sum);

				result2.setText(o_sum);
			}
		});
		//spinner.setModel(new SpinnerNumberModel(10, 10, 20, 2));
		SpinnerNumberModel numModel = new SpinnerNumberModel(0, 0, 20, 1);
		spinner.setModel(numModel);
		
		spinner.setBounds(400, 173, 85, 33);
		contentPane.add(spinner);

		Choice choice = new Choice();
		choice.setBounds(329, 219, 156, 21);
		contentPane.add(choice);
		choice.add("-");

		result2 = new JTextField();
		result2.setText("\uC8FC\uBB38 \uAC00\uACA9");
		result2.setFont(new Font("����", Font.PLAIN, 14));
		result2.setBounds(335, 283, 150, 33);
		contentPane.add(result2);
		result2.setColumns(10);
		
		bt_order = new JButton("");
		bt_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onum=String.valueOf(o_num);
				oprice=String.valueOf(sum);

				new shipping3().setVisible(true);
				dispose();
			}
		});
		bt_order.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (10).jpg"));
		bt_order.setBounds(335, 326, 148, 43);
		contentPane.add(bt_order);
		
		other = new JButton("");
		other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main().setVisible(true);
				dispose();
			}
		});
		other.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (11).jpg"));
		other.setBounds(23, 379, 462, 56);
		contentPane.add(other);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(308, 77, 175, 33);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("상품명 : 브루스 라디오");
		lblNewLabel_2.setFont(new Font("굴림체", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==bt_order) {
		onum=String.valueOf(o_num);
		oprice=String.valueOf(sum);


	new shipping2().setVisible(true);
	dispose();
	}else if(e.getSource()==other) {
		new main().setVisible(true);
		dispose();
	}

}
}


