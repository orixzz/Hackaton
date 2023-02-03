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
        return false;
    }

    record Challenge(long value) {
    }

}
