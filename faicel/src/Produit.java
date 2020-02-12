public class Produit {
	
	
	
	private int id;
	private String nomProduit;
	private String description;
	private float prix;
	
	
	
	public Produit(int id, String nomProduit, String description, float prix) {
		super();
		this.id = id;
		this.nomProduit = nomProduit;
		this.description = description;
		this.prix = prix;
	}
	
	
	public Produit(String nomProduit, String description, float prix) {
		super();
		this.nomProduit = nomProduit;
		this.description = description;
		this.prix = prix;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", description=" + description + ", prix=" + prix
				+ "]";
	}
	
	
	
	

}
