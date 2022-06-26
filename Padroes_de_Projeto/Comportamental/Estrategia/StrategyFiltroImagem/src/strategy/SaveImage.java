package strategy;

import java.io.*;
import java.util.TreeSet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
 
public class SaveImage extends Component implements ActionListener {
 
    String descs[];
 
    private BufferedImage bi, biFiltered;
    int w, h;
    private Filtragem filtragem = new Filtragem();
    
    public BufferedImage getBi(){ return bi; }
    public void setBi(BufferedImage bi){ this.bi = bi; }
    public BufferedImage getBiFiltered(){ return biFiltered; }
    public void setBiFiltered(BufferedImage bi){ this.biFiltered = bi; }
    
    public SaveImage() {
        this.filtragem.setFilter(new Original(this));
        this.descs = new String[]{"Original", "Convolve : LowPass", "Convolve : Sharpen", "LookupOp"};
        try {
            String current = new java.io.File(".").getCanonicalPath();                   
            
            bi = ImageIO.read(new File(current + "\\src\\" + "praia.jpeg"));            
            w = bi.getWidth(null);
            h = bi.getHeight(null);
            if (bi.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 =
                    new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics big = bi2.getGraphics();
                big.drawImage(bi, 0, 0, null);
                biFiltered = bi = bi2;
            }
        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }
 
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }
 
    String[] getDescriptions() {
        return descs;
    }
 
    @Override
    public void paint(Graphics g) {
        filterImage();
        g.drawImage(biFiltered, 0, 0, null);
    }
    
    public void filterImage() {
        if(!this.filtragem.isFiltered()){
            this.filtragem.filter();
        }
    }
 
    /* Return the formats sorted alphabetically and in lower case */
    public String[] getFormats() {
        String[] formats = ImageIO.getWriterFormatNames();
        TreeSet<String> formatSet = new TreeSet<>();
        for (String s : formats) {
            formatSet.add(s.toLowerCase());
        }
        return formatSet.toArray(new String[0]);
    }
 
    @Override
     public void actionPerformed(ActionEvent e) {
         JComboBox cb = (JComboBox)e.getSource();
         if (cb.getActionCommand().equals("SetFilter")) {
            switch (cb.getSelectedIndex()) {
                case 0:
                    this.filtragem.setFilter(new Original(this));
                    break;
                case 1:
                    this.filtragem.setFilter(new LowPass(this));
                    break;
                case 2:
                    this.filtragem.setFilter(new Sharpen(this));
                    break;
                case 3:
                    this.filtragem.setFilter(new Lookup(this));
                    break;
            }
            repaint();
         } else if (cb.getActionCommand().equals("Formats")) {
             /* Save the filtered image in the selected format.
              * The selected item will be the name of the format to use
              */
             String format = (String)cb.getSelectedItem();
             /* Use the format name to initialise the file suffix.
              * Format names typically correspond to suffixes
              */
             File saveFile = new File("savedimage."+format);
             JFileChooser chooser = new JFileChooser();
             chooser.setSelectedFile(saveFile);
             int rval = chooser.showSaveDialog(cb);
             if (rval == JFileChooser.APPROVE_OPTION) {
                 saveFile = chooser.getSelectedFile();
                 /* Write the filtered image in the selected format,
                  * to the file chosen by the user.
                  */
                 try {
                     ImageIO.write(biFiltered, format, saveFile);
                 } catch (IOException ex) {
                 }
             }
         }
    };
     
     public static void main(String s[]) {
        JFrame f = new JFrame("Save Image Sample");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        SaveImage si = new SaveImage();
        f.add("Center", si);
        JComboBox choices = new JComboBox(si.getDescriptions());
        choices.setActionCommand("SetFilter");
        choices.addActionListener(si);
        JComboBox formats = new JComboBox(si.getFormats());
        formats.setActionCommand("Formats");
        formats.addActionListener(si);
        JPanel panel = new JPanel();
        panel.add(choices);
        panel.add(new JLabel("Save As"));
        panel.add(formats);
        f.add("South", panel);
        f.pack();
        f.setVisible(true);
    }
}
