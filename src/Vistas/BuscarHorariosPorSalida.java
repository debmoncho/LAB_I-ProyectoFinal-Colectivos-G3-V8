package Vistas;

import Entidades.Horario;
import accesoADatos.HorarioData;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tebby
 */
public class BuscarHorariosPorSalida extends javax.swing.JInternalFrame {

    private DefaultTableModel tablaDec;
    private DefaultComboBoxModel jcombo;
    HorarioData horarioD = new HorarioData();

    /**
     * Creates new form BuscarHorariosPorSalida
     */
    public BuscarHorariosPorSalida() {
        initComponents();
        tablaDec = new DefaultTableModel();
        jcombo = new DefaultComboBoxModel();
        armarCabecera();
        llenarHorarios();

    }

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ruta");
        filaCabecera.add("Salida");
        filaCabecera.add("Llegada");
        //filaCabecera.add("estado");
        for (Object it : filaCabecera) {
            tablaDec.addColumn(it);
        }
        jTable.setModel(tablaDec);
    }

    public void llenarHorarios() {
        List<Horario> listaHora = horarioD.obtenerTodosLosHorarios();
        jcombo = new DefaultComboBoxModel(listaHora.toArray());
        jHora.setModel(jcombo);
    }

    private void agregarHorarios() {
        Horario hora = (Horario) jHora.getSelectedItem();

        tablaDec.setRowCount(0);
        tablaDec.addRow(new Object[]{hora.getRuta(), hora.getHoraSalida(), hora.getHoraLlegada()});
        jTable.setModel(tablaDec);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHora = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHoraActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ruta", "Hora de Salida", "Hora de Llegada"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Busqueda de Horario por Salida");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Seleccione la Hora de Salida");
        jLabel10.setToolTipText("");
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(221, 221, 221)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jHora, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHoraActionPerformed
        // TODO add your handling code here:
        agregarHorarios();
    }//GEN-LAST:event_jHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jHora;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
