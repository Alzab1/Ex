package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class AmazonProductsOutputPage extends BasePage {
    private Collection<SelenideElement> itemBlocksCollection
            = $$("div[class='s-result-list s-search-results sg-row']>div[data-index]");
    private  Collection<SelenideElement> prices = $$("div[class='s-result-list s-search-results sg-row']>div[data-index] span.a-offscreen");
 //  private SelenideElement exp= $x(".//div[@class='s-result-list s-search-results sg-row']//div[@data-index='0']//span[@class='a-price']/span[1]");
 //   private SelenideElement exp= $x(".//div[@class='s-result-list s-search-results sg-row']//div[@data-index='3']//span[@class='a-size-base-plus a-color-base a-text-normal']");

    private SelenideElement hamburgerMenuIcon = $("#nav-hamburger-menu");

    private SelenideElement getHamburgerMenuElement(String categoryName) {
        return $x(String.format(".//ul[contains(@class,'hmenu-visible')]/li/a/div[contains(text(),'%s')]"
                , categoryName));
    }

    public void getProductListPageByHamburgerMenuCategoryNames(String categoryName, String subCategoryName) {
        hamburgerMenuIcon.click();
        getHamburgerMenuElement(categoryName).click();
        Selenide.sleep(30000);
        getHamburgerMenuElement(subCategoryName).click();
    }

    public void filterByPriceRange(String minPrice, String maxPrice) {
        new Filters().SetPriceRangeGo(minPrice, maxPrice);
    }

    public void filterByStarsRating(int numStars) {
        new Filters().SetStarsRatingReview(numStars);
    }

    public boolean checkItemsPrices(String minPrice, String maxPrice, int itemQuantity){
        Selenide.sleep(2000);
        if(itemBlocksCollection.size()>itemQuantity){
      List<String> pricesInString =  prices.stream().map(s ->s.getText().replaceAll("\\D", ""))
              .collect(Collectors.toList());
 //           System.out.println(pricesInString);
      return pricesInString.stream().mapToInt(Integer::parseInt).allMatch((s) -> s>=Integer.parseInt(minPrice)
              && s<=Integer.parseInt(maxPrice));}
        else {
            System.out.println("items quantity is less");return false;}
    }
}
