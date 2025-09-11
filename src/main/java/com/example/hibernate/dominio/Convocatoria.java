package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busqueda_id;
    private Date tiempoInicio;
    private Date tiempoFinalizacion;

    @Enumerated(EnumType.STRING)
    private GeneroPersona generoPersona;
    private int edadMinima;
    private int edadMaxima;
    private String generoObra;
    private String tipoRemuneracion;
    private String localizacion;
    private String infoAdicional;

    @Enumerated(EnumType.STRING)
    private EstadoConvocatoria estadoConvocatoria;

    @Enumerated(EnumType.STRING)
    private TipoConvocatoria tipoConvocatoria;
    private String productoPublicitario;

    // Relacion con Requisito (M:N)
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "RequisitoxConvocatoria",
            joinColumns = @JoinColumn(name = "busqueda_id"),
            inverseJoinColumns = @JoinColumn(name = "requisito_id")
    )
    private List<Requisito> requisitos;

    // Relacion con Postulacion (1:N)
    @OneToMany(mappedBy = "convocatoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulacion> postulaciones;

    //Getters y Setters

    public Integer getBusqueda_id() { return busqueda_id; }
    public void setBusqueda_id(Integer nuevoBusqueda_id) { this.busqueda_id = nuevoBusqueda_id; }

    public Date getTiempoInicio() { return tiempoInicio; }
    public void setTiempoInicio(Date nuevoTiempoInicio) { this.tiempoInicio = nuevoTiempoInicio; }

    public Date getTiempoFinalizacion() { return tiempoFinalizacion; }
    public void setTiempoFinalizacion(Date nuevoTiempoFinalizacion) { this.tiempoFinalizacion = nuevoTiempoFinalizacion; }

    public GeneroPersona getGeneroPersona() { return generoPersona; }
    public void setGeneroPersona(GeneroPersona nuevoGeneroPersona) { this.generoPersona = nuevoGeneroPersona; }

    public int getEdadMinima() { return edadMinima; }
    public void setEdadMinima(int nuevoEdadMinima) { this.edadMinima = nuevoEdadMinima; }

    public int getEdadMaxima() {return edadMaxima; }
    public void setEdadMaxima(int nuevaEdadMaxima) {this.edadMaxima = nuevaEdadMaxima; }

    public String getGeneroObra() { return generoObra; }
    public void setGeneroObra(String nuevoGeneroObra) { this.generoObra = nuevoGeneroObra; }

    public String getTipoRemuneracion() { return tipoRemuneracion; }
    public void setTipoRemuneracion(String nuevaTipoRemuneracion) { this.tipoRemuneracion = nuevaTipoRemuneracion; }

    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String nuevaLocalizacion) { this.localizacion = nuevaLocalizacion; }

    public String getInfoAdicional() { return infoAdicional; }
    public void setInfoAdicional(String nuevaInfoAdicional) { this.infoAdicional = nuevaInfoAdicional; }

    public EstadoConvocatoria getEstadoConvocatoria() {return estadoConvocatoria;}
    public void setEstadoConvocatoria(EstadoConvocatoria nuevoEstadoConvocatoria) { this.estadoConvocatoria = nuevoEstadoConvocatoria;}

    public TipoConvocatoria getTipoConvocatoria() { return tipoConvocatoria; }
    public void setTipoConvocatoria(TipoConvocatoria nuevoTipoConvocatoria) {this.tipoConvocatoria = nuevoTipoConvocatoria; }

    public String getProductoPublicitario() {return productoPublicitario; }
    public void setProductoPublicitario(String nuevoProductoPublicitario) { this.productoPublicitario = nuevoProductoPublicitario; }

    public List<Requisito> getRequisitos() { return requisitos; }
    public void setRequisitos(List<Requisito> nuevosRequisitos) { this.requisitos = nuevosRequisitos; }

    public List<Postulacion> getPostulaciones() { return postulaciones; }
    public void setPostulaciones(List<Postulacion> nuevasPostulaciones) { this.postulaciones = nuevasPostulaciones; }
}

