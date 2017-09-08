# Ticket Search

Ticket Search is a web application that allows users to search for event tickets

The application uses the SeatGeek API to search for event data, parses the JSON results, and displays relevant data points in a user-friendly form.  Users can search based on any number of keywords, including: location, artist, team, date, sport, etc. Users can select a resulting event from the resulting list which opens the direct SeatGeek url for that event in a new browser window with with more details and tickets for purchase for that specific event.


## Getting Started / Installing / Deployment

Compile the src directory and call Main.  The main method is located in src/main/java/seatGeekPortal/SeatGeekMain.java

```
$ javac src/main/java/seatGeekPortal/SeatGeekMain.java
$ java src/main/java/seatGeekPortal/SeatGeekMain
```

Or open in your favorite IDE (Eclipse, IntelliJ) and run Main in SeatGeekMain.java.

### Prerequisites

SeatGeek API Key - [free](http://platform.seatgeek.com/)  

## Built With

* [Java](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* [**Ramon-Luis**](https://github.com/ramon-luis)

## Acknowledgments

* Thank you to Adam Gerber at the University of Chicago for providing the base code & inspiration, as well as introducing me to the world of computer programming!