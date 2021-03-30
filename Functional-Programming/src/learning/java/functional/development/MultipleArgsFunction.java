package learning.java.functional.development;

public interface MultipleArgsFunction<S, T, U, R> {
    R apply(S s, T t, U u);
}
