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
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getKykSya()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getKykSya {

    private final static String SYONO1 = "11807111118";

    private final static String SYONO2 = "11807111129";

    private final static String SYONO3 = "11807111233";

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
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getKykSya.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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
    public void testGetKykSya_A1() {
        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(SYONO1);

        exClassificationEquals(keiyakusyaBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetKykSya_A2() {
        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(SYONO2);

        exClassificationEquals(keiyakusyaBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exStringEquals(keiyakusyaBean.getKykNmKn(), "契約者カナ名０１", "契約者名（カナ）");
        exStringEquals(keiyakusyaBean.getKykNmKj(), "契約者カ漢字０１", "契約者名（漢字）");
        exDateEquals(keiyakusyaBean.getKykseiYmd(), BizDate.valueOf("20180208"), "契約者生年月日");
        exClassificationEquals(keiyakusyaBean.getKyksei(), C_Kyksei.MALE, "契約者性別");
    }

    @Test
    @TestOrder(30)
    public void testGetKykSya_A3() {
        KeiyakusyaBean keiyakusyaBean = dsGetKeiyakuCommon.getKykSya(SYONO3);

        exClassificationEquals(keiyakusyaBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }
}
