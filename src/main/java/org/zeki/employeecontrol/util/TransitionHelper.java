package org.zeki.employeecontrol.util;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class TransitionHelper {

    private PauseTransition feedBackTransition = null;

    public void hideFeedBackLabel(Label label) {
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
}
