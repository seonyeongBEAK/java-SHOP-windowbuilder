package windowbulderTest;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import static windowbulderTest.Login.mmid;

import java.awt.Color;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
   JOptionPane m = new JOptionPane();
   static JButton Join_b,login_b;
   static JTextField id_t;
   static String driver, url;
   static Connection conn;
   static Statement stmt;
   static ResultSet rs;
   static String tmpstr;
   private JPanel contentPane;
   String memberID;
   public static String mmid;


   memberData data = new memberData();
   main mp = new main();
   static long count = 0;
   private JPasswordField pwd_t;
   


   public Login() {
   	setTitle("Login");
   	setBackground(new Color(255, 250, 250));
	   

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 321);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(242, 242, 242));
      contentPane.setForeground(new Color(128, 128, 64));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);

      JButton Join_b = new JButton("");
      Join_b.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (35).jpg"));
      Join_b.setBounds(259, 204, 117, 41);
      Join_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new relog().setVisible(true);
			}
		});
      contentPane.add(Join_b);   
      
      login_b = new JButton("");
      login_b.addActionListener(this);
      login_b.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (34).jpg"));
      
      
      
      login_b.setBounds(78, 204, 117, 41);
      contentPane.add(login_b);
      
      id_t = new JTextField();
      id_t.setBounds(259, 78, 150, 32);
      contentPane.add(id_t);
      id_t.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (1).png"));
      lblNewLabel.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 16));
      lblNewLabel.setBounds(186, 76, 61, 32);
      contentPane.add(lblNewLabel);
      
      JLabel lblPw = new JLabel("");
      lblPw.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (2).png"));
      lblPw.setFont(new Font("占쏙옙占쏙옙", Font.BOLD, 16));
      lblPw.setBounds(186, 127, 61, 32);
      contentPane.add(lblPw);
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (32).jpg"));
      lblNewLabel_1.setForeground(new Color(87, 77, 34));
      lblNewLabel_1.setFont(new Font("占쌨먼울옙체", Font.BOLD, 25));
      lblNewLabel_1.setBounds(27, 67, 114, 41);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_1_2_1 = new JLabel("");
      lblNewLabel_1_2_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (33).jpg"));
      lblNewLabel_1_2_1.setForeground(new Color(87, 77, 34));
      lblNewLabel_1_2_1.setFont(new Font("占쌨먼울옙체", Font.BOLD, 25));
      lblNewLabel_1_2_1.setBounds(27, 108, 88, 41);
      contentPane.add(lblNewLabel_1_2_1);
      
      JLabel lblNewLabel_1_1 = new JLabel("");
      lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (31).jpg"));
      lblNewLabel_1_1.setForeground(new Color(87, 77, 34));
      lblNewLabel_1_1.setFont(new Font("占쌨먼울옙체", Font.BOLD, 25));
      lblNewLabel_1_1.setBounds(27, 10, 382, 58);
      contentPane.add(lblNewLabel_1_1);
      
      pwd_t = new JPasswordField();
      pwd_t.setBounds(259, 128, 150, 31);
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
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
		query("select","select m_id,m_pw from member where m_id like'"+id_t.getText()+"'");
		count = 1;
		viewData();
		dbDis();
		
	}
	

	 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login_b) {
			dbConnect();
			try {
				query("select","select * from member where m_id='"+id_t.getText() + "'");
				if(rs.next()) {
					if(id_t.getText().equals(rs.getString("m_id"))) {
						if(pwd_t.getText().equals(rs.getString("m_pw"))) {
							JOptionPane.showMessageDialog(null, "로그인 성공!");

							memberID = id_t.getText();
							mmid = memberID;
							System.out.println(mmid);



					           mp.setVisible(true);
					           dispose();
						}
						else JOptionPane.showMessageDialog(null, "비밀번호가 틀림!");
					}
				}
				else if(!rs.next()) {
					 if(id_t.getText().equals("admin")) {
							if(pwd_t.getText().equals("0000")) {
								JOptionPane.showMessageDialog(null, "관리자 로그인 성공!");
								admin ap = new admin();
								ap.setVisible(true);
								dispose();
								return;
							}
						}
					
						JOptionPane.showMessageDialog(null, "아이디가 틀림!");
				}
				else
					JOptionPane.showMessageDialog(null, "오류");
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			dbDis();
		}
	}

}