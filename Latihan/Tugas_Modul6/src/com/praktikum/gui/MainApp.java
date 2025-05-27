package com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainApp extends Application {

    private Stage primaryStage;
    private ObservableList<String[]> mahasiswaReports = FXCollections.observableArrayList();
    private ObservableList<String> adminReports = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPane();
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.show();
    }

    public void showLoginPane() {
        LoginPane loginPane = new LoginPane(this);
        Scene scene = new Scene(loginPane, 400, 250);
        primaryStage.setScene(scene);
    }

    public void showMahasiswaDashboard(String username) {
        MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard(this, username, mahasiswaReports);
        Scene scene = new Scene(mahasiswaDashboard, 600, 400);
        primaryStage.setScene(scene);
    }

    public void showAdminDashboard() {
        AdminDashboard adminDashboard = new AdminDashboard(this, adminReports);
        Scene scene = new Scene(adminDashboard, 600, 400);
        primaryStage.setScene(scene);
    }

    // Method untuk menambahkan laporan dari MahasiswaDashboard
    public void addReport(String[] report) {
        mahasiswaReports.add(report);
        // Format string untuk adminReports: "NamaBarang - Lokasi - Status"
        String status = "Reported";
        String adminReport = report[0] + " - " + report[2] + " - " + status;
        adminReports.add(adminReport);
    }

    // Method untuk update status laporan di adminReports
    public void updateAdminReportStatus(int index, String newStatus) {
        if (index >= 0 && index < adminReports.size()) {
            String oldReport = adminReports.get(index);
            // Format: "NamaBarang - Lokasi - Status"
            String[] parts = oldReport.split(" - ");
            if (parts.length == 3) {
                String updatedReport = parts[0] + " - " + parts[1] + " - " + newStatus;
                adminReports.set(index, updatedReport);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
