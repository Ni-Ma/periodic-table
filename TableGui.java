/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodictable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class will build the periodic table. It adds the functionality for each
 * button allowing them to open a window displaying the data of each element.
 * The constructor places each button. The handler calls the Element constructor
 * and passes it the necessary information based on which button(element) is
 * selected.
 *
 * @author nmartin
 */
public class TableGui {

    Element element;
    Text phaseTxt;
    Text meltTxt;
    Text boilTxt;
    Text fusionTxt;
    Text vaporTxt;

    public TableGui(GridPane grid) {
 
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));

        grid.setStyle("-fx-background-color: #001018;");

        /*
        *Construct buttons and add them to the GridPane
         */
        //Row 1 of the table
        Button btnH = new Button("1\nH");
        btnH.setId("H");
        btnH.setStyle("-fx-base: #bf2b00; "
                + "-fx-font: bold 13 Georgia;");
        btnH.setPrefSize(45, 45);
        grid.add(btnH, 1, 1);
        btnH.setOnAction(myHandler);

        Button btnHe = new Button("2\nHe");
        btnHe.setId("He");
        btnHe.setStyle("-fx-base: #005c2b; "
                + "-fx-font: bold 13 Georgia");
        btnHe.setPrefSize(45, 45);
        grid.add(btnHe, 18, 1);
        btnHe.setOnAction(myHandler);

        //Row 2 of the table
        Button btnLi = new Button("3\nLi");
        btnLi.setId("Li");
        btnLi.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnLi.setPrefSize(45, 45);
        grid.add(btnLi, 1, 2);
        btnLi.setOnAction(myHandler);

        Button btnBe = new Button("4\nBe");
        btnBe.setId("Be");
        btnBe.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnBe.setPrefSize(45, 45);
        grid.add(btnBe, 2, 2);
        btnBe.setOnAction(myHandler);

        Button btnB = new Button("5\nB");
        btnB.setId("B");
        btnB.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnB.setPrefSize(45, 45);
        grid.add(btnB, 13, 2);
        btnB.setOnAction(myHandler);

        Button btnC = new Button("6\nC");
        btnC.setId("C");
        btnC.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnC.setPrefSize(45, 45);
        grid.add(btnC, 14, 2);
        btnC.setOnAction(myHandler);

        Button btnN = new Button("7\nN");
        btnN.setId("N");
        btnN.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnN.setPrefSize(45, 45);
        grid.add(btnN, 15, 2);
        btnN.setOnAction(myHandler);

        Button btnO = new Button("8\nO");
        btnO.setId("O");
        btnO.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnO.setPrefSize(45, 45);
        grid.add(btnO, 16, 2);
        btnO.setOnAction(myHandler);

        Button btnF = new Button("9\nF");
        btnF.setId("F");
        btnF.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnF.setPrefSize(45, 45);
        grid.add(btnF, 17, 2);
        btnF.setOnAction(myHandler);

        Button btnNe = new Button("10\nNe");
        btnNe.setId("Ne");
        btnNe.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnNe.setPrefSize(45, 45);
        grid.add(btnNe, 18, 2);
        btnNe.setOnAction(myHandler);

        //Row 3 of the table
        Button btnNa = new Button("11\nNa");
        btnNa.setId("Na");
        btnNa.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnNa.setPrefSize(45, 45);
        grid.add(btnNa, 1, 3);
        btnNa.setOnAction(myHandler);

        Button btnMg = new Button("12\nMg");
        btnMg.setId("Mg");
        btnMg.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnMg.setPrefSize(45, 45);
        grid.add(btnMg, 2, 3);
        btnMg.setOnAction(myHandler);

        Button btnAl = new Button("13\nAl");
        btnAl.setId("Al");
        btnAl.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnAl.setPrefSize(45, 45);
        grid.add(btnAl, 13, 3);
        btnAl.setOnAction(myHandler);

        Button btnSi = new Button("14\nSi");
        btnSi.setId("Si");
        btnSi.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnSi.setPrefSize(45, 45);
        grid.add(btnSi, 14, 3);
        btnSi.setOnAction(myHandler);

        Button btnP = new Button("15\nP");
        btnP.setId("P");
        btnP.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnP.setPrefSize(45, 45);
        grid.add(btnP, 15, 3);
        btnP.setOnAction(myHandler);

        Button btnS = new Button("16\nS");
        btnS.setId("S");
        btnS.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnS.setPrefSize(45, 45);
        grid.add(btnS, 16, 3);
        btnS.setOnAction(myHandler);

        Button btnCl = new Button("17\nCl");
        btnCl.setId("Cl");
        btnCl.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnCl.setPrefSize(45, 45);
        grid.add(btnCl, 17, 3);
        btnCl.setOnAction(myHandler);

        Button btnAr = new Button("18\nAr");
        btnAr.setId("Ar");
        btnAr.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnAr.setPrefSize(45, 45);
        grid.add(btnAr, 18, 3);
        btnAr.setOnAction(myHandler);

        //Row 4 of the table
        Button btnK = new Button("19\nK");
        btnK.setId("K");
        btnK.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnK.setPrefSize(45, 45);
        grid.add(btnK, 1, 4);
        btnK.setOnAction(myHandler);

        Button btnCa = new Button("20\nCa");
        btnCa.setId("Ca");
        btnCa.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnCa.setPrefSize(45, 45);
        grid.add(btnCa, 2, 4);
        btnCa.setOnAction(myHandler);

        Button btnSc = new Button("21\nSc");
        btnSc.setId("Sc");
        btnSc.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnSc.setPrefSize(45, 45);
        grid.add(btnSc, 3, 4);
        btnSc.setOnAction(myHandler);

        Button btnTi = new Button("22\nTi");
        btnTi.setId("Ti");
        btnTi.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnTi.setPrefSize(45, 45);
        grid.add(btnTi, 4, 4);
        btnTi.setOnAction(myHandler);

        Button btnV = new Button("23\nV");
        btnV.setId("V");
        btnV.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnV.setPrefSize(45, 45);
        grid.add(btnV, 5, 4);
        btnV.setOnAction(myHandler);

        Button btnCr = new Button("24\nCr");
        btnCr.setId("Cr");
        btnCr.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnCr.setPrefSize(45, 45);
        grid.add(btnCr, 6, 4);
        btnCr.setOnAction(myHandler);

        Button btnMn = new Button("25\nMn");
        btnMn.setId("Mn");
        btnMn.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnMn.setPrefSize(45, 45);
        grid.add(btnMn, 7, 4);
        btnMn.setOnAction(myHandler);

        Button btnFe = new Button("26\nFe");
        btnFe.setId("Fe");
        btnFe.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnFe.setPrefSize(45, 45);
        grid.add(btnFe, 8, 4);
        btnFe.setOnAction(myHandler);

        Button btnCo = new Button("27\nCo");
        btnCo.setId("Co");
        btnCo.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnCo.setPrefSize(45, 45);
        grid.add(btnCo, 9, 4);
        btnCo.setOnAction(myHandler);

        Button btnNi = new Button("28\nNi");
        btnNi.setId("Ni");
        btnNi.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnNi.setPrefSize(45, 45);
        grid.add(btnNi, 10, 4);
        btnNi.setOnAction(myHandler);

        Button btnCu = new Button("29\nCu");
        btnCu.setId("Cu");
        btnCu.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnCu.setPrefSize(45, 45);
        grid.add(btnCu, 11, 4);
        btnCu.setOnAction(myHandler);

        Button btnZn = new Button("30\nZn");
        btnZn.setId("Zn");
        btnZn.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnZn.setPrefSize(45, 45);
        grid.add(btnZn, 12, 4);
        btnZn.setOnAction(myHandler);

        Button btnGa = new Button("31\nGa");
        btnGa.setId("Ga");
        btnGa.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnGa.setPrefSize(45, 45);
        grid.add(btnGa, 13, 4);
        btnGa.setOnAction(myHandler);

        Button btnGe = new Button("32\nGe");
        btnGe.setId("Ge");
        btnGe.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnGe.setPrefSize(45, 45);
        grid.add(btnGe, 14, 4);
        btnGe.setOnAction(myHandler);

        Button btnAs = new Button("33\nAs");
        btnAs.setId("As");
        btnAs.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnAs.setPrefSize(45, 45);
        grid.add(btnAs, 15, 4);
        btnAs.setOnAction(myHandler);

        Button btnSe = new Button("34\nSe");
        btnSe.setId("Se");
        btnSe.setStyle("-fx-base: #bf2b00;"
                + "-fx-font: bold 13 Georgia");
        btnSe.setPrefSize(45, 45);
        grid.add(btnSe, 16, 4);
        btnSe.setOnAction(myHandler);

        Button btnBr = new Button("35\nBr");
        btnBr.setId("Br");
        btnBr.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnBr.setPrefSize(45, 45);
        grid.add(btnBr, 17, 4);
        btnBr.setOnAction(myHandler);

        Button btnKr = new Button("36\nKr");
        btnKr.setId("Kr");
        btnKr.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnKr.setPrefSize(45, 45);
        grid.add(btnKr, 18, 4);
        btnKr.setOnAction(myHandler);

        //Row 5 of the table
        Button btnRb = new Button("37\nRb");
        btnRb.setId("Rb");
        btnRb.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnRb.setPrefSize(45, 45);
        grid.add(btnRb, 1, 5);
        btnRb.setOnAction(myHandler);

        Button btnSr = new Button("38\nSr");
        btnSr.setId("Sr");
        btnSr.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnSr.setPrefSize(45, 45);
        grid.add(btnSr, 2, 5);
        btnSr.setOnAction(myHandler);

        Button btnY = new Button("39\nY");
        btnY.setId("Y");
        btnY.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnY.setPrefSize(45, 45);
        grid.add(btnY, 3, 5);
        btnY.setOnAction(myHandler);

        Button btnZr = new Button("40\nZr");
        btnZr.setId("Zr");
        btnZr.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnZr.setPrefSize(45, 45);
        grid.add(btnZr, 4, 5);
        btnZr.setOnAction(myHandler);

        Button btnNb = new Button("41\nNb");
        btnNb.setId("Nb");
        btnNb.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnNb.setPrefSize(45, 45);
        grid.add(btnNb, 5, 5);
        btnNb.setOnAction(myHandler);

        Button btnMo = new Button("42\nMo");
        btnMo.setId("Mo");
        btnMo.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnMo.setPrefSize(45, 45);
        grid.add(btnMo, 6, 5);
        btnMo.setOnAction(myHandler);

        Button btnTc = new Button("43\nTc");
        btnTc.setId("Tc");
        btnTc.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnTc.setPrefSize(45, 45);
        grid.add(btnTc, 7, 5);
        btnTc.setOnAction(myHandler);

        Button btnRu = new Button("44\nRu");
        btnRu.setId("Ru");
        btnRu.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnRu.setPrefSize(45, 45);
        grid.add(btnRu, 8, 5);
        btnRu.setOnAction(myHandler);

        Button btnRh = new Button("45\nRh");
        btnRh.setId("Rh");
        btnRh.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnRh.setPrefSize(45, 45);
        grid.add(btnRh, 9, 5);
        btnRh.setOnAction(myHandler);

        Button btnPd = new Button("46\nPd");
        btnPd.setId("Pd");
        btnPd.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnPd.setPrefSize(45, 45);
        grid.add(btnPd, 10, 5);
        btnPd.setOnAction(myHandler);

        Button btnAg = new Button("47\nAg");
        btnAg.setId("Ag");
        btnAg.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnAg.setPrefSize(45, 45);
        grid.add(btnAg, 11, 5);
        btnAg.setOnAction(myHandler);

        Button btnCd = new Button("48\nCd");
        btnCd.setId("Cd");
        btnCd.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnCd.setPrefSize(45, 45);
        grid.add(btnCd, 12, 5);
        btnCd.setOnAction(myHandler);

        Button btnIn = new Button("49\nIn");
        btnIn.setId("In");
        btnIn.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnIn.setPrefSize(45, 45);
        grid.add(btnIn, 13, 5);
        btnIn.setOnAction(myHandler);

        Button btnSn = new Button("50\nSn");
        btnSn.setId("Sn");
        btnSn.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnSn.setPrefSize(45, 45);
        grid.add(btnSn, 14, 5);
        btnSn.setOnAction(myHandler);

        Button btnSb = new Button("51\nSb");
        btnSb.setId("Sb");
        btnSb.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnSb.setPrefSize(45, 45);
        grid.add(btnSb, 15, 5);
        btnSb.setOnAction(myHandler);

        Button btnTe = new Button("52\nTe");
        btnTe.setId("Te");
        btnTe.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnTe.setPrefSize(45, 45);
        grid.add(btnTe, 16, 5);
        btnTe.setOnAction(myHandler);

        Button btnI = new Button("53\nI");
        btnI.setId("I");
        btnI.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnI.setPrefSize(45, 45);
        grid.add(btnI, 17, 5);
        btnI.setOnAction(myHandler);

        Button btnXe = new Button("54\nXe");
        btnXe.setId("Xe");
        btnXe.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnXe.setPrefSize(45, 45);
        grid.add(btnXe, 18, 5);
        btnXe.setOnAction(myHandler);

        //Row 6 of the table
        Button btnCs = new Button("55\nCs");
        btnCs.setId("Cs");
        btnCs.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnCs.setPrefSize(45, 45);
        grid.add(btnCs, 1, 6);
        btnCs.setOnAction(myHandler);

        Button btnBa = new Button("56\nBa");
        btnBa.setId("Ba");
        btnBa.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnBa.setPrefSize(45, 45);
        grid.add(btnBa, 2, 6);
        btnBa.setOnAction(myHandler);

        Button btnHf = new Button("72\nHf");
        btnHf.setId("Hf");
        btnHf.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnHf.setPrefSize(45, 45);
        grid.add(btnHf, 4, 6);
        btnHf.setOnAction(myHandler);

        Button btnTa = new Button("73\nTa");
        btnTa.setId("Ta");
        btnTa.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnTa.setPrefSize(45, 45);
        grid.add(btnTa, 5, 6);
        btnTa.setOnAction(myHandler);

        Button btnW = new Button("74\nW");
        btnW.setId("W");
        btnW.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnW.setPrefSize(45, 45);
        grid.add(btnW, 6, 6);
        btnW.setOnAction(myHandler);

        Button btnRe = new Button("75\nRe");
        btnRe.setId("Re");
        btnRe.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnRe.setPrefSize(45, 45);
        grid.add(btnRe, 7, 6);
        btnRe.setOnAction(myHandler);

        Button btnOs = new Button("76\nOs");
        btnOs.setId("Os");
        btnOs.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnOs.setPrefSize(45, 45);
        grid.add(btnOs, 8, 6);
        btnOs.setOnAction(myHandler);

        Button btnIr = new Button("77\nIr");
        btnIr.setId("Ir");
        btnIr.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnIr.setPrefSize(45, 45);
        grid.add(btnIr, 9, 6);
        btnIr.setOnAction(myHandler);

        Button btnPt = new Button("78\nPt");
        btnPt.setId("Pt");
        btnPt.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnPt.setPrefSize(45, 45);
        grid.add(btnPt, 10, 6);
        btnPt.setOnAction(myHandler);

        Button btnAu = new Button("79\nAu");
        btnAu.setId("Au");
        btnAu.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnAu.setPrefSize(45, 45);
        grid.add(btnAu, 11, 6);
        btnAu.setOnAction(myHandler);

        Button btnHg = new Button("80\nHg");
        btnHg.setId("Hg");
        btnHg.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnHg.setPrefSize(45, 45);
        grid.add(btnHg, 12, 6);
        btnHg.setOnAction(myHandler);

        Button btnTl = new Button("81\nTl");
        btnTl.setId("Tl");
        btnTl.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnTl.setPrefSize(45, 45);
        grid.add(btnTl, 13, 6);
        btnTl.setOnAction(myHandler);

        Button btnPb = new Button("82\nPb");
        btnPb.setId("Pb");
        btnPb.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnPb.setPrefSize(45, 45);
        grid.add(btnPb, 14, 6);
        btnPb.setOnAction(myHandler);

        Button btnBi = new Button("83\nBi");
        btnBi.setId("Bi");
        btnBi.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnBi.setPrefSize(45, 45);
        grid.add(btnBi, 15, 6);
        btnBi.setOnAction(myHandler);

        Button btnPo = new Button("84\nPo");
        btnPo.setId("Po");
        btnPo.setStyle("-fx-base: #ff6235;"
                + "-fx-font: bold 13 Georgia");
        btnPo.setPrefSize(45, 45);
        grid.add(btnPo, 16, 6);
        btnPo.setOnAction(myHandler);

        Button btnAt = new Button("85\nAt");
        btnAt.setId("At");
        btnAt.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnAt.setPrefSize(45, 45);
        grid.add(btnAt, 17, 6);
        btnAt.setOnAction(myHandler);

        Button btnRn = new Button("86\nRn");
        btnRn.setId("Rn");
        btnRn.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnRn.setPrefSize(45, 45);
        grid.add(btnRn, 18, 6);
        btnRn.setOnAction(myHandler);

        //Row 7 of the table
        Button btnFr = new Button("87\nFr");
        btnFr.setId("Fr");
        btnFr.setStyle("-fx-base: #065179;"
                + "-fx-font: bold 13 Georgia");
        btnFr.setPrefSize(45, 45);
        grid.add(btnFr, 1, 7);
        btnFr.setOnAction(myHandler);

        Button btnRa = new Button("88\nRa");
        btnRa.setId("Ra");
        btnRa.setStyle("-fx-base: #821d00;"
                + "-fx-font: bold 13 Georgia");
        btnRa.setPrefSize(45, 45);
        grid.add(btnRa, 2, 7);
        btnRa.setOnAction(myHandler);

        Button btnRf = new Button("104\nRf");
        btnRf.setId("Rf");
        btnRf.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnRf.setPrefSize(45, 45);
        grid.add(btnRf, 4, 7);
        btnRf.setOnAction(myHandler);

        Button btnDb = new Button("105\nDb");
        btnDb.setId("Db");
        btnDb.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnDb.setPrefSize(45, 45);
        grid.add(btnDb, 5, 7);
        btnDb.setOnAction(myHandler);

        Button btnSg = new Button("106\nSg");
        btnSg.setId("Sg");
        btnSg.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnSg.setPrefSize(45, 45);
        grid.add(btnSg, 6, 7);
        btnSg.setOnAction(myHandler);

        Button btnBh = new Button("107\nBh");
        btnBh.setId("Bh");
        btnBh.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnBh.setPrefSize(45, 45);
        grid.add(btnBh, 7, 7);
        btnBh.setOnAction(myHandler);

        Button btnHs = new Button("108\nHs");
        btnHs.setId("Hs");
        btnHs.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnHs.setPrefSize(45, 45);
        grid.add(btnHs, 8, 7);
        btnHs.setOnAction(myHandler);

        Button btnMt = new Button("109\nMt");
        btnMt.setId("Mt");
        btnMt.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnMt.setPrefSize(45, 45);
        grid.add(btnMt, 9, 7);
        btnMt.setOnAction(myHandler);

        Button btnDs = new Button("110\nDs");
        btnDs.setId("Ds");
        btnDs.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnDs.setPrefSize(45, 45);
        grid.add(btnDs, 10, 7);
        btnDs.setOnAction(myHandler);

        Button btnRg = new Button("111\nRg");
        btnRg.setId("Rg");
        btnRg.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnRg.setPrefSize(45, 45);
        grid.add(btnRg, 11, 7);
        btnRg.setOnAction(myHandler);

        Button btnCn = new Button("112\nCn");
        btnCn.setId("Cn");
        btnCn.setStyle("-fx-base: #ff8b00;"
                + "-fx-font: bold 13 Georgia");
        btnCn.setPrefSize(45, 45);
        grid.add(btnCn, 12, 7);
        btnCn.setOnAction(myHandler);

        Button btnNh = new Button("113\nNh");
        btnNh.setId("Nh");
        btnNh.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnNh.setPrefSize(45, 45);
        grid.add(btnNh, 13, 7);
        btnNh.setOnAction(myHandler);

        Button btnFl = new Button("114\nFl");
        btnFl.setId("Fl");
        btnFl.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnFl.setPrefSize(45, 45);
        grid.add(btnFl, 14, 7);
        btnFl.setOnAction(myHandler);

        Button btnMc = new Button("115\nMc");
        btnMc.setId("Mc");
        btnMc.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnMc.setPrefSize(45, 45);
        grid.add(btnMc, 15, 7);
        btnMc.setOnAction(myHandler);

        Button btnLv = new Button("116\nLv");
        btnLv.setId("Lv");
        btnLv.setStyle("-fx-base: #0b98e4;"
                + "-fx-font: bold 13 Georgia");
        btnLv.setPrefSize(45, 45);
        grid.add(btnLv, 16, 7);
        btnLv.setOnAction(myHandler);

        Button btnTs = new Button("117\nTs");
        btnTs.setId("Ts");
        btnTs.setStyle("-fx-base: #00ea6c;"
                + "-fx-font: bold 13 Georgia");
        btnTs.setPrefSize(45, 45);
        grid.add(btnTs, 17, 7);
        btnTs.setOnAction(myHandler);

        Button btnOg = new Button("118\nOg");
        btnOg.setId("Og");
        btnOg.setStyle("-fx-base: #005c2b;"
                + "-fx-font: bold 13 Georgia");
        btnOg.setPrefSize(45, 45);
        grid.add(btnOg, 18, 7);
        btnOg.setOnAction(myHandler);

        //elements 57-71 and 89-103
        Button btnLa = new Button("57\nLa");
        btnLa.setId("La");
        btnLa.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnLa.setPrefSize(45, 45);
        grid.add(btnLa, 4, 20);
        btnLa.setOnAction(myHandler);

        Button btnCe = new Button("58\nCe");
        btnCe.setId("Ce");
        btnCe.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnCe.setPrefSize(45, 45);
        grid.add(btnCe, 5, 20);
        btnCe.setOnAction(myHandler);

        Button btnPr = new Button("59\nPr");
        btnPr.setId("Pr");
        btnPr.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnPr.setPrefSize(45, 45);
        grid.add(btnPr, 6, 20);
        btnPr.setOnAction(myHandler);

        Button btnNd = new Button("60\nNd");
        btnNd.setId("Nd");
        btnNd.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnNd.setPrefSize(45, 45);
        grid.add(btnNd, 7, 20);
        btnNd.setOnAction(myHandler);

        Button btnPm = new Button("61\nPm");
        btnPm.setId("Pm");
        btnPm.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnPm.setPrefSize(45, 45);
        grid.add(btnPm, 8, 20);
        btnPm.setOnAction(myHandler);

        Button btnSm = new Button("62\nSm");
        btnSm.setId("Sm");
        btnSm.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnSm.setPrefSize(45, 45);
        grid.add(btnSm, 9, 20);
        btnSm.setOnAction(myHandler);

        Button btnEu = new Button("63\nEu");
        btnEu.setId("Eu");
        btnEu.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnEu.setPrefSize(45, 45);
        grid.add(btnEu, 10, 20);
        btnEu.setOnAction(myHandler);

        Button btnGd = new Button("64\nGd");
        btnGd.setId("Gd");
        btnGd.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnGd.setPrefSize(45, 45);
        grid.add(btnGd, 11, 20);
        btnGd.setOnAction(myHandler);

        Button btnTb = new Button("65\nTb");
        btnTb.setId("Tb");
        btnTb.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnTb.setPrefSize(45, 45);
        grid.add(btnTb, 12, 20);
        btnTb.setOnAction(myHandler);

        Button btnDy = new Button("66\nDy");
        btnDy.setId("Dy");
        btnDy.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnDy.setPrefSize(45, 45);
        grid.add(btnDy, 13, 20);
        btnDy.setOnAction(myHandler);

        Button btnHo = new Button("67\nHo");
        btnHo.setId("Ho");
        btnHo.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnHo.setPrefSize(45, 45);
        grid.add(btnHo, 14, 20);
        btnHo.setOnAction(myHandler);

        Button btnEr = new Button("68\nEr");
        btnEr.setId("Er");
        btnEr.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnEr.setPrefSize(45, 45);
        grid.add(btnEr, 15, 20);
        btnEr.setOnAction(myHandler);

        Button btnTm = new Button("69\nTm");
        btnTm.setId("Tm");
        btnTm.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnTm.setPrefSize(45, 45);
        grid.add(btnTm, 16, 20);
        btnTm.setOnAction(myHandler);

        Button btnYb = new Button("70\nYb");
        btnYb.setId("Yb");
        btnYb.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnYb.setPrefSize(45, 45);
        grid.add(btnYb, 17, 20);
        btnYb.setOnAction(myHandler);

        Button btnLu = new Button("71\nLu");
        btnLu.setId("Lu");
        btnLu.setStyle("-fx-base: #824700;"
                + "-fx-font: bold 13 Georgia");
        btnLu.setPrefSize(45, 45);
        grid.add(btnLu, 18, 20);
        btnLu.setOnAction(myHandler);

        Button btnAc = new Button("89\nAc");
        btnAc.setId("Ac");
        btnAc.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnAc.setPrefSize(45, 45);
        grid.add(btnAc, 4, 21);
        btnAc.setOnAction(myHandler);

        Button btnTh = new Button("90\nTh");
        btnTh.setId("Th");
        btnTh.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnTh.setPrefSize(45, 45);
        grid.add(btnTh, 5, 21);
        btnTh.setOnAction(myHandler);

        Button btnPa = new Button("91\nPa");
        btnPa.setId("Pa");
        btnPa.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnPa.setPrefSize(45, 45);
        grid.add(btnPa, 6, 21);
        btnPa.setOnAction(myHandler);

        Button btnU = new Button("92\nU");
        btnU.setId("U");
        btnU.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnU.setPrefSize(45, 45);
        grid.add(btnU, 7, 21);
        btnU.setOnAction(myHandler);

        Button btnNp = new Button("93\nNp");
        btnNp.setId("Np");
        btnNp.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnNp.setPrefSize(45, 45);
        grid.add(btnNp, 8, 21);
        btnNp.setOnAction(myHandler);

        Button btnPu = new Button("94\nPu");
        btnPu.setId("Pu");
        btnPu.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnPu.setPrefSize(45, 45);
        grid.add(btnPu, 9, 21);
        btnPu.setOnAction(myHandler);

        Button btnAm = new Button("95\nAm");
        btnAm.setId("Am");
        btnAm.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnAm.setPrefSize(45, 45);
        grid.add(btnAm, 10, 21);
        btnAm.setOnAction(myHandler);

        Button btnCm = new Button("96\nCm");
        btnCm.setId("Cm");
        btnCm.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnCm.setPrefSize(45, 45);
        grid.add(btnCm, 11, 21);
        btnCm.setOnAction(myHandler);

        Button btnBk = new Button("97\nBk");
        btnBk.setId("Bk");
        btnBk.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnBk.setPrefSize(45, 45);
        grid.add(btnBk, 12, 21);
        btnBk.setOnAction(myHandler);

        Button btnCf = new Button("98\nCf");
        btnCf.setId("Cf");
        btnCf.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnCf.setPrefSize(45, 45);
        grid.add(btnCf, 13, 21);
        btnCf.setOnAction(myHandler);

        Button btnEs = new Button("99\nEs");
        btnEs.setId("Es");
        btnEs.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnEs.setPrefSize(45, 45);
        grid.add(btnEs, 14, 21);
        btnEs.setOnAction(myHandler);

        Button btnFm = new Button("100\nFm");
        btnFm.setId("Fm");
        btnFm.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnFm.setPrefSize(45, 45);
        grid.add(btnFm, 15, 21);
        btnFm.setOnAction(myHandler);

        Button btnMd = new Button("101\nMd");
        btnMd.setId("Md");
        btnMd.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnMd.setPrefSize(45, 45);
        grid.add(btnMd, 16, 21);
        btnMd.setOnAction(myHandler);

        Button btnNo = new Button("102\nNo");
        btnNo.setId("No");
        btnNo.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnNo.setPrefSize(45, 45);
        grid.add(btnNo, 17, 21);
        btnNo.setOnAction(myHandler);

        Button btnLr = new Button("103\nLr");
        btnLr.setId("Lr");
        btnLr.setStyle("-fx-base: #ffa335;"
                + "-fx-font: bold 13 Georgia");
        btnLr.setPrefSize(45, 45);
        grid.add(btnLr, 18, 21);
        btnLr.setOnAction(myHandler);

        Label[] periods = new Label[18];

        for (int i = 0; i < 18; i++) {
            periods[i] = new Label(i + 1 + "");
            periods[i].setAlignment(Pos.CENTER);
            periods[i].setTextFill(Color.WHITE);
            periods[i].setFont(new Font("Georgia", 18));
            periods[i].setPrefWidth(45);
            grid.add(periods[i], i + 1, 0);
        }

        Label[] groups = new Label[7];

        for (int i = 0; i < 7; i++) {
            groups[i] = new Label(i + 1 + "");
            groups[i].setAlignment(Pos.CENTER);
            groups[i].setTextFill(Color.WHITE);
            groups[i].setFont(new Font("Georgia", 18));
            groups[i].setPrefWidth(45);
            grid.add(groups[i], 0, i + 1);
        }

        /*
        * This portion creates the portion of the GUI which denotes what each color
        * means.  It builds a horizontal box containing one centered label.  This is then
        * placed into the grid pane.  The HBox is used because this was the only way to 
        * set a background color behind the text.
        */
        
        HBox metalloidsBox = new HBox();
        metalloidsBox.setPadding(new Insets(1, 1, 1, 1));
        metalloidsBox.setSpacing(1);
        metalloidsBox.setStyle("-fx-background-color: #ff6235");
        Label metalloidsLbl = new Label("Metalloids");
        metalloidsLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: BLACK");
        metalloidsLbl.setPrefSize(90, 35);
        metalloidsLbl.setAlignment(Pos.CENTER);
        metalloidsBox.getChildren().addAll(metalloidsLbl);
        grid.add(metalloidsBox, 3, 1, 2, 1);

        HBox otherNonBox = new HBox();
        otherNonBox.setPadding(new Insets(1, 1, 1, 1));
        otherNonBox.setSpacing(1);
        otherNonBox.setStyle("-fx-background-color: #bf2b00");
        Label otherNonLbl = new Label("Other Non-Metals");
        otherNonLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: WHITE");
        otherNonLbl.setPrefSize(90, 35);
        otherNonLbl.setAlignment(Pos.CENTER);
        otherNonLbl.setWrapText(true);
        otherNonBox.getChildren().addAll(otherNonLbl);
        grid.add(otherNonBox, 5, 1, 2, 1);

        HBox halogensBox = new HBox();
        halogensBox.setPadding(new Insets(1, 1, 1, 1));
        halogensBox.setSpacing(1);
        halogensBox.setStyle("-fx-background-color: #00ea6c");
        Label halogensLbl = new Label("Halogens");
        halogensLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: BLACK");
        halogensLbl.setPrefSize(90, 35);
        halogensLbl.setAlignment(Pos.CENTER);
        halogensBox.getChildren().addAll(halogensLbl);
        grid.add(halogensBox, 7, 1, 2, 1);

        HBox nobleBox = new HBox();
        nobleBox.setPadding(new Insets(1, 1, 1, 1));
        nobleBox.setSpacing(1);
        nobleBox.setStyle("-fx-background-color: #005c2b");
        Label nobleLbl = new Label("Nobel Gases");
        nobleLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: WHITE");
        nobleLbl.setPrefSize(90, 35);
        nobleLbl.setAlignment(Pos.CENTER);
        nobleBox.getChildren().addAll(nobleLbl);
        grid.add(nobleBox, 9, 1, 2, 1);

        HBox alkaliBox = new HBox();
        alkaliBox.setPadding(new Insets(1, 1, 1, 1));
        alkaliBox.setSpacing(1);
        alkaliBox.setStyle("-fx-background-color: #065179");
        Label alkaliLbl = new Label("Alkali Metals");
        alkaliLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: WHITE");
        alkaliLbl.setPrefSize(90, 35);
        alkaliLbl.setAlignment(Pos.CENTER);
        alkaliLbl.setWrapText(true);
        alkaliBox.getChildren().addAll(alkaliLbl);
        grid.add(alkaliBox, 11, 1, 2, 1);

        HBox earthBox = new HBox();
        earthBox.setPadding(new Insets(1, 1, 1, 1));
        earthBox.setSpacing(1);
        earthBox.setStyle("-fx-background-color: #821d00");
        Label earthLbl = new Label("Alkaline Earth Metals");
        earthLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: WHITE");
        earthLbl.setPrefSize(90, 35);
        earthLbl.setAlignment(Pos.CENTER);
        earthLbl.setWrapText(true);
        earthBox.getChildren().addAll(earthLbl);
        grid.add(earthBox, 3, 2, 2, 1);

        HBox lanthanoidsBox = new HBox();
        lanthanoidsBox.setPadding(new Insets(1, 1, 1, 1));
        lanthanoidsBox.setSpacing(1);
        lanthanoidsBox.setStyle("-fx-background-color: #824700");
        Label lanthanoidsLbl = new Label("Lanthanoids");
        lanthanoidsLbl.setStyle("-fx-font: bold 12 Georgia;"
                + "-fx-text-fill: WHITE");
        lanthanoidsLbl.setPrefSize(90, 35);
        lanthanoidsLbl.setAlignment(Pos.CENTER);
        lanthanoidsBox.getChildren().addAll(lanthanoidsLbl);
        grid.add(lanthanoidsBox, 5, 2, 2, 1);
        
        HBox actinoidsBox = new HBox();
        actinoidsBox.setPadding(new Insets(1, 1, 1, 1));
        actinoidsBox.setSpacing(1);
        actinoidsBox.setStyle("-fx-background-color: #ffa335");
        Label actinoidsLbl = new Label("Actinoids");
        actinoidsLbl.setStyle("-fx-font: bold 12 Georgia;");
        actinoidsLbl.setPrefSize(90, 35);
        actinoidsLbl.setAlignment(Pos.CENTER);
        actinoidsBox.getChildren().addAll(actinoidsLbl);
        grid.add(actinoidsBox, 7, 2, 2, 1);
        
        HBox transitionBox = new HBox();
        transitionBox.setPadding(new Insets(1, 1, 1, 1));
        transitionBox.setSpacing(1);
        transitionBox.setStyle("-fx-background-color: #ff8b00");
        Label transitionLbl = new Label("Transition Metals");
        transitionLbl.setStyle("-fx-font: bold 12 Georgia;");
        transitionLbl.setPrefSize(90, 35);
        transitionLbl.setAlignment(Pos.CENTER);
        transitionLbl.setWrapText(true);
        transitionBox.getChildren().addAll(transitionLbl);
        grid.add(transitionBox, 9, 2, 2, 1);
        
        HBox postBox = new HBox();
        postBox.setPadding(new Insets(1, 1, 1, 1));
        postBox.setSpacing(1);
        postBox.setStyle("-fx-background-color: #0b98e4");
        Label postLbl = new Label("Post Transition Metals");
        postLbl.setStyle("-fx-font: bold 11 Georgia;"
                + "-fx-text-fill: BLACK");
        postLbl.setPrefSize(90, 35);
        postLbl.setAlignment(Pos.CENTER);
        postLbl.setWrapText(true);
        postBox.getChildren().addAll(postLbl);
        grid.add(postBox, 11, 2, 2, 1);

    }

    /*
    * This method is used to determine actions to perform when a button is pressed.
    * It will build the second window and populate it with information based on what
    * button was selected.  It does this by instantiating the object of type Element.
    * This information is used by the various fields in the popup window to display
    * the information about the selected element.
     */
    final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            switch (((Control) event.getSource()).getId()) {
                case "H":
                    element = new Element("Hydrogen", 1, "gas", 13.99, 20.271, 0.904, 28.836);
                    break;
                case "He":
                    element = new Element("Helium", 2, "gas", 0.95, 4.222, 0.0138, 0.0829);
                    break;
                case "Li":
                    element = new Element("Lithium", 3, "solid", 453.65, 1603, 3.00, 136);
                    break;
                case "Be":
                    element = new Element("Beryllium", 4, "solid", 1560, 2742, 12.2, 292);
                    break;
                case "B":
                    element = new Element("Boron", 5, "solid", 2349, 4200, 50.2, 508);
                    break;
                case "C":
                    element = new Element("Carbon", 6, "solid", 3823, 4098, 105, 715);
                    break;
                case "N":
                    element = new Element("Nitrogen", 7, "gas", 63.15, 77.355, 0.72, 5.56);
                    break;
                case "O":
                    element = new Element("Oxygen", 8, "gas", 54.36, 90.188, 0.444, 6.82);
                    break;
                case "F":
                    element = new Element("Flourine", 9, "gas", 53.48, 85.03, 0.26, 3.27);
                    break;
                case "Ne":
                    element = new Element("Neon", 10, "gas", 24.56, 27.104, 0.335, 1.71);
                    break;
                case "Na":
                    element = new Element("Sodium", 11, "solid", 370.944, 1156.090, 2.60, 97.42);
                    break;
                case "Mg":
                    element = new Element("Magnesium", 12, "solid", 923, 1363, 8.48, 128);
                    break;
                case "Al":
                    element = new Element("Aluminum", 13, "solid", 933.47, 2743, 10.71, 284);
                    break;
                case "Si":
                    element = new Element("Silicon", 14, "solid", 1687, 3538, 50.21, 383);
                    break;
                case "P":
                    element = new Element("Phosphorus", 15, "solid", 317.3, 553.7, 0.66, 51.9);
                    break;
                case "S":
                    element = new Element("Sulfur", 16, "solid", 388.36, 717.8, 1.727, 45);
                    break;
                case "Cl":
                    element = new Element("Chlorine", 17, "gas", 171.6, 239.11, 6.406, 20.41);
                    break;
                case "Ar":
                    element = new Element("Argon", 18, "gas", 83.81, 87.302, 1.18, 6.53);
                    break;
                case "K":
                    element = new Element("Potassium", 19, "solid", 336.7, 1032, 2.33, 76.9);
                    break;
                case "Ca":
                    element = new Element("Calcium", 20, "solid", 1115, 1757, 154.7, 25.929);
                    break;
                case "Sc":
                    element = new Element("Scandium", 21, "solid", 1814, 3109, 14.1, 332.7);
                    break;
                case "Ti":
                    element = new Element("Titanium", 22, "solid", 1941, 3560, 14.15, 425);
                    break;
                case "V":
                    element = new Element("Vanadium", 23, "solid", 2183, 3680, 21.5, 444);
                    break;
                case "Cr":
                    element = new Element("Chromium", 24, "solid", 2180, 2944, 21, 347);
                    break;
                case "Mn":
                    element = new Element("Manganese", 25, "solid", 1519, 2334, 12.91, 221);
                    break;
                case "Fe":
                    element = new Element("Iron", 26, "solid", 1811, 3134, 13.81, 340);
                    break;
                case "Co":
                    element = new Element("Cobolt", 27, "solid", 1768, 3200, 16.06, 377);
                    break;
                case "Ni":
                    element = new Element("Nickle", 28, "solid", 1728, 3003, 17.48, 379);
                    break;
                case "Cu":
                    element = new Element("Copper", 29, "solid", 1357.77, 2835, 13.26, 300.4);
                    break;
                case "Zn":
                    element = new Element("Zinc", 30, "solid", 692.68, 1180, 7.32, 115);
                    break;
                case "Ga":
                    element = new Element("Gallium", 31, "solid", 302.9146, 2673, 5.59, 256);
                    break;
                case "Ge":
                    element = new Element("Germanium", 32, "solid", 1211.40, 3106, 36.94, 334);
                    break;
                case "As":
                    element = new Element("Arsenic", 33, "solid", 1090, 876, 24.44, 34.76);
                    break;
                case "Se":
                    element = new Element("Selenium", 34, "solid", 494, 958, 6.69, 95.48);
                    break;
                case "Br":
                    element = new Element("Bromine", 35, "liquid", 265.8, 332.0, 10.571, 29.96);
                    break;
                case "Kr":
                    element = new Element("Krypton", 36, "gas", 115.78, 119.93, 1.64, 9.08);
                    break;
                case "Rb":
                    element = new Element("Rubidium", 37, "solid", 312.45, 961, 2.19, 69);
                    break;
                case "Sr":
                    element = new Element("Strontium", 38, "solid", 1050, 1650, 7.43, 141);
                    break;
                case "Y":
                    element = new Element("Yttrium", 39, "solid", 1799, 3203, 11.42, 363);
                    break;
                case "Zr":
                    element = new Element("Zirconium", 40, "solid", 2128, 4650, 14, 591);
                    break;
                case "Nb":
                    element = new Element("Niobium", 41, "solid", 2750, 5017, 689.9, 24.60);
                    break;
                case "Mo":
                    element = new Element("Molybdenum", 42, "solid", 2896, 4912, 37.48, 598);
                    break;
                case "Tc":
                    element = new Element("Technetium", 43, "solid", 2430, 4538, 33.29, 585.2);
                    break;
                case "Ru":
                    element = new Element("Ruthenium", 44, "solid", 2607, 4423, 38.59, 619);
                    break;
                case "Rh":
                    element = new Element("Rhodium", 45, "solid", 2237, 3968, 26.59, 493);
                    break;
                case "Pd":
                    element = new Element("Palladium", 46, "solid", 1828.05, 3236, 16.74, 358);
                    break;
                case "Ag":
                    element = new Element("Silver", 47, "solid", 1234.98, 2435, 11.28, 254);
                    break;
                case "Cd":
                    element = new Element("Cadmium", 48, "solid", 594.22, 1040, 6.21, 99.87);
                    break;
                case "In":
                    element = new Element("Indium", 49, "solid", 429.7485, 2345, 3.281, 231.8);
                    break;
                case "Sn":
                    element = new Element("Tin", 50, "solid", 505.08, 2875, 7.03, 296.1);
                    break;
                case "Sb":
                    element = new Element("Atimony", 51, "solid", 903.78, 1908, 19.79, 193.43);
                    break;
                case "Te":
                    element = new Element("Tellurium", 52, "solid", 722.66, 1261, 17.49, 114.1);
                    break;
                case "I":
                    element = new Element("Iodine", 53, "solid", 386.85, 457.4, 15.52, 41.57);
                    break;
                case "Xe":
                    element = new Element("Xenon", 54, "gas", 161.40, 165.051, 2.27, 12.64);
                    break;
                case "Cs":
                    element = new Element("Caesium", 55, "solid", 301.7, 944, 2.09, 63.9);
                    break;
                case "Ba":
                    element = new Element("Barium", 56, "solid", 1000, 2118, 7.12, 142);
                    break;
                case "La":
                    element = new Element("Lanthanum", 57, "solid", 1193, 3737, 6.20, 400);
                    break;
                case "Ce":
                    element = new Element("Cerium", 58, "solid", 1068, 3716, 5.46, 398);
                    break;
                case "Pr":
                    element = new Element("Praseodymium", 59, "solid", 1208, 3403, 6.89, 331);
                    break;
                case "Nd":
                    element = new Element("Neodymium", 60, "solid", 1297, 3347, 7.14, 289);
                    break;
                case "Pm":
                    element = new Element("Prometheum", 61, "solid", 1315, 3273, 7.13, 289);
                    break;
                case "Sm":
                    element = new Element("Samarium", 62, "solid", 1345, 2173, 8.62, 192);
                    break;
                case "Eu":
                    element = new Element("Europium", 63, "solid", 1099, 1802, 9.21, 176);
                    break;
                case "Gd":
                    element = new Element("Gadolinium", 64, "solid", 1585, 3273, 10.05, 301.3);
                    break;
                case "Tb":
                    element = new Element("Terbium", 65, "solid", 1629, 3396, 10.15, 391);
                    break;
                case "Dy":
                    element = new Element("Dysprosium", 66, "solid", 1680, 2840, 11.06, 280);
                    break;
                case "Ho":
                    element = new Element("Holmium", 67, "solid", 1734, 2873, 17.0, 251);
                    break;
                case "Er":
                    element = new Element("Erbium", 68, "solid", 1802, 3141, 19.90, 280);
                    break;
                case "Tm":
                    element = new Element("Thulium", 69, "solid", 1818, 2223, 16.84, 191);
                    break;
                case "Yb":
                    element = new Element("Ytterbium", 70, "solid", 1097, 1469, 7.66, 129);
                    break;
                case "Lu":
                    element = new Element("Lutetium", 71, "solid", 1925, 3675, 22, 414);
                    break;
                case "Hf":
                    element = new Element("Hafnium", 72, "solid", 2506, 4876, 27.2, 648);
                    break;
                case "Ta":
                    element = new Element("Tantalum", 73, "solid", 3290, 5731, 36.57, 753);
                    break;
                case "W":
                    element = new Element("Tungsten", 74, "solid", 3695, 6203, 35.3, 774);
                    break;
                case "Re":
                    element = new Element("Rhenium", 75, "solid", 3459, 5903, 60.43, 704);
                    break;
                case "Os":
                    element = new Element("Osmium", 76, "solid", 3306, 5285, 31, 378);
                    break;
                case "Ir":
                    element = new Element("Iridium", 77, "solid", 2719, 4403, 41.12, 564);
                    break;
                case "Pt":
                    element = new Element("Platinum", 78, "solid", 2041.4, 4098, 22.17, 510);
                    break;
                case "Au":
                    element = new Element("Gold", 79, "solid", 1337.33, 3243, 12.55, 342);
                    break;
                case "Hg":
                    element = new Element("Mercury", 80, "liquid", 234.3210, 629.88, 2.29, 59.11);
                    break;
                case "Tl":
                    element = new Element("Thallium", 81, "solid", 577, 1746, 4.14, 165);
                    break;
                case "Pb":
                    element = new Element("Lead", 82, "solid", 600.61, 2022, 4.77, 179.5);
                    break;
                case "Bi":
                    element = new Element("Bismuth", 83, "solid", 544.7, 1837, 11.30, 179);
                    break;
                case "Po":
                    element = new Element("Polonium", 84, "solid", 527, 1235, 13, 102.91);
                    break;
                case "At":
                    element = new Element("Astatine", 85, "solid", 575, 610, 6, 54.39);
                    break;
                case "Rn":
                    element = new Element("Radon", 86, "gas", 202, 211.5, 3.247, 18.10);
                    break;
                case "Fr":
                    element = new Element("Francium", 87, "solid", 300, 950, 2, 65);
                    break;
                case "Ra":
                    element = new Element("Radium", 88, "solid", 973, 2010, 8.5, 113);
                    break;
                case "Ac":
                    element = new Element("Actinium", 89, "solid", 1500, 3500, 14, 400);
                    break;
                case "Th":
                    element = new Element("Thorium", 90, "solid", 2023, 5061, 13.81, 514);
                    break;
                case "Pa":
                    element = new Element("Protactinium", 91, "solid", 1841, 4300, 12.34, 481);
                    break;
                case "U":
                    element = new Element("Uranium", 92, "solid", 1405.3, 4404, 9.14, 417.1);
                    break;
                case "Np":
                    element = new Element("Neptunium", 93, "solid", 912, 4447, 5.19, 336);
                    break;
                case "Pu":
                    element = new Element("Plutonium", 94, "solid", 912.5, 3505, 2.82, 333.5);
                    break;
                case "Am":
                    element = new Element("Americium", 95, "solid", 1449, 2880, 14.39, 238.5);
                    break;
                case "Cm":
                    element = new Element("Curium", 96, "solid", 1613, 3383, 13.85, 385.76);
                    break;
                case "Bk":
                    element = new Element("Berkelium", 97, "solid", 1259, 2900, 7.92, 310.03);
                    break;
                case "Cf":
                    element = new Element("Californium", 98, "solid", 1173, 1743, 0, 196.23);
                    break;
                case "Es":
                    element = new Element("Einsteinium", 99, "solid", 1133, 1269, 0, 0);
                    break;
                case "Fm":
                    element = new Element("Fermium", 100, "solid", 1800, 0, 0, 0);
                    break;
                case "Md":
                    element = new Element("Mendelevium", 101, "solid", 1100, 0, 0, 0);
                    break;
                case "No":
                    element = new Element("Nobelium", 102, "solid", 1100, 0, 0, 0);
                    break;
                case "Lr":
                    element = new Element("Lawrencium", 103, "solid", 1900, 0, 0, 0);
                    break;
                case "Rf":
                    element = new Element("Rutherfordium", 104, "solid", 2400, 5800, 0, 0);
                    break;
                case "Db":
                    element = new Element("Dubnium", 105, "solid", 0, 0, 0, 0);
                    break;
                case "Sg":
                    element = new Element("Seaborgium", 106, "solid", 0, 0, 0, 0);
                    break;
                case "Bh":
                    element = new Element("Bohrium", 107, "solid", 0, 0, 0, 0);
                    break;
                case "Hs":
                    element = new Element("Hassium", 108, "solid", 0, 0, 0, 0);
                    break;
                case "Mt":
                    element = new Element("Meitnerium", 109, "solid", 0, 0, 0, 0);
                    break;
                case "Ds":
                    element = new Element("Darmstadtium", 110, "solid", 0, 0, 0, 0);
                    break;
                case "Rg":
                    element = new Element("Roentgenium", 111, "solid", 0, 0, 0, 0);
                    break;
                case "Cn":
                    element = new Element("Copernicium", 112, "gas", 0, 357, 0, 0);
                    break;
                case "Nh":
                    element = new Element("Nihonium", 113, "solid", 700, 1430, 7.61, 130);
                    break;
                case "Fl":
                    element = new Element("Flerovium", 114, "solid", 340, 420, 0, 38);
                    break;
                case "Mc":
                    element = new Element("Moscovium", 115, "solid", 670, 1400, 5.9, 138);
                    break;
                case "Lv":
                    element = new Element("Livermorium", 116, "solid", 637, 1035, 7.61, 42);
                    break;
                case "Ts":
                    element = new Element("Tennessine", 117, "solid", 623, 883, 0, 0);
                    break;
                case "Og":
                    element = new Element("Oganesson", 118, "solid", 0, 350, 23.5, 19.4);
                    break;
            }

            /*
            * This portion creates the layout for the information screen created after
            * the element is selected.
             */
            GridPane elementGrid = new GridPane();
            elementGrid.setAlignment(Pos.CENTER);
            elementGrid.setHgap(10);
            elementGrid.setVgap(10);
            elementGrid.setPadding(new Insets(25, 25, 25, 25));

            Text elementName = new Text(element.name);
            elementGrid.add(elementName, 0, 0);

            Label atoNbrLbl = new Label("Atomic Number: ");
            elementGrid.add(atoNbrLbl, 0, 2);
            Text atoNbrTxt = new Text("" + element.atomicNumber);
            elementGrid.add(atoNbrTxt, 1, 2);

            Label phaseLbl = new Label("Phase: ");
            elementGrid.add(phaseLbl, 0, 4);
            if (element.atomicNumber > 99) {
                phaseTxt = new Text(element.phase + " (predicted)");
            } else {
                phaseTxt = new Text(element.phase);
            }
            elementGrid.add(phaseTxt, 1, 4);

            Label meltPointLbl = new Label("Melting Point: ");
            elementGrid.add(meltPointLbl, 0, 6);
            if (element.meltPoint == 0) {
                meltTxt = new Text("unknown");
            } else if (element.atomicNumber < 113) {
                meltTxt = new Text(element.meltPoint + " K");
            } else {
                meltTxt = new Text(element.meltPoint + " K (predicted)");
            }
            elementGrid.add(meltTxt, 1, 6);

            Label boilPointLbl = new Label("Boiling Point: ");
            elementGrid.add(boilPointLbl, 0, 8);
            if (element.boilPoint == 0) {
                boilTxt = new Text("unknown");
            } else if (element.atomicNumber < 113) {
                boilTxt = new Text(element.boilPoint + " K");
            } else {
                boilTxt = new Text(element.boilPoint + " K (predicted)");
            }
            elementGrid.add(boilTxt, 1, 8);

            Label fusionLbl = new Label("Heat of Fusion: ");
            elementGrid.add(fusionLbl, 0, 10);
            if (element.heatFusion == 0) {
                fusionTxt = new Text("unknown");
            } else if (element.atomicNumber < 113) {
                fusionTxt = new Text(element.heatFusion + " kJ/mol");
            } else {
                fusionTxt = new Text(element.heatFusion + " kJ/mol (predicted)");
            }
            elementGrid.add(fusionTxt, 1, 10);

            Label vaporLbl = new Label("Heat of Vaporization: ");
            elementGrid.add(vaporLbl, 0, 12);
            if (element.heatVapor == 0) {
                vaporTxt = new Text("unknown");
            } else if (element.atomicNumber < 113) {
                vaporTxt = new Text(element.heatVapor + " kJ/mol");
            } else {
                vaporTxt = new Text(element.heatVapor + " kJ/mol (predicted)");
            }
            elementGrid.add(vaporTxt, 1, 12);

            Button modelBtn = new Button("Display Model");
            elementGrid.add(modelBtn, 1, 14);
            modelBtn.setOnAction(modelHandler);

            Stage stage = new Stage();

            stage.setTitle(element.name);
            stage.setScene(new Scene(elementGrid, 450, 450));
            stage.show();
        }
    };

    final EventHandler<ActionEvent> modelHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Model elementModel = new Model();
            elementModel.displayModel(element);
        }
    };

}
