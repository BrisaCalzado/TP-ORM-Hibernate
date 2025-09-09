package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postulacion_id;

    @ManyToOne
    @JoinColumn(name = "postulante_id")  // nombre de la FK en la tabla
    private Postulante postulante;

    @ManyToOne
    @JoinColumn(name = "busqueda_id")   // nombre de la FK en la tabla
    private Convocatoria convocatoria;

    private String cv;
    private String reelURL;

    @Enumerated(EnumType.STRING)
    private EstadoPostulacion estado;
    private Date fechaPostulacion;

    @ManyToMany
    @JoinTable(
            name = "PostulacionXFotos",
            joinColumns = @JoinColumn(name = "postulacion_id"),
            inverseJoinColumns = @JoinColumn(name = "fotos_id")
    )
    private List<Fotos> fotos;

    // Getters y Setters

    public Integer getPostulacion_id() { return postulacion_id; }
    public void setPostulacion_id(Integer nuevoPostulante_id) { this.postulacion_id = nuevoPostulante_id; }

    public Postulante getPostulante() { return postulante; }
    public void setPostulante(Postulante postulante) { this.postulante = postulante; }

    public Convocatoria getConvocatoria() { return convocatoria; }
    public void setConvocatoria(Convocatoria convocatoria) { this.convocatoria = convocatoria; }

    public String getCv() { return cv; }
    public void setCv(String nuevoCv) { this.cv = nuevoCv; }

    public String getReelURL() { return reelURL; }
    public void setReelURL(String nuevoReelURL) { this.reelURL = nuevoReelURL; }

    public EstadoPostulacion getEstado() { return estado; }
    public void setEstado(EstadoPostulacion nuevoEstado) { this.estado = nuevoEstado; }

    public Date getFechaPostulacion() { return fechaPostulacion; }
    public void setFechaPostulacion(Date fechaPostulacion) { this.fechaPostulacion = fechaPostulacion; }

    public List<Fotos> getFotos() { return fotos; }
    public void setFotos(List<Fotos> nuevasFotos) { this.fotos = nuevasFotos; }
}
