package entity;

public class Velo extends Produit {

	private String marque;
	//select marque, type from velos v INNER JOIN produits p on v.id=p.id
	private String type;
	
	@Override
	public String toString() {
		return "Velo [marque=" + marque + ", type=" + type + ", " + super.toString() + "]";
	}
	
	
	
	public Velo(int id, String nomProduit, String description, float prix, String marque, String type) {
		super(id, nomProduit, description, prix);
		this.setMarque(marque);
		this.setType(type);
	}
	public Velo(String nomProduit, String description, float prix, String marque, String type) {
		super(nomProduit, description, prix);
		this.setMarque(marque);
		this.setType(type);
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
