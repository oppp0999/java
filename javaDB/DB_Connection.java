package java_db_company_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection 
{
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DB_Connection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JAVA_DB_Test?serverTimezone=UTC&useSSL=false","root","1234");
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

		} catch (SQLException e) 
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
	
	public void Condition_Search_Age(int input_age,int input_choice)
	{
		String SQL = "";
		
		if(input_choice==1)
		{
			SQL = "SELECT * FROM employee where age >=" + "'" + input_age + "'";
		}
		else if(input_choice==2)
		{
			SQL = "SELECT * FROM employee where age <=" + "'" + input_age + "'";
		}
		
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
	
	public void Condition_Search_Company(String input_company)
	{
		String SQL = "SELECT * FROM employee where company =" + "'" + input_company + "'";
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
	
	public void Condition_Search_Position(String input_position)
	{
		String SQL = "SELECT * FROM employee where position =" + "'" + input_position + "'";
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
	
	public void Condition_Search_Salary(int input_salary,int input_choice)
	{
		String SQL = "";
		
		if(input_choice==1)
		{
			SQL ="SELECT * FROM employee where salary >=" + "'" + input_salary + "'";
		}
		else if(input_choice==2)
		{
			SQL ="SELECT * FROM employee where salary <=" + "'" + input_salary + "'";
		}
		
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
	
	public void Condition_Search_Year(int input_year,int input_choice)
	{
		String SQL = "";
		
		if(input_choice==1)
		{
			SQL ="SELECT * FROM employee where year >=" + "'" + input_year + "'";
		}
		else if(input_choice==2)
		{
			SQL ="SELECT * FROM employee where year <=" + "'" + input_year + "'";
		}
		
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
	
	public void Condition_Search_CompanyAndPosition(String input_company,String input_position)
	{
		String SQL = "SELECT * FROM employee where company =" + "'" + input_company 
				+ "'" +"and position=" + "'" + input_position + "'" ;
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
	
	public void add_data(String input_name,int input_age,
			String input_company,String input_position,int input_salary,int input_year)
	{
		PreparedStatement pstmt=null;
		
		try {
			pstmt = con.prepareStatement
					("insert into employee(name,age,company,position,salary,year) values(?,?,?,?,?,?)");
			
			pstmt.setString(1,input_name);			
			pstmt.setString(2,Integer.toString(input_age));
			pstmt.setString(3,input_company);			
			pstmt.setString(4,input_position);			
			pstmt.setString(5,Integer.toString(input_salary));			
			pstmt.setString(6,Integer.toString(input_year));			
							
			pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void del_data(String input_name)
	{
		PreparedStatement pstmt = null;

		String SQL = "delete FROM employee where name =?";
				try {
					pstmt = con.prepareStatement(SQL);
					pstmt.setString(1,input_name);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
	}
	
	public void mod_data(String input_name,int input_age,
			String input_company,String input_position,int input_salary,int input_year)
	{
		PreparedStatement pstmt = null;

		String SQL = "update employee set age = ?,company = ?,position = ?,salary = ?,year = ? where name = ?";
				try {
					pstmt = con.prepareStatement(SQL);
					
					pstmt.setString(1, Integer.toString(input_age) );
					pstmt.setString(2, input_company);
					pstmt.setString(3, input_position);
					pstmt.setString(4, Integer.toString(input_salary));
					pstmt.setString(5, Integer.toString(input_salary));
					pstmt.setString(6, input_name);
					
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void Salary_Desc_Or_Asc(int input_choice)
	{
		String SQL="";
		
		if(input_choice==1)
		{
			SQL="SELECT * FROM employee order by salary desc";
		}
		else if(input_choice==2)
		{
			SQL="SELECT * FROM employee order by salary asc";
		}	
		
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
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}