package imdb;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTests extends BaseTest {
    @Test
    private void searchByKeywordShouldDisplayAppropriatePage() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SearchBar searchBar = page.getSearchBar();
        System.out.println("here 1");
        searchBar.insertSearchQuery("Matrix");
        SearchResultsPage searchResultsPage = searchBar.performSearchQuery();
        searchResultsPage.waitForLoadAndVerify();
    }

}
