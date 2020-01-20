import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Student {
  String name;
  int mark;

  public Student(String name, int mark) {
    this.name = name;
    this.mark = mark;
  }

  @Override
  public String toString() {
    return "{" +
            "name='" + name + '\'' +
            ", mark=" + mark +
            '}';
  }
}

class Car implements Comparable<Car> {
  String code;
  int speed;

  public Car(String code, int speed) {
    this.code = code;
    this.speed = speed;
  }

  @Override
  public int compareTo(Car o) {
    return this.speed - o.speed;
  }

  @Override
  public String toString() {
    return "Car{" +
            "code='" + code + '\'' +
            ", speed=" + speed +
            '}';
  }
}

public class Compare {
  public static void main(String[] args) {
    ArrayList<Student> students = new ArrayList<>();
    students.add(new Student("e", 79));
    students.add(new Student("b", 59));
    students.add(new Student("c", 89));
    students.add(new Student("z", 69));
    students.add(new Student("a", 99));

    Comparator<Student> markComparator = new Comparator<Student>() {
      @Override
      public int compare(Student student, Student student1) {
        return student.mark - student1.mark;
      }
    };

    Comparator<Student> markDesendingComparator = (s1, s2) -> s2.mark - s1.mark;

    //assigned lambda
    students.sort(markDesendingComparator);

    //lambda directly
    students.sort((a, b) -> a.name.compareTo(b.name));

    System.out.println(students);
    System.out.println();

    ArrayList<Car> cars = new ArrayList<>();
    cars.add(new Car("c2", 1));
    cars.add(new Car("b2", 10));
    cars.add(new Car("z2", 6));
    cars.add(new Car("d2", 8));
    cars.add(new Car("x2", 7));
    cars.add(new Car("a2", 9));

    System.out.println(cars);
    Collections.sort(cars);
    System.out.println(cars);

   //Using Streams
    cars.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    System.out.println();
    cars.stream().sorted((a, b) -> a.code.compareTo(b.code)).forEach(System.out::println);

  }
}
