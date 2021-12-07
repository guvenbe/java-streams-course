package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1ImperativeDeclarative {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> youngPeople = Lists.newArrayList();

    final int limit = 10;
    int counter = 1;
    for (Person person : people) {
      if (person.getAge() <= 18) {
        youngPeople.add(person);
        counter++;
        if (counter == limit) {
          break;
        }
      }
    }
    youngPeople.forEach(System.out::println);
    //Functional

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() <= 18)
        .limit(10) //first 10
        .collect(Collectors.toList());

    youngPeople.forEach(System.out::println);

  }
}
