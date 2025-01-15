/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui_controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericType;

import logic.EventManager;
import logic.EventManagerFactory;
import model.Client;
import model.Event;
import model.User;

/**
 *
 * @author 2dam
 */
public class ShowAllEventsViewController {
    
    @FXML
    AnchorPane bpPrincipal;
    
    @FXML
    TextField tfBuscador;
    
    @FXML
    TextField tfPrecio;
    
    @FXML
    DatePicker dateFecha;
    
    @FXML
    DatePicker dateFechaHasta;
    
    @FXML
    Label lbHasta;
    
    @FXML
    TableView<Event> tablaEvent;
    
    @FXML
    TableColumn<Event, String> tcNombre;
    
    @FXML
    TableColumn<Event, Integer> tcSala;
    
    @FXML
    TableColumn<Event, String> tcFecha;
    
    @FXML
    TableColumn<Event, Double> tcPrecio;
    
    @FXML
    TableColumn<Event, Integer> tcNumEntradas;
    
    @FXML
    TableColumn<Event, String> tcMusica;
    
    @FXML
    TableColumn<Event, Integer> tcConsumicion;
    
    @FXML
    Button btnCrearEvento;
    
    @FXML
    Button btnBorrarEvento;
    
    @FXML
    Button btnAñadirArtistas;
    
    @FXML
    Button btnSeleccionar;
    
 

    
    private Stage stage;

    private User user;

    private boolean tema;

    private final Logger LOGGER = Logger.getLogger("crudbankjfxclient.view");
    
    @FXML
    private void deleteEvent(ActionEvent event) {
        Event selectedEvent = tablaEvent.getSelectionModel().getSelectedItem();
        EventManagerFactory.get().remove(selectedEvent.getId().toString());
        Event[] eventsArray = EventManagerFactory.get().findAll_XML(Event[].class); 
        List<Event> events = Arrays.asList(eventsArray);
 
        cargarTabla(events);
    }
    
    
    private void cargarTabla(List<Event> tableEvents){
        System.out.println(tableEvents.get(0).toString());
        initializeTableColumns();        
        // Convertir ArrayList a ObservableList
        ObservableList<Event> observableEvents = FXCollections.observableArrayList(tableEvents);       
        // Cargar datos en la tabla
        tablaEvent.setItems(observableEvents);
        
    }
    
    private void initializeTableColumns() {
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcSala.setCellValueFactory(new PropertyValueFactory<>("club"));
        tcFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        tcPrecio.setCellValueFactory(new PropertyValueFactory<>("precioEntrada"));
        tcNumEntradas.setCellValueFactory(new PropertyValueFactory<>("NumEntradas"));
        tcMusica.setCellValueFactory(new PropertyValueFactory<>("Musica"));
        tcConsumicion.setCellValueFactory(new PropertyValueFactory<>("Consumicion"));
    }
      
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTema(boolean tema) {
        this.tema = tema;
    }
    
  
    
    public void initStage(Parent root) {

        LOGGER.info("Initializing Bank Statement window.");
        Scene scene = new Scene(root);

      
      Event[] eventsArray = EventManagerFactory.get().findAll_XML(Event[].class);
      List<Event> events = Arrays.asList(eventsArray);
 
      cargarTabla(events);
        
        if(user instanceof Client){
            btnAñadirArtistas.setVisible(false);
            btnBorrarEvento.setVisible(false);
            btnCrearEvento.setVisible(false);
        }else{
            tablaEvent.setEditable(true);
        }
        tablaEvent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Event>() {
            @Override
            public void changed(ObservableValue<? extends Event> observable, Event oldValue, Event newValue) {
                if (newValue != null) {
                    btnAñadirArtistas.setDisable(false);
                    btnBorrarEvento.setDisable(false);
                    btnCrearEvento.setDisable(false);
                    btnSeleccionar.setDisable(false);
                }else{
                    btnAñadirArtistas.setDisable(true);
                    btnBorrarEvento.setDisable(true);
                    btnCrearEvento.setDisable(true);
                    btnSeleccionar.setDisable(true);
                }
            }
        });
        
        dateFecha.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                if (newValue != null) {
                    if(dateFecha.getValue() != null){
                        lbHasta.setVisible(true);
                        dateFechaHasta.setVisible(true);
                    }
                }
            }

            
        });
       
        tcPrecio.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        tcPrecio.setOnEditCommit(event -> {
            Event selectedEvent = event.getRowValue();
            selectedEvent.setPrecioEntrada(event.getNewValue());
            Event evento = EventManagerFactory.get().find_XML(Event.class, selectedEvent.getId().toString());
            EventManagerFactory.get().edit_XML(evento, selectedEvent.getId().toString());
        });
        
        stage.show();
        stage.setScene(scene);
        LOGGER.info("Bank Statement window initialized.");

    }


}
