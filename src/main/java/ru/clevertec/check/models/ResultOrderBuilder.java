package main.java.ru.clevertec.check.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ResultOrderBuilder {
    private  List<OrderLine> lines;

    public ResultOrder build(){
        return new ResultOrder(LocalDate.now(), LocalTime.now(), getLines(), createTotalLine());
    }


    protected ResultOrder.TotalLine createTotalLine() {
        double totalPrice = 0;
        double totalDiscount = 0;
        for (OrderLine line:lines) {
            totalDiscount += line.getDiscount();
            totalPrice += line.getTotalPrice();
        }
        double totalWithDiscount = totalPrice - totalDiscount;
        return new ResultOrder.TotalLine(totalPrice, totalDiscount, totalWithDiscount);
    }

    public ResultOrderBuilder setLine(List<OrderLine> lines) {
        this.lines = lines;
        return this;
    }

    public List<OrderLine> getLines() {
        return lines;
    }
}
