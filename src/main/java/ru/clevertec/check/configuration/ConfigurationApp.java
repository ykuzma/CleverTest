package main.java.ru.clevertec.check.configuration;

public class ConfigurationApp {
    private int wholesale = 10;
    private String pathProduct = "./src/main/resources/products.csv";
    private String pathDiscountCard = "./src/main/resources/discountCards.csv";
    private String delimiter = ";";
    private String saveTo = "./result.csv";

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

    public void setSaveTo(String saveTo) {
        this.saveTo = saveTo;
    }

    public void setWholesale(int wholesale) {
        this.wholesale = wholesale;
    }

    public void setPathDiscountCard(String pathDiscountCard) {
        this.pathDiscountCard = pathDiscountCard;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getSaveTo() {
        return saveTo;
    }

    private ConfigurationApp(){}

    public  int getWholesale() {
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
