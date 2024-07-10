package main.java.ru.clevertec.check.models;

import java.io.InputStream;
import java.io.OutputStream;

public interface ResultHandler {

   void print();

   void save(OutputStream ous);
}
