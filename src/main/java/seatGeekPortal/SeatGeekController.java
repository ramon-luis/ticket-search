package seatGeekPortal;

import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class SeatGeekController implements Initializable {

    @FXML
    private AnchorPane fxAnchorPane;
    @FXML
    private Pane fxTopPane;
    @FXML
    private VBox fxVbox;
    @FXML
    private TextField fxSearchBox;
    @FXML
    private Button fxFindButton;
    @FXML
    private Pane fxBottomPane;
    @FXML
    private ListView<String> fxList;
    @FXML
    private ProgressBar fxProgressBar;

    private HashMap<Integer, Event> eventsMap;

    public SeatGeekController() {
        // map events to ID int in order to access event info after converted to String
        eventsMap = new HashMap<>();
    }

    public void initialize(URL url, ResourceBundle rb) {
        final Service eventFinder = new Service<ObservableList<String>>() {

            @Override
            protected Task createTask() {
                return new Task<ObservableList<String>>() {
                    protected ObservableList<String> call() throws InputMismatchException {

                        // search for matching events
                        String sSearchInput = fxSearchBox.getText();
                        SeatGeekTask seatGeekAPI = new SeatGeekTask(sSearchInput);
                        ArrayList<Event> events = seatGeekAPI.getEvents();

                        // add events to hashmap and create description to display
                        ArrayList<String> eventDescriptions = new ArrayList<>();
                        int i = 1;
                        for (Event e : events) {
                            eventsMap.put(i, e);
                            eventDescriptions.add(i + ". " + e.getTitle() + " | " + e.getVenue().getName() + " | " + getReadableDate(e.getDatetimeLocal()));
                            i++;
                        }

                        // populate the list with event descriptions
                        return FXCollections.observableArrayList(eventDescriptions);
                    }

                };
            }
        };

        // bind relevant properties to the controls
        fxFindButton.disableProperty().bind(eventFinder.runningProperty());
        fxList.itemsProperty().bind(eventFinder.valueProperty());
        fxList.visibleProperty().bind(eventFinder.valueProperty().isNotNull());

        // search when button is clicked
        fxFindButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!eventFinder.isRunning()) {
                    eventFinder.reset();
                    eventFinder.start();
                }
            }
        });


        // action when list item is clicked
        fxList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                try {
                    // do nothing if clicked list item is not text
                    if (!(me.getTarget() instanceof Text)) {
                        return;
                    }

                    // get the item clicked, parse the item number, and pull event URL from event hashmap
                    String sClicked = ((Text) me.getTarget()).getText().toString();
                    int iEventHash = Integer.valueOf(sClicked.substring(0, sClicked.indexOf('.')));
                    String sEventURL = eventsMap.get(iEventHash).getUrl();

                    //performer image
                    Performer primaryPerformer = eventsMap.get(iEventHash).getPerformers().get(0);
                    String sImageURL = primaryPerformer.getImage();


                    // open the URL
                    openWebpage(new URI(sEventURL));

                } catch (Exception e) {
                    System.out.println("There was an issue handling the mouse click event on the list:");
                    System.out.println("  " + e);
                }
            }
        });

    }


    // helper function to convert SeatGeek API date & time into user friendly format
    private String getReadableDate(String sDateTime) {

        // define the simple date formats for input and output
        SimpleDateFormat sdfSeatGeekAPI = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdfUserFriendly = new SimpleDateFormat("EEE, MMM d, yyyy h:mma z");

        // use empty string for default so that do not return null
        String sDate = "";

        // parse the date & time string into the new format
        try {
            sDate = sdfUserFriendly.format(sdfSeatGeekAPI.parse(sDateTime));
        } catch (ParseException e) {
            System.out.println("There was an issue parsing a date format:");
            System.out.println("  " + e);
        }

        return sDate;
    }

    // helper function to open webpage in desktop browser
    private static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                System.out.println("There was an error opening the link:");
                System.out.println("  " + e);
            }
        }
    }


}