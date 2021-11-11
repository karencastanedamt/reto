/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tutoria.Interface.InterfaceComputer;
import tutoria.Modelo.computer;

/**
 *
 * @author USUARIO
 */
@Repository
public class computerRepositorio {
      @Autowired
    private InterfaceComputer crud;
    

    public List<computer> getAll(){
        return (List<computer>) crud.findAll();       
    }
    
    public Optional <computer> getComputer(int idComputer){
        return crud.findById(idComputer);
    }
    
    public computer save(computer computer){
        return crud.save(computer);
    }
     public void delete(computer computer){
        crud.delete(computer);
    }

    public Optional<computer> getComputers(int idComputer) {
        return null;
    }
    
}
