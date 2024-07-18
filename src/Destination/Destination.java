package Destination;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.Map;

public class Destination {

    private static final Map<String, ObservableList<String>> countryCitiesMap = new HashMap<>();
    private static final Map<String, ObservableList<String>> cityDatesMap = new HashMap<>();
    private static final Map<String, ObservableList<String>> dateTimesMap = new HashMap<>();

    static {
        initializeData();
    }

    private static void initializeData() {
        // Populate cities for each country
        ObservableList<String> franceCities = FXCollections.observableArrayList(
                "Paris",
                "Nice",
                "Lyon"
        );
        countryCitiesMap.put("France", franceCities);

        ObservableList<String> uaeCities = FXCollections.observableArrayList(
                "Dubai",
                "Abu Dhabi",
                "Sharjah"
        );
        countryCitiesMap.put("United Arab Emirates", uaeCities);

        ObservableList<String> usaCities = FXCollections.observableArrayList(
                "New York",
                "Chicago",
                "Houstan"
        );
        countryCitiesMap.put("United States", usaCities);

        

        // France
        ObservableList<String> parisDates = FXCollections.observableArrayList(
                "5/6/2023"
        );
        cityDatesMap.put("Paris", parisDates);

        ObservableList<String> niceDates = FXCollections.observableArrayList(
                "10/11/2023"
        );
        cityDatesMap.put("Nice", niceDates);

        ObservableList<String> LyonDates = FXCollections.observableArrayList(
                "14/3/2023"
        );
        cityDatesMap.put("Lyon", LyonDates);   


        // United Arab Emirates

        ObservableList<String> DubaiDates = FXCollections.observableArrayList(
                "16/6/2023"
        );
        cityDatesMap.put("Dubai", DubaiDates);          

        ObservableList<String> Abu_DhabiDates = FXCollections.observableArrayList(
                "19/9/2023"
        );
        cityDatesMap.put("Abu Dhabi", Abu_DhabiDates);     

        ObservableList<String> SharjahDates = FXCollections.observableArrayList(
                "22/12/2023"
        );
        cityDatesMap.put("Sharjah", SharjahDates);  


        // United States 

        ObservableList<String> ChicagoDates = FXCollections.observableArrayList(
                "25/3/2023"
        );
        cityDatesMap.put("Chicago", ChicagoDates);          

        ObservableList<String> HoustanDates = FXCollections.observableArrayList(
                "28/6/2023"
        );
        cityDatesMap.put("Houstan", HoustanDates);     

        ObservableList<String> New_YorkDates = FXCollections.observableArrayList(
                "31/9/2023"
        );
        cityDatesMap.put("New York", New_YorkDates);  

        
        

        ObservableList<String> dec5Times = FXCollections.observableArrayList(
                "2:00 PM",
                "5:30 PM",
                "8:45 PM"
        );
        dateTimesMap.put("5/6/2023", dec5Times);


        ObservableList<String> sep12Times = FXCollections.observableArrayList(
                "4:15 PM",
                "7:30 PM",
                "10:00 PM"
        );
        dateTimesMap.put("10/11/2023", sep12Times);

        
        ObservableList<String> nov28Times = FXCollections.observableArrayList(
                "1:45 PM",
                "6:15 PM",
                "9:45 PM"
        );
        dateTimesMap.put("14/3/2023", nov28Times);
        
        ObservableList<String> sep18Times = FXCollections.observableArrayList(
                "2:30 PM",
                "5:00 PM",
                "8:30 PM"
        );
        dateTimesMap.put("16/6/2023", sep18Times);
        
        ObservableList<String> dec15Times = FXCollections.observableArrayList(
                "2:45 PM",
                "6:00 PM",
                "9:15 PM"
        );
        dateTimesMap.put("19/9/2023", dec15Times);
        
        ObservableList<String> aug10Times = FXCollections.observableArrayList(
                "1:15 PM",
                "4:30 PM",
                "7:00 PM"
        );
        dateTimesMap.put("22/12/2023", aug10Times);
        
        ObservableList<String> jul8Times = FXCollections.observableArrayList(
                "2:45 PM",
                "6:00 PM",
                "9:15 PM"
        );
        dateTimesMap.put("25/3/2023", jul8Times);
        
        ObservableList<String> jul15Times = FXCollections.observableArrayList(
                "3:00 PM",
                "5:30 PM",
                "8:45 PM"
        );
        dateTimesMap.put("28/6/2023", jul15Times);
        
        ObservableList<String> aug18Times = FXCollections.observableArrayList(
                "1:30 PM",
                "4:45 PM",
                "7:15 PM"
        );
        dateTimesMap.put("18/8/2023", aug18Times);
        
        ObservableList<String> jul5Times = FXCollections.observableArrayList(
                "2:15 PM",
                "5:30 PM",
                "8:45 PM"
        );
        dateTimesMap.put("31/9/2023", jul5Times);
        

    }

    public static ComboBox<String> createCountryDropDown() {
        ObservableList<String> countryOptions = FXCollections.observableArrayList(
                "France",
                "United Arab Emirates",
                "United States"
        );

        ComboBox<String> countryDropDown = new ComboBox<>(countryOptions);
        countryDropDown.setPromptText("Select Country");

        return countryDropDown;
    }

    public static ComboBox<String> createCityDropDown(String selectedCountry) {
        ObservableList<String> cities = getCitiesForCountry(selectedCountry);

        ComboBox<String> cityDropDown = new ComboBox<>(cities);
        cityDropDown.setPromptText("Select City");

        return cityDropDown;
    }

    public static ComboBox<String> createDateDropDown(String selectedCity) {
        ObservableList<String> dates = cityDatesMap.getOrDefault(selectedCity, FXCollections.observableArrayList());

        ComboBox<String> dateDropDown = new ComboBox<>(dates);
        dateDropDown.setPromptText("Select Date");

        return dateDropDown;
    }

    public static ComboBox<String> createTimeDropDown(String selectedDate) {
        ObservableList<String> times = dateTimesMap.getOrDefault(selectedDate, FXCollections.observableArrayList());

        ComboBox<String> timeDropDown = new ComboBox<>(times);
        timeDropDown.setPromptText("Select Time");

        return timeDropDown;
    }

    private static ObservableList<String> getCitiesForCountry(String selectedCountry) {
        return countryCitiesMap.getOrDefault(selectedCountry, FXCollections.observableArrayList());
    }

}
















   
