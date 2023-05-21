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

public class admin extends JFrame {

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
	public admin() {
		setBackground(new Color(255, 250, 250));
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton Order = new JButton("");
		Order.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (14).png"));
		Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new test1().setVisible(true);
				dispose();
			}
		});
		Order.setBounds(12, 95, 150, 300);
		contentPane.add(Order);
		
		JButton Member = new JButton("");
		Member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new one().setVisible(true);
				dispose();
			}
		});
		Member.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (15).png"));
		Member.setBounds(171, 95, 150, 300);
		contentPane.add(Member);
		
		JButton Product = new JButton("");
		Product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new sang().setVisible(true);
				dispose();
			}
		});
		Product.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (16).png"));
		Product.setBounds(330, 95, 150, 300);
		contentPane.add(Product);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (12).png"));
		lblNewLabel.setBounds(12, 10, 468, 78);
		contentPane.add(lblNewLabel);
	}

}
