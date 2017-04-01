package com.uniminuto.ejercicio1.entityEjb;

/**
 * Created by yeimmy canon on 27/09/2016.
 */
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Servicio")
public class Servicio {

    @Id
    @Column(name="id_servicio")
    private Long idServicio;

    @Column(name="punto_inicio")
    private String puntoInicio;

    @Column(name="punto_final")
    private String puntoFinal;


    public Servicio() {

    }


    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }


    public String getPuntoInicio() {
        return puntoInicio;
    }

    public void setPuntoInicio(String puntoInicio) {
        this.puntoInicio = puntoInicio;
    }

    public String getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(String puntoFinal) {
        this.puntoFinal = puntoFinal;
    }


}
