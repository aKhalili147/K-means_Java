package kmeans;

import java.util.ArrayList;

public class Kmeans {
  private int k; // number of clusters
  private ArrayList<Point>   allPoints;
  private ArrayList<Cluster> clusters;
  
  /**
   * Parameter: nbAttributes (assumes that the first 4 attributes are float)
   */
  public Kmeans(String filename, String separator, int k, int nbAttributes) {
    this.k = k;
    this.allPoints = new ArrayList<Point>();
    this.clusters  = new ArrayList<Cluster>();
    
    ArrayList<ArrayList<String>> data = Util.importCSV(filename, separator);
    for (ArrayList<String> instance : data) {
      if (instance.get(0).isEmpty()) continue; // skip iteration if empty line
      float[] attributes = new float[nbAttributes];
      for (int i = 0; i < nbAttributes; i++) attributes[i] = Float.parseFloat(instance.get(i));
      this.allPoints.add(new Point(attributes));
    }
  }

  /* =================== Question 1 ===================
   * Initialize each cluster by picking random points in allPoints
   */
  public void initClusters(){
    int indexPoint = 0;
    /*
     * For each partition k do
     *   create new cluster c
     *   choose a random point index in [0;150[  (i = (int) (Math.random()*(this.allPoints.size())))
     *   get point i in the set of points and assign to new point p
     *   assign p as the center of c
     *   add c to the collection of clusters
     * end
     *   
     */
    for(int j=0;j<this.k;j++) {
    	Cluster c = new Cluster();
    	indexPoint = (int) (Math.random()*(this.allPoints.size()));
    	Point p = this.allPoints.get(indexPoint);
    	c.setCenter(p);
    	c.setIndex(indexPoint);
    	this.clusters.add(c);
    }
    
  }
  
  /* =================== Question 2 ===================
   * Find the nearest cluster to a point p
   * Returns the index of the nearest cluster
   */
  private int findNearestCluster(Point p){
    int   target_cluster = -1;
    float dMin = Float.MAX_VALUE;
    /*
     * for each cluster c in clusters do
     *   d = distance between p and the center of c
     *   if d < dMin : dMin is now d and the target cluster is c
     * end
     */
    for(Cluster c: this.clusters) {
    	double d = p.distanceTo(c.getCenter());
    	if(d<dMin) {
    		dMin = (float)d;
    		target_cluster = c.getIndex();
    	}
    }
    // TODO
    
    if (target_cluster == -1 ) throw new RuntimeException("Target cluster index is negative");
    return target_cluster;
  }

  /* =================== Question 4 ===================
   * Single kmeans step:
   * 1/ reset all clusters
   * 2/ find to which cluster each point of allPoints belongs
   * 3/ compute the new centroid for each cluster
   */
  public void kmeansStep(){
    /*
     * For each cluster c do
     *   reset all points in c (find the appropriate method in Cluster.java 
     * end
     * 
     * For each point p in the dataset do
     *   find the nearest cluster c to p
     *   add the point p to c
     * end
     * 
     * For each cluster c do
     *   compute the centroid point of c
     * end
     */
    
    // TODO
  }
  
  
  
  public void printClusters(){ for (Cluster c: clusters) System.out.println(c);  }
  
  public int getK() { return this.k; }
  public Cluster getCluster(int index){return this.clusters.get(index); }
  
  public String toString() {
    String s = "";
    for (Cluster c: this.clusters)
      s += c.exportToString();
    return s;
  }
}
