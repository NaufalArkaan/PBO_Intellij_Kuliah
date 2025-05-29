package com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdminDashboard extends VBox {
    private MainApp mainApp;

    public AdminDashboard(MainApp mainApp, ObservableList<String[]> adminReports) {
        this.mainApp = mainApp;

        this.setPadding(new Insets(20));
        this.setSpacing(10);

        Label welcomeLabel = new Label("Halo, Administrator admin");

        //---------------------------------
        // LEFT: Laporan Barang
        //---------------------------------
        Label laporanLabel = new Label("Laporan Barang");

        // kalau memang mau ListView + TableView, tapi biasanya cukup TableView saja
        ObservableList<String[]> laporanData = FXCollections.observableArrayList(
                new String[]{"Dompet", "Kelas B101", "Belum Diambil"},
                new String[]{"Kunci", "Parkiran", "Belum Diambil"}
        );
        TableView<String[]> laporanTable = new TableView<>(adminReports);
        laporanTable.setPrefSize(400, 300);

        TableColumn<String[], String> lapNamaCol = new TableColumn<>("Nama");
        lapNamaCol.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[0]));
        TableColumn<String[], String> lapLokasiCol = new TableColumn<>("Lokasi");
        lapLokasiCol.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[1]));
        TableColumn<String[], String> lapStatusCol = new TableColumn<>("Status");
        lapStatusCol.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[2]));
        laporanTable.getColumns().addAll(lapNamaCol, lapLokasiCol, lapStatusCol);

        Button markClaimedBtn = new Button("Tandai Claimed");
        markClaimedBtn.setOnAction(e -> {
            int i = laporanTable.getSelectionModel().getSelectedIndex();
            if (i >= 0) {
                String[] row = laporanTable.getItems().get(i);
                row[2] = "Claimed";
                laporanTable.refresh();
            }
        });

        VBox leftBox = new VBox(5, laporanLabel, laporanTable, markClaimedBtn);
        leftBox.setPadding(new Insets(0, 10, 0, 0));


        //---------------------------------
        // RIGHT: Data Mahasiswa
        //---------------------------------
        Label mhsLabel = new Label("Data Mahasiswa");

        ObservableList<String[]> mahasiswaData = FXCollections.observableArrayList(
                new String[]{"Ken Aryo", "202310370311006"},
                new String[]{"Wira Yudha", "202310370311010"}
        );
        TableView<String[]> mhsTable = new TableView<>(mahasiswaData);
        mhsTable.setPrefSize(400, 300);

        TableColumn<String[], String> mhsNamaCol = new TableColumn<>("Nama");
        mhsNamaCol.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[0]));
        TableColumn<String[], String> mhsNimCol = new TableColumn<>("NIM");
        mhsNimCol.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[1]));
        mhsTable.getColumns().addAll(mhsNamaCol, mhsNimCol);

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");
        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambah");
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText().trim();
            String nim  = nimField.getText().trim();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                mahasiswaData.add(new String[]{nama, nim});
                namaField.clear();
                nimField.clear();
                mainApp.setMahasiswaData(mahasiswaData);
            }
        });

        Button hapusBtn = new Button("Hapus");
        hapusBtn.setOnAction(e -> {
            int i = mhsTable.getSelectionModel().getSelectedIndex();
            if (i >= 0) {
                mahasiswaData.remove(i);
                mainApp.setMahasiswaData(mahasiswaData);
            }
        });

        HBox mhsInputBox = new HBox(5, namaField, nimField, tambahBtn, hapusBtn);
        VBox rightBox = new VBox(5, mhsLabel, mhsTable, mhsInputBox);
        rightBox.setPadding(new Insets(0, 0, 0, 10));


        //---------------------------------
        // Gabungkan kiri+kanan jadi horizontal
        //---------------------------------
        HBox mainContent = new HBox(10, leftBox, rightBox);

        //---------------------------------
        // Tombol Logout dan Welcome
        //---------------------------------
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> mainApp.showLoginPane());

        // Tambahkan semua ke root VBox
        this.getChildren().addAll(
                welcomeLabel,
                mainContent,
                logoutBtn
        );
    }
}
