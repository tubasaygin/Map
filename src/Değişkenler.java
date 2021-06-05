


import javax.swing.*;

public class Değişkenler extends JPanel{
    private int  mesafeler=0;

    public Değişkenler() {


    }

    public int getMesafeler() {
        return mesafeler;
    }

    public void setMesafeler(int mesafeler) {
        this.mesafeler = mesafeler;
    }

    public void ekle(int mesafeler){
        this.mesafeler+=mesafeler;


    }

    public int bastir(){

        System.out.println("Gidilen toplam yol : "+ mesafeler);
        return mesafeler;
    }


}



