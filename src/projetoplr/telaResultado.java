/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoplr;


//import java.awt.AWTException;
//import java.awt.BorderLayout;
//import java.awt.Component;
import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.Rectangle;
//import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.imageio.ImageIO;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;

/**
 *
 * @author 0040481612038
 */
public class telaResultado extends javax.swing.JFrame {
    banco banco = new banco();
    JTable tabela;
    JScrollPane barraRolagem;

    /**
     * Creates new form telaResultado
     */
    public telaResultado(ArrayList tabelas, int culuna, int numTabelas, ArrayList data,String operacao) throws SQLException {
        initComponents();

        this.setLayout(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setSize(400, 400);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int z = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(z, y);
        this.setResizable(false);

        //FO
        JLabel FO = new JLabel();
        FO.setText("FO");
        this.add(FO);
        FO.setBounds(20, 20, 200, 30);

        JLabel FOValue = new JLabel();
        FOValue.setText(data.get(0).toString());
        this.add(FOValue);
        FOValue.setBounds(20, 60, 200, 30);
        //FIM DO FO

        /*RESTRIÇOESSSSSSSSSSSSSSSSSSSSSSS*/
        JLabel restricoes = new JLabel();
        restricoes.setText("Restrições");
        this.add(restricoes);
        restricoes.setBounds(280, 20, 200, 30);
        int tamanho = data.size();
        JLabel[] labels = new JLabel[tamanho - 1];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        int firstValueY = 20;
        for (int i = 0; i < labels.length; i++) {
            firstValueY += 40;
            labels[i].setText(data.get(i + 1).toString());
            this.add(labels[i]);
            labels[i].setBounds(280, firstValueY, 200, 30);
        }

        /*FIM DAS RESTRIÇÕES*/
        
        
        JButton resultados = new JButton("Resultados");
        this.add(resultados);
        resultados.setBounds(280, 290, 100, 30);
     
        if(operacao.equals("")){
        JButton confirmar = new JButton("Salvar");
        this.add(confirmar);
        confirmar.setBounds(20, 290, 100, 30);
     
     confirmar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for(int i=0; i<data.size();i++){
            int aux=1;
            int id = 0;
            if(i==0){
                
                try {
                    banco.insereFO(data.get(i).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(telaResultado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    id = banco.pegaID();
                } catch (SQLException ex) {
                    Logger.getLogger(telaResultado.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    banco.insereVariaveis(data.get(i).toString(), id);
                } catch (SQLException ex) {
                    Logger.getLogger(telaResultado.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
            
            }
                JOptionPane.showMessageDialog(null,"Inserido com sucesso");
            }
           
        });
     }
        resultados.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaTabelas novatela = new telaTabelas(tabelas, culuna, numTabelas, data,operacao);
                novatela.show();
                telaResultado.this.dispose();

            }
        });
        
        
       

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                principal principalTela = new principal();
                principalTela.setVisible(true);
                telaResultado.this.dispose();
            }
        });
    }


    /*
    
    
    
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(554, 446));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
