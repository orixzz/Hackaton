package be.one16.testsolution.solution;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @PostMapping("/solution")
    public Challenge solution(@RequestBody Challenge challenge) {

        final List<Integer> solves = new ArrayList<>();

        int counter = 1;

        while (solves.size() < 4) {
            solves.add(fib(counter));
            counter++;
        }

        while (getSumOfSolves(solves) != challenge.value) {
            solves.remove(0);
            solves.add(fib(counter));
            counter++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : solves)
            stringBuilder.append(i);
        return new Challenge(Long.parseLong(stringBuilder.toString()));
    }


    private Integer getSumOfSolves(List<Integer> solves) {
        int sum = 0;
        for (Integer i : solves)
            sum += i;
        return sum;
    }

    int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    record Challenge(long value) { }

}
