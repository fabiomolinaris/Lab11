package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextArea txtResult;

	@FXML
	void doSimula(ActionEvent event) {
		model.creaTavoli();
		for(int i = 1; i< 2001; i++){
			model.genereArrivoClienti(i);
		}
		model.run();
	}

	@FXML
	void initialize() {
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}
}
