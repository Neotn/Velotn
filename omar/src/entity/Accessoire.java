package entity;

public class Accessoire extends Produit {
	private String marque;
	private String type;

	
	public Accessoire(int id, String nomProduit, String description, float prix, String marque, String type) {
		super(id, nomProduit, description, prix);
		this.marque = marque;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Accessoire [marque=" + marque + ", type=" + type +" ,"+ super.toString() + "]";
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
