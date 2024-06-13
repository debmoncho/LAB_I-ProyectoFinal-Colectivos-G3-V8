
package Entidades;

import java.time.LocalTime;


public class Ruta {
    
    private int IdRuta;
    private String origen;
    private String destino;
    private LocalTime duracionEstimada;
    private boolean estado;
    public Ruta() {
    }

    public Ruta(int IdRuta, String origen, String destino, LocalTime duracionEstimada,boolean estado) {
        this.IdRuta = IdRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
    }

    public Ruta(String origen, String destino, LocalTime duracionEstimada,boolean estado) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
        this.estado = estado;
    }

    public int getIdRuta() {
        return IdRuta;
    }

    public void setIdRuta(int IdRuta) {
        this.IdRuta = IdRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getDuracionEstimada() {
        return duracionEstimada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setDuracionEstimada(LocalTime duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    @Override
    public String toString() {
        return "IdDeRuta: " + IdRuta + " - Origen: " + origen + " - Destino: " + destino + " - DuracionEstimada: " + duracionEstimada;
    }
    
    
}
