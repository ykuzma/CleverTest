package main.java.ru.clevertec.check.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationApp {
    private Connection connection;
    private int wholesale = 10;
    private String pathProduct = "./src/main/resources/products.csv";
    private String pathDiscountCard = "./src/main/resources/discountCards.csv";
    private String delimiter = ";";
    private String saveTo = "./result.csv";

    private String dsURL;
    private String dsPassword;
    private String dsUsername;


    private static ConfigurationApp configurationApp;

    public static ConfigurationApp getInstance() {
        if(configurationApp == null) {
            configurationApp = new ConfigurationApp();
        }
        return configurationApp;
    }

    private static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/check";
            String name = "postgres";
            String pass = "penelopacristal";


            return DriverManager.getConnection(url, name, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setDsURL(String dsURL) {
        this.dsURL = dsURL;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public void setDsUsername(String dsUsername) {
        this.dsUsername = dsUsername;
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

    public String getDsURL() {
        return dsURL;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public String getDsUsername() {
        return dsUsername;
    }

    public String getSaveTo() {
        return saveTo;
    }

    private ConfigurationApp(){
      connection = getConnection();
    }

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
