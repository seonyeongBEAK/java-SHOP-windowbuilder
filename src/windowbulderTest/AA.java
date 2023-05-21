package windowbulderTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class AA extends JFrame implements ActionListener{

	private JPanel panel_2;
	private static JTextField search_t;
	
	
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	static JButton orderSelect_b,back_b;

	private JTextField tName;
	private JTextField tTel;
	private JTextField tHome;


	public AA() {
		setTitle("\uC8FC\uBB38\uC870\uD68C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 346);
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 250));
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setLayout(null);
		setContentPane(panel_2);
		
		JLabel label1 = new JLabel("회원 정보 조회");
		label1.setFont(new Font("����", Font.BOLD, 20));
		label1.setBounds(190, 10, 144, 31);
		panel_2.add(label1);
		
		search_t = new JTextField();
		search_t.setBounds(203, 66, 112, 24);
		panel_2.add(search_t);
		search_t.setColumns(10);
		
		orderSelect_b = new JButton("\uC870\uD68C");
		orderSelect_b.setSelectedIcon(null);
		orderSelect_b.setFont(new Font("����", Font.PLAIN, 12));
		orderSelect_b.setBackground(new Color(240, 240, 240));
		orderSelect_b.setIcon(null);
		orderSelect_b.addActionListener(this);
		orderSelect_b.setBounds(203, 100, 112, 25);
		panel_2.add(orderSelect_b);
		
		back_b = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_b.setBackground(new Color(203, 220, 224));
		back_b.setFont(new Font("����", Font.PLAIN, 12));
		back_b.setBounds(405, 274, 91, 23);
		back_b.addActionListener(this);
		panel_2.add(back_b);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(176, 70, 24, 15);
		panel_2.add(lblNewLabel);
		
		tTel = new JTextField();
		tTel.setBounds(84, 188, 116, 21);
		panel_2.add(tTel);
		tTel.setColumns(10);
		
		tName = new JTextField();
		tName.setBounds(84, 157, 116, 21);
		panel_2.add(tName);
		tName.setColumns(10);
		
		tHome = new JTextField();
		tHome.setBounds(84, 219, 116, 21);
		panel_2.add(tHome);
		tHome.setColumns(10);
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
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AA frame = new AA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
		
//		query("select", "select * from product where p_id = 0");
//		count = 1;
		viewData();
		dbDis();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==orderSelect_b) {
			dbConnect();
			try {
				query("select","select * from member where m_id='"+search_t.getText()+"'");

				while(rs.next()) {
					if(search_t.getText().equals(rs.getString("m_id"))) {
						System.out.println(rs.getString("m_name"));
						tName.setText(rs.getString("m_name"));
						tTel.setText(rs.getString("m_tel"));
						tHome.setText(rs.getString("m_home"));
					}
				}
			}catch(Exception e1) {
				e1.getStackTrace();
			}
		}
		else if(e.getSource()==back_b) {
			new main().setVisible(true);
			dispose();
		}
	}
}
