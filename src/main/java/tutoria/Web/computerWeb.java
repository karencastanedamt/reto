/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.Web;

import tutoria.Modelo.computer;
import tutoria.Servicios.ServiciosComputer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/COMPUTER")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class computerWeb {
     @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    @Autowired
    private ServiciosComputer servicio;
    @GetMapping("all")
    public List <computer> getComputer(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<computer> getOrthesis(@PathVariable("id") int idComputer) {
        return servicio.getComputer(idComputer);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public computer save(@RequestBody computer computer) {
        return servicio.save(computer);
    }
    
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public computer update(@RequestBody computer computer) {
        return servicio.update(computer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int computerId) {
        return servicio.deleteComputer(computerId);
    }
}
