package main.java.ru.clevertec.check.configuration;

import java.io.PrintStream;

public class ConfigurationApp {

    private String pathProduct = "./src/main/resources/products.csv";
    private String pathDiscountCard = "./src/main/resources/discountCards.csv";
    private String delimiter = ";";
    private String savoTo = "./result.csv";
    private static int wholesale = 10;

    private static ConfigurationApp configurationApp;

    public static ConfigurationApp getInstance() {
        if(configurationApp == null) {
            configurationApp = new ConfigurationApp();
        }
        return configurationApp;
    }


    public void setPathProduct(String pathProduct) {
        this.pathProduct = pathProduct;
    }

    public void setPathDiscountCard(String pathDiscountCard) {
        this.pathDiscountCard = pathDiscountCard;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void setSavoTo(String savoTo) {
        this.savoTo = savoTo;
    }

    public static void setWholesale(int wholesale) {
        ConfigurationApp.wholesale = wholesale;
    }

    private ConfigurationApp(){}

    public int getWholesale() {
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
