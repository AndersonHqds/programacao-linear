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
import javax.swing.JOptionPane;

/**
 *
 * @author 0040481612031
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    int cont = 1;
    int index = 0;

    public principal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfoMax = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnprosseguir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnadicionar = new javax.swing.JButton();
        txtrestricao = new javax.swing.JTextField();
        lblrestricao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnexcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxrestricoes = new javax.swing.JComboBox<>();
        btnalterar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtfoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfoMaxActionPerformed(evt);
            }
        });
        txtfoMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfoMaxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfoMaxKeyReleased(evt);
            }
        });

        jLabel1.setText("FO MAX (Z) =");

        btnprosseguir.setText("Prosseguir");
        btnprosseguir.setEnabled(false);
        btnprosseguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprosseguirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Restrições"));

        btnadicionar.setText("+");
        btnadicionar.setEnabled(false);
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });

        txtrestricao.setEditable(false);
        txtrestricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrestricaoActionPerformed(evt);
            }
        });

        lblrestricao.setText("1");

        jLabel2.setText("Restrição");

        btnexcluir.setText("Selecionar");
        btnexcluir.setEnabled(false);
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });

        jLabel3.setText("Restrições");

        cbxrestricoes.setEnabled(false);
        cbxrestricoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxrestricoesItemStateChanged(evt);
            }
        });
        cbxrestricoes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbxrestricoesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxrestricoesFocusLost(evt);
            }
        });
        cbxrestricoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxrestricoesMouseClicked(evt);
            }
        });
        cbxrestricoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxrestricoesActionPerformed(evt);
            }
        });

        btnalterar.setText("Salvar");
        btnalterar.setEnabled(false);
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });

        btncancelar.setText("x");
        btncancelar.setEnabled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxrestricoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnexcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblrestricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtrestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnadicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnalterar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblrestricao)
                    .addComponent(jLabel2)
                    .addComponent(txtrestricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadicionar)
                    .addComponent(btnalterar)
                    .addComponent(btncancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxrestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexcluir)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jMenu1.setText("Consulta");

        jMenuItem1.setText("Consultar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnprosseguir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtfoMax))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnprosseguir)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(456, 354));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtfoMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfoMaxKeyPressed
        // TODO add your handling code here:
        boolean verifica = verificaTamanho();
        controlaTela(verifica);
    }//GEN-LAST:event_txtfoMaxKeyPressed

    private void txtfoMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfoMaxKeyReleased
        // TODO add your handling code here:
        boolean verifica = verificaTamanho();
        controlaTela(verifica);

    }//GEN-LAST:event_txtfoMaxKeyReleased

    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
        // TODO add your handling code here:
        if (!txtrestricao.getText().equals("")) {
            cbxrestricoes.addItem(txtrestricao.getText().replaceAll("\\s+", ""));
            cont++;
            lblrestricao.setText(String.valueOf(cont));
            txtrestricao.setText("");
            boolean prossegue = verficaProsseguir();
            btnprosseguir.setEnabled(prossegue);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Preencher campo restrição");
        }
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void cbxrestricoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxrestricoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxrestricoesActionPerformed

    private void cbxrestricoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxrestricoesItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxrestricoesItemStateChanged

    private void cbxrestricoesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxrestricoesFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxrestricoesFocusGained

    private void cbxrestricoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxrestricoesMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxrestricoesMouseClicked

    private void cbxrestricoesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxrestricoesFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxrestricoesFocusLost

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        if (cbxrestricoes.getSelectedIndex() != -1) {
            String texto = btnexcluir.getText().toString();
            index = cbxrestricoes.getSelectedIndex();
            if (texto.equals("Selecionar")) {
                txtrestricao.setText((cbxrestricoes.getSelectedItem().toString()));
                controlaTelaSelecionar(true);
                btnexcluir.setText("Excluir");
                cbxrestricoes.setEnabled(false);
            } else {
                cbxrestricoes.setEnabled(true);
                cbxrestricoes.removeItemAt(index);
                controlaTelaSelecionar(false);
                txtrestricao.setText("");
                btnexcluir.setText("Selecionar");
                cont--;
                boolean prossegue = verficaProsseguir();
                btnprosseguir.setEnabled(prossegue);
                lblrestricao.setText(String.valueOf(cont));
            }
        }

    }//GEN-LAST:event_btnexcluirActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        controlaTelaSelecionar(false);
        cbxrestricoes.setEnabled(true);
        txtrestricao.setText("");
        btnexcluir.setText("Selecionar");
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        // TODO add your handling code here:
        cbxrestricoes.removeItemAt(index);
        cbxrestricoes.setEnabled(true);
        cbxrestricoes.addItem(txtrestricao.getText().toString());
        controlaTelaSelecionar(false);
        txtrestricao.setText("");
        btnexcluir.setText("Selecionar");

    }//GEN-LAST:event_btnalterarActionPerformed

    private void btnprosseguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprosseguirActionPerformed
        // TODO add your handling code here:
        ArrayList allData = new ArrayList();
        allData.add(txtfoMax.getText());
        int tamanho = cbxrestricoes.getItemCount();
        int qtd[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            allData.add(cbxrestricoes.getItemAt(i));
            qtd[i] = contaX(cbxrestricoes.getItemAt(i));
        }
        try {
            subString(allData, qtd.length);
            new ValidaDados(allData, contaX(txtfoMax.getText()), qtd,"");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digitação incorreta !");
        }


    }//GEN-LAST:event_btnprosseguirActionPerformed

    private void txtfoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfoMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfoMaxActionPerformed

    private void txtrestricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrestricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrestricaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       consulta consultaOlds = null;
        try {
            consultaOlds = new consulta();
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
       consultaOlds.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    public void controlaTelaSelecionar(boolean bol) {
        btncancelar.setEnabled(bol);
        btnalterar.setEnabled(bol);
        btnadicionar.setEnabled(!bol);
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

    public void controlaTela(boolean bol) {
        txtrestricao.setEditable(bol);
        btnadicionar.setEnabled(bol);
        btnexcluir.setEnabled(bol);
        cbxrestricoes.setEnabled(bol);
    }

    public boolean verificaTamanho() {
        if (txtfoMax.getText().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verficaProsseguir() {
        if (cont == 1) {
            cbxrestricoes.setSelectedIndex(-1);
            return false;
        } else {
            return true;
        }
    }

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
    private javax.swing.JButton btnadicionar;
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnprosseguir;
    private javax.swing.JComboBox<String> cbxrestricoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblrestricao;
    private javax.swing.JTextField txtfoMax;
    private javax.swing.JTextField txtrestricao;
    // End of variables declaration//GEN-END:variables
}