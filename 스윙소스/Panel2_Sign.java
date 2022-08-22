import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DB.Member_DB;

class Panel2_Sign extends JPanel 
{	
	private Frame F;
	
	private JLabel id_label;
	private JLabel password_label;
	private JLabel password_confirm_label;
	
	private JLabel name_label;
	private JLabel civil_id_label;
	private JLabel address_label;
	private JLabel phone_num_label;
	
	
	private JTextField id_field;
	private JPasswordField password_field;
	private JPasswordField password_confirm_field;
	
	private JTextField name_field;
	private JTextField civil_id_field;
	private JTextField address_field;
	private JTextField phone_num_field;
	
	private JButton Sign_Button;
	private JButton Prev_Button;
	
	public Panel2_Sign(Frame f) {
		setBackground(Color.GREEN);
		setSize(400, 400);
		setLayout(null);
		
		F = f;	
		
		id_label = new JLabel("아이디:");
		id_label.setBounds(20, 20, 100, 20);
		add(id_label);
		
		id_field = new JTextField("");
		id_field.setBounds(150, 20, 100, 20);
		add(id_field);
		
		password_label = new JLabel("비밀번호:");
		password_label.setBounds(20, 40, 100, 20);
		add(password_label);
		
		password_field = new JPasswordField("");
		password_field.setBounds(150, 40, 100, 20);
		add(password_field);
		
		password_confirm_label = new JLabel("비밀번호 확인:");
		password_confirm_label.setBounds(20, 60, 100, 20);
		add(password_confirm_label);
		
		password_confirm_field = new JPasswordField("");
		password_confirm_field.setBounds(150, 60, 100, 20);
		add(password_confirm_field);
		
		name_label = new JLabel("이름:");
		name_label.setBounds(20, 80, 100, 20);
		add(name_label);
		
		name_field = new JTextField("");
		name_field.setBounds(150, 80, 100, 20);
		add(name_field);
		
		civil_id_label = new JLabel("주민등록번호:");
		civil_id_label.setBounds(20, 100, 100, 20);
		add(civil_id_label);
		
		civil_id_field = new JTextField("");
		civil_id_field.setBounds(150, 100, 100, 20);
		add(civil_id_field);
		
		address_label = new JLabel("주소:");
		address_label.setBounds(20, 120, 100, 20);
		add(address_label);
		
		address_field = new JTextField("");
		address_field.setBounds(150, 120, 100, 20);
		add(address_field);
		
		phone_num_label = new JLabel("전화번호:");
		phone_num_label.setBounds(20, 140, 100, 20);
		add(phone_num_label);
		
		phone_num_field = new JTextField("");
		phone_num_field.setBounds(150, 140, 100, 20);
		add(phone_num_field);
		
		Sign_Button=new JButton("회원가입");
		Sign_Button.setBounds(200, 300, 100, 50);
		add(Sign_Button);
		
		Sign_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{	
					//insert into MEMBER(id,password,name,civil_id,address,phone_num) values(?,?,?,?,?,?);
					String id=id_field.getText();
					String password=password_field.getText();
					String password_confirm=password_confirm_field.getText();
					
					String name=name_field.getText();
					String civil_id=civil_id_field.getText();
					String address=address_field.getText();
					String phone_num=phone_num_field.getText();
					
					Member_DB memberdb=new Member_DB();
					memberdb.Connect();
					
					if(password.equals(password_confirm)==true) {
						//비밀번호 검사
						
						//주민등록 번호 검사
						//940512-1789312
						//6자리-7자리 (총 14자리)
						if(civil_id.length() == 14) {
							//길이는 정상
							//7째 자리에 하이픈이 있는지 확인
							//그리고 성별 체크 (1,2) - 8번째 1,2번이 아니면 잘못된것
							if (civil_id.charAt(6)=='-')
							{
								if(civil_id.charAt(7)=='1' || civil_id.charAt(7)=='2') {
									//
									memberdb.Sign_Member(id, password, name, civil_id, address, phone_num);
									
									F.Move_Sign_Panel();					
									//
								} else {
									JOptionPane.showMessageDialog(null,"주민등록 성별 확인 하세요!");
								}
							} else {
								JOptionPane.showMessageDialog(null,"주민등록 하이픈 확인 하세요!");
							}
							
						} else {
							JOptionPane.showMessageDialog(null,"주민등록 번호 길이 확인 하세요!");
						}
						
					} else {
						JOptionPane.showMessageDialog(null,"비밀번호 확인하세요!");
					}
					
					
				}
		});
		
		Prev_Button=new JButton("이전");
		Prev_Button.setBounds(50, 300, 100, 50);
		add(Prev_Button);
		
		Prev_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					F.Move_Login_Panel();					
				}
		});
		
		setVisible(true);
	} 
}