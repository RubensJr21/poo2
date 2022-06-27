
/*
     Copia arquivos de uma pasta para outra pasta
 */
import java.io.*;

/**
 *
 * @author felipe
 */
public class MoveFileWithThreadMain {

    private static File listaFiles[] = null;

    public static void main(String args[]) throws IOException, InterruptedException {
        listaFiles = MoveFile.getSingleTonListaFiles(); //le arquivos do diretorio e coloca na listaFiles                
        
        Runnable r1 = new MoveFileWithThread(listaFiles);
        Runnable r2 = new MoveFileWithThread(listaFiles);
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        t1.start();
        t2.start();
    }
    
    public synchronized static File[] getSingleTonListaFiles() throws IOException
    {        
        if(listaFiles == null){
            String current = new java.io.File(".").getCanonicalPath();
            File file = new File(current + "\\src\\origem");
            listaFiles = file.listFiles();                      
        }
        return listaFiles;        
    }
}
