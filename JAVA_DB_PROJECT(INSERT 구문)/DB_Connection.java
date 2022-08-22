package JAVA_DB_PROJECT;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DB_Connection() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql_practice?serverTimezone=UTC&useSSL=false","root","");
			st = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("데이버테이스 연결 오류: "+e.getMessage());
		}
	}
	
	public void Search()
	{
		String SQL="SELECT * FROM employee";
		try {
			ResultSet rs = st.executeQuery(SQL);
			//RESULTSET은 테이블 형태의 데이터
			//statement 객체가 SQL쿼리문장을 실행한다.
			
			while(rs.next()){
				String Name = rs.getString("name");
				System.out.print(Name+" ");
				int age=rs.getInt("age");
				System.out.print(age+" ");
				String company = rs.getString("company");
				System.out.print(company+" ");
				String position = rs.getString("position");
				System.out.print(position+" ");
				int salary=rs.getInt("salary");
				System.out.print(salary+" ");
				int year=rs.getInt("year");
				System.out.print(year+" ");
				System.out.println("");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void Condition_Search_Name(String input_name)
	{
		
		String SQL = "SELECT * FROM employee where name =" + "'" + input_name + "'";
				try {
					ResultSet rs = st.executeQuery(SQL);
					
					while(rs.next()){
						String Name = rs.getString("name");
						System.out.print(Name+" ");
						int age=rs.getInt("age");
						System.out.print(age+" ");
						String company = rs.getString("company");
						System.out.print(company+" ");
						String position = rs.getString("position");
						System.out.print(position+" ");
						int salary=rs.getInt("salary");
						System.out.print(salary+" ");
						int year=rs.getInt("year");
						System.out.print(year+" ");
						System.out.println("");				
					}												
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 			
	}
	

}
