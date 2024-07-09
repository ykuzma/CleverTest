package main.java.ru.clevertec.check.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.ms");
    public static void info(String message) {
        log(message, Level.INFO);

    }
    public static void warn(String message) {
        log(message, Level.WARN);

    }
    public static void error(String message) {
        log(message, Level.ERROR);

    }

    private static void log(String message, Level level) {
        String result = String.format("%s %s - %s", timeFormatter.format(LocalDateTime.now()),
                level, message);
        System.out.println(result);
    }

   private enum Level {
        INFO,
       WARN,
       ERROR
   }
}
