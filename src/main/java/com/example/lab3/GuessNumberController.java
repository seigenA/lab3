package com.example.lab3;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


@RequestMapping("/guess")
public class GuessNumberController {

    private final int numberToGuess = 42;

    @PostMapping
    public ResponseEntity<String> guessNumber(@RequestParam int guess) {
        if (guess < numberToGuess) {
            return ResponseEntity.ok("Ваше число меньше загаданного числа.");
        } else if (guess > numberToGuess) {
            return ResponseEntity.ok("Ваше число больше загаданного числа.");
        } else {
            return ResponseEntity.ok("Вы угадали!");
        }
    }
}
