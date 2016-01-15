package com.capgemini.javafx_starterkit2;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Startup extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		String langCode = getParameters().getNamed().get("lang");
		if (langCode != null && !langCode.isEmpty()) {
			Locale.setDefault(Locale.forLanguageTag(langCode));
		}

		primaryStage.setTitle("StarterKit-JavaFX");

		Parent root = FXMLLoader.load(
				getClass().getResource("/com/capgemini/javafx_starterkit2/view/image-browser.fxml"), //
				ResourceBundle.getBundle("com/capgemini/javafx_starterkit2/base/base"));

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
