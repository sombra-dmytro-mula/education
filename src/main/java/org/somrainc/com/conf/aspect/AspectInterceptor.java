package org.somrainc.com.conf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.somrainc.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
@Configuration
public class AspectInterceptor {

    @Autowired
    private UserService userService;

    @Around("execution(** org.somrainc.com.service.UserService.tellWhatIsYourName(..))")
    public void beforeMethod(ProceedingJoinPoint jp) {
//        System.out.println("My name is Dmytro");
//        System.out.println("Awesome Spring");
        userService.tellSomething();

        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
