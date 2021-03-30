package learning.java.functional.development;

public class Main3 {

    protected static class MultipleMath {
        public static Integer multiply(Integer s, Integer t, Integer u) {
            return s * t * u;
        }
    }

    public static void main(String[] args) {
        NoArgsFunction<String> noArgsFunction = () -> "Hello World!";
        System.out.println(noArgsFunction.apply());

        MultipleArgsFunction<Integer, Integer, Integer, Integer> multipleArgsFunction =
                (s, t, u) -> {
                    return s + t + u;
                };
        System.out.println(multipleArgsFunction.apply(2,3,4));

        MultipleArgsFunction<Integer, Integer, Integer, Integer> multiplyMathFunction =
                MultipleMath::multiply;
        Integer result = multiplyMathFunction.apply(1,2,3);
        System.out.println(result);
    }
}
