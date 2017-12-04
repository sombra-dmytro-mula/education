package org.somrainc.com.integration;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.somrainc.com.Application;
import org.somrainc.com.model.Book;
import org.somrainc.com.model.User;
import org.somrainc.com.repository.BookRepository;
import org.somrainc.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {
                Application.class
        })
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class IntegrationTest {

    //    @PersistenceContext
//    private Session session;
    @Autowired
    SessionFactory sessionFactory;
    //    @Autowired
//    @Qualifier("provideS3Uploader")
//    private UploaderInterface uploaderInterface;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void test() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        for (User user : users) {
            System.out.println(user.getBooks().get(0));
        }
    }

    @Test
    @Transactional
    public void test2() {
        User user = userRepository.findOne(1L);
        user.getBooks().clear();
        System.out.println(user.getBooks());
        Book book = bookRepository.findOne(1L);
        System.out.println(book.getUser());
    }

    @Test
    @Transactional
    public void test3() {
        List result = sessionFactory.openSession().createCriteria(User.class)
                .setFetchMode("books", FetchMode.JOIN)
                .list();
        for (int i = 0; i < result.size(); i++) {
            for (int i1 = i + 1; i1 < result.size(); i1++) {
                if (result.get(i).equals(result.get(i1))) {
                    System.out.printf("Equal for element %s and %s - %s\n", i, i1, result.get(i));
                }
            }
        }
    }
}
