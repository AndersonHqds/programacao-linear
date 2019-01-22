/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoplr;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcelo Martins
 */
public class telaTabelas extends JFrame {

    public telaTabelas(ArrayList tabelas, int culuna, int numTabelas, ArrayList data,String operacao) {
        //Tela no centro
        this.setSize(500, 500);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int z = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(z, y);
        this.setResizable(false);
        //Tela no centro
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                telaResultado novatela = null;
                try {
                    novatela = new telaResultado(tabelas, culuna, numTabelas, data, operacao);
                } catch (SQLException ex) {
                    Logger.getLogger(telaTabelas.class.getName()).log(Level.SEVERE, null, ex);
                }
                novatela.setVisible(true);
                telaTabelas.this.dispose();
            }
        });
       /*COLOCAR VALORES NAS TABELAS*/
        double matriz[][] = null;
        String[] culunaNome = new String[culuna];
        int cont2 = 0;
        //NOME DO HEADER DA TABELA
        for (int i = 1; i < culunaNome.length - 1; i++) {
            if (i >= culuna / 2) {
                cont2++;
                culunaNome[i] = "XF" + cont2;
            } else {
                culunaNome[i] = "X" + i;
            }
        }
        culunaNome[0] = "Z";
        culunaNome[culuna - 1] = "B";

        //Adicionando Dados
        //CRIANDO O ROLE DE ABA
        JTabbedPane jtp = new JTabbedPane();

        for (int x = 0; x < numTabelas; x++) {
            //Criando uma nova JTABLE para cada numtabela
            JTable tbl = new JTable();

            DefaultTableModel dtm = new DefaultTableModel(culuna / 2, culuna);

            dtm.setColumnIdentifiers(culunaNome);
            //set model into the table object
            tbl.setModel(dtm);
            //CRIANDO AS ABINHAS 
            if (x == numTabelas - 1) {
                //TITULO, JSCROLLPANE = (PARA DAR SCROLL NA TABELA) TBL = TABELA, ESTA LINHA AUTOMATICAMENTE
                //ADICIONAR A TABELA NA ABA CRIADA
                jtp.addTab("Melhor Resolução", new JScrollPane(tbl));
            } else {
                //TITULO, JSCROLLPANE = (PARA DAR SCROLL NA TABELA) TBL = TABELA, ESTA LINHA AUTOMATICAMENTE
                //ADICIONAR A TABELA NA ABA CRIADA
                jtp.addTab("Algoritimo " + (x + 1), new JScrollPane(tbl));
            }
            //PADRÃO CRIADO PARA VISUALIZAÇÃO 
            jtp.setTabPlacement(JTabbedPane.TOP);
            jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            this.add(jtp, BorderLayout.CENTER);
            this.pack();
            
            matriz = (double[][]) tabelas.get(x);
            //PEGANDO TODAS AS LINHAS E PERCORRENDO
            for (int i = 0; i < matriz.length; i++) {
                //PEGANDO TODAS AS COLUNAS DA LINHA E PERCORRENDO
                for (int j = 0; j < matriz[i].length; j++) {
                    //SETVALUEAT COMO FUNCIONA?
                    /*
                    .setValueAt(valor,posição linha, posição coluna)
                    */
                    dtm.setValueAt(matriz[i][j], i, j);
                }
            }
            //SETANDO NULL PARA NÃO CARREGAR DADOS DE LIXO
            matriz = null;
        }

    }
}
