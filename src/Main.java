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
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 27)
                        .map(person -> person.getFamily())
                                .collect(Collectors.toList());

        System.out.println(stream);
        List<String> stream1 = persons.stream()
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getAge() < 65)
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getAge() < 60)
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .map(person -> person.getFamily())
                        .collect(Collectors.toList());
        System.out.println(stream1);





    }
}
class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public void setFamily(String family) {
        this.family = family;
    }

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}