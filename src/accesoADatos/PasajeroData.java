
package accesoADatos;

import Entidades.Pasajero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PasajeroData {
    
    private Connection con = null;

    public PasajeroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarPasajero(Pasajero pasajero) {

        String sql = "INSERT INTO pasajeros (nombre, apellido, dni, correo, telefono, estado) "
                + "VALUES ( ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setBoolean(6, pasajero.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                pasajero.setIdPasajero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasajero Guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el pasajero");
            ex.printStackTrace();
        }

    }
    
    public void modificarPasajero(Pasajero pasajero) {

        String sql = "UPDATE pasajeros SET nombre = ?, apellido = ?, dni = ?, correo = ?, telefono = ? "
                + "  WHERE idPasajero = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getApellido());
            ps.setString(3, pasajero.getDni());
            ps.setString(4, pasajero.getCorreo());
            ps.setString(5, pasajero.getTelefono());
            ps.setInt(6, pasajero.getIdPasajero());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero guardado!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el pasajero");
            ex.printStackTrace();
        }
    }
    
    public void eliminarPasajero(int id) {

        String sql = "UPDATE pasajeros SET estado= 0  WHERE idPasajero= ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pasajero eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pasajero");
        }
    }
    
    public Pasajero buscarPasajero(int id) {

        String sql = "SELECT nombre, apellido, dni, correo, telefono FROM pasajeros WHERE idPasajero= ? AND estado= 1";
        Pasajero pasajero = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(id);
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
    
              
                pasajero.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese pasajero");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pasajero ");
        }
        
        return pasajero;
    }
    
    public Pasajero buscarPasajeroPorDni(String dni) {

        String sql = "SELECT idPasajero, nombre, apellido, dni, correo, telefono FROM pasajeros WHERE dni= ? AND estado= 1";
        Pasajero pasajero = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));

                pasajero.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese pasajero");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pasajero ");
        }
        
        return pasajero;
    }
    
    public Pasajero buscarPasajeroPorApellido(String apellido) {

        String sql = "SELECT idPasajero, nombre, apellido, dni, correo, telefono FROM pasajeros WHERE apellido= ? AND estado= 1";
        Pasajero pasajero = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, apellido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));

                pasajero.setEstado(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese pasajero");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pasajero ");
        }
        
        return pasajero;
    }
    
    public List<Pasajero> listarPasajero() {
         
        String sql = "SELECT  idPasajero, nombre, apellido, dni, correo, telefono FROM pasajeros WHERE  estado= 1";
        ArrayList<Pasajero> pasajeros = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
         
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                
                Pasajero pasajero = new Pasajero();
                pasajero.setIdPasajero(rs.getInt("idPasajero"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setApellido(rs.getString("apellido"));
                pasajero.setDni(rs.getString("dni"));
                pasajero.setCorreo(rs.getString("correo"));
                pasajero.setTelefono(rs.getString("telefono"));
                pasajero.setEstado(true);
                pasajeros.add(pasajero);
            } 

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pasajero ");
        }
        
        return pasajeros;
    }
    
    public ArrayList<Pasajero> buscarPasajerosCl(String Pclave){
        
         ArrayList<Pasajero>pasajeros=new ArrayList();
        try {
           PreparedStatement ps = con.prepareStatement("SELECT * FROM pasajeros WHERE dni LIKE ?");
           ps.setString(1, Pclave + "%");
            
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Pasajero p = new Pasajero(); 
               p.setIdPasajero(rs.getInt("idPasajero"));
               p.setNombre(rs.getString("nombre"));
               p.setApellido(rs.getString("apellido"));
               p.setDni(rs.getString("dni"));
               p.setCorreo(rs.getString("correo"));
               p.setTelefono(rs.getString("telefono"));
               p.setEstado(rs.getBoolean("estado"));
               pasajeros.add(p);
               
           }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar pasajeros");
        }
        
        
        return pasajeros;
        
    }
    
    public ArrayList<Pasajero> buscarPasajerosC2(String Pclave){
        
         ArrayList<Pasajero>pasajeros=new ArrayList();
        try {
           PreparedStatement ps = con.prepareStatement("SELECT * FROM pasajeros WHERE apellido LIKE ?");
           ps.setString(1, Pclave + "%");
            
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()){
               Pasajero p = new Pasajero(); 
               p.setIdPasajero(rs.getInt("idPasajero"));
               p.setNombre(rs.getString("nombre"));
               p.setApellido(rs.getString("apellido"));
               p.setDni(rs.getString("dni"));
               p.setCorreo(rs.getString("correo"));
               p.setTelefono(rs.getString("telefono"));
               p.setEstado(rs.getBoolean("estado"));
               pasajeros.add(p);
               
           }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar pasajeros");
        }
        
        
        return pasajeros;
        
    }
    
    
}
