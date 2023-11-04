package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 普通死亡Ｓ設定クラスのメソッド {@link SetHutuuSibouS#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHutuuSibouSTest_exec {

    @Inject
    private SetHutuuSibouS setHutuuSibouS;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String mosNo1 = "791112220";
    private final static String mosNo2 = "791112238";
    private final static String mosNo3 = "791112246";
    private final static String mosNo4 = "791112253";
    private final static String mosNo5 = "791112261";
    private final static String mosNo6 = "791112279";
    private final static String mosNo7 = "791112287";
    private final static String mosNo8 = "860000017";
    private final static String mosNo9 = "860000025";
    private final static String mosNo10 = "860000033";

    private final static String fileName = "UT_SP_単体テスト仕様書_普通死亡Ｓ設定";

    private final static String sheetName = "INデータ_20170727";


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHutuuSibouSTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB01", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB02", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB03", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB04", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB05", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB06", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB07", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB08", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB09", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB10", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB11", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB12", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB13", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB14", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("AB15", 1));
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        pMp.setDataSyoriControl(syoriCTL);

        try {
            setHutuuSibouS.exec(pMp);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        pMp.setDataSyoriControl(syoriCTL);

        try {
            setHutuuSibouS.exec(pMp);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112238", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(40000), "普通死亡Ｓ");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(0), "普通死亡Ｓ");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(275000), "普通死亡Ｓ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(90000, BizCurrencyTypes.DOLLAR), "普通死亡Ｓ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(100000, BizCurrencyTypes.AU_DOLLAR), "普通死亡Ｓ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(20000, BizCurrencyTypes.YEN), "普通死亡Ｓ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(35000, BizCurrencyTypes.YEN), "普通死亡Ｓ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MosnaiCheckParam pMp = new MosnaiCheckParam();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        pMp.setDataSyoriControl(syoriCTL);
        BizCurrency result = setHutuuSibouS.exec(pMp);
        exBizCalcbleEquals(result, BizCurrency.valueOf(160000, BizCurrencyTypes.YEN), "普通死亡Ｓ");
    }
}
