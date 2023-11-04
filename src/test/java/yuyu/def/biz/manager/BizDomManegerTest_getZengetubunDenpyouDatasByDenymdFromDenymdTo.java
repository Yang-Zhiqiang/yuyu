package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.result.bean.ZengetubunDenpyouDatasByDenymdFromDenymdToBean;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getZengetubunDenpyouDatasByDenymdFromDenymdTo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManegerTest_getZengetubunDenpyouDatasByDenymdFromDenymdTo {

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getZengetubunDenpyouDatasByDenymdFromDenymdTo";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> beans =
            bizDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate.valueOf(20160514), BizDate.valueOf(20160516))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManegerTest_getZengetubunDenpyouDatasByDenymdFromDenymdTo.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());
        bizDomManager.delete(bizDomManager.getAllKanjyouKamoku());
        bizDomManager.delete(bizDomManager.getAllSyoritanto());
        bizDomManager.delete(bizDomManager.getAllTantouCd());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> beans =
            bizDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate.valueOf(20160518), BizDate.valueOf(20160519))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> exDBResults =
            bizDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate.valueOf(20160514), BizDate.valueOf(20160516))) {

            Iterator<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> iter = exDBResults.iterator();
            ZengetubunDenpyouDatasByDenymdFromDenymdToBean beans = null;
            int iCount = 0;
            while (iter.hasNext()) {

                iCount++;
                beans = iter.next();
                if (1 == iCount) {
                    Assert.assertEquals("101", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160515), beans.getDenymd());
                    Assert.assertEquals("1001", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("101", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(100, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }
                Assert.assertEquals(1, iCount);
            }
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> exDBResults =
            bizDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(BizDate.valueOf(20160615), BizDate.valueOf(20160617))) {

            Iterator<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> iter = exDBResults.iterator();
            ZengetubunDenpyouDatasByDenymdFromDenymdToBean beans = null;
            int iCount = 0;
            while (iter.hasNext()) {

                iCount++;
                beans = iter.next();

                if (1 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("100", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (2 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (3 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("300", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (4 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1003", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("103", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (5 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1002", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("104", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(221, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (6 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160616), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(221, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(0, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (7 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160617), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (8 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (9 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }

                if (10 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000002", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160617), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }
                if (11 == iCount) {
                    Assert.assertEquals("102", beans.getHjybtantositucd());
                    Assert.assertEquals("9000003", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }
                if (12 == iCount) {
                    Assert.assertEquals("103", beans.getHjybtantositucd());
                    Assert.assertEquals("9000002", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }
                if (13 == iCount) {
                    Assert.assertEquals("104", beans.getHjybtantositucd());
                    Assert.assertEquals("9000001", beans.getSyorisosikicd());
                    Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, beans.getKanjyoukmkcd());
                    Assert.assertEquals(BizDate.valueOf(20160615), beans.getDenymd());
                    Assert.assertEquals("1004", beans.getSyoricd());
                    Assert.assertEquals("200", beans.getHuridenatesakicd());
                    Assert.assertEquals("102", beans.getBusitucd());
                    Assert.assertEquals(BizCurrency.valueOf(111, BizCurrencyTypes.YEN), beans.getKarikatagk());
                    Assert.assertEquals(BizCurrency.valueOf(110, BizCurrencyTypes.YEN), beans.getKasikatagk());
                }
            }
            Assert.assertEquals(13, iCount);
        }
    }
}