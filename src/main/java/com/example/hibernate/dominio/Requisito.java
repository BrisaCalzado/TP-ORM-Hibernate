package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requisito_id;
    private String descripcion;

    public Integer getRequisito_id() { return requisito_id; }
    public void setRequisito_id(Integer nuevoRequisito_id) { this.requisito_id = nuevoRequisito_id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String nuevaDescripcion) { this.descripcion = nuevaDescripcion; }
}