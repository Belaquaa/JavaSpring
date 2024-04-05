package com.vovandrelo.spring_7_AOP.less_4_after_throwing_advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // В Spring AOP аннотация @AfterThrowing используется для определения After-Throwing-Advice - действия, которое
    // должно быть выполнено после выброса исключения в указанном с помощью pointcut-expression методе:
    @AfterThrowing("execution(public String getName())")
    public void afterThrowingAdviceGetName() {
        System.out.println("-------------");
        System.out.println("Some log №1 from after-throwing-advice ");
    }

    // ! After-Throwing-Advice не предназначено для обработки исключения !

    // After-Throwing может использовать внутри себя:
    // - JoinPoint: объект, который содержит информацию о вызванном методе, например, имя метода, аргументы метода и
    //   другие детали;
    // - Throwing: объект, содержащий вызванное исключение;
    @AfterThrowing(pointcut = "execution(public String getName())", throwing = "someException")
    public void afterThrowingAdviceGetName(JoinPoint joinPoint, Throwable someException) {
        System.out.println("-------------");
        System.out.println("Some log №2 from after-throwing-advice ");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("JoinPoint, methodSignature.getName: " + methodSignature.getName());
        System.out.println("Throwing: " + someException.getMessage());
    }
}
