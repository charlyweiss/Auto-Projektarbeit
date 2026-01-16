import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;


public class Main extends JFrame {

    private final List<Auto> AutoListe = new ArrayList<>();

    private void refreshList() {
        listModel.clear();
        for (Auto a : AutoListe) {
            listModel.addElement(a);
        }
    }

    // GUI-Elemente
    private final JTextField tfMarke = new JTextField(12);
    private final JTextField tfModell = new JTextField(12);
    private final JTextField tfPreis = new JTextField(12);
    private final JTextField tfPS = new JTextField(12);
    private final JCheckBox cbEAuto = new JCheckBox("EAuto");


    private final DefaultListModel<Auto> listModel = new DefaultListModel<>();
    private final JList<Auto> autoList = new JList<>(listModel) ;

    public Main() {
        setTitle("Auto");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initObjekte();
        initGUI();
        refreshList();

        setVisible(true);
    }

    public void initObjekte() {
        AutoListe.add(new Auto("Audi", "A5", 190, 45000, false));
        AutoListe.add(new Auto("Tesla", "Model 3", 283, 40000, true));
        AutoListe.add(new Auto("Porsche", "911 Turbo S", 650, 285000, false));
    }

    private void initGUI() {
        // ===== Formular (links) =====
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 0;
        form.add(new JLabel("Marke"), c);

        c.gridx = 1;
        form.add(tfMarke, c);

        c.gridx = 0;
        c.gridy = 1;
        form.add(new JLabel("Modell"), c);

        c.gridx = 1;
        form.add(tfModell, c);

        c.gridx = 0;
        c.gridy = 2;
        form.add(new JLabel("PS"), c);

        c.gridx = 1;
        form.add(tfPS, c);

        c.gridx = 0;
        c.gridy = 3;
        form.add(new JLabel("Preis"), c);
        c.gridx = 1;
        form.add(tfPreis, c);

        c.gridx = 0;
        c.gridy = 4;
        form.add(new JLabel("EAuto"), c);
        c.gridx = 1;
        form.add(cbEAuto, c);


        JButton btnSpeichern = new JButton("Speichern");

        c.gridx = 1;
        c.gridy = 5;
        form.add(btnSpeichern, c);

        // ===== Liste (rechts) =====
        autoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(autoList);

        // ===== Layout im Fenster =====
        setLayout(new BorderLayout(10, 10));
        add(form, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);

        // ===== Button-Logik =====
        btnSpeichern.addActionListener(e -> speichern());
    }

    private void speichern() {
        String marke = tfMarke.getText().trim();
        String modell = tfModell.getText().trim();

        // Eingabe prüfen (Exception Handling)
        if (tfMarke.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Marke darf nicht leer sein.");
            return;
        }
        int ps;
        double preis;
        try {
            ps = Integer.parseInt(tfPS.getText().trim());
            preis = Double.parseDouble(tfPreis.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "PS und Preis muss eine Zahl sein.");
            return;
        }

        boolean eAuto = cbEAuto.isSelected();

        // Objekt erzeugen + in Liste speichern
        Auto neu = new Auto(marke, modell, ps, preis, eAuto);
        AutoListe.add(neu);
        refreshList();

        // GUI aktualisieren + Felder leeren
        refreshList();
        tfMarke.setText("");
        tfModell.setText("");
        tfPreis.setText("");
        tfPS.setText("");
        cbEAuto.setSelected(false);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
        }
}
