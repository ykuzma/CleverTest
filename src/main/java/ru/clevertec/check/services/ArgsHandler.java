package main.java.ru.clevertec.check.services;

import main.java.ru.clevertec.check.models.OrderData;

public class ArgsHandler implements ArgParser<OrderData>, ValidationService<String[]> {
    private final String ID_TEMPLATE = "\\d{1,19}-\\d{1,10}";
    private final String DISCOUNT_TEMPLATE = "discountCard=\\d{4}";
    private final String DEBIT_CARD_TEMPLATE = "balanceDebitCard=-{0,1}\\d{1,19}(\\.\\d{2}){0,1}";


    @Override
    public boolean validate(String[] params) {
        int bank = 0;
        int discount = 0;
        int id = 0;

        for (String s: params) {
            if(s.matches(ID_TEMPLATE)) {
                bank++;
            } else if (s.matches(DISCOUNT_TEMPLATE)) {
                discount++;
            }else if(s.matches(DEBIT_CARD_TEMPLATE)){
                id++;
            }else {
                return false;
            }
            if(bank > 1 || discount > 1) return false;
        }

        return id != 0 && bank != 0;
    }

    @Override
    public OrderData parse(String[] args) {
        if(args.length == 0 || validate(args))
            throw new NoParametersException("Bad request");

        String[] tempArr;
        //todo interface
        OrderDataBuilder builder = new OrderDataBuilder();
        for (String arg : args) {

            if(arg.matches(ID_TEMPLATE)) {
                tempArr = arg.split("-");
                long key = Integer.parseInt(tempArr[0]);
                int value = Integer.parseInt(tempArr[1]);
                builder.setProduct(key, value);
            } else if (arg.matches(DEBIT_CARD_TEMPLATE)) {
                tempArr = arg.split("=");
                builder.setDebitCardAmount(Double.parseDouble(tempArr[1]));

            }else {
                tempArr = arg.split("=");
                builder.setDiscountCardNumber(Integer.parseInt(tempArr[1]));
            }
        }
        return builder.build();
    }
}
