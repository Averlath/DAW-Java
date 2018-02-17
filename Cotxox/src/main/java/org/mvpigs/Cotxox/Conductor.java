package org.mvpigs.Cotxox;

import java.util.ArrayList;

public class Conductor {
    private String nombre;
    private String modelo;
    private String matricula;
    private float valoracionMedia;
    private boolean ocupado;
    private ArrayList<Byte> valoraciones;

    public Conductor(String nombre) {
        this.nombre = nombre;
        valoraciones = new ArrayList<Byte>();
        ocupado = false;
        valoracionMedia = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public void setValoracion(byte valoracion) {
        this.valoraciones.add(valoracion);
    }

    public ArrayList<Byte> getValoracion() {
        return this.valoraciones;
    }

    public double calcularValoracionMedia() {
        int sumaValoraciones = 0;
        for (byte valoracion : this.valoraciones) {
            sumaValoraciones = sumaValoraciones + valoracion;
        }

        this.valoracionMedia = sumaValoraciones / this.valoraciones.size();
        return this.valoracionMedia;
    }
}