package com.belaquaa.spring_3_scanning.less_6_lookup_annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    // Аннотация @Lookup используется для решения проблемы с prototype-beans, которые необходимо интегрировать в
    // singleton bean-ы. В Spring bean-ы по умолчанию являются singleton, что означает, что создается только один
    // экземпляр bean-а, который затем используется везде в приложении. Однако иногда требуется, чтобы внедряемый
    // bean был прототипом, то есть каждый раз, когда он запрашивается, создается новый экземпляр.
    //
    // Проблема возникает, когда мы пытаемся внедрить prototype bean в singleton bean. Поскольку singleton создается
    // один раз, prototype bean также будет создан один раз и больше не будет прототипом, а станет частью singleton.
    //
    // Чтобы решить эту проблему, можно использовать аннотацию @Lookup. Она позволяет singleton bean-у получать новый
    // экземпляр прототипного bean-а каждый раз, когда он ему нужен:
    @Lookup
    public PrototypeBean getPrototypeBean() {
        // Spring автоматически заменит этот метод реализацией, которая возвращает новый прототипный бин
        return null;
    }
}
