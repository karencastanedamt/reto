/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Servicios;

import tutoria.Modelo.computer;
import tutoria.Repositorio.computerRepositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosComputer {
        @Autowired
    private computerRepositorio metodosCrud;
    
    public List<computer> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<computer> getComputer(int idComputer){
        return metodosCrud.getComputer(idComputer);
    }
    
    public computer save(computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<computer> evt=metodosCrud.getComputer(computer.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }
    public computer update(computer computer){
        if(computer.getId()!=null){
            Optional<computer> e=metodosCrud.getComputer(computer.getId());
            if(!e.isEmpty()){
                if(computer.getId()!=null){
                    e.get().setId(computer.getId());
                }
                if(computer.getBrand()!=null){
                    e.get().setBrand(computer.getBrand());
                }
                if(computer.getModel()!=null){
                    e.get().setModel(computer.getModel());
                }
                if(computer.getCategory_id()!=null){
                    e.get().setCategory_id(computer.getCategory_id());
                }
                if(computer.getName()!=null){
                    e.get().setName(computer.getName());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }


    public boolean deleteComputer(int computerId) {
        Boolean aBoolean = getComputer(computerId).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
