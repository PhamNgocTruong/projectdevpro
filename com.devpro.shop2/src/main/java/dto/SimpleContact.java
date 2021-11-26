package dto;

public class SimpleContact {
	
	private String txtEmail;
	private String txtContent;
	private boolean ckbCheckbox;
	
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public String getTxtContent() {
		return txtContent;
	}
	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}
	public boolean isCkbCheckbox() {
		return ckbCheckbox;
	}
	public void setCkbCheckbox(boolean ckbCheckbox) {
		this.ckbCheckbox = ckbCheckbox;
	}
	
}
