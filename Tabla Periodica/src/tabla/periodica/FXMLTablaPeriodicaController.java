/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.periodica;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author geral
 */
public class FXMLTablaPeriodicaController implements Initializable {

    @FXML
    private JFXComboBox<String> ordenamientoComboBox;
    @FXML
    private GridPane tabla_gridPane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        configurarOrdenamientoComboBox();
        
        ObservableList<ContenedorElemento> elementosTabla = FXCollections.observableArrayList();
        
        tabla_gridPane.setMinSize(1,1);
        tabla_gridPane.setHgap(0);
        tabla_gridPane.setVgap(0);
               
        for(int i = 0; i < 18; i++){
            
            for(int j = 0; j < 10; j++){
                ContenedorElemento elemento = new ContenedorElemento(String.valueOf(i), "H", "Hidrogeno", "#c4c4c4");
                GridPane.setHgrow(elemento, Priority.NEVER);
                GridPane.setVgrow(elemento, Priority.NEVER);
                
                elemento.setOnMouseClicked(e -> abrirVentanaInfo(e));

                GridPane.setConstraints(elemento, i, j);
                tabla_gridPane.getChildren().add(elemento);
            }
        }
        
    }

    public void abrirVentanaInfo(MouseEvent event){
        //Aqui va el código para abrir la ventana
        
        ContenedorElemento elemento = (ContenedorElemento) event.getSource();
        System.out.println("Se presionó " + elemento.getNumeroAtomico());
    }
    
    public void configurarOrdenamientoComboBox(){
        ObservableList<String> tiposOrdenamiento = FXCollections.observableArrayList();
        tiposOrdenamiento.addAll("Número atómico", "Símbolo", "Nombre");
        ordenamientoComboBox.getItems().clear();   
        ordenamientoComboBox.getItems().addAll(tiposOrdenamiento);
        ordenamientoComboBox.getSelectionModel().selectFirst();
    }
    
}
