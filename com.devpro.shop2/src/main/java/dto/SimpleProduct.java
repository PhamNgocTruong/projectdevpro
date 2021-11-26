 package dto;

public class SimpleProduct {
	private String title;
	private String price;
	private String priceSale;
	private String shortDescription;
	private String details;
	private boolean isHot;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(String priceSale) {
		this.priceSale = priceSale;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isHot() {
		return isHot;
	}
	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}
	
}
