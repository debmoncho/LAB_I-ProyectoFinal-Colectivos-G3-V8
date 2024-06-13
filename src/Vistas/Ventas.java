/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import accesoADatos.ColectivoData;
import accesoADatos.HorarioData;
import accesoADatos.PasajeData;
import accesoADatos.PasajeroData;
import accesoADatos.RutaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tebby
 */
public class Ventas extends javax.swing.JInternalFrame {

    private HorarioData hd = new HorarioData();
    private RutaData rd = new RutaData();
    private PasajeroData pd = new PasajeroData();
    private ColectivoData cd = new ColectivoData();
    private PasajeData pasajeD = new PasajeData();
    private DefaultTableModel modelo;
    private DefaultComboBoxModel comboModelo;

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        modelo = new DefaultTableModel();
        comboModelo = new DefaultComboBoxModel();
        armarCabecera();
        llenarRutas();
        LlenarColectivos();

    }

    public void LlenarColectivos() {
        List<Colectivo> listaCole = cd.listarColectivos();
        comboModelo = new DefaultComboBoxModel(listaCole.toArray());
        jComboColectivo.setModel(comboModelo);
    }

    public void llenarRutas() {
        List<Ruta> listaRuta = rd.listarRuta();
        comboModelo = new DefaultComboBoxModel(listaRuta.toArray());
        jComboRuta.setModel(comboModelo);
    }

    public void llenarHorario() {
        Ruta ruta = (Ruta) jComboRuta.getSelectedItem();
        List<Horario> listaHora = hd.obtenerHorarioPorRutaYEstado(ruta.getIdRuta());
        List<String> infoHora = new ArrayList<>();

        for (Horario hora : listaHora) {
            String info = hora.getHoraSalida().toString();
            infoHora.add(info);
        }

        comboModelo = new DefaultComboBoxModel(infoHora.toArray());
        jComboHora.setModel(comboModelo);
    }

    public void traerAsientos() {
        Colectivo cole = (Colectivo) jComboColectivo.getSelectedItem();
        List<Pasaje> pasajes = pasajeD.obtenerPasajesCompradosPorColectivo(cole.getIdColectivo());
        List<Integer> pasajesComprados = new ArrayList<Integer>();
        boolean comprado = false;
        for (Pasaje p : pasajes) {

            pasajesComprados.add(p.getAsiento());

        }
        List<Integer> asientos = new ArrayList<Integer>();
        for (int i = 0; i < cole.getCapacidad(); i++) {
            comprado = false;
            for (Integer p : pasajesComprados) {
                if (i + 1 == p) {
                    comprado = true;
                    break;
                }
            }
            if (!comprado) {
                asientos.add(i + 1);
            }
        }
        comboModelo = new DefaultComboBoxModel(asientos.toArray());
        jComboAsiento.setModel(comboModelo);
    }

    private void llenarTabla(ArrayList<Pasajero> pasajeros) {
        for (Pasajero aux : pasajeros) {
            Pasajero pasajero = aux;
            if (pasajero.isEstado()) {
                modelo.addRow(new Object[]{pasajero.getIdPasajero(), pasajero.getNombre(), pasajero.getApellido(), pasajero.getDni(), pasajero.getTelefono()});
            }
        }
        jTabla.setModel(modelo);
    }

    public void llenarTablaPorSeleccion() {
        modelo.setRowCount(0);
        ArrayList<Pasajero> listaPasajero = pd.buscarPasajerosCl(jDni.getText());
        llenarTabla(listaPasajero);
    }

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Id");
        filaCabecera.add("Nombre");
        filaCabecera.add("Apellido");
        filaCabecera.add("Dni ");
        filaCabecera.add("Telefono");
        //filaCabecera.add("estado");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboRuta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboHora = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboColectivo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboAsiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaRecibo = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabla);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese DNI de Pasajero:");

        jDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDniKeyReleased(evt);
            }
        });

        jLabel4.setText("Ruta:");

        jComboRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboRutaActionPerformed(evt);
            }
        });

        jLabel5.setText("Horario de Viaje:");

        jComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHoraActionPerformed(evt);
            }
        });

        jLabel6.setText("Colectivo:");

        jComboColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboColectivoActionPerformed(evt);
            }
        });

        jLabel7.setText("Nº de Asiento:");

        jComboAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAsientoActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha de Viaje:");

        jGuardar.setText("Guardar Venta");
        jGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        jLabel9.setText("Precio del Pasaje:");

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venta de pasajes");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ingrese Datos para Venta de Pasaje");
        jLabel12.setToolTipText("");
        jLabel12.setAlignmentY(0.0F);
        jLabel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Busqueda de Pasajero");
        jLabel13.setToolTipText("");
        jLabel13.setAlignmentY(0.0F);
        jLabel13.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtaRecibo.setColumns(20);
        jtaRecibo.setRows(5);
        jtaRecibo.setText("(Aca podria cargar los datos del pasaje emitido)");
        jtaRecibo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jScrollPane3.setViewportView(jtaRecibo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(jDni, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(171, 171, 171)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboRuta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboColectivo, javax.swing.GroupLayout.Alignment.LEADING, 0, 530, Short.MAX_VALUE)
                                .addComponent(jComboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jDni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jGuardar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jLabel13)
                    .addContainerGap(844, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDniKeyReleased
        // TODO add your handling code here:
        llenarTablaPorSeleccion();

    }//GEN-LAST:event_jDniKeyReleased

    private void jComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboHoraActionPerformed

    private void jComboRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboRutaActionPerformed
        // TODO add your handling code here:
        llenarHorario();
    }//GEN-LAST:event_jComboRutaActionPerformed

    private void jComboColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboColectivoActionPerformed
        // TODO add your handling code here:
        traerAsientos();
    }//GEN-LAST:event_jComboColectivoActionPerformed

    private void jComboAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAsientoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboAsientoActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
        try{
        DefaultTableModel model2 = (DefaultTableModel) jTabla.getModel();
        int id = (int) model2.getValueAt(jTabla.getSelectedRow(), 0);
        Pasajero pasajero = pd.buscarPasajero(id);
        java.util.Date fecha = jdFecha.getDate();
        LocalDate lc = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();
        if(ahora.isAfter(lc)){
            JOptionPane.showMessageDialog(null, "fecha incorrecta");
            jdFecha.setDate(null);
            return;
        }
        
        Ruta ruta = (Ruta) jComboRuta.getSelectedItem();
        String selected = (String) jComboHora.getSelectedItem();
        LocalTime horaViaje = LocalTime.parse(selected);
        Colectivo colectivo = (Colectivo) jComboColectivo.getSelectedItem();
        int asiento = (int) jComboAsiento.getSelectedItem();
        String pre = jtPrecio.getText();
        double precio = (double) Double.parseDouble(pre);
        Pasaje pasaje = new Pasaje(0, pasajero, colectivo, ruta, lc, horaViaje, asiento, precio);
//        JOptionPane.showMessageDialog(null, info);
            pasajeD.guardarPasaje(pasaje);
        jtaRecibo.setText(pasaje.mensajeRecibo());
        jdFecha.setDate(null);
        jComboHora.removeAllItems();
        jComboAsiento.removeAllItems();
        llenarRutas();
        LlenarColectivos();
        jtPrecio.setText("");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Se esperaban numeros no otros caracteres");
        }
        
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboAsiento;
    private javax.swing.JComboBox<String> jComboColectivo;
    private javax.swing.JComboBox<String> jComboHora;
    private javax.swing.JComboBox<String> jComboRuta;
    private javax.swing.JTextField jDni;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabla;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTextArea jtaRecibo;
    // End of variables declaration//GEN-END:variables
}
