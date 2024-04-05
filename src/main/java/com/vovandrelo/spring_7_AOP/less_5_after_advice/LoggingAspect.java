package com.vovandrelo.spring_7_AOP.less_5_after_advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // В Spring AOP аннотация @After используется для определения After-Advice - действия, которое должно быть
    // выполнено после завершения работы указанного с помощью pointcut-expression метода. Причём, указанный метод
    // может завершиться как успешно, так и с исключением:
    @After("execution(public String getName())")
    public void afterAdviceGetName() {
        System.out.println("Some log №1 from after-advice ");
    }

    // After-Advice не может использовать внутри себя ни JoinPoint, ни Returning, ни Throwing.
}
