package yuyu.testinfr.selenium;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import yuyu.def.db.entity.AS_Kinou;

import com.google.common.base.Strings;

/**
 * Webアプリケーション の Selenium サポートクラスです。<br />
 * <ul>
 *  <li>Java コードから Selenium を使って Webアプリケーション を起動し、
 *      各種動作テストを行う為の基盤機能を提供します。</li>
 *  <li>Selenium を使うことで
 *      「業務機能の動作テストを、常に同じ操作で、繰り返し何度でも再実行が可能」
 *      となります。</li>
 *  <li>SLCで、今まで手動で行っていた「ST」と呼ばれるシステムテストも、テストコードを組みさえすれば
 *      「人の手を介さず、何度でも ST をやり直す」
 *      ことも可能となります。</li>
 * </ul>
 */
public class SeleniumSupport {

    @Inject
    protected WebDriver driver;

    @Inject
    protected SeleniumTestConfig config;

    private String methodNameS = null;
    private String methodNameH = null;

    private static long screenshotCount = 0;
    private static long htmlCount = 0;

    public void open(String url) {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(config.getWindowSizeWidth(), config.getWindowSizeHeight()));
        //        driver.manage().window().maximize();
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        String childWindowHandle = driver.getWindowHandle();
        driver.close();
        switchToParentWindow(childWindowHandle);
    }

    public void clickButton(String buttonId) {
        String resultButtonId = buttonId;
        if( "#".equals(buttonId.substring(1,2)) ){
            resultButtonId = buttonId.substring(2, buttonId.length()-1);
        }
        driver.findElement(By.id(resultButtonId)).click();
        delay();
    }

    public void setToTextBox(String textBoxId, String value) {
        driver.findElement(By.id(textBoxId)).clear();
        driver.findElement(By.id(textBoxId)).sendKeys(value);
    }


    public void setToCheckBox(String checkBoxId, boolean checked) {
        WebElement checkBox = driver.findElement(By.id(checkBoxId));
        if ((checked && ( ! checkBox.isSelected())) ||
            (( ! checked) && checkBox.isSelected()))
        {
            checkBox.click();
        }
    }

    protected void switchToNewWindow() {
        delay();
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(driver.getWindowHandle()))
            {
                continue;
            }
            driver.switchTo().window(handle);
            break;
        }
    }

    protected void switchToParentWindow(String childWindowHandle) {
        delay();
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(childWindowHandle))
            {
                continue;
            }
            driver.switchTo().window(handle);
            break;
        }
    }

    protected void switchToNewWindowHandle(Set<String> windowHandles) {

        delay();
        Set<String> newHandles = driver.getWindowHandles();
        newHandles.removeAll(windowHandles);
        Iterator<String> newHandle = newHandles.iterator();

        driver.switchTo().window(newHandle.next());

    }

    public void assertValue(String id, String expected) {
        WebElement element = driver.findElement(By.id(id));
        String value;
        switch (element.getTagName().toLowerCase()) {
            case "input":
                value = element.getAttribute("value");
                break;
            case "span":
                value = element.getText();
                break;
            case "textarea":
                value = element.getAttribute("value");
                break;
            default:
                throw new UnsupportedOperationException(element.getTagName() + " タグの値検証には未対応です。");
        }
        try {
            assertEquals(
                id + "にセットされている値は '" + value + "' です。期待値 '" + expected + "' がセットされていません。",
                expected,
                value
                );
        } catch (AssertionError e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            throw e;
        }
    }

    public void takeScreenshot(String fileName) {
        delay();
        File ssDir  = new File(config.getScreenshotDir());
        File ssFile = new File(ssDir, fileName);
        if (ssFile.getParentFile() != null) {
            ssFile.getParentFile().mkdirs();
        }
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(ssFile)) ) {
            byte[] ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            out.write(ss);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void delay(int... millils) {
        try {
            Thread.sleep(millils.length == 0 ? config.getDelay() : millils[0]);
        } catch (InterruptedException e) {
        }
    }

    public void takeScreenshot(AS_Kinou kinou) {

        StackTraceElement stack[] = (new Throwable()).getStackTrace();

        int i = 0;

        String className = null;
        String kinouId = kinou.getKinouId();

        while (i < stack.length) {
            StackTraceElement frame = stack[i];

            className = frame.getClassName();

            if (className.matches(".*" + kinou.getKinouId() + ".Selenium" + ".*")) {
                if (Strings.isNullOrEmpty(methodNameS) || !methodNameS.equals(frame.getMethodName())) {
                    screenshotCount = 0;
                    methodNameS = frame.getMethodName();
                }
                break;
            }

            i++;
        }

        String ymd = new BizDateFormat("yyyyMMdd").format(BizDate.getSysDate());
        String count = String.format("%04d", Long.valueOf(++screenshotCount));
        String methodNM = Character.toTitleCase(methodNameS.charAt(0)) + methodNameS.substring(1,4).toLowerCase() + Character.toTitleCase(methodNameS.charAt(4)) + methodNameS.substring(5);
        PackageWebApp basePkg = new PackageWebApp();
        String testFolderNM = basePkg.getTestFolderNM(methodNM);
        takeScreenshot(kinouId + "/" + ymd  + "/" + testFolderNM + "/" + Character.toTitleCase(kinouId.charAt(0)) + kinouId.substring(1).toLowerCase() + methodNM + "_"  + count + ".png");

    }

    public void returnWindow() {
        driver.switchTo().defaultContent();
    }

    public void clickSearchButton(String buttonId) {
        String resultButtonId = buttonId;
        if( "#".equals(buttonId.substring(1,2)) ){
            resultButtonId = buttonId.substring(2, buttonId.length()-1);
        }
        driver.findElement(By.id(resultButtonId)).click();

        delay(2500);
    }

    public void getPageHTMLSource(AS_Kinou kinou) {

        BizDateFormat bdf = new BizDateFormat("yyyyMMdd");
        String kinouId = kinou.getKinouId();

        StackTraceElement stack[] = (new Throwable()).getStackTrace();

        int i = 0;

        String className = null;

        while (i < stack.length) {
            StackTraceElement frame = stack[i];

            className = frame.getClassName();

            if (className.matches(".*" + kinouId + ".Selenium" + ".*")) {
                if (Strings.isNullOrEmpty(methodNameH) || !methodNameH.equals(frame.getMethodName())) {
                    htmlCount = 0;
                    methodNameH = frame.getMethodName();
                }
                break;
            }

            i++;
        }

        String resultMethodNM = Character.toTitleCase(methodNameH.charAt(0)) + methodNameH.substring(1,4).toLowerCase() + Character.toTitleCase(methodNameH.charAt(4)) + methodNameH.substring(5);

        PackageWebApp basePkg = new PackageWebApp();
        String testFolderNM = basePkg.getTestFolderNM(methodNameH);
        String count = String.format("%04d", Long.valueOf(++htmlCount));
        String fileName = kinouId + "/" + bdf.format(BizDate.getSysDate()) + "/" + testFolderNM + "/HTML/" + Character.toTitleCase(kinouId.charAt(0))
            + kinouId.substring(1).toLowerCase() + resultMethodNM + "_"  + count + ".log";

        File ssFile = new File(config.getScreenshotDir(), fileName);
        if (ssFile.getParentFile() != null) {
            ssFile.getParentFile().mkdirs();
        }

        try (OutputStream out = new FileOutputStream(ssFile)) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"))) {
                writer.write(driver.getPageSource());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void clickNavigateBack() {
        driver.navigate().back();
    }
}
