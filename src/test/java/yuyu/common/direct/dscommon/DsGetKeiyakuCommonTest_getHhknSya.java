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
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getHhknSya()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getHhknSya {

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
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getHhknSya.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    public void testGetHhknSya_A1() {
        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(SYONO1);

        exClassificationEquals(hihokensyaBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHhknSya_A2() {
        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(SYONO2);

        exClassificationEquals(hihokensyaBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exStringEquals(hihokensyaBean.getHhknNmKn(), "被保険者カナ名０１", "被保険者名（カナ）");
        exDateEquals(hihokensyaBean.getHhknseiYmd(), BizDate.valueOf("20180208"), "被保険者生年月日");
    }
    @Test
    @TestOrder(30)
    public void testGetHhknSya_A3() {
        HihokensyaBean hihokensyaBean = dsGetKeiyakuCommon.getHhknSya(SYONO3);

        exClassificationEquals(hihokensyaBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }
}
