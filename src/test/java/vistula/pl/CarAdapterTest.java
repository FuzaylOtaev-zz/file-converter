package vistula.pl;

import org.junit.jupiter.api.Test;
import pl.vistula.adapter.CarAdapter;
import pl.vistula.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarAdapterTest {

    @Test
    void testCarAdapter() {
        Car car = new Car();
        car.setSpeed(11.51D);
        car.setDistance(11.51D);
        car.setDate("2021/01/10");
        car.setTime("08:20:30 PM");
        car.setDescription("Good car");

        CarAdapter adapter = new CarAdapter(car);

        assertEquals("01.10.2021", adapter.getDate());
        assertEquals("20:20:30", adapter.getTime());
        assertEquals(10, adapter.getDistance());
        assertEquals(10, adapter.getSpeed());
        assertEquals("Good car", adapter.getDescription());
    }
}
