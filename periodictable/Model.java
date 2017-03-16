/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodictable;

import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * This class contains the methods to build and display the atomic model of the
 * element.
 *
 * @author nmartin
 */
public class Model {

    final Group root = new Group();
    final Xform axisGroup = new Xform();
    final Xform atomGroup = new Xform();
    final Xform world = new Xform();
    final PerspectiveCamera camera = new PerspectiveCamera(true);
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
    final Xform atomXform = new Xform();
    private static final double CAMERA_INITIAL_DISTANCE = -450;
    private static final double CAMERA_INITIAL_X_ANGLE = 70.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;
    private static final double AXIS_LENGTH = 250.0;
    private static final double HYDROGEN_ANGLE = 104.5;
    private static final double CONTROL_MULTIPLIER = 0.1;
    private static final double SHIFT_MULTIPLIER = 10.0;
    private static final double MOUSE_SPEED = 0.1;
    private static final double ROTATION_SPEED = 2.0;
    private static final double TRACK_SPEED = 0.3;

    double mousePosX;
    double mousePosY;
    double mouseOldX;
    double mouseOldY;
    double mouseDeltaX;
    double mouseDeltaY;

    public Model() {
    }

    public void displayModel(String elementName) {
        Stage stage = new Stage();

        root.getChildren().add(world);
        root.setDepthTest(DepthTest.ENABLE);

        buildCamera();
        buildModel(elementName);

        Scene scene = new Scene(root, 1024, 768, true);
        scene.setFill(Color.GREY);
        handleMouse(scene, world);

        stage.setTitle("Model");
        stage.setScene(scene);
        stage.show();

        scene.setCamera(camera);
    }

    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        cameraXform3.setRotateZ(180.0);

        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }

    private void handleMouse(Scene scene, final Node root) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseOldX = me.getSceneX();
                mouseOldY = me.getSceneY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseDeltaX = (mousePosX - mouseOldX);
                mouseDeltaY = (mousePosY - mouseOldY);

                double modifier = 1.0;

                if (me.isControlDown()) {
                    modifier = CONTROL_MULTIPLIER;
                }
                if (me.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }
                if (me.isPrimaryButtonDown()) {
                    cameraXform.ry.setAngle(cameraXform.ry.getAngle() - mouseDeltaX * MOUSE_SPEED * modifier * ROTATION_SPEED);
                    cameraXform.rx.setAngle(cameraXform.rx.getAngle() + mouseDeltaY * MOUSE_SPEED * modifier * ROTATION_SPEED);
                } else if (me.isSecondaryButtonDown()) {
                    double z = camera.getTranslateZ();
                    double newZ = z + mouseDeltaX * MOUSE_SPEED * modifier;
                    camera.setTranslateZ(newZ);
                } else if (me.isMiddleButtonDown()) {
                    cameraXform2.t.setX(cameraXform2.t.getX() + mouseDeltaX * MOUSE_SPEED * modifier * TRACK_SPEED);
                    cameraXform2.t.setY(cameraXform2.t.getY() + mouseDeltaY * MOUSE_SPEED * modifier * TRACK_SPEED);
                }
            }
        });
    }

    private void buildModel(String elementName) {

        int protons;
        int neutrons;
        int electrons;

        switch (elementName) {

            case "Hydrogen":
//                protons = 1;
//                neutrons = 0;
//                electrons = 1;
//                buildAtom(protons, neutrons, electrons);
                createNucleus(1, 5);
                break;
            case "Helium":
//                protons = 2;
//                neutrons = 2;
//                electrons = 2;
//                buildAtom(protons, neutrons, electrons);
                createNucleus(2, 5);
                break;
            case "Lithium":
//                protons = 3;
//                neutrons = 4;
//                electrons = 3;
//                buildAtom(protons, neutrons, electrons);
                createNucleus(3, 5);
                break;
            case "Beryllium":
//                protons = 4;
//                neutrons = 5;
//                electrons = 4;
//                buildAtom(protons, neutrons, electrons);
                createNucleus(4, 5);
                break;
            case "Boron":
                protons = 5;
                neutrons = 6;
                electrons = 5;
                buildAtom(protons, neutrons, electrons);
                break;
            case "Carbon":
                protons = 6;
                neutrons = 6;
                electrons = 6;
                buildAtom(protons, neutrons, electrons);
                break;
            case "Nitrogen":
                protons = 7;
                neutrons = 7;
                electrons = 7;
                buildAtom(protons, neutrons, electrons);
                break;
            case "Oxygen":
                protons = 8;
                neutrons = 8;
                electrons = 8;
                buildAtom(protons, neutrons, electrons);
                break;

        }

        atomGroup.getChildren().add(atomXform);

        world.getChildren().addAll(atomGroup);
    }

    private void buildAtom(int protons, int neutrons, int electrons) {
        Sphere[] protonSpheres;
        Sphere[] neutronSpheres;
        Sphere[] electronSpheres;

        protonSpheres = new Sphere[protons];
        neutronSpheres = new Sphere[neutrons];
        electronSpheres = new Sphere[electrons];

        Ellipse orbit1 = EllipseBuilder.create()
                .centerX(0)
                .centerY(0)
                .radiusX(75)
                .radiusY(75)
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(null)
                .build();

        Ellipse orbit2 = EllipseBuilder.create()
                .centerX(0)
                .centerY(0)
                .radiusX(100)
                .radiusY(100)
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(null)
                .build();

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);

        final PhongMaterial greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.DARKGREY);
        greyMaterial.setSpecularColor(Color.GREY);

        final PhongMaterial yellowMaterial = new PhongMaterial();
        yellowMaterial.setDiffuseColor(Color.YELLOW);
        yellowMaterial.setSpecularColor(Color.LIGHTYELLOW);

        for (int i = 0; i < protons; i++) {
            protonSpheres[i] = new Sphere(10.0);
            protonSpheres[i].setMaterial(redMaterial);
            protonSpheres[i].setTranslateX(2 * protons);
            protonSpheres[i].getTransforms().addAll(new Rotate((360 / protons) * i, -2 * protons, 0));
        }

        for (int i = 0; i < neutrons; i++) {
            neutronSpheres[i] = new Sphere(10.0);
            neutronSpheres[i].setMaterial(blueMaterial);
            neutronSpheres[i].setTranslateY(2 * neutrons);
            neutronSpheres[i].getTransforms().addAll(new Rotate((360 / neutrons) * i, 0, -2 * neutrons, 0, new Point3D(1, 0, 0)));
        }

        for (int i = 0; i < electrons; i++) {
            electronSpheres[i] = new Sphere(5.0);
            electronSpheres[i].setMaterial(yellowMaterial);
            if (i < 2) {
                electronSpheres[i].setTranslateX(75);
                electronSpheres[i].getTransforms().addAll(new Rotate((360 / 2) * i, -75, 0));
            }
            if (i >= 2 && i < 10) {
                electronSpheres[i].setTranslateX(100);
                electronSpheres[i].getTransforms().add(new Rotate((360 / 8) * (i - 2), -100, 0));
            }
        }

        for (int i = 0; i < protons; i++) {
            atomXform.getChildren().add(protonSpheres[i]);
        }

        for (int i = 0; i < neutrons; i++) {
            atomXform.getChildren().add(neutronSpheres[i]);
        }

        for (int i = 0; i < electrons; i++) {
            atomXform.getChildren().add(electronSpheres[i]);
        }

        atomXform.getChildren().add(orbit1);

        if (electrons > 2) {
            atomXform.getChildren().add(orbit2);
        }
    }

    public void createNucleus(int atomicNumber, int nucleonRadius) {

        double ratio = nucleonRadius/Math.sqrt(2);
        
        int particles = atomicNumber == 1 ? atomicNumber : atomicNumber * 2; //protons and neutrons
        Point3D[] nucleonPos = {new Point3D(0, 0, 0),
            new Point3D(-nucleonRadius, (2 * ratio), 0),
            new Point3D(-nucleonRadius, (-2 * ratio), 0),
            new Point3D(-nucleonRadius, 0, (2 * ratio)),
            new Point3D(-nucleonRadius, 0, (-2 * ratio)),
            new Point3D(0, nucleonRadius, (-2 * ratio)),
            new Point3D(0, nucleonRadius, (2 * ratio)),
            new Point3D(0, -nucleonRadius, (2 * ratio)),
            new Point3D(0, -nucleonRadius, (-2 * ratio)),
            new Point3D(nucleonRadius, 0, (2 * ratio)),
            new Point3D(nucleonRadius, 0, (-2 * ratio)),
            new Point3D(nucleonRadius, (2 * ratio), 0),
            new Point3D(nucleonRadius, (-2 * ratio), 0),
            new Point3D(2 * nucleonRadius, 0, 0),
            new Point3D(0, 2 * nucleonRadius, 0),
            new Point3D(0, 0, 2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 0, 0),
            new Point3D(0, -2 * nucleonRadius, 0),
            new Point3D(0, 0, -2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, (4 * ratio), 0),
            new Point3D(-2 * nucleonRadius, (-4 * ratio), 0),
            new Point3D(-2 * nucleonRadius, 0, (4 * ratio)),
            new Point3D(-2 * nucleonRadius, 0, (-4 * ratio)),
            new Point3D(0, 2 * nucleonRadius, (-4 * ratio)),
            new Point3D(0, 2 * nucleonRadius, (4 * ratio)),
            new Point3D(0, -2 * nucleonRadius, (4 * ratio)),
            new Point3D(0, -2 * nucleonRadius, (-4 * ratio)),
            new Point3D(2 * nucleonRadius, 0, (4 * ratio)),
            new Point3D(2 * nucleonRadius, 0, (-4 * ratio)),
            new Point3D(2 * nucleonRadius, (4 * ratio), 0),
            new Point3D(2 * nucleonRadius, (-4 * ratio), 0),
            new Point3D(4 * nucleonRadius, 0, 0),
            new Point3D(0, 4 * nucleonRadius, 0),
            new Point3D(0, 0, 4 * nucleonRadius),
            new Point3D(-4 * nucleonRadius, 0, 0),
            new Point3D(0, -4 * nucleonRadius, 0),
            new Point3D(0, 0, -4 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, (2 * ratio), 0),
            new Point3D(-3 * nucleonRadius, (-2 * ratio), 0),
            new Point3D(-3 * nucleonRadius, 0, (2 * ratio)),
            new Point3D(-3 * nucleonRadius, 0, (-2 * ratio)),
            new Point3D(3 * nucleonRadius, 0, (2 * ratio)),
            new Point3D(3 * nucleonRadius, 0, (-2 * ratio)),
            new Point3D(3 * nucleonRadius, (2 * ratio), 0),
            new Point3D(3 * nucleonRadius, (-2 * ratio), 0),
            new Point3D(0, 3 * nucleonRadius, (-2 * ratio)),
            new Point3D(0, 3 * nucleonRadius, (2 * ratio)),
            new Point3D(0, -3 * nucleonRadius, (2 * ratio)),
            new Point3D(0, -3 * nucleonRadius, (-2 * ratio)),
            new Point3D(-2 * nucleonRadius, (2 * ratio), nucleonRadius),
            new Point3D(-2 * nucleonRadius, (-2 * ratio), nucleonRadius),
            new Point3D(-2 * nucleonRadius, (2 * ratio), -nucleonRadius),
            new Point3D(-2 * nucleonRadius, (-2 * ratio), -nucleonRadius),
            new Point3D(-2 * nucleonRadius, 0, (2 * ratio)),
            new Point3D(-2 * nucleonRadius, 0, (-2 * ratio)),
            new Point3D(2 * nucleonRadius, 0, (2 * ratio)),
            new Point3D(2 * nucleonRadius, 0, (-2 * ratio)),
            new Point3D(2 * nucleonRadius, (2 * ratio), 0),
            new Point3D(2 * nucleonRadius, (-2 * ratio), 0),
            new Point3D(2 * nucleonRadius, (2 * ratio), -nucleonRadius),
            new Point3D(2 * nucleonRadius, (-2 * ratio), -nucleonRadius),
            new Point3D(2 * nucleonRadius, (2 * ratio), nucleonRadius),
            new Point3D(2 * nucleonRadius, (-2 * ratio), nucleonRadius),
            new Point3D(-ratio, 2 * nucleonRadius, 0),
            new Point3D(-ratio, -2 * nucleonRadius, 0),
            new Point3D(ratio, 2 * nucleonRadius, 0),
            new Point3D(ratio, -2 * nucleonRadius, 0),
            new Point3D(ratio, 3*nucleonRadius, ratio),
            new Point3D(ratio, 3*nucleonRadius, -ratio),
            new Point3D(ratio, -3*nucleonRadius, -ratio),
            new Point3D(ratio, -3*nucleonRadius, ratio),
            new Point3D(ratio, ratio, 3*nucleonRadius),
            new Point3D(ratio, ratio, -3*nucleonRadius),
            new Point3D(ratio, ratio, -3*nucleonRadius),
            new Point3D(ratio, ratio, 3*nucleonRadius),
            new Point3D(-ratio, 3*nucleonRadius, ratio),
            new Point3D(-ratio, 3*nucleonRadius, -ratio),
            new Point3D(-ratio, -3*nucleonRadius, -ratio),
            new Point3D(-ratio, -3*nucleonRadius, ratio),
            new Point3D(-ratio, ratio, 3*nucleonRadius),
            new Point3D(-ratio, ratio, -3*nucleonRadius),
            new Point3D(-ratio, ratio, -3*nucleonRadius),
            new Point3D(-ratio, ratio, 3*nucleonRadius),
            new Point3D(ratio, -ratio, 3*nucleonRadius),
            new Point3D(ratio, -ratio, -3*nucleonRadius),
            new Point3D(ratio, -ratio, -3*nucleonRadius),
            new Point3D(ratio, -ratio, 3*nucleonRadius),
            new Point3D(-ratio, -ratio, 3*nucleonRadius),
            new Point3D(-ratio, -ratio, -3*nucleonRadius),
            new Point3D(-ratio, -ratio, -3*nucleonRadius),
            new Point3D(-ratio, -ratio, 3*nucleonRadius),
            new Point3D(3*nucleonRadius, -ratio, ratio),
            new Point3D(-3*nucleonRadius, -ratio, ratio),
            new Point3D(3*nucleonRadius, ratio, ratio),
            new Point3D(-3*nucleonRadius, ratio, ratio),
            new Point3D(3*nucleonRadius, -ratio, -ratio),
            new Point3D(-3*nucleonRadius, -ratio, -ratio),
            new Point3D(3*nucleonRadius, ratio, -ratio),
            new Point3D(-3*nucleonRadius, ratio, -ratio),
            new Point3D(4*nucleonRadius, -2*ratio, nucleonRadius),
            new Point3D(-4*nucleonRadius, -2*ratio, nucleonRadius),
            new Point3D(4*nucleonRadius, 2*ratio, nucleonRadius),
            new Point3D(-4*nucleonRadius, 2*ratio, nucleonRadius),
            new Point3D(4*nucleonRadius, -2*ratio, -nucleonRadius),
            new Point3D(-4*nucleonRadius, -2*ratio, -nucleonRadius),
            new Point3D(4*nucleonRadius, 2*ratio, -nucleonRadius),
            new Point3D(-4*nucleonRadius, 2*ratio, -nucleonRadius),
            new Point3D(3*nucleonRadius, -ratio, 2*nucleonRadius),
            new Point3D(-3*nucleonRadius, -ratio, 2*nucleonRadius),
            new Point3D(3*nucleonRadius, ratio, 2*nucleonRadius),
            new Point3D(-3*nucleonRadius, ratio, 2*nucleonRadius),
            new Point3D(3*nucleonRadius, -ratio, -2*nucleonRadius),
            new Point3D(-3*nucleonRadius, -ratio, -2*nucleonRadius),
            new Point3D(3*nucleonRadius, ratio, -2*nucleonRadius),
            new Point3D(-3*nucleonRadius, ratio, -2*nucleonRadius),
            new Point3D(3*nucleonRadius, -2*ratio, 3*nucleonRadius),
            new Point3D(-3*nucleonRadius, -2*ratio, 3*nucleonRadius),
            new Point3D(3*nucleonRadius, 2*ratio, 3*nucleonRadius),
            new Point3D(-3*nucleonRadius, 2*ratio, 3*nucleonRadius),
            new Point3D(3*nucleonRadius, -2*ratio, -3*nucleonRadius),
            new Point3D(-3*nucleonRadius, -2*ratio, -3*nucleonRadius),
            new Point3D(3*nucleonRadius, 2*ratio, -3*nucleonRadius),
            new Point3D(-3*nucleonRadius, 2*ratio, -3*nucleonRadius),
            new Point3D(2*nucleonRadius, -2*ratio, 4*nucleonRadius),
            new Point3D(-2*nucleonRadius, -2*ratio, 4*nucleonRadius),
            new Point3D(2*nucleonRadius, 2*ratio, 4*nucleonRadius),
            new Point3D(-2*nucleonRadius, 2*ratio, 4*nucleonRadius),
            new Point3D(2*nucleonRadius, -2*ratio, -4*nucleonRadius),
            new Point3D(-2*nucleonRadius, -2*ratio, -4*nucleonRadius),
            new Point3D(2*nucleonRadius, 2*ratio, -4*nucleonRadius),
            new Point3D(-2*nucleonRadius, 2*ratio, -4*nucleonRadius),
            new Point3D(nucleonRadius, -2*ratio, 5*nucleonRadius),
            new Point3D(-nucleonRadius, -2*ratio, 5*nucleonRadius),
            new Point3D(nucleonRadius, 2*ratio, 5*nucleonRadius),
            new Point3D(-nucleonRadius, 2*ratio, 5*nucleonRadius),
            new Point3D(nucleonRadius, -2*ratio, -5*nucleonRadius),
            new Point3D(-nucleonRadius, -2*ratio, -5*nucleonRadius),
            new Point3D(nucleonRadius, 2*ratio, -5*nucleonRadius),
            new Point3D(-nucleonRadius, 2*ratio, -5*nucleonRadius),
            new Point3D(-2*nucleonRadius, 3*ratio, -2*nucleonRadius),
            new Point3D(-2*nucleonRadius, 3*ratio, 2*nucleonRadius),
            new Point3D(-2*nucleonRadius, -3*ratio, 2*nucleonRadius),
            new Point3D(-2*nucleonRadius, -3*ratio, -2*nucleonRadius),
            new Point3D(2*nucleonRadius, 3*ratio, 2*nucleonRadius),
            new Point3D(2*nucleonRadius, -3*ratio, -2*nucleonRadius),
            new Point3D(2*nucleonRadius, 3*ratio, -2*nucleonRadius),
            new Point3D(2*nucleonRadius, -3*ratio, 2*nucleonRadius),
            new Point3D(2*nucleonRadius, -4*ratio, 4*ratio),
            new Point3D(2*nucleonRadius, -4*ratio, -4*ratio),
            new Point3D(-2*nucleonRadius, -4*ratio, 4*ratio),
            new Point3D(-2*nucleonRadius, -4*ratio, 4*ratio),
            new Point3D(2*nucleonRadius, 4*ratio, 4*ratio),
            new Point3D(2*nucleonRadius, 4*ratio, -4*ratio),
            new Point3D(-2*nucleonRadius, 4*ratio, 4*ratio),
            new Point3D(-2*nucleonRadius, 4*ratio, -4*ratio),
            new Point3D(nucleonRadius, -4*ratio, -6*ratio),
            new Point3D(-nucleonRadius, -4*ratio, 6*ratio),
            new Point3D(nucleonRadius, 4*ratio, -6*ratio),
            new Point3D(-nucleonRadius, 4*ratio, -6*ratio),
            new Point3D(nucleonRadius, -4*ratio, 6*ratio),
            new Point3D(-nucleonRadius, -4*ratio, -6*ratio),
            new Point3D(nucleonRadius, 4*ratio, 6*ratio),
            new Point3D(-nucleonRadius, 4*ratio, 6*ratio),
            
        };

        addNucleus(particles, nucleonPos, nucleonRadius);
    }

    void addNucleus(int particles, Point3D[] nucleonPos, int nucleonRadius) {

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);

        PhongMaterial[] materials = {redMaterial, blueMaterial};

        for (int i = 0; i < 163; i++) {

            Sphere nucleon = new Sphere(nucleonRadius);

            nucleon.setMaterial(materials[i % 2]);

            nucleon.setTranslateX(nucleonPos[i].getX());
            nucleon.setTranslateY(nucleonPos[i].getY());
            nucleon.setTranslateZ(nucleonPos[i].getZ());

            atomXform.getChildren().add(nucleon);
        }
    }

}
