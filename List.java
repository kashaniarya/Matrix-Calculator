public class List {
 
  private class Node {
    Object data;
    Node next;
    Node prev;
    
    Node(Object d) {
      data = d;
      next = null;
      prev = null;
    }
    
    public String toString() {
      return String.valueOf(data); 
    }
  }
  
  private Node front;
  private Node back;
  private Node cursor;
  private int length;
  private int index;
  
  public List() {
    front = null;
    back = null;
    cursor = null;
    length = 0;
    index = -1;
  }
  
  public int length() {
    return length;
  }
  public int index() {
    return index;
  }
  //precondition: list is non-empty so length is greater than 0
  public Object front() throws RuntimeException {
    if( length() > 0) {
      return front.data;
    }
    else { 
      throw new RuntimeException("Error: List is empty.");
    }
  }
  //precondition: list is non-empty so length is greater than 0
  public Object back() throws RuntimeException {
    if( length() > 0) {
      return back.data;
    }
    else { 
      throw new RuntimeException("Error: List is empty.");
    }
  }
  
  
  //precondition: list is non-empty and cursor is defined
  //so length is greater than 0 and index is greater than or equal to 0
  public Object get() throws RuntimeException {
    if( length() > 0 && index() >= 0 ) {
      return cursor.data;
    }
    else { 
      throw new RuntimeException( "Error: Either list is empty or cursor is off list.");
    }
  }
  
  
  public boolean equals(Object L) {
    if( !(L instanceof List) ) {
      return false;
    }
    Node temp = null;
    Node Lcursor = null;
    if( ((List)L).length() == this.length() ) {
      temp = front;
      ((List)L).moveFront();
      Lcursor = ((List)L).cursor;
      for( int i=0; i< length() ; i++) {
        if(Lcursor.data != temp.data) {
          return false;
        }
        temp = temp.next;
        Lcursor = Lcursor.next;
      }
      return true;
    }
    return false;
  }
  public void clear() {
    front = null;
    back = null;
    cursor = null;
    length = 0;
    index = -1;
  }
  //precondition: list is non-empty so length is greater than 0
  public void moveFront() throws RuntimeException{
    if( length() > 0 ) {
      cursor = null;
      cursor = front;
      index = 0;
    }
    else {
      throw new RuntimeException("Error: List is empty.");
    }
  }
  //precondition: list is non-empty so length is greater than 0
  public void moveBack() throws RuntimeException {
    if( length() > 0 ) {
      cursor = null;
      cursor = back;
      index = length-1;
    }
    else {
      throw new RuntimeException("Error: List is empty.");
    }
  }
  public void movePrev() {
    if(index == -1) {}
    else if(index == 0) {
      cursor = null;
      index = -1;
    }
    else {
      cursor = cursor.prev;
      index--;
    }
  }
  public void moveNext() {
    if(index == -1) {}
    else if(index == length-1) {
      cursor = null;
      index = -1;
    }
    else {
      cursor = cursor.next;
      index++;
    }
  }
  public void prepend(Object data) {
    Node n = new Node(data);
    if(length == 0) {
      front = n;
      back = n;
      front.next = null;
      front.prev = null;
    }
    else {
      Node temp = front;
      n.next = temp;
      temp.prev = n;
      front = n;
      n.prev = null;
      if ( index() >= 0 ) {
        index++;
      }
    }
    length++;
  }
  public void append(Object data) {
    Node n = new Node(data);
    if(length == 0) {
      front = n;
      back = n;
      front.next = null;
      front.prev = null;
    }
    else {
      Node temp = back;
      n.prev = temp;
      temp.next = n;
      back = n;
      n.next = null;
    }
    length++;
  }
  //precondition: list is non-empty and cursor is defined
  //so length is greater than 0 and index is greater than or equal to 0
  public void insertBefore(Object data) throws RuntimeException{
    if(length() > 0 && index() >= 0 ) {
      Node n = new Node(data);
      if(cursor.prev != null) {
        Node temp = cursor.prev;
        temp.next = n;
        n.prev = temp;
        n.next = cursor; 
        cursor.prev = n;
      }
      else {
       Node temp = front;
        n.next = temp;
        temp.prev = n;
        front = n;
      }
      index++;
      length++;
    }
    else{
      throw new RuntimeException("Error: Either list is empty or cursor is off list.");
    }
  }
  //precondition: list is non-empty and cursor is defined
  //so length is greater than 0 and index is greater than or equal to 0
  public void insertAfter(Object data) throws RuntimeException{
    if(length() > 0 && index() >= 0 ) {
      Node n = new Node(data);
      if( cursor.next != null) {
        Node temp = cursor.next;
        n.next = temp;
        cursor.next = n;
        temp.prev = n;
        n.prev = cursor;
      }
      else {
        cursor.next = n;
        n.prev = cursor;
        n.next = null;
      }
      length++;
    }
    else {
      throw new RuntimeException("Error: Either list is empty or cursor is off list.");
    }
  }
  //precondition: list is non-empty so length is greater than 0
  public void deleteFront() throws RuntimeException {
    if(length()==1) {
      clear();
    }
    else if(length() > 0) {
      if(index()==0) {
        cursor = null;
        index = -1;
      }
      Node temp = front;
      front = front.next;
      front.prev = null;
      temp = null;
      length--;
    }
    else {
      throw new RuntimeException("Error: List is empty.");
    }
  }
  //precondition: list is non-empty so length is greater than 0
  public void deleteBack() throws RuntimeException{
    if(length()==1) {
      clear();
    }
    else if(length() > 0) {
      if(index()==length()-1) {
        cursor = null;
        index = -1;
      }
      Node temp = back;
      back = back.prev;
      back.next = null;
      temp = null;
      length--;
    }
    else {
      throw new RuntimeException("Error: List is empty.");
    }
  }
  //precondition: list is non-empty and cursor is defined
  //so length is greater than 0 and index is greater than or equal to 0
  public void delete() throws RuntimeException{
    if( length() > 0 && index() >= 0 ) {
      if(length() == 1) {
        clear();
      }
      else if( cursor.prev != null) {
        Node temp = cursor.prev;
        Node temp2 = cursor.next;
        Node deletedNode = cursor;
        temp.next = null;
        temp.next = temp2;
        deletedNode = null;
        cursor = null;
        index = -1;
        length--;
      }
      else {
        deleteFront();
      }
    }
    else {
      throw new RuntimeException("Error: Either list is empty or cursor is off list.");
    }
  }
  public String toString() {
    String s = "";
    Node n = front;
    while( n != null) {
      s += n.data;
      s+= " ";
      n = n.next;
    }
    return s;
  }
}






