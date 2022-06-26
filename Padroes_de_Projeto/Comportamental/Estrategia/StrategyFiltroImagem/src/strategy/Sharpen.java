/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 *
 * @author Rubens Jr
 */
public class Sharpen extends Strategy {
    public Sharpen(SaveImage si){
        this.si = si;
    }
    @Override
    public BufferedImageOp filter() {
        final float[] SHARPEN3x3 = { // sharpening filter kernel
            0.f, -1.f,  0.f,
           -1.f,  5.f, -1.f,
            0.f, -1.f,  0.f
        };

        BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, SHARPEN3x3),
                            ConvolveOp.EDGE_NO_OP,
                            null);
        
        BufferedImage bi = new BufferedImage(si.w, si.h, BufferedImage.TYPE_INT_RGB);
        si.setBiFiltered(bi);
        op.filter(si.getBi(), si.getBiFiltered());
        return op;
    }
    
}
