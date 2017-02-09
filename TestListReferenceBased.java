public class TestListReferenceBased{
  private Node head;
  public void main(String args[]){
  }

  public void Add(Node node, int data, int index){
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

  public boolean isEmpty(Node node){
    if(head == null) return true;
    else return false;
  }

  public int size(Node node){
    int count = 0;
    for(Node ptr = head; ptr != null; ptr = ptr.getNext()){
      count ++;
    }
    return count;
  }

  public void remove(int index){
    Node ptr = head;
    Node nxt = head.getNext().getNext();
    for(int x = 0; x < index; x++){    //x may need to equal 1.
      ptr = ptr.getNext();
      nxt = nxt.getNext();
    }
    ptr.setNext(nxt);
  }



  private class Node {
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
