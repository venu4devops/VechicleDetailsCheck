package cardetailscheck.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.objects.HomePage;
import page.objects.VehicleIdentityPage;
import pojos.Vehicle;
import utils.FileUtils;
import utils.VehicleUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VehiclesDetailsStepDefs {
    List<String> vehicleRegistrationNumbers = new ArrayList<>();
    List<Vehicle> actualVehicleList = new ArrayList<>();
    HomePage homePage;
    VehicleIdentityPage vehicleIdentityPage;

    public VehiclesDetailsStepDefs() {
    }

    @Given("^I read the car numbers from (.*)$")
    public void readCarNumbers(String fileName) throws IOException {
        vehicleRegistrationNumbers = VehicleUtils.getVehicleRegistrationNumbers(FileUtils.readFile(fileName));
    }

    @When("^I run it through the cartaxcheck website$")
    public void getCarDetails() {
        homePage = new HomePage();
        vehicleIdentityPage = new VehicleIdentityPage();
        vehicleRegistrationNumbers.forEach(vehicleRegistrationNumber -> {
            homePage.load();
            homePage.enterRegistrationNumber(vehicleRegistrationNumber);
            homePage.freeCarCheck();
            Vehicle vehicle = new Vehicle(
                    vehicleRegistrationNumber,
                    vehicleIdentityPage.getMake(),
                    vehicleIdentityPage.getModel(),
                    vehicleIdentityPage.getColour(),
                    vehicleIdentityPage.getYear()
            );
            actualVehicleList.add(vehicle);
        });
    }

    @Then("^the details should match (.*)$")
    public void verifyDetails(String fileName) throws IOException {
        Map<String, Vehicle> expectedVehicleDetails = new HashMap<>();
        List<String> vehicleDetails = FileUtils.readFile(fileName);
        vehicleDetails.forEach(vehicleDetail -> {
            Vehicle vehicle = new Vehicle(vehicleDetail);
            expectedVehicleDetails.put(vehicle.getRegistrationNumber(), vehicle);
        });
        String reportString = " ";
        boolean areAllCarDetailsMatched = true;
        for (Vehicle vehicle : actualVehicleList) {
            Vehicle expectedVehicle = expectedVehicleDetails.get(vehicle.getRegistrationNumber());
            if (expectedVehicle == null) {
                areAllCarDetailsMatched = false;
                reportString = reportString.concat("Vehicle with registration number " + vehicle.getRegistrationNumber() + " is not found\n");
            } else if (!vehicle.equals(expectedVehicle)) {
                areAllCarDetailsMatched = false;
                reportString = reportString.concat("Vehicle with registration number " + vehicle.getRegistrationNumber() +
                        " doesnot match the expected result\n");
            }
        }
        Assert.assertTrue(reportString, areAllCarDetailsMatched);
    }
}
