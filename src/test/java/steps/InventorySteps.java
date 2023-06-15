package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Condition.*;

public class InventorySteps extends BaseSteps{

    @Then("^I am on the page Inventory$")
    public void iAmOnThePageInventory() {
        inventoryPage.inventoryList.shouldBe(visible);
    }
}
