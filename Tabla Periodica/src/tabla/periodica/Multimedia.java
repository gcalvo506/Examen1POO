/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.periodica;

import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

/**
 *
 * @author geral
 */
public class Multimedia {
    private String videoElemento;
    private String imagenAspecto;
    private String imagenAtomo;

    public Multimedia() {
    }

    public Multimedia(String videoElemento, String imagenAspecto, String imagenAtomo) {
        this.videoElemento = videoElemento;
        this.imagenAspecto = imagenAspecto;
        this.imagenAtomo = imagenAtomo;
    }

    public String getVideoElemento() {
        return videoElemento;
    }

    public void setVideoElemento(String videoElemento) {
        this.videoElemento = videoElemento;
    }

    public String getImagenAspecto() {
        return imagenAspecto;
    }

    public void setImagenAspecto(String imagenAspecto) {
        this.imagenAspecto = imagenAspecto;
    }

    public String getImagenAtomo() {
        return imagenAtomo;
    }

    public void setImagenAtomo(String imagenAtomo) {
        this.imagenAtomo = imagenAtomo;
    }

}
