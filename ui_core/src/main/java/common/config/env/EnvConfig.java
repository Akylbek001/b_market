package common.config.env;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:environment.properties"})
public interface EnvConfig extends Config{
    @Key("run")
    String run();

    @Key("selenoid.url")
    String selenoidUrl();

    @Key("browser")
    String browser();

    @Key("base.url")
    String baseUrl();

    @Key("ownHouseProgram.path")
    String ownHouseProgramPath();

    @Key("contacts.path")
    String contactsPath();

    @Key("faq.url")
    String faqUrl();

    @Key("internetBanking.url")
    String internetBankingUrl();

    @Key("mortgage.path")
    String mortgagePath();

    @Key("calc.url")
    String calcUrl();

    @Key("news.path")
    String newsPath();

    @Key("programs.path")
    String programsPath();

    @Key("siteMap.path")
    String siteMapPath();

    @Key("newBuildings.path")
    String newBuildingsPath();

    @Key("baspanaInfo.path")
    String baspanaInfoPath();

    @Key("baiterek.url")
    String baiterekUrl();

    @Key("depositPortfolio.path")
    String depositPortfolioPath();

    @Key("facebook.url")
    String facebookUrl();

    @Key("vk.url")
    String vkUrl();

    @Key("instagram.url")
    String instagramUrl();

    @Key("youtube.url")
    String youtubeUrl();


    @Key("googlePlay.url")
    String googlePlayUrl();

    @Key("appStore.url")
    String appStoreUrl();

    @Key("baspanaNews.path")
    String baspanaNewsPath();

    @Key("tg.url")
    String tgUrl();

    @Key("whatsapp.url")
    String whatsappUrl();

    @Key("auth.path")
    String authPath();

    @Key("favorite.forNotAuthorized")
    String favoriteForNotAuthorized();
}
