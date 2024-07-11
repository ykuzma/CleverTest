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
            Logger.info("Configuration create.");
        }
        return configurationApp;
    }

    private Connection createConnection() {
        try {

            return DriverManager.getConnection(dsURL, dsUsername, dsPassword);
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

    public Connection getConnection() {
        if(connection == null) {
           connection = createConnection();
        }
        return connection;
    }

    public String getSaveTo() {
        return saveTo;
    }

    private ConfigurationApp(){ }

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
