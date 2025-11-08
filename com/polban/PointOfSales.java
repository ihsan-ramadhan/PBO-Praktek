package com.polban;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.Locale;


public class PointOfSales extends JFrame {
    private static final String WARNING_TITLE = "Peringatan";

    private JTable produkTable;
    private DefaultTableModel keranjangModel;
    private JSpinner qtySpinner;
    private JLabel selectedProductLabel;
    private JLabel totalLabel;
    private JLabel pointsLabel;
    private JTextArea strukArea;
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton printButton;

    private String selectedId;
    private String selectedNama;
    private int selectedHarga;
    private double currentTotal = 0.0;
    
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public PointOfSales() {
        initUI();
        initListeners();
    }

    private void initUI() {
        setTitle("Point Of Sales - Java Swing");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        JPanel leftPanel = new JPanel(new BorderLayout());

        leftPanel.add(new JLabel("Produk"), BorderLayout.NORTH);
        String[] produkCols = {"ID", "Nama Produk", "Harga (Rp)"};
        Object[][] produkData = {
                {"P001", "Air Mineral 600ml", 3000},
                {"P002", "Kopi Sachet", 5000},
                {"P003", "Roti isi", 8000},
                {"P004", "Snack Keripik", 6000},
                {"P005", "Minuman Botol", 12000}
        };
        produkTable = new JTable(produkData, produkCols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        produkTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        leftPanel.add(new JScrollPane(produkTable), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        selectedProductLabel = new JLabel("Pilih produk dari tabel di kiri");
        inputPanel.add(selectedProductLabel);
        inputPanel.add(new JLabel("Qty:"));
        qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        qtySpinner.setPreferredSize(new Dimension(50, 20));
        inputPanel.add(qtySpinner);
        addToCartButton = new JButton("Add to Cart");
        inputPanel.add(addToCartButton);
        leftPanel.add(inputPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());

        JPanel keranjangPanel = new JPanel(new BorderLayout());
        keranjangPanel.add(new JLabel("Keranjang"), BorderLayout.NORTH);
        String[] keranjangCols = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        keranjangModel = new DefaultTableModel(keranjangCols, 0);
        JTable keranjangTable = new JTable(keranjangModel) {
            @Override
             public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        keranjangPanel.add(new JScrollPane(keranjangTable), BorderLayout.CENTER);

        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalLabel = new JLabel("Total: Rp0,00");
        pointsLabel = new JLabel("Points: 0");
        totalPanel.add(totalLabel);
        totalPanel.add(pointsLabel);
        checkoutPanel.add(totalPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkoutButton = new JButton("Checkout");
        printButton = new JButton("Cetak");
        buttonPanel.add(checkoutButton);
        buttonPanel.add(printButton);
        checkoutPanel.add(buttonPanel);

        JPanel strukPanel = new JPanel(new BorderLayout());
        strukPanel.add(new JLabel("Struk:"), BorderLayout.NORTH);
        strukArea = new JTextArea(10, 30);
        strukArea.setEditable(false);
        strukArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        strukPanel.add(new JScrollPane(strukArea), BorderLayout.CENTER);
        checkoutPanel.add(strukPanel);

        rightPanel.add(keranjangPanel, BorderLayout.CENTER);
        rightPanel.add(checkoutPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(500);
        add(splitPane, BorderLayout.CENTER);
    }

    private void initListeners() {
        produkTable.getSelectionModel().addListSelectionListener(this::handleProductSelection);

        addToCartButton.addActionListener(e -> handleAddToCart());

        checkoutButton.addActionListener(e -> handleCheckout());

        printButton.addActionListener(e -> handlePrint());
    }

    private void handleProductSelection(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = produkTable.getSelectedRow();
            if (selectedRow != -1) {
                selectedId = produkTable.getValueAt(selectedRow, 0).toString();
                selectedNama = produkTable.getValueAt(selectedRow, 1).toString();
                selectedHarga = (int) produkTable.getValueAt(selectedRow, 2);
                
                String selectedText = String.format("Dipilih: %s-%s (%s)", 
                    selectedId, selectedNama, currencyFormatter.format(selectedHarga));
                selectedProductLabel.setText(selectedText);
            }
        }
    }

    private void handleAddToCart() {
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "...", WARNING_TITLE, JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qty = (int) qtySpinner.getValue();
        double subtotal = (double) selectedHarga * qty;

        for (int i = 0; i < keranjangModel.getRowCount(); i++) {
            if (keranjangModel.getValueAt(i, 0).equals(selectedId)) {
                int currentQty = (int) keranjangModel.getValueAt(i, 2);
                int newQty = currentQty + qty;
                double newSubtotal = (double)selectedHarga * newQty;

                keranjangModel.setValueAt(newQty, i, 2);
                keranjangModel.setValueAt(newSubtotal, i, 4);
                
                updateTotal();
                qtySpinner.setValue(1);
                return;
            }
        }

        keranjangModel.addRow(new Object[]{selectedId, selectedNama, qty, selectedHarga, subtotal});
        updateTotal();
        qtySpinner.setValue(1);
    }
    
    private void updateTotal() {
        currentTotal = 0.0;
        for (int i = 0; i < keranjangModel.getRowCount(); i++) {
            currentTotal += (double) keranjangModel.getValueAt(i, 4);
        }

        int points = (int) (currentTotal / 1000);

        totalLabel.setText(String.format("Total: %s", currencyFormatter.format(currentTotal)));
        pointsLabel.setText(String.format("Points: %d", points));
    }

    private void handleCheckout() {
        if (keranjangModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "...", WARNING_TITLE, JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("     ===== POINT OF SALES =====\n");
        sb.append("     Toko: Demo Toko\n");
        sb.append("---------------------------------------\n");

        for (int i = 0; i < keranjangModel.getRowCount(); i++) {
            String id = keranjangModel.getValueAt(i, 0).toString();
            String nama = keranjangModel.getValueAt(i, 1).toString();
            int qty = (int) keranjangModel.getValueAt(i, 2);
            double sub = (double) keranjangModel.getValueAt(i, 4);
            
            sb.append(String.format("%s %s %d %s%n", id, nama, qty, currencyFormatter.format(sub)));
        }
        
        int points = (int) (currentTotal / 1000);

        sb.append("---------------------------------------\n");
        sb.append(String.format("TOTAL:%n%s%n", currencyFormatter.format(currentTotal)));
        sb.append(String.format("POINTS DIDAPAT: %d (1 point per Rp 1000)%n", points));
        sb.append("\n");
        sb.append("   Terima kasih! Silakan kunjungi kembali.\n");

        strukArea.setText(sb.toString());

        keranjangModel.setRowCount(0);
        updateTotal();
    }

    private void handlePrint() {
        if (strukArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "...", WARNING_TITLE, JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean didPrint = strukArea.print();
            if (didPrint) {
                JOptionPane.showMessageDialog(this, "Struk telah dikirim ke printer.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Error saat mencetak: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PointOfSales frame = new PointOfSales();
            frame.setVisible(true);
        });
    }
}