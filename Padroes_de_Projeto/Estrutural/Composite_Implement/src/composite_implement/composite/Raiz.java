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
public abstract class Raiz {
    protected String name;
    
    protected void println(String str){
        System.out.println(str);
    }
    
    protected void printNomeDaRaiz(){
        println(this.name);
    }
    protected void printNomeDaRaiz(String complemento){
        println(this.name + ": " + complemento);
    }
}
