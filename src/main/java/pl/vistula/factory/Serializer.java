package pl.vistula.factory;

import pl.vistula.model.Car;
import pl.vistula.model.Vehicle;

import java.util.List;

public interface Serializer {
    String serialize(List<Vehicle> cars);
}
