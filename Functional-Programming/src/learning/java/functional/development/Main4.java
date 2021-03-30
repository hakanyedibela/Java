package learning.java.functional.development;

public class Main4 {


    protected static class Developer {
        private final String firstName;
        private final String lastName;
        private final Integer age;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getAge() {
            return age;
        }


        public Developer(String firstName, String lastName, Integer age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
    }

    protected static class DeveloperFinder {
        public final NoArgsFunction<Developer> findDeveloper;

        public DeveloperFinder(Boolean isAdult) {
            this.findDeveloper = isAdult
                    ? this::isAdult
                    : this::isNotAdult;
        }

        private Developer isNotAdult() {
            return new Developer("John", "Doe", 15);
        }

        private Developer isAdult() {
            return new Developer("Jason", "Freddy", 22);
        }
    }

    public static void main(String[] args) {

        final Boolean isAdult = Boolean.FALSE;
        DeveloperFinder developerFinder = new DeveloperFinder(isAdult);
        var result = developerFinder.findDeveloper.apply();
        System.out.println(result.getFirstName());
        System.out.println(result.getLastName());
        System.out.println(result.getAge());

    }
}
