package com.airplanedk.ReservaVuelos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private Long idFactura;

    @Column(name = "fechaEmision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "detalles", nullable = false, length = 200)
    private String detalles;

    @Column(name = "numeroTarjeta", nullable = false)
    private String numeroTarjeta;

    @Column(name = "fechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "cvv", nullable = false)
    private int cvv;

    @Column(name = "titular", nullable = false, length = 200)
    private String titular;

    // Getters y setters

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", fechaEmision=" + fechaEmision +
                ", monto=" + monto +
                ", detalles='" + detalles + '\'' +
                ", numeroTarjeta=" + numeroTarjeta +
                ", fechaVencimiento=" + fechaVencimiento +
                ", cvv=" + cvv +
                ", titular='" + titular + '\'' +
                '}';
    }
}

