/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateexemplo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rubens Jr
 */
public class ExportHTML extends ExportFiles{
    private BufferedWriter out = null;
    
    public ExportHTML(){
        String current;
        try {
            current = new java.io.File(".").getCanonicalPath();
            File file = new File(current + "\\src\\" + "index.html");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            this.out = new BufferedWriter(fw);
            this.out.write("<HTML><BODY>");
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printLineHTML(String linha) {
        try {
            this.out.write("<BR>" + linha);
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void saveHTML() {
        try {
            this.out.write("</BODY>");
            this.out.write("</HTML>");
            this.out.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void export(String txt) {
        String[] txtLinhas = txt.split("\n");
        for(Object linhas : txtLinhas ){
            printLineHTML((String)linhas);
        }   
        saveHTML();
    }
}
