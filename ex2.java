package kr.vel;
​
​
public class Menu {
	
	public int id;
   public String name;
   public int price;
   public int num;
	public Menu() {
		
	}
​
	public Menu(int id,String name, int price, int num) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
​
	public String getName() {
		return name;
	}
​
	public void setName(String name) {
		this.name = name;
	}
​
	public int getPrice() {
		return price;
	}
​
	public void setPrice(int price) {
		this.price = price;
	}
​
	public int getNum() {
		return num;
	}
​
	public void setNum(int num) {
		this.num = num;
	}
	
	public void sellMenu() {
		num—;
	}
	public boolean avail() {
		return num>0;
	}
	public String toStr() {
		return name + " " + price + "원 남은수량"+num +"개";
	}
	
}