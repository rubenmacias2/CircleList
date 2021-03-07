package Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import logic.*;
import org.junit.jupiter.api.*;
class ListerCircledTest {
    ListerCircled<Company> list;

    private void  setUp(){
        list= new ListerCircled<>(Company.compId);
        list.addFirst(new Company("1","1",0));
        list.addFirst(new Company("2","2",0));
        list.addFirst(new Company("3","3",0));
        list.addFirst(new Company("4","4",0));
        list.addFirst(new Company("5","5",0));
    }
    @Test
    void ListTest() {
        setUp();
        Node<Company> node = list.finNode(new Company("3","",0));
        assertNotNull(node);
        ArrayList<Company> nodes = list.runnerList(node);
        assertEquals(5,list.getList().size());
        assertEquals("5",nodes.get(3).getId());
    }
}