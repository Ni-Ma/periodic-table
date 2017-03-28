/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodictable;

import java.io.*;
import java.util.*;
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

    List<Button> btnList = new ArrayList<Button>();
    Element element;
    Text phaseTxt;
    Text meltTxt;
    Text boilTxt;
    Text fusionTxt;
    Text vaporTxt;

    @SuppressWarnings("ConvertToTryWithResources")
    public TableGui(GridPane grid) throws IOException {

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(4);
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));

        grid.setStyle("-fx-background-color: #001018;");

        // Read in file with element information
        String fileName = "elementList.txt";
        String line = null;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int i = 0; // index of element being read in
            // Create button for each element in file
            while ((line = br.readLine()) != null) {
                addButton(grid, myHandler, btnList, line, i);
                i++;
            }
            br.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to open file '" + fileName + "'");
        }

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
        Label metalloidsLbl = new Label("Metalloids");
        addKey(metalloidsBox, grid, metalloidsLbl, 3, 1, "-fx-background-color: #ff6235",
                "-fx-font: bold 12 Georgia; -fx-text-fill: BLACK");

        HBox otherNonBox = new HBox();
        Label otherNonLbl = new Label("Other Non-Metals");
        addKey(otherNonBox, grid, otherNonLbl, 5, 1, "-fx-background-color: #bf2b00",
                "-fx-font: bold 12 Georgia; -fx-text-fill: WHITE");

        HBox halogensBox = new HBox();
        Label halogensLbl = new Label("Halogens");
        addKey(halogensBox, grid, halogensLbl, 7, 1, "-fx-background-color: #00ea6c",
                "-fx-font: bold 12 Georgia; -fx-text-fill: BLACK");

        HBox nobleBox = new HBox();
        Label nobleLbl = new Label("Nobel Gases");
        addKey(nobleBox, grid, nobleLbl, 9, 1, "-fx-background-color: #005c2b",
                "-fx-font: bold 12 Georgia; -fx-text-fill: WHITE");

        HBox alkaliBox = new HBox();
        Label alkaliLbl = new Label("Alkali Metals");
        addKey(alkaliBox, grid, alkaliLbl, 11, 1, "-fx-background-color: #065179",
                "-fx-font: bold 12 Georgia; -fx-text-fill: WHITE");

        HBox earthBox = new HBox();
        Label earthLbl = new Label("Alkaline Earth Metals");
        addKey(earthBox, grid, earthLbl, 3, 2, "-fx-background-color: #821d00",
                "-fx-font: bold 12 Georgia; -fx-text-fill: WHITE");

        HBox lanthanoidsBox = new HBox();
        Label lanthanoidsLbl = new Label("Lanthanoids");
        addKey(lanthanoidsBox, grid, lanthanoidsLbl, 5, 2, "-fx-background-color: #824700",
                "-fx-font: bold 12 Georgia; -fx-text-fill: WHITE");

        HBox actinoidsBox = new HBox();
        Label actinoidsLbl = new Label("Actinoids");
        addKey(actinoidsBox, grid, actinoidsLbl, 7, 2, "-fx-background-color: #ffa335",
                "-fx-font: bold 12 Georgia;");

        HBox transitionBox = new HBox();
        Label transitionLbl = new Label("Transition Metals");
        addKey(transitionBox, grid, transitionLbl, 9, 2, "-fx-background-color: #ff8b00",
                "-fx-font: bold 12 Georgia;");

        HBox postBox = new HBox();
        Label postLbl = new Label("Post Transition Metals");
        addKey(postBox, grid, postLbl, 11, 2, "-fx-background-color: #0b98e4",
                "-fx-font: bold 11 Georgia; -fx-text-fill: BLACK");

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
    
    /*
    * Constructs each button then places in the correct position in the GridPane to form
    * the periodic table.
    */
    private static void addButton(GridPane grid, EventHandler handler, List<Button> btnList, String line, int index){

        // Get button details
        String[] info = line.split(" "); 
        String id = info[0];
        Type type = Type.valueOf(info[1]);
        int x = Integer.parseInt(info[2]);
        int y = Integer.parseInt(info[3]);
       
        // Create button
        String title = (index + 1) + "\n" + id;
        Button tmpBtn = new Button(title);
        tmpBtn.setId(id);
        tmpBtn.setStyle("-fx-base: #" + type.color() + "; -fx-font: bold 13 Georgia;");
        tmpBtn.setPrefWidth(40);
        grid.add(tmpBtn, x, y);
        tmpBtn.setOnAction(handler);
        tmpBtn.setPrefSize(45, 45);

        // add button to list
        btnList.add(index, tmpBtn);
    }

    /*
    * Constructs and formats each portion of the key, then places in correct location
    * in the GridPane.
    */
    private static void addKey(HBox hBox, GridPane grid, Label lbl, int x, int y, String boxStyle, String lblStyle) {
        hBox.setPadding(new Insets(1, 1, 1, 1));
        hBox.setSpacing(1);
        hBox.setStyle(boxStyle);
        lbl.setStyle(lblStyle);
        lbl.setPrefSize(90, 35);
        lbl.setAlignment(Pos.CENTER);
        lbl.setWrapText(true);
        hBox.getChildren().addAll(lbl);
        grid.add(hBox, x, y, 2, 1);
    }

}
