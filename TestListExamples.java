import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMerge1() {
    List<String> list1 = Arrays.asList("a", "b", "c");
    List<String> list2 = Arrays.asList("a", "d", "e");
    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d", "e");
    assertEquals(expected, merged);
  }
  @Test(timeout = 500)
  public void testMerge2() {
    List<String> list1 = Arrays.asList("a");
    List<String> list2 = Arrays.asList("b");
    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList("a", "b");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge3() {
    List<String> list1 = Arrays.asList("a", "b", "z");
    List<String> list2 = Arrays.asList("a", "c", "d");
    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d", "z");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge4() {
    List<String> list1 = Arrays.asList();
    List<String> list2 = Arrays.asList();
    List<String> merged = ListExamples.merge(list1, list2);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilterEmpty() {
    List<String> input = Arrays.asList();
    List<String> expect = Arrays.asList();
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    assertEquals(expect, filtered);
  }
  @Test(timeout = 500)
  public void testFilterSingle() {
    List<String> input = Arrays.asList("Moon", "MOO", "moo");
    List<String> expect = Arrays.asList("Moon");
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    assertEquals(expect, filtered);
  }

  @Test(timeout = 500)
  public void testFilterMulti() {
    List<String> input = Arrays.asList("Moon", "MOO", "moon", "MOON");
    List<String> expect = Arrays.asList("Moon", "moon", "MOON");
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    assertEquals(expect, filtered);
  }

  @Test(timeout = 500)
  public void testFilterWrong() {
    List<String> input = Arrays.asList("Hank", "Joe", "Bob");
    List<String> expect = Arrays.asList();
    List<String> filtered = ListExamples.filter(input, new IsMoon());
    assertEquals(expect, filtered);
  }
}
