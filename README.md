# Ticket Search

Ticket Search is a web application that allows users to search for event tickets

The application uses the SeatGeek API to search for event data, parses the JSON results, and displays relevant data points in a user-friendly form.  Users can search based on any number of keywords, including: location, artist, team, date, sport, etc. Users can select an event from the resulting list which opens the SeatGeek url for that event in a new browser window with more details about the event, including options for purchasing tickets.  

## Getting Started / Installing / Deployment

Compile the src directory and call Main.  The main method is located in:  
`src/main/java/seatGeekPortal/SeatGeekMain.java`  

```
$ javac src/main/java/seatGeekPortal/SeatGeekMain.java
$ java src/main/java/seatGeekPortal/SeatGeekMain
```

Or open in your favorite IDE (Eclipse, IntelliJ) and run Main in SeatGeekMain.java.

### Prerequisites

SeatGeek API Key [free](http://platform.seatgeek.com/) - to access data

## Built With

* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* [**Ramon-Luis**](https://github.com/ramon-luis)

## Acknowledgments

* Thank you to Adam Gerber at the University of Chicago for introducing me to the world of computer programming!