package entity;

public class Produit {
	
	
	
	protected int id;
	protected String nomProduit;
	protected String description;
	protected float prix;
	//User
	
	
	
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
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
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
