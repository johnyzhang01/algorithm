package week01;

public class ZhLinkedList {

  private static class Node {

    Object item;
    Node next;
    Node prev;

    public Node(Object item, Node next, Node prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }

  Node node(int index) {
    Node x = first;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  transient int size = 0;

  transient Node first;
  transient Node last;

  void linkFirst(Object item) {
    final Node f = first;
    final Node newNode = new Node(item, f, null);
    first = newNode;
    if (f == null) {
      last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }

  void linkLast(Object item) {
    final Node l = last;
    final Node newNode = new Node(item, null, l);
    last = newNode;
    if (l == null) {
      first = newNode;
    } else {
      l.next = newNode;
    }
    size++;
  }

  void linkBefore(Object item, Node succ) {
    final Node pred = succ.prev;
    final Node newNode = new Node(item, succ, pred);
    succ.prev = newNode;
    if (pred == null) {
      first = newNode;
    } else {
      pred.next = newNode;
    }
    size++;
  }

  Object unlink(Node x){
    Object item = x.item;
    Node prev = x.prev;
    Node next = x.next;

    if(prev == null){
      first = x.next;
    }else{
      prev.next = next;
      x.prev = null;
    }

    if(next == null){
      last = x.prev;
    }else{
      next.prev = prev;
      x.next = null;
    }

    x.item = null;
    size--;
    return item;
  }


  public ZhLinkedList() {

  }

  public void add(Object item) {
    linkLast(item);
  }

  public void add(Object item, int index) {

    if(!isElementIndex(index)){
      return;
    }

    if (index == size){
      linkLast(item);
    }else{
      linkBefore(item, node(index));
    }

  }

  public void remove(int index) {

    if(isElementIndex(index)){
      unlink(node(index));
    }
  }


  public Object get(int index) {
    return node(index).item;
  }

  private boolean isElementIndex(int index) {
    return index >= 0 && index < size;
  }

  public static void main(String args[]) {
    ZhLinkedList zl = new ZhLinkedList();

    System.out.println(zl.size);

    ZhLinkedList zl1 = new ZhLinkedList();
    zl1.add(1);
    System.out.println(zl1.size);
    zl1.remove(0);
    System.out.println(zl1.size);


    ZhLinkedList zl2 = new ZhLinkedList();
    zl2.add("0");
    zl2.add("1");
    zl2.add("2");
    zl2.add("3");
    for(int i=0;i<zl2.size;i++){
      System.out.println(zl2.get(i));
    }
    zl2.add("-1",1);
    for(int i=0;i<zl2.size;i++){
      System.out.println(zl2.get(i));
    }
  }



}


