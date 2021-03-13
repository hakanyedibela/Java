package learning.java.functional.development;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {


        List<Developer> listOfDevelopers = List.of(
                new Developer("Hakan", "Yedibela", 34, "Technical Lead", 4091),
                new Developer("John", "Doe", 33, "Technical Lead", 5060),
                new Developer("Aisha", "Walters", 33, "UI/UX Expert", 5030),
                new Developer("Jenny", "Pretty", 35, "Dev-Ops Expert", 4333)
        );

        Predicate<Developer> predicate = x -> x.getAge() == 33;
        System.out.println(predicate.test(listOfDevelopers.get(1))); // true

        // Operations on streams and parallelStreams never change the original DataStructure

        // Simple filter with Predicate
        listOfDevelopers
                .stream()
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(developer -> {
                    System.out.println(developer.getFirstName());
                });

        // add +100 to all salaries
        listOfDevelopers
                .stream()
                .map(x -> x.getSalary() + 100)
                .collect(Collectors.toList())
                .forEach(developer -> {
                    System.out.println(developer);
                });

        // Joining Example. Write result into var
        var joiningExample = listOfDevelopers
                .stream()
                .map(Developer::getFirstName)
                .collect(Collectors.joining(";"));
        System.out.println(joiningExample);

        // Grouping List over age with groupingBy Function
        listOfDevelopers
                .stream()
                .map(Developer::getAge)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println("Key = " + key + ", Value = " + value ));

    }

    static class Developer {

        private final String firstName;
        private final String lastName;
        private final Integer age;
        private final String position;
        private final Integer salary;

        public Developer(String firstName, String lastName, Integer age, String position, Integer salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.position = position;
            this.salary = salary;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getAge() {
            return age;
        }

        public String getPosition() {
            return position;
        }

        public Integer getSalary() {
            return salary;
        }

    }
}
