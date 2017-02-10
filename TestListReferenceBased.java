public class TestListReferenceBased{
  private static Node head = new Node(null);

/** Main class
* Initializes a linked list
*/
  public static void main(String[] args){
    Node node0 = new Node(12,null);
    Node node1 = new Node(3,null);
    Node node2 = new Node(25,null);
    Node node3 = new Node(18,null);
    Node node4 = new Node(13,null);
    Node node5 = new Node(17,null);
    remove(4);

    Add(node0,0);
    Add(node1,1);
    Add(node2,2);
    Add(node3,3);
    Add(node4,0);
    Add(node5,2);
    System.out.print(size(head));
    System.out.print(" Items in the linked list: ");
    for(Node ptr = head; ptr.getNext() != null; ptr = ptr.getNext()){
      if(ptr.getNext() == null){
        System.out.print(ptr.getData());
      }
      else{
        System.out.print(ptr.getData() + ", ");
      }
    }
  }

  public static void Add(Node node, int index){
    Node ptr = head.getNext();
    Node prev = head;
    if(index == 0){
      node.setNext(head);
      head = node;
    }
    else{
      for(int x = 0; x < index; x++){
        ptr = ptr.getNext();
        prev = prev.getNext();
      }
      node.setNext(ptr);
      prev.setNext(node);
    }
  }

  public static boolean isEmpty(Node node){
    if(head == null) return true;
    else return false;
  }

  public static int size(Node node){
    int count = 0;
    for(Node ptr = head; ptr.getNext() != null; ptr = ptr.getNext()){
      count ++;
    }
    return count;
  }

  public static void remove(int index){
    Node ptr = head;
    Node nxt = head.getNext();
    for(int x = 1; x < index; x++){
      ptr = ptr.getNext();
      nxt = nxt.getNext();
    }
    ptr.setNext(ptr.getNext().getNext());
    nxt.setNext(null);
  }

  public static int get(int index){
    Node ptr = head.getNext();
    for(int x = 0; x < index; x++){
      ptr = ptr.getNext();
    }
    return ptr.getData();
  }

  public static void removeAll(){
    for(Node ptr = head; ptr.getNext() != null; ptr = ptr.getNext()){
      remove(ptr.getData());
    }

  }



//******************************************
//******************************************
  private static class Node {
    private Node next;
    private int data;
    //private int count;

    //Constructor for Node
    public Node(int data, Node next){
      this.next = next;
      this.data = data;
    }

    //Constructor for Head Node
    public Node(Node next){
      this.next = next;
      //count = 0;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
      this.next = next;
    }

    public int getData(){
      return data;
    }

    public void setData(int data){
      this.data = data;
    }
  }
}
