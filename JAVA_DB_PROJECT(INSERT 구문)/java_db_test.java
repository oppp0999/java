package JAVA_DB_PROJECT;

import java.util.Scanner;

public class java_db_test {
	public static void main(String[] args)
	{
		DB_Connection connection = new DB_Connection();
		
		Scanner sc = new Scanner(System.in);
		int choice=0;
		String input_name="";
		
		Menu_Class.menu();
		choice=sc.nextInt();
		
		if(choice==1)
		{
			//��� ��ȸ
			connection.Search();		
		}
		else if(choice==2)//���� ��ȸ
		{
			Menu_Class.Condition_Menu();
			choice=sc.nextInt();
			
			if(choice==1) {//�̸����� ��ȸ
				input_name=sc.nextLine();
				connection.Condition_Search_Name(input_name);
			} else if(choice==2) {//
				
			}
		}
	}
}
