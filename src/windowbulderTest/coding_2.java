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

public class coding_2 extends JFrame implements ActionListener {
	int i = 0;
	private JPanel contentPane;
	private JTextField result2;
	JSpinner spinner;

	JButton bt_order, other;
	
	private int price = 45000;
	private int o_num, sum;
	private String o_sum;

	public static String p_name2  = "iot 기와집 키트";
	public static String onum;
	public static String oprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coding_2 frame = new coding_2();
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
	public coding_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uBC30\uC1A1\uC870\uD68C-001 (1).png"));
		lblNewLabel_1.setBounds(23, 69, 300, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (3).jpg"));
		lblNewLabel_2.setBounds(329, 75, 156, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, 10, 460, 59);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (3).png"));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("�޸տ�����", Font.BOLD, 28));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (9).jpg"));
		lblNewLabel_2_1.setBounds(329, 169, 59, 33);
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
		
		spinner.setBounds(400, 169, 85, 33);
		contentPane.add(spinner);

		Choice choice = new Choice();
		choice.setBounds(329, 215, 156, 21);
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

				new shipping2().setVisible(true);
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


