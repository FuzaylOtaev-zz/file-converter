package pl.vistula.view;

import javax.swing.*;

public class View extends JFrame {
    private JFileChooser sourceFileChooser;
    private JFileChooser destinationFileChooser;
    private JComboBox<String> comboBox;

    private JButton chooseSourceBtn;
    private JButton chooseDestinationBtn;
    private JButton submitBtn;

    public View() {
        sourceFileChooser = new JFileChooser();
        chooseSourceBtn = new JButton("Source");

        chooseDestinationBtn = new JButton("Destination");
        destinationFileChooser = new JFileChooser();

        submitBtn = new JButton("Submit");

        comboBox = new JComboBox<>(new String[] {"csv", "xml"});

        JPanel panel = new JPanel();
        panel.add(chooseSourceBtn);
        panel.add(chooseDestinationBtn);
        panel.add(comboBox);
        panel.add(submitBtn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

        this.add(panel);

        this.setVisible(true);
    }

    public JFileChooser getSourceFileChooser() {
        return sourceFileChooser;
    }

    public JFileChooser getDestinationFileChooser() {
        return destinationFileChooser;
    }

    public JButton getChooseSourceBtn() {
        return chooseSourceBtn;
    }

    public JButton getChooseDestinationBtn() {
        return chooseDestinationBtn;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }
}
