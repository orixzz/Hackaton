package be.one16.testsolution.solution;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {
    final HashMap<Integer, BigInteger> dict = new HashMap<>();

    @PostMapping("/solution")
    public Challenge solution(@RequestBody Challenge challenge) {
        final List<BigInteger> solves = new ArrayList<>();
        int counter = 1;

        while (solves.size() < 4) {
            solves.add(fib(counter));
            counter++;
        }

        while (getSumOfSolves(solves).compareTo(challenge.value) != 0 && counter < 300) {
            System.out.println(counter + solves.toString());
            solves.remove(0);
            solves.add(fib(counter));
            counter++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (BigInteger i : solves)
            stringBuilder.append(i);
        return new Challenge(new BigInteger(stringBuilder.toString()));
    }


    private BigInteger getSumOfSolves(List<BigInteger> solves) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i : solves) sum = sum.add(i);
        return sum;
    }

    BigInteger fib(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);

        if (dict.containsKey(n)) {
            return dict.get(n);
        }

        final BigInteger calc = fib(n - 1).add(fib(n - 2));
        dict.put(n, calc);
        return calc;
    }

    record Challenge(BigInteger value) { }

}
