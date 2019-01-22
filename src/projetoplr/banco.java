/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoplr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author blackpine
 */
public class banco {
    Connection con;
    
    public banco(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpl","root","");
           System.out.println("Conectado");
       }
       catch(ClassNotFoundException | SQLException erro)
       {
           System.out.println(erro.getMessage());
       }
    }
    
    public void insereFO(String querie) throws SQLException{
        Statement comando = con.createStatement();
        try {    
            comando.execute("INSERT INTO `tbl_FO`(`FO`) VALUES ('"+querie+"');");//ExeculteQuery(Execulta comando e trás resultado de uma consulta==Select) Execulte(Não gera resultado)
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
        }
       
    }
    
    public int pegaID() throws SQLException
    {   
         int id = 0;
         Statement comando = con.createStatement();
         try {
            
            ResultSet resultado = comando.executeQuery("SELECT Id FROM `tbl_FO`");//ExeculteQuery(Execulta comando e trás resultado de uma consulta==Select) Execulte(Não gera resultado)
           while(resultado.next()){
              id = resultado.getInt(1);
           }
             System.out.println(id);
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
        }
         return id;
    }
    
    public void insereVariaveis(String querie,int idTable) throws SQLException{
       Statement comando = con.createStatement();
      try{
      comando.execute("INSERT INTO `tbl_Variaveis`(`IdTable`, `variaveis`) VALUES ('"+idTable+"','"+querie+"');");//ExeculteQuery(Execulta comando e trás resultado de uma consulta==Select) Execulte(Não gera resultado)
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
    }
    }
    
   public ArrayList<String> pegaFO() throws SQLException
    {   
         int id = 0;
         ArrayList<String> FO = new ArrayList();
         
         Statement comando = con.createStatement();
         try {
            
            ResultSet resultado = comando.executeQuery("SELECT FO FROM `tbl_FO`");//ExeculteQuery(Execulta comando e trás resultado de uma consulta==Select) Execulte(Não gera resultado)
           while(resultado.next()){
              FO.add(resultado.getString("FO"));
           }
             System.out.println(id);
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
        }
         return FO;
    }
   
   public ArrayList<String> pegaRestricoes(String expressao) throws SQLException
    {   
        
         ArrayList<String> restricoes = new ArrayList();
         int i=0;
         Statement comando = con.createStatement();
         try {
            ResultSet resultado = comando.executeQuery("SELECT DISTINCT tv.variaveis FROM tbl_FO t, tbl_Variaveis tv WHERE t.FO ='"+expressao+"'");//ExeculteQuery(Execulta comando e trás resultado de uma consulta==Select) Execulte(Não gera resultado)
           while(resultado.next()){
               
              restricoes.add(resultado.getString("variaveis"));
               System.out.println(restricoes.get(i).toString()+"Daqui");
               i++;
           }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       
        }
         return restricoes;
    }
}
