package be.one16.testsolution.solution;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    private String result;


    @PostMapping("/solution")
    public Challenge solution(@RequestBody Challenge challenge) {
        long temp = challenge.value;

        while(true) {
            final boolean check = checkIfPalindrome(temp);
            if (check) {
                return new Challenge(temp);
            } else {
                temp++;
            }
        }
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

    record Challenge(long value) { }

}
