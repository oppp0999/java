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
		
		id_label = new JLabel("���̵�:");
		id_label.setBounds(20, 20, 100, 20);
		add(id_label);
		
		id_field = new JTextField("");
		id_field.setBounds(150, 20, 100, 20);
		add(id_field);
		
		password_label = new JLabel("��й�ȣ:");
		password_label.setBounds(20, 40, 100, 20);
		add(password_label);
		
		password_field = new JPasswordField("");
		password_field.setBounds(150, 40, 100, 20);
		add(password_field);
		
		password_confirm_label = new JLabel("��й�ȣ Ȯ��:");
		password_confirm_label.setBounds(20, 60, 100, 20);
		add(password_confirm_label);
		
		password_confirm_field = new JPasswordField("");
		password_confirm_field.setBounds(150, 60, 100, 20);
		add(password_confirm_field);
		
		name_label = new JLabel("�̸�:");
		name_label.setBounds(20, 80, 100, 20);
		add(name_label);
		
		name_field = new JTextField("");
		name_field.setBounds(150, 80, 100, 20);
		add(name_field);
		
		civil_id_label = new JLabel("�ֹε�Ϲ�ȣ:");
		civil_id_label.setBounds(20, 100, 100, 20);
		add(civil_id_label);
		
		civil_id_field = new JTextField("");
		civil_id_field.setBounds(150, 100, 100, 20);
		add(civil_id_field);
		
		address_label = new JLabel("�ּ�:");
		address_label.setBounds(20, 120, 100, 20);
		add(address_label);
		
		address_field = new JTextField("");
		address_field.setBounds(150, 120, 100, 20);
		add(address_field);
		
		phone_num_label = new JLabel("��ȭ��ȣ:");
		phone_num_label.setBounds(20, 140, 100, 20);
		add(phone_num_label);
		
		phone_num_field = new JTextField("");
		phone_num_field.setBounds(150, 140, 100, 20);
		add(phone_num_field);
		
		Sign_Button=new JButton("ȸ������");
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
						//��й�ȣ �˻�
						
						//�ֹε�� ��ȣ �˻�
						//940512-1789312
						//6�ڸ�-7�ڸ� (�� 14�ڸ�)
						if(civil_id.length() == 14) {
							//���̴� ����
							//7° �ڸ��� �������� �ִ��� Ȯ��
							//�׸��� ���� üũ (1,2) - 8��° 1,2���� �ƴϸ� �߸��Ȱ�
							if (civil_id.charAt(6)=='-')
							{
								if(civil_id.charAt(7)=='1' || civil_id.charAt(7)=='2') {
									//
									memberdb.Sign_Member(id, password, name, civil_id, address, phone_num);
									
									F.Move_Sign_Panel();					
									//
								} else {
									JOptionPane.showMessageDialog(null,"�ֹε�� ���� Ȯ�� �ϼ���!");
								}
							} else {
								JOptionPane.showMessageDialog(null,"�ֹε�� ������ Ȯ�� �ϼ���!");
							}
							
						} else {
							JOptionPane.showMessageDialog(null,"�ֹε�� ��ȣ ���� Ȯ�� �ϼ���!");
						}
						
					} else {
						JOptionPane.showMessageDialog(null,"��й�ȣ Ȯ���ϼ���!");
					}
					
					
				}
		});
		
		Prev_Button=new JButton("����");
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