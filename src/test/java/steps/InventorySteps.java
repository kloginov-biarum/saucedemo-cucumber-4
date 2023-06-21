package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.node.DoubleNode;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

public class InventorySteps extends BaseSteps{

    @Then("^I am on the page Inventory$")
    public void iAmOnThePageInventory() {
        inventoryPage.inventoryList.shouldBe(visible);
    }

    @Then("^inventory item quantity is (\\d+)$")
    public void inventoryItemQuantityIs(int expectedItemQuantity) {
        //check that quantity is 6
        inventoryPage.inventoryItems.filterBy(visible).shouldHave(size(expectedItemQuantity));
    }


    @Then("^all items name are sorted alphabetically$")
    public void allItemsNameAreSortedAlphabetically() {
        List<String> actualNames = new ArrayList<>();
        for (SelenideElement itemName: inventoryPage.itemNames) {
            actualNames.add(itemName.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames);
        assertEquals(expectedNames, actualNames);
    }

    @When("^I choose sorting option by name A-Z$")
    public void iChooseSortingOptionByNameAZ() {
        inventoryPage.sortDropdown.click();
        inventoryPage.optionAZ.shouldBe(visible).click();
    }

    @When("^I choose sorting option by name Z-A$")
    public void iChooseSortingOptionByNameZA() {
        inventoryPage.sortDropdown.click();
        inventoryPage.optionZA.shouldBe(visible).click();
    }

    @Then("^all items name are sorted in reverse alphabetical order$")
    public void allItemsNameAreSortedInReverseAlphabeticalOrder() {
        List<String> expectedNames = new ArrayList<>();
        for (SelenideElement itemName: inventoryPage.itemNames) {
            expectedNames.add(itemName.getText());
        }
        sort(expectedNames, reverseOrder());
        inventoryPage.itemNames.shouldHave(exactTexts(expectedNames));
    }

    @When("^I choose sorting option by price from low to high$")
    public void iChooseSortingOptionByPriceFromLowToHigh() {
        inventoryPage.sortDropdown.click();
        inventoryPage.optionLowToHigh.shouldBe(visible).click();
    }
//"9.99" - > 9.99

    @Then("^all prices are sorted from low to high$")
    public void allPricesAreSortedFromLowToHigh() {
        List<Double> actualPrices = new ArrayList<>();
        for (SelenideElement itemPrice: inventoryPage.itemPrices) {
            actualPrices.add(parseDouble(itemPrice.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);
        List <String> expectedPricesText = new ArrayList<>();
        for (Double value:expectedPrices) {
            expectedPricesText.add(value.toString());
        }
        inventoryPage.itemPrices.shouldHave(texts(expectedPricesText));
    }
}
