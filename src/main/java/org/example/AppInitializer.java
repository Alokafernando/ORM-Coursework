package org.example;


import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.config.FactoryConfiguration;
import org.example.entity.User;
import org.example.util.EncryptionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class AppInitializer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/loadingFx.fxml"));
        stage.setScene(new Scene(load));
        stage.show();

//        setAdmin();

        Task<Scene> loadingTask = new Task<Scene>() {
            @Override
            protected Scene call() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/loginFx.fxml"));
//                FXMLLoader fxmlLoader = new FXMLLoader(AppInitializer.class.getResource("/view/adminDashboardFx.fxml"));
                return new Scene(fxmlLoader.load());
            }
        };

        loadingTask.setOnSucceeded(event -> {
            Scene value = loadingTask.getValue();

            stage.setTitle("Serenity");
            Image image = new Image(getClass().getResourceAsStream("/images/logo.png"));
            stage.getIcons().add(image);

//            stage.setResizable(false);

            stage.setScene(value);
        });

        new Thread(loadingTask).start();
    }


    private void setAdmin() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
//        user.setUserId("1");
        user.setName("admin");
        user.setEmail("admin@gmail.com");
        user.setPhone("0764267067");
        String hashPassword = EncryptionUtil.hashPassword("1234");
        user.setPassword(hashPassword);
        user.setRole("admin");

        session.save(user);
        transaction.commit();

        session.close();
    }

    public static void main(String[] args) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        session.close();
        launch();
    }
}
