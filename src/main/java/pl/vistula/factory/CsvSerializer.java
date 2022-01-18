package pl.vistula.factory;

import pl.vistula.adapter.CarAdapter;
import pl.vistula.model.Car;
import pl.vistula.model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class CsvSerializer implements Serializer {
    private static final String HEADERS = "Date,Time,Speed,Distance,Description\n";

    @Override
    public String serialize(List<Vehicle> vehicles) {
        String values = vehicles.stream()
                .map(vehicle -> vehicle.getDate() + "," +
                        vehicle.getTime() + "," +
                        vehicle.getSpeed() + "," +
                        vehicle.getDistance() + "," +
                        vehicle.getDescription() + "\n")
                .collect(Collectors.joining());

        return HEADERS + values;
    }
}
