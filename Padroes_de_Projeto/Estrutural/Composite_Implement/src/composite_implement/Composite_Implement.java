/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite_implement;

import composite_implement.composite.Arquivo;
import composite_implement.composite.Pasta;

/**
 *
 * @author 20191BSI0379
 */
public class Composite_Implement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pasta root = new Pasta("root");
        
        Arquivo file_1 = new Arquivo("text_1.txt");
        Arquivo file_2 = new Arquivo("text_2.txt");
        Arquivo file_3 = new Arquivo("text_3.txt");
        
        root.adicionarArquivo(file_1);
        root.adicionarArquivo(file_2);
        root.adicionarArquivo(file_3);
        
        Pasta pasta1 = new Pasta("pasta1");
        Arquivo file1 = new Arquivo("text1.txt");
        Arquivo file2 = new Arquivo("text2.txt");
        Arquivo file3 = new Arquivo("text3.txt");
        
        pasta1.adicionarArquivo(file1);
        pasta1.adicionarArquivo(file2);
        pasta1.adicionarArquivo(file3);
        
        Pasta pasta2 = new Pasta("pasta2");
        Arquivo file4 = new Arquivo("text4.txt");
        Arquivo file5 = new Arquivo("text5.txt");
        Arquivo file6 = new Arquivo("text6.txt");
        
        pasta2.adicionarArquivo(file4);
        pasta2.adicionarArquivo(file5);
        pasta2.adicionarArquivo(file6);
        
        Pasta pasta3 = new Pasta("pasta3");
        Arquivo file7 = new Arquivo("text7.txt");
        Arquivo file8 = new Arquivo("text8.txt");
        Arquivo file9 = new Arquivo("text9.txt");
        
        pasta3.adicionarArquivo(file7);
        pasta3.adicionarArquivo(file8);
        pasta3.adicionarArquivo(file9);
        
        
        root.adicionarPasta(pasta1);
        root.adicionarPasta(pasta2);
        root.adicionarPasta(pasta3);
        
        root.list();
        
    }
    
}
