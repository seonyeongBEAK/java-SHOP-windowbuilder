package windowbulderTest;
import static windowbulderTest.coding_1.p_name1;
import static windowbulderTest.coding_1.onum;
import static windowbulderTest.coding_1.oprice;
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


public class orderAdd extends JFrame implements ActionListener{
	
	int i = 0;
	String num,result,id,name,tel,home;
	
	private JPanel contentPane;
	
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static int count = 0;
	static String Name;
	static JTextField o_name,p_name,o_num,o_tel,o_price,o_home;
	
	private JButton bt_order;

	
	shipping2 order = new shipping2();
	private JTextField o_id;

	
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderAdd frame = new orderAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		dbConnect();
//		query("select", "select * from order");
//		count = 1;
		viewData();
		dbDis();
	}
	/**
	 * Create the frame.
	 */
	public orderAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		o_name = new JTextField();
		o_name.setFont(new Font("����", Font.BOLD, 16));
		o_name.setBounds(154, 250, 116, 40);
		contentPane.add(o_name);
		o_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (5).png"));
		lblNewLabel_1.setBounds(72, 249, 70, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (6).png"));
		lblNewLabel_1_1.setBounds(72, 36, 70, 40);
		contentPane.add(lblNewLabel_1_1);
		
		p_name = new JTextField();
		p_name.setFont(new Font("����", Font.BOLD, 16));
		p_name.setColumns(50);
		p_name.setBounds(154, 37, 252, 40);
		p_name.setText(p_name1);
		contentPane.add(p_name);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (7).png"));
		lblNewLabel_1_1_1.setBounds(72, 86, 70, 40);
		contentPane.add(lblNewLabel_1_1_1);
		
		o_num = new JTextField();
		o_num.setFont(new Font("����", Font.BOLD, 16));
		o_num.setColumns(10);
		o_num.setBounds(154, 87, 116, 40);
		o_num.setText(onum);
		contentPane.add(o_num);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (8).png"));
		lblNewLabel_1_1_1_1.setBounds(72, 351, 70, 40);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		o_tel = new JTextField();
		o_tel.setFont(new Font("����", Font.BOLD, 16));
		o_tel.setColumns(50);
		o_tel.setBounds(154, 301, 252, 40);
		contentPane.add(o_tel);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (9).png"));
		lblNewLabel_1_1_1_1_1.setBounds(72, 136, 70, 40);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		o_price = new JTextField();
		o_price.setFont(new Font("����", Font.BOLD, 16));
		o_price.setColumns(10);
		o_price.setBounds(154, 137, 116, 40);
		o_price.setText(oprice);
		contentPane.add(o_price);
		
		JLabel lblNewLabel = new JLabel("\uBC30\uC1A1\uC9C0 \uC785\uB825");
		lblNewLabel.setBounds(154, 10, 116, 15);
		contentPane.add(lblNewLabel);
		
		bt_order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		bt_order.setBounds(177, 398, 97, 23);
		bt_order.addActionListener(this);
		contentPane.add(bt_order);
		
		o_home = new JTextField();
		o_home.setFont(new Font("����", Font.BOLD, 16));
		o_home.setColumns(50);
		o_home.setBounds(154, 351, 252, 40);
		contentPane.add(o_home);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_1_1_1_2.setBounds(72, 301, 70, 40);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1_2_1.setBounds(72, 200, 70, 40);
		contentPane.add(lblNewLabel_1_1_1_1_2_1);
		
		o_id = new JTextField();
		o_id.setFont(new Font("����", Font.BOLD, 16));
		o_id.setColumns(50);
		o_id.setBounds(154, 200, 116, 40);
		o_id.setText(mmid);
		contentPane.add(o_id);
	}
	public static void dbConnect() {
		driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("����̹� �˻� ����!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:odbc:shop";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/shop";
        String sql = "Select * From order";
		try {
         
            conn = DriverManager.getConnection(url,"root","1234");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("�����ͺ��̽� ���� ����!");            
         
        }
        catch(Exception e) {
            System.out.println("�����ͺ��̽� ���� ����!");
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
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_order) {
			dbConnect();
	
			try {	
				query("insert", "insert into order values ('"+p_name.getText()+"','"+o_num.getText()+"','"+o_price.getText()+"','"+o_id.getText()+"' ,'"+o_name.getText()+"', '"+o_tel.getText()+"', '"+o_home.getText()+"')");

			}catch(Exception e1) {
				e1.getStackTrace();
			}
			
			System.out.println("��ǰ �ֹ� �Ϸ�");
			JOptionPane.showMessageDialog(null, "��ǰ �ֹ� �Ϸ�");
			new test();

			
			p_name.setText("");
			o_num.setText("");
			o_price.setText("");
			o_id.setText("");
			o_name.setText("");
			o_tel.setText("");
			o_home.setText("");
			
			dbDis();
			
	
		}

	}
}

