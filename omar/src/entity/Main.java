package entity;

import java.util.ArrayList;
import java.util.List;

import service.ServiceProduit;

public class Main {
	
	
	public static void main(String[] args) 
    { 
		//List<Produit> produits = new ArrayList<Produit>();
		Velo v1 = new Velo(1, "Velo v1", "Vello VTT", 500, "VTT", "VTT");
		Accessoire a1 = new Accessoire(2, "Water Bottle", "Bouteille d'eau", 2, "Null", "Null");
		Piece_Rechange pr = new Piece_Rechange(3, "Chaine", "Chaine pour bic", 50, "Null", "Null");
		ServiceProduit sp = new ServiceProduit();
		//sp.insertVelo(v1);
		sp.displayProducts().forEach(System.out::println);
		System.out.println(sp.RechercheProduit(pr));
		

		
		//produits.forEach((e)->{System.out.println(e);});
		
    }
	

}
