package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.configuration.ConfigurationApp;
import main.java.ru.clevertec.check.configuration.Logger;
import main.java.ru.clevertec.check.exception.BadParametersException;
import main.java.ru.clevertec.check.models.OrderData;

import java.util.Arrays;

public class ArgsHandler implements ArgParser<OrderData>, ValidationService<String[]> {

    private final String ID_TEMPLATE = "\\d{1,19}-\\d{1,10}";
    private final String DISCOUNT_TEMPLATE = "discountCard=\\d{4}";
    private final String DEBIT_CARD_TEMPLATE = "balanceDebitCard=-{0,1}\\d{1,19}(\\.\\d{2}){0,1}";
    private final String SAVE_TO_FILE = "saveToFile=.+";

    private final String DS_URL = "datasource.url=.+";
    private final String DS_USERNAME = "datasource.username=.+";
    private final String DS_PASSWORD = "datasource.password=.+";



    @Override
    public boolean validate(String[] params) {
        int bank = 0;
        int discount = 0;
        int id = 0;
        int url = 0;
        int pass = 0;
        int user = 0;
        int save = 0;
        

        for (String s: params) {
            if(s.matches(ID_TEMPLATE)) {
                id++;
            } else if (s.matches(DISCOUNT_TEMPLATE)) {
                discount++;
            }else if(s.matches(DEBIT_CARD_TEMPLATE)){
                bank++;
            } else if (s.matches(SAVE_TO_FILE)) {
                save++;

            } else if (s.matches(DS_URL)) {
                url++;
            } else if (s.matches(DS_PASSWORD)) {
                pass++;
            } else if (s.matches(DS_USERNAME)) {
                user++;
            }
            else {
                Logger.error("Bad param = " + s);
                return false;
            }
            if(bank > 1 || discount > 1 || url > 1 || save > 1 || pass > 1 || user > 1) return false;
        }

        return id != 0 && bank != 0 && save != 0 && pass != 0 && user != 0 && url != 0;
    }

    @Override
    public OrderData parse(String[] args) {
        Logger.info("method  parse start");
        if(args.length == 0){
            Logger.error("No find Params");
            throw new BadParametersException("BAD REQUEST");
        }else if(!validate(args)) {
            Arrays.stream(args).filter(s -> s.matches(SAVE_TO_FILE))
                    .forEach(s -> ConfigurationApp.getInstance().setSaveTo(s.split("=")[1]));
            throw new BadParametersException("BAD REQUEST");
        }

        String[] tempArr;

        OrderData.OrderDataBuilder builder = new OrderData.OrderDataBuilder();
        for (String arg : args) {

            if(arg.matches(ID_TEMPLATE)) {
                tempArr = arg.split("-");
                long key = Integer.parseInt(tempArr[0]);
                int value = Integer.parseInt(tempArr[1]);
                builder.setProduct(key, value);
            } else if (arg.matches(DEBIT_CARD_TEMPLATE)) {
                tempArr = arg.split("=");
                builder.setDebitCardAmount(Double.parseDouble(tempArr[1]));

            } else if(arg.matches(DISCOUNT_TEMPLATE)){
                tempArr = arg.split("=");
                builder.setDiscountCardNumber(Integer.parseInt(tempArr[1]));
            } else if (arg.matches(SAVE_TO_FILE)) {
                tempArr = arg.split("=");
                ConfigurationApp.getInstance().setSaveTo(tempArr[1]);
            } else if (arg.matches(DS_URL)) {
                tempArr = arg.split("=");
                ConfigurationApp.getInstance().setDsURL(tempArr[1]);
            } else if (arg.matches(DS_USERNAME)) {
                tempArr = arg.split("=");
                ConfigurationApp.getInstance().setDsUsername(tempArr[1]);
            } else {
                tempArr = arg.split("=");
                ConfigurationApp.getInstance().setDsPassword(tempArr[1]);
            }
        }
        Logger.info("validate finish successful");
        return builder.build();
    }
}
