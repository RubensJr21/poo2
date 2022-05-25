/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite_implement.composite;

import java.util.ArrayList;

/**
 *
 * @author 20191BSI0379
 */
public class Pasta extends Raiz{
    ArrayList<Raiz> files = new ArrayList();
    
    public Pasta(String name){
        this.name = name;
    }
    
    private void adicionarRaiz(Raiz raiz){
        this.files.add(raiz);
    }
    
    private void removerRaiz(int index){
        this.files.remove(index);
    }
    
    private Raiz getRaiz(int index){
        return this.files.get(index);
    }
    
    public void adicionarArquivo(Arquivo arquivo){
        this.adicionarRaiz(arquivo);
    }
    public void adicionarPasta(Pasta pasta){
        this.adicionarRaiz(pasta);
    }
    
    public void removerArquivo(int index){
        this.removerRaiz(index);
    }
    public void removerPasta(int index){
        this.removerRaiz(index);
    }
    
    public Raiz getArquivo(int index){
        return this.getRaiz(index);
    }
    public Raiz getPasta(int index){
        return this.getRaiz(index);
    }    
    
    public void list(){
        this.files.forEach((Raiz raiz) -> {
            if(raiz instanceof Pasta ){
                Pasta folder = (Pasta) raiz;
                folder.printNomePasta();
                folder.list();
            }else if(raiz instanceof Arquivo ){
                Arquivo file = (Arquivo) raiz;
                file.printNomeArquivo();
            }
        });
    }
    
    public void printNomePasta(){
       this.printNomeDaRaiz("pasta");
    }
}
