public class ListTest{
   public static void main(String[] args){
      List A = new List();
      List B = new List();
      for(int i=1; i<=20; i++){
         A.append(i);
         B.append(i);
      }
//      System.out.println(A.length());
//      System.out.println(A.index());
//      System.out.println(A.front());
//      System.out.println(A.back());
//      A.moveFront();
//      System.out.println(A.get());
//      A.moveNext();
//      System.out.println(A.get());
//      A.moveBack();
//      System.out.println(A.get());
//      A.movePrev();
//      System.out.println(A.get());
      //A.clear();
      //System.out.println(A.equals(B));
//      A.moveFront();
//      A.insertBefore(0);
//      A.insertAfter(0);
//      A.moveBack();
//      A.insertBefore(0);
//      A.insertAfter(0);
//      A.moveFront();
//      A.moveNext();
//      A.delete();
      
//      A.deleteFront();
//      A.deleteBack();
      System.out.println(A.equals(B));
      
      System.out.println(A);
      System.out.println(B);
   }
}