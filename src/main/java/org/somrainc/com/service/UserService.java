package org.somrainc.com.service;

import org.somrainc.com.model.User;

public interface UserService {

    User findById(long id);

    void save(User user);

    void update(User user);

    void tellWhatIsYourName();

    void tellHowOldAreYou();

    void tellSomething();

    String forSpELTest();
}
