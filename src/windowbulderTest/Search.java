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

public class Search extends JFrame implements ActionListener{

	private JPanel panel_2;
	static String[] head = new String[] {"상품명","가격","상품설명"};
	static DefaultTableModel model1 = new DefaultTableModel(head,0);
	static JTable table;
	
	
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static long count = 0;
	static JButton search_b,back_b;


	public Search() {
		setTitle("상품 목록");
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 346);
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setLayout(null);
		setContentPane(panel_2);
		
		search_b = new JButton("상품 전체 조회");
		search_b.setBackground(SystemColor.inactiveCaption);
		search_b.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		search_b.addActionListener(this);
		search_b.setBounds(188, 28, 138, 41);
		panel_2.add(search_b);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 96, 455, 161);
		panel_2.add(panel);
		
		table = new JTable(model1);
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setFont(new Font("����", Font.PLAIN, 14));
		table.setPreferredScrollableViewportSize(new Dimension(450, 161));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		back_b = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		back_b.setFont(new Font("돋움", Font.PLAIN, 13));
		back_b.setBackground(SystemColor.inactiveCaption);
		back_b.setBounds(395, 267, 91, 23);
		back_b.addActionListener(this);
		panel_2.add(back_b);
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

	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
		if(e.getSource()==search_b) {
			dbConnect();
			model1.setRowCount(0);

			try {
				query("select","select * from product");

				while(rs.next()) {
						model1.addRow(new Object[] {rs.getString("p_name"), rs.getString("p_price"), rs.getString("p_content")});
				}
			}catch(Exception e1) {
				e1.getStackTrace();
			}
		}
		else if(e.getSource()==back_b) {
			model1.setRowCount(0);
			new main().setVisible(true);
			dispose();
		}
	}


}
