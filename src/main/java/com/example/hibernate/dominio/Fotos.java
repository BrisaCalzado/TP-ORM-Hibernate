package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Fotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fotos_id;
    private String url;

    //Getters y Setters

    public Integer getFotos_id() { return fotos_id; }
    public void setFotos_id(Integer nuevasFotos_id) { this.fotos_id = nuevasFotos_id; }

    public String getUrl() { return url; }
    public void setUrl(String nueva_url) { this.url = nueva_url; }

}

