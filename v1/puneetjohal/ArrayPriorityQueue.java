//Puneet Johal
//APCS2 pd2
//HW46 -- Arrr, There Be Priorities Here Matey
//2018-05-10

import java.util.ArrayList;

public class ArrayPriorityQueue {

  //instance variables
  private ArrayList<String> q;

  //constructor
  public ArrayPriorityQueue(){
    q = new ArrayList<String>();
  }

  //enque
  public void add (String s){
    q.add(s);
  }

  //deque
  public String removeMin(){
    int min = 0;
    for (int i = 1; i < q.size(); i++){
      if ( q.get(min).compareTo(q.get(i)) > 0) {
        min = i;
      }
    }
    return q.remove(min);
  }

  //peek
  public String peekMin(){
    int min = 0;
    for (int i = 1; i < q.size(); i++){
      if ( q.get(min).compareTo(q.get(i)) > 0) {
        min = i;
      }
    }
    return q.get(min);
  }

  //isEmpty
  public boolean isEmpty(){
    return q.size() == 0;
  }

  //main
  public static void main (String[] args) {
    ArrayPriorityQueue ghita = new ArrayPriorityQueue();
    ghita.add("foo");
    ghita.add("moo");
    ghita.add("goo");
    ghita.add("who");

    while (!ghita.isEmpty()){
      System.out.println(ghita.peekMin());
      System.out.println(ghita.removeMin());
    }
  }

}
