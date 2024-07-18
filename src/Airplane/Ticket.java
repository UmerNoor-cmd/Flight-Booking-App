package Airplane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.HashMap;
import java.util.Map;

public class Ticket {

    private static final Map<String, ObservableList<String>> priceMap = new HashMap<>();

    static {
        initializeData();
    }

    private static void initializeData() {
        ObservableList<String> Economyprice = FXCollections.observableArrayList("$300");
        priceMap.put("Economy", Economyprice);

        ObservableList<String> Premiumprice = FXCollections.observableArrayList("$600");
        priceMap.put("Premium", Premiumprice);

        ObservableList<String> BusinessClassprice = FXCollections.observableArrayList("$1200");
        priceMap.put("Business Class", BusinessClassprice);

        ObservableList<String> FirstClassprice = FXCollections.observableArrayList("$1800");
        priceMap.put("First Class", FirstClassprice);
    }

    public static Map<String, ObservableList<String>> createclassTypeDropDown() {
        initializeData();

        ObservableList<String> classTypeOptions = FXCollections.observableArrayList(
                "Economy",
                "Premium",
                "Business Class",
                "First Class"
        );

        ComboBox<String> classTypeDropDown = new ComboBox<>(classTypeOptions);
        classTypeDropDown.setPromptText("Select Class");

        Map<String, ObservableList<String>> result = new HashMap<>();
        result.put("classTypeOptions", classTypeOptions);
        result.put("prices", priceMap.get("Economy")); // Default to Economy prices
        return result;
    }

    public static ObservableList<String> getPrice(String classType) {
        return priceMap.get(classType);
    }
}
