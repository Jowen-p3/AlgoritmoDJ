import java.util.ArrayList;
import java.util.Arrays;


public class dijsktra {
    public static void main(String[] args) {
        project01.Graph graph = new project01.Graph(5);
        graph.addVertax("A");
        graph.addVertax("B");
        graph.addVertax("C");
        graph.addVertax("D");
        graph.addVertax("E");


        graph.addEdges(0,1,10);
        graph.addEdges(0,2,2);
        graph.addEdges(2,1,1);
        graph.addEdges(2,4,7);
        graph.addEdges(1,4,1);
        graph.addEdges(4,3,3);

        showEdges();
        graph.dijkStra(0);



    }
    
    private int numberOfEdges;
    private double[] distance;
    private String[] path;
    private ArrayList<String> Vertax;
    private static int[][] edges;
    private boolean[] isVisited;
    public  Graph(int n){
        this.n = n;
        numberOfEdges=0;
        Vertax = new ArrayList<>(n);
        edges  = new int[n][n];
        isVisited = new boolean[n+1];
        distance = new double[n];
        for (int i = 0; i <n ; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }

        path = new String[n];
        for (int i = 0; i <n ; i++) {
            path[i] = "";
        }
    }

   
    public static void showEdges(){
        for (int[] edse: edges
        ) {
            System.out.println(Arrays.toString(edse));
        }

    }
    
    public  int GetSizeOfGraph(ArrayList<String> Vertax){
        return Vertax.size();
    }
   
    public  void addVertax(String s){
        Vertax.add(s);
    }
   
    public int getFirstCO(int index){
        for (int i = 0; i <Vertax.size() ; i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
   
    public int getNextCO(int index,int firstCO){
        for (int i =firstCO+1 ; i <Vertax.size() ; i++) {
            if (edges[index][i]>0) return i;
        }
        return n;
    }
    
    public  void addEdges(int e1,int e2 , int weight){
        edges[e1][e2] = weight;
        //edges[e2][e1] = weight;
        numberOfEdges++;
    }
    
    public int getNumberOfEdges(){
        return numberOfEdges;
    }

    public void dijkStra(int index ){

        int CO;
        int headIndex = index;
        distance[index]=0;

        while (!isVisited[headIndex]){

           
            CO = getFirstCO(headIndex);
            while(isVisited[CO]){
                CO = getNextCO(headIndex,CO);
            }

            
            if (CO==n) {
                isVisited[headIndex]=true;

            }
            
            else {
                while (!isVisited[CO]&&CO<n) {
                    isVisited[headIndex]=true;
                    double currentDis = distance[headIndex]+edges[headIndex][CO];
                    if (currentDis<distance[CO]) {
                        distance[CO] = currentDis;

                        path[CO] = path[headIndex]+" "+Vertax.get(headIndex);
                    }

                    CO = getNextCO(headIndex, CO);

                }
            }

            headIndex = indexGet(distance,isVisited);


        }
        for (int i = 0; i <n ; i++) {
            path[i] = path[i]+" "+Vertax.get(i);
        }
        System.out.println("Iniciar nodo:"+Vertax.get(index));
        for (int i = 0; i <n ; i++) {
            System.out.println(Vertax.get(i)+"   "+distance[i]+"   "+path[i]);
        }


    }
    
    public int indexGet(double[] distance, boolean[] isVisited){
        int j=0;
        double mindis=Double.POSITIVE_INFINITY;
        for (int i = 0; i < distance.length; i++) {
            if (!isVisited[i]){
                if(distance[i]<mindis){
                    mindis=distance[i];
                    j=i;
                }
            }
        }
        return j;
    }
}