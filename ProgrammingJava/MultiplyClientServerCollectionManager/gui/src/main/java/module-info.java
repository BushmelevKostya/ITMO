module com.gui {
	requires javafx.controls;
	requires javafx.fxml;
	
	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires common;
	
//	opens com.gui to javafx.fxml;
//	exports com.gui;
	opens gui to javafx.fxml;
}