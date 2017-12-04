package org.somrainc.com.junit;

import org.hibernate.jpa.internal.EntityManagerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.somrainc.com.model.User;
import org.somrainc.com.utils.UtilUser;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
public class JUnitMock {
    private User user;

    @Test
    public void testHibernate() {

    }

}
