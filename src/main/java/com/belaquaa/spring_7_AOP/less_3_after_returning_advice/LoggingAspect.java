package com.belaquaa.spring_7_AOP.less_3_after_returning_advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // В Spring AOP аннотация @AfterReturning используется для определения After-Returning-Advice - действия, которое
    // должно быть выполнено после успешного завершения работы указанного с помощью pointcut-expression метода:
    @AfterReturning("execution(public String getName())")
    public void afterReturningAdviceGetName() {
        System.out.println("-------------");
        System.out.println("Some log №1 from after-returning-advice ");
    }

    // Advice-Before может использовать внутри себя:
    // - JoinPoint: объект, который содержит информацию о вызванном методе, например, имя метода, аргументы метода и
    //   другие детали;
    // - Returning: объект, содержащий возвращаемое значение вызванного метода;
    @AfterReturning(pointcut = "execution(public String getName())", returning = "someInfo")
    public void afterReturningAdviceGetName(JoinPoint joinPoint, String someInfo) {
        System.out.println("-------------");
        System.out.println("Some log №2 from after-returning-advice ");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("JoinPoint, methodSignature.getName: " + methodSignature.getName());

        // Изменение объекта в @AfterReturning не изменит само возвращаемое значение метода, если это значение является
        // неизменяемым объектом (например, строкой или числом). В случае изменяемых объектов (например, списков или
        // пользовательских объектов), изменения свойств объекта будут отражены в возвращаемом значении, так как Java
        // передает объекты по ссылке.
        System.out.println("Returning: " + someInfo);
    }
}
