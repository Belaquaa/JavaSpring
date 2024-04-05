package com.vovandrelo.spring_7_AOP.less_2_before_advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    // В Spring AOP аннотация @Before используется для определения Before-Advice - действия, которое должно быть
    // выполнено перед запуском указанного с помощью pointcut-expression метода:
    @Before("execution(public void sound(String))")
    public void beforeAdviceSound() {
        System.out.println("-------------");
        System.out.println("Some log №1 from before-advice ");
    }

    // Advice-Before может использовать внутри себя JoinPoint - объект, который содержит информацию о вызванном методе,
    // например, имя метода, аргументы метода и другие детали:
    @Before("execution(public void sound(String))")
    public void beforeAdviceSound(JoinPoint joinPoint) {
        System.out.println("-------------");
        System.out.println("Some log №2 from before-advice ");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("JoinPoint, methodSignature: " + methodSignature);
        System.out.println("JoinPoint, methodSignature.getMethod: " + methodSignature.getMethod());
        System.out.println("JoinPoint, methodSignature.getReturnType: " + methodSignature.getReturnType());
        System.out.println("JoinPoint, methodSignature.getName: " + methodSignature.getName());

        Object[] methodArgs = joinPoint.getArgs();
        System.out.println("JoinPoint, methodArgs: " + Arrays.toString(methodArgs));
    }
}
