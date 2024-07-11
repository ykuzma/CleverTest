package main.java.ru.clevertec.check.exception;

import main.java.ru.clevertec.check.models.ResultHandler;

import java.io.OutputStream;
import java.io.PrintWriter;

public class ExceptionHandler implements ResultHandler {

    private final String exceptionMessage;
    private final String DEFAULT_MESSAGE = "INTERNAL SERVER ERROR";

    public ExceptionHandler(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage == null ? DEFAULT_MESSAGE : exceptionMessage;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void save(OutputStream ous) {
        print();
        PrintWriter writer = new PrintWriter(ous);
        writer.print(this);
        writer.flush();
    }

    @Override
    public String toString() {

        return "ERROR\n" + getExceptionMessage();
    }
}
