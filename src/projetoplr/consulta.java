/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoplr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blackpine
 */
public class consulta extends javax.swing.JFrame {

    banco banco = new banco();
     ArrayList<String> FO = new ArrayList();
    public consulta() throws SQLException {
        initComponents();
        FO = banco.pegaFO();
        for(int i=0; i < FO.size();i++){
            jComboBox1.addItem(FO.get(i).toString());
        }
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    
        
        
              this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                principal novatela = null;
                   novatela = new principal();
               
                novatela.setVisible(true);
                consulta.this.dispose();
            }
        });
        
    }
    
    public int contaX(String valor) {
        int cont = 0;
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) == 'x' || valor.charAt(i) == 'X') {
                cont++;
            }

        }
        return cont;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Fo = jComboBox1.getSelectedItem().toString();
        ArrayList allData = new ArrayList();
        allData.add(Fo);
        try {
           ArrayList vamove = banco.pegaRestricoes(Fo);
           for(int i=0; i<vamove.size();i++){
               System.out.println(vamove.get(i).toString());
           }
        } catch (SQLException ex) {
            Logger.getLogger(consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tamanho = 0;
        try {
            System.out.println("aqui");
            tamanho = banco.pegaRestricoes(Fo).size();
        } catch (SQLException ex) {
            Logger.getLogger(consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int qtd[] = new int[tamanho];
        try {
            for(int i=0; i<banco.pegaRestricoes(Fo).size();i++){
                allData.add(banco.pegaRestricoes(Fo).get(i).toString().replace("[", "").replace("]", ""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
         for (int i = 0; i < tamanho; i++) {    
            qtd[i] = contaX(allData.get(i+1).toString());
             System.out.println(allData.get(i+1).toString()+"Teste");
        }
       
            subString(allData, qtd.length);
            new ValidaDados(allData, contaX(Fo), qtd,"consulta");
            this.dispose();
         
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public String[] subString(ArrayList lista, int quantidade) {
        int ln = 0;
        int conta = quantidade * 2 + 1;
        String array[] = new String[conta];
        int cont = 1;
        int newExiste = 0;

        cont = 1;
        for (int i = 0; i < conta; i++) {
            int existe = lista.get(0).toString().indexOf("x" + cont);
            //System.out.println("existe:" + existe);
            String valor = String.valueOf(cont);

            if (i == 0) {
                //Primeiro número do FO
                array[i] = lista.get(0).toString().substring(0, existe);
                newExiste = existe;
                ln = Integer.parseInt(lista.get(0).toString().substring(0, existe)) * -1;

            } else if (i < quantidade) {
                //outros números
                array[i] = lista.get(0).toString().substring(newExiste + valor.length() + 1, existe);
                newExiste = existe;
                //Pegar o valor em negativo
                if ((Integer.parseInt(array[i]) * -1) < ln) {
                    ln = Integer.parseInt(array[i]) * -1;
                }

            } else {
                array[i] = "0";
            }
            cont++;

        }

        return array;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}