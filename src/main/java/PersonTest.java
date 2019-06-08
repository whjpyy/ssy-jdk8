import com.chen.shengsiyuan.jdk8.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest {

    public static void main(String[] args) {

        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 30);
        Person p3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(p1, p2, p3);

        PersonTest.getPersonsByUsername("zhangsan", persons).forEach(p -> System.out.println(p.getUsername()));

        PersonTest.getPersonsByAge(25, persons).forEach(p -> System.out.println(p.getAge()));

        PersonTest.getPersonByAge2(33, persons, (ageOfPerson, personList) ->
             personList.stream().filter(p -> p.getAge() < ageOfPerson).collect(Collectors.toList())
        ).forEach(p -> System.out.println(p.getAge()));

        PersonTest.getPersonByAge2(33, persons, (ageOfPerson, personList) ->
                personList.stream().filter(p -> p.getAge() > ageOfPerson).collect(Collectors.toList())
        ).forEach(p -> System.out.println(p.getAge()));
    }

    public static List<Person> getPersonsByUsername(String username, List<Person> persons){
        return persons.stream().filter(person -> person.getUsername().equals(username)).collect(Collectors.toList());
    }

    public static List<Person> getPersonsByAge(int age, List<Person> persons){
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) ->
                personList.stream().filter(p -> p.getAge() > age).collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    public static List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction){
        return biFunction.apply(age, persons);
    }
}
