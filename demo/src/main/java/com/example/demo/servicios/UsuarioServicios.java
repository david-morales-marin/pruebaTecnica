package com.example.demo.servicios;

import com.example.demo.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositorio.Repositorio;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/registro")
public class UsuarioServicios {

    @Autowired
    private Repositorio repositorio;

    public Usuario newUser (Usuario usuario){
        return repositorio.save(usuario);
    }

    @GetMapping
    public List<Usuario> getAllUsuario(){
        return repositorio.findAll();
    }

    @DeleteMapping
    public void delete(Usuario usuario){
        repositorio.delete(usuario);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return this.repositorio.save(usuario);
    }


    @PutMapping(path = "/{identificacion}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer identificacion, @RequestBody Usuario usuario){
        Usuario actualizar = null;
        int pos = 0;
        int aux = 0;
        for (Usuario usuario1: getAllUsuario()){
            if(usuario1.getIdentificacion().equals(identificacion)){
                actualizar=usuario1;
                aux = pos;
            }
            pos++;
        }
        actualizar.setIdentificacion(usuario.getIdentificacion());
        actualizar.setTelefono(usuario.getTelefono());
        actualizar.setNombre(usuario.getNombre());

        getAllUsuario().remove(aux);
        getAllUsuario().add(aux, usuario);

        for(Usuario usuario1: getAllUsuario()){
            System.out.println("Su informacion personal fue actualizada correctamente " + usuario1);
        }
        this.repositorio.save(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
}
