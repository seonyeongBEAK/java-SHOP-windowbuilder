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
import static windowbulderTest.coding_1.onum;
import static windowbulderTest.coding_1.p_name1;
import static windowbulderTest.coding_1.oprice;
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

public class shipping1 extends JFrame implements ActionListener {
	
	JOptionPane m = new JOptionPane();
	   memberData data = new memberData();


	static Label id, pwd, tel, name, home;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	
	JButton bt_orderAdd;
	static String m_name, m_home;
	coding_1 pr1 = new coding_1();


	private JPanel contentPane;
	private static JTextField o_price;
	private static JTextField p_name;
	private static JTextField o_num;
	private static JTextField o_home;
	private static JTextField o_tel;
	private JTextField o_name;
	private JTextField o_id;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shipping1 frame = new shipping1();
					frame.setTitle("주문정보 입력");
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

	public shipping1() {
		setTitle("\uC0C1\uD488 \uC8FC\uBB38 \uC815\uBCF4 \uC785\uB825");
		setBackground(new Color(255, 250, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bt_orderAdd = new JButton("\uC8FC\uBB38\uD558\uAE30");
		bt_orderAdd.setIcon(null);
		bt_orderAdd.addActionListener(this);
		bt_orderAdd.setBounds(161, 323, 117, 38);
		contentPane.add(bt_orderAdd);
		
		o_price = new JTextField();
		o_price.setToolTipText("ID\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_price.setForeground(new Color(192, 192, 192));
		o_price.setBounds(134, 114, 220, 32);
		o_price.setText(oprice);
		contentPane.add(o_price);
		o_price.setColumns(10);
		
		p_name = new JTextField();
		p_name.setToolTipText("\uC774\uB984\uC744 \uC791\uC131\uD558\uC138\uC694.");
		p_name.setForeground(new Color(192, 192, 192));
		p_name.setColumns(10);
		p_name.setBounds(134, 30, 127, 32);
		p_name.setText(p_name1);
//		name_t.setText(pr1.getA());

		contentPane.add(p_name);
		
		o_num = new JTextField();
		o_num.setToolTipText("\uC804\uD654\uBC88\uD638\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_num.setForeground(new Color(192, 192, 192));
		o_num.setColumns(10);
		o_num.setBounds(134, 72, 180, 32);
		o_num.setText(onum);
//		tel_t.setText(pr1.getB());
		contentPane.add(o_num);
		
		o_home = new JTextField();
		o_home.setToolTipText("\uBC30\uC1A1\uC9C0\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_home.setForeground(new Color(192, 192, 192));
		o_home.setColumns(10);
		o_home.setBounds(134, 280, 220, 32);
//		tel_t.setText(pr1.getC());
		System.out.println(onum);
		contentPane.add(o_home);
		
		o_tel = new JTextField();
		o_tel.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_tel.setForeground(Color.LIGHT_GRAY);
		o_tel.setColumns(10);
		o_tel.setBounds(134, 238, 220, 32);
		System.out.println(oprice);
		contentPane.add(o_tel);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uD488\uBA85");
		lblNewLabel.setBounds(44, 38, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1.setBounds(44, 80, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC00\uACA9");
		lblNewLabel_2.setBounds(44, 122, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setBounds(44, 246, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBC30\uC1A1\uC9C0");
		lblNewLabel_4.setBounds(44, 288, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		o_name = new JTextField();
		o_name.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_name.setText((String) null);
		o_name.setForeground(Color.LIGHT_GRAY);
		o_name.setColumns(10);
		o_name.setBounds(134, 196, 220, 32);
		contentPane.add(o_name);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uC8FC\uBB38\uC790 \uC131\uD568");
		lblNewLabel_3_1.setBounds(44, 204, 72, 15);
		contentPane.add(lblNewLabel_3_1);
		
		o_id = new JTextField();
		o_id.setToolTipText("\uBC30\uC1A1\uC9C0\uB97C \uC791\uC131\uD558\uC138\uC694.");
		o_id.setForeground(Color.LIGHT_GRAY);
		o_id.setColumns(10);
		o_id.setBounds(134, 153, 144, 32);
		o_id.setText(mmid);
		contentPane.add(o_id);
		System.out.println(mmid);

		lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(44, 161, 57, 15);
		contentPane.add(lblNewLabel_5);
		
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
	        String sql = "Select * From test";
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
			if (e.getSource() == bt_orderAdd) {
				dbConnect();
				try {
		
					query("insert", "insert into test values('"+p_name.getText()+"','"+o_num.getText()+"','"+o_price.getText()+"','"+o_id.getText()+"','"+o_name.getText()+"','"+o_tel.getText()+"','"+o_home.getText()+"')");

				} catch (Exception e1) {
					e1.printStackTrace();
				}			
				System.out.println(mmid);
				JOptionPane.showMessageDialog(null, "주문완료");
				new test1().setVisible(true);
				dispose();
				o_price.setText("");
				o_tel.setText("");
				p_name.setText("");
				o_num.setText("");
				o_home.setText("");
				dbDis();
			} 
	


	}
}
