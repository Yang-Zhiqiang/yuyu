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
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getHokenKikan(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getHokenKikan extends AbstractTest{

    private final static String SYONO1 = "11807111118";

    private final static String SYONO2 = "11807111129";

    private final static String SYONO3 = "11807111130";

    private final static String SYONO4 = "11807111141";

    private final static String SYONO5 = "60806000011";

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
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
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
    public void testGetHokenKikan_A1() {
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(SYONO1);

        exClassificationEquals(hokenKikanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHokenKikan_A2() {
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(SYONO2);

        exClassificationEquals(hokenKikanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHokenKikan_A3() {
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(SYONO3);

        exClassificationEquals(hokenKikanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHokenKikan_A4() {
        changeSystemDate(BizDate.valueOf(20200329));
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(SYONO4);

        exClassificationEquals(hokenKikanBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exDateEquals(hokenKikanBean.getHknkknkaisiymd1(),  BizDate.valueOf("20200201") ,  "第１保険期間開始日");
        exDateEquals(hokenKikanBean.getHknkknmanryouymd1(),  BizDate.valueOf("20250131") ,  "第１保険期間満了日");
        exNumericEquals(hokenKikanBean.getDai1hknkkn(),  5 ,  "第１保険期間");
        exDateEquals(hokenKikanBean.getHknkknkaisiymd2(),  BizDate.valueOf("20250201") ,  "第２保険期間開始日");
        exDateEquals(hokenKikanBean.getHknkknmanryouymd2(),  BizDate.valueOf("99991231") ,  "第２保険期間満了日");

    }

    @Test
    @TestOrder(50)
    public void testGetHokenKikan_A5() {
        changeSystemDate(BizDate.valueOf(20200329));
        HokenKikanBean hokenKikanBean = dsGetKeiyakuCommon.getHokenKikan(SYONO5);

        exClassificationEquals(hokenKikanBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exDateEquals(hokenKikanBean.getHknkknmanryouymd1(),  null,  "第１保険期間満了日");
        exDateEquals(hokenKikanBean.getHknkknkaisiymd2(),  null,  "第２保険期間開始日");
        exDateEquals(hokenKikanBean.getHknkknmanryouymd2(),  null,  "第２保険期間満了日");

    }
}
