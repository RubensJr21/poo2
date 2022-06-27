/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateexemplo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Rubens Jr
 */
public class ExportWord extends ExportFiles{
    
    private XWPFDocument document = null;
    private FileOutputStream out = null;
    
    public ExportWord(){
        String current;
        try {
            current = new java.io.File(".").getCanonicalPath();
            this.out = new FileOutputStream(new File(current + "\\src\\" + "word.docx"));
            this.document = new XWPFDocument();
            //Blank Document
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printLineWord(String linha) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(linha);
    }
    
    protected void saveWord() {
        try {
            this.document.write(this.out);
            this.out.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void export(String txt) {
        String[] txtLinhas = txt.split("\n");
        for(Object linhas : txtLinhas ){
            printLineWord((String)linhas);
        }   
        saveWord();
    }
}