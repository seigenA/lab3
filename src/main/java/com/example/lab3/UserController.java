package com.example.lab3;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private Map<Integer, User> users = new HashMap<>();

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Имя не может быть пустым");
        }
        if (user.getAge() < 18) {
            return ResponseEntity.badRequest().body("Возраст должен быть больше 18");
        }
        user.setId(users.size() + 1);
        users.put(user.getId(), user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody User user) {
        if (!users.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        users.put(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        users.remove(id);
        return ResponseEntity.ok("Пользователь с ID " + id + " был удален.");
    }

    @GetMapping
    public ResponseEntity<Map<Integer, User>> getAllUsers() {
        return ResponseEntity.ok(users);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Ошибка валидации: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @GetMapping("/exception")
    public ResponseEntity<String> throwException() {
        throw new RuntimeException("Это исключение.");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(500).body("Произошла ошибка: " + ex.getMessage());
    }
}
