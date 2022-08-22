import java.awt.CardLayout;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	private CardLayout cards = new CardLayout();
	
	private Panel1_Login panel1;
	private Panel2_Sign panel2;
	private Panel3_Del panel3;
	private Panel4_Login_Success panel4;
	private Panel5_Modify panel5;
	
	public Frame() {
		setSize(400, 400);
		this.setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1=new Panel1_Login(this);
		panel2=new Panel2_Sign(this);
		panel3=new Panel3_Del(this);
		panel4=new Panel4_Login_Success(this);
		panel5=new Panel5_Modify(this);
		
		this.add("page1_login", panel1);
		this.add("page2_sign", panel2);
		this.add("page3_del", panel3);
		this.add("page4_success", panel4);
		this.add("page5_modify", panel5);
		
		setVisible(true);
	}
	
	public Panel1_Login get_panel1() {
		return panel1;
	}
	
	public Panel4_Login_Success get_panel4() {
		return panel4;
	}
	
	public Panel5_Modify get_panel5() {
		return panel5;
	}
	
	public void setLoginSuccessIdLabel(Panel1_Login panel_from,Panel4_Login_Success panel_to) {
		panel_to.setIdLabelText(panel_from.getIdFieldText());
	}
	
	public void setModifyIdText(Panel4_Login_Success panel_from,Panel5_Modify panel_to) {
		panel_to.setIdStringText(panel_from.getIdLabelText());
	}
	
	public void sendModifyInfo_4_to_5(Panel4_Login_Success panel_from,Panel5_Modify panel_to) {
		panel_to.setInfo(panel_from.getInfo());			
	}
	
	public void sendName_1_to_4(Panel1_Login panel_from,Panel4_Login_Success panel_to) {
		panel_to.setName(panel_from.getName());
	}
	
	public void Move_Login_Panel() 
	{
		cards.show(this.getContentPane(), "page1_login");
	}
	
	public void Move_Sign_Panel() 
	{
		cards.show(this.getContentPane(), "page2_sign");

	}
	
	public void Move_Del_Panel() 
	{
		cards.show(this.getContentPane(), "page3_del");
	}
	
	public void Move_Success_Panel() 
	{
		cards.show(this.getContentPane(), "page4_success");
	}
	
	public void Move_Modify_Panel() 
	{
		cards.show(this.getContentPane(), "page5_modify");
	}

}