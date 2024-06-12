
package accesoADatos;

import Entidades.Colectivo;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ColectivoData {
    
    private Connection con = null;

    public ColectivoData() {

        con = Conexion.getConexion();
    }
    
    public void guardarColectivo(Colectivo colectivo) {

        String sql = "INSERT INTO colectivos (matricula, marca, modelo, capacidad, estado)"
                + "VALUES (? ,? ,? ,? ,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setBoolean(5, colectivo.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                colectivo.setIdColectivo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Bondi Guardado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el bondi");
            ex.printStackTrace();
        }

    }
    
    
    public void modificarColectivo(Colectivo colectivo) {

        String sql = "UPDATE `colectivos` SET matricula = ? , marca = ? , modelo = ? ,"
                + "capacidad = ? WHERE idColectivo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, colectivo.getMatricula());
            ps.setString(2, colectivo.getMarca());
            ps.setString(3, colectivo.getModelo());
            ps.setInt(4, colectivo.getCapacidad());
            ps.setInt(5, colectivo.getIdColectivo());
            
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Bondi modificado!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el bondi");
            ex.printStackTrace();
            
            
        }
    }
    
    
    public void eliminarColectivo(int id) {

        String sql = "UPDATE colectivos SET estado = 0  WHERE idColectivo = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Bondi eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el bondi!");
            ex.printStackTrace();
        }
    }

    
    public Colectivo buscarColectivo(int id) {

        String sql = "SELECT matricula, marca, modelo, capacidad "
                + "FROM colectivos WHERE idColectivo = ? AND estado = 1";
        Colectivo colectivo = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                colectivo = new Colectivo();
                
                colectivo.setIdColectivo(id);
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                colectivo.setEstado(true);
                
            } else {
                
                JOptionPane.showMessageDialog(null, "No existe ese bondi");
                
            }
            
            ps.close();

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al buscar el bondi");
        }

        return colectivo;
    }
    
    
    //faltaria buscar colectivo por id = buscar alumno por id
    //pero como el metodo esta arriba, no lo agregue
    
    
    public List<Colectivo> listarColectivos() {

        String sql = "SELECT idColectivo, matricula, marca, modelo, capacidad "
                + "FROM colectivos WHERE estado = 1";
        
        ArrayList<Colectivo> colectivos = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Colectivo colectivo = new Colectivo();
                colectivo.setIdColectivo(rs.getInt("idColectivo"));
                colectivo.setMatricula(rs.getString("matricula"));
                colectivo.setMarca(rs.getString("marca"));
                colectivo.setModelo(rs.getString("modelo"));
                colectivo.setCapacidad(rs.getInt("capacidad"));
                
                colectivo.setEstado(true);
                colectivos.add(colectivo);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el bondi ");
            ex.printStackTrace();
        }

        return colectivos;
    }
    
   
    
    
    
    
    
}
    
    
    
