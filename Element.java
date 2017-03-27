/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodictable;

/**
 *
 * @author nmartin
 */
public class Element {

    String name;
    String phase;
    double meltPoint;
    double boilPoint;
    double heatFusion;
    double heatVapor;
    int atomicNumber;

    public Element(String name, int atomicNumber, String phase, double meltPoint,
            double boilPoint, double heatFusion, double heatVapor) {

        this.name = name;
        this.atomicNumber = atomicNumber;
        this.phase = phase;
        this.meltPoint = meltPoint;
        this.boilPoint = boilPoint;
        this.heatFusion = heatFusion;
        this.heatVapor = heatVapor;

    }

}
