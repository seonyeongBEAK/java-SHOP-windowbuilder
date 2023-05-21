package windowbulderTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class sang extends JFrame implements ActionListener {
	int i = 0;
	private static JPanel contentPane;
	private static JTextField price;
	private static JTextField pname;
	private static JTextField pcontent;
	JButton pInsert;
	

	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static int count = 0;
	private JLabel lblNewLabel_1_2;
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
//		query("select", "select * from product where Pname = 1");
//		count = 1;
		viewData();
		dbDis();

	}

	/**
	 * Create the frame.
	 */
	public sang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, 10, 460, 59);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (17).png"));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 28));
		
		price = new JTextField();
		price.setToolTipText("\uAE08\uC561\uC744 \uC785\uB825\uD558\uC138\uC694.");
		price.setFont(new Font("굴림", Font.PLAIN, 14));
		price.setBounds(118, 139, 365, 33);
		contentPane.add(price);
		price.setColumns(10);
		
		pInsert = new JButton("");
		pInsert.addActionListener(this);
		pInsert.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001.png"));
		pInsert.setBounds(23, 334, 462, 56);
		contentPane.add(pInsert);
		
		pname = new JTextField();
		pname.setToolTipText("\uC0C1\uD488\uBA85\uC744 \uC785\uB825\uD558\uC138\uC694.");
		pname.setBounds(118, 94, 365, 33);
		contentPane.add(pname);
		pname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBA85 :");
		lblNewLabel_1.setBounds(49, 93, 57, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAE08\uC561 :");
		lblNewLabel_1_1.setBounds(59, 138, 57, 35);
		contentPane.add(lblNewLabel_1_1);
		
		pcontent = new JTextField();
		pcontent.setToolTipText("\uC0C1\uD488 \uC815\uBCF4\uB97C \uC785\uB825\uD558\uC2DC\uC624.");
		pcontent.setBounds(118, 195, 365, 99);
		contentPane.add(pcontent);
		pcontent.setColumns(10);
		
		lblNewLabel_1_2 = new JLabel("상품 설명 :");
		lblNewLabel_1_2.setBounds(35, 227, 71, 35);
		contentPane.add(lblNewLabel_1_2);
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
        String sql = "Select * From product";
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
		if(e.getSource()==pInsert) {
			dbConnect();
			try {
				query("insert", "insert into product values('"+pname.getText()+"','"+price.getText()+"','"+pcontent.getText()+"')");
		
			}catch(Exception e1) {
				e1.getStackTrace();
			}
			System.out.println("상품 등록 완료");
			dbDis();
			main main = new main();
			main.setVisible(true);
			dispose();
			pname.setText("");
			pcontent.setText("");
			price.setText("");
		}

	}
}

