package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 給付日額設定クラスのメソッド {@link SetKyuuhuNitigaku#exec(List<HT_MosSyouhn>，List<HT_MosSyouhn>)} テスト用クラスです。<br/>
 */
@RunWith(SWAKTestRunner.class)
public class SetKyuuhuNitigakuTest_exec {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SetKyuuhuNitigaku setKyuuhuNitigaku;

    private final static String fileName = "UT_SP_単体テスト仕様書_給付日額設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetKyuuhuNitigakuTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0), "疾病入院通算日額３");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0), "疾病入院通算日額３");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0), "疾病入院通算日額３");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0), "疾病入院通算日額３");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "疾病入院通算日額３");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        List<HT_MosSyouhn> mosSyouhn1 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<HT_MosSyouhn> mosSyouhn2 = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        setKyuuhuNitigaku.exec(mosSyouhn1, mosSyouhn2);

        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk1(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "疾病入院通算日額１");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk2(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "疾病入院通算日額２");
        exBizCalcbleEquals(setKyuuhuNitigaku.getSipnyutsnntgk3(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "疾病入院通算日額３");
    }

}