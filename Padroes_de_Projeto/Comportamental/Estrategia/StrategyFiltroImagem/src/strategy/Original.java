/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.image.BufferedImageOp;

/**
 *
 * @author Rubens Jr
 */
public class Original extends Strategy {
    public Original(SaveImage si){
        this.si = si;
    }
    @Override
    public BufferedImageOp filter() {
        si.setBiFiltered(si.getBi());
        return null;
    }
}
