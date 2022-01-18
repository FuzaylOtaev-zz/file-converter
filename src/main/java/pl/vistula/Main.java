package pl.vistula;

import pl.vistula.controller.Controller;
import pl.vistula.model.ConvertFileRequest;
import pl.vistula.service.FileService;
import pl.vistula.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConvertFileRequest request = new ConvertFileRequest();
        View view = new View();

        Controller controller = new Controller(request, view);
        controller.init();
    }
}
