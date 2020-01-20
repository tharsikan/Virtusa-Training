import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A {

  public static void main(String[] args) {
    //Student filter HomeWork
    Map<String, Integer> studentList = new HashMap<String, Integer>();

    studentList.put("ishan", 99);
    studentList.put("a", 88);
    studentList.put("hishan", 77);
    studentList.put("kishan", 66);
    studentList.put("rishan", 55);
    studentList.put("dilshan", 44);

    Map<String, Integer> filtered = studentList.entrySet().stream().filter(e -> e.getValue() > 60).sorted(Map.Entry.<String, Integer>comparingByKey()).collect(Collectors.toMap(
            e -> e.getKey(), e -> e.getValue()
    ));
    System.out.println(filtered);

    //Print star Pattern
    int starLines = 10;
    int[] ints = IntStream.range(0, starLines).map(e -> e + e + 1).toArray();
    Arrays.stream(ints).forEach(e -> {
      System.out.println(
              Stream.generate(() -> " ").limit((ints[ints.length - 1] - e) / 2).collect(Collectors.joining()) +
                      Stream.generate(() -> "*").limit(e).collect(Collectors.joining()));
    });
    
    //print fibonnachi
      
      
  }
}
