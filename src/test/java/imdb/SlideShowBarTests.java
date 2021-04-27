package imdb;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SlideShowBarTests extends BaseTest {
    @Test
    public void verifyFeaturedSlideShow(){
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar featuredBar = page.getFeaturedBar();
        assertFalse(featuredBar.isLeftButtonPresent(), "Left button should not be present");
        featuredBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyExclusiveSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar featuredBar = page.getExclusiveBar();
        assertFalse(featuredBar.isLeftButtonPresent(), "Left button should not be present");
        featuredBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyStreamingSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar streamingBar = page.getStreamingBar();
        assertFalse(streamingBar.isLeftButtonPresent(), "Left button should not be present");
        streamingBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyComingSoonSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar comingSoonBar = page.getComingSoonBar();
        assertFalse(comingSoonBar.isLeftButtonPresent(), "Left button should not be present");
        comingSoonBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyWatchSoonSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar watchSoonBar = page.getWatchSoonBar();
        assertFalse(watchSoonBar.isLeftButtonPresent(), "Left button should not be present");
        watchSoonBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyEditorsPickSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar editorsPickBar = page.getEditorsPickBar();
        assertFalse(editorsPickBar.isLeftButtonPresent(), "Left button should not be present");
        editorsPickBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }

    @Test
    public void verifyBornTodaySlideShow() throws Exception {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar bornTodayBar = page.getBornTodayBar();
        assertFalse(bornTodayBar.isLeftButtonPresent(), "Left button should not be present");
        bornTodayBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }
    @Test
    public void verifyTopNewsSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar topNewsBar = page.getTopNewsBar();
        assertFalse(topNewsBar.isLeftButtonPresent(), "Left button should not be present");
        topNewsBar.slideRight(); // should be able to slide right at least once, if not possible will get (timeout currently) error
    }


    @Test // For testing screenshot
    public void failingTopNewsSlideShow() {
        HomePage page = new HomePage(this.webDriver);
        HomePage.SlideShowBar topNewsBar = page.getTopNewsBar();
        assertTrue(topNewsBar.isLeftButtonPresent(), "Left button should be present");
    }
}
