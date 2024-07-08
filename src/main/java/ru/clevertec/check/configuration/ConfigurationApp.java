package main.java.ru.clevertec.check.configuration;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class ConfigurationApp implements Closeable {

    private String pathProduct = "./src/main/resources/products.csv";
    private String pathDiscountCard;
    private InputStream inputStream;

    private static ConfigurationApp configurationApp;

    public static ConfigurationApp getInstance() {
        if(configurationApp == null) {
            configurationApp = new ConfigurationApp();
        }
        return configurationApp;
    }

    @Override
    public void close() throws IOException {

    }

    private ConfigurationApp(){}
}
