/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;


/**
 *
 * @author Rubens Jr
 */
public class Filtragem {
    private boolean filtered = false;
    private Strategy filterChose = null;
    
    public boolean isFiltered(){ return this.filtered ;}
    
    public void setFilter(Strategy fc){
        this.filtered = false;
        this.filterChose = fc;
    }
    
    public void filter(){
        this.filtered = true;
        this.filterChose.filter();
    }
}
