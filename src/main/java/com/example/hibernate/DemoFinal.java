package com.example.hibernate;

import com.example.hibernate.dominio.*;
import com.example.hibernate.utils.BDUtils;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;

import java.util.*;
import javax.persistence.EntityManager;

import javax.persistence.EntityManager;
import java.util.List;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        // Crear convocatoria con requisitos
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setTiempoInicio(new Date());
        convocatoria.setTiempoFinalizacion(new Date());
        convocatoria.setGeneroPersona(GeneroPersona.MASCULINO);
        convocatoria.setEdadMinima(18);
        convocatoria.setEdadMaxima(40);
        convocatoria.setGeneroObra("Comedia");
        convocatoria.setTipoRemuneracion("Remunerado");
        convocatoria.setLocalizacion("CABA");
        convocatoria.setInfoAdicional("Convocatoria completa");
        convocatoria.setEstadoConvocatoria(EstadoConvocatoria.ACTIVA);
        convocatoria.setTipoConvocatoria(TipoConvocatoria.CORTO);
        convocatoria.setProductoPublicitario("Producto Real");

        Requisito req1 = new Requisito();
        req1.setDescripcion("Tener experiencia mínima 1 año");
        Requisito req2 = new Requisito();
        req2.setDescripcion("Disponibilidad completa");

        convocatoria.setRequisitos(Arrays.asList(req1, req2));
        em.persist(req1);
        em.persist(req2);
        em.persist(convocatoria);

        // Crear postulante
        Postulante postulante = new Postulante();
        postulante.setNombre("Marcos");
        postulante.setEdad(28);
        em.persist(postulante);

        // Crear fotos
        Fotos foto1 = new Fotos();
        foto1.setUrl("foto1.jpg");

        Fotos foto2 = new Fotos();
        foto2.setUrl("foto2.jpg");

        // Persistir fotos
                em.persist(foto1);
                em.persist(foto2);

        //Crear postulación
        Postulacion postulacion = new Postulacion();
        postulacion.setConvocatoria(convocatoria);
        postulacion.setPostulante(postulante);
        postulacion.setCv("cv_marcos.pdf");
        postulacion.setReelURL("reel_marcos.mp4");
        postulacion.setEstado(EstadoPostulacion.INICIADA);
        postulacion.setFechaPostulacion(new Date());
        postulacion.setFotos(Arrays.asList(foto1, foto2));
        em.persist(postulacion);

        //Update de entidad administrada
        postulante.setNombre("Sofia");
        postulacion.setEstado(EstadoPostulacion.APROBADA);

        //Consulta JPQL
        List<Postulacion> postulaciones = em.createQuery(
                        "SELECT p FROM Postulacion p WHERE p.estado = ?1", Postulacion.class)
                .setParameter(1, EstadoPostulacion.APROBADA)
                .getResultList();

        System.out.println("Postulaciones aprobadas: " + postulaciones.size());

        BDUtils.commit(em);

        System.out.println("DemoFinal completado correctamente.");
    }
}

