/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Produit;
import java.util.List;

/**
 *
 * @author khalil
 */
public interface Ipromotion<T> {
    void insertPromotion(T t) ;  
        List<T> displaAll() ;  
        void Delete(int id) ; 
    void Update(int id , String type, float taux);  
     float  calculerpromo(int id ) ;  
       float getProduitPrix(int id) ; 
       void Updateprix(int id ,int id_pr) ; 
       List<T> rechercherParType(String type) ;
}
