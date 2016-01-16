package com.capgemini.javafx_starterkit2.model;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ImageBrowser {

	private static final int FIRST_ADRESS = 0;

	private int currentAdress;

	private List<String> adresses;
	private List<File> images;

	public List<String> getAdresses() {
		return adresses;
	}

	public List<File> getImages() {
		return images;
	}

	public String getCurrentAdress() {
		return adresses.get(currentAdress);
	}

	public String getFirstAdress() {
		return adresses.get(FIRST_ADRESS);
	}

	public void setImages(List<File> images) throws MalformedURLException {

		if (!(images == null) && !images.isEmpty()) {
			this.images = images;

			adresses = new ArrayList<String>();

			for (File image : images) {
				adresses.add(image.toURI().toURL().toString());
			}

			currentAdress = FIRST_ADRESS;
		}
	}

	/*
	 * REV: logika przelaczania obrazkow powinna znajdowac sie w kontrolerze
	 */
	public void nextAdress() {

		if (!(images == null) && !images.isEmpty()) {
			if (currentAdress + 1 <= adresses.size() - 1) {
				currentAdress += 1;
			} else {
				currentAdress = FIRST_ADRESS;
			}
		}
	}

	public void prevAdress() {

		if (!(images == null) && !images.isEmpty()) {
			if (currentAdress - 1 >= FIRST_ADRESS) {
				currentAdress -= 1;
			} else {
				currentAdress = adresses.size() - 1;
			}
		}
	}

}
