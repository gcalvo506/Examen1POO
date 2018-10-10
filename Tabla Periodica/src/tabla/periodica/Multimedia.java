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
    WebView videoElemento;
    ImageView imagenAspecto;
    ImageView imagenAtomo;

    public Multimedia() {
    }

    public Multimedia(WebView videoElemento, ImageView imagenAspecto, ImageView imagenAtomo) {
        this.videoElemento = videoElemento;
        this.imagenAspecto = imagenAspecto;
        this.imagenAtomo = imagenAtomo;
    }

    public WebView getVideoElemento() {
        return videoElemento;
    }

    public void setVideoElemento(WebView videoElemento) {
        this.videoElemento = videoElemento;
    }

    public ImageView getImagenAspecto() {
        return imagenAspecto;
    }

    public void setImagenAspecto(ImageView imagenAspecto) {
        this.imagenAspecto = imagenAspecto;
    }

    public ImageView getImagenAtomo() {
        return imagenAtomo;
    }

    public void setImagenAtomo(ImageView imagenAtomo) {
        this.imagenAtomo = imagenAtomo;
    }


}
