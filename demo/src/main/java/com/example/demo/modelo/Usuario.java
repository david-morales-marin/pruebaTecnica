package com.example.demo.modelo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
import javax.sql.DataSource;
import java.io.Serializable;

@Entity
@Table(name = "registro")
public class Usuario implements Serializable {
    private static final Integer serialVersionUID = -4431;

    @Id
    @Column(name = "identificacion", length = 30)
    private Integer identificacion;

    @Column(name="telefono", length = 30)
    private String telefono;

    @Column(name="nombre", length = 30)
    private String nombre;

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(){

    }

    public Usuario(Integer identificacion, String telefono, String nombre){
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.nombre = nombre;
    }
}
