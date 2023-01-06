import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalpoints = 0;
        for (Point point : s.getPoints()) {
            totalpoints = totalpoints + 1;
        }
        return totalpoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int numpoints = getNumPoints(s);
        double perimeter = getPerimeter(s);
        double avelength = perimeter/numpoints;
        return avelength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest_side = 0.0;
        Point prevPt = s.getLastPoint();
        double curr_len;
        for (Point point : s.getPoints()) {
            curr_len = prevPt.distance(point);
            prevPt = point;
            if (curr_len > largest_side) {
                largest_side = curr_len;
            }
        }
        return largest_side;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestx = 0.0;
        for (Point curr_pt : s.getPoints()) {
            if(largestx < curr_pt.getX()) {
                largestx = curr_pt.getX();
            }
        }
        return largestx;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largest_perimeter = 0.0;
        FileResource fr;
        Shape curr_shape;
        for (File f : dr.selectedFiles()) {
            fr = new FileResource(f);
            curr_shape = new Shape(fr);
            if (largest_perimeter < getPerimeter(curr_shape)) {
                largest_perimeter = getPerimeter(curr_shape);
            }
        }
        return largest_perimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largest_perimeter = 0.0;
        FileResource fr;
        Shape curr_shape;
        File temp = null; 
        for (File f : dr.selectedFiles()) {
            fr = new FileResource(f);
            curr_shape = new Shape(fr);
            if (largest_perimeter < getPerimeter(curr_shape)) {
                largest_perimeter = getPerimeter(curr_shape);
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numberofpoints = getNumPoints(s);
        System.out.println("number of points = " + numberofpoints);
        double ave = getAverageLength(s);
        System.out.println("average = " + ave);
        double largest_side = getLargestSide(s);
        System.out.println("Largest side = " + largest_side);
        double largestx = getLargestX(s);
        System.out.println("Largest x = " + largestx);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double x = getLargestPerimeterMultipleFiles();
        System.out.println("Multiple file perimeter: "+x);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String x = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter: "+x);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
