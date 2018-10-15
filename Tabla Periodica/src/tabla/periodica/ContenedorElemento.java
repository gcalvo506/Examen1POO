/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.periodica;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author bryan
 */
public class ContenedorElemento extends VBox {
    
    private Label nombreLabel;
    private Label simboloLabel;
    private Label numeroAtomicoLabel;
    private Elemento elemento;
    
    public ContenedorElemento(String numeroAtomico, String simbolo, String nombre, String color, Elemento elemento){
        super();
        this.elemento = elemento;
        double dimensiones = 65;
        
        double escalaNombre = 0.6;
        nombreLabel = new Label(nombre);
        nombreLabel.setScaleX(escalaNombre);
        nombreLabel.setScaleY(escalaNombre);
        //nombreLabel.setMinWidth(USE_PREF_SIZE);  //Esta linea es para que no se corten los nombres
        
        double escalaSimbolo = 1.2;
        simboloLabel = new Label(simbolo);
        simboloLabel.setScaleX(escalaSimbolo);
        simboloLabel.setScaleY(escalaSimbolo);
        
        numeroAtomicoLabel = new Label(numeroAtomico);
        numeroAtomicoLabel.setScaleX(escalaNombre);
        numeroAtomicoLabel.setScaleY(escalaNombre);
        
        setStyle("-fx-background-color: " + color);
        getStyleClass().add("elemento");
        
        getChildren().addAll(numeroAtomicoLabel, simboloLabel, nombreLabel);
        setMaxHeight(dimensiones);
        setMaxWidth(dimensiones);
        setAlignment(Pos.CENTER);
        
        String css = "";
        
        if (nombre.equals("")){
            css = "-fx-background-color: " + color + ";\n";
        } else {
            css = "-fx-border-color: black;\n" +
                   "-fx-border-width: 1;\n" +
                   "-fx-background-color: " + color + ";\n";
        }
        
        
        setStyle(css);
    }
    
    public String getNombre(){
        return nombreLabel.getText();
    }
    
    public String getSimbolo(){
        return simboloLabel.getText();
    }
    
    public String getNumeroAtomico(){
        return numeroAtomicoLabel.getText();
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
    
}
