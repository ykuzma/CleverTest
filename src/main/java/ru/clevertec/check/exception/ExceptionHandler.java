package main.java.ru.clevertec.check.exception;

import main.java.ru.clevertec.check.models.ResultHandler;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class ExceptionHandler implements ResultHandler {

    private final String exceptionMessage;

    public ExceptionHandler(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void save(OutputStream ous) {
        PrintWriter writer = new PrintWriter(ous);
        writer.print(this);
        writer.flush();
    }

    @Override
    public String toString() {

        return "ERROR\n" + getExceptionMessage();
    }
}
