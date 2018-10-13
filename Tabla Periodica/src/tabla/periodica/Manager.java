/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla.periodica;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author geral
 */
public abstract class Manager {

    private static ArrayList<Elemento> listaElementos = new ArrayList();

    public static ArrayList<Elemento> getListaElementos() {
        return listaElementos;
    }

    public static void cargarElementos(){
    JSONParser parser= new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("TablaPeriodicaJSON.txt"));
            JSONArray elementosJSONArray =(JSONArray)obj;
            Elemento elemento;
            for(int i = 0;i<elementosJSONArray.size();i++){
                JSONObject elementoJSON = (JSONObject)elementosJSONArray.get(i);

                Produccion produccion = new Produccion();
                produccion.setFormaPolimorfica(elementoJSON.get("FormaPolimorfica").toString());
                produccion.setLugarDeObtencion(elementoJSON.get("LugarDeObtencion").toString());
                produccion.setMetodoObtencion(elementoJSON.get("MetodoObtencion").toString());
                
                Datos datos = new Datos();
                datos.setResenaHistorica(elementoJSON.get("ResenaHistorica").toString());
                datos.setIsIsotopo(Boolean.parseBoolean(elementoJSON.get("IsIsotopo").toString()));
                datos.setProduccion(produccion);
                String[] listaUsos;
                listaUsos=elementoJSON.get("Usos").toString().split(",");
                ArrayList<String> UsosArraylist = new ArrayList();
                for(int a = 0; a<listaUsos.length; a++){
                    UsosArraylist.add(listaUsos[a]);
                }
                
                datos.setListaUsos(UsosArraylist);


                PropiedadesQuimicas propiedadesQuimicas = new PropiedadesQuimicas();
                propiedadesQuimicas.setNombre(elementoJSON.get("Nombre").toString());
                propiedadesQuimicas.setSimbolo(elementoJSON.get("Simbolo").toString());
                propiedadesQuimicas.setNumeroMasico(Double.parseDouble(elementoJSON.get("NumMasico").toString()));
                propiedadesQuimicas.setNumeroAtomico(Integer.parseInt(elementoJSON.get("NumAtomico").toString()));
                propiedadesQuimicas.setFamilia(elementoJSON.get("Familia").toString());
                propiedadesQuimicas.setGrupo(Integer.parseInt(elementoJSON.get("Grupo").toString()));
                propiedadesQuimicas.setPeriodo(Integer.parseInt(elementoJSON.get("Periodo").toString()));
                propiedadesQuimicas.setBloque(elementoJSON.get("Bloque").toString());
                propiedadesQuimicas.setPuntoFusion(Double.parseDouble(elementoJSON.get("PtoFusion").toString()));
                propiedadesQuimicas.setPuntoEbullicion(Double.parseDouble(elementoJSON.get("PtoEbullicion").toString()));


                Multimedia multimedia = new Multimedia();
                multimedia.setImagenAspecto(elementoJSON.get("ImagenAspecto").toString());
                multimedia.setImagenAtomo(elementoJSON.get("ImagenAtomo").toString());
                multimedia.setVideoElemento(elementoJSON.get("Video").toString());

                String color = elementoJSON.get("Color").toString();

                elemento = new Elemento(propiedadesQuimicas,datos,multimedia,color);
                listaElementos.add(elemento);
            }
            
        }
        catch(NullPointerException e){e.printStackTrace();}
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }
    
}

