package main.java.ru.clevertec.check.configuration;

import java.io.PrintStream;

public class ConfigurationApp {
    private static int wholesale = 10;


    private String pathProduct = "./products.csv";
    private String pathDiscountCard = "./discountCards.csv";
    private String delimiter = ";";

    private static ConfigurationApp configurationApp;

    public static ConfigurationApp getInstance() {
        if(configurationApp == null) {
            configurationApp = new ConfigurationApp();
        }
        return configurationApp;
    }



    private ConfigurationApp(){}

    public static int getWholesale() {
        return wholesale;
    }

    public String getPathProduct() {
        return pathProduct;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getPathDiscountCard() {
        return pathDiscountCard;
    }
}
