package com.example.demo.repositorio;

import com.example.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface Repositorio extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM registro",nativeQuery = true)

    public List<Usuario> consultar();

    public Usuario save(Usuario usuario);



}
