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
					System.out.printf("�̸� �Է�:");
					name=sc.nextLine();
					connection.Condition_Search_Name(name);
				}
				else if(choice==2)
				{
					System.out.println("���� �Է�:");
					age=sc.nextInt();

					System.out.printf("1.�̻�,2.����:");
					choice=sc.nextInt();

					connection.Condition_Search_Age(age,choice);
				}
				else if(choice==3)
				{
					sc.nextLine();
					System.out.printf("ȸ�� �Է�:");
					name=sc.nextLine();
					connection.Condition_Search_Company(name);			
				}
				else if(choice==4)
				{ 
					sc.nextLine();
					System.out.printf("���� �Է�:");
					position=sc.nextLine();
					connection.Condition_Search_Position(position);			
				}
				else if(choice==5) //����
				{
					System.out.printf("���� �Է�:");
					salary=sc.nextInt();
					System.out.printf("1.�̻�,2.����:");
					choice=sc.nextInt();
					connection.Condition_Search_Salary(salary, choice);
				}
				else if(choice==6) //���� 
				{
					System.out.printf("���� �Է�:");
					year=sc.nextInt();
					System.out.printf("1.�̻�,2.����:");
					choice=sc.nextInt();
					connection.Condition_Search_Year(year, choice);

				}
				else if(choice==7) //ȸ�� ����
				{
					sc.nextLine();
					System.out.printf("ȸ�� �Է�:");
					company=sc.nextLine();
					System.out.printf("���� �Է�:");
					position=sc.nextLine();
					connection.Condition_Search_CompanyAndPosition(company, position);
				}
				else if(choice==8) //����
				{
					System.out.printf("1.��������,2.��������:");
					choice=sc.nextInt();
					connection.Salary_Desc_Or_Asc(choice);
				}
			}
			else if(choice==3)
			{
				System.out.println("������ ���� �Է�");
				sc.nextLine();
				System.out.printf("�̸� �Է�:");
				name=sc.nextLine();

				System.out.printf("���� �Է�:");
				age=sc.nextInt();
				sc.nextLine();
				
				System.out.printf("ȸ�� �Է�:");
				company=sc.nextLine();
				
				
				System.out.printf("���� �Է�:");
				position=sc.nextLine();
				
				System.out.printf("���� �Է�:");
				salary=sc.nextInt();

				System.out.printf("���� �Է�:");
				year=sc.nextInt();
				
				connection.add_data(name, age, company, position, salary, year);
			}
			else if(choice==4)
			{
				System.out.println("������ ���� �Է�");
				sc.nextLine();
				System.out.printf("�̸� �Է�:");
				name=sc.nextLine();
				connection.del_data(name);		
			}
			else if(choice==5)
			{
				System.out.println("������ ���� �Է�(�̸����� �˻�)");
				sc.nextLine();
				System.out.printf("ã�� �̸� �Է�:");
				name=sc.nextLine();

				System.out.printf("������ ���� �Է�:");
				age=sc.nextInt();
				sc.nextLine();
				
				System.out.printf("������ ȸ�� �Է�:");
				company=sc.nextLine();
				
				System.out.printf("������ ���� �Է�:");
				position=sc.nextLine();
				
				System.out.printf("������ ���� �Է�:");
				salary=sc.nextInt();	
				
				System.out.printf("������ ���� �Է�:");
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
