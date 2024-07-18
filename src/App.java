import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import Destination.Destination;
import Airplane.Ticket;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Connection URL
        String url = "jdbc:ucanaccess://G:/Studentdata.accdb";


        

        Map<String, ObservableList<String>> classTypeData = Ticket.createclassTypeDropDown();
        ObservableList<String> classTypeOptions = classTypeData.get("classTypeOptions");
        ObservableList<String> prices = classTypeData.get("prices");


        ComboBox<String> classTypeDropDown = new ComboBox<>(classTypeOptions);
        classTypeDropDown.setPromptText("Select Class");


        ComboBox<String> countryDropDown = Destination.createCountryDropDown();
        ComboBox<String> cityDropDown = Destination.createCityDropDown("dsad"); // Default to garbage
        ComboBox<String> dateDropDown = Destination.createDateDropDown("Ndasdasice");
        ComboBox<String> timeDropDown = Destination.createTimeDropDown("24/11/2023"); // Default to garbage

        ComboBox<String> options = new ComboBox<>();
        options.setPromptText("Would you like to:");
        options.getItems().addAll("Book a flight", "Check your bookings","Admin");

        Label labelIntro = new Label("Welcome to Dawn Airlines!:");

        Label labelId = new Label("Customer ID:");
        TextField textFieldId = new TextField();
        textFieldId.setEditable(false); // Make it uneditable


        Label labelFirstName = new Label("First Name:");
        TextField textFieldFirstName = new TextField();

        Label labelLastName = new Label("Last Name:");
        TextField textFieldLastName = new TextField();

        // Create labels for additional information
        Label labelCountry = new Label("Country:");
        Label labelCity = new Label("City:");
        Label labelDate = new Label("Date:");
        Label labelTime = new Label("Time:");
        Label labelClass_type = new Label("Select Class:");
        TextField priceTextField = new TextField();

        
        Button saveTicketButton = new Button("Next"); 
        Button backTicketButton = new Button("Back"); 


        Button saveButton = new Button("Book");

        // admin
        Button DelayButton = new Button("Delay Flights");
        TextField DelayButtonTextField = new TextField();
        DelayButtonTextField.setEditable(false); // Make it uneditable

        Button CancelButton = new Button("Cancel Flight");
        TextField CancelButtonTextField = new TextField();
        CancelButtonTextField.setEditable(false); // Make it uneditable



        // Check Your Bookings
        Button confirmButton = new Button("Confirm");
        Label labelcheckId = new Label("Please Enter Your Customer ID:");
        TextField labelcheckIdTextField = new TextField();

        Label labelcheckFirstName = new Label("First Name:");
        TextField labelcheckFirstNameTextField = new TextField();
        labelcheckFirstNameTextField.setEditable(false); // Make it uneditable

        Label labelcheckLastName = new Label("Last Name:");
        TextField labelcheckLastNameTextField = new TextField();
        labelcheckLastNameTextField.setEditable(false); // Make it uneditable






        // destination

        Label labelcheckFlight_ID = new Label("Flight ID:");
        TextField labelcheckFlight_IDTextField = new TextField();
        labelcheckFlight_IDTextField.setEditable(false); // Make it uneditable

        Label labelcheckCountry = new Label("Country:");
        TextField labelcheckCountryTextField = new TextField();
        labelcheckCountryTextField.setEditable(false); // Make it uneditable

        Label labelcheckCity = new Label("City:");
        TextField labelcheckCityTextField = new TextField();
        labelcheckCityTextField.setEditable(false); // Make it uneditable

        Label labelcheckDate = new Label("Date:");
        TextField labelcheckDateTextField = new TextField();
        labelcheckDateTextField.setEditable(false); // Make it uneditable

        Label labelcheckTime = new Label("Time:");
        TextField labelcheckTimeTextField = new TextField();
        labelcheckTimeTextField.setEditable(false); // Make it uneditable


        // Ticket
        Label labelcheckClass_type = new Label("Class Type:");
        TextField labelcheckClass_typeTextField = new TextField();
        labelcheckClass_typeTextField.setEditable(false); // Make it uneditable

        Label labelcheckPrice = new Label("Price:");
        TextField labelcheckPriceTextField = new TextField();
        labelcheckPriceTextField.setEditable(false); // Make it uneditable



   // Initially hide the TextArea

        // Create a ListView to display the data
        ListView<String> listView = new ListView<>();

        // Initially hide input boxes and labels
        labelId.setVisible(false);
        textFieldId.setVisible(false);
        labelFirstName.setVisible(false);
        textFieldFirstName.setVisible(false);
        labelLastName.setVisible(false);
        textFieldLastName.setVisible(false);
        countryDropDown.setVisible(false);
        cityDropDown.setVisible(false);
        labelCountry.setVisible(false);
        labelCity.setVisible(false);
        labelDate.setVisible(false);
        labelTime.setVisible(false);
        dateDropDown.setVisible(false);
        timeDropDown.setVisible(false);
        saveButton.setVisible(false);
        labelClass_type.setVisible(false);
        classTypeDropDown.setVisible(false);
        priceTextField.setVisible(false);
        priceTextField.setEditable(false);
        saveTicketButton.setVisible(false);
        backTicketButton.setVisible(false);
        // check your bookings
        labelcheckId.setVisible(false);
        labelcheckIdTextField.setVisible(false);
        // customer
        labelcheckFirstName.setVisible(false);
        labelcheckLastName.setVisible(false);
        labelcheckLastNameTextField.setVisible(false);
        labelcheckFirstNameTextField.setVisible(false);
        confirmButton.setVisible(false);

        // destination
        labelcheckFlight_ID.setVisible(false);
        labelcheckFlight_IDTextField.setVisible(false);
        labelcheckCountry.setVisible(false);
        labelcheckCountryTextField.setVisible(false);
        labelcheckCity.setVisible(false);
        labelcheckCityTextField.setVisible(false);
        labelcheckDate.setVisible(false);
        labelcheckDateTextField.setVisible(false);
        labelcheckTime.setVisible(false);
        labelcheckTimeTextField.setVisible(false);

        // ticket
        labelcheckClass_type.setVisible(false);
        labelcheckClass_typeTextField.setVisible(false);
        labelcheckPrice.setVisible(false);
        labelcheckPriceTextField.setVisible(false);

        // admin
        DelayButton.setVisible(false);
        CancelButton.setVisible(false);

        CancelButtonTextField.setVisible(false); // Make it uneditable
        DelayButtonTextField.setVisible(false); // Make it uneditable

        // Event handler for the ComboBox selection
        options.setOnAction(event -> {
            String selectedOption = options.getValue();
            if ("Book a flight".equals(selectedOption)) {
                // Show input boxes and labels for booking a flight
                labelId.setVisible(true);
                textFieldId.setVisible(true);
                labelFirstName.setVisible(true);
                textFieldFirstName.setVisible(true);
                labelLastName.setVisible(true);
                textFieldLastName.setVisible(true);
                labelCountry.setVisible(true);
                countryDropDown.setVisible(true);
                labelCity.setVisible(true);
                cityDropDown.setVisible(true);
                labelDate.setVisible(true);
                dateDropDown.setVisible(true);
                labelTime.setVisible(true);
                timeDropDown.setVisible(true);
                saveTicketButton.setVisible(true);
                backTicketButton.setVisible(false);
                saveButton.setVisible(false);
                labelClass_type.setVisible(false);
                classTypeDropDown.setVisible(false);
                priceTextField.setEditable(false);
                labelcheckFirstName.setVisible(false);
                labelcheckLastName.setVisible(false);
                labelcheckLastNameTextField.setVisible(false);
                labelcheckFirstNameTextField.setVisible(false);
                confirmButton.setVisible(false);
                labelcheckId.setVisible(false);
                labelcheckIdTextField.setVisible(false);
                // destination
                labelcheckFlight_ID.setVisible(false);
                labelcheckFlight_IDTextField.setVisible(false);
                labelcheckCountry.setVisible(false);
                labelcheckCountryTextField.setVisible(false);
                labelcheckCity.setVisible(false);
                labelcheckCityTextField.setVisible(false);
                labelcheckDate.setVisible(false);
                labelcheckDateTextField.setVisible(false);
                labelcheckTime.setVisible(false);
                labelcheckTimeTextField.setVisible(false);

                // ticket
                labelcheckClass_type.setVisible(false);
                labelcheckClass_typeTextField.setVisible(false);
                labelcheckPrice.setVisible(false);
                labelcheckPriceTextField.setVisible(false);

                // admin
                // admin
                DelayButton.setVisible(false);
                CancelButton.setVisible(false);
                CancelButtonTextField.setVisible(false); 
                DelayButtonTextField.setVisible(false); 


                // Generate a unique ID 
                textFieldId.setText(generateUniqueID("ID"));
            } 
            else if ("Check your bookings".equals(selectedOption)) {
                // Show input boxes and labels for checking bookings
                labelcheckFirstNameTextField.setVisible(true);
                labelcheckLastNameTextField.setVisible(true);
                confirmButton.setVisible(true);
                labelcheckIdTextField.setVisible(true);
                labelcheckFirstName.setVisible(true);
                labelcheckLastName.setVisible(true);
                labelcheckId.setVisible(true);
                // destiantion
                labelcheckFlight_ID.setVisible(true);
                labelcheckFlight_IDTextField.setVisible(true);
                labelcheckCountry.setVisible(true);
                labelcheckCountryTextField.setVisible(true);
                labelcheckCity.setVisible(true);
                labelcheckCityTextField.setVisible(true);
                labelcheckDate.setVisible(true);
                labelcheckDateTextField.setVisible(true);
                labelcheckTime.setVisible(true);
                labelcheckTimeTextField.setVisible(true);

                // ticket
                labelcheckClass_type.setVisible(true);
                labelcheckClass_typeTextField.setVisible(true);
                labelcheckPrice.setVisible(true);
                labelcheckPriceTextField.setVisible(true);
        
                // Hide other input boxes and labels
                labelId.setVisible(false);
                textFieldId.setVisible(false);
                labelFirstName.setVisible(false);
                textFieldFirstName.setVisible(false);
                labelLastName.setVisible(false);
                textFieldLastName.setVisible(false);
                countryDropDown.setVisible(false);
                cityDropDown.setVisible(false);
                labelCountry.setVisible(false);
                labelCity.setVisible(false);
                labelDate.setVisible(false);
                labelTime.setVisible(false);
                dateDropDown.setVisible(false);
                timeDropDown.setVisible(false);
                saveButton.setVisible(false);
                saveTicketButton.setVisible(false);
                labelClass_type.setVisible(false);
                classTypeDropDown.setVisible(false);
                priceTextField.setEditable(false);
                backTicketButton.setVisible(false);
                priceTextField.setVisible(false);

                // admin
                DelayButton.setVisible(false);
                CancelButton.setVisible(false);
                CancelButtonTextField.setVisible(false); 
                DelayButtonTextField.setVisible(false);     
        
                // Event handler for the Confirm button
                confirmButton.setOnAction(confirmEvent -> {
                    String customerId = labelcheckIdTextField.getText(); //  customer ID is entered here
        
                    try (Connection connection = DriverManager.getConnection(url)) {
                        // Fetch first name and last name from the Customer table based on the entered ID
                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "SELECT [First_Name], [Last_Name] FROM Customer WHERE [ID] = ?"
                        )) {
                            preparedStatement.setString(1, customerId);
        
                            ResultSet resultSet = preparedStatement.executeQuery();
        
                            if (resultSet.next()) {
                                String firstName = resultSet.getString("First_Name");
                                String lastName = resultSet.getString("Last_Name");
        
                                // Display the data in the corresponding text fields
                                labelcheckFirstNameTextField.setText(firstName);
                                labelcheckLastNameTextField.setText(lastName);
        
                            } else {
                                // Display an error message if the customer ID is not found
                                labelcheckFirstNameTextField.setText("Customer not found");
                                labelcheckLastNameTextField.clear();
                            }
                        }
                        // destination
                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "SELECT [Flight_ID], [Country], [City], [Date_], [Time_] FROM Destination WHERE [ID] = ?"
                        )) {
                            preparedStatement.setString(1, customerId);
        
                            ResultSet resultSet = preparedStatement.executeQuery();
        
                            if (resultSet.next()) {
                                String Flight_ID = resultSet.getString("Flight_ID");

                                String Country = resultSet.getString("Country");
                                String City = resultSet.getString("City");
                                String Date_ = resultSet.getString("Date_");
                                String Time_ = resultSet.getString("Time_");



                                // Display the data in the corresponding text fields
                                labelcheckFlight_IDTextField.setText(Flight_ID);
                                labelcheckCountryTextField.setText(Country);
                                labelcheckCityTextField.setText(City);
                                labelcheckDateTextField.setText(Date_);
                                labelcheckTimeTextField.setText(Time_);  
        
                            } else {
                                // Display an error message if the customer ID is not found
                                labelcheckFirstNameTextField.setText("Customer not found");
                                labelcheckLastNameTextField.clear();
                            }
                        }
                        // ticket
                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "SELECT [Class_Type], [Price] FROM Ticket WHERE [ID] = ?"
                        )) {
                            preparedStatement.setString(1, customerId);
        
                            ResultSet resultSet = preparedStatement.executeQuery();
        
                            if (resultSet.next()) {

                                String Class_Type = resultSet.getString("Class_Type");
                                String Price = resultSet.getString("Price");




                                // Display the data in the corresponding text fields
                                labelcheckClass_typeTextField.setText(Class_Type);
                                labelcheckPriceTextField.setText(Price);
        
                            } else {
                                // Display an error message if the customer ID is not found
                                labelcheckFirstNameTextField.setText("Customer not found");
                                labelcheckLastNameTextField.clear();
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
            }

            else if ("Admin".equals(selectedOption)) {
                // Show input boxes and labels for checking bookings
                labelcheckFirstNameTextField.setVisible(false);
                labelcheckLastNameTextField.setVisible(false);
                confirmButton.setVisible(false);
                labelcheckIdTextField.setVisible(true);
                labelcheckFirstName.setVisible(false);
                labelcheckLastName.setVisible(false);
                labelcheckId.setVisible(true);
                labelcheckFlight_ID.setVisible(false);
                labelcheckFlight_IDTextField.setVisible(false);
                labelcheckCountry.setVisible(false);
                labelcheckCountryTextField.setVisible(false);
                labelcheckCity.setVisible(false);
                labelcheckCityTextField.setVisible(false);
                labelcheckDate.setVisible(false);
                labelcheckDateTextField.setVisible(false);
                labelcheckTime.setVisible(false);
                labelcheckTimeTextField.setVisible(false);
                labelcheckClass_type.setVisible(false);
                labelcheckClass_typeTextField.setVisible(false);
                labelcheckPrice.setVisible(false);
                labelcheckPriceTextField.setVisible(false);
                labelId.setVisible(false);
                textFieldId.setVisible(false);
                labelFirstName.setVisible(false);
                textFieldFirstName.setVisible(false);
                labelLastName.setVisible(false);
                textFieldLastName.setVisible(false);
                countryDropDown.setVisible(false);
                cityDropDown.setVisible(false);
                labelCountry.setVisible(false);
                labelCity.setVisible(false);
                labelDate.setVisible(false);
                labelTime.setVisible(false);
                dateDropDown.setVisible(false);
                timeDropDown.setVisible(false);
                saveButton.setVisible(false);
                saveTicketButton.setVisible(false);
                labelClass_type.setVisible(false);
                classTypeDropDown.setVisible(false);
                priceTextField.setEditable(false);
                backTicketButton.setVisible(false);
                priceTextField.setVisible(false);
                confirmButton.setVisible(false);

                CancelButtonTextField.setVisible(true); 
                DelayButtonTextField.setVisible(true);   

                // admin
                DelayButton.setVisible(true);

                 DelayButton.setOnAction(delayevent -> {
                    String customerId = labelcheckIdTextField.getText();
                
                    try (
                        Connection connection = DriverManager.getConnection(url);
                    ) {
                        // Retrieve current Date_ from Destination table
                        try (
                            PreparedStatement preparedStatement = connection.prepareStatement(
                                "SELECT [Date_] FROM Destination WHERE [ID] = ?"
                            )
                        ) {
                            preparedStatement.setString(1, customerId);
                            ResultSet resultSet = preparedStatement.executeQuery();
                
                            if (resultSet.next()) {
                                String currentDate = resultSet.getString("Date_");
                
                                // Update the Date_ column to a new value (e.g., delay by setting to 2:00 AM)
                                try (
                                    PreparedStatement updateStatement = connection.prepareStatement(
                                        "UPDATE Destination SET [Date_] = ? WHERE [ID] = ?"
                                    )
                                ) {
                                    updateStatement.setString(1, "18/6/2023"); // Set the new date
                                    updateStatement.setString(2, customerId);
                
                                    // Execute the update
                                    updateStatement.executeUpdate();
                
                                    DelayButtonTextField.setText("Flight Delayed for Customer ID " + customerId + ". Previous Date: " + currentDate);
                                }
                            } else {
                                labelcheckFirstNameTextField.setText("Customer not found");
                                labelcheckLastNameTextField.clear();                            
                            }
                        }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });


                    CancelButton.setVisible(true);


                    CancelButton.setOnAction(cancelevent -> {
                        String customerId = labelcheckIdTextField.getText();
                    
                        try (
                            Connection connection = DriverManager.getConnection(url);
                        ) {
                            // Check if the customer exists
                            try (
                                PreparedStatement checkCustomerStatement = connection.prepareStatement(
                                    "SELECT [First_Name] FROM Customer WHERE [ID] = ?"
                                )
                            ) {
                                checkCustomerStatement.setString(1, customerId);
                                ResultSet customerResultSet = checkCustomerStatement.executeQuery();
                    
                                if (customerResultSet.next()) {
                                    // Delete entries from Ticket table
                                    try (
                                        PreparedStatement deleteTicketStatement = connection.prepareStatement(
                                            "DELETE FROM Ticket WHERE [ID] = ?"
                                        )
                                    ) {
                                        deleteTicketStatement.setString(1, customerId);
                                        deleteTicketStatement.executeUpdate();
                                    }
                    
                                    // Delete entries from Destination table
                                    try (
                                        PreparedStatement deleteDestinationStatement = connection.prepareStatement(
                                            "DELETE FROM Destination WHERE [ID] = ?"
                                        )
                                    ) {
                                        deleteDestinationStatement.setString(1, customerId);
                                        deleteDestinationStatement.executeUpdate();
                                    }
                    
                                    // Delete entries from Customer table
                                    try (
                                        PreparedStatement deleteCustomerStatement = connection.prepareStatement(
                                            "DELETE FROM Customer WHERE [ID] = ?"
                                        )
                                    ) {
                                        deleteCustomerStatement.setString(1, customerId);
                                        deleteCustomerStatement.executeUpdate();
                                    }

                                    CancelButtonTextField.setText("Flight Canceled for Customer ID " + customerId);

                                } else {
                                labelcheckFirstNameTextField.setText("Customer not found");
                                labelcheckLastNameTextField.clear();                                
                            }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });

                }

            else {
                // Hide input boxes and labels for other options
                labelId.setVisible(false);
                textFieldId.setVisible(false);
                labelFirstName.setVisible(false);
                textFieldFirstName.setVisible(false);
                labelLastName.setVisible(false);
                textFieldLastName.setVisible(false);
                countryDropDown.setVisible(false);
                cityDropDown.setVisible(false);
                labelCountry.setVisible(false);
                labelCity.setVisible(false);
                labelDate.setVisible(false);
                labelTime.setVisible(false);
                dateDropDown.setVisible(false);
                timeDropDown.setVisible(false);
                saveButton.setVisible(false);
                saveTicketButton.setVisible(false);
                labelClass_type.setVisible(false);
                classTypeDropDown.setVisible(false);
                priceTextField.setEditable(false);
                backTicketButton.setVisible(false);

                priceTextField.clear();  // Clear the price when not booking a flight
            }
        });

        // Create a GridPane to arrange elements
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Add elements to the GridPane
        gridPane.add(labelId, 0, 0);
        gridPane.add(textFieldId, 1, 0);
        gridPane.add(labelFirstName, 0, 1);
        gridPane.add(textFieldFirstName, 1, 1);
        gridPane.add(labelLastName, 0, 2);
        gridPane.add(textFieldLastName, 1, 2);
        gridPane.add(labelCountry, 0, 3);
        gridPane.add(countryDropDown, 1, 3);
        gridPane.add(labelCity, 0, 4);
        gridPane.add(cityDropDown, 1, 4);
        gridPane.add(labelDate, 0, 5);
        gridPane.add(dateDropDown, 1, 5);
        gridPane.add(labelTime, 0, 6);
        gridPane.add(timeDropDown, 1, 6);
        gridPane.add(labelClass_type, 0 , 0);       
        gridPane.add(classTypeDropDown, 1 , 0);
        priceTextField.setPrefWidth(350);
        gridPane.add(priceTextField, 2, 0);
        gridPane.add(backTicketButton, 0 , 2);
        gridPane.add(labelcheckId, 0, 0);
        gridPane.add(labelcheckIdTextField, 1, 0);
        gridPane.add(labelcheckFirstName, 0, 1);
        gridPane.add(labelcheckFirstNameTextField, 1, 1);
        gridPane.add(labelcheckLastName, 0, 2);
        gridPane.add(labelcheckLastNameTextField, 1, 2);
        // destination
        gridPane.add(labelcheckFlight_ID, 0, 3);
        gridPane.add(labelcheckFlight_IDTextField, 1, 3);
        gridPane.add(labelcheckCountry, 0, 4);
        gridPane.add(labelcheckCountryTextField, 1, 4);
        gridPane.add(labelcheckCity, 0, 5);
        gridPane.add(labelcheckCityTextField, 1, 5);
        gridPane.add(labelcheckDate, 0, 6);
        gridPane.add(labelcheckDateTextField, 1, 6);
        gridPane.add(labelcheckTime, 0, 7);
        gridPane.add(labelcheckTimeTextField, 1, 7);


        // ticket
        gridPane.add(labelcheckClass_type, 0, 8);
        gridPane.add(labelcheckClass_typeTextField, 1, 8);
        gridPane.add(labelcheckPrice, 0, 9);
        gridPane.add(labelcheckPriceTextField, 1, 9);

        gridPane.add(confirmButton, 0, 10);

        // admin
        DelayButtonTextField.setPrefWidth(550);
        CancelButtonTextField.setPrefWidth(350);

        gridPane.add(DelayButton, 0, 2);
        gridPane.add(DelayButtonTextField, 1, 2);
        gridPane.add(CancelButton, 0, 3);
        gridPane.add(CancelButtonTextField, 1, 3);

        

        VBox vBox = new VBox(labelIntro, options, gridPane, saveTicketButton, saveButton, listView);
       


        // Replace the existing VBox with the new VBox for checking bookings
        vBox = new VBox(labelIntro, options, vBox);
       
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(saveButton, new Insets(10, 0, 0, 0)); // Add margin to separate saveButton from other elements


        // Event handler for class type drop-down selection
        classTypeDropDown.setOnAction(event -> {
            String selectedClassType = classTypeDropDown.getValue();
            ObservableList<String> classPrices = Ticket.getPrice(selectedClassType);
            if (classPrices != null && !classPrices.isEmpty()) {
                priceTextField.setText("Price: " + classPrices.get(0));
                priceTextField.setVisible(true);
            } else {
                priceTextField.setText("Price: N/A");
                priceTextField.setVisible(true);
            }
        });



            // Event handler for the save button
            saveButton.setOnAction(event -> {
                // Check if any of the required fields is empty
                if (textFieldId.getText().isEmpty() ||
                        textFieldFirstName.getText().isEmpty() ||
                        textFieldLastName.getText().isEmpty() ||
                        countryDropDown.getValue() == null ||
                        cityDropDown.getValue() == null ||
                        dateDropDown.getValue() == null ||
                        timeDropDown.getValue() == null ||
                        classTypeDropDown.getValue() == null) {

                    // Display error messages in the text fields for empty values
                    if (textFieldId.getText().isEmpty()) {
                        textFieldId.setPromptText("Fill This First");
                    }
                    if (textFieldFirstName.getText().isEmpty()) {
                        textFieldFirstName.setPromptText("Fill This First");
                    }
                    if (textFieldLastName.getText().isEmpty()) {
                        textFieldLastName.setPromptText("Fill This First");
                    }
                    if (countryDropDown.getValue() == null) {
                        countryDropDown.setPromptText("Fill This First");
                    }
                    if (cityDropDown.getValue() == null) {
                        cityDropDown.setPromptText("Fill This First");
                    }
                    if (dateDropDown.getValue() == null) {
                        dateDropDown.setPromptText("Fill This First");
                    }
                    if (timeDropDown.getValue() == null) {
                        timeDropDown.setPromptText("Fill This First");
                    }
                    if (classTypeDropDown.getValue() == null) {
                        classTypeDropDown.setPromptText("Fill This First");
                    }

                    // Exit the event handler if any field is empty
                    return;
                }

                try (
                        // Establish the connection
                        Connection connection = DriverManager.getConnection(url);
                ) {
                    // Save data to Customer table
                    try (
                            // Prepare a statement to insert data
                            PreparedStatement customerStatement = connection.prepareStatement(
                                    "INSERT INTO Customer ([ID], [First_Name] , [Last_Name]) VALUES (?, ?, ?)"
                            )
                    ) {
                        // Set parameters
                        customerStatement.setString(1, textFieldId.getText());
                        customerStatement.setString(2, textFieldFirstName.getText());
                        customerStatement.setString(3, textFieldLastName.getText());

                        // Execute the update
                        customerStatement.executeUpdate();

                        System.out.println("Data saved to the Customer table");
                    }

                    // Save data to Destination table
                    try (
                            // Prepare a statement to insert data
                            PreparedStatement destinationStatement = connection.prepareStatement(
                                    "INSERT INTO Destination ([ID], [Flight_ID], [Country], [City], [Date_], [Time_]) VALUES (?, ?, ?, ?, ?, ?)"
                            )
                    ) {
                        // Generate a unique Flight_ID
                        String flightId = generateUniqueID("Flight");

                        // Set parameters
                        destinationStatement.setString(1, textFieldId.getText());
                        destinationStatement.setString(2, flightId);
                        destinationStatement.setString(3, countryDropDown.getValue());
                        destinationStatement.setString(4, cityDropDown.getValue());
                        destinationStatement.setString(5, dateDropDown.getValue());
                        destinationStatement.setString(6, timeDropDown.getValue());

                        // Execute the update
                        destinationStatement.executeUpdate();

                        System.out.println("Data saved to the Destination table with Flight_ID: " + flightId);
                    }

                    try (
                            // Prepare a statement to insert data
                            PreparedStatement ticketStatement = connection.prepareStatement(
                                    "INSERT INTO Ticket ([ID], [Flight_ID],[Class_Type], [Price]) VALUES (?, ?, ?, ?)"
                            )
                    ) {
                        String flightId = generateUniqueID("Flight");

                        // Set parameters
                        ticketStatement.setString(1, textFieldId.getText());
                        ticketStatement.setString(2, flightId);
                        ticketStatement.setString(3, classTypeDropDown.getValue());
                        ticketStatement.setString(4, priceTextField.getText());


                        // Execute the update
                        ticketStatement.executeUpdate();
                        priceTextField.setText("Your Flight Has Been Booked"+textFieldId.getText());
                    }

                    // Clear text fields after saving
                    textFieldFirstName.clear();
                    textFieldLastName.clear();
                    labelFirstName.setVisible(false);
                    textFieldFirstName.setVisible(false);
                    labelLastName.setVisible(false);
                    textFieldLastName.setVisible(false);
                    labelId.setVisible(false);
                    textFieldId.setVisible(false);
                    backTicketButton.setVisible(false);
                    priceTextField.setVisible(true);
                    labelClass_type.setVisible(false);
                    classTypeDropDown.setVisible(false);
                    countryDropDown.setVisible(false);
                    cityDropDown.setVisible(false);
                    labelCountry.setVisible(false);
                    labelCity.setVisible(false);
                    labelDate.setVisible(false);
                    labelTime.setVisible(false);
                    dateDropDown.setVisible(false);
                    timeDropDown.setVisible(false);
                    saveButton.setVisible(false);

                    // Generate a new unique ID for the next entry
                    textFieldId.setText(generateUniqueID("FLIGHT"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });



        saveTicketButton.setOnAction(event -> {
                labelClass_type.setVisible(true);
                backTicketButton.setVisible(true);
                classTypeDropDown.setVisible(true);
                priceTextField.setEditable(false);
                countryDropDown.setVisible(false);
                cityDropDown.setVisible(false);
                labelCountry.setVisible(false);
                labelCity.setVisible(false);
                labelDate.setVisible(false);
                labelTime.setVisible(false);
                dateDropDown.setVisible(false);
                timeDropDown.setVisible(false);
                saveButton.setVisible(true);
                saveTicketButton.setVisible(false);
        
                // Clear text fields after saving

                labelFirstName.setVisible(false);
                textFieldFirstName.setVisible(false);
                labelLastName.setVisible(false);
                textFieldLastName.setVisible(false);
                labelId.setVisible(false);
                textFieldId.setVisible(false);

                
        });

        backTicketButton.setOnAction(event -> {
                saveTicketButton.setVisible(true);
                labelClass_type.setVisible(false);
                classTypeDropDown.setVisible(false);
                priceTextField.setEditable(false);
                countryDropDown.setVisible(true);
                cityDropDown.setVisible(true);
                labelCountry.setVisible(true);
                labelCity.setVisible(true);
                labelDate.setVisible(true);
                labelTime.setVisible(true);
                dateDropDown.setVisible(true);
                timeDropDown.setVisible(true);
                saveButton.setVisible(false);
                saveTicketButton.setVisible(true);
                priceTextField.setVisible(false);

                // Clear text fields after saving

                labelFirstName.setVisible(true);
                textFieldFirstName.setVisible(true);
                labelLastName.setVisible(true);
                textFieldLastName.setVisible(true);
                labelId.setVisible(true);
                textFieldId.setVisible(true);
                backTicketButton.setVisible(false);


        });


        // Event handler for country drop-down selection
        countryDropDown.setOnAction(event -> {
            String selectedCountry = countryDropDown.getValue();
            // Update city drop-down based on the selected country
            ComboBox<String> updatedCityDropDown = Destination.createCityDropDown(selectedCountry);
            cityDropDown.getItems().setAll(updatedCityDropDown.getItems());
            updatedCityDropDown.setVisible(true);
            cityDropDown.setVisible(true);
            dateDropDown.setVisible(false);
            timeDropDown.setVisible(false);
        });

        // Event handler for city drop-down selection
        cityDropDown.setOnAction(event -> {
            String selectedCity = cityDropDown.getValue();

            // Update date drop-down based on the selected city
            ComboBox<String> updatedDateDropDown = Destination.createDateDropDown(selectedCity);
            dateDropDown.getItems().setAll(updatedDateDropDown.getItems());
            updatedDateDropDown.setVisible(true);

            // Update time drop-down based on the selected date (if any)
            String selectedDate = updatedDateDropDown.getValue();
            ComboBox<String> updatedTimeDropDown = Destination.createTimeDropDown(selectedDate);
            timeDropDown.getItems().setAll(updatedTimeDropDown.getItems());
            updatedTimeDropDown.setVisible(true);

            // Make sure dateDropDown and timeDropDown are visible
            dateDropDown.setVisible(true);
            timeDropDown.setVisible(true);
        });

        // Event handler for date drop-down selection
        dateDropDown.setOnAction(event -> {
            String selectedDate = dateDropDown.getValue();
            // Update time drop-down based on the selected date
            ComboBox<String> updatedTimeDropDown = Destination.createTimeDropDown(selectedDate);
            timeDropDown.getItems().setAll(updatedTimeDropDown.getItems());
            updatedTimeDropDown.setVisible(true); // Show the updated time drop-down
        });

        // Create a scene and set it on the stage
        Scene scene = new Scene(vBox, 600, 500);
        primaryStage.setScene(scene);

        // Set the stage title
        primaryStage.setTitle("Data Entry and Display");

        // Show the stage
        primaryStage.show();

        
    }



    private String generateUniqueID(String prefix) {
        // Generate a unique alphanumeric string by combining timestamp and random component
        long timestamp = System.currentTimeMillis();
        int randomSuffix = (int) ((Math.random() * 9000) + 1000); // Generate a random 4-digit number
    
        // Format the ID using the prefix, timestamp, and random component
        return String.format("%s%d%d", prefix, timestamp, randomSuffix);
    }
}

