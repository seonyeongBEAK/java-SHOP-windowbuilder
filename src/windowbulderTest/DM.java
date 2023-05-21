package windowbulderTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class DM extends JFrame implements ActionListener {

	private static int count;
	private static String driver;
	private static String url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	private JPanel contentPane;
	private JTextField Dm;
	private JTextField title;
	private JButton bt_dm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sang frame = new sang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
//		query("select", "select * from qna where Ti = 1");
//		count = 1;
		viewData();
		dbDis();

	}

	/**
	 * Create the frame.
	 */
	public DM() {
		setTitle("Q&A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 291);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (36).jpg"));
		lblNewLabel.setBounds(28, 10, 380, 40);
		contentPane.add(lblNewLabel);
		
		Dm = new JTextField();
		Dm.setToolTipText("\uB0B4\uC6A9\uC744 \uC791\uC131\uD558\uC2DC\uC624.");
		Dm.setHorizontalAlignment(SwingConstants.CENTER);
		Dm.setBounds(28, 80, 380, 117);
		contentPane.add(Dm);
		Dm.setColumns(5000);
		
		title = new JTextField();
		title.setText("\uC81C\uBAA9 :");
		title.setBounds(28, 60, 380, 21);
		contentPane.add(title);
		title.setColumns(100);
		
		bt_dm = new JButton("");
		bt_dm.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (37).jpg"));
		bt_dm.setBounds(141, 201, 169, 41);
		bt_dm.addActionListener(this);
		contentPane.add(bt_dm);
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
	       String sql = "Select * From qna";
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
		if(e.getSource()==bt_dm) {
			dbConnect();
			try {
				query("insert", "insert into qna values('"+title.getText()+"','"+Dm.getText()+"')");
		
			}catch(Exception e1) {
				e1.getStackTrace();
			}
			System.out.println("문의사항 작성 완료");
			JOptionPane.showMessageDialog(null, "문의사항 작성 완료");

			new main().setVisible(true);
			dispose();

			title.setText("");
			Dm.setText("");
		}

	}
}
