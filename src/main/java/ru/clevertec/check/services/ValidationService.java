package main.java.ru.clevertec.check.services;

public interface ValidationService<T> {

    boolean validate(T obj);
}
