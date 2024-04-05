package com.vovandrelo.spring_7_AOP.less_6_around_advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // В Spring AOP аннотация @Around используется для определения Around-Advice - действия, которое с помощью
    // pointcut-expression связывается с методом и имеет возможность:
    // - Произвести какие-либо действия до работы target-метода;
    // - Произвести какие-либо действия после работы target-метода;
    // - Получить/изменить результат работы target-метода;
    //
    // Это один из самых мощных Advice-ов в Spring AOP, так как он дает полный контроль над выполнением метода.

    // Метод, помеченный аннотацией @Around, должен возвращать Object и принимать один обязательный аргумент
    // — объект типа ProceedingJoinPoint. Этот интерфейс является подтипом JoinPoint и предоставляет дополнительную
    // функциональность: возможность продолжить выполнение цепочки перехвата, то есть вызвать сам перехватываемый
    // метод:
    @Around("execution(public String getName())")
    public Object aroundAdviceGetName(ProceedingJoinPoint ProceedingJoinPoint) throws Throwable {
        System.out.println("Some log №1 from start around-advice");

        // Выполнение целевого метода:
        Object targetMethodResult = ProceedingJoinPoint.proceed();

        // Важно отметить, что если метод, помеченный @Around, не вызывает joinPoint.proceed(), то перехватываемый
        // метод не будет выполнен. Это дает возможность полностью изменить поведение перехватываемого метода.

        // ... some actions with targetMethodResult ...

        System.out.println("Some log №2 from finish around-advice ");
        return targetMethodResult;
    }

    // Around-Advice может использоваться для обработки исключений:
    @Around("execution(public String getNameWithThrow())")
    public Object aroundAdviceGetNameWithThrow(ProceedingJoinPoint ProceedingJoinPoint) throws Throwable {
        System.out.println("Some log №3 from start around-advice-with-throw");

        Object targetMethodResult = null;
        try {
            targetMethodResult = ProceedingJoinPoint.proceed();
        } catch (RuntimeException exception) {
            targetMethodResult = "New result after processing exception";
        }

        System.out.println("Some log №4 from finish around-advice-with-throw");
        return targetMethodResult;
    }
}
