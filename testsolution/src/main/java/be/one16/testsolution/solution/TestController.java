package be.one16.testsolution.solution;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/solution")
    public Result solution(@RequestBody Challenge challenge) {
        String binary = Integer.toBinaryString(challenge.code);
        final String message = challenge.message;
        StringBuilder response = new StringBuilder();

        while (binary.length() < message.length()) {
            binary = "0" + binary;
        }

        for (int i = 0; i <= message.length() - 1; i++) {
            if (binary.charAt(i) == '1') {
                final char c = message.charAt(i);
                response.append(c);
            }
        }

        return new Result(response.toString());
    }


    record Challenge(String message, Integer code) {
    }

    record Result(String decoded) {
    }

}
