package com.capgemini.javafx_starterkit2.controller;

import java.net.MalformedURLException;

import com.capgemini.javafx_starterkit2.model.ImageBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ImageBrowserController {

	@FXML
	private Button openButton;

	@FXML
	private ImageView imageView;

	@FXML
	private Button prevButton;

	@FXML
	private Button slideshowButton;

	@FXML
	private Button nextButton;

	private ImageBrowser model = new ImageBrowser();

	public ImageBrowserController() {
	}

	@FXML
	private void openButtonAction(ActionEvent event) throws MalformedURLException {

		FileChooser fileChooser = new FileChooser();
		/*
		 * REV: teksty powinny byc pobrane z bundle
		 */
		fileChooser.setTitle("Open Resource File");

		ExtensionFilter mostUsedImageExtensionsFilter = new FileChooser.ExtensionFilter("Images", "*.jpg", "*.tif",
				"*.png", "*.gif", "*.bmp");
		ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG", "*.jpg");
		ExtensionFilter tifFilter = new FileChooser.ExtensionFilter("JPG", "*.tif");
		ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("JPG", "*.png");
		ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("JPG", "*.gif");
		ExtensionFilter bmpFilter = new FileChooser.ExtensionFilter("JPG", "*.bmp");

		fileChooser.getExtensionFilters().addAll(mostUsedImageExtensionsFilter, jpgFilter, tifFilter, pngFilter,
				gifFilter, bmpFilter);

		/*
		 * REV: okno wyboru plikow poiwnno byc modalne, new Stage() nie jesr rozwiazaniem
		 */
		model.setImages(fileChooser.showOpenMultipleDialog(new Stage()));

		showImage();
	}

	@FXML
	private void prevButtonAction(ActionEvent event) {

		model.prevAdress();

		showImage();
	}

	@FXML
	private void nextButtonAction(ActionEvent event) {

		model.nextAdress();

		showImage();
	}

	@FXML
	private void slideshowButtonAction(ActionEvent event) {

	}

	private void showImage() {

		if (!(model.getAdresses() == null) && !model.getImages().isEmpty()) {
			Image value = new Image(model.getCurrentAdress());
			imageView.setImage(value);
		} else {
			showNoImageInformation();
		}
	}

	private void showNoImageInformation() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		/*
		 * REV: teksty powinny byc pobrane z bundle
		 */
		alert.setTitle("Information");
		alert.setContentText("No image selected");
		alert.showAndWait();
	}

}
