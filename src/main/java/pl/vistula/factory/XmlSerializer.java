package pl.vistula.factory;

import pl.vistula.model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class XmlSerializer implements Serializer {
    private static final String XML_BEGINNING = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<cars>\n";
    private static final String XML_END = "</cars>\n";

    @Override
    public String serialize(List<Vehicle> vehicles) {
        String values = vehicles.stream()
                .map(vehicle -> "\t<car>\n" +
                            "\t\t<date>" + vehicle.getDate() + "</date>\n" +
                            "\t\t<time>" + vehicle.getTime() + "</time>\n" +
                            "\t\t<speed>" + vehicle.getSpeed() + "</speed>\n" +
                            "\t\t<distance>" + vehicle.getDistance() + "</distance>\n" +
                            "\t\t<description>" + vehicle.getDescription() + "</description>\n" +
                        "\t</car>\n")
                .collect(Collectors.joining());

        return XML_BEGINNING + values + XML_END;
    }
}
