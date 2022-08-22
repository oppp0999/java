package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Member_DB 
{
	private Connection con;
	private Statement statement;
	private ResultSet resultset;
	PreparedStatement pstmt;
	
	public Member_DB()
	{
		
	}
	
	public void Connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MEMBER_DB?serverTimezone=UTC&useSSL=false","root","1234");
			statement = con.createStatement();			
		}
		catch(Exception e)
		{
			System.out.println("데이버테이스 연결 오류: "+e.getMessage());
		}
	}
	
	public boolean Try_Login(String input_id, String input_pass)
	{
		String SQL="SELECT * FROM MEMBER";
		try {
			resultset = statement.executeQuery(SQL);
			
			while(resultset.next()){
				String id = resultset.getString("id");
				System.out.println("id:"+id);
				String pass=resultset.getString("password");
				System.out.println("pass:"+pass);
				
				String temp="";
				temp=resultset.getString("name");
				temp=resultset.getString("civil_id");
				temp=resultset.getString("address");
				temp=resultset.getString("phone_num");
				
				
				if(input_id.equals(id)==true)
				{
					if(input_pass.equals(pass)==true)
					{
						JOptionPane.showMessageDialog(null, "아이디,패스워드 일치!"); 
						return true;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "패스워드 불일치!"); 
						return false;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "아이디,패스워드 불일치!"); 
					return false;
				}			
			}
			con.close();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void Delete_Id(String input_id, String input_pass)
	{

		try {							
			String SQL = "DELETE FROM MEMBER WHERE id=? AND password=?";
	        pstmt = (PreparedStatement) con.prepareStatement(SQL);
	       
	        pstmt.setString(1, input_id);
	        pstmt.setString(2, input_pass);
	        
	        if(pstmt.executeUpdate()==1){
        
	        	JOptionPane.showMessageDialog(null, "회원탈퇴 성공!"); 

	        } else {
	        	JOptionPane.showMessageDialog(null, "아이디, 비밀번호 확인 하세요!"); 
	        }
	        	        	        
	    } catch(Exception e) {
	        e.printStackTrace();
	       
	    }
		
	}
	
	public void Modify_Info(String input_id, String input_pass,
			String name, String civil_id, String address, String phone_num)
	{
		String SQL = "UPDATE MEMBER SET id=? ,password=?, name=?, civil_id=?, address=?, phone_num=?";
		try {
			pstmt = (PreparedStatement) con.prepareStatement(SQL);
			
			pstmt.setString(1, input_id);
	        pstmt.setString(2, input_pass);
	        pstmt.setString(3, name);
	        pstmt.setString(4, civil_id);
	        pstmt.setString(5, address);
	        pstmt.setString(6, phone_num);
	        	        
	        if(pstmt.executeUpdate()==1){
	    
	        	JOptionPane.showMessageDialog(null, "회원정보 변경 성공!"); 

	        } else {
	        	JOptionPane.showMessageDialog(null, "아이디, 비밀번호 확인 하세요!"); 
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
        
	}
	
	public void Sign_Member(String input_id, String input_pass,
			String name, String civil_id, String address, String phone_num)
	{
		String SQL = "insert into MEMBER(id,password,name,civil_id,address,phone_num) values(?,?,?,?,?,?)";
		try {
			pstmt = (PreparedStatement) con.prepareStatement(SQL);
			
			pstmt.setString(1, input_id);
	        pstmt.setString(2, input_pass);
	        pstmt.setString(3, name);
	        pstmt.setString(4, civil_id);
	        pstmt.setString(5, address);
	        pstmt.setString(6, phone_num);
	        	        
	        if(pstmt.executeUpdate()==1){
	    
	        	JOptionPane.showMessageDialog(null, "회원가입 성공!"); 

	        } else {
	        	JOptionPane.showMessageDialog(null, "회원가입 실패!"); 
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] Get_Info_WhereId(String input_id) {
		String[] info=new String[6];
		String SQL = "select * from MEMBER where id="+"'"+input_id+"'";
		
		try {
			resultset = statement.executeQuery(SQL);
			
			if(resultset.next()){

	        	JOptionPane.showMessageDialog(null, "아이디로 정보 검색 성공!"); 
	        	
	        	info[0] = resultset.getString("id");
				System.out.println("id:"+info[0]);
				
				info[1]=resultset.getString("password");
				System.out.println("pass:"+info[1]);

				info[2]=resultset.getString("name");
				System.out.println("name:"+info[2]);
				
				info[3]=resultset.getString("civil_id");
				System.out.println("civil_id:"+info[3]);
				
				info[4]=resultset.getString("address");
				System.out.println("address:"+info[4]);
				
				info[5]=resultset.getString("phone_num");
				System.out.println("phone_num:"+info[5]);
				
	        } else {
	        	JOptionPane.showMessageDialog(null, "아이디로 정보 검색 실패!"); 
	        }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return info;
	}
	
	public String getNameById(String input_id) {
		
		String SQL = "select name from MEMBER where id="+"'"+input_id+"'";
		String name = "";
		try {
			resultset = statement.executeQuery(SQL);
			
			if(resultset.next()){
				
				name = resultset.getString("name");
				System.out.println("name:"+name);
	        	
	        } else {
	        	JOptionPane.showMessageDialog(null, "아이디로 정보 검색 실패!"); 
	        }		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return name;
				
	}
}
