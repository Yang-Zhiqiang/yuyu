package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ採番処理クラスのメソッド {@link DsSaibanSyori#saibanRealTimeMailDsSousinNoRenban()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsSaibanSyoriTest_saibanRealTimeMailDsSousinNoRenban {

    @Inject
    private DsSaibanSyori dsSaibanSyori;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ採番処理";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsSaibanSyoriTest_saibanRealTimeMailDsSousinNoRenban.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ011", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(110)
    public void testRealTimeMailSaibanDsSousinNoRenban_A1() {

        String pKey = "2018050110200";

        String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);

        exStringEquals(result, "00000001", "ＤＳ送信番号連番");
    }

    @Test
    @TestOrder(120)
    public void testRealTimeMailSaibanDsSousinNoRenban_A2() {

        String pKey = "2018050110300";

        String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);

        exStringEquals(result, "00000001", "ＤＳ送信番号連番");
    }

    @Test
    @TestOrder(130)
    public void testRealTimeMailSaibanDsSousinNoRenban_A3() {

        String pKey = "2018050210200";

        String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);

        exStringEquals(result, "00000001", "ＤＳ送信番号連番");
    }

    @Test
    @TestOrder(140)
    public void testRealTimeMailSaibanDsSousinNoRenban_A4() {

        String pKey = "2018050210300";

        String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);

        exStringEquals(result, "00000001", "ＤＳ送信番号連番");
    }

    @Test
    @TestOrder(150)
    public void testRealTimeMailSaibanDsSousinNoRenban_A5() {

        String pKey = "2018050110200";

        String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);

        exStringEquals(result, "00000002", "ＤＳ送信番号連番");
    }

    @Test
    @TestOrder(160)
    public void testRealTimeMailSaibanDsSousinNoRenban_A6() {

        String pKey = "2018050310200";
        String message = "";
        try {
            String result = dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);
        } catch (Exception e) {
            message = e.getMessage();
        }

        exStringEquals(message, "error while updating sequenceValue[id = 22, keys = 2018050310200].", "例外メッセージ");
    }

    @Test
    @TestOrder(210)
    public void testRealTimeMailSaibanDsSousinNoRenban_B1() {

        String pKey = null;
        String className = "";
        try {
            dsSaibanSyori.saibanRealTimeMailDsSousinNoRenban(pKey);
        } catch (NullPointerException npe) {
            className = npe.getClass().getName();
        }
        exStringEquals(className, "java.lang.NullPointerException", "例外のクラス名");
    }
}
