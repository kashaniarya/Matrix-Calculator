public class MatrixTest {
  public static void main(String[] args) {
    
//    Matrix M = new Matrix(3);
//    Matrix x = new Matrix(3);
//    Matrix y = new Matrix(3);
////    System.out.println(M.getSize());
////    System.out.println(M.getNNZ());
////    System.out.println(M.equals(x));
////    
//    
//   M.changeEntry(1,1,1);
//  M.changeEntry(1,2,2);
//   M.changeEntry(1,1,5);
//  M.changeEntry(1,1,0);
//   M.changeEntry(1,3,5);
//   M.changeEntry(1,3,10);
//   M.changeEntry(1,2,20);
//   M.changeEntry(1,3,3);
//    M.changeEntry(1,2,2);
//    M.changeEntry(2,3,4);
////    x = M.copy(); 
////    M.makeZero();
////    x.makeZero();
//    x = M.scalarMult(2);
//    //x.changeEntry(1,1,11); 
//    
////    System.out.println(M.getSize());
////    System.out.println(M.getNNZ());
////    System.out.println(M.equals(x)); 
////    
//    
//    
//    //y = M.sub(x);
//    
//    M.changeEntry(1,1,1);
//    M.changeEntry(1,2,2);
//    M.changeEntry(1,3,3);
//    
//    M.changeEntry(2,3,0);
//    M.changeEntry(2,3,1);
////    x = M.copy();
////    M.makeZero();
////    x.makeZero();
//    M.changeEntry(3,1,1);
//    M.changeEntry(3,2,2);
//    M.changeEntry(3,3,3);
//    x.changeEntry(3,1,1);
//    x.changeEntry(3,2,2);
//    x.changeEntry(3,3,3);
//    
//    
//    
//    //x = M.copy();
//    System.out.println(M);
////    M.changeEntry(1,1,0);
////    M.changeEntry(1,1,0);
//    //System.out.println(M);
//    System.out.println(x.transpose());
//    
//    
//    //y = M.transpose();
//    //double dd = M.mult(x);
//    y = M.mult(x);
//    //double q= M.mult(x);
//    System.out.println(y);
    
    
    int i, j, n=3;
      Matrix A = new Matrix(n);
      Matrix B = new Matrix(n);
//      
//
//      A.changeEntry(1,1,1); B.changeEntry(1,1,1);
//      A.changeEntry(1,2,2); B.changeEntry(1,2,0);
//      A.changeEntry(1,3,3); B.changeEntry(1,3,1);
//      A.changeEntry(2,1,4); B.changeEntry(2,1,0);
//      A.changeEntry(2,2,5); B.changeEntry(2,2,1);
//      A.changeEntry(2,3,6); B.changeEntry(2,3,0);
//      A.changeEntry(3,1,7); B.changeEntry(3,1,1);
//      A.changeEntry(3,2,8); B.changeEntry(3,2,1);
//      A.changeEntry(3,3,9); B.changeEntry(3,3,1);
//    
////      System.out.println(A.getNNZ());
////      System.out.println(B.getNNZ());
////
//      
//      System.out.println(B);
//      System.out.println(B.transpose());
//    Matrix G = B.mult(B);
//      System.out.println(G.getNNZ());
//      System.out.println(G);
    
    
      A.changeEntry(1,1,1);
      A.changeEntry(1,2,2);
      A.changeEntry(1,3,3);
      A.changeEntry(2,1,4);
      A.changeEntry(2,2,5);
      A.changeEntry(2,3,6);
      A.changeEntry(3,1,7);
      A.changeEntry(3,2,8);
      A.changeEntry(3,3,9);
      
      B.changeEntry(1,1,1);
      B.changeEntry(1,3,1);
      B.changeEntry(2,2,1);
      B.changeEntry(3,1,1);
      B.changeEntry(3,2,1);
      B.changeEntry(3,3,1);
      
      
      System.out.println(A);
      System.out.println(B);
      
      System.out.println(A.add(B));
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
    
    
  }
}