/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author khalil
 */
public interface Ilocation<T> { 
    void insertLocation(T t) ;  
        List<T> displaAll() ;  
        void DeleteUserLocation(int id) ; 
    void Update(int id , String date_debut, String date_fin , int id_v);  
    List<T> rechercherParid(int id ) ; 
    float  calculer(int id ) ;  
      void DeleteProduitLocation(int id) ; 
      void UpdatePrix(int id  ,float prixtotal,int id_v) ; 
      List<T> TrierParPrix(); 

    
}