package yuyu.testinfr.inject;

import java.io.File;

import jp.co.slcs.swak.core.inject.AbstractSWAKModule;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import yuyu.testinfr.selenium.SeleniumTestConfig;

/**
 * Selenium の WebDriver に対する実装クラスをバインドする Google Guice 用 Module です。
 */
public class SeleniumModule extends AbstractSWAKModule {

    @Override
    protected void configure() {

        SeleniumTestConfig config = SeleniumTestConfig.instance;

        bindInstance(config);

        if (config.getSeleniumConfig().getWebDriver().equals(InternetExplorerDriver.class)) {
            System.setProperty(
                    InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
                    new File(config.getSeleniumConfig().getIeDriverServer()).getAbsolutePath()
                    );
        } else if (config.getSeleniumConfig().getWebDriver().equals(ChromeDriver.class)) {
            System.setProperty(
                    ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                    new File(config.getSeleniumConfig().getChromeDriver()).getAbsolutePath()
                    );
        }

        //        bind(WebDriver.class).to(config.getSeleniumConfig().getWebDriver());
    }

}
