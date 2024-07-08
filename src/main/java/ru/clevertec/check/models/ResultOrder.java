package main.java.ru.clevertec.check.models;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class ResultOrder {

    private final LocalDate date;
    private final LocalTime time;
    private final List<OrderLine> lines;
    private final TotalLine totalLine;

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
        return "ResultOrder{" +
                "date=" + date +
                ", time=" + time +
                ", line=" + lines +
                ", totalLine=" + totalLine +
                '}';
    }


    public void print() {
        System.out.println(this);
    }


    public void save(FileOutputStream fos) {
        new PrintWriter(fos).print(this);
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
}
