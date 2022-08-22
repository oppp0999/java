package java_db_company_project;

import java.util.Scanner;

public class java_db_test 
{
	
	
	public static void main(String[] args)
	{
		DB_Connection connection = new DB_Connection();
		Scanner sc = new Scanner(System.in);

		int choice=0;
		String name="";
		int age=0;
		String company="";
		String position="";
		int salary=0;
		int year=0;

		
		while(true)
		{
			Menu_Class.Menu();
			choice = sc.nextInt();

			if(choice==1)
			{
				connection.Search();
			}
			else if(choice==2)
			{
				Menu_Class.Condition_Menu();
				choice = sc.nextInt();
				if(choice==1)
				{
					sc.nextLine();
					System.out.printf("이름 입력:");
					name=sc.nextLine();
					connection.Condition_Search_Name(name);
				}
				else if(choice==2)
				{
					System.out.println("나이 입력:");
					age=sc.nextInt();

					System.out.printf("1.이상,2.이하:");
					choice=sc.nextInt();

					connection.Condition_Search_Age(age,choice);
				}
				else if(choice==3)
				{
					sc.nextLine();
					System.out.printf("회사 입력:");
					name=sc.nextLine();
					connection.Condition_Search_Company(name);			
				}
				else if(choice==4)
				{ 
					sc.nextLine();
					System.out.printf("직급 입력:");
					position=sc.nextLine();
					connection.Condition_Search_Position(position);			
				}
				else if(choice==5) //연봉
				{
					System.out.printf("연봉 입력:");
					salary=sc.nextInt();
					System.out.printf("1.이상,2.이하:");
					choice=sc.nextInt();
					connection.Condition_Search_Salary(salary, choice);
				}
				else if(choice==6) //연차 
				{
					System.out.printf("연차 입력:");
					year=sc.nextInt();
					System.out.printf("1.이상,2.이하:");
					choice=sc.nextInt();
					connection.Condition_Search_Year(year, choice);

				}
				else if(choice==7) //회사 직급
				{
					sc.nextLine();
					System.out.printf("회사 입력:");
					company=sc.nextLine();
					System.out.printf("직급 입력:");
					position=sc.nextLine();
					connection.Condition_Search_CompanyAndPosition(company, position);
				}
				else if(choice==8) //연봉
				{
					System.out.printf("1.내림차순,2.오름차순:");
					choice=sc.nextInt();
					connection.Salary_Desc_Or_Asc(choice);
				}
			}
			else if(choice==3)
			{
				System.out.println("삽입할 정보 입력");
				sc.nextLine();
				System.out.printf("이름 입력:");
				name=sc.nextLine();

				System.out.printf("나이 입력:");
				age=sc.nextInt();
				sc.nextLine();
				
				System.out.printf("회사 입력:");
				company=sc.nextLine();
				
				
				System.out.printf("직급 입력:");
				position=sc.nextLine();
				
				System.out.printf("연봉 입력:");
				salary=sc.nextInt();

				System.out.printf("연차 입력:");
				year=sc.nextInt();
				
				connection.add_data(name, age, company, position, salary, year);
			}
			else if(choice==4)
			{
				System.out.println("삭제할 정보 입력");
				sc.nextLine();
				System.out.printf("이름 입력:");
				name=sc.nextLine();
				connection.del_data(name);		
			}
			else if(choice==5)
			{
				System.out.println("수정할 정보 입력(이름으로 검색)");
				sc.nextLine();
				System.out.printf("찾을 이름 입력:");
				name=sc.nextLine();

				System.out.printf("수정할 나이 입력:");
				age=sc.nextInt();
				sc.nextLine();
				
				System.out.printf("수정할 회사 입력:");
				company=sc.nextLine();
				
				System.out.printf("수정할 직급 입력:");
				position=sc.nextLine();
				
				System.out.printf("수정할 연봉 입력:");
				salary=sc.nextInt();	
				
				System.out.printf("수정할 연차 입력:");
				year=sc.nextInt();
				
				connection.mod_data(name, age, company, position, salary, year);
				//
				//public void mod_data(String input_name,int input_age,
				//		String input_company,String input_position,int input_salary,int input_year)

			}
			else if(choice==6)
			{
				break;
			}
				
		}
		sc.close();	
	}
	
}
