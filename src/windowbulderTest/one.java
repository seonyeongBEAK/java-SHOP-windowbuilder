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

public class one extends JFrame implements ActionListener{

	private JPanel panel_2;
	private JTextField search_t;
	static String[] head = new String[] {"ID","이름","전화번호","주소"};
	static DefaultTableModel model1 = new DefaultTableModel(head,0);
	static JTable table;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	static JButton search_b,back_b;


	public one() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 318);
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setLayout(null);
		setContentPane(panel_2);
		

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4 \uC870\uD68C");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(162, 10, 117, 27);
		panel_2.add(lblNewLabel);
		
//		search_t = new JTextField();
//		search_t.setBounds(12, 51, 315, 21);
//		panel_2.add(search_t);
//		search_t.setColumns(10);
		
		search_b = new JButton("\uC870\uD68C");
		search_b.addActionListener(this);
		search_b.setBounds(339, 50, 97, 23);
		panel_2.add(search_b);
		
		back_b = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_b.setBounds(339, 17, 97, 23);
		back_b.addActionListener(this);
		panel_2.add(back_b);
		
		table = new JTable(model1);
		table.setFont(new Font("����", Font.PLAIN, 14));
		table.setPreferredScrollableViewportSize(new Dimension(450, 161));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 83, 424, 189);
		panel_2.add(scrollPane);
		scrollPane.setViewportView(table);
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
					one frame = new one();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
//		try {
//			query("select","select * from member");
//			
//			while(rs.next()) {
////				if(search_t.getText().equals(rs.getString("Name"))) {
//					model1.addRow(new Object[] {rs.getString("m_id"), rs.getString("m_name"),rs.getString("m_tel"),rs.getString("m_home")});
////				}
//			}
//		}catch(Exception e1) {
//			e1.getStackTrace();
//		}
//		query("select", "select * from member where Name = 1");
		count = 1;
		viewData();
		dbDis();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search_b) {
			dbConnect();
			try {
				query("select","select * from member");
				
				while(rs.next()) {
//					if(search_t.getText().equals(rs.getString("Name"))) {
						model1.addRow(new Object[] {rs.getString("m_id"), rs.getString("m_name"),rs.getString("m_tel"),rs.getString("m_home")});
//					}
				}
			}catch(Exception e1) {
				e1.getStackTrace();
			}
		}
		else if(e.getSource()==back_b) {
			dispose();
		}
	}

}
