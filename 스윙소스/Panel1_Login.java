import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.Member_DB;



public class Panel1_Login extends JPanel 
{
	private JButton Login_Button;
	private JButton Sign_Button;
	private JButton Del_Button;
	
	private JLabel login_label;
	
	private JLabel id_label;
	private JLabel password_label;
	
	private JTextField id_field;
	private JPasswordField password_field;
	
	private Frame F;
	
	private Panel4_Login_Success login_success;
	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIdFieldText() {
	      return id_field.getText();
	}
	
	public Panel1_Login(Frame f) {
		setBackground(Color.RED);
		setSize(400, 400);
		setLayout(null);
		
		F = f;
		
		id_label = new JLabel("���̵�");
		id_label.setBounds(20, 20, 100, 20);
		add(id_label);
		
		id_field = new JTextField("");
		id_field.setBounds(150, 20, 100, 20);
		add(id_field);
		
		password_label = new JLabel("��й�ȣ");
		password_label.setBounds(20, 40, 100, 20);
		add(password_label);
		
		password_field = new JPasswordField("");
		password_field.setBounds(150, 40, 100, 20);
		add(password_field);
		
		Login_Button = new JButton("�α���");
		Sign_Button = new JButton("ȸ������");
		Del_Button = new JButton("ȸ��Ż��");
		
		Login_Button.setBounds(150, 200, 100, 50);
		add(Login_Button);
		
		Sign_Button.setBounds(50, 300, 100, 50);
		add(Sign_Button);
		
		Del_Button.setBounds(200, 300, 100, 50);
		add(Del_Button);
			
		Login_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{			
					boolean is_same=false;
					
					String id=id_field.getText();
					String password=password_field.getText();
					
					Member_DB memberdb=new Member_DB();
					memberdb.Connect();
					
					boolean correct=false;
					
					correct=memberdb.Try_Login(id,password);
					
					if(correct==true)
					{
						//JOptionPane.showMessageDialog(null,"�α��� ����!");

						if(f.get_panel4()!=null) {
							JOptionPane.showMessageDialog(null,"�α��� ���� �������� �ѱ� ���̵�:"+(id_field.getText()));
							
							String name=memberdb.getNameById(id);
							setName(name);
							f.setLoginSuccessIdLabel(f.get_panel1(), f.get_panel4());
							f.sendName_1_to_4(f.get_panel1(), f.get_panel4());
						} else {
							JOptionPane.showMessageDialog(null,"�α��� �ǳ� �ҷ��ü� ����!");
						}
						
				
						id_field.setText("");
						password_field.setText("");
						
						F.Move_Success_Panel();
																		
					}
					else
					{
						//�α��� ����
						id_field.setText("");
						password_field.setText("");					
					}
				}
		});
		
		Sign_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					F.Move_Sign_Panel();					
				}
		});
		
		Del_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					F.Move_Del_Panel();					
				}
		});		
		
		setVisible(true);
	} 
	
	

}
