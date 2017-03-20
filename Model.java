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
    
    final int nucleonRadius = 3;

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

    //creates the window to display the 3D model
    public void displayModel(Element element) {
        Stage stage = new Stage();

        root.getChildren().add(world);
        root.setDepthTest(DepthTest.ENABLE);

        buildCamera();
        buildModel(element.atomicNumber);

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

    //primary method to begin the model creation.  This method calls the buildAtom method
    private void buildModel(int atomicNumber) {

        buildAtom(atomicNumber);

        atomGroup.getChildren().add(atomXform);

        world.getChildren().addAll(atomGroup);
    }

    /*
    *  This method builds the electrons and places them in the correct orbitals.
    *  It then calls the method createNucleus to handle the nucleus construction.
    */
    private void buildAtom(int atomicNumber) {
        
        Sphere[] electronSpheres;
;
        electronSpheres = new Sphere[atomicNumber];

        Ellipse orbit1 = EllipseBuilder.create()
                .centerX(0)
                .centerY(0)
                .radiusX(50)
                .radiusY(50)
                .strokeWidth(0.5)
                .stroke(Color.BLACK)
                .fill(null)
                .build();

        Ellipse orbit2 = EllipseBuilder.create()
                .centerX(0)
                .centerY(0)
                .radiusX(75)
                .radiusY(75)
                .strokeWidth(0.5)
                .stroke(Color.BLACK)
                .fill(null)
                .build();

        final PhongMaterial greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.DARKGREY);
        greyMaterial.setSpecularColor(Color.GREY);

        final PhongMaterial yellowMaterial = new PhongMaterial();
        yellowMaterial.setDiffuseColor(Color.YELLOW);
        yellowMaterial.setSpecularColor(Color.LIGHTYELLOW);

        for (int i = 0; i < atomicNumber; i++) {
            electronSpheres[i] = new Sphere(1.5);
            electronSpheres[i].setMaterial(yellowMaterial);
            if (i < 2) {
                electronSpheres[i].setTranslateX(50);
                electronSpheres[i].getTransforms().addAll(new Rotate((360 / 2) * i, -50, 0));
            }
            if (i >= 2 && i < 10) {
                electronSpheres[i].setTranslateX(75);
                electronSpheres[i].getTransforms().add(new Rotate((360 / 8) * (i - 2), -75, 0));
            }
        }

        for (int i = 0; i < atomicNumber; i++) {
            atomXform.getChildren().add(electronSpheres[i]);
        }

        atomXform.getChildren().add(orbit1);

        if (atomicNumber > 2) {
            atomXform.getChildren().add(orbit2);
        }
        
        createNucleus(atomicNumber);
    }

    /*
    *  This method contains the array of positions for each nucleon.
    *  These values are passed to the addNucleus method to construct the nucleus
    *  and add it to the window.
    */
    public void createNucleus(int atomicNumber) {

        double ratio = nucleonRadius / Math.sqrt(2);

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
            new Point3D(ratio, 3 * nucleonRadius, ratio),
            new Point3D(ratio, 3 * nucleonRadius, -ratio),
            new Point3D(ratio, -3 * nucleonRadius, -ratio),
            new Point3D(ratio, -3 * nucleonRadius, ratio),
            new Point3D(ratio, ratio, 3 * nucleonRadius),
            new Point3D(ratio, ratio, -3 * nucleonRadius),
            new Point3D(ratio, ratio, -3 * nucleonRadius),
            new Point3D(ratio, ratio, 3 * nucleonRadius),
            new Point3D(-ratio, 3 * nucleonRadius, ratio),
            new Point3D(-ratio, 3 * nucleonRadius, -ratio),
            new Point3D(-ratio, -3 * nucleonRadius, -ratio),
            new Point3D(-ratio, -3 * nucleonRadius, ratio),
            new Point3D(-ratio, ratio, 3 * nucleonRadius),
            new Point3D(-ratio, ratio, -3 * nucleonRadius),
            new Point3D(-ratio, ratio, -3 * nucleonRadius),
            new Point3D(-ratio, ratio, 3 * nucleonRadius),
            new Point3D(ratio, -ratio, 3 * nucleonRadius),
            new Point3D(ratio, -ratio, -3 * nucleonRadius),
            new Point3D(ratio, -ratio, -3 * nucleonRadius),
            new Point3D(ratio, -ratio, 3 * nucleonRadius),
            new Point3D(-ratio, -ratio, 3 * nucleonRadius),
            new Point3D(-ratio, -ratio, -3 * nucleonRadius),
            new Point3D(-ratio, -ratio, -3 * nucleonRadius),
            new Point3D(-ratio, -ratio, 3 * nucleonRadius),
            new Point3D(3 * nucleonRadius, -ratio, ratio),
            new Point3D(-3 * nucleonRadius, -ratio, ratio),
            new Point3D(3 * nucleonRadius, ratio, ratio),
            new Point3D(-3 * nucleonRadius, ratio, ratio),
            new Point3D(3 * nucleonRadius, -ratio, -ratio),
            new Point3D(-3 * nucleonRadius, -ratio, -ratio),
            new Point3D(3 * nucleonRadius, ratio, -ratio),
            new Point3D(-3 * nucleonRadius, ratio, -ratio),
            new Point3D(4 * nucleonRadius, -2 * ratio, nucleonRadius),
            new Point3D(-4 * nucleonRadius, -2 * ratio, nucleonRadius),
            new Point3D(4 * nucleonRadius, 2 * ratio, nucleonRadius),
            new Point3D(-4 * nucleonRadius, 2 * ratio, nucleonRadius),
            new Point3D(4 * nucleonRadius, -2 * ratio, -nucleonRadius),
            new Point3D(-4 * nucleonRadius, -2 * ratio, -nucleonRadius),
            new Point3D(4 * nucleonRadius, 2 * ratio, -nucleonRadius),
            new Point3D(-4 * nucleonRadius, 2 * ratio, -nucleonRadius),
            new Point3D(3 * nucleonRadius, -ratio, 2 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, -ratio, 2 * nucleonRadius),
            new Point3D(3 * nucleonRadius, ratio, 2 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, ratio, 2 * nucleonRadius),
            new Point3D(3 * nucleonRadius, -ratio, -2 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, -ratio, -2 * nucleonRadius),
            new Point3D(3 * nucleonRadius, ratio, -2 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, ratio, -2 * nucleonRadius),
            new Point3D(3 * nucleonRadius, -2 * ratio, 3 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, -2 * ratio, 3 * nucleonRadius),
            new Point3D(3 * nucleonRadius, 2 * ratio, 3 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, 2 * ratio, 3 * nucleonRadius),
            new Point3D(3 * nucleonRadius, -2 * ratio, -3 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, -2 * ratio, -3 * nucleonRadius),
            new Point3D(3 * nucleonRadius, 2 * ratio, -3 * nucleonRadius),
            new Point3D(-3 * nucleonRadius, 2 * ratio, -3 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -2 * ratio, 4 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -2 * ratio, 4 * nucleonRadius),
            new Point3D(2 * nucleonRadius, 2 * ratio, 4 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 2 * ratio, 4 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -2 * ratio, -4 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -2 * ratio, -4 * nucleonRadius),
            new Point3D(2 * nucleonRadius, 2 * ratio, -4 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 2 * ratio, -4 * nucleonRadius),
            new Point3D(nucleonRadius, -2 * ratio, 5 * nucleonRadius),
            new Point3D(-nucleonRadius, -2 * ratio, 5 * nucleonRadius),
            new Point3D(nucleonRadius, 2 * ratio, 5 * nucleonRadius),
            new Point3D(-nucleonRadius, 2 * ratio, 5 * nucleonRadius),
            new Point3D(nucleonRadius, -2 * ratio, -5 * nucleonRadius),
            new Point3D(-nucleonRadius, -2 * ratio, -5 * nucleonRadius),
            new Point3D(nucleonRadius, 2 * ratio, -5 * nucleonRadius),
            new Point3D(-nucleonRadius, 2 * ratio, -5 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 3 * ratio, -2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 3 * ratio, 2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -3 * ratio, 2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -3 * ratio, -2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, 3 * ratio, 2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -3 * ratio, -2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, 3 * ratio, -2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -3 * ratio, 2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -4 * ratio, 4 * ratio),
            new Point3D(2 * nucleonRadius, -4 * ratio, -4 * ratio),
            new Point3D(-2 * nucleonRadius, -4 * ratio, 4 * ratio),
            new Point3D(-2 * nucleonRadius, -4 * ratio, -4 * ratio),
            new Point3D(2 * nucleonRadius, 4 * ratio, 4 * ratio),
            new Point3D(2 * nucleonRadius, 4 * ratio, -4 * ratio),
            new Point3D(-2 * nucleonRadius, 4 * ratio, 4 * ratio),
            new Point3D(-2 * nucleonRadius, 4 * ratio, -4 * ratio),
            new Point3D(nucleonRadius, -4 * ratio, -6 * ratio),
            new Point3D(-nucleonRadius, -4 * ratio, 6 * ratio),
            new Point3D(nucleonRadius, 4 * ratio, -6 * ratio),
            new Point3D(-nucleonRadius, 4 * ratio, -6 * ratio),
            new Point3D(nucleonRadius, -4 * ratio, 6 * ratio),
            new Point3D(-nucleonRadius, -4 * ratio, -6 * ratio),
            new Point3D(nucleonRadius, 4 * ratio, 6 * ratio),
            new Point3D(-nucleonRadius, 4 * ratio, 6 * ratio),
            new Point3D(-3 * nucleonRadius, 4 * ratio, 2 * ratio),
            new Point3D(-3 * nucleonRadius, -4 * ratio, 2 * ratio),
            new Point3D(-3 * nucleonRadius, 4 * ratio, -2 * ratio),
            new Point3D(-3 * nucleonRadius, -4 * ratio, -2 * ratio),
            new Point3D(3 * nucleonRadius, 4 * ratio, 2 * ratio),
            new Point3D(3 * nucleonRadius, -4 * ratio, -2 * ratio),
            new Point3D(3 * nucleonRadius, -4 * ratio, 2 * ratio),
            new Point3D(3 * nucleonRadius, 4 * ratio, -2 * ratio),
            new Point3D(-5 * nucleonRadius, 0, 2 * ratio),
            new Point3D(-5 * nucleonRadius, 0, 2 * ratio),
            new Point3D(-5 * nucleonRadius, 0, -2 * ratio),
            new Point3D(-5 * nucleonRadius, 0, -2 * ratio),
            new Point3D(5 * nucleonRadius, 0, 2 * ratio),
            new Point3D(5 * nucleonRadius, 0, -2 * ratio),
            new Point3D(5 * nucleonRadius, 0, 2 * ratio),
            new Point3D(5 * nucleonRadius, 0, -2 * ratio),
            new Point3D(-4 * nucleonRadius, 0, 4 * ratio),
            new Point3D(-4 * nucleonRadius, 0, 4 * ratio),
            new Point3D(-4 * nucleonRadius, 0, -4 * ratio),
            new Point3D(-4 * nucleonRadius, 0, -4 * ratio),
            new Point3D(4 * nucleonRadius, 0, 4 * ratio),
            new Point3D(4 * nucleonRadius, 0, -4 * ratio),
            new Point3D(4 * nucleonRadius, 0, 4 * ratio),
            new Point3D(4 * nucleonRadius, 0, -4 * ratio),
            new Point3D(-3 * nucleonRadius, 0, 6 * ratio),
            new Point3D(-3 * nucleonRadius, 0, 6 * ratio),
            new Point3D(-3 * nucleonRadius, 0, -6 * ratio),
            new Point3D(-3 * nucleonRadius, 0, -6 * ratio),
            new Point3D(3 * nucleonRadius, 0, 6 * ratio),
            new Point3D(3 * nucleonRadius, 0, -6 * ratio),
            new Point3D(3 * nucleonRadius, 0, 6 * ratio),
            new Point3D(3 * nucleonRadius, 0, -6 * ratio),
            new Point3D(-2 * nucleonRadius, 0, 8 * ratio),
            new Point3D(-2 * nucleonRadius, 0, 8 * ratio),
            new Point3D(-2 * nucleonRadius, 0, -8 * ratio),
            new Point3D(-2 * nucleonRadius, 0, -8 * ratio),
            new Point3D(2 * nucleonRadius, 0, 8 * ratio),
            new Point3D(2 * nucleonRadius, 0, -8 * ratio),
            new Point3D(2 * nucleonRadius, 0, 8 * ratio),
            new Point3D(2 * nucleonRadius, 0, -8 * ratio),
            new Point3D(3 * nucleonRadius, 4 * nucleonRadius, 0),
            new Point3D(4 * nucleonRadius, 3 * nucleonRadius, 0),
            new Point3D(5 * nucleonRadius, 2 * nucleonRadius, 0),
            new Point3D(6 * nucleonRadius, 0, 0),
            new Point3D(-3 * nucleonRadius, 4 * nucleonRadius, 0),
            new Point3D(-4 * nucleonRadius, 3 * nucleonRadius, 0),
            new Point3D(-5 * nucleonRadius, 2 * nucleonRadius, 0),
            new Point3D(-6 * nucleonRadius, 0, 0),
            new Point3D(-3 * nucleonRadius, -4 * nucleonRadius, 0),
            new Point3D(-4 * nucleonRadius, -3 * nucleonRadius, 0),
            new Point3D(-5 * nucleonRadius, -2 * nucleonRadius, 0),
            new Point3D(3 * nucleonRadius, -4 * nucleonRadius, 0),
            new Point3D(4 * nucleonRadius, -3 * nucleonRadius, 0),
            new Point3D(5 * nucleonRadius, -2 * nucleonRadius, 0),
            new Point3D(2 * nucleonRadius, 4 * nucleonRadius, 2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 4 * nucleonRadius, 2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -4 * nucleonRadius, 2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, 4 * nucleonRadius, -2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, 4 * nucleonRadius, -2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -4 * nucleonRadius, -2 * nucleonRadius),
            new Point3D(2 * nucleonRadius, -4 * nucleonRadius, -2 * nucleonRadius),
            new Point3D(-2 * nucleonRadius, -4 * nucleonRadius, 2 * nucleonRadius),
            new Point3D(3 * nucleonRadius, -4 * nucleonRadius, nucleonRadius),
            new Point3D(3 * nucleonRadius, 4 * nucleonRadius, -nucleonRadius),
            new Point3D(3 * nucleonRadius, -4 * nucleonRadius, -nucleonRadius),
            new Point3D(-3 * nucleonRadius, -4 * nucleonRadius, -nucleonRadius),
            new Point3D(-3 * nucleonRadius, 4 * nucleonRadius, -nucleonRadius),
            new Point3D(-3 * nucleonRadius, -4 * nucleonRadius, nucleonRadius),
            new Point3D(-3 * nucleonRadius, 4 * nucleonRadius, nucleonRadius),
            new Point3D(3 * nucleonRadius, 4 * nucleonRadius, nucleonRadius),
            new Point3D(0, 0, 6 * nucleonRadius),
            new Point3D(0, 0, -6 * nucleonRadius),
            new Point3D(0, 4 * nucleonRadius, 3 * nucleonRadius)
        };

        addNucleus(particles, nucleonPos, nucleonRadius);

    }

    /*
    *  This method uses the positions from the createNucleus method to place each
    *  nucleon in the correct position.  It then assigns the material based on an
    *  even/odd basis.
    */
    void addNucleus(int particles, Point3D[] nucleonPos, int nucleonRadius) {

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);

        PhongMaterial[] materials = {redMaterial, blueMaterial};

        for (int i = 0; i < particles; i++) {

            Sphere nucleon = new Sphere(nucleonRadius);

            nucleon.setMaterial(materials[i % 2]);

            nucleon.setTranslateX(nucleonPos[i].getX());
            nucleon.setTranslateY(nucleonPos[i].getY());
            nucleon.setTranslateZ(nucleonPos[i].getZ());

            atomXform.getChildren().add(nucleon);
        }
    }

}
