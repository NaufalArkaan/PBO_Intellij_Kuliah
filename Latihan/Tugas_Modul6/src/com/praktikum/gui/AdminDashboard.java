package com.praktikum.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;

public class AdminDashboard extends VBox {
    private MainApp mainApp;
    private ObservableList<String> adminReports;

    public AdminDashboard(MainApp mainApp, ObservableList<String> adminReports) {
        this.mainApp = mainApp;
        this.adminReports = adminReports;

        this.setPadding(new Insets(20));
        this.setSpacing(10);

        Label welcomeLabel = new Label("Halo, Administrator admin");

        ListView<String> reportList = new ListView<>(adminReports);

        Button markClaimedButton = new Button("Tandai Claimed");
        markClaimedButton.setOnAction(e -> {
            int selectedIndex = reportList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                String selected = adminReports.get(selectedIndex);
                if (!selected.contains("Claimed")) {
                    mainApp.updateAdminReportStatus(selectedIndex, "Claimed");
                }
            }
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> mainApp.showLoginPane());

        this.getChildren().addAll(
                welcomeLabel,
                reportList,
                markClaimedButton,
                logoutButton
        );
    }
}
