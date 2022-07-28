package Activity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {

    static ArrayList<String> list;
    @BeforeEach
    public void setUp(){
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }
    @Test
    public void insertTest(){
        assertEquals(2,list.size(),"Expected size should be 2 for the list please check");

        list.add("gamma");
        assertEquals(3,list.size(),"Expected size should be 3 for the list please check");

        assertEquals("alpha", list.get(0), "This is not expected 1th element");
        assertEquals("beta", list.get(1), "This is not expected 2st element");
        assertEquals("gamma", list.get(2), "This is not expected 3rd element");
    }
    @Test
    public void testReplace(){
        assertEquals(2,list.size(),"Expected size should be 2 for the list please check");

        list.add("gamma");
        assertEquals(3,list.size(),"Expected size should be 3 for the list please check");
        list.set(1,"alpha");
        assertEquals("alpha", list.get(0), "This is not expected 1th element");
        assertEquals("alpha", list.get(1), "This is not expected 2st element");
        assertEquals("gamma", list.get(2), "This is not expected 3rd element");




    }
}
