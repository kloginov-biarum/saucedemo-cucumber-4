package steps;

import org.junit.Before;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SideBar;

public class BaseSteps {
    static String BASE_URL="https://www.saucedemo.com/";
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    SideBar sideBar = new SideBar();


}
