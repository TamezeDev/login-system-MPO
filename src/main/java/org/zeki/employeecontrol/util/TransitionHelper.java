package org.zeki.employeecontrol.util;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.zeki.employeecontrol.controller.app.AppController;


public class TransitionHelper {

    private PauseTransition feedBackTransition = null;

    public void feedBackTransition(Label label) {
        if (feedBackTransition != null) {
            feedBackTransition.stop();
        }
        label.setVisible(true);
        feedBackTransition = new PauseTransition(Duration.seconds(2));
        feedBackTransition.setOnFinished((event) -> {
            label.setVisible(false);
            feedBackTransition = null;
        });
        feedBackTransition.play();
    }

    public static void initialTransition(HBox titleBox, HBox signBox, VBox mainBox) {
        // TITLE & SIGN APPEAR AT 0.5s
        FadeTransition titleBoxTransition = new FadeTransition(Duration.seconds(1), titleBox);
        FadeTransition signBoxTransition = new FadeTransition(Duration.seconds(1), signBox);
        titleBoxTransition.setFromValue(0);
        titleBoxTransition.setToValue(1);
        signBoxTransition.setFromValue(0);
        signBoxTransition.setToValue(1);

        // MAIN FUNCTION APPEAR AT 1s
        FadeTransition mainBoxTransition = new FadeTransition(Duration.seconds(1.5), mainBox);
        mainBoxTransition.setFromValue(0);
        mainBoxTransition.setToValue(1);
        // SEQUENCE
        SequentialTransition sequence = new SequentialTransition(
                titleBoxTransition, signBoxTransition, mainBoxTransition
        );
        sequence.play();
        AppController.getInstance().setStartedApp(true);
    }
}
