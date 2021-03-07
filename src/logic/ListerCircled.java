package logic;

import java.util.ArrayList;
import java.util.Comparator;

public class ListerCircled<T> {
    private Comparator<T> comparator;
    private Node<T> head;

    public ListerCircled(Comparator<T> comparator) {
        this.comparator = comparator;
        head = null;
    }
    public boolean isEmpty(){
        return head==null;
    }

    public void addFirst(T info){
        Node<T> node = new Node<T>(info);
        if(isEmpty()){
            head= node;
            head.setNext(node);

        }else {
            node.setNext(head.getNext());
            head.setNext(node);
        }
    }
    public  void addLast(T info){
        Node<T> node = new  Node<T>(info);
        if(isEmpty()){
            head= node;
            head.setNext(node);

        }else {
            node.setNext(head.getNext());
            head.setNext(node);

            head= node;
        }
    }
    public ArrayList<T> getList(){
        Node<T> it = head;
        ArrayList<T> out= new ArrayList<T>();
        do {
            out.add(it.getNext().getInfo());
            it= it.getNext();
        }while (it != head);

        return out;
    }
    public Node<T> finNode(T info){
        Node<T> it = head;
        do{
            if(comparator.compare(info,it.getInfo())==0){
                return it;
            }
            it=it.getNext();
        }while (it != head);
        return null;
    }
    public T deleteNode (Node<T> node){
        T out = node.getInfo();
        if(node == head){
            head=head.getNext();
        }else {
            Node<T> aux = head;
            while (aux.getNext() != node){
                aux = aux.getNext();
            }
            aux.setNext(node.getNext());
        }
        return out;
    }
    public  void addSorted(T info){
        Node<T> node = new Node<T>(info);
        if(isEmpty()){
            head= node;
            node.setNext(node);
        }else {
            Node<T> aux = head;
            if(comparator.compare(info,head.getNext().getInfo())<0){
                addFirst(info);
            }else if(comparator.compare(info,head.getInfo())>0){
                addLast(info);
            }else {
                Node<T> act = head;
                do{

                }while (comparator.compare(info,act.getInfo())>0);
                act = act.getNext();
            }
        }
    }
    public ArrayList<T> runnerList(Node<T> node){
        ArrayList<T> out = new ArrayList<T>();
        Node<T> it= node;
        do{
            out.add(it.getInfo());
            it=it.getNext();
        }while (it != node);
        return  out;
    }
    public void addAftertTo(Node<T> node,T info){
        if(isEmpty()){
            head= new Node<>(info);
        }else{
            Node<T> nNode= new Node<>(info);
            nNode.setNext( node.getNext());
            node.setNext(nNode);
        }
    }
    public void addBeforeTo(Node<T> node,T info){
        if(isEmpty()){
            head = new Node<>(info);
        }else{
            if(head == node){

            }else if(findBefore(node.getInfo())!= null){
                addAftertTo(findBefore(node.getInfo()), info);
            }
        }
    }
    public Node<T> findBefore(T info){
        Node<T> it = head;
        Node<T> ant = null;
        do{
            if(comparator.compare(info,it.getInfo())==0){

                return ant;
            }
            ant=it;
            it=it.getNext();
        }while (it != head);
        return null;
    }

    public Node<T> getHead() {
        return head;
    }



}
