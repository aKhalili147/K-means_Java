package kmeans;

import java.util.ArrayList;

public class Cluster {
  private ArrayList<Point> points;
  private Point center;
  private int   index;
  
  public Cluster(){
    this.points = new ArrayList<Point>();
  }
  
  public double distanceTo(Point p){
    return this.center.distanceTo(p);
  }
  
  // Setters
  public void setCenter(Point c){ this.center = c; }
  public void setIndex(int i)   { this.index = i; }
  
  // Getters
  public Point getCenter() { return this.center; }
  public int   getIndex()  { return this.index; }
  
  public void resetPoints(){ this.points = new ArrayList<Point>(); }
  public void addPoint(Point p) {this.points.add(p); }
  
  /* =================== Question 3 ===================
   * Compute the centroid (average point) of the cluster
   */
  public void updateCenter() {
    if (this.points.size() == 0) {
      this.center = new Point(this.center.getDimension());
      return;
    }
    
    int nbPoints = this.points.size();
    Point pAccu  = new Point(this.points.get(0).getDimension());
    
    /*
     * 1. Accumulate the components of all points in the cluster
     * for each p in the set of points do
     *   add p to pAccu
     * end
     * 
     * 2. Now average each component
     * for each dimension i of pAccu do
     *   attribute i <- attribute i / nbPoints
     * end
     */
    
    // TODO
    
    this.center = pAccu;
  }
  
  
  public String toString(){
    String s = "";
    s = "=> Cluster "+this.index+" -- Center: "+ this.center +"   Nb points: "+this.points.size();
    return s;
  }
  
  /**
   * Format output for CSV (with space separator)
   */
  public String exportToString() {
    String s = "";
    for (Point p: this.points)
      s += p.toString() + " " + this.index + "\n";
    return s;
  }
}
