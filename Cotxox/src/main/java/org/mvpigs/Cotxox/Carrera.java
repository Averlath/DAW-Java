package org.mvpigs.Cotxox;

import org.mvpigs.Cotxox.Tarifa;

public class Carrera {
    private int tiempoEsperado;
    private int tiempoCarrera;
    private double costeTotal;
    private Conductor conductor;

    private String origen;
    private String destino;
    private double distancia;
    private String tarjetaCredito;
    private int propina = 0;

    public Carrera(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTarjetaCredito() {
        return this.tarjetaCredito;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setTiempoEsperado(int tiempoEsperado) {
        this.tiempoEsperado = tiempoEsperado;
    }

    public int getTiempoEsperado() {
        return tiempoEsperado;
    }

    public double getCosteEsperado() {
        return Tarifa.getCosteTotalEsperado(this);
    }

    public void setConductor (Conductor conductor) {
        this.conductor = conductor;
    }

    public Conductor getConductor() {
        return this.conductor;
    }

    public void asignarConductor(PoolConductores conductores) {
        setConductor(conductores.asignarConductor());
    }

    public void realizarPago(double pago) {
        this.costeTotal = pago;
    }

    public int getPropina() {
        return this.propina;
    }

    public void recibirPropina(int propina) {
        this.propina = propina;
    }

    public void liberarConductor() {
        getConductor().setOcupado(false);
    }

    public double getCosteTotal() {
        return this.costeTotal;
    }
}