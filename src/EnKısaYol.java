


import org.w3c.dom.ls.LSOutput;

class EnKısaYol {

    static final int V = 81;
    private  int mesafem;


    int minMesafe(int mesafe[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && mesafe[v] <= min) {
                min = mesafe[v];
                min_index = v;
            }

        return min_index;
    }
    Değişkenler degisken = new Değişkenler();
    void printSolution(int mesafe[], int src, int nereye) {


        //  System.out.println("///////////");
        System.out.println("\n\n");
        System.out.println((src+1)+" ve "+(nereye + 1) + " Arasındaki mesafe:" + mesafe[nereye]);

        degisken.ekle(mesafe[nereye]);
        degisken.bastir();
        mesafem= degisken.getMesafeler();



/*
     for (int i = 0; i < V; i++)
           System.out.println((i+1)+ " Plaka koduna sahip şehir ile arasındaki en kısa mesafe  " + mesafe[i]);

*/
    }

    public int getMesafem() {
        return mesafem;
    }

    void dijkstra(float graph[][], int src, int gidilecekYer) /// src: başlangıç plakası
    {


        int mesafe[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            mesafe[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        mesafe[src] = 0;

        for (int count = 0; count < V ; count++) {

            int u = minMesafe(mesafe, sptSet);

            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0 &&
                        mesafe[u] != Integer.MAX_VALUE && mesafe[u] + graph[u][v] < mesafe[v]) {
                    mesafe[v] = (int) (mesafe[u] + graph[u][v]);
                    //  System.out.println("mesafe u:"+mesafe[u]);
                    // System.out.println("mesafe v:"+mesafe[v]);
                    //System.out.println(graph[u][v]);

                }

        }



        printSolution(mesafe, src, gidilecekYer);


    }


}
