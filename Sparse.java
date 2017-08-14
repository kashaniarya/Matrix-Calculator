import java.util.Scanner;
import java.io.*;

public class Sparse {
  
  public static void main(String args[]) throws FileNotFoundException, java.io.IOException {
    if(args.length != 2) {
      System.err.println("EXIT 1");
      System.exit(1);
    }
    Scanner in = new Scanner(new File(args[0]));
    PrintWriter out = new PrintWriter(new FileWriter(args[1]));
    
    Matrix A = new Matrix(0);
    Matrix B = new Matrix(0);
    while(in.hasNextInt()) {
      int n = in.nextInt();
      A = new Matrix(n);
      B = new Matrix(n);
      int aRows = in.nextInt();
      int bRows = in.nextInt();
      
      for(int z=1; z <= aRows; z++) {
        int i = in.nextInt();
        int j = in.nextInt();
        double x = in.nextDouble();
        A.changeEntry(i,j,x);
      }
      for(int y=1; y <= bRows; y++) {
        int i = in.nextInt();
        int j = in.nextInt();
        double x = in.nextDouble();
        B.changeEntry(i,j,x);
      }
    }
    out.println("A has "+A.getNNZ()+" non-zero entries:");
    out.println(A);
    
    out.println("B has "+B.getNNZ()+" non-zero entries:");
    out.println(B);
    
    out.println("(1.5)*A =");
    out.println(A.scalarMult(1.5));
    
    out.println("A+B =");
    out.println(A.add(B));
    
    out.println("A+A =");
    out.println(A.add(A));
    
    out.println("B-A =");
    out.println(B.sub(A));
    
    out.println("A-A =");
    out.println(A.sub(A));
    
    out.println("Transpose(A) =");
    out.println(A.transpose());
    
    out.println("A*B =");
    out.println(A.mult(B));
    
    out.println("B*B =");
    out.println(B.mult(B));
    
    
    in.close();
    out.close();
  }
  
}