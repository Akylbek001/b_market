package pages;

import common.utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    @Slf4j
    public class FooterPage extends BasePage {
    private static final By INTERNET_BANKING_LINK = By.cssSelector("a[href='https://online.hcsbk.kz/']");
    private static final By MORTGAGE_LINK = By.cssSelector("a[href='/programm-bank/mortgage-shares-index']");
    private static final By CALC_LINK = By.cssSelector("a[href='https://hcsbk.kz/ru/#calc_sect']");
    private static final By NEWS_LINK = By.cssSelector("a[href='/news-ads/news']");
    private static final By PROGRAMS_LINK = By.cssSelector("a[href='/programm-bank']");
    private static final By SITE_MAP_LINK = By.cssSelector("a[href='/Home/Sitemaps']");
    private static final By NEW_BUILDINGS_LINK = By.cssSelector("a[href='/pool/search']");
    private static final By ABOUT_BASPANA_KZ_LINK = By.cssSelector("a[href='/home/baspana-info']");
    private static final By BAITEREK_LINK = By.cssSelector("a[href='https://www.baiterek.gov.kz/ru']");
    private static final By INFORMATION_SECURITY__MEMO_LINK = By.xpath(
            "//*[contains(text(), 'Памятка по информационной безопасности')]"
    );
    private static final By DEPOSIT_PORTFOLIO_LINK = By.cssSelector("a[href='/report/statis']");
    private static final By FACEBOOK_LINK = By.cssSelector("a[href='https://www.facebook.com/Otbasybankkz/']");
    private static final By VK_LINK = By.cssSelector("a[href='https://vk.com/otbasybankkz']");
    private static final By INSTAGRAM_LINK = By.cssSelector("a[href='https://www.instagram.com/otbasy_bank_kz/']");
    private static final By YOUTUBE_LINK = By.cssSelector("a[href='https://www.youtube.com/channel/UCEehsItjnHv_XEVDvwKadtA/feed?view_as=public']");
    private static final By APPSTORE_LINK = By.cssSelector("a[href='https://apps.apple.com/us/app/zssb-24/id1148478653']");
    private static final By GOOGLEPLAY_LINK = By.cssSelector("a[href='https://play.google.com/store/apps/details?id=kz.sdk.hcsbk']");


    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click internet banking link")
    public FooterPage clickInternetBankingLink() {
        move.moveToElemAndClick(INTERNET_BANKING_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click mortgage link")
    public FooterPage clickMortgageLink() {
        move.moveToElemAndClick(MORTGAGE_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click calc link")
    public FooterPage clickCalcLink() {
        move.scrollToElement(CALC_LINK);
        button.btnClick(CALC_LINK);
        return this;
    }

    @Step("Click news link")
    public FooterPage clickNewsLink() {
        move.moveToElemAndClick(NEWS_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click programs link")
    public FooterPage clickProgramsLink() {
        move.moveToElemAndClick(PROGRAMS_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click siteMap link")
    public FooterPage clickSiteMapLink() {
        move.moveToElemAndClick(SITE_MAP_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click new buildings link")
    public FooterPage clickNewBuildingsLink() {
        move.moveToElemAndClick(NEW_BUILDINGS_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click about baspana.kz link")
    public FooterPage clickBaspanaInfoLink() {
        move.moveToElemAndClick(ABOUT_BASPANA_KZ_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click baiterek link")
    public FooterPage clickBaiterekLink() {
        move.moveToElemAndClick(BAITEREK_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click information security link")
    public FooterPage clickInformationSecurityLink() {
        move.moveToElemAndClick(INFORMATION_SECURITY__MEMO_LINK);
        WaitUtils.wait(10);
        return this;
    }

    @Step("Click deposit portfolio link")
    public FooterPage clickDepositPortfolioLink() {
        move.moveToElemAndClick(DEPOSIT_PORTFOLIO_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click facebook link")
    public FooterPage clickFacebookLink() {
        move.moveToElemAndClick(FACEBOOK_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click vk link")
    public FooterPage clickVkLink() {
        move.moveToElemAndClick(VK_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click instagram link")
    public FooterPage clickInstagramLink() {
        move.moveToElemAndClick(INSTAGRAM_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click youtube link")
    public FooterPage clickYoutubeLink() {
        move.moveToElemAndClick(YOUTUBE_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click appStore link")
    public FooterPage clickAppStoreLink() {
        move.moveToElemAndClick(APPSTORE_LINK);
        WaitUtils.wait(3);
        return this;
    }

    @Step("Click google play link")
    public FooterPage clickGooglePlayLink() {
        move.moveToElemAndClick(GOOGLEPLAY_LINK);
        WaitUtils.wait(3);
        return this;
    }
}
