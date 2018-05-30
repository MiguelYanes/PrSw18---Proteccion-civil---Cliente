package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Alejandro Cencerrado
 * 
 * Panel Maestro/Detalle de Albergues.
 * 
 */
public class PanelAlbergues extends javax.swing.JPanel implements ActionListener{
    private OyenteVista oyenteVista;

    /**
     * Constructor
     * 
     * Se inicializan todos los componentes y se definen sus ActionCommand y listeners.
     * @param oyenteVista 
     */
    public PanelAlbergues(OyenteVista oyenteVista) {
        this.oyenteVista = oyenteVista;
        initComponents();
        
        jButtonInsertar.addActionListener(this);
        jButtonInsertar.setActionCommand("Insertar Albergue");
        
        jButtonModificar.addActionListener(this);
        jButtonModificar.setActionCommand("Modificar Albergue");
        
        jButtonEliminar.addActionListener(this);
        jButtonEliminar.setActionCommand("Eliminar Albergue");
        
        jButtonRecargar.addActionListener(this);
        jButtonRecargar.setActionCommand("Recargar Albergues");
        
        jTableDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                cambiaJTextFields();
            }
        });
    }
    
    /**
     * Método creado para modificar los jTextField cada vez que cambia la selección de la lista.
     * 
     * Al seleccionar un elemento, la id se vuelve ineditable y se activan los botones de editar y eliminar,
     * mientras que si no hay elemento seleccionado se permite insertar y no modificar ni elminar.
     * 
     */
    public void cambiaJTextFields(){
        int filaSeleccionada = jTableDatos.getSelectedRow();
        String id = jTableDatos.getValueAt(filaSeleccionada, 0).toString();
        jTextFieldId.setText(id);
        
        jTextFieldId.setEditable(id.equals(""));

        jTextFieldCapacidad.setText(jTableDatos.getValueAt(filaSeleccionada, 1).toString());
        jTextFieldCoordenadaX.setText(jTableDatos.getValueAt(filaSeleccionada, 2).toString());
        jTextFieldCoordenadaY.setText(jTableDatos.getValueAt(filaSeleccionada, 3).toString());
        jTextFieldOcupacion.setText(jTableDatos.getValueAt(filaSeleccionada, 4).toString());
        
        jButtonInsertar.setEnabled(id.equals(""));
        jButtonModificar.setEnabled(!id.equals(""));
        jButtonEliminar.setEnabled(!id.equals(""));
    }
    

    @Override
     public void actionPerformed(ActionEvent e) {
        notificacionAControl(e.getActionCommand());
    }
     
    /**
     * Método que recibe envía la notificación a control
     * @param evento 
     */
    public void notificacionAControl(String evento){      
      switch(evento) {
        
        case "Recargar Albergues":
           oyenteVista.notificacion(OyenteVista.Evento.VER_PANEL_ALBERGUES, null);
           break;       
      
        case "Insertar Albergue":
            oyenteVista.notificacion(OyenteVista.Evento.INSERTAR_ALBERGUE, null);
            break;
            
        case "Eliminar Albergue":
            oyenteVista.notificacion(OyenteVista.Evento.ELIMINAR_ALBERGUE, null);
            break;  
      
        case "Modificar Albergue":
            oyenteVista.notificacion(OyenteVista.Evento.MODIFICAR_ALBERGUE, null);
            break;  
        }   
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldCapacidad = new javax.swing.JTextField();
        jTextFieldCoordenadaX = new javax.swing.JTextField();
        jTextFieldCoordenadaY = new javax.swing.JTextField();
        jTextFieldOcupacion = new javax.swing.JTextField();
        jButtonRecargar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonInsertar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Albergues");

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosMouseClicked(evt);
            }
        });
        jTableDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableDatosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jLabel2.setText("ID:");

        jLabel3.setText("Capacidad");

        jLabel4.setText("Coordenada X:");

        jLabel5.setText("Coordenada Y:");

        jLabel6.setText("Ocupación:");

        jTextFieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdActionPerformed(evt);
            }
        });

        jButtonRecargar.setText("Recargar");

        jButtonModificar.setText("Modificar");

        jButtonEliminar.setText("Eliminar");

        jButtonInsertar.setText("Insertar");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCapacidad)
                            .addComponent(jTextFieldId)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldOcupacion)
                            .addComponent(jTextFieldCoordenadaX)
                            .addComponent(jTextFieldCoordenadaY)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRecargar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCoordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCoordenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRecargar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonInsertar)
                    .addComponent(jButtonEliminar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdActionPerformed

    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonInsertarActionPerformed

    private void jTableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosMouseClicked

    }//GEN-LAST:event_jTableDatosMouseClicked

    private void jTableDatosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDatosKeyPressed
        
    }//GEN-LAST:event_jTableDatosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonEliminar;
    public javax.swing.JButton jButtonInsertar;
    public javax.swing.JButton jButtonModificar;
    public javax.swing.JButton jButtonRecargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableDatos;
    public javax.swing.JTextField jTextFieldCapacidad;
    public javax.swing.JTextField jTextFieldCoordenadaX;
    public javax.swing.JTextField jTextFieldCoordenadaY;
    public javax.swing.JTextField jTextFieldId;
    public javax.swing.JTextField jTextFieldOcupacion;
    // End of variables declaration//GEN-END:variables
}
