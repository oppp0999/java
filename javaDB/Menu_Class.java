package java_db_company_project;

public class Menu_Class {
	public static void Menu()
	{
		System.out.println("\n-------대기업 사원 DB검색 프로그램------");
		System.out.println("1.DB 모두 조회");
		System.out.println("2.DB 조건 조회");
		System.out.println("3.DB 삽입");
		System.out.println("4.DB 삭제");
		System.out.println("5.DB 수정");
		System.out.println("6.종료");
		System.out.println("----------------------------------\n");	
	}
	
	public static void Condition_Menu()
	{
		System.out.println("1.이름으로 검색");
		System.out.println("2.나이로 검색");
		System.out.println("3.회사로 검색");
		System.out.println("4.직급으로 검색");
		System.out.println("5.연봉으로 검색");
		System.out.println("6.연차로 검색");
		System.out.println("7.회사,직급으로 검색");	
		System.out.println("8.연봉");	
	}
}
