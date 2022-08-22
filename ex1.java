package kr.vel;
import java.util.Scanner;
​
public class test {
	
	public static Menu[] menuArray;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int getNum;
		menuArray = new Menu[5];
		menuArray[0] = new Menu("콜라",1000,5);
		menuArray[1] = new Menu("커피",1500,2);
		menuArray[2] = new Menu("핫식스",800,5);
		menuArray[3] = new Menu("물",500,5);
		menuArray[4] = new Menu("이론음료",1200,2);
		
		do {
			MainPrint();
			getNum = scan.nextInt();
			
			if(getNum <= menuArray.length) {
				if(menuArray[getNum].avail()) {
					menuArray[getNum].sellMenu();
					continue;
				}else {
					System.out.println("판매가 완료 되었습니다.");
				}
			}
			
		}while(getNum != 9);
​
	}
	
	public static void MainPrint() {
		System.out.println("5가지 자판기");
		int i = 0;
		for(Menu menuItem : menuArray){
			System.out.println(++i +" = " +menuItem.toStr());
		}
		System.out.println("구매할 메뉴를 번호로 넣어 주세요");
		System.out.print(">>");
	}
}