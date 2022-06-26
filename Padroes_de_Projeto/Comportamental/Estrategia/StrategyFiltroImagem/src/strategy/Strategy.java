/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

/**
 *
 * @author Rubens Jr
 */
public abstract class Strategy {
    SaveImage si;
    public abstract BufferedImageOp filter();
}
