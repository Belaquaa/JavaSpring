package com.belaquaa.spring_7_AOP.less_7_pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut: выражение, оно определяет место, в котором должен быть применён Advice. Pointcut-expression
    // указывается совместно с типом сопоставления и имеет следующий формат:
    //  - тип_сопоставления(модификатор-доступа возвращаемое-значение название-класса.название-метода(типы-метода))
    // Обязательными параметрами являются:
    //  - тип_сопоставления(возвращаемое-значение название-метода(типы-метода))

    // Pointcut-expression могут использовать различные типы сопоставлений:
    // - execution - для сопоставления выполнения метода.
    // - within - для сопоставления всех методов в определенном классе или пакете.
    // - this - для сопоставления с прокси-объектом AOP, реализующим заданный интерфейс.
    // - target - для сопоставления с целевым объектом, за которым следит AOP-прокси.
    // - args - для сопоставления методов, принимающих аргументы с определенными типами.
    // - @annotation - для сопоставления методов, аннотированных определенной аннотацией.
    // - @args - для сопоставления методов, чьи аргументы аннотированы определенной аннотацией.
    // - @within - для сопоставления всех методов в типе с определенной аннотацией.
    // - @target - для сопоставления объектов, чьи классы аннотированы определенной аннотацией.

    // Примеры Pointcut:
    // - execution (public void getBook()): Соответствует методу без параметров, где бы он ни находился с access
    //                                      modifier = public, return type = void и именем = getBook;
    // - execution (public void com.vovandrelo.Book.getBook()): Соответствует методу без параметров, из класса
    //                                                          com.vovandrelo.Book c access modifier = public,
    //                                                          return type = void и именем = getBook;
    // - execution (public void get*()):    Соответствует методу без параметров, где бы он ни находился с access
    //                                      modifier = public, return type = void и именем, начинающимся на «get»;
    // - execution (* getBook()):           Соответствует методу без параметров, где бы он ни находился с любым access
    //                                      modifier, любым return type и именем = getBook;
    // - execution (* *()):                 Соответствует методу без параметров, где бы он ни находился с любым access
    //                                      modifier, любым return type и любым именем
    // - execution (public void getBook (String)):  Соответствует методу с параметром String, где бы он ни находился с
    //                                              access modifier = public, return type = void n именем = getBook
    // - execution (public void getBook (*)):   Соответствует методу с любым одним параметром, где бы он ни находился с
    //                                          access modifier = public, return type = void и именем = getBook
    // - execution (public void getBook (..)):  Соответствует методу с любым количеством любого типа параметров, где бы
    //                                          он ни находился с access modifier = public, return type = void и
    //                                          именем = getBook
    // - execution (public void getBook (com.vovandrelo.Book, ..)): Соответствует методу, первым параметром которого
    //                                                              является Book, а дальше может идти 0 и больше
    //                                                              параметров любого типа, где бы этот метод ни
    //                                                              находился с access modifier = public, return
    //                                                              type = void и именем = getBook
    // - execution (* * (..)):  Соответствует методу с любым количеством любого типа параметров, где бы он ни находился
    //                          с любым access modifier, любым return type и любым именем

    // Обычно Pointcut используются внутри с аннотаций Advice (см. less-2-3-4-5), но при возникновении ситуации,
    // когда один и тот же Pointcut необходимо использовать в множестве различных Advice, используется аннотация
    // @Pointcut. Она позволяет вынести Pointcut-expression в переменную и использовать его в нескольких Advice:
    @Pointcut("execution(* com.belaquaa.spring_7_AOP.less_7_pointcut.Library.get*(..))")
    private void allGetMethodsFromLibrary() {
    }
    @Pointcut("execution(* com.belaquaa.spring_7_AOP.less_7_pointcut.Library.return*(..))")
    private void allReturnMethodsFromLibrary() {
    }

    // Pointcut-ы можно комбинировать с помощью логических операций: ||, && или !
    @Pointcut("allGetMethodsFromLibrary() || allReturnMethodsFromLibrary()")
    private void allGetAndReturnMethodsFromLibrary() {
    }

    // Используем определённые раннее Pointcut-ы:
    @Before("allGetMethodsFromLibrary()")
    public void beforeAdviceGetBook() {
        System.out.println("Some log №1 from before-advice-get-book");
    }

    @Before("allReturnMethodsFromLibrary()")
    public void beforeAdviceReturnBook() {
        System.out.println("Some log №2 from before-advice-return-book");
    }

    @Before("allGetAndReturnMethodsFromLibrary()")
    public void beforeAdviceGetAndReturnBook() {
        System.out.println("Some log №3 from before-advice-get-and-return-book");
    }
}
