package pl.vistula.controller;

import pl.vistula.model.ConvertFileRequest;
import pl.vistula.service.FileService;
import pl.vistula.view.View;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Controller {

    private final ConvertFileRequest convertFileRequest;
    private final View view;

    public Controller(ConvertFileRequest convertFileRequest, View view) {
        this.convertFileRequest = convertFileRequest;
        this.view = view;
    }

    public void init() {
        view.getChooseSourceBtn().addActionListener(e -> {
            view.getSourceFileChooser().showOpenDialog(view);
            File file = view.getSourceFileChooser().getSelectedFile();
            if (file != null) {
                convertFileRequest.setSourceFile(view.getSourceFileChooser().getSelectedFile().getPath());
            }
        });

        view.getChooseDestinationBtn().addActionListener(e -> {
            view.getDestinationFileChooser().showSaveDialog(view);
            File file = view.getDestinationFileChooser().getSelectedFile();
            if (file != null) {
                convertFileRequest.setDestinationFile(file.getPath());
            }
        });

        view.getComboBox().addActionListener(e -> {
            convertFileRequest.setFileFormat(String.valueOf(view.getComboBox().getSelectedItem()));
        });

        view.getSubmitBtn().addActionListener(e -> {
            try {
                FileService.convertAndSaveFile(convertFileRequest);
                JOptionPane.showMessageDialog(view, "file is saved.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "failed to save file");
            }
        });
    }
}
