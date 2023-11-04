package yuyu.common.hozen.khcommon;

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
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通算用金額取得クラスのメソッド {@link GetKhTuusanyouKngk#getTsnyennyknkgk(
 * BM_SyouhnZokusei, IT_NyknJissekiRireki, IT_KykSonotaTkyk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetKhTuusanyouKngkTest_getTsnyouYennyknkgk {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_通算用金額取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetKhTuusanyouKngkTest_getTsnyouYennyknkgk.class,
                fileName, sheetName);
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

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(60)
    public void testGetTsnyouYennyknkgk_A1() {

        BM_SyouhnZokusei psyouhnZokusei = null;
        IT_NyknJissekiRireki pNyknJissekiRireki = null;
        IT_KykSonotaTkyk   pKykSonotaTkyk = null;
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(70)
    public void testGetTsnyouYennyknkgk_A2() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki = null;
        IT_KykSonotaTkyk   pKykSonotaTkyk = null;
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(80)
    public void testGetTsnyouYennyknkgk_A3() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk   pKykSonotaTkyk = null;
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(90)
    public void testGetTsnyouYennyknkgk_A4() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000011").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(100)
    public void testGetTsnyouYennyknkgk_A5() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000011").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(110)
    public void testGetTsnyouYennyknkgk_A6() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000022").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(120)
    public void testGetTsnyouYennyknkgk_A7() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾂ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000011").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(130)
    public void testGetTsnyouYennyknkgk_A8() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｲ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000011",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000011").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

    @Test
    @TestOrder(140)
    public void testGetTsnyouYennyknkgk_A9() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 2);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000033",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000033").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR), "通算用円入金額");

    }

    @Test
    @TestOrder(150)
    public void testGetTsnyouYennyknkgk_A10() {

        BM_SyouhnZokusei psyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｺ", 1);
        IT_NyknJissekiRireki pNyknJissekiRireki =
            hozenDomManager.getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000044",
                C_Nyktrksflg.BLNK).get(0);
        IT_KykSonotaTkyk  pKykSonotaTkyk = hozenDomManager.getKykKihon("60806000044").getKykSonotaTkyk();
        GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);
        BizCurrency tsnyennyknkgk = getKhTuusanyouKngk.getTsnyouYennyknkgk(psyouhnZokusei, pNyknJissekiRireki,
            pKykSonotaTkyk);

        exBizCalcbleEquals(tsnyennyknkgk, BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "通算用円入金額");

    }

}
