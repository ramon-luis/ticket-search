package seatGeekPortal;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;
import javafx.util.Duration;
import seatGeekPortal.EventAPIClasses.Performer;
import seatGeekPortal.EventAPIClasses.SeatGeekEvent;

import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Controller:
 * background image rotates - simple, clean interface intentional
 * list is displayed only when populated with data - list is semi-transparent
 * hovering over list item changes mouse to hand (clickable link) and list item to larger & bold font
 * clicking a list item looks up the event in a hashmap and then opens the matching URL in SeatGeek for tickets
 */

public class SeatGeekController implements Initializable {

    //FXML tags
    @FXML
    private AnchorPane fxAnchorPane;
    @FXML
    private TextField fxSearchBox;
    @FXML
    private Button fxFindButton;
    @FXML
    private ListView<String> fxList;


    // instance variables
    private HashMap<Integer, SeatGeekEvent> eventsMap;
    private ArrayList<String> sBackgroundImages;

    // constructor
    public SeatGeekController() {
        // map events to ID int in order to access event info after converted to String
        eventsMap = new HashMap<>();

        // get the background images in the resources folder
        sBackgroundImages = new ArrayList<>();
        sBackgroundImages.addAll(getBackgroundImages());
    }

    // initialize
    public void initialize(URL url, ResourceBundle rb) {

        // create an observable list of events that match user input query
        final Service eventFinder = new Service<ObservableList<String>>() {

            @Override
            protected Task createTask() {
                return new Task<ObservableList<String>>() {
                    protected ObservableList<String> call() throws InputMismatchException {

                        // search for matching events
                        String sSearchInput = fxSearchBox.getText();
                        SeatGeekTask seatGeekAPI = new SeatGeekTask(sSearchInput);
                        ArrayList<SeatGeekEvent> events = seatGeekAPI.getEvents();

                        // add events to hashmap and create description to display
                        ArrayList<String> eventDescriptions = new ArrayList<>();
                        int i = 1;
                        for (SeatGeekEvent e : events) {
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

        // change background image every few seconds
        cycleBackgroundImage();


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

    // change the background image every few seconds
    private void cycleBackgroundImage() {
        // create new timeline for animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        // define parameters for key event: duration and event handler
        Duration duration = Duration.seconds(3);
        EventHandler<ActionEvent> onFinished = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // select a random background image from resources & assign to anchor pane
                int iRandomIndex = ThreadLocalRandom.current().nextInt(1, sBackgroundImages.size());
                String sNewImage = sBackgroundImages.get(iRandomIndex);
                fxAnchorPane.setStyle("-fx-background-image: url(" + sNewImage + ");" +
                        "-fx-background-repeat: stretch;" +
                        "-fx-background-position: center center;" +
                        "-fx-background-size: cover;");
            }
        };

        // create keyframe (animation sequence)
        KeyFrame keyFrame = new KeyFrame(duration, onFinished, null, null);

        // add keyframe to timeline and play
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
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

    // helper function to get list of background image
    private ArrayList<String> getBackgroundImages() {

        // final list to return
        ArrayList<String> sImages = new ArrayList<>();

        // get list of file names stored in image directory
        File f = new File("src/main/resources/images/");
        ArrayList<String> sImageFileNames = new ArrayList<>(Arrays.asList(f.list()));

        // append the image directory
        for (String sFileName : sImageFileNames) {
            sImages.add("/images/" + sFileName);
        }

        return sImages;
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