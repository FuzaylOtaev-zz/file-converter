package pl.vistula.service;

import pl.vistula.adapter.CarAdapter;
import pl.vistula.factory.Serializer;
import pl.vistula.factory.SerializerFactory;
import pl.vistula.model.Car;
import pl.vistula.model.ConvertFileRequest;
import pl.vistula.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static void convertAndSaveFile(ConvertFileRequest request) throws IOException {
        List<Vehicle> vehicles = readVehiclesFromFile(request.getSourceFile());
        if (vehicles.isEmpty())
            return;

        SerializerFactory factory = new SerializerFactory(request.getFileFormat());
        Serializer serializer = factory.getSerializer();
        String fileContent = serializer.serialize(vehicles);

        saveFile(request.getDestinationFile(), fileContent, request.getFileFormat());
    }

    private static List<Vehicle> readVehiclesFromFile(String sourceFile) throws IOException {
        Path path = Paths.get(sourceFile);
        List<String> lines = Files.readAllLines(path);

        List<Vehicle> vehicles = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split("\t");

            Car car = new Car();
            car.setDate(values[0]);
            car.setTime(values[1]);
            car.setSpeed(Double.parseDouble(values[2]));
            car.setDistance(Double.parseDouble(values[3]));
            car.setDescription(values[4]);

            vehicles.add(new CarAdapter(car));
        }

        return vehicles;
    }

    private static void saveFile(String path, String content, String format) {
        String fullFilePath = path + "." + format;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullFilePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
