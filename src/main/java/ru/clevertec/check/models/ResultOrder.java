package main.java.ru.clevertec.check.models;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ResultOrder implements ResultHandler{

    protected final LocalDate date;
    protected final LocalTime time;
    protected final List<OrderLine> lines;
    protected final TotalLine totalLine;

    public ResultOrder(LocalDate date, LocalTime time, List<OrderLine> lines, TotalLine totalLine) {
        this.date = date;
        this.time = time;
        this.lines = lines;
        this.totalLine = totalLine;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public TotalLine getTotalLine() {
        return totalLine;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOrder that = (ResultOrder) o;
        return Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(lines, that.lines) && Objects.equals(totalLine, that.totalLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, lines, totalLine);
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

        lines.forEach((line) ->{
            sb.append(String.format(Locale.ROOT,"%d;%s;%.2f$;%.2f$;%.2f$\n",
                    line.getQty(), line.getProductDescription(),
                    line.getPrice(), line.getDiscount(), line.getTotalPrice()));
        });

        sb.append("\nTOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT\n")
                .append(String.format(Locale.ROOT, "%.2f$;%.2f$;%.2f$",
                        totalLine.getTotalPrice(),
                        totalLine.getTotalDiscount(),
                        totalLine.getTotalWithDiscount()));



        return sb.toString();
    }
    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public void save(OutputStream fos) {

      PrintWriter pr = new PrintWriter(fos);
      pr.print(this);
      pr.flush();
    }



    public static class TotalLine {
        private final double totalPrice;
        private final double totalDiscount;
        private final double totalWithDiscount;

        public TotalLine(double totalPrice, double totalDiscount, double totalWithDiscount) {
            this.totalPrice = totalPrice;
            this.totalDiscount = totalDiscount;
            this.totalWithDiscount = totalWithDiscount;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public double getTotalDiscount() {
            return totalDiscount;
        }

        public double getTotalWithDiscount() {
            return totalWithDiscount;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TotalLine totalLine = (TotalLine) o;
            return Double.compare(totalLine.totalPrice, totalPrice) == 0 && Double.compare(totalLine.totalDiscount, totalDiscount) == 0 && Double.compare(totalLine.totalWithDiscount, totalWithDiscount) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(totalPrice, totalDiscount, totalWithDiscount);
        }

        @Override
        public String toString() {
            return "TotalLine{" +
                    "totalPrice=" + totalPrice +
                    ", totalDiscount=" + totalDiscount +
                    ", totalWithDiscount=" + totalWithDiscount +
                    '}';
        }
    }

    public static class Builder {
        private  List<OrderLine> lines;

        public ResultOrder build(){
            return new ResultOrder(LocalDate.now(), LocalTime.now(), getLines(), createTotalLine());
        }


        protected TotalLine createTotalLine() {
            double totalPrice = 0;
            double totalDiscount = 0;
            for (OrderLine line:lines) {
                totalDiscount += line.getDiscount();
                totalPrice += line.getTotalPrice();
            }
            double totalWithDiscount = totalPrice - totalDiscount;
            return new TotalLine(totalPrice, totalDiscount, totalWithDiscount);
        }

        public Builder setLine(List<OrderLine> lines) {
            this.lines = lines;
            return this;
        }

        public List<OrderLine> getLines() {
            return lines;
        }
    }
}
