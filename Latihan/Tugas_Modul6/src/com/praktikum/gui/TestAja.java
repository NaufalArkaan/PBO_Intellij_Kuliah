package com.praktikum.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestAja extends Application {

    private Stage primaryStage;

    // Simulasi data laporan barang (nama barang, lokasi, status, pemilik)
    private List<ItemReport> reports = new ArrayList<>();

    // Simulasi data user mahasiswa (username, password)
    private final String mahasiswaUsername = "nisrina";
    private final String mahasiswaPassword = "12345";

    // Simulasi data admin (username, password)
    private final String adminUsername = "admin";
    private final String adminPassword = "admin";

    private String currentUser = null; // Menyimpan username yang login

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPane();
    }

    // Tampilan Login
    private void showLoginPane() {
        Label labelRole = new Label("Login Sistem Lost & Found");
        ComboBox<String> roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Mahasiswa", "Admin");
        roleCombo.setValue("Mahasiswa");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label messageLabel = new Label();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String role = roleCombo.getValue();
            String username = usernameField.getText().trim();
            String password = passwordField.getText();

            if (role.equals("Mahasiswa")) {
                if (username.equals(mahasiswaUsername) && password.equals(mahasiswaPassword)) {
                    currentUser = username;
                    showMahasiswaDashboard(username);
                } else {
                    messageLabel.setText("Login gagal, periksa kredensial.");
                }
            } else if (role.equals("Admin")) {
                if (username.equals(adminUsername) && password.equals(adminPassword)) {
                    currentUser = username;
                    showAdminDashboard();
                } else {
                    messageLabel.setText("Login gagal, periksa kredensial.");
                }
            }
        });

        VBox vbox = new VBox(10, labelRole, roleCombo, usernameField, passwordField, loginButton, messageLabel);
        vbox.setPadding(new Insets(20));
        vbox.setPrefWidth(300);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lost & Found Kampus - Login");
        primaryStage.show();
    }

    // Dashboard Mahasiswa
    private void showMahasiswaDashboard(String username) {
        Label welcomeLabel = new Label("Selamat datang, " + username);

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Nama Barang");

        TextField itemDescField = new TextField();
        itemDescField.setPromptText("Deskripsi Barang");

        TextField itemLocationField = new TextField();
        itemLocationField.setPromptText("Lokasi Barang");

        Button reportButton = new Button("Laporkan");

        ListView<String> reportList = new ListView<>();
        refreshMahasiswaReportList(reportList, username);

        reportButton.setOnAction(e -> {
            String itemName = itemNameField.getText().trim();
            String itemDesc = itemDescField.getText().trim();
            String itemLocation = itemLocationField.getText().trim();

            if (itemName.isEmpty() || itemLocation.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Input tidak lengkap", "Nama barang dan lokasi harus diisi.");
                return;
            }

            // Tambah laporan baru
            reports.add(new ItemReport(itemName, itemDesc, itemLocation, "Reported", username));
            refreshMahasiswaReportList(reportList, username);

            // Bersihkan field input
            itemNameField.clear();
            itemDescField.clear();
            itemLocationField.clear();
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            currentUser = null;
            showLoginPane();
        });

        VBox vbox = new VBox(10,
                welcomeLabel,
                itemNameField,
                itemDescField,
                itemLocationField,
                reportButton,
                new Label("Daftar Laporan Anda:"),
                reportList,
                logoutButton);
        vbox.setPadding(new Insets(20));
        vbox.setPrefWidth(400);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard Mahasiswa");
    }

    // Refresh daftar laporan mahasiswa
    private void refreshMahasiswaReportList(ListView<String> listView, String username) {
        listView.getItems().clear();
        for (ItemReport report : reports) {
            if (report.getOwner().equals(username)) {
                listView.getItems().add(report.toString());
            }
        }
    }

    // Dashboard Admin
    private void showAdminDashboard() {
        Label welcomeLabel = new Label("Halo, Administrator " + currentUser);

        ListView<String> reportList = new ListView<>();
        refreshAdminReportList(reportList);

        Button markClaimedButton = new Button("Tandai Claimed");
        markClaimedButton.setOnAction(e -> {
            int selectedIndex = reportList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                ItemReport selectedReport = reports.get(selectedIndex);
                if (!selectedReport.getStatus().equals("Claimed")) {
                    selectedReport.setStatus("Claimed");
                    refreshAdminReportList(reportList);
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Pilih laporan", "Silakan pilih laporan untuk ditandai.");
            }
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            currentUser = null;
            showLoginPane();
        });

        VBox vbox = new VBox(10, welcomeLabel, reportList, markClaimedButton, logoutButton);
        vbox.setPadding(new Insets(20));
        vbox.setPrefWidth(400);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard Admin");
    }

    // Refresh daftar laporan untuk admin
    private void refreshAdminReportList(ListView<String> listView) {
        listView.getItems().clear();
        for (ItemReport report : reports) {
            listView.getItems().add(report.toString());
        }
    }

    // Utility untuk menampilkan alert
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Kelas internal untuk menyimpan data laporan barang
    private static class ItemReport {
        private String name;
        private String description;
        private String location;
        private String status;
        private String owner;

        public ItemReport(String name, String description, String location, String status, String owner) {
            this.name = name;
            this.description = description;
            this.location = location;
            this.status = status;
            this.owner = owner;
        }

        public String getStatus() {
            return status;
        }

        public String getOwner() {
            return owner;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return name + " - " + location + " - " + status;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

