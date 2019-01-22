/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoplr;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 0040481612031
 */
public final class ValidaDados {

    int ln;
    double[][] tabela;
    ArrayList dataOriginalPrincipal = new ArrayList();
    int tabelas;
    ArrayList todasAsTabelas = new ArrayList();
    int culunas;
   
    public ValidaDados(ArrayList data, int quantidade, int qtdRest[],String op) {
        int somaqtd = 0;
        

        for (int i = 0; i < qtdRest.length; i++) {
            somaqtd = somaqtd + qtdRest[i];
        }
        //subString(data, quantidade);
        for (int i = 0; i < data.size(); i++) {
            dataOriginalPrincipal.add(data.get(i));
        }
        
        double[][] calcula = calcula(subString(data, quantidade), restricoes(data, somaqtd, quantidade, qtdRest), data, quantidade);
        telaTabelas resultado = new telaTabelas(todasAsTabelas, culunas, tabelas, dataOriginalPrincipal,op);
        resultado.setVisible(true);

    }

    public String[] subString(ArrayList lista, int quantidade) {

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

    public double[][] calcula(String[] fo, int[][] restricoes, ArrayList lista, int quantidade) {
        int z = 1;
        int[] foNew;

        foNew = retornaInt(fo);
        double pegaPivot = 0;
        int guardaLn = 0, linePivot = 0;
        double pivot = 0;
        int fim = quantidade * 2 + 2;
        int lastLine = lista.size() - 1;
        double[][] tabela = new double[lista.size()][quantidade * 2 + 2];
        for (int i = 0; i < lista.size(); i++) {
            for (int o = 0; o < fim; o++) {
                if (i == 0) {
                    //primeiro receberá z
                    if (i == 0 && o == 0) {
                        tabela[i][o] = z;
                    } else {
                        //depois o FO
                        tabela[i][o] = foNew[o - 1] * -1;
                        //e o valor da tabela for igual ln pega a coluna em qe ln está
                        if (tabela[i][o] == ln) {
                            guardaLn = o;
                        }

                    }
                } else {
                    //Coluna Z
                    if (o == 0) {
                        tabela[i][o] = 0;
                    } //Outras colunas
                    else {
                        tabela[i][o] = restricoes[i - 1][o - 1];
                    }
                    //Se o(coluna) for igual a guarda ln(posição da coluna da ln)
                    if (o == guardaLn && i > 1) {
                        //System.out.println("foi");
                        //Divide o B pelos elementos da coluna ln
                        //pega a linha anterior e divide pelo b annterior
                        pegaPivot = tabela[i - 1][fim - 1] / tabela[i - 1][guardaLn];
                        //Se a linha for a segunda(i=0)
                        //armazenará a divisão de b por ln em pivot e pegará essa linha
                        if (i == 2) {
                            pivot = pegaPivot;
                            //Pegará a linha anterior(linha das operações)
                            linePivot = i - 1;
                        } //Verifica o menor numero positivo e pega a linha
                        else if (pegaPivot > 0 && pegaPivot < pivot) {
                            pivot = pegaPivot;
                            linePivot = i - 1;
                        }
                        //System.out.println(pegaPivot+"pgpv");
                    }
                }

                System.out.print(tabela[i][o] + " ");

            }
            System.out.println("");
            //tabela[i][o] 

        }
        todasAsTabelas.add(tabela);
        tabelas++;
        //Pegando a ultima linha
        pegaPivot = tabela[lastLine][fim - 1] / tabela[lista.size() - 1][guardaLn];

        if (pegaPivot > 0 && pegaPivot < pivot) {
            pivot = pegaPivot;
            linePivot = lastLine;

        }
        newLinePivot(tabela, linePivot, tabela[linePivot][guardaLn], fim, lista.size(), guardaLn);
        return tabela;
    }

    public void calcula2(int linhas, int colunas, int colunaMain, double[][] newTable) {
        double[][] newTab = new double[linhas][colunas];

        int z = 1;
        int cont = 0;
        double[] check = new double[colunas];
        for (int i = 0; i < linhas; i++) {
            for (int o = 0; o < colunas; o++) {
                if (i == 0 && o == 0) {
                    newTab[i][o] = z;
                } else {
                    newTab[i][o] = newTable[i][o];
                    if (i == 0) {
                        check[i] = newTable[i][o];
                        if (check[i] >= 0) {
                            cont++;
                        }

                    }
                }
            }
        }
        todasAsTabelas.add(newTab);
        tabelas++;
        // System.out.println(colunas+"Colunas");
        if (cont != colunas - 1) {

            pegaPivot(linhas, colunas, newTab);
        } else {
            for (int i = 0; i < linhas; i++) {
                for (int o = 0; o < colunas; o++) {
                    // System.out.println(newTab[i][o]);   

                }
            }
            System.out.println("Melhor Solução");
            culunas=colunas;
        } 
        newTab = null;
        return;
    }

    public int[][] restricoes(ArrayList lista, int somaqtd, int quantidade, int qtdRest[]) {
        String valor;

        int existe, newExiste = 0;
        int fim = quantidade * 2 + 1;
        boolean aux = false;
        int armazena = 0, armazena2 = 0;
        int[][] restricoes = new int[lista.size()][quantidade * 2 + 1];
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int o = 0; o < fim; o++) {
                existe = lista.get(i + 1).toString().indexOf("x" + (o + 1));

                int existeRest = lista.get(i + 1).toString().indexOf("<=");
                if (o == 0) {
                    //Primeiro número de cada restrição
                    restricoes[i][o] = Integer.parseInt(lista.get(i + 1).toString().substring(0, existe));
                    newExiste = existe;
                } else {
                    if (o + 1 > quantidade * 2) {
                        restricoes[i][o] = Integer.parseInt(lista.get(i + 1).toString().substring(existeRest + 2, lista.get(i + 1).toString().length()));

                    } else {

                        if ((o + 1) > qtdRest[i] && (o + 1) <= (quantidade * 2) && aux == true) {
                            restricoes[i][o] = 0;
                            if (o + 1 == armazena + 1 && i == armazena2) {
                                aux = false;
                            }
                        } else {
                            if ((o + 1) > qtdRest[i] && (o + 1) <= (quantidade * 2) && aux == false) {
                                restricoes[i][o] = 1;
                                armazena = o;
                                armazena2 = i + 1;
                                aux = true;
                            } else {
                                valor = String.valueOf(o + 1);
                                //Outros números das retrições
                                restricoes[i][o] = Integer.parseInt(lista.get(i + 1).toString().substring(newExiste + valor.length() + 1, existe));
                            }
                        }
                    }
                    newExiste = existe;
                }

            }

        }

        return restricoes;
    }

    public double[][] recalcula(double[][] tabela, int colunas, int linhas, double[] newlinepvt, int colunaP, int linePvt) {
        double[][] newTabela = new double[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int o = 0; o < colunas; o++) {
                if (i != linePvt) {
                    newTabela[i][o] = (newlinepvt[o] * (double) (tabela[i][colunaP] * -1)) + (double) tabela[i][o];
                } else {
                    newTabela[i][o] = newlinepvt[o];
                }
                System.out.println(newTabela[i][o]);

            }
        }
        calcula2(linhas, colunas, colunaP, newTabela);
        newTabela = null;
        return newTabela;
    }

    public void newLinePivot(double[][] tabela, int linePivot, double elemPivot, int colunas, int linhas, int colunaP) {
        // System.out.println(elemPivot+"lpvt");

        double[] newLpv = new double[colunas * 2];

        //Pegando os números da linha pivot
        for (int i = 0; i < colunas; i++) {
            newLpv[i] = (double) tabela[linePivot][i] / elemPivot;
        }
        //Linha pivot =  newLpv
        //linePivot = posição em que a linha pivot está
        recalcula(tabela, colunas, linhas, newLpv, colunaP, linePivot);
        newLpv = null;
        return;
    }

    public int[] retornaInt(String[] texto) {
        int[] foNew = new int[texto.length * 2];
        for (int i = 0; i < texto.length; i++) {
            foNew[i] = Integer.parseInt(texto[i]);
        }
        return foNew;
    }

    public void pegaPivot(int linha, int coluna, double[][] tabela) {
        double guardaLn = 2;
        int colLn = 0;
        double[][] table = new double[linha * 2][coluna * 2];
        double pegaPivot2 = 0, pivot = 0;
        int linePivot = 0;
        for (int i = 0; i < linha; i++) {
            for (int o = 0; o < coluna; o++) {
                table[i][o] = tabela[i][o];
                //restricoes[i - 1][o - 1];
                if (i == 0 && tabela[i][o] < guardaLn) {
                    guardaLn = tabela[i][o];
                    colLn = o;
                    // System.out.println(guardaLn);
                }
                //Se o(coluna) for igual a guarda colLn(posição da coluna da ln)
                if (o == colLn && i > 1) {

                    //Divide o B pelos elementos da coluna ln
                    //pega a linha anterior e divide pelo b anterior
                    pegaPivot2 = tabela[i - 1][coluna - 1] / tabela[i - 1][colLn];
                    //Se a linha for a segunda(i=0)
                    //armazenará a divisão de b por ln em pivot e pegará essa linha
                    if (i == 2) {
                        pivot = pegaPivot2;
                        //Pegará a linha anterior(linha das operações)
                        linePivot = i - 1;
                    } //Verifica o menor numero positivo e pega a linh
                    else if (pegaPivot2 > 0 && pegaPivot2 < pivot) {
                        pivot = pegaPivot2;
                        linePivot = i - 1;
                    }
                }

            }
        }

        //Pegando a ultima linha
        pegaPivot2 = tabela[linha - 1][coluna - 1] / tabela[linha - 1][colLn];

        if (pegaPivot2 > 0 && pegaPivot2 < pivot) {
            pivot = pegaPivot2;
            linePivot = linha - 1;

        }

        newLinePivot(table, linePivot, tabela[linePivot][colLn], coluna, linha, colLn);
        tabela = null;
        return;
    }

}
