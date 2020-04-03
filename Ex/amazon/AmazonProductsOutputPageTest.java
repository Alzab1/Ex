package tests.testng;


import org.testng.Assert;
import org.testng.annotations.Test;
import web.pages.AmazonProductsOutputPage;

public class AmazonProductsOutputPageTest {
    @Test
            public void openProductsList() {
        String minPrice = "1";
        String maxPrice = "20";
        int numStarsAndUp = 1;
        int quantityItems = 5;
        AmazonProductsOutputPage amazonProductsOutputPage = new AmazonProductsOutputPage();
        amazonProductsOutputPage.open();
        amazonProductsOutputPage
                .getProductListPageByHamburgerMenuCategoryNames("Baby","Gifts");
        amazonProductsOutputPage.filterByPriceRange(minPrice,maxPrice);
        amazonProductsOutputPage.filterByStarsRating(numStarsAndUp);
        Assert.assertTrue(amazonProductsOutputPage.checkItemsPrices(minPrice,maxPrice,quantityItems));
    }
}
