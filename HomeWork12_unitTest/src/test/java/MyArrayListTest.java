import MyArrayList.MyArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    @Test
    public void addValueToEmpty(){
        MyArrayList list = new MyArrayList(1);
        list.add("1");
        String expected = "1";
        assertEquals(list.get(0),expected);
        assertEquals(1,list.size());
    }

    @Test
    public void addValueToNotEmpty(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");

        String expected = "1";
        String expected2 = "2";
        assertEquals(list.get(0),expected);
        assertEquals(list.get(1),expected2);
        assertEquals(2,list.size());
    }

    @Test
    public void addValueWithIndex(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add(1,"3");

        String expected = "1";
        String expected2 = "3";
        String expected3 = "2";
        assertEquals(list.get(0),expected);
        assertEquals(list.get(1),expected2);
        assertEquals(list.get(2),expected3);
        assertEquals(3,list.size());
    }

    @Test
    public void addValueWithNegativeIndex(){
        MyArrayList list = new MyArrayList(1);
        assertFalse(list.add(-1,""));
    }

    @Test
    public void addNull(){
        MyArrayList list = new MyArrayList(1);
        assertTrue(list.add(null));
        assertEquals(1,list.size());
    }

    @Test
    public void addValueWithOutOfBoundIndex(){
        MyArrayList list = new MyArrayList(1);
        assertFalse(list.add(2,""));
    }

    @Test
    public void addValueWithIndexInStartList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add(0,"3");

        String expected = "3";
        String expected2 = "1";
        String expected3 = "2";
        assertEquals(list.get(0),expected);
        assertEquals(list.get(1),expected2);
        assertEquals(list.get(2),expected3);
        assertEquals(3,list.size());
    }

    @Test
    public void addValueWithIndexInEndList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add(1,"3");

        String expected = "1";
        String expected2 = "3";
        String expected3 = "2";
        assertEquals(list.get(0),expected);
        assertEquals(list.get(1),expected2);
        assertEquals(list.get(2),expected3);
        assertEquals(3,list.size());
    }

    @Test
    public void getItemFromList(){
        MyArrayList list = new MyArrayList(1);
        list.add("1");
        list.add("2");

        String expected = "1";
        String expected2 = "2";
        assertEquals(expected,list.get(0));
        assertEquals(expected2,list.get(1));
        assertEquals(2,list.size());
    }

    @Test
    public void extendListSize(){
        MyArrayList list = new MyArrayList(1);
        list.add("1");
        list.add("2");
        assertEquals(2,list.size());
    }

    @Test
    public void removeLastItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.delete("2");

        String expected = "1";
        assertEquals(expected,list.get(0));
        assertEquals(1,list.size());
    }

    @Test
    public void removeFirstItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.delete("1");

        String expected = "2";
        assertEquals(expected,list.get(0));
        assertEquals(1,list.size());
    }

    @Test
    public void removeItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");
        list.delete("2");

        String expected = "1";
        String expected2 = "3";
        assertEquals(expected,list.get(0));
        assertEquals(expected2,list.get(1));
        assertEquals(2,list.size());
    }

    @Test
    public void containsFirstItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        assertTrue(list.contain("1"));
    }

    @Test
    public void containsItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        assertTrue(list.contain("2"));
    }

    @Test
    public void containsLastItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        assertTrue(list.contain("3"));
    }

    @Test
    public void notContainsItemFromList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        assertFalse(list.contain("4"));
    }

    @Test
    public void equalsList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList list2 = new MyArrayList(2);
        list2.add("1");
        list2.add("2");
        list2.add("3");

        assertTrue(list.equals(list2));
    }

    @Test
    public void notEqualsListWithDifferentSize(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList list2 = new MyArrayList(2);
        list2.add("1");
        list2.add("2");

        assertFalse(list.equals(list2));
    }

    @Test
    public void notEqualsListWithLastDifferentValue(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList list2 = new MyArrayList(2);
        list2.add("1");
        list2.add("2");
        list2.add("4");

        assertFalse(list.equals(list2));
    }

    @Test
    public void notEqualsListWithFirstDifferentValue(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList list2 = new MyArrayList(2);
        list2.add("2");
        list2.add("2");
        list2.add("3");

        assertFalse(list.equals(list2));
    }

    @Test
    public void notEqualsListWithDifferentValue(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        MyArrayList list2 = new MyArrayList(2);
        list2.add("1");
        list2.add("3");
        list2.add("3");

        assertFalse(list.equals(list2));
    }

    @Test
    public void clearList(){
        MyArrayList list = new MyArrayList(2);
        list.add("1");
        list.add("2");
        list.add("3");

        assertTrue(list.clear());
        assertEquals(0,list.size());
    }

    @Test
    public void clearListWithEmptyList(){
        MyArrayList list = new MyArrayList(2);

        assertTrue(list.clear());
        assertEquals(0,list.size());
    }
}
