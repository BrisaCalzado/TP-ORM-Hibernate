package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Postulante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postulante_id;
    private String nombre;
    private int edad;

    public Integer getPostulante_id() { return postulante_id; }
    public void setPostulante_id(Integer nuevoPostulante_id) { this.postulante_id = nuevoPostulante_id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nuevoNombre) { this.nombre = nuevoNombre; }

    public int getEdad() { return edad; }
    public void setEdad(int nuevaEdad) { this.edad = nuevaEdad; }
}
