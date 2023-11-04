package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getKykKihon()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getKykKihon extends AbstractTest{

    private final static String SYONO1 = "11807111118";

    private final static String SYONO2 = "11807111129";

    private final static String SYONO3 = "11807111130";

    private final static String SYONO4 = "11807111141";

    @Inject
    private DsGetKeiyakuCommon dsGetKeiyakuCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ契約共通情報取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getKykKihon.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testGetKykKihon_A1() {
        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(SYONO1);

        exClassificationEquals(keiyakuKihonBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetKykKihon_A2() {
        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(SYONO2);

        exClassificationEquals(keiyakuKihonBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetKykKihon_A3() {
        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(SYONO3);

        exClassificationEquals(keiyakuKihonBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testGetKykKihon_A4() {
        changeSystemDate(BizDate.valueOf(20180314));
        KeiyakuKihonBean keiyakuKihonBean = dsGetKeiyakuCommon.getKykKihon(SYONO4);

        exClassificationEquals(keiyakuKihonBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exClassificationEquals(keiyakuKihonBean.getAisyoumeiKbn(),  C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN ,  "愛称名区分");
        exStringEquals(keiyakuKihonBean.getSyouhnNm(), "商品証券用名００４", "商品名");
        exDateEquals(keiyakuKihonBean.getKykYmd(), BizDate.valueOf("20180208"), "契約日");
        exClassificationEquals(keiyakuKihonBean.getKykTuukasyu(),  C_Tuukasyu.JPY,  "契約通貨種類");
        exDateEquals(keiyakuKihonBean.getSakuseiKijyunYmd(), BizDate.valueOf("20180314"), "作成基準日");
    }
}
