package logic;

public class Run {
    public static void main (String [] arg){

        ListerCircled<Company> list = new ListerCircled<Company>(Company.compId);
        list.addSorted(new Company("1","1",1));
        list.addSorted(new Company("3","3",3));
        list.addSorted(new Company("2","2",2));
        list.addFirst(new Company("4","inicio",4));
        list.addLast(new Company("5","añade al final",4));
        list.addAftertTo(list.finNode(new Company("5","",0)),new Company("6","0",0));
        list.addBeforeTo(list.finNode(new Company("5","",0)),new Company("7","0",0));


        System.out.println(list.getList().size());
        for (Company company : list.getList()){
            System.out.println(company.toString());
        }
        System.out.println("head-------" +list.getHead().getInfo().toString());
        System.out.println("***"+list.finNode(new Company("5","",0)).getNext().getInfo().toString());

        Node<Company> node = list.finNode(new Company("5","",0));
        if (node != null){
            System.out.println(">>find "+node.getInfo().toString());

        }else {
            System.out.println("No Existe");
        }
        list.deleteNode(list.finNode(new Company("3","",0)));
        list.deleteNode(list.finNode(new Company("1","",0)));
        System.out.println(list.getList().size());

        for (Company company : list.runnerList(list.finNode(new Company("3","",0)))){
            System.out.println(company.toString());
        }

    }
}
