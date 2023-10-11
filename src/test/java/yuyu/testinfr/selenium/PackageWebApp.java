package yuyu.testinfr.selenium;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.util.Lazy;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBJPQLQuery;
import jp.co.slcs.swak.db.typesafe.ExDBField;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.text.csv.CsvColumnDesc;
import jp.co.slcs.swak.file.description.text.csv.CsvHeadDesc;
import jp.co.slcs.swak.util.reflect.ClassUtils;
import jp.co.slcs.swak.web.message.MessageManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.infr.report.PdfUtil;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.lowagie.text.pdf.PdfReader;

/**
 * <p>package (web app) を「自動的にブラウザで操作する」ことが可能になる「(seleniumを使った)統合テスト基盤」です。<br />
 *    Java のコード（JUnit テストコード）から「ブラウザを開き、操作し、表示内容を検証」することが可能となります。<br />
 * </p>
 * <p>seleniumを使ったテストは以下のように実行します。</p>
 * <ol>
 *  <li>src / test / resources / conf / selenium-test-config.xml の設定を確認する。</li>
 *  <li>tomcat を起動し、テスト対象のWebアプリを動作させる。</li>
 *  <li>JUnitで、このクラスを継承したユニットテストクラスを実行する。({@link SeleniumUserTourokuTest} 等)</li>
 *  <li>あとは selenium がテストクラスにプログラムした通りにブラウザを操作してテストを実施してくれる。</li>
 *  <li>何も問題が無ければテストは成功するし、何か問題が発生すればテストは失敗で終了する。</li>
 * </ol>
 * <p>このクラスは、ブラウザを操作する為の以下のメソッドを提供します</p>
 * <table border="1" cellspacing="1" cellpadding="2">
 *  <tr bgcolor="whitesmoke">
 *   <th>分類</th>
 *   <th>コマンド</th>
 *   <th>概要</th>
 *  </tr>
 *  <tr>
 *   <td rowspan="7">基本<br />動作</td>
 *   <td>{@link #open()}</td>
 *   <td>ブラウザで package (web app) の welcome-page （ログイン画面）を開きます。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #quit()}</td>
 *   <td>{@link #open()} で開いたブラウザウィンドウを閉じます。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #login(String, String)}</td>
 *   <td>ログイン画面でログインします。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #logout()}</td>
 *   <td>メニュー画面でログアウトします。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #takeScreenshot(String)}</td>
 *   <td>その時点の画面スクリーンショットを撮ります。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #openKinou(AS_Kinou)}</td>
 *   <td>メニュー画面で機能ボタンを押下し、機能のサブウィンドウを開きます。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #clickButton(String)}<br />
 *       {@link #clickTojiruBtn()}
 *   </td>
 *   <td>ボタンを押下します。</td>
 *  </tr>
 *
 *
 *
 *  <tr>
 *   <td rowspan="3">設定</td>
 *   <td>{@link #setToTextBox(Item, String)}<br />
 *       {@link #setToTextBox(Item, int, String)}
 *   </td>
 *   <td>テキストボックスに値を設定します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #setToCheckBox(Item, boolean)}<br />
 *       {@link #setToCheckBox(Item, int, boolean)}
 *   </td>
 *   <td>チェックボックスに値を設定します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #setToKubun(Item, Classification)}<br />
 *       {@link #setToKubun(Item, int, Classification)}
 *   </td>
 *   <td>区分項目（&lt;select&gt; または &lt;input type="radio"&gt; エレメント）に区分値を設定します。</td>
 *  </tr>
 *
 *
 *
 *  <tr>
 *   <td rowspan="5">検証</td>
 *   <td>{@link #assertTitle(AS_Kinou)}</td>
 *   <td>指定機能のウィンドウタイトルが表示されているか検証します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #assertPageNo(int)}</td>
 *   <td>期待通りのページが表示されているか検証します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #assertMessages(MessageManager)}</td>
 *   <td>期待通りのメッセージが表示されているか検証します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #assertValue(Item, String)}<br />
 *       {@link #assertValue(Item, int, String)}</td>
 *   <td>画面項目に期待通りの値が設定されているか検証します。</td>
 *  </tr>
 *  <tr>
 *   <td>{@link #assertBool(Item, boolean)}<br />
 *       {@link #assertBool(Item, int, boolean)}</td>
 *   <td>画面項目に期待通りのブール値が設定されているか検証します。</td>
 *  </tr>
 *
 * </table>
 *
 *
 *
 * <ul>
 *  <li>コーディング例は {@link SeleniumUserTourokuTest} のソースを参照してください。</li>
 *  <li>実行前に conf / selenium-test-config.xml の設定内容も確認して下さい。</li>
 *  <li>スクリーンショット画像を保存するディレクトリは<br />
 *      &nbsp;&nbsp; conf / selenium-test-config.xml / seleniumTestConfig / screenshotDir <br />
 *      で指定します。
 *  </li>
 *  <li>[検証]系コマンド実行時に期待値と異なる値が表示されていた場合は、 AssertionError が発生し その時点でテストは失敗します。</li>
 *  <li>検証エラー発生時はその時点のスクリーンショットが "AssertionError.png" というファイル名で保存されます。<br />
 *      エラー時スクリーンショット画像のファイル名は selenium-test-config.xml の設定で変更できます。
 *  </li>
 * </ul>
 */
public class PackageWebApp extends SeleniumSupport {

    @Inject
    protected YuyuBaseConfig yuyuBaseConfig;

    @Inject
    private SeleniumReport seleniumReport;

    private String methodNmP = null;
    private String methodNmC = null;

    private static String currentHandle = null;

    private static final Lazy<AS_Kinou> login = new Lazy<>(
        new Supplier<AS_Kinou>() {
            @Override
            public AS_Kinou get() {
                return SWAKInjector.getInstance(BaseDomManager.class).getKinou("login");
            }
        }
        );

    private static final Lazy<AS_Kinou> menu  = new Lazy<>(
        new Supplier<AS_Kinou>() {
            @Override
            public AS_Kinou get() {
                return SWAKInjector.getInstance(BaseDomManager.class).getKinou("menu");
            }
        }
        );

    public void open() {
        open(
            String.format(
                "%s://%s:%d/%s/",
                config.getProtocol(),
                config.getHost(),
                Integer.valueOf(config.getPort()),
                config.getContextName()
                )
            );
    }

    public void assertTitle(AS_Kinou kinou) {
        assertTitle(kinou, null);
    }

    public void assertTitle(AS_Kinou kinou, String assertionErrorMessage) {
        delay();
        try {
            assertEquals(
                (assertionErrorMessage == null) ? kinou.getKinouNm() + " 画面ではありません。" : assertionErrorMessage,
                    windowTitle(kinou),
                    driver.getTitle()
                );
        } catch (AssertionError e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            throw e;
        }
    }

    public void assertTitle(String kinouNm) {
        delay();
        try {
            assertEquals(
                windowTitle(kinouNm),
                driver.getTitle()
                );
        } catch (AssertionError e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            throw e;
        }
    }

    public void login(String userId, String password) {
        login(userId, password, true);
    }

    public void login(String userId, String password, boolean assertLogin) {
        assertTitle(login.get());
        setToTextBox("userId",   userId);
        setToTextBox("password", password);
        clickButton("loginBtn");
        if (assertLogin) {
            assertTitle(menu.get(), "ログインに失敗しました。");
        }
    }

    public void logout() {
        assertTitle(menu.get());
        clickButton("logoutBtn");
        delay();
        assertTitle("ログアウト");
    }

    public void openKinou(AS_Kinou kinou) {
        assertTitle(menu.get());
        WebElement btn = searchKinouBtn(kinou);
        btn.click();
        delay();
        switchToNewWindow();
        assertTitle(kinou, kinou.getKinouNm() + " 機能のウィンドウが開けません。");
    }

    public void clickTojiruBtn() {
        String handle = driver.getWindowHandle();
        try {
            clickButton("tojiruBtn");
        } catch (NoSuchElementException e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            fail("[閉じる]ボタンが見つかりません");
            throw e;
        }
        switchToParentWindow(handle);
    }

    public void setToTextBox(Item item, String value) {
        setToTextBox(item, Message.NO_ROW_NUMBER, value);
    }

    public void setToTextBox(Item item, int index, String value) {
        setToTextBox(item.getErrorItemId(index), value);
    }

    public void setToCheckBox(Item item, boolean checked) {
        setToCheckBox(item, Message.NO_ROW_NUMBER, checked);
    }

    public void setToCheckBox(Item item, int index, boolean checked) {
        setToCheckBox(item.getErrorItemId(index), checked);
    }

    public void setToKubun(Item item, Classification<?> kbn) {
        setToKubun(item, Message.NO_ROW_NUMBER, kbn);
    }

    public void setToKubun(Item item, int index, Classification<?> kbn) {
        WebElement element;
        try {
            element = driver.findElement(By.id(item.getErrorItemId(index)));
        } catch (NoSuchElementException e) {
            element = driver.findElement(By.id(item.getErrorItemId(index) + "[0]"));
        }
        switch (element.getTagName().toLowerCase()) {
            case "select":
                new Select(element).selectByValue(kbn.getValue());
                break;
            case "input":
                if (! element.getAttribute("type").equalsIgnoreCase("radio")) {
                    throw new UnsupportedOperationException(
                        "<" + element.getTagName() + " type='" + element.getAttribute("type") + "'>" +
                            " エレメントに区分値を設定する操作はサポートされていません。"
                        );
                }
                for (int i = 0; ; i++) {
                    try {
                        element = driver.findElement(By.id(item.getErrorItemId(index) + "[" + i + "]"));
                    } catch (NoSuchElementException e) {
                        takeScreenshot(config.getAssertionErrorScreenshotFileName());
                        fail("区分値「" + kbn.getContent() + "(" + kbn.getValue() + ")」に対する選択肢は画面に表示されていません。");
                        throw e;
                    }
                    if (element.getAttribute("value").equals(kbn.getValue())) {
                        element.click();
                        break;
                    }
                }
                break;
            default:
                throw new UnsupportedOperationException("<" + element.getTagName() + "> エレメントに区分値を設定する操作はサポートされていません。");
        }
    }

    public void setToKubun(Item item, String value) {
        setToKubun(item, Message.NO_ROW_NUMBER, value);
    }

    public void setToKubun(Item item, int index, String value) {
        WebElement element;
        try {
            element = driver.findElement(By.id(item.getErrorItemId(index)));
        } catch (NoSuchElementException e) {
            element = driver.findElement(By.id(item.getErrorItemId(index) + "[0]"));
        }
        switch (element.getTagName().toLowerCase()) {
            case "select":
                new Select(element).selectByValue(value);
                break;
            default:
                throw new UnsupportedOperationException("<" + element.getTagName() + "> エレメントに区分値を設定する操作はサポートされていません。");
        }
    }

    public void assertPageNo(int pageNo) {
        List<WebElement> elements = driver.findElements(By.name("pageNo"));
        WebElement       element  = elements.get(0);
        String           value    = element.getAttribute("value");
        int currentPageNo = Integer.valueOf(value).intValue();
        try {
            assertEquals(
                "P." + currentPageNo + " が表示されています。期待されたページ (P." + pageNo + ") に遷移していません。",
                currentPageNo,
                pageNo
                );
        } catch (AssertionError e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            throw e;
        }
    }

    public List<String> getMessages() {
        Builder<String> builder = ImmutableList.<String>builder();
        for (WebElement element : driver.findElements(By.className("error_message"))) {
            builder.add(element.getText());
        }
        return builder.build();
    }

    public void assertMessages(MessageManager msgManager) {
        delay();
        try {
            assertEquals(
                "期待されたメッセージが表示されていません。",
                Lists.transform(
                    msgManager.getMessages(),
                    new Function<Message, String>() {
                        @Override
                        public String apply(Message message) {
                            return message.toString();
                        }
                    }
                    ),
                    getMessages()
                );
        } catch (AssertionError e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            throw e;
        }
    }

    public void assertValue(Item item, String expected) {
        assertValue(item, Message.NO_ROW_NUMBER, expected);
    }

    public void assertValue(Item item, int index, String expected) {
        assertValue(item.getErrorItemId(index), expected);
    }

    public void assertBool(String id, boolean expected) {
        assertValue(id, expected ? "■" : "□");
    }

    public void assertBool(Item item, boolean expected) {
        assertBool(item, Message.NO_ROW_NUMBER, expected);
    }

    public void assertBool(Item item, int index, boolean expected) {
        assertBool(item.getErrorItemId(index), expected);
    }

    public void close(AS_Kinou kinou) {
        String childWindowHandle = driver.getWindowHandle();
        driver.close();
        switchToParentWindow(childWindowHandle);
        takeScreenshot(kinou);
        openKinou(kinou);
    }

    public void openChildWindowClick(String buttonId) {
        driver.findElement(By.id(buttonId)).click();
        delay();
        driver.switchTo().frame("_dialogFrame");
    }

    public void openNewWindowClick(String buttonId) {
        String resultButtonId = buttonId;
        if( "#".equals(buttonId.substring(1,2)) ){
            resultButtonId = buttonId.substring(2, buttonId.length()-1);
        }
        Set<String> windowHandles = driver.getWindowHandles();
        driver.findElement(By.id(resultButtonId)).click();
        delay();
        switchToNewWindowHandle(windowHandles);
    }

    public void closeNewWindow() {
        String childWindowHandle = driver.getWindowHandle();
        driver.close();
        delay();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!childWindowHandle.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }

        }
    }

    public void closeChildWindow() {
        clickButton("tojiruBtn");
        returnWindow();
    }

    public void clickLink(String tagId) {
        driver.findElement(By.tagName(tagId)).click();
        delay();
    }

    public void haitaOpenKinou(AS_Kinou kinou) {
        assertTitle(menu.get());
        WebElement btn = searchKinouBtn(kinou);
        btn.click();
        delay();
        haitaSwitchToNewWindow();
        assertTitle(kinou, kinou.getKinouNm() + " 機能のウィンドウが開けません。");
    }

    public void haitaToNewWindow() {
        delay();
        currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(currentHandle))
            {
                continue;
            }
            driver.switchTo().window(handle);
            break;
        }
    }

    public void haitaSwitchToNewWindow() {
        delay();
        for (String handle : driver.getWindowHandles()) {
            if (handle.equals(currentHandle) || handle.equals(driver.getWindowHandle()))
            {
                continue;
            }
            driver.switchTo().window(handle);
            break;
        }
    }

    public void haitaClose() {
        delay();
        driver.findElement(By.id("tojiruBtn")).click();
        driver.switchTo().window(currentHandle);
    }

    public void outCsv(AS_Kinou pTargetKinou, boolean dbFlgKbn) {

        String kinouId = pTargetKinou.getKinouId();
        List<String> tableIdList = new ArrayList<>();

        switch(kinouId) {

            case "login":

                tableIdList.add(AM_User.TABLE_NAME);
                break;

            case "menu":

                tableIdList.add(AM_User.TABLE_NAME);
                tableIdList.add(AS_Kinou.TABLE_NAME);
                tableIdList.add(AS_KinouMode.TABLE_NAME);
                tableIdList.add(AT_MyMenu.TABLE_NAME);
                tableIdList.add(AS_SubSystem.TABLE_NAME);
                tableIdList.add(AS_Category.TABLE_NAME);
                break;

            case "passwordhenkou":

                tableIdList.add(AM_User.TABLE_NAME);
                tableIdList.add(AT_UserHenkouRireki.TABLE_NAME);
                break;

            case "roletouroku":

                tableIdList.add(AM_Role.TABLE_NAME);
                break;

            case "rolekensaku":

                tableIdList.add(AM_Role.TABLE_NAME);
                break;

            case "usertouroku":

                tableIdList.add(AM_User.TABLE_NAME);
                tableIdList.add(AM_UserGroup.TABLE_NAME);
                tableIdList.add(AM_Role.TABLE_NAME);
                tableIdList.add(AT_UserRole.TABLE_NAME);
                break;

            case "userkensaku":

                tableIdList.add(AM_User.TABLE_NAME);
                break;

            case "holidaygrouptouroku":

                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                break;

            case "holidaytouroku":

                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                tableIdList.add(AT_Holiday.TABLE_NAME);
                tableIdList.add(AT_HolidayYoyaku.TABLE_NAME);
                break;

            case "kadoutimegrouptouroku":

                tableIdList.add(AT_KadouTimeGroup.TABLE_NAME);
                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                break;

            case "kadoutimetouroku":

                tableIdList.add(AT_KadouTimeGroup.TABLE_NAME);
                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                tableIdList.add(AT_KadouTime.TABLE_NAME);
                break;

            case "tokuteibikadoutimetouroku":

                tableIdList.add(AT_KadouTimeGroup.TABLE_NAME);
                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                tableIdList.add(AT_TokuteibiKadouTime.TABLE_NAME);
                break;

            case "kinouteigitouroku":

                tableIdList.add(AS_Kinou.TABLE_NAME);
                tableIdList.add(AS_KinouMode.TABLE_NAME);
                tableIdList.add(AT_KinouKengen.TABLE_NAME);
                tableIdList.add(AS_KinouModeSiborikomi.TABLE_NAME);
                tableIdList.add(AS_SubSystem.TABLE_NAME);
                tableIdList.add(AS_Category.TABLE_NAME);
                tableIdList.add(AM_Role.TABLE_NAME);
                tableIdList.add(AT_KadouTimeGroup.TABLE_NAME);
                break;

            case "accesslogsyoukai":

                tableIdList.add(AM_User.TABLE_NAME);
                tableIdList.add(AT_AccessLog.TABLE_NAME);
                tableIdList.add(AT_AccessLogSyousai.TABLE_NAME);
                tableIdList.add(AS_SubSystem.TABLE_NAME);
                tableIdList.add(AS_Category.TABLE_NAME);
                break;

            case "batchjyoukyousyoukai":

                tableIdList.add(AM_Batch.TABLE_NAME);
                tableIdList.add(AT_BatchJob.TABLE_NAME);
                tableIdList.add(AT_BatchLog.TABLE_NAME);
                tableIdList.add(AT_TyouhyouHozon.TABLE_NAME);
                tableIdList.add(AS_SubSystem.TABLE_NAME);
                tableIdList.add(AS_Category.TABLE_NAME);
                break;

            case "batchjikkoubikousin":

                tableIdList.add(AT_BatchDate.TABLE_NAME);
                break;

            case "yoyakudatahanei":

                tableIdList.add(AT_HolidayGroup.TABLE_NAME);
                tableIdList.add(AT_Holiday.TABLE_NAME);
                tableIdList.add(AT_HolidayYoyaku.TABLE_NAME);
                break;

            case "addressmasterhanei":

//                tableIdList.add(AM_Address.TABLE_NAME);
            	throw new RuntimeException("S案件では住所マスタテーブルが削除されているため、住所マスタ反映バッチのテストはできません");

            case "usergrouptouroku":

                tableIdList.add(AM_UserGroup.TABLE_NAME);
                break;

            case "usergroupkensaku":

                tableIdList.add(AM_UserGroup.TABLE_NAME);
                break;

            case "useritiranhyou":

                tableIdList.add(AM_UserGroup.TABLE_NAME);
                tableIdList.add(AM_User.TABLE_NAME);
                tableIdList.add(AM_Role.TABLE_NAME);
                break;

            default:
                throw new RuntimeException("CSV出力対象機能ではありません。");
        }

        outCsvFile(kinouId, tableIdList, dbFlgKbn);
    }

    public void outputPdf(AS_Kinou pTargetKinou) {

        String kinouId = pTargetKinou.getKinouId();
        BizDateFormat bdf = new BizDateFormat("yyyyMMdd");

        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        int i = 0;

        String className = null;

        while (i < stack.length) {
            StackTraceElement frame = stack[i];

            className = frame.getClassName();

            if (className.matches(".*" + kinouId + ".Selenium" + ".*")) {
                if (Strings.isNullOrEmpty(methodNmP) || !methodNmP.equals(frame.getMethodName())) {
                    methodNmP = frame.getMethodName();
                }
                break;
            }

            i++;
        }

        String resultMethodNM = Character.toTitleCase(methodNmP.charAt(0)) + methodNmP.substring(1,4).toLowerCase() + Character.toTitleCase(methodNmP.charAt(4)) + methodNmP.substring(5);
        String testFolderNM = getTestFolderNM(resultMethodNM);
        String fileName = kinouId + "/" + bdf.format(BizDate.getSysDate())  + "/" + testFolderNM + "/PDF/" + resultMethodNM + ".pdf";

        AT_TyouhyouHozon tyouhyouHozon = seleniumReport.getTyouhyouHozonbyReportKey();

        byte[] pdfDatas = seleniumReport.getPdfImages(new String[]{tyouhyouHozon.getReportKey()});

        if(pdfDatas == null){
            throw new BizAppException("EAS0026");
        }
        PdfReader reader;
        try {
            reader = new PdfReader(pdfDatas);
        } catch (IOException e1) {
            throw new BizAppException(e1, "EAS0019");
        }

        File ssFile = new File(config.getScreenshotDir(), fileName);
        if (ssFile.getParentFile() != null) {
            ssFile.getParentFile().mkdirs();
        }

        try(ByteArrayOutputStream oBaos = new ByteArrayOutputStream();
            BufferedOutputStream bOs = new BufferedOutputStream(new FileOutputStream(ssFile));) {
            PdfUtil.encrypt(reader , oBaos);
            bOs.write(oBaos.toByteArray());
        } catch (Exception e1) {
            throw new BizAppException(e1, "EAS0007");
        }

    }

    public String getTestFolderNM(String pMethodNm) {

        if (pMethodNm == null || pMethodNm.length() < 5) {
            return "Z_その他";
        }

        String resultMethodNm = pMethodNm.substring(4, 5);

        switch (resultMethodNm) {
            case "A" :
                return "A_画面制御";
            case "B" :
                return "B_画面遷移";
            case "C" :
                return "C_画面項目";
            case "D" :
                return "D_画面全体";
            case "E" :
                return "E_入力・表示項目";
            case "F" :
                return "F_エラーチェック（単項目）";
            case "G" :
                return "G_エラーチェック（業務）";
            case "H" :
                return "H_メッセージ";
            case "I" :
                return "I_全半角変換";
            case "J" :
                return "J_DB編集";
            case "K" :
                return "K_帳票項目出力";
            case "L" :
                return "L_カンバセーション確認";
            case "M" :
                return "M_テスト仕様書";
            case "N" :
                return "N_排他制御";
            case "O" :
                return "O_リスト表示のテスト";
            case "P" :
                return "P_二重POSTチェックのテスト";
            case "Q" :
                return "Q_帳票出力のテスト";
            default :
                return "Z_その他";
        }
    }

    public void clickTojiruBtn(AS_Kinou kinou) {
        String handle = driver.getWindowHandle();
        try {
            clickButton("tojiruBtn");
        } catch (NoSuchElementException e) {
            takeScreenshot(config.getAssertionErrorScreenshotFileName());
            fail("[閉じる]ボタンが見つかりません");
            throw e;
        }
        switchToParentWindow(handle);
        takeScreenshot(kinou);
        openKinou(kinou);
    }


    private String windowTitle(AS_Kinou kinou) {
        return windowTitle(kinou.getKinouNm());
    }

    private String windowTitle(String kinouNm) {
        return String.format("%s - %s", kinouNm, yuyuBaseConfig.getApplicationName());
    }

    private static Map<AS_Kinou, WebElement> kinouBtns = new HashMap<>();

    private WebElement searchKinouBtn(AS_Kinou kinou) {
        if (kinouBtns.containsKey(kinou)) {
            return kinouBtns.get(kinou);
        }

        String kinouPath = String.format(
            "/%s/%s/%s/",
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId()
        );

        for (WebElement element : driver.findElements(By.tagName("a"))) {
            String href = element.getAttribute("href");
            if (Strings.isNullOrEmpty(href)) continue;
            if (href.indexOf(kinouPath) >= 0) {
                kinouBtns.put(kinou, element.findElement(By.xpath("../../span[2]")));
                return kinouBtns.get(kinou);
            }
        }

        takeScreenshot(config.getAssertionErrorScreenshotFileName());
        fail(kinou.getKinouNm() + " 機能の起動ボタンが見つかりません。");
        throw new NoSuchElementException(kinou.getKinouNm() + " 機能の起動ボタンが見つかりません。");
    }

//
//    private WebElement searchKinouBtn(AS_Kinou kinou) {
//        for (int i = 0; ; i++) {
//            WebElement element;
//            try {
//                element = driver.findElement(By.id("menuContents[" + i + "].kinouNm")).findElement(By.xpath("../../span[2]"));
//            } catch (NoSuchElementException e) {
//                fail(kinou.getKinouNm() + " 機能の起動ボタンが見つかりません。");
//                takeScreenshot(config.getAssertionErrorScreenshotFileName());
//                throw e;
//            }
//            if (element.getText().equals(kinou.getKinouNm())) {
//                return element;
//            }
//        }
//    }

    private void outCsvFile(String kinouId, List<String> tableIdList, boolean dbFlgKbn) {

        for (String tableId : tableIdList) {

            List<Object> taihiData = load(tableId, dbFlgKbn);

            try {
                output(kinouId, tableId, taihiData, dbFlgKbn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static List<Object> load(String tableId, boolean dbFlgKbn) {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        if (!dbFlgKbn) {
            em.clear();
        }
        String query = $SELECT + "e" + $FROM + tableId + " e";
        ExDBJPQLQuery jpql = em.createJPQL(query);

        return jpql.getResultList();
    }

    @SuppressWarnings("unchecked")
    private void output(String kinouId, String tableId,  List<Object> taihiData, boolean dbFlgKbn) throws Exception {

        Class<Object> tableClass = null;

        BizDateFormat bdf = new BizDateFormat("yyyyMMdd");

        StackTraceElement stack[] = (new Throwable()).getStackTrace();

        int i = 0;

        String className = null;

        while (i < stack.length) {
            StackTraceElement frame = stack[i];

            className = frame.getClassName();

            if (className.matches(".*" + kinouId + ".Selenium" + ".*")) {
                if (Strings.isNullOrEmpty(methodNmC) || !methodNmC.equals(frame.getMethodName())) {
                    methodNmC = frame.getMethodName();
                }
                break;
            }

            i++;
        }

        String resultMethodNM = Character.toTitleCase(methodNmC.charAt(0)) + methodNmC.substring(1,4).toLowerCase() + Character.toTitleCase(methodNmC.charAt(4)) + methodNmC.substring(5);
        String testFolderNM = getTestFolderNM(resultMethodNM);

        String dbFlgKbnNm = (dbFlgKbn) ? "Before" : "After";

        String fileName = kinouId + "/" + bdf.format(BizDate.getSysDate()) + "/" + testFolderNM + "/CSV/" + resultMethodNM + tableId + "_" + dbFlgKbnNm + ".csv";
        File ssFile = new File(config.getScreenshotDir(), fileName);
        if (ssFile.getParentFile() != null) {
            ssFile.getParentFile().mkdirs();
        }

        try (OutputStream out = new FileOutputStream(ssFile)) {

            if (taihiData != null && !taihiData.isEmpty()) {
                tableClass = (Class<Object>) taihiData.get(0).getClass();
                FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.CSV);
                FileDescription<Object, CsvHeadDesc, CsvColumnDesc> fd = generateFileDescription(tableId, tableClass);
                fileEntityManager.write(fd, taihiData, out);
            } else {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"))) {
                    String headDesc = "";
                    FileDescription<Object, CsvHeadDesc, CsvColumnDesc> fd = generateFileDescription(tableId, tableClass);
                    for (CsvColumnDesc column : fd.getColumnDesc()) {
                        headDesc = headDesc + "\"" + column.getLabel() + "\",";
                    }
                    writer.write(headDesc.substring(0, headDesc.length() - 1));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static FileDescription<Object, CsvHeadDesc, CsvColumnDesc> generateFileDescription(String tableId, Class<Object> entityClass) throws Exception {
        CsvHeadDesc chd = new CsvHeadDesc();
        List<CsvColumnDesc> ccdList = Lists.newArrayList();
        Class<?> metaClass = ClassUtils.loadClass("yuyu.def.db.meta.GenQ" + tableId);
        Field[] fs = metaClass.getDeclaredFields();
        for (Field f : fs) {
            if (ExDBField.class.isAssignableFrom(f.getType())) {
                CsvColumnDesc ccd = new CsvColumnDesc(f.getName());
                ccd.setLabel(f.getName());
                ccdList.add(ccd);
            }
        }
        String[] commonColumns = {"kousinsyaId", "kousinTime", "kousinKinou", "version"};
        for (String commonColumn : commonColumns) {
            CsvColumnDesc ccd = new CsvColumnDesc(commonColumn);
            ccd.setLabel(commonColumn);
            ccdList.add(ccd);
        }

        return new FileDescription<>(entityClass, chd, ccdList.toArray(new CsvColumnDesc[ccdList.size()]));
    }

}
