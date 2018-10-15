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
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane informacion_pane;
    @FXML
    private Pane tablaElementos_pane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Manager.cargarElementos();
        configurarOrdenamientoComboBox();
        Manager.ordenarListaPorNumeroAtomico();
        cargarTablaElementos();
        abrirVentanaTabla();
        
        
    }

    public void abrirVentanaInfo(MouseEvent event){
        //Aqui va el código para abrir la ventana
        
        tablaElementos_pane.toBack();
        tablaElementos_pane.setVisible(false);
        
        informacion_pane.toFront();
        informacion_pane.setVisible(true);
        
        ContenedorElemento contenedor = (ContenedorElemento) event.getSource();
        Elemento elemento = contenedor.getElemento();
        System.out.println("Se presionó " + elemento.getPropiedadesQuimicas().getNombre());
        
        // Llenar los campos de información de la ventana con los de el elemento seleccionado
        
    }
    
    public void abrirVentanaTabla(){
        informacion_pane.toBack();
        informacion_pane.setVisible(false);
        
        tablaElementos_pane.toFront();
        tablaElementos_pane.setVisible(true);
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
        
        String colorPorDefecto = "#f4f4f4";
        
        int cantElementos = Manager.getListaElementos().size();
        int numeroElementoActual = 0;
        
               
        for(int i = 0; i < 10; i++){
            
            for(int j = 0; j < 18; j++){
                
                ContenedorElemento elemento = null;
                if(numeroElementoActual < cantElementos){
                    
                    if(i == 0 && (j > 0 && j < 17)){
                        elemento = new ContenedorElemento("", "", "", colorPorDefecto, null);
                    } else if ((i == 1 || i == 2) && (j > 1 && j < 12)){
                        elemento = new ContenedorElemento("", "", "", colorPorDefecto, null);
                    } else {
                        String numeroAtomico = String.valueOf(Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getNumeroAtomico());
                        String simbolo = Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getSimbolo();
                        String nombre = Manager.getListaElementos().get(numeroElementoActual).getPropiedadesQuimicas().getNombre();
                        String color = Manager.getListaElementos().get(numeroElementoActual).getColor();

                        elemento = new ContenedorElemento(numeroAtomico, simbolo, nombre, color,Manager.getListaElementos().get(numeroElementoActual));
                        elemento.setOnMouseClicked(e -> abrirVentanaInfo(e));
                        numeroElementoActual++;
                    }

                }else{
                    elemento = new ContenedorElemento("", "", "", colorPorDefecto, null);
                }
                
                
                GridPane.setHgrow(elemento, Priority.NEVER);
                GridPane.setVgrow(elemento, Priority.NEVER);  

                GridPane.setConstraints(elemento, j, i);
                tabla_gridPane.getChildren().add(elemento);
            }
        }
    }

    @FXML
    private void ordenarElementosTabla(ActionEvent event) {
        String tipoOrdenamiento = ordenamientoComboBox.getValue();
        
        if (tipoOrdenamiento.equals("Número atómico")){
            Manager.ordenarListaPorNumeroAtomico();
        } else if(tipoOrdenamiento.equals("Símbolo")){
            Manager.ordenarListaPorSimbolo();
        } else {
            Manager.ordenarListaPorNombre();;
        }
        cargarTablaElementos();
    }
    
}
