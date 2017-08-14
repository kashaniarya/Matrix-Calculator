public class Matrix{
  
  //private Entry class
  private class Entry {
    int column;
    double value;
    
    //Entry constructor
    Entry(int column, double value) {
      this.column = column;
      this.value = value;
    }
    //Entry toString()
    public String toString() {
      return "("+column+", "+value+")";
    }
    
    //Entry equals() method
    public boolean equals(Entry E) {
      if(E.column == this.column && E.value == this.value) {
        return true;
      }
      
      return false;
    }
  }
  
  //private instance variables
  private List[] Row;
  private int length;
  
  //Matrix constructor
  public Matrix(int n) {
    length = n;
    Row = new List[n];
    for(int i=0; i<n; i++) {
      Row[i] = new List();
    }
  }
  
  //Matrix getSize()
  public int getSize() {
    return length;
  }
  
  //Matrix get number of non-zero method
  public int getNNZ() {
    int nnz=0;
    for(int i=0; i < getSize(); i++) {
      if(Row[i].length()==0) {}
      else {
        nnz += Row[i].length();
      }
    }
    return nnz;
  }
  
  //Matrix equals method
  public boolean equals(Object x) {
    if(!(x instanceof Matrix)) {
      return false;
    }
    Matrix matrix2 = ((Matrix)x).copy();
    
    if(getSize() != matrix2.getSize() ) {
      return false;
    }
    for(int i=0; i < getSize(); i++) {
      if(Row[i].length() == 0 && matrix2.Row[i].length() == 0) {}
      else if(Row[i].length() != matrix2.Row[i].length()) {
        return false;
      }
      else {
        if(!((List)Row[i]).equals(((List)matrix2.Row[i]))) {
          return false;
        }
      }
    }
    return true;
  }
  
  //Matrix makeZero() method
  public void makeZero() {
    for(int i=0; i<getSize(); i++) {
      Row[i].clear();
    }
  }
  
  //Matrix copy() method
  public Matrix copy() {
    Matrix matrix2 = new Matrix(getSize());
    for(int i=0; i < getSize(); i++) {
      if(Row[i].length()==0) {}
      else {
        Row[i].moveFront();
        for(int j=1; j<=Row[i].length();j++) {
          matrix2.Row[i].append(((Entry)Row[i].get()));
          Row[i].moveNext();
        }
      }
    }
    return matrix2;
  }
  
  
  //pre: 1<=i<=getSize(), 1<=j<=getSize()
  public void changeEntry(int i, int j, double x) throws RuntimeException {
    if(1<=i && i<=getSize() && 1<=j && j<=getSize() ) {
      i = i-1;
      if(((List)Row[i]).length()==0 && x!=0) {
        Row[i].append(new Entry(j,x));
      }
      else if(((List)Row[i]).length()==0 && x==0) {}
      else {
        Row[i].moveFront();
        int z=1;
        while(z<j && Row[i].index()!=-1 && ((Entry)Row[i].get()).column < j) {
          Row[i].moveNext();
          z++;
        }
        if(x == 0 && z<=j && Row[i].index()!=-1 && ((Entry)Row[i].get()).column == j) {   
          Row[i].delete();
        }
        else if(x!=0 && z<=j && Row[i].index()!=-1 && ((Entry)Row[i].get()).column == j) {
          ((Entry)Row[i].get()).value = x;
        }
        else if(x!=0 && z<=j && Row[i].index()!=-1 && ((Entry)Row[i].get()).column > j) {
          Row[i].insertBefore(new Entry(j,x));
        }
        else if(x!=0 && Row[i].index()==-1) {
          Row[i].append(new Entry(j,x));
        }
        else {}
      }
    }
    else {
      throw new RuntimeException("Row or Column is less than 1 or too large.");
    }
  }
  
  //Matrix scalarMult() method
  public Matrix scalarMult(double x) {
    Matrix matrix2 = new Matrix(getSize());
    for(int i=0;i < getSize();i++) {
      if(((List)Row[i]).length() == 0) {}
      else {
        Row[i].moveFront();
        for(int j=1; j <= Row[i].length();j++) {
          double z = x*(((Entry)Row[i].get()).value);
          int c = ((Entry)Row[i].get()).column;
          matrix2.changeEntry(i+1,c,z);
          Row[i].moveNext();
        }
      }
    }
    return matrix2;
  }
  
  //Matrix toString()
  public String toString() {
    String s = "";
    if(getNNZ()!=0) {
      int nnz = getNNZ();
      for(int i=0; i < getSize(); i++) {
        if(nnz==0) {break;}
        
        if(((List)Row[i]).length() ==0 ) {}
        else {
          int a=i+1;
          s+=(a+":");
          Row[i].moveFront();
          for(int j=1;j <= Row[i].length();j++) {
            s+= (" "+(Entry)Row[i].get());
            nnz--;
            Row[i].moveNext();
          }
          s += "\n";
        }
      }
    }
    return s;
  }
  
  
  //pre: getSize()==M.getSize()
  public Matrix add(Matrix M) throws RuntimeException{
    if(getSize() != M.getSize()) {
      throw new RuntimeException("Matrix Error: Cannont Add on Matrices of unequal dimensions.");
    }
    else {
      Matrix matrix2 = M.copy(); 
      for(int i=0; i<getSize();i++) {
        if(matrix2.Row[i].length()==0 && Row[i].length() != 0) {
          Row[i].moveFront();
          for(int j=1; j<= Row[i].length();j++) {
            matrix2.Row[i].append(((Entry)Row[i].get()));
            Row[i].moveNext();
          }
        }
        else if(Row[i].length()==0 && matrix2.Row[i].length() != 0) {}
        else if(matrix2.Row[i].length()==0 && Row[i].length()==0) {}
        else {
          matrix2.Row[i] = matrix2.addHelper(Row[i],matrix2.Row[i]);
        }
      }
      return matrix2;
    }
  }
  
  
  //private helper function addHelper for Matrix add method
  private List addHelper(List P, List Q) {
    int size = 0;
    List retval = new List();
    if(P.length() >= Q.length()) {
      size = P.length();
    }
    else {
      size = Q.length();
    }
    P.moveBack();
    Q.moveBack();
    if(((Entry)P.get()).column > size) {
      size = ((Entry)P.get()).column;
    }
    if(((Entry)Q.get()).column > size) {
      size = ((Entry)Q.get()).column;
    }
    P.moveFront();
    Q.moveFront();
    int m1colref=0;
    int m2colref=0;
    
    for(int j=1; j <= size; j++) {
      
      if(P.index() != -1 && Q.index() != -1) {
        m1colref = ((Entry)P.get()).column;
        m2colref = ((Entry)Q.get()).column; 
      }
      else if(P.index() == -1 && Q.index() == -1) {
        m1colref = -1;
        m2colref = -1;
      }
      else if(P.index()==-1) {
        m1colref = 1+((Entry)Q.get()).column;
        m2colref = ((Entry)Q.get()).column; 
      }
      else if(Q.index()==-1) {
        m1colref = ((Entry)P.get()).column;
        m2colref = 1+((Entry)P.get()).column;
      }
      else {
        m1colref = -1;
        m2colref = -1;
      }
      
      if( m1colref != -1 && m2colref != -1) {
        if(m1colref==m2colref) {
          double xxx = ((Entry)P.get()).value + ((Entry)Q.get()).value;
          if(xxx!=0){
            ((List)retval).append((new Entry(m1colref,xxx)));
          }
          P.moveNext();
          Q.moveNext();
        }
        else if(m1colref > m2colref) {
          retval.append(new Entry(m2colref,((Entry)Q.get()).value));
          Q.moveNext();
        }
        else {
          retval.append(new Entry(m1colref,((Entry)P.get()).value));
          P.moveNext();
        }
      }
    }
    return retval;
  }
  
  
  //pre: getSize()==M.getSize()
  public Matrix sub(Matrix M) throws RuntimeException{
    if(getSize() != M.getSize() ) {
      throw new RuntimeException("Matrix Error: Cannont Subtract on Matrices of unequal dimensions.");
    }
    else {
      return this.add(M.scalarMult(-1));
    }
  }
  
  
  //Matrix transpose() method
  public Matrix transpose() {
    Matrix matrix2 = new Matrix(getSize());
    for(int i=0; i< getSize(); i++) {
      if(Row[i].length()!=0) {
        Row[i].moveFront();
        for(int j=1; j<= Row[i].length(); j++) {
          matrix2.changeEntry(((Entry)Row[i].get()).column, i+1, ((Entry)Row[i].get()).value);
          Row[i].moveNext();
        }
      }
    }
    return matrix2;
  }
  
  //private helper function dot product for Matrix Mult method
  private static double dot(List P, List Q) {
    int size = 0;
    int retval = 0;
    if(P.length() >= Q.length()) {
      size = P.length();
    }
    else {
      size = Q.length();
    }
    
    if(P.length() != 0 && Q.length() != 0) {
      P.moveBack();
      Q.moveBack();
      if(((Entry)P.get()).column > size) {
        size = ((Entry)P.get()).column;
      }
      if(((Entry)Q.get()).column > size) {
        size = ((Entry)Q.get()).column;
      }
      P.moveFront();
      Q.moveFront();
      int m1colref=0;
      int m2colref=0;
      
      for(int i=1; i <= size; i++) {
        if(P.index()!=-1 && Q.index()!=-1) {
          m1colref = ((Entry)P.get()).column;
          m2colref = ((Entry)Q.get()).column;
        }
        else if(P.index()==-1 && Q.index()==-1) {
          m1colref = -1;
          m2colref = -1;
        }
        else if(P.index() == -1) {
          m1colref = 1+((Entry)Q.get()).column; 
          m2colref = ((Entry)Q.get()).column; 
        }
        else if(Q.index() == -1) {
          m1colref = ((Entry)P.get()).column;
          m2colref = 1+((Entry)P.get()).column;
        }
        else {
          m1colref = -1;
          m2colref = -1;
        }
        
        if(m1colref != -1 && m2colref != -1) {
          if(m1colref==m2colref) {
            retval += ((Entry)P.get()).value * ((Entry)Q.get()).value;
            P.moveNext();
            Q.moveNext();
          }
          else if(m1colref > m2colref) {
            Q.moveNext();
          }
          else {
            P.moveNext();
          }
        }
      }
    }
    return retval;
  }
  
  
  // pre: getSize()==M.getSize()
  public Matrix mult(Matrix M) throws RuntimeException {
    if(getSize()==M.getSize()) {
      Matrix retmat = new Matrix(getSize());
      Matrix m2 = M.transpose();
      for(int i=0; i < getSize();i++) {
        if(Row[i].length()!=0 && m2.Row[i].length()!=0) {
          for(int j=0; j < getSize(); j++) {
            double xx = dot(Row[i],m2.Row[j]);
            retmat.changeEntry(i+1,j+1, xx);
          }
        }
      }
      return retmat;
    }
    else {
      throw new RuntimeException("Can only multiply on matrices of same dimension.");
    }
  }
  
  
  
  
  
  
  
}