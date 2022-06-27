
package templateexemplo;


public class TemplateMain {

   
    public static void main(String[] args) {
        String texto = "linha 1\n" 
                + "linha2\n"
                + "fim\n";                                
        ExportFiles exportHTML = new ExportHTML();
        ExportFiles exportWord = new ExportWord();
        exportHTML.export(texto);
        exportWord.export(texto);
    }
    
}
