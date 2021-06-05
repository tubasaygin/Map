public class Graph {
    private int numOfNodes;
    private boolean directed;
    private boolean weighted;
    public float matrix[][];
    private boolean isSetMatrix[][];

    public Graph(int numOfNodes,boolean directed,boolean weighted){
        this.numOfNodes=numOfNodes;
        this.directed=directed;
        this.weighted=weighted;

        matrix=new float[numOfNodes][numOfNodes];
        isSetMatrix=new boolean[numOfNodes][numOfNodes];
    }

    public void addEdge(int source, int destination, float weight){
        float valueToAdd = weight;

        if(!weighted){
            valueToAdd = 1;
        }
        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if(!directed){
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }

    }

    public void printMatrix(){
        System.out.println("\n\nKomşuluk matrisi: \n\n");
        for (int i = 0; i < numOfNodes ; i++) {
            for (int j = 0; j < numOfNodes ; j++) {
                if(isSetMatrix[i][j]){
                    System.out.format("%8s", String.valueOf(matrix[i][j]));
                }
                else
                    System.out.format("%8s", "|  ");
            }
            System.out.println();
        }

    }

    public void printEdges(){
        System.out.println("\n\n Şehirlerin komşuları : \n\n");
        for (int i = 0; i < numOfNodes ; i++) {
            System.out.print((i+1)+ " plakalı sehrin komsu il plakaları: ");
            for (int j = 0; j < numOfNodes ; j++) {
                if(isSetMatrix[i][j]){
                    System.out.print((j + 1)+" ");
                }
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination){
        return isSetMatrix[source][destination];
    }

    public Float getEdgeValue(int source, int destination){
        if(!weighted || !isSetMatrix[source][destination])
            return null;
        return matrix[source][destination];
    }



}


