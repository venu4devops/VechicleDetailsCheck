package utils;

import pojos.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleUtils {
    public static List<String> getVehicleRegistrationNumbers(List<String> fileContent) {
        List<String> vehicleRegistrationNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}(\\s)?[A-Z]{3}");
        for(String eachLine: fileContent){
            Matcher matcher = pattern.matcher(eachLine);
            while(matcher.find()) {
                String vehicleRegistrationNumber = matcher.group();
                vehicleRegistrationNumber = vehicleRegistrationNumber.replace(" ", "");
                vehicleRegistrationNumbers.add(vehicleRegistrationNumber);
            }
        }
        return vehicleRegistrationNumbers;
    }
}
