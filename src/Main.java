import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));

        }
        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(count + " несовершеннолетних");
        List<String> stream = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

        System.out.println("Призывники " + stream);
        List<String> stream1 = persons.stream()
                .filter(x -> x.getAge() > 18 && x.getAge() < 65)
                .filter(x -> x.getAge() > 18 && x.getAge() < 60)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
      System.out.println("Работоспособоное население " + stream1);

        /* как сделать с помощью метода sorted?
        Подскажите пожалуйста
         */

         /* List<String> stream2 = persons.stream()
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getAge() < 60)
                .filter(person -> person.getSex() == Sex.WOMAN)
                .filter(x -> x.getEducation() == Education.HIGHER)
                    .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println("Работоспособоные женщины " + stream2);*/

    }
}