
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rubens Jr
 */
public class MoveFileWithThread implements Runnable{
    
    File []listaFiles;
    
    private static int index = 0;
    
    public MoveFileWithThread(File []listaFiles){
        this.listaFiles = listaFiles;
    }
    public static void copyFile(File sourceFile, File destFile) throws IOException {

        if (!sourceFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source;
        FileChannel destination;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
    }
    
    private static synchronized int getIndex(){
        return MoveFileWithThread.index++;
    }
    
    @Override
    public void run() {
        final long startTime = System.currentTimeMillis();// tempo incial
        System.out.println("Iniciando copiar de arquivos");
        for(int i = MoveFileWithThread.getIndex(); i < this.listaFiles.length; i = MoveFileWithThread.getIndex()) {
            System.out.println("i = " + i);
            File origem = new File(this.listaFiles[i].getAbsolutePath());
            String destinationFile = this.listaFiles[i].getAbsolutePath();
            destinationFile = destinationFile.replace("origem", "destino");
            try {
                copyFile(origem, new File(destinationFile));
            } catch (IOException ex) {
                Logger.getLogger(MoveFileWithThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        final long elapsedTimeMillis = System.currentTimeMillis() - startTime; //tempo total de execução do programa
        System.out.println("Time:" + elapsedTimeMillis);
    }
}
