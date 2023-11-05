package yuyu.def.db.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SumNyknJissekiRirekiBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金実績履歴合計Bean取得(入金取消フラグ)<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getSumNyknJissekiRirekiBeanByNyktrksflgNe {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getSumNyknJissekiRirekiBeanByNyktrksflgNe";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10806000016");

        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("01", "10806000016");
            SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean = kykKihon1.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.TORIKESI);
            Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumHrkp().size());
            Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().size());
            Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumRsgaku().size());

            insertTestData();
        }
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_KykKihonTest_getSumNyknJissekiRirekiBeanByNyktrksflgNe.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000038");
        SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean = kykKihon.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.TORIKESI);
        Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumHrkp().size());
        Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().size());
        Assert.assertEquals(0, sumNyknJissekiRirekiBean.getSumRsgaku().size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000027");
        SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean = kykKihon.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.BLNK);

        Assert.assertEquals(1, sumNyknJissekiRirekiBean.getSumHrkp().size());
        Assert.assertEquals(BizCurrency.valueOf(20), sumNyknJissekiRirekiBean.getSumHrkp().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().size());
        Assert.assertEquals(BizCurrency.valueOf(40), sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(1, sumNyknJissekiRirekiBean.getSumRsgaku().size());
        Assert.assertEquals(BizCurrency.valueOf(30), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.YEN));

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10806000016");
        SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean = kykKihon.getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg.TORIKESI);

        Assert.assertEquals(3, sumNyknJissekiRirekiBean.getSumHrkp().size());
        Assert.assertEquals(BizCurrency.valueOf(56), sumNyknJissekiRirekiBean.getSumHrkp().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(14,BizCurrencyTypes.MANYEN), sumNyknJissekiRirekiBean.getSumHrkp().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(15,BizCurrencyTypes.DOLLAR), sumNyknJissekiRirekiBean.getSumHrkp().get(BizCurrencyTypes.DOLLAR));

        Assert.assertEquals(3, sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().size());
        Assert.assertEquals(BizCurrency.valueOf(105), sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(37,BizCurrencyTypes.MANYEN), sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(38,BizCurrencyTypes.DOLLAR), sumNyknJissekiRirekiBean.getSumYenkansannyknkingk().get(BizCurrencyTypes.DOLLAR));

        Assert.assertEquals(5, sumNyknJissekiRirekiBean.getSumRsgaku().size());
        Assert.assertEquals(BizCurrency.valueOf(9), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.YEN));
        Assert.assertEquals(BizCurrency.valueOf(100,BizCurrencyTypes.MANYEN), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.MANYEN));
        Assert.assertEquals(BizCurrency.valueOf(42,BizCurrencyTypes.DOLLAR), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(25,BizCurrencyTypes.AU_DOLLAR), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.AU_DOLLAR));
        Assert.assertEquals(BizCurrency.valueOf(11,BizCurrencyTypes.EURO), sumNyknJissekiRirekiBean.getSumRsgaku().get(BizCurrencyTypes.EURO));
    }

    @Transactional
    public static void deleteTestSubData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
