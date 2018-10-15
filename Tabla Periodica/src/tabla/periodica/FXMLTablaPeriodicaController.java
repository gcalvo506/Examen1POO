/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.periodica;

import com.jfoenix.controls.JFXComboBox;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
    @FXML
    private Label nombreElemento_label;
    @FXML
    private WebView videoWebview;
    @FXML
    private Label simbolo_label;
    @FXML
    private Label numeroMasico_label;
    @FXML
    private Label numeroAtomico_label;
    @FXML
    private Label familia_label;
    @FXML
    private Label grupo_label;
    @FXML
    private Label periodo_label;
    @FXML
    private Label bloque_label;
    @FXML
    private Label puntoFusion_label;
    @FXML
    private Label puntoEbullision_label;
    @FXML
    private Label isotopo_label;
    @FXML
    private Label metodoObtencion_label;
    @FXML
    private Label lugarObtencion_label;
    @FXML
    private Label usos_label;
    @FXML
    private ImageView imagenAspecto_imageView;
    @FXML
    private ImageView imagenAtomo_imageView;
    @FXML
    private Label reseniaHistorica_label;
    @FXML
    private Label formaPolimorfica_label;
    
    private WebEngine engine;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Manager.cargarElementos();
        configurarOrdenamientoComboBox();
        Manager.ordenarListaPorNumeroAtomico();
        cargarTablaElementos();
        abrirVentanaTabla();
        engine = videoWebview.getEngine();
        
    }

    public void abrirVentanaInfo(MouseEvent event){
        //Aqui va el código para abrir la ventana
        
        tablaElementos_pane.toBack();
        tablaElementos_pane.setVisible(false);
        
        informacion_pane.toFront();
        informacion_pane.setVisible(true);
        
        ContenedorElemento contenedor = (ContenedorElemento) event.getSource();
        Elemento elemento = contenedor.getElemento();
        
        
        // Llenar los campos de información de la ventana con los de el elemento seleccionado
        nombreElemento_label.setText(elemento.getPropiedadesQuimicas().getNombre());
        simbolo_label.setText(elemento.getPropiedadesQuimicas().getSimbolo());
        numeroMasico_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getNumeroMasico()));
        numeroAtomico_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getNumeroAtomico()));
        familia_label.setText(elemento.getPropiedadesQuimicas().getFamilia());
        grupo_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getGrupo()));
        periodo_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getPeriodo()));
        bloque_label.setText(elemento.getPropiedadesQuimicas().getBloque());
        puntoFusion_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getPuntoFusion()) + "°C");
        formaPolimorfica_label.setText(elemento.getDatos().getProduccion().getFormaPolimorfica());
        puntoEbullision_label.setText(String.valueOf(elemento.getPropiedadesQuimicas().getPuntoEbullicion()) + "°C");
        reseniaHistorica_label.setText(elemento.getDatos().getResenaHistorica());
        
        if(elemento.getDatos().isIsIsotopo()){
            isotopo_label.setText("Sí");
        } else {
            isotopo_label.setText("No");
        }
        
        metodoObtencion_label.setText(elemento.getDatos().getProduccion().getMetodoObtencion());
        lugarObtencion_label.setText(elemento.getDatos().getProduccion().getLugarDeObtencion());
        
        ArrayList<String> listaUsos = elemento.getDatos().getListaUsos();
        String usos = "";
        for(String uso : listaUsos){
            usos += uso + "\n\n";
        }
        
        usos_label.setText(usos);
        
        engine.loadContent("<html><body>" + elemento.getMultimedia().getVideoElemento() + "</body></html>");
        

        imagenAspecto_imageView.setImage(null);
        InputStream rutaImagenAspecto = this.getClass().getResourceAsStream("res/" + elemento.getMultimedia().getImagenAspecto());
        if(rutaImagenAspecto != null){
            Image imagenAspecto = new Image(rutaImagenAspecto);
            imagenAspecto_imageView.setImage(imagenAspecto);
        } else {
            System.err.println("Imagen de aspecto no encontrada");
        }
        
        imagenAtomo_imageView.setImage(null);
        InputStream rutaImagenAtomo = this.getClass().getResourceAsStream("res/" + elemento.getMultimedia().getImagenAtomo());
        if(rutaImagenAspecto != null){
            Image imagenAtomo = new Image(rutaImagenAtomo);
            imagenAtomo_imageView.setImage(imagenAtomo);
        } else {
            System.err.println("Imagen de atomo no encontrada");
        }
        
        
        
        
    }
    
    @FXML
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
