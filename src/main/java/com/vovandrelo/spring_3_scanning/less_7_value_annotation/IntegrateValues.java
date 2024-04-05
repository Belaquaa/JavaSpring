package com.vovandrelo.spring_3_scanning.less_7_value_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IntegrateValues {
    // Аннотация @Value используется для внедрения (инъекции) примитивных значений, строк, или выражений в bean-ы:

    // Внедрение числа:
    @Value("10")
    public int numberValue;

    // Внедрение строки:
    @Value("some string")
    public String stringValue;

    // Внедрение boolean-значения:
    @Value("true")
    public boolean booleanValue;

    // Так же аннотация @value может использоваться для внедрения значений из подключённого с помощью @PropertySource
    // property-файла. Причём, если ни одни property-файл не подключен, то Spring попытается реализовать поведение по
    // умолчанию и будет искать указанные значения в application.yml

    // Внедрение числа из файла *.properties:
    @Value("${my.number}")
    public int numberFromFile;

    // Внедрение строки из файла *.properties:
    @Value("${my.string}")
    public String stringFromFile;

    // Внедрение boolean-значения из файла *.properties:
    @Value("${my.boolean}")
    public boolean booleanFromFile;

    // Внедрения значения по-умолчанию:
    @Value("${missing-string:default-value}")
    public String defaultString;

    // Аннотацию @Value аналогично @Autowired можно использовать внутри конструкторов и set-теров.

    // Для внедрения более сложных выражений с помощью аннотации @Value используется SpEL (Spring Expression Language).
}
