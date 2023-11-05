package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続注意判定メソッド {@link HanteiTetuduki#exec(KhozenCommonParam,String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiTetudukiTest_exec {

    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_手続注意判定";

    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap = null;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(HanteiTetudukiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKhTtdkTyuuikahi());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345959";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345672";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345683";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345694";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345708";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345719";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345720";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345731";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345742";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345753";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者行方不明", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345764";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[代理人による手続不可]が設定されている契約です。", "メッセージパラメータ取得");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345775";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345786";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345797";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345801";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "被保険者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345812";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[契約者意思能力なし]が設定されている契約です。", "メッセージパラメータ取得");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345823";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345834";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345845";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345856";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "保全関係その他", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345867";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[消滅時μ配当調整要]が設定されている契約です。", "メッセージパラメータ取得");

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345878";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345889";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345890";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345904";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "給付金・特定人不担保", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345915";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA , "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[P免非該当]が設定されている契約です。", "メッセージパラメータ取得");

    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345926";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "保険金関係　受取人注意, 生前給付非該当, 消滅時精算, 消滅後応対注意, 苦情経緯あり応対注意", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("HanteiTetuduki");
        String syono = "12806345937";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[育英資金案内注意, 自動送金口座変更案内中, 被保険者属性確認事項あり, 取引時確認留意事項あり, 被保険者からの解除請求あり]が設定されている契約です。", "メッセージパラメータ取得");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345948";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "保険金関係　受取人注意, 消滅時精算, 苦情経緯あり応対注意", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345960";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345971";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者代理人同意要", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345982";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "代理権発動済契約のため、契約者代理人による手続きの場合は事情届兼誓約書等の提出が必要です。<BR>契約者本人から請求を行う場合には意思能力があることの確認が必要です。", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(339)
    @Transactional
    public void testExec_A34_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345959";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。<BR>契約者代理人の同意が必要です。", "メッセージパラメータ取得");
    }


    @Test
    @TestOrder(349)
    @Transactional
    public void testExec_A35_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345694";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345708";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345719";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345720";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345731";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345742";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(409)
    @Transactional
    public void testExec_A41_inData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestOrder(410)
    public void testExec_A41() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345694";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345708";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345719";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345720";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIKANOU, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345731";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.SYORIHUKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "EIA1006", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "契約者に関する捜査照会", "メッセージパラメータ取得");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId("HanteiTetuduki");

        String syono = "12806345742";

        HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
        C_SyorikahiKbn syorikeka = hanteiTetuduki.exec(khozenCommonParam, syono);

        exClassificationEquals(syorikeka, C_SyorikahiKbn.TYUUITRATKIKA, "処理可否結果");
        exStringEquals(hanteiTetuduki.getMessageID(), "WIA1001", "メッセージID取得");
        exStringEquals(hanteiTetuduki.getMessageParam(), "手続注意[破産および倒産]が設定されている契約です。", "メッセージパラメータ取得");
    }

}
