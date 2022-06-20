package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;

    private SpinnerNumberModel husySpinnerNumberModel;
    private SpinnerNumberModel kraliciSpinnerNumberModel;

    private JTextField pocetHlavTextFiled;
    private JTextField pocetNohouTextField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husySpinnerNumberModel = new SpinnerNumberModel(0,0,null,1);

        husySpinner = new JSpinner(husySpinnerNumberModel);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('h');
        husyLabel.setLabelFor(husySpinner);

        add(husyLabel);
        add(husySpinner);

        kraliciSpinnerNumberModel = new SpinnerNumberModel(0, 0, null, 1);

        kraliciSpinner = new JSpinner(kraliciSpinnerNumberModel);
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setDisplayedMnemonic('m');
        kraliciLabel.setLabelFor(kraliciSpinner);

        add(kraliciLabel);
        add(kraliciSpinner);

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('v');

        add(vypocitatButton, "center, span");

        vypocitatButton.addActionListener(this :: handleVypocitat);

        pocetHlavTextFiled = new JTextField();
        pocetHlavTextFiled.setEnabled(false);
        pocetHlavTextFiled.setHorizontalAlignment(JTextField.TRAILING);

        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavTextFiled);

        add(pocetHlavTextFiled);
        add(pocetHlavLabel);

        pocetNohouTextField = new JTextField();
        pocetNohouTextField.setEnabled(false);
        pocetHlavTextFiled.setHorizontalAlignment(JTextField.TRAILING);

        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouTextField);

        add(pocetNohouTextField);
        add(pocetNohouLabel);

        pack();
    }

    private void handleVypocitat (ActionEvent actionEvent) {

        int husy = (Integer) husySpinner.getValue();
        int kralici = (Integer) kraliciSpinner.getValue();

        pocetHlavTextFiled.setText(Integer.toString(husy + kralici));
        pocetNohouTextField.setText(Integer.toString(husy*2 + kralici*4));
    }

}
