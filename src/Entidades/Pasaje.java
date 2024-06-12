
package Entidades;

import java.time.LocalDate;
import java.time.LocalTime;


public class Pasaje {
    
    private int IdPasaje;
    private Pasajero pasajero;
    private Colectivo colectivo;
    private Ruta ruta;
    private LocalDate fechaViaje;
    private LocalTime horaViaje;
    private int asiento;
    private double precio;

    public Pasaje() {
    }

    public Pasaje(int IdPasaje, Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.IdPasaje = IdPasaje;
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasaje(Pasajero pasajero, Colectivo colectivo, Ruta ruta, LocalDate fechaViaje, LocalTime horaViaje, int asiento, double precio) {
        this.pasajero = pasajero;
        this.colectivo = colectivo;
        this.ruta = ruta;
        this.fechaViaje = fechaViaje;
        this.horaViaje = horaViaje;
        this.asiento = asiento;
        this.precio = precio;
    }

    public int getIdPasaje() {
        return IdPasaje;
    }

    public void setIdPasaje(int IdPasaje) {
        this.IdPasaje = IdPasaje;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalTime getHoraViaje() {
        return horaViaje;
    }

    public void setHoraViaje(LocalTime horaViaje) {
        this.horaViaje = horaViaje;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String mensajeRecibo() {
        return "Gracias por viajar con nosotros!\n"
                + "Nro de pasaje: " + this.IdPasaje + "\n"
                + "Pasajero: " + this.pasajero + "\n"
                + "Colectivo: " + this.colectivo + "\n"
                + "Ruta: " + this.ruta + "\n"
                + "Fecha de viaje: " + this.fechaViaje + "\n"
                + "Hora de viaje: " + this.horaViaje + "\n"
                + "Asiento: " + this.asiento + "\n"
                + "Precio: " + this.precio;
    }
  
    @Override
    public String toString() {
        return "IdPasaje=" + IdPasaje + ", pasajero=" + pasajero + ", colectivo=" + colectivo + ", ruta=" + ruta + ", fechaViaje=" + fechaViaje + ", horaViaje=" + horaViaje + ", asiento=" + asiento + ", precio=" + precio + '}';
    }
    
    
}
