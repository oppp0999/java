import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DB.Member_DB;

class Panel4_Login_Success extends JPanel 
{	
	private Frame F;
	
	private JButton Modify_Button;
	private JButton Prev_Button;
	
	private Panel1_Login LoginPanel;
	
	private JLabel id_label;
	private JLabel name_label;
	
	
	private String id;
	private String info[];
	private String name;
	
	public void setName(String name) {
		this.name=name;
		name_label.setText(name+"님");
	}
	
	public String getName() {
		return name;
	}
	
	public String getIdLabelText() {
		return id_label.getText();
	}
	
	public void setIdLabelText(String text) {
		id_label.setText(text);
	}
	
	public void setInfo(String[] input) {
		info=input;
	}
	public String[] getInfo() {
		return info;
	}
	
	public Panel4_Login_Success(Frame f) {
		setBackground(Color.yellow);
		setSize(400, 400);
		setLayout(null);
		
		F = f;	
		
		Modify_Button=new JButton("정보수정");
		Modify_Button.setBounds(200, 300, 100, 50);
		add(Modify_Button);
		
		id_label = new JLabel("ff");
		id_label.setBounds(300, 20, 100, 20);
		add(id_label);
		
		name_label = new JLabel("name");
		name_label.setBounds(300, 0, 100, 20);
		add(name_label);
		
		Modify_Button.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent arg0) 
				{							
					if(f.get_panel5()!=null) {
						JOptionPane.showMessageDialog(null,"정보 수정 페이지에 넘길 아이디값:"+(id_label.getText()));
						
						f.setModifyIdText(f.get_panel4(), f.get_panel5());	
						
						Member_DB memberdb=new Member_DB();
						memberdb.Connect();
						info=new String[6];
						
						info=memberdb.Get_Info_WhereId(id_label.getText().toString());
						f.sendModifyInfo_4_to_5(f.get_panel4(),f.get_panel5());
						
					} else {
						JOptionPane.showMessageDialog(null,"정보 수정 판넬 불러올수 없음!");
					}
					
					
					F.Move_Modify_Panel();					
				}
		});
		
		setVisible(true);
	} 
}