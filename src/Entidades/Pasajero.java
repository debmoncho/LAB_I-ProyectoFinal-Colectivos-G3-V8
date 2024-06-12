
package Entidades;


public class Pasajero {
    
    private int IdPasajero;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;
    private boolean estado;
    public Pasajero() {
    }

    public Pasajero(int IdPasajero, String nombre, String apellido, String dni, String correo, String telefono,boolean estado) {
        this.IdPasajero = IdPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Pasajero(String nombre, String apellido, String dni, String correo, String telefono, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Pasajero(String nombre, String apellido, String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdPasajero() {
        return IdPasajero;
    }

    public void setIdPasajero(int IdPasajero) {
        this.IdPasajero = IdPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Pasajero{" + "IdPasajero=" + IdPasajero + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

    
}
