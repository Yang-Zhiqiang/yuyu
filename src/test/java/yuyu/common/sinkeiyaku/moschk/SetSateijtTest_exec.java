package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定状態設定クラスのメソッド {@link SetSateijt#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSateijtTest_exec {

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000025";

    private final static String mosNo3 = "860000033";

    private final static String mosNo4 = "860000041";

    private final static String mosNo5 = "860000058";

    private final static String mosNo6 = "860000066";

    private final static String mosNo7 = "860000074";

    private final static String mosNo8 = "860000082";

    private final static String mosNo9 = "860000090";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SetSateijt setSateijt;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_査定状態設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSateijtTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_TYUU, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), null, "査定済日");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150601), "査定済日");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_TYUU, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150601), "査定済日");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.TKJYSYDK_MATI, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150601), "査定済日");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150609), "査定済日");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_SUMI, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150609), "査定済日");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_TYUU, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150601), "査定済日");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_TYUU, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), BizDate.valueOf(20150601), "査定済日");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150609));

        setSateijt.exec(mosnaiCheckParam);

        syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        exClassificationEquals(syoriCTL.getSateijtkbn(), C_SateijtKbn.SATEI_TYUU, "査定状態区分");
        exDateEquals(syoriCTL.getSateizumiymd(), null, "査定済日");
    }
}
