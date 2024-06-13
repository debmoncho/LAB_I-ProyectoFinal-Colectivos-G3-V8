
package Entidades;

import java.time.LocalTime;


public class Horario {
    
    private int IdHorario;
    private Ruta ruta;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private boolean estado;
    public Horario() {
    }

    public Horario(int IdHorario, Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada,boolean estado) {
        this.IdHorario = IdHorario;
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
    }

    public Horario(Ruta ruta, LocalTime horaSalida, LocalTime horaLlegada) {
        this.ruta = ruta;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public int getIdHorario() {
        return IdHorario;
    }

    public void setIdHorario(int IdHorario) {
        this.IdHorario = IdHorario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public boolean isEstado() {
        return estado;
    }
    

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "idHorario: " + IdHorario + " - Salida: " + horaSalida + " - Llegada: " + horaLlegada;
    }
    
    
}
