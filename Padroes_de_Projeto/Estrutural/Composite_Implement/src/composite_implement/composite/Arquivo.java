/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite_implement.composite;

/**
 *
 * @author 20191BSI0379
 */
public class Arquivo extends Raiz{
    
    public Arquivo(String name){
        this.name = name;
    }
    
    public void printNomeArquivo(){
       this.printNomeDaRaiz();
    }
}
