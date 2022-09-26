import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class LambdaMain {

    List<Integer> list = new ArrayList<>();

    // 3 of the 4 Functional Interface types - Predicate, Consumer, Function, and Supplier
    IntPredicate moreThan1 = n -> n > 1;
    IntPredicate isEven = moreThan1.and(n -> n % 2 == 0);   // Composite Predicate

    IntFunction<Boolean> add = list::add;       // Function using a Method Reference

    IntConsumer display1 = a -> System.out.printf("Composite (%d): ", a);
    IntConsumer display2 = a -> System.out.println(a * 10);
    IntConsumer composite = display1.andThen(display2);     // Composite Consumer
    List<Integer> printNEvens(int n) {         	      // first n even numbers
        for (int i = 0; list.size() < n; i++) {
            if (isEven.test(i)) add.apply(i);   // Predicate and Function
        }
        return list;
    }
    void consume(int n) {                       // Consumer
        composite.accept(n);
    }

    public void go()   {


    }
    public static void main(String[] args)  {
        new LambdaMain().go();


    }
}
