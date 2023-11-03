package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金商品項目編集ユーティリティのメソッド
 * {@link EditNenkinKoumokuUtil#getSkNkgnsKijyunGk(BM_SyouhnZokusei, HT_MosKihon, HT_MosSyouhn)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class EditNenkinKoumokuUtilTest_getSkNkgnsKijyunGk {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_年金商品項目編集ユーティリティ";

    private final static String sheetName = "INデータ";

    @Inject
    private EditNenkinKoumokuUtil editNenkinKoumokuUtil;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditNenkinKoumokuUtilTest_getSkNkgnsKijyunGk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testGetSkNkgnsKijyunGk_A1() {
        BM_SyouhnZokusei syouhnZokusei = null;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000017");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
    }

    @Test
    @TestOrder(20)
    public void testGetSkNkgnsKijyunGk_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 2);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000025");
        HT_MosKihon mosKihon = null;
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
    }

    @Test
    @TestOrder(30)
    public void testGetSkNkgnsKijyunGk_A3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 3);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000033");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = null;
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
    }

    @Test()
    @TestOrder(40)
    public void testGetSkNkgnsKijyunGk_A4() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000041");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), "年金原資基準額");
    }

    @Test()
    @TestOrder(50)
    public void testGetSkNkgnsKijyunGk_A5() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 5);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000058");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "年金原資基準額");
    }

    @Test()
    @TestOrder(60)
    public void testGetSkNkgnsKijyunGk_A6() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｳ1", 6);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000066");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "新契約年金原資基準額");
    }

    @Test()
    @TestOrder(70)
    public void testGetSkNkgnsKijyunGk_A7() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾁ", 0);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000074");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "年金原資基準額");
    }

    @Test()
    @TestOrder(80)
    public void testGetSkNkgnsKijyunGk_A8() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 0);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000082");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資基準額");

    }

    @Test()
    @TestOrder(90)
    public void testGetSkNkgnsKijyunGk_A9() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000090");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "年金原資基準額");

    }

    @Test()
    @TestOrder(100)
    public void testGetSkNkgnsKijyunGk_A10() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000108");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR), "年金原資基準額");

    }

    @Test()
    @TestOrder(110)
    public void testGetSkNkgnsKijyunGk_A11() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000116");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "年金原資基準額");
    }

    @Test()
    @TestOrder(120)
    public void testGetSkNkgnsKijyunGk_A12() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000124");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR), "年金原資基準額");
    }

    @Test()
    @TestOrder(130)
    public void testGetSkNkgnsKijyunGk_A13() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾏ", 4);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("791112220");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = syoriCTL.getMosSyouhns().get(0);
        BizCurrency skNKgensiKijyunG = editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
        BizCurrency NKgensiKijyunG = editNenkinKoumokuUtil.getNkgnsKijyunGk();

        exBizCalcbleEquals(skNKgensiKijyunG, BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), "新契約年金原資基準額");
        exBizCalcbleEquals(NKgensiKijyunG, BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), "年金原資基準額");
    }
}

