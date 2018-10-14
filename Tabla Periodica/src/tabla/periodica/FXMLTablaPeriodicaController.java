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
        Manager.cargarElementos();
        configurarOrdenamientoComboBox();
        
        cargarTablaElementos();
        
        
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
    
    public void cargarTablaElementos(){
        ObservableList<ContenedorElemento> elementosTabla = FXCollections.observableArrayList();
        
        tabla_gridPane.setMinSize(1,1);
        tabla_gridPane.setHgap(0);
        tabla_gridPane.setVgap(0);
        
        int cantElementos = Manager.getListaElementos().size();
        int numeroElementoActual = 0;
        
        Manager.ordenarListaPorSimbolo();
               
        for(int i = 0; i < 10; i++){
            
            for(int j = 0; j < 18; j++){
                
                ContenedorElemento elemento = null;
                if(numeroElementoActual < cantElementos){
                    
                    String numeroAtomico = String.valueOf(Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getNumeroAtomico());
                    String simbolo = Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getSimbolo();
                    String nombre = Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getNombre();
                    String color = Manager.getListaElementos().get(numeroElementoActual).getColor();
                    
                    elemento = new ContenedorElemento(numeroAtomico, simbolo, nombre, color);
                    elemento.setOnMouseClicked(e -> abrirVentanaInfo(e));
                    numeroElementoActual++;
                }else{
                    elemento = new ContenedorElemento("", "", "", "#ffffff");
                }
                
                
                GridPane.setHgrow(elemento, Priority.NEVER);
                GridPane.setVgrow(elemento, Priority.NEVER);  

                GridPane.setConstraints(elemento, j, i);
                tabla_gridPane.getChildren().add(elemento);
            }
        }
    }
    
}
