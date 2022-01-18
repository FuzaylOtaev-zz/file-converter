package vistula.pl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.vistula.adapter.CarAdapter;
import pl.vistula.factory.CsvSerializer;
import pl.vistula.factory.XmlSerializer;
import pl.vistula.model.Car;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializerTest {

    Car car = null;

    @BeforeEach
    void initCar() {
        car = new Car();
        car.setSpeed(11.51D);
        car.setDistance(11.51D);
        car.setDate("2021/01/10");
        car.setTime("08:20:30 PM");
        car.setDescription("Good car");
    }

    @Test
    void testCsvSerializer() {
        CsvSerializer serializer = new CsvSerializer();
        String csv = serializer.serialize(Collections.singletonList(new CarAdapter(car)));

        assertEquals(
                "Date,Time,Speed,Distance,Description\n01.10.2021,20:20:30,10.0,10.0,Good car\n",
                csv
        );
    }

    @Test
    void testXmlSerializer() {
        XmlSerializer serializer = new XmlSerializer();
        String xml = serializer.serialize(Collections.singletonList(new CarAdapter(car)));

        assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<cars>\n" +
                            "\t<car>\n" +
                                "\t\t<date>01.10.2021</date>\n" +
                                "\t\t<time>20:20:30</time>\n" +
                                "\t\t<speed>10.0</speed>\n" +
                                "\t\t<distance>10.0</distance>\n" +
                                "\t\t<description>Good car</description>\n" +
                            "\t</car>\n" +
                        "</cars>\n",
                xml
        );
    }
}
