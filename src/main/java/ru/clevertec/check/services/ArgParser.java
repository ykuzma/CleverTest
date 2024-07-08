package main.java.ru.clevertec.check.services;

public interface ArgParser<T> {

   T parse(String[] args);
}
