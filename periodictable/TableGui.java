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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nmartin
 */
public class TableGui {

    GridPane grid;
    Element element;

    public TableGui(GridPane grid) {

        this.grid = grid;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(3);
        grid.setVgap(3);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        grid.setStyle("-fx-background-color: #001018;");

        /*
        *Construct buttons and add them to the GridPane
         */
        //Row 1 of the table
        Button btnH = new Button("1\nH");
        addButton(grid, btnH, "H", "-fx-base: #bf2b00;", 0, 1, myHandler);

        Button btnHe = new Button("2\nHe");
        addButton(grid, btnHe, "He", "-fx-base: #005c2b;", 17, 1, myHandler);

        //Row 2 of the table
        Button btnLi = new Button("3\nLi");
        btnLi.setId("Li");
        btnLi.setStyle("-fx-base: #065179;");
        btnLi.setPrefWidth(40);
        grid.add(btnLi, 0, 2);
        btnLi.setOnAction(myHandler);

        Button btnBe = new Button("4\nBe");
        btnBe.setId("Be");
        btnBe.setStyle("-fx-base: #821d00");
        btnBe.setPrefWidth(40);
        grid.add(btnBe, 1, 2);
        btnBe.setOnAction(myHandler);

        Button btnB = new Button("5\nB");
        btnB.setId("B");
        btnB.setStyle("-fx-base: #ff6235;");
        btnB.setPrefWidth(40);
        grid.add(btnB, 12, 2);
        btnB.setOnAction(myHandler);

        Button btnC = new Button("6\nC");
        btnC.setId("C");
        btnC.setStyle("-fx-base: #bf2b00;");
        btnC.setPrefWidth(40);
        grid.add(btnC, 13, 2);
        btnC.setOnAction(myHandler);

        Button btnN = new Button("7\nN");
        btnN.setId("N");
        btnN.setStyle("-fx-base: #bf2b00;");
        btnN.setPrefWidth(40);
        grid.add(btnN, 14, 2);
        btnN.setOnAction(myHandler);

        Button btnO = new Button("8\nO");
        btnO.setId("O");
        btnO.setStyle("-fx-base: #bf2b00;");
        btnO.setPrefWidth(40);
        grid.add(btnO, 15, 2);
        btnO.setOnAction(myHandler);

        Button btnF = new Button("9\nF");
        btnF.setId("F");
        btnF.setStyle("-fx-base: #00ea6c;");
        btnF.setPrefWidth(40);
        grid.add(btnF, 16, 2);
        btnF.setOnAction(myHandler);

        Button btnNe = new Button("10\nNe");
        btnNe.setId("Ne");
        btnNe.setStyle("-fx-base: #005c2b;");
        btnNe.setPrefWidth(40);
        grid.add(btnNe, 17, 2);
        btnNe.setOnAction(myHandler);

        //Row 3 of the table
        Button btnNa = new Button("11\nNa");
        btnNa.setId("Na");
        btnNa.setStyle("-fx-base: #065179;");
        btnNa.setPrefWidth(40);
        grid.add(btnNa, 0, 3);
        btnNa.setOnAction(myHandler);

        Button btnMg = new Button("12\nMg");
        btnMg.setId("Mg");
        btnMg.setStyle("-fx-base: #821d00;");
        btnMg.setPrefWidth(40);
        grid.add(btnMg, 1, 3);
        btnMg.setOnAction(myHandler);

        Button btnAl = new Button("13\nAl");
        btnAl.setId("Al");
        btnAl.setStyle("-fx-base: #0b98e4;");
        btnAl.setPrefWidth(40);
        grid.add(btnAl, 12, 3);
        btnAl.setOnAction(myHandler);

        Button btnSi = new Button("14\nSi");
        btnSi.setId("Si");
        btnSi.setStyle("-fx-base: #ff6235;");
        btnSi.setPrefWidth(40);
        grid.add(btnSi, 13, 3);
        btnSi.setOnAction(myHandler);

        Button btnP = new Button("15\nP");
        btnP.setId("P");
        btnP.setStyle("-fx-base: #bf2b00;");
        btnP.setPrefWidth(40);
        grid.add(btnP, 14, 3);
        btnP.setOnAction(myHandler);

        Button btnS = new Button("16\nS");
        btnS.setId("S");
        btnS.setStyle("-fx-base: #bf2b00;");
        btnS.setPrefWidth(40);
        grid.add(btnS, 15, 3);
        btnS.setOnAction(myHandler);

        Button btnCl = new Button("17\nCl");
        btnCl.setId("Cl");
        btnCl.setStyle("-fx-base: #00ea6c;");
        btnCl.setPrefWidth(40);
        grid.add(btnCl, 16, 3);
        btnCl.setOnAction(myHandler);

        Button btnAr = new Button("18\nAr");
        btnAr.setId("Ar");
        btnAr.setStyle("-fx-base: #005c2b;");
        btnAr.setPrefWidth(40);
        grid.add(btnAr, 17, 3);
        btnAr.setOnAction(myHandler);

        //Row 4 of the table
        Button btnK = new Button("19\nK");
        btnK.setId("K");
        btnK.setStyle("-fx-base: #065179;");
        btnK.setPrefWidth(40);
        grid.add(btnK, 0, 4);
        btnK.setOnAction(myHandler);

        Button btnCa = new Button("20\nCa");
        btnCa.setId("Ca");
        btnCa.setStyle("-fx-base: #821d00;");
        btnCa.setPrefWidth(40);
        grid.add(btnCa, 1, 4);
        btnCa.setOnAction(myHandler);

        Button btnSc = new Button("21\nSc");
        btnSc.setId("Sc");
        btnSc.setStyle("-fx-base: #ff8b00;");
        btnSc.setPrefWidth(40);
        grid.add(btnSc, 2, 4);
        btnSc.setOnAction(myHandler);

        Button btnTi = new Button("22\nTi");
        btnTi.setId("Ti");
        btnTi.setStyle("-fx-base: #ff8b00;");
        btnTi.setPrefWidth(40);
        grid.add(btnTi, 3, 4);
        btnTi.setOnAction(myHandler);

        Button btnV = new Button("23\nV");
        btnV.setId("V");
        btnV.setStyle("-fx-base: #ff8b00;");
        btnV.setPrefWidth(40);
        grid.add(btnV, 4, 4);
        btnV.setOnAction(myHandler);

        Button btnCr = new Button("24\nCr");
        btnCr.setId("Cr");
        btnCr.setStyle("-fx-base: #ff8b00;");
        btnCr.setPrefWidth(40);
        grid.add(btnCr, 5, 4);
        btnCr.setOnAction(myHandler);

        Button btnMn = new Button("25\nMn");
        btnMn.setId("Mn");
        btnMn.setStyle("-fx-base: #ff8b00;");
        btnMn.setPrefWidth(40);
        grid.add(btnMn, 6, 4);
        btnMn.setOnAction(myHandler);

        Button btnFe = new Button("26\nFe");
        btnFe.setId("Fe");
        btnFe.setStyle("-fx-base: #ff8b00;");
        btnFe.setPrefWidth(40);
        grid.add(btnFe, 7, 4);
        btnFe.setOnAction(myHandler);

        Button btnCo = new Button("27\nCo");
        btnCo.setId("Co");
        btnCo.setStyle("-fx-base: #ff8b00;");
        btnCo.setPrefWidth(40);
        grid.add(btnCo, 8, 4);
        btnCo.setOnAction(myHandler);

        Button btnNi = new Button("28\nNi");
        btnNi.setId("Ni");
        btnNi.setStyle("-fx-base: #ff8b00;");
        btnNi.setPrefWidth(40);
        grid.add(btnNi, 9, 4);
        btnNi.setOnAction(myHandler);

        Button btnCu = new Button("29\nCu");
        btnCu.setId("Cu");
        btnCu.setStyle("-fx-base: #ff8b00;");
        btnCu.setPrefWidth(40);
        grid.add(btnCu, 10, 4);
        btnCu.setOnAction(myHandler);

        Button btnZn = new Button("30\nZn");
        btnZn.setId("Zn");
        btnZn.setStyle("-fx-base: #ff8b00;");
        btnZn.setPrefWidth(40);
        grid.add(btnZn, 11, 4);
        btnZn.setOnAction(myHandler);

        Button btnGa = new Button("31\nGa");
        btnGa.setId("Ga");
        btnGa.setStyle("-fx-base: #0b98e4;");
        btnGa.setPrefWidth(40);
        grid.add(btnGa, 12, 4);
        btnGa.setOnAction(myHandler);

        Button btnGe = new Button("32\nGe");
        btnGe.setId("Ge");
        btnGe.setStyle("-fx-base: #ff6235;");
        btnGe.setPrefWidth(40);
        grid.add(btnGe, 13, 4);
        btnGe.setOnAction(myHandler);

        Button btnAs = new Button("33\nAs");
        btnAs.setId("As");
        btnAs.setStyle("-fx-base: #ff6235;");
        btnAs.setPrefWidth(40);
        grid.add(btnAs, 14, 4);
        btnAs.setOnAction(myHandler);

        Button btnSe = new Button("34\nSe");
        btnSe.setId("Se");
        btnSe.setStyle("-fx-base: #bf2b00;");
        btnSe.setPrefWidth(40);
        grid.add(btnSe, 15, 4);
        btnSe.setOnAction(myHandler);

        Button btnBr = new Button("35\nBr");
        btnBr.setId("Br");
        btnBr.setStyle("-fx-base: #00ea6c;");
        btnBr.setPrefWidth(40);
        grid.add(btnBr, 16, 4);
        btnBr.setOnAction(myHandler);

        Button btnKr = new Button("36\nKr");
        btnKr.setId("Kr");
        btnKr.setStyle("-fx-base: #005c2b;");
        btnKr.setPrefWidth(40);
        grid.add(btnKr, 17, 4);
        btnKr.setOnAction(myHandler);

        //Row 5 of the table
        Button btnRb = new Button("37\nRb");
        btnRb.setId("Rb");
        btnRb.setStyle("-fx-base: #065179;");
        btnRb.setPrefWidth(40);
        grid.add(btnRb, 0, 5);
        btnRb.setOnAction(myHandler);

        Button btnSr = new Button("38\nSr");
        btnSr.setId("Sr");
        btnSr.setStyle("-fx-base: #821d00;");
        btnSr.setPrefWidth(40);
        grid.add(btnSr, 1, 5);
        btnSr.setOnAction(myHandler);

        Button btnY = new Button("39\nY");
        btnY.setId("Y");
        btnY.setStyle("-fx-base: #ff8b00;");
        btnY.setPrefWidth(40);
        grid.add(btnY, 2, 5);
        btnY.setOnAction(myHandler);

        Button btnZr = new Button("40\nZr");
        btnZr.setId("Zr");
        btnZr.setStyle("-fx-base: #ff8b00;");
        btnZr.setPrefWidth(40);
        grid.add(btnZr, 3, 5);
        btnZr.setOnAction(myHandler);

        Button btnNb = new Button("41\nNb");
        btnNb.setId("Nb");
        btnNb.setStyle("-fx-base: #ff8b00;");
        btnNb.setPrefWidth(40);
        grid.add(btnNb, 4, 5);
        btnNb.setOnAction(myHandler);

        Button btnMo = new Button("42\nMo");
        btnMo.setId("Mo");
        btnMo.setStyle("-fx-base: #ff8b00;");
        btnMo.setPrefWidth(40);
        grid.add(btnMo, 5, 5);
        btnMo.setOnAction(myHandler);

        Button btnTc = new Button("43\nTc");
        btnTc.setId("Tc");
        btnTc.setStyle("-fx-base: #ff8b00;");
        btnTc.setPrefWidth(40);
        grid.add(btnTc, 6, 5);
        btnTc.setOnAction(myHandler);

        Button btnRu = new Button("44\nRu");
        btnRu.setId("Ru");
        btnRu.setStyle("-fx-base: #ff8b00;");
        btnRu.setPrefWidth(40);
        grid.add(btnRu, 7, 5);
        btnRu.setOnAction(myHandler);

        Button btnRh = new Button("45\nRh");
        btnRh.setId("Rh");
        btnRh.setStyle("-fx-base: #ff8b00;");
        btnRh.setPrefWidth(40);
        grid.add(btnRh, 8, 5);
        btnRh.setOnAction(myHandler);

        Button btnPd = new Button("46\nPd");
        btnPd.setId("Pd");
        btnPd.setStyle("-fx-base: #ff8b00;");
        btnPd.setPrefWidth(40);
        grid.add(btnPd, 9, 5);
        btnPd.setOnAction(myHandler);

        Button btnAg = new Button("47\nAg");
        btnAg.setId("Ag");
        btnAg.setStyle("-fx-base: #ff8b00;");
        btnAg.setPrefWidth(40);
        grid.add(btnAg, 10, 5);
        btnAg.setOnAction(myHandler);

        Button btnCd = new Button("48\nCd");
        btnCd.setId("Cd");
        btnCd.setStyle("-fx-base: #ff8b00;");
        btnCd.setPrefWidth(40);
        grid.add(btnCd, 11, 5);
        btnCd.setOnAction(myHandler);

        Button btnIn = new Button("49\nIn");
        btnIn.setId("In");
        btnIn.setStyle("-fx-base: #0b98e4;");
        btnIn.setPrefWidth(40);
        grid.add(btnIn, 12, 5);
        btnIn.setOnAction(myHandler);

        Button btnSn = new Button("50\nSn");
        btnSn.setId("Sn");
        btnSn.setStyle("-fx-base: #0b98e4;");
        btnSn.setPrefWidth(40);
        grid.add(btnSn, 13, 5);
        btnSn.setOnAction(myHandler);

        Button btnSb = new Button("51\nSb");
        btnSb.setId("Sb");
        btnSb.setStyle("-fx-base: #ff6235;");
        btnSb.setPrefWidth(40);
        grid.add(btnSb, 14, 5);
        btnSb.setOnAction(myHandler);

        Button btnTe = new Button("52\nTe");
        btnTe.setId("Te");
        btnTe.setStyle("-fx-base: #ff6235;");
        btnTe.setPrefWidth(40);
        grid.add(btnTe, 15, 5);
        btnTe.setOnAction(myHandler);

        Button btnI = new Button("53\nI");
        btnI.setId("I");
        btnI.setStyle("-fx-base: #00ea6c;");
        btnI.setPrefWidth(40);
        grid.add(btnI, 16, 5);
        btnI.setOnAction(myHandler);

        Button btnXe = new Button("54\nXe");
        btnXe.setId("Xe");
        btnXe.setStyle("-fx-base: #005c2b;");
        btnXe.setPrefWidth(40);
        grid.add(btnXe, 17, 5);
        btnXe.setOnAction(myHandler);

        //Row 6 of the table
        Button btnCs = new Button("55\nCs");
        btnCs.setId("Cs");
        btnCs.setStyle("-fx-base: #065179");
        btnCs.setPrefWidth(40);
        grid.add(btnCs, 0, 6);
        btnCs.setOnAction(myHandler);

        Button btnBa = new Button("56\nBa");
        btnBa.setId("Ba");
        btnBa.setStyle("-fx-base: #821d00;");
        btnBa.setPrefWidth(40);
        grid.add(btnBa, 1, 6);
        btnBa.setOnAction(myHandler);

        Button btnHf = new Button("72\nHf");
        btnHf.setId("Hf");
        btnHf.setStyle("-fx-base: #ff8b00;");
        btnHf.setPrefWidth(40);
        grid.add(btnHf, 3, 6);
        btnHf.setOnAction(myHandler);

        Button btnTa = new Button("73\nTa");
        btnTa.setId("Ta");
        btnTa.setStyle("-fx-base: #ff8b00;");
        btnTa.setPrefWidth(40);
        grid.add(btnTa, 4, 6);
        btnTa.setOnAction(myHandler);

        Button btnW = new Button("74\nW");
        btnW.setId("W");
        btnW.setStyle("-fx-base: #ff8b00;");
        btnW.setPrefWidth(40);
        grid.add(btnW, 5, 6);
        btnW.setOnAction(myHandler);

        Button btnRe = new Button("75\nRe");
        btnRe.setId("Re");
        btnRe.setStyle("-fx-base: #ff8b00;");
        btnRe.setPrefWidth(40);
        grid.add(btnRe, 6, 6);
        btnRe.setOnAction(myHandler);

        Button btnOs = new Button("76\nOs");
        btnOs.setId("Os");
        btnOs.setStyle("-fx-base: #ff8b00;");
        btnOs.setPrefWidth(40);
        grid.add(btnOs, 7, 6);
        btnOs.setOnAction(myHandler);

        Button btnIr = new Button("77\nIr");
        btnIr.setId("Ir");
        btnIr.setStyle("-fx-base: #ff8b00;");
        btnIr.setPrefWidth(40);
        grid.add(btnIr, 8, 6);
        btnIr.setOnAction(myHandler);

        Button btnPt = new Button("78\nPt");
        btnPt.setId("Pt");
        btnPt.setStyle("-fx-base: #ff8b00;");
        btnPt.setPrefWidth(40);
        grid.add(btnPt, 9, 6);
        btnPt.setOnAction(myHandler);

        Button btnAu = new Button("79\nAu");
        btnAu.setId("Au");
        btnAu.setStyle("-fx-base: #ff8b00;");
        btnAu.setPrefWidth(40);
        grid.add(btnAu, 10, 6);
        btnAu.setOnAction(myHandler);

        Button btnHg = new Button("80\nHg");
        btnHg.setId("Hg");
        btnHg.setStyle("-fx-base: #ff8b00;");
        btnHg.setPrefWidth(40);
        grid.add(btnHg, 11, 6);
        btnHg.setOnAction(myHandler);

        Button btnTl = new Button("81\nTl");
        btnTl.setId("Tl");
        btnTl.setStyle("-fx-base: #0b98e4;");
        btnTl.setPrefWidth(40);
        grid.add(btnTl, 12, 6);
        btnTl.setOnAction(myHandler);

        Button btnPb = new Button("82\nPb");
        btnPb.setId("Pb");
        btnPb.setStyle("-fx-base: #0b98e4;");
        btnPb.setPrefWidth(40);
        grid.add(btnPb, 13, 6);
        btnPb.setOnAction(myHandler);

        Button btnBi = new Button("83\nBi");
        btnBi.setId("Bi");
        btnBi.setStyle("-fx-base: #0b98e4;");
        btnBi.setPrefWidth(40);
        grid.add(btnBi, 14, 6);
        btnBi.setOnAction(myHandler);

        Button btnPo = new Button("84\nPo");
        btnPo.setId("Po");
        btnPo.setStyle("-fx-base: #ff6235;");
        btnPo.setPrefWidth(40);
        grid.add(btnPo, 15, 6);
        btnPo.setOnAction(myHandler);

        Button btnAt = new Button("85\nAt");
        btnAt.setId("At");
        btnAt.setStyle("-fx-base: #00ea6c;");
        btnAt.setPrefWidth(40);
        grid.add(btnAt, 16, 6);
        btnAt.setOnAction(myHandler);

        Button btnRn = new Button("86\nRn");
        btnRn.setId("Rn");
        btnRn.setStyle("-fx-base: #005c2b;");
        btnRn.setPrefWidth(40);
        grid.add(btnRn, 17, 6);
        btnRn.setOnAction(myHandler);

        //Row 7 of the table
        Button btnFr = new Button("87\nFr");
        btnFr.setId("Fr");
        btnFr.setStyle("-fx-base: #065179;");
        btnFr.setPrefWidth(40);
        grid.add(btnFr, 0, 7);
        btnFr.setOnAction(myHandler);

        Button btnRa = new Button("88\nRa");
        btnRa.setId("Ra");
        btnRa.setStyle("-fx-base: #821d00;");
        btnRa.setPrefWidth(40);
        grid.add(btnRa, 1, 7);
        btnRa.setOnAction(myHandler);

        Button btnRf = new Button("104\nRf");
        btnRf.setId("Rf");
        btnRf.setStyle("-fx-base: #ff8b00;");
        btnRf.setPrefWidth(40);
        grid.add(btnRf, 3, 7);
        btnRf.setOnAction(myHandler);

        Button btnDb = new Button("105\nDb");
        btnDb.setId("Db");
        btnDb.setStyle("-fx-base: #ff8b00;");
        btnDb.setPrefWidth(40);
        grid.add(btnDb, 4, 7);
        btnDb.setOnAction(myHandler);

        Button btnSg = new Button("106\nSg");
        btnSg.setId("Sg");
        btnSg.setStyle("-fx-base: #ff8b00;");
        btnSg.setPrefWidth(40);
        grid.add(btnSg, 5, 7);
        btnSg.setOnAction(myHandler);

        Button btnBh = new Button("107\nBh");
        btnBh.setId("Bh");
        btnBh.setStyle("-fx-base: #ff8b00;");
        btnBh.setPrefWidth(40);
        grid.add(btnBh, 6, 7);
        btnBh.setOnAction(myHandler);

        Button btnHs = new Button("108\nHs");
        btnHs.setId("Hs");
        btnHs.setStyle("-fx-base: #ff8b00;");
        btnHs.setPrefWidth(40);
        grid.add(btnHs, 7, 7);
        btnHs.setOnAction(myHandler);

        Button btnMt = new Button("109\nMt");
        btnMt.setId("Mt");
        btnMt.setStyle("-fx-base: #ff8b00;");
        btnMt.setPrefWidth(40);
        grid.add(btnMt, 8, 7);
        btnMt.setOnAction(myHandler);

        Button btnDs = new Button("110\nDs");
        btnDs.setId("Ds");
        btnDs.setStyle("-fx-base: #ff8b00;");
        btnDs.setPrefWidth(40);
        grid.add(btnDs, 9, 7);
        btnDs.setOnAction(myHandler);

        Button btnRg = new Button("111\nRg");
        btnRg.setId("Rg");
        btnRg.setStyle("-fx-base: #ff8b00;");
        btnRg.setPrefWidth(40);
        grid.add(btnRg, 10, 7);
        btnRg.setOnAction(myHandler);

        Button btnCn = new Button("112\nCn");
        btnCn.setId("Cn");
        btnCn.setStyle("-fx-base: #ff8b00;");
        btnCn.setPrefWidth(40);
        grid.add(btnCn, 11, 7);
        btnCn.setOnAction(myHandler);

        Button btnUut = new Button("113\nUut");
        btnUut.setId("Uut");
        btnUut.setStyle("-fx-base: #0b98e4;");
        btnUut.setPrefWidth(40);
        grid.add(btnUut, 12, 7);
        btnUut.setOnAction(myHandler);

        Button btnFl = new Button("114\nFl");
        btnFl.setId("Fl");
        btnFl.setStyle("-fx-base: #0b98e4;");
        btnFl.setPrefWidth(40);
        grid.add(btnFl, 13, 7);
        btnFl.setOnAction(myHandler);

        Button btnUup = new Button("115\nUup");
        btnUup.setId("Uup");
        btnUup.setStyle("-fx-base: #0b98e4;");
        btnUup.setPrefWidth(40);
        grid.add(btnUup, 14, 7);
        btnUup.setOnAction(myHandler);

        Button btnLv = new Button("116\nLv");
        btnLv.setId("Lv");
        btnLv.setStyle("-fx-base: #0b98e4;");
        btnLv.setPrefWidth(40);
        grid.add(btnLv, 15, 7);
        btnLv.setOnAction(myHandler);

        Button btnUus = new Button("117\nUus");
        btnUus.setId("Uus");
        btnUus.setStyle("-fx-base: #00ea6c;");
        btnUus.setPrefWidth(40);
        grid.add(btnUus, 16, 7);
        btnUus.setOnAction(myHandler);

        Button btnUuo = new Button("118\nUuo");
        btnUuo.setId("Uuo");
        btnUuo.setStyle("-fx-base: #005c2b;");
        btnUuo.setPrefWidth(40);
        grid.add(btnUuo, 17, 7);
        btnUuo.setOnAction(myHandler);
        
        //elements 57-71 and 89-103
        
        Button btnLa = new Button("57\nLa");
        btnLa.setId("La");
        btnLa.setStyle("-fx-base: #824700");
        btnLa.setPrefWidth(40);
        grid.add(btnLa, 3, 20);
        btnLa.setOnAction(myHandler);
        
        Button btnCe = new Button("58\nCe");
        btnCe.setId("Ce");
        btnCe.setStyle("-fx-base: #824700");
        btnCe.setPrefWidth(40);
        grid.add(btnCe, 4, 20);
        btnCe.setOnAction(myHandler);
        
        Button btnPr = new Button("59\nPr");
        btnPr.setId("Pr");
        btnPr.setStyle("-fx-base: #824700");
        btnPr.setPrefWidth(40);
        grid.add(btnPr, 5, 20);
        btnPr.setOnAction(myHandler);
        
        Button btnNd = new Button("60\nNd");
        btnNd.setId("Nd");
        btnNd.setStyle("-fx-base: #824700");
        btnNd.setPrefWidth(40);
        grid.add(btnNd, 6, 20);
        btnNd.setOnAction(myHandler);
        
        Button btnPm = new Button("61\nPm");
        btnPm.setId("Pm");
        btnPm.setStyle("-fx-base: #824700");
        btnPm.setPrefWidth(40);
        grid.add(btnPm, 7, 20);
        btnPm.setOnAction(myHandler);
        
        Button btnSm = new Button("62\nSm");
        btnSm.setId("Sm");
        btnSm.setStyle("-fx-base: #824700");
        btnSm.setPrefWidth(40);
        grid.add(btnSm, 8, 20);
        btnSm.setOnAction(myHandler);
        
        Button btnEu = new Button("63\nEu");
        btnEu.setId("Eu");
        btnEu.setStyle("-fx-base: #824700");
        btnEu.setPrefWidth(40);
        grid.add(btnEu, 9, 20);
        btnEu.setOnAction(myHandler);
        
        Button btnGd = new Button("64\nGd");
        btnGd.setId("Gd");
        btnGd.setStyle("-fx-base: #824700");
        btnGd.setPrefWidth(40);
        grid.add(btnGd, 10, 20);
        btnGd.setOnAction(myHandler);
        
        Button btnTb = new Button("65\nTb");
        btnTb.setId("Tb");
        btnTb.setStyle("-fx-base: #824700");
        btnTb.setPrefWidth(40);
        grid.add(btnTb, 11, 20);
        btnTb.setOnAction(myHandler);
        
        Button btnDy = new Button("66\nDy");
        btnDy.setId("Dy");
        btnDy.setStyle("-fx-base: #824700");
        btnDy.setPrefWidth(40);
        grid.add(btnDy, 12, 20);
        btnDy.setOnAction(myHandler);
        
        Button btnHo = new Button("67\nHo");
        btnHo.setId("Ho");
        btnHo.setStyle("-fx-base: #824700");
        btnHo.setPrefWidth(40);
        grid.add(btnHo, 13, 20);
        btnHo.setOnAction(myHandler);
        
        Button btnEr = new Button("68\nEr");
        btnEr.setId("Er");
        btnEr.setStyle("-fx-base: #824700");
        btnEr.setPrefWidth(40);
        grid.add(btnEr, 14, 20);
        btnEr.setOnAction(myHandler);
        
        Button btnTm = new Button("69\nTm");
        btnTm.setId("Tm");
        btnTm.setStyle("-fx-base: #824700");
        btnTm.setPrefWidth(40);
        grid.add(btnTm, 15, 20);
        btnTm.setOnAction(myHandler);
        
        Button btnYb = new Button("70\nYb");
        btnYb.setId("Yb");
        btnYb.setStyle("-fx-base: #824700");
        btnYb.setPrefWidth(40);
        grid.add(btnYb, 16, 20);
        btnYb.setOnAction(myHandler);
        
        Button btnLu = new Button("71\nLu");
        btnLu.setId("Lu");
        btnLu.setStyle("-fx-base: #824700");
        btnLu.setPrefWidth(40);
        grid.add(btnLu, 17, 20);
        btnLu.setOnAction(myHandler);
        
        Button btnAc = new Button("89\nAc");
        btnAc.setId("Ac");
        btnAc.setStyle("-fx-base: #ffa335");
        btnAc.setPrefWidth(40);
        grid.add(btnAc, 3, 21);
        btnAc.setOnAction(myHandler);
        
        Button btnTh = new Button("90\nTh");
        btnTh.setId("Th");
        btnTh.setStyle("-fx-base: #ffa335");
        btnTh.setPrefWidth(40);
        grid.add(btnTh, 4, 21);
        btnTh.setOnAction(myHandler);
        
        Button btnPa = new Button("91\nPa");
        btnPa.setId("Pa");
        btnPa.setStyle("-fx-base: #ffa335");
        btnPa.setPrefWidth(40);
        grid.add(btnPa, 5, 21);
        btnPa.setOnAction(myHandler);
        
        Button btnU = new Button("92\nU");
        btnU.setId("U");
        btnU.setStyle("-fx-base: #ffa335");
        btnU.setPrefWidth(40);
        grid.add(btnU, 6, 21);
        btnU.setOnAction(myHandler);
        
        Button btnNp = new Button("93\nNp");
        btnNp.setId("Np");
        btnNp.setStyle("-fx-base: #ffa335");
        btnNp.setPrefWidth(40);
        grid.add(btnNp, 7, 21);
        btnNp.setOnAction(myHandler);
        
        Button btnPu = new Button("94\nPu");
        btnPu.setId("Pu");
        btnPu.setStyle("-fx-base: #ffa335");
        btnPu.setPrefWidth(40);
        grid.add(btnPu, 8, 21);
        btnPu.setOnAction(myHandler);
        
        Button btnAm = new Button("95\nAm");
        btnAm.setId("Am");
        btnAm.setStyle("-fx-base: #ffa335");
        btnAm.setPrefWidth(40);
        grid.add(btnAm, 9, 21);
        btnAm.setOnAction(myHandler);
        
        Button btnCm = new Button("96\nCm");
        btnCm.setId("Cm");
        btnCm.setStyle("-fx-base: #ffa335");
        btnCm.setPrefWidth(40);
        grid.add(btnCm, 10, 21);
        btnCm.setOnAction(myHandler);
        
        Button btnBk = new Button("97\nBk");
        btnBk.setId("Bk");
        btnBk.setStyle("-fx-base: #ffa335");
        btnBk.setPrefWidth(40);
        grid.add(btnBk, 11, 21);
        btnBk.setOnAction(myHandler);
        
        Button btnCf = new Button("98\nCf");
        btnCf.setId("Cf");
        btnCf.setStyle("-fx-base: #ffa335");
        btnCf.setPrefWidth(40);
        grid.add(btnCf, 12, 21);
        btnCf.setOnAction(myHandler);
        
        Button btnEs = new Button("99\nEs");
        btnEs.setId("Es");
        btnEs.setStyle("-fx-base: #ffa335");
        btnEs.setPrefWidth(40);
        grid.add(btnEs, 13, 21);
        btnEs.setOnAction(myHandler);
        
        Button btnFm = new Button("100\nFm");
        btnFm.setId("Fm");
        btnFm.setStyle("-fx-base: #ffa335");
        btnFm.setPrefWidth(40);
        grid.add(btnFm, 14, 21);
        btnFm.setOnAction(myHandler);
        
        Button btnMd = new Button("101\nMd");
        btnMd.setId("Md");
        btnMd.setStyle("-fx-base: #ffa335");
        btnMd.setPrefWidth(40);
        grid.add(btnMd, 15, 21);
        btnMd.setOnAction(myHandler);
        
        Button btnNo = new Button("102\nNo");
        btnNo.setId("No");
        btnNo.setStyle("-fx-base: #ffa335");
        btnNo.setPrefWidth(40);
        grid.add(btnNo, 16, 21);
        btnNo.setOnAction(myHandler);
        
        Button btnLr = new Button("103\nLr");
        btnLr.setId("Lr");
        btnLr.setStyle("-fx-base: #ffa335");
        btnLr.setPrefWidth(40);
        grid.add(btnLr, 17, 21);
        btnLr.setOnAction(myHandler);
    }

    /*
     * Specifies button values and adds them to grid.
     */
    public static void addButton(GridPane grid, Button btn, String id, String style, int x, int y, EventHandler handler){
        btn.setId(id);
        btn.setStyle(style);
        btn.setPrefWidth(40);
        grid.add(btn, x, y);
        btn.setOnAction(handler);
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
                    element = new Element("Hydrogen", "gas", 13.99, 20.271, 0.904, 28.836);
                    break;
                case "He":
                    element = new Element("Helium", "gas", 0.95, 4.222, 0.0138, 0.0829);
                    break;
                case "Li":
                    element = new Element("Lithium", "solid", 453.65, 1603, 3.00, 136);
                    break;
                case "Be":
                    element = new Element("Beryllium", "solid", 1560, 2742, 12.2, 292);
                    break;
                case "B":
                    element = new Element("Boron", "solid", 2349, 4200, 50.2, 508);
                    break;
                case "C":
                    element = new Element("Carbon", "solid", 3823, 4098, 105, 715);
                    break;
                case "N":
                    element = new Element("Nitrogen", "gas", 63.15, 77.355, 0.72, 5.56);
                    break;
                case "O":
                    element = new Element("Oxygen", "gas", 54.36, 90.188, 0.444, 6.82);
                    break;
            }

            GridPane elementGrid = new GridPane();
            elementGrid.setAlignment(Pos.CENTER);
            elementGrid.setHgap(10);
            elementGrid.setVgap(10);
            elementGrid.setPadding(new Insets(25, 25, 25, 25));

            Text elementName = new Text(element.name);
            elementGrid.add(elementName, 0, 0);

            Label phaseLbl = new Label("Phase: ");
            elementGrid.add(phaseLbl, 0, 2);
            Text phaseTxt = new Text(element.phase);
            elementGrid.add(phaseTxt, 1, 2);

            Label meltPointLbl = new Label("Melting Point: ");
            elementGrid.add(meltPointLbl, 0, 4);
            Text meltText = new Text(element.meltPoint + " K");
            elementGrid.add(meltText, 1, 4);

            Label boilPointLbl = new Label("Boiling Point: ");
            elementGrid.add(boilPointLbl, 0, 6);
            Text boilTxt = new Text(element.boilPoint + " K");
            elementGrid.add(boilTxt, 1, 6);

            Label fusionLbl = new Label("Heat of Fusion: ");
            elementGrid.add(fusionLbl, 0, 8);
            Text fusionTxt = new Text(element.heatFusion + " kJ/mol");
            elementGrid.add(fusionTxt, 1, 8);

            Label vaporLbl = new Label("Heat of Vaporization: ");
            elementGrid.add(vaporLbl, 0, 10);
            Text vaporTxt = new Text(element.heatVapor + " kJ/mol");
            elementGrid.add(vaporTxt, 1, 10);

            Button modelBtn = new Button("Display Model");
            elementGrid.add(modelBtn, 1, 12);
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
            elementModel.displayModel(element.name);
        }
    };

}
