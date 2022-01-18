package pl.vistula.factory;

import pl.vistula.exception.FileFormatException;

public class SerializerFactory {
    private final String format;

    public SerializerFactory(String format) {
        this.format = format;
    }

    public Serializer getSerializer() {
        if ("csv".equals(format)) {
            return new CsvSerializer();
        }
        if ("xml".equals(format)) {
            return new XmlSerializer();
        }

        throw new FileFormatException("invalid file format");
    }
}
