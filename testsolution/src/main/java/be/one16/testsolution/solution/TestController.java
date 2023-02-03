package be.one16.testsolution.solution;


import jdk.jshell.spi.ExecutionControl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class TestController {


    private String result;


    @PostMapping("/solution")
    public Challenge solution(@RequestBody Challenge challenge) {
        long temp = challenge.value;
        
        return new Challenge(temp);
    }

    private boolean checkIfPalindrome(long candidate) {
        final String s = String.valueOf(candidate);
        final int index = (s.length() % 2 == 0) ? s.length() / 2 : s.length() / 2 - 1;

        int counter = 0;
        while (counter < index) {
            if (s.charAt(counter) != s.charAt(s.length() - 1 - counter)) {
                return false;
            }
            counter++;
        }

        return true;
    }

    record Challenge(long value) {
    }

}
