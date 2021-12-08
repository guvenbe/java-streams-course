package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12UnderstandingCollectors {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(
//            () -> new ArrayList<String>(), //list
//            (list, element) -> list.add(element),//acumulator
//            (list1, list2)->list1.addAll(list2) //
            ArrayList::new, //list
            ArrayList::add,//acumulator
            ArrayList::addAll //combiner - used in multithreading
            );

    emails.forEach(System.out::println);
  }
}
