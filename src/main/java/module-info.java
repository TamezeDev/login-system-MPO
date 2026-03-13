module org.zeki.employeecontrol {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires javafx.graphics;

    opens org.zeki.employeecontrol to javafx.fxml;
    exports org.zeki.employeecontrol;
    exports org.zeki.employeecontrol.controller.scene;
    opens org.zeki.employeecontrol.controller.scene to javafx.fxml;
}