package org.somrainc.com.service;

import org.somrainc.com.model.User;
import org.somrainc.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        System.out.println("Saving user");
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        User savedUser = userRepository.findOne(user.getId());
        savedUser.setUsername(user.getUsername());
        userRepository.save(savedUser);
    }

    @Override
    public void tellWhatIsYourName() {
        System.out.println("My name is Clark");
    }

    @Override
    public void tellHowOldAreYou() {
        System.out.println("I'm 35");
    }

    @Override
    public void tellSomething() {
        System.out.println("We are going to have a party");
    }

    @Override
    public String forSpELTest() {
        return null;
    }

}
