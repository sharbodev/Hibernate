package org.example;

import org.example.model.Admin;
import org.example.model.User;
import org.example.repository.AdminRepository;
import org.example.repository.UserRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
        userRepository.save(new User("Boubr", 15));
    }
}
