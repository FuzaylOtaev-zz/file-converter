package pl.vistula.adapter;

import pl.vistula.model.Car;
import pl.vistula.model.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarAdapter implements Vehicle {
    private final Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/dd/MM");
        Date date = null;
        try {
            date = format.parse(car.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");

        return outputFormat.format(date);
    }

    public String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss aa");
        Date date = null;
        try {
            date = format.parse(car.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        return outputFormat.format(date);
    }

    public Double getSpeed() {
        return car.getSpeed() / 1.151;
    }

    public Double getDistance() {
        return car.getDistance() / 1.151;
    }

    public String getDescription() {
        return car.getDescription();
    }
}
