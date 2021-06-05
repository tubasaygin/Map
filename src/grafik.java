import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.io.DataOutput;

public class grafik extends JPanel {
    private int []sehirler;
    private int sehirSayisi;
    private int [][]koordinat;
    private int [][]sehritut;


    public grafik(int []sehirler, int sehirSayisi, int [][]koordinat){
        this.sehirler=sehirler;
        this.sehirSayisi=sehirSayisi;
        this.koordinat=koordinat;

    }

    public void paint(Graphics e){

        super.paint(e);
        for(int i=0;i<sehirSayisi-1;i++){

            for(int j=0;j<81;j++){

                if(sehirler[i]==j+1){
                    e.drawLine(koordinat[sehirler[i]-1][0],
                            koordinat[sehirler[i]-1][1],
                            koordinat[sehirler[i+1]-1][0],
                            koordinat[sehirler[i+1]-1][1] );

                }

            }
            e.drawLine(koordinat[sehirler[i+1]-1][0], koordinat[sehirler[i+1]-1][1], 221,122);

        }
    }
}



