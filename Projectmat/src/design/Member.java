package design;

public class Member {

	String name;
	String menu;
	String price;
	String star;
	String category;
	
	public Member(String name, String menu, String star, String category, String price) {
		this.name = name;
		this.menu = menu;
		this.price = price;
		this.star = star;
		this.category = category;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
