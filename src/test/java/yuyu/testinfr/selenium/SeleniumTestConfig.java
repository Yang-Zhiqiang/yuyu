package yuyu.testinfr.selenium;

import jp.co.slcs.swak.core.resource.ConfigFile;
import jp.co.slcs.swak.core.resource.XMLResourceUtil;
import lombok.Getter;
import lombok.Setter;

import org.openqa.selenium.WebDriver;

/**
 * Selenium を使ったブラウザ動作テストの設定です。<br />
 * conf / selenium-test-config.xml の設定値が {@link SeleniumConfig#instance} に反映されます。
 */
public class SeleniumTestConfig {

    public static final SeleniumTestConfig instance = XMLResourceUtil.getXMLResource(
        ConfigFile.getConfigFileStream("selenium-test-config.xml"),
        SeleniumTestConfig.class
        );

    public static class SeleniumConfig {
        @Getter @Setter
        private Class<WebDriver> webDriver;

        @Getter @Setter
        private String ieDriverServer;

        @Getter @Setter
        private String chromeDriver;
    }

    @Getter @Setter
    private SeleniumConfig seleniumConfig;

    @Getter @Setter
    private String protocol;

    @Getter @Setter
    private String host;

    @Getter @Setter
    private int    port;

    @Getter @Setter
    private String contextName;

    @Getter @Setter
    private String screenshotDir;

    @Getter @Setter
    private String assertionErrorScreenshotFileName;

    @Getter @Setter
    private int    delay;

    @Getter @Setter
    private int windowSizeWidth;

    @Getter @Setter
    private int windowSizeHeight;
}
