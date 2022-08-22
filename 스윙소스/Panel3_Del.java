import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.Member_DB;

public class Panel3_Del extends JPanel 
{

	private Frame F;
	
	private JLabel id_label;
	private JLabel password_label;
	
	private JTextField id_field;
	private JPasswordField password_field;
	
	private JButton Del_Button;
	private JButton Prev_Button;
	
	public Panel3_Del(Frame f) {
		setBackground(Color.BLUE);
		setSize(400, 400);
		setLayout(null);
		F = f;
		
		id_label = new JLabel("아이디");
		id_label.setBounds(20, 20, 100, 20);
		add(id_label);
		
		id_field = new JTextField("");
		id_field.setBounds(150, 20, 100, 20);
		add(id_field);
		
		password_label = new JLabel("비밀번호");
		password_label.setBounds(20, 40, 100, 20);
		add(password_label);
		
		password_field = new JPasswordField("");
		password_field.setBounds(150, 40, 100, 20);
		add(password_field);
		
		Del_Button=new JButton("회원탈퇴");
		Del_Button.setBounds(200, 300, 100, 50);
		add(Del_Button);
		
		Del_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{								
					Member_DB memberdb=new Member_DB();
					memberdb.Connect();
					
					memberdb.Delete_Id(id_field.getText(), password_field.getText());
					
					id_field.setText("");
					password_field.setText("");					
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