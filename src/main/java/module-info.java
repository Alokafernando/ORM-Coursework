module mental.health.care.center {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires net.sf.jasperreports.core;
    requires java.mail;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires static lombok;
    requires jbcrypt;

    opens org.example.entity to org.hibernate.orm.core;
    opens org.example.config to jakarta.persistence;
    opens org.example.controller to javafx.fxml;
    opens org.example.tdm to javafx.base, javafx.fxml;


    exports org.example;
}
