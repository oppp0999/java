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

class Panel5_Modify extends JPanel 
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
	
	private JButton Modify_Button;
	private JButton Prev_Button;
	
	private String id;
	private String info[];
	
	public void setIdStringText(String text) {
		id=text;
		
		JOptionPane.showMessageDialog(null,id);
	}
	
	public void setInfo(String[] input) {
		info=input;
		
		id_field.setText(info[0]);
		password_field.setText(info[1]);
		password_confirm_field.setText(info[1]);
		name_field.setText(info[2]);
		civil_id_field.setText(info[3]);
		address_field.setText(info[4]);
		phone_num_field.setText(info[5]);
		
	}
	public String[] getInfo() {
		return info;
	}
	
	public Panel5_Modify(Frame f) {
		setBackground(Color.pink);
		setSize(400, 400);
		setLayout(null);
		
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
		
		password_confirm_label = new JLabel("이름:");
		password_confirm_label.setBounds(20, 80, 100, 20);
		add(password_confirm_label);
		
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
		
		
		
		F = f;	
		
		
		Member_DB memberdb=new Member_DB();
		memberdb.Connect();
		
		Prev_Button=new JButton("이전");
		Prev_Button.setBounds(50, 300, 100, 50);
		add(Prev_Button);
		
		Prev_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					F.Move_Success_Panel();					
				}
		});
		
		
		Modify_Button=new JButton("정보수정");
		Modify_Button.setBounds(200, 300, 100, 50);
		add(Modify_Button);
		
		Modify_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					JOptionPane.showMessageDialog(null,id);
					
					Member_DB memberdb=new Member_DB();
					memberdb.Connect();
					
					info[0]=id_field.getText();
					info[1]=password_field.getText();
					info[2]=name_field.getText();
					info[3]=civil_id_field.getText();
					info[4]=address_field.getText();
					info[5]=phone_num_field.getText();
					
					memberdb.Modify_Info(info[0], info[1], info[2], info[3], info[4], info[5]);
				}
		});
		
		setVisible(true);
	} 
}