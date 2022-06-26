/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

/**
 *
 * @author Rubens Jr
 */
public class Lookup extends Strategy {
    public Lookup(SaveImage si){
        this.si = si;
    }
    @Override
    public BufferedImageOp filter() {
        byte lut[] = new byte[256];
        for (int j=0; j<256; j++) {
            lut[j] = (byte)(256-j); 
        }
        ByteLookupTable blut = new ByteLookupTable(0, lut);
        
        BufferedImageOp op = new LookupOp(blut, null);
        
        BufferedImage bi = new BufferedImage(si.w, si.h, BufferedImage.TYPE_INT_RGB);
        si.setBiFiltered(bi);
        
        op.filter(si.getBi(), si.getBiFiltered());
        return op;
    }
}
