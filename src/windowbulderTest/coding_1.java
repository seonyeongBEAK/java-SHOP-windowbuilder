package windowbulderTest;
import static windowbulderTest.Login.mmid;
import java.awt.EventQueue;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
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

public class coding_1 extends JFrame implements ActionListener {
	int i = 0;

	private JPanel contentPane;
	JSpinner spinner;
	
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static String tmpstr;
	static int count = 0;
	public static String p_name1  = "Ai자율주행차";
	public static String onum;
	public static String oprice;

	   memberData data = new memberData();
	   test t = new test();
	
	private int price = 35000;
	private int o_num, sum;

	private String o_sum;

//	String o_price;
	
	JButton bt_order, other;
	private JTextField result;
	
	String id, name,tel,home;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coding_1 frame = new coding_1();
					frame.setTitle("�ֹ�");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		dbConnect();

//		viewData();
//		dbDis();
	}

	/**
	 * Create the frame.
	 */
	public coding_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (2).jpg"));
		lblNewLabel_1.setBounds(23, 69, 300, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (3).jpg"));
		lblNewLabel_2.setBounds(329, 75, 156, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, 10, 460, 59);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694_-001 (41).jpg"));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("�޸տ�����", Font.BOLD, 28));
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (9).jpg"));
		lblNewLabel_2_1.setBounds(329, 171, 59, 33);
		contentPane.add(lblNewLabel_2_1);
		
		
		Choice choice = new Choice();
		choice.setBounds(329, 217, 156, 21);
		contentPane.add(choice);
		
		choice.add("-");
		
		bt_order = new JButton("");
		bt_order.addActionListener(this);
		bt_order.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (10).jpg"));
		bt_order.setBounds(335, 326, 148, 43);
		contentPane.add(bt_order);
		
		other = new JButton("");
		other.addActionListener(this);
		other.setIcon(new ImageIcon("C:\\Users\\yungday\\Downloads\\\uC790\uC728\uC8FC\uD589\uCE74-001 (11).jpg"));
		other.setBounds(33, 379, 462, 56);
		contentPane.add(other);
		
		result = new JTextField();
		result.setFont(new Font("����", Font.PLAIN, 12));
		result.setText("\uC8FC\uBB38 \uAC00\uACA9");
		result.setBounds(336, 283, 149, 33);
		contentPane.add(result);
		result.setColumns(10);
		
//		JSpinner spinner = new JSpinner();
//		spinner.setBounds(358, 213, 30, 22);
//		contentPane.add(spinner);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("spinner value : "+spinner.getValue());
//				o_num = (int) spinner.getValue();
				//�켱 �ش� ������Ʈ�� String���� ��ȯ�� �� Integer.parseInt
				o_num= Integer.parseInt(String.valueOf(spinner.getValue()));
				onum=String.valueOf(spinner.getValue());
				sum = price * o_num;
		        System.out.println(sum);
				System.out.println(onum);
				o_sum=String.valueOf(sum);

				result.setText(o_sum);
			}
		});
		//spinner.setModel(new SpinnerNumberModel(10, 10, 20, 2));
		SpinnerNumberModel numModel = new SpinnerNumberModel(0, 0, 20, 1);
		spinner.setModel(numModel);
		
		spinner.setBounds(400, 171, 85, 33);
		contentPane.add(spinner);


	}
	


//	public static void dbConnect() {
//    	driver = "sun.jdbc.odbc.JdbcOdbcDriver";
//    	try{
//    		Class.forName("com.mysql.jdbc.Driver");
//    		System.out.println("����̹� �˻� ����!");        
//    	}catch(ClassNotFoundException e){
//    		System.err.println("error = " + e);
//    	}
//        
//    	
//        url = "jdbc:odbc:shop";
//        conn = null;
//        stmt = null;
//        rs = null;
//        String url = "jdbc:mysql://localhost/shop";	//DB �ּ�
//        String sql = "Select * From member";			//DB ���̺��
//
//		try {
//         
//            conn = DriverManager.getConnection(url,"root","1234");	//���ᰴü : �ּ��� ���̵�� ������� ����
//
//            stmt = conn.createStatement( );	//���ఴü
//
//            rs = stmt.executeQuery(sql);	//���ఴü
//
//            System.out.println("�����ͺ��̽� ���� ����!");    
//            
//         
//        }
//        catch(Exception e) {
//            System.out.println("�����ͺ��̽� ���� ����!");
//        }
//	}

//	public static void query(String order, String sql) throws SQLException {
//		if (order == "select") {
//			rs = stmt.executeQuery(sql);
//		} 
//
//		else {
//			stmt.executeUpdate(sql);
//		}
//	}
//
//	public static void viewData() throws SQLException {
//		if(!rs.next()){
//			System.out.println("!rs.next()");
//			count--;
//		}
//		else{		
//				System.out.println("rs.next()");
//		}
//	}

//	public static void dbDis(){
//		try {
//			if (conn != null)
//				conn.close();
//			if (stmt != null)
//				stmt.close();
//			System.out.println("�����ͺ��̽� ���� ����!");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//


	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==�ֹ��ϱ�) {
//			dbConnect();
////			o_num = Integer.parseInt(num.getText());
////			o_price = price * o_num;
//			try {	
//				query("select", "select * from member");
////				query("insert", "insert into order values('"+p_name+"','"+num.getText()+"','"+p_name+"','"+result.getText()+"')");
//
////						query("insert", "insert into order values('"+rs.getString("Name")+"','"+p_name+"','"+num.getText()+"','"+rs.getString("Home")+"','"+result.getText()+"')");
//		
////						query("insert","INSERT INTO `newmodel`.`order` (`Mname`, `Oname`, `Onum`, `Odel`, `Oprice`) VALUES ('test', 'Ai', '2', 'test', '100');");
//			}catch(Exception e1) {
//				e1.getStackTrace();
//			}
//			System.out.println("��ǰ �ֹ� �Ϸ�");
//			dbDis();
//
//	
//		}
		if(e.getSource()==bt_order) {
//			bb=String.valueOf(o_num);
			onum=String.valueOf(o_num);
//			cc=String.valueOf(sum);
			oprice=String.valueOf(sum);


//		new orderAdd().setVisible(true);
		new shipping1().setVisible(true);
		dispose();
//			dbConnect();
////	         System.out.println(data.getMember_id());
//			try {
//				id = data.getMember_id();
//				query("select","select * from member");
////				query("select","select * from member m_id = '"+id+"'");
//
//				if(rs.next()) {
////						if(id.equals(rs.getString("m_id"))) {
//							
////							name = rs.getString("m_name");
////							tel = rs.getString("m_tel");
////							home = rs.getString("m_home");
////							
////							System.out.println(name);
////							System.out.println(tel);
////							System.out.println(home);
////							System.out.println(data.getMember_id());
//					System.out.println(mmid);
//							
//							
////							data.setMember_name(name);
////							
////							memberID = id_t.getText();
////							data.setMember_id(memberID);
////							
////							data.setMember_tel(rs.getString("m_tel"));
////							data.setMember_home(rs.getString("m_home"));
////					         System.out.println(data.getMember_name());
////					         System.out.println(data.getMember_tel());
////					         System.out.println(data.getMember_home());
//
////							new orderAdd().setVisible(true);
//							new test02().setVisible(true);
//
//							dispose();
////						}
//				}
//			
//			}catch(Exception e1) {
//				e1.printStackTrace();
//			}
//			dbDis();
		}else if(e.getSource()==other) {
			new main().setVisible(true);
			dispose();
		}
//		else if(e.getSource()==a) {
//			o_num = Integer.parseInt(num.getText());
//			sum = price * o_num;
//			
//			onum = Integer.toString(o_num);
////			bb = num.getText();
//
//			oprice = Integer.toString(sum);
//			cc = result.getText();
//
//			result.setText(oprice);
//			
//			
//	}
}
	
}


