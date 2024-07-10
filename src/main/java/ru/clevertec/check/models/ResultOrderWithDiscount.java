package main.java.ru.clevertec.check.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ResultOrderWithDiscount extends ResultOrder{

    private final DiscountCard discountCard;

    public ResultOrderWithDiscount(LocalDate date, LocalTime time, List<OrderLine> line,
                                   TotalLine totalLine, DiscountCard discountCard) {
        super(date, time, line, totalLine);
        this.discountCard = discountCard;
    }

    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ResultOrderWithDiscount that = (ResultOrderWithDiscount) o;
        return Objects.equals(discountCard, that.discountCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountCard);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        sb.append("Date;Time")
                .append("\n")
                .append(String.format("%s;%s", dateFormatter.format(date), timeFormatter.format(time)))
                .append("\n\n")
                .append("QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL").append("\n");

        lines.forEach((line) -> sb.append(String.format(Locale.ROOT,"%d;%s;%.2f$;%.2f$;%.2f$\n",
                line.getQty(), line.getProductDescription(),
                line.getPrice(), line.getDiscount(), line.getTotalPrice())));

        sb.append("\nDISCOUNT CARD;DISCOUNT PERCENTAGE\n")
                .append(String.format("%04d;%d%s\n", discountCard.getNumber(), discountCard.getDiscount_amount(), "%"))
                .append("\nTOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT\n")
                .append(String.format(Locale.ROOT, "%.2f$;%.2f$;%.2f$",
                        totalLine.getTotalPrice(),
                        totalLine.getTotalDiscount(),
                        totalLine.getTotalWithDiscount()));

        return sb.toString();
    }

    public static class Builder extends ResultOrder.Builder {

        private DiscountCard discountCard;

        @Override
        public ResultOrderWithDiscount build() {
            return new ResultOrderWithDiscount(LocalDate.now(), LocalTime.now(),
                    getLines(),  createTotalLine(), getDiscountCard());
        }

        public Builder setDiscountCard(DiscountCard discountCard) {
            this.discountCard = discountCard;
            return this;
        }

        @Override
        public Builder setLine(List<OrderLine> lines) {
            super.setLine(lines);
            return this;
        }

        public DiscountCard getDiscountCard() {
            return discountCard;
        }
    }



}
