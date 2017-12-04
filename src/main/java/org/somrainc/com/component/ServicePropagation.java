package org.somrainc.com.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ServicePropagation {
    public int counter = 0;

    public void showAndIncrease() {
        System.out.println(counter++);
    }

}
