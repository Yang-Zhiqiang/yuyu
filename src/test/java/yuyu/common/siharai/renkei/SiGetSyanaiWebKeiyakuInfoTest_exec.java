package yuyu.common.siharai.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.siharai.renkei.SiGetSyanaiWebKeiyakuInfo;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 社内Web用保険金契約内容情報取得のメソッド{@link SiGetSyanaiWebKeiyakuInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiGetSyanaiWebKeiyakuInfoTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_社内Web用保険金契約内容情報取得";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
            siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiGetSyanaiWebKeiyakuInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("99806003296");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("99806035873");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("99806003687");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("99806002088");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "20200707", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(50)
    public void testExec_B1() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("99806036036");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.EXCEPTION, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(60)
    public void testExec_C1() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec(null);

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }

    @Test
    @TestOrder(70)
    public void testExec_C2() {

        SiGetSyanaiWebKeiyakuInfo siGetSyanaiWebKeiyakuInfo = SWAKInjector.getInstance(SiGetSyanaiWebKeiyakuInfo.class);
        C_IwssnKykSyoukaiKekkaKbn kekka = siGetSyanaiWebKeiyakuInfo.exec("");

        exClassificationEquals(kekka, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");
        exStringEquals(siGetSyanaiWebKeiyakuInfo.getIwssnSyanaiSiharaiInfoOutputBean().getIwssnSiboushryymd(),
            "00000000", "（ＩＷＳＳＮ）死亡による支払日");
    }
}
