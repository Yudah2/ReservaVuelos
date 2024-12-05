package com.airplanedk.ReservaVuelos.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVuelo")
    private Long idVuelo;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idAerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Column(name = "numeroVuelo", nullable = false, length = 50)
    private String numeroVuelo;

    @Column(name = "precioBase", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_idAeropuertOrigen", nullable = false)
    private Aeropuerto aeropuertoOrigen;

    @Column(name = "fechaSalida", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "horaSalida", nullable = false)
    private LocalTime horaSalida;

    @ManyToOne
    @JoinColumn(name = "aeropuerto_idAeropuertoDestino", nullable = false)
    private Aeropuerto aeropuertoDestino;

    @Column(name = "fechaLlegada", nullable = false)
    private LocalDate fechaLlegada;

    @Column(name = "horaLlegada", nullable = false)
    private LocalTime horaLlegada;

    @Column(name = "asientos", nullable = false)
    private Integer asientos;

    // Getters y setters

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Integer getAsientos() {
        return asientos;
    }

    public void setAsientos(Integer asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", aerolinea=" + aerolinea +
                ", numeroVuelo='" + numeroVuelo + '\'' +
                ", precioBase=" + precioBase +
                ", aeropuertoOrigen=" + aeropuertoOrigen +
                ", fechaSalida=" + fechaSalida +
                ", horaSalida=" + horaSalida +
                ", aeropuertoDestino=" + aeropuertoDestino +
                ", fechaLlegada=" + fechaLlegada +
                ", horaLlegada=" + horaLlegada +
                ", asientos=" + asientos +
                '}';
    }
}
