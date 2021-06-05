import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GUI  {


    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label4;
    private JLabel label2;
    private JLabel label3;
    private JOptionPane optionpane;
    private JLabel label5;
    private JLabel label6;
    private JButton buton1;
    private JButton buton2;
    private JLabel label7;
    private int eklenenSehirS=1;


    private String[] dizi = new String[81];
    public  LinkedHashSet<String> eklenenSehirler = new LinkedHashSet<>();

    Graph graph2 = new Graph(81,false,true);

    public GUI() {

        Graph graph2 = new Graph(81,false,true);
        String[][] matris = new String[82][81];
        String [] okunacakDosya = new String [81];
        String [][] fotopiksel = new String[81][2];
        int [][] fotopiksel2 = new int[81][2];
        String [] okunacakDosya2 = new String[81];
        int [] eklenenSehirlerim = new int[10];

        int k=1;
        try{
            FileReader harita = new FileReader("HARİTAkoordinat.txt");
            try (BufferedReader harita2 = new BufferedReader(harita)) {
                String satirim = harita2.readLine();
                okunacakDosya2[0] =satirim;

                while(satirim!=null){

                    satirim=harita2.readLine();

                    if(satirim!=null){
                        okunacakDosya2[k]=satirim;
                        k++;
                    }

                }
                harita2.close();
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }

        int rr=0;
        int f=0;
        while(rr < 81) {
            String u = okunacakDosya2[f];
            StringTokenizer haritaA = new StringTokenizer(u,",");

            int a=0;
            while(a<2) {

                while (haritaA.hasMoreTokens()) {

                    try {
                        String st = haritaA.nextToken();
                        fotopiksel[rr][a] = st;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a++;

                }
            }

            rr++;
            f++;
        }

        for(int y=0;y<81;y++){
            for(int p=0;p<2;p++){
                fotopiksel2[y][p]=Integer.parseInt(fotopiksel[y][p]);
            }
        }
       /*
        for(int z=0;z<81;z++){
            for(int m=0;m<2;m++){
                System.out.println(fotopiksel2[z][m]);
            }
        }

        */


        int i = 1;
        try{
            FileReader fr = new FileReader("komsuuzaklik.txt");
            try (BufferedReader komsuuzaklik = new BufferedReader(fr)) {
                String satir = komsuuzaklik.readLine();
                okunacakDosya[0] = satir;

                while(satir!=null){
                    //   int b=1;
                    //System.out.println(satir);
                    satir=komsuuzaklik.readLine();

                    if(satir!=null){
                        okunacakDosya[i]=satir;
                        i++;
                    }

                }
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }

        int j=0;
        while(j < 81) {
            String s = okunacakDosya[j];
            StringTokenizer stringTokenizer = new StringTokenizer(s,", ");

            int a=0;
            while(stringTokenizer.hasMoreTokens() && a<82 ){

                try{
                    String st = stringTokenizer.nextToken();
                    matris[a][j]=st;
                    a++;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            j++;
        }
        System.out.println("Dosyanın okunması sonucu : \n\n");
        for(String s : okunacakDosya){
            System.out.println(s);
        }



        for (int l = 0; l < 81; l++) {
            for (int z = 0; z < 82; z++) {
                //System.out.print(matris[z][l]+" ");
                if(z != (l+1) ){
                    int b = Integer.parseInt(matris[z][l]);
                    if(b>0 && z>1){
                        graph2.addEdge(l, z-1 , b);

                    }
                }
            }
            //System.out.println();
        }
        graph2.printMatrix();
        graph2.printEdges();



        frame= new JFrame("HARİTA");

        panel =new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        ImageIcon Flag = new ImageIcon("harita.png");
        label3=new JLabel(Flag);

        ImageIcon plakalar= new ImageIcon("plaka.jpg");
        label5=new JLabel(plakalar);
        label5.setBounds(700,200,550,303);
        panel.add(label5);

        label1=new JLabel("Lütfen aşağıda bulunan şehirlerden eklemek istediğinizi seçip, ekle butonuna basın. ");
        label1.setForeground(Color.red);
        label1.setBounds(100, 50, 900, 50);
        panel.add(label1);

        label4=new JLabel("UYARI : Başlangıç noktası ve bitiş noktası Kocaeli olarak belirlenmiştir. Girmenize gerek yok!");
        label4.setForeground(Color.BLACK);
        label4.setBounds(100,100,900,50);
        panel.add(label4);




        buton1=new JButton("Şehri ekle");
        buton1.setBounds(200, 175, 100, 20);
        buton1.setForeground(Color.orange);
        panel.add(buton1);

        for(int t=0;t<81;t++){
            dizi[t]=""+(t+1);
        }
        JComboBox box =new JComboBox(dizi);
        panel.add(box);
        box.setBounds(100, 175, 100, 20);


        label2= new JLabel("Eklenen sehirler: ");
        label2.setBounds(100, 300, 400, 30);
        panel.add(label2);

        buton2=new JButton("Rota yap");
        buton2.setBounds(100, 400, 200, 50);
        buton2.setForeground(Color.blue);
        panel.add(buton2);

        buton1.addActionListener(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e) {


                if(eklenenSehirS>=0 && eklenenSehirS<11 && !eklenenSehirler.contains((String)box.getSelectedItem())){
                    eklenenSehirler.add((String)box.getSelectedItem());
                    label2.setText("Eklenen sehirler : "+ eklenenSehirler);
                    JOptionPane.showMessageDialog(null, (String)box.getSelectedItem()+" plakalı şehir basariyla eklendi.");
                    eklenenSehirlerim[0]=41;
                    eklenenSehirlerim[eklenenSehirS]=Integer.parseInt((String)box.getSelectedItem());
                    eklenenSehirS++;

                }


                else if(eklenenSehirler.contains((String)box.getSelectedItem())){
                    JOptionPane.showMessageDialog(null, "Bu şehir zaten eklendi");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Daha fazla şehir ekleyemezsiniz");
                }


            }
        });


        panel2=new JPanel();
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float [][]kısaYol = new float[82][81];
                kısaYol=graph2.matrix;
                EnKısaYol bul = new EnKısaYol();


                for(int c=0;c<eklenenSehirS-1;c++){
                    bul.dijkstra(kısaYol, eklenenSehirlerim[c]-1, eklenenSehirlerim[c+1]-1);

                }
                bul.dijkstra(kısaYol, eklenenSehirlerim[eklenenSehirS-1]-1, 40);
                int c= bul.getMesafem();
                Font font= new Font("Verdana", Font.BOLD, 20);




                grafik cizim = new grafik(eklenenSehirlerim, eklenenSehirS, fotopiksel2);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(cizim);
                panel2 =new JPanel();
                panel2.setLayout(null);
                frame.revalidate();
                frame.repaint();
                frame.add(panel2);
                JLabel label6 = new JLabel("Bulunan minimum mesafe = "+c);

                label6.setFont(font);
                label6.setForeground(Color.BLACK);
                label6.setBounds(100,500,500,100);
                label7=new JLabel();
                label7.setText("Girilen şehirler arasındaki uzaklığı tek tek görmek için terminal ekranına bakabilirsiniz.");
                label7.setForeground(Color.BLACK);
                label7.setBounds(100,550,600,100);
                label3.setBounds(0,0,1019,482);
                cizim.add(label3);
                cizim.add(label6);
                cizim.add(label7);
            }
        });
        frame.setSize(1400,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);




    }



}
