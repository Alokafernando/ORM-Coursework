module mental.health.care.center {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.desktop;
    requires net.sf.jasperreports.core;
    requires java.mail;
    requires jbcrypt;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires com.google.protobuf;

    opens org.example.entity to org.hibernate.orm.core;
    opens org.example.config to jakarta.persistence;
    opens org.example.view.tdm to javafx.base;
    opens org.example.controller to javafx.fxml;

    exports org.example;
}