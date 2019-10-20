package kmeans;

public class TestKMeans {

  public static void main(String[] args) {
    Kmeans classifier = new Kmeans("/home/efi/eclipse-workspace/Kmeans/src/kmeans/iris_text.data",
        ",", /* separator */
        3,   /* k */
        4  /* nb attributes */);
    
    System.out.println("*** Initial clusters");
    classifier.initClusters();
    classifier.printClusters();
    
    for(int i = 0; i < 1000; i++) classifier.kmeansStep();
    
    System.out.println("\n*** Final clusters");
    classifier.printClusters();
    
    Util.exportDataToCSV("clusters.data", classifier.toString());
  }

}
