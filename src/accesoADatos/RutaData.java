package accesoADatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SrPanda
 */
public class RutaData {

    private Connection con = null;

    public RutaData() {

        con = Conexion.getConexion();

    }

    public void guardarRuta(Ruta ruta) {

        String sql = "INSERT INTO Rutas (origen,destino,duracionEstimada,estado)"
                + "VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getDuracionEstimada()));
            ps.setBoolean(4, ruta.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                ruta.setIdRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ruta Guardada Correctamente");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ruta Incorrecta " + ex);
        }

    }

    public void eliminarRuta(int idRuta) {

        String sql = "UPDATE rutas SET estado = 0 WHERE idRuta = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se a Eliminado La Ruta Correctamente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Ruta");
        }

    }

    public Ruta buscarRuta(int idRuta) {

        String sql = "SELECT  origen, destino, duracionEstimada FROM rutas WHERE idRuta = ? AND estado = 1";
        Ruta ruta = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ruta = new Ruta();
                ruta.setIdRuta(idRuta);
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "La ruta no Existe ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ruta No Cargada en el Sistema " + ex);
        }
        return ruta;
    }

    public List<Ruta> listarRuta() {
        String sql = "SELECT idRuta , origen, destino, duracionEstimada"
                + " FROM rutas WHERE estado = 1";
        ArrayList<Ruta> rutas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(true);

                rutas.add(ruta);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar Ruta");
        }

        return rutas;
    }

    public void actualiazRuta(Ruta ruta) {

        String sql = "UPDATE rutas SET origen = ?, destino = ?, duracionEstimada = ?, estado = ? WHERE idRuta = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getDuracionEstimada()));
            ps.setBoolean(4, ruta.isEstado());
            ps.setInt(5, ruta.getIdRuta());

            int exit = ps.executeUpdate();

            if (exit == 1) {
                JOptionPane.showMessageDialog(null, "Ruta modificada!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La Ruta sin Problemas");
        }

    }

    public List<Ruta> listarOrigen() {
        String sql = "SELECT idRuta, origen, destino, duracionEstimada FROM rutas WHERE estado = 1";
        ArrayList<Ruta> rutas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(true);

                rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar Orígenes");
        }

        return rutas;
    }

    public List<Ruta> listarDestino() {
        String sql = "SELECT idRuta, origen, destino, duracionEstimada FROM rutas WHERE estado = 1";
        ArrayList<Ruta> rutas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("idRuta"));
                ruta.setOrigen(rs.getString("origen"));
                ruta.setDestino(rs.getString("destino"));
                ruta.setDuracionEstimada(rs.getTime("duracionEstimada").toLocalTime());
                ruta.setEstado(true);

                rutas.add(ruta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar Destinos");
        }

        return rutas;
    }
}
