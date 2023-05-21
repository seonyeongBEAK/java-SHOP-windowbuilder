package windowbulderTest;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import static windowbulderTest.Login.mmid;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Choice;

public class relog extends JFrame implements ActionListener {
	
	JOptionPane m = new JOptionPane();

	static Label id, pwd, tel, name, home;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	
	JButton bt_join, bt_cancel;
	static String m_name, m_home;

	
	private JPanel contentPane;
	private static JTextField id_t;
	private static JTextField name_t;
	private static JTextField tel_t;
	private static JTextField home_t;
	private static JTextField pwd_t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relog frame = new relog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
//		query("select", "select * from member where m_id = 1");
//		count = 1;
		viewData();
		dbDis();
	}

	public relog() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (28).jpg"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 10, 309, 38);
		contentPane.add(lblNewLabel);
		
		bt_join = new JButton("");
		bt_join.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (29).jpg"));
		bt_join.addActionListener(this);
		bt_join.setBounds(62, 303, 117, 38);
		contentPane.add(bt_join);
		
		bt_cancel = new JButton("");
		bt_cancel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (30).jpg"));
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
			}
		});
		bt_cancel.setBounds(254, 303, 117, 38);
		contentPane.add(bt_cancel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (23).jpg"));
		lblNewLabel_1.setBounds(62, 156, 60, 32);
		contentPane.add(lblNewLabel_1);
		
		id_t = new JTextField();
		id_t.setToolTipText("ID\uB97C \uC791\uC131\uD558\uC138\uC694.");
		id_t.setForeground(new Color(192, 192, 192));
		id_t.setBounds(134, 156, 220, 32);
		contentPane.add(id_t);
		id_t.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (24).jpg"));
		lblNewLabel_1_1.setBounds(62, 204, 60, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (26).jpg"));
		lblNewLabel_1_2.setBounds(62, 72, 60, 32);
		contentPane.add(lblNewLabel_1_2);
		
		name_t = new JTextField();
		name_t.setToolTipText("\uC774\uB984\uC744 \uC791\uC131\uD558\uC138\uC694.");
		name_t.setForeground(new Color(192, 192, 192));
		name_t.setColumns(10);
		name_t.setBounds(134, 72, 127, 32);
		contentPane.add(name_t);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (25).jpg"));
		lblNewLabel_1_2_1.setBounds(62, 114, 60, 32);
		contentPane.add(lblNewLabel_1_2_1);
		
		tel_t = new JTextField();
		tel_t.setToolTipText("\uC804\uD654\uBC88\uD638\uB97C \uC791\uC131\uD558\uC138\uC694.");
		tel_t.setForeground(new Color(192, 192, 192));
		tel_t.setColumns(10);
		tel_t.setBounds(134, 114, 180, 32);
		contentPane.add(tel_t);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (27).jpg"));
		lblNewLabel_1_1_1.setBounds(62, 246, 60, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		home_t = new JTextField();
		home_t.setToolTipText("\uBC30\uC1A1\uC9C0\uB97C \uC791\uC131\uD558\uC138\uC694.");
		home_t.setForeground(new Color(192, 192, 192));
		home_t.setColumns(10);
		home_t.setBounds(134, 246, 220, 32);
		contentPane.add(home_t);
		
		pwd_t = new JTextField();
		pwd_t.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC791\uC131\uD558\uC138\uC694.");
		pwd_t.setForeground(Color.LIGHT_GRAY);
		pwd_t.setColumns(10);
		pwd_t.setBounds(134, 204, 220, 32);
		contentPane.add(pwd_t);
		
	}
		public static void dbConnect() {
	    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		System.out.println("드라이버 검색 성공!");        
	    	}catch(ClassNotFoundException e){
	    		System.err.println("error = " + e);
	    	}
	        
	    	
	        url = "jdbc:odbc:shop";
	        conn = null;
	        stmt = null;
	        rs = null;
	        String url = "jdbc:mysql://localhost/shop?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	        String sql = "Select * From member";
			try {
	         
	            conn = DriverManager.getConnection(url,"root","1234");

	            stmt = conn.createStatement( );

	            rs = stmt.executeQuery(sql);
	            
	            System.out.println("데이터베이스 연결 성공!");            
	         
	        }
	        catch(Exception e) {
	            System.out.println("데이터베이스 연결 실패!");
	        }
		}
		public static void query(String order, String sql) throws SQLException {
			if (order == "select") {
				rs = stmt.executeQuery(sql);
			} 
			else {
				stmt.executeUpdate(sql);
			}
		}

		public static void viewData() throws SQLException {
			if(!rs.next()){
				System.out.println("!rs.next()");
				count--;
			}
			else{		
					System.out.println("rs.next()");
					name_t.setText(rs.getString("m_name"));
					tel_t.setText(rs.getString("m_tel"));
					id_t.setText(rs.getString("m_id"));
					pwd_t.setText(rs.getString("m_pw"));
					home_t.setText(rs.getString("m_home"));
			}
		}

		public static void dbDis(){
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				System.out.println("데이터베이스 연결 해제!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt_join) {
				dbConnect();
				try {

					query("insert", "insert into member values('"+id_t.getText()+"','"+pwd_t.getText()+"','"+name_t.getText()+"','"+tel_t.getText()+"','"+home_t.getText()+"')");

				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				JOptionPane.showMessageDialog(null, "회원가입 완료!");
				new Login().setVisible(true);
				dispose();
				id_t.setText("");
				pwd_t.setText("");
				name_t.setText("");
				tel_t.setText("");
				home_t.setText("");
				dbDis();
			} 
			if(e.getSource() == bt_cancel) {
				dispose();
			}


	}
}
