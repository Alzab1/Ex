package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Filters {
    private SelenideElement filterPriceLowPriceInputField = $("input[id='low-price']");
    private SelenideElement filterPriceHighInputField = $("input[id='high-price']");
    private SelenideElement filterByPriceGoButton = $("input.a-button-input");
    private SelenideElement getFilterByStarsRatingReviewElement (int numStars) {
        return $(String.format("section[aria-label*='%d Star']",numStars));}
    public void SetPriceRangeGo(String minPrice, String maxPrice) {
        filterPriceLowPriceInputField.sendKeys(minPrice);
        filterPriceHighInputField.sendKeys(maxPrice);
        filterByPriceGoButton.click();
    }
    public void SetStarsRatingReview(int numStars){
        getFilterByStarsRatingReviewElement(numStars).click();
    }
}
