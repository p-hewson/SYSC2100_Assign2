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

    for(int x = 0; x < index; x++){
      ptr = ptr.getNext();
      prev = prev.getNext();
    }
    node.setNext(ptr);
    prev.setNext(node);
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
