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
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保全契約異動状態取得のメソッド{@link HozenKeiyakuIdouJyoutaiSyutoku#keiyakuJyoutaiYuukouseiHantei(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HozenKeiyakuIdouJyoutaiSyutokuTest_keiyakuJyoutaiYuukouseiHantei {

    @Inject
    private HozenKeiyakuIdouJyoutaiSyutoku idouJyoutaiSyutoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保全契約異動状態取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                HozenKeiyakuIdouJyoutaiSyutokuTest_keiyakuJyoutaiYuukouseiHantei.class, fileName, sheetName);
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
    public void testKeiyakuJyoutaiYuukouseiHantei_A1() {
        String pSyoNo = "31809111327";

        idouJyoutaiSyutoku.setDetachYouhiKbn(C_YouhiKbn.HUYOU);

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
    }

    @Test
    @TestOrder(20)
    public void testKeiyakuJyoutaiYuukouseiHantei_A2() {
        String pSyoNo = "17806000013";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.ERROR, "有効性区分");
    }

    @Test
    @TestOrder(30)
    public void testKeiyakuJyoutaiYuukouseiHantei_A3() {
        String pSyoNo = "17806000024";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.OK, "有効性区分");
    }

    @Test
    @TestOrder(40)
    public void testKeiyakuJyoutaiYuukouseiHantei_A4() {
        String pSyoNo = "17806000035";

        C_YuukshantkekKbn yuukshantkekKbn = idouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(pSyoNo);

        exClassificationEquals(yuukshantkekKbn, C_YuukshantkekKbn.NG, "有効性区分");
    }
}