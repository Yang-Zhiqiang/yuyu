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
import yuyu.def.biz.result.bean.SokujiSikinIdouListSkssBySyoriYmdBean;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSokujiSikinIdouListSkssBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSokujiSikinIdouListSkssBySyoriYmd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSokujiSikinIdouListSkssBySyoriYmd";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        try (ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getSokujiSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160215))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        insertSubData();

    }

    @BeforeClass
    @Transactional()
    public static void insertSubData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getSokujiSikinIdouListSkssBySyoriYmd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getSokujiSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160213))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        try (ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getSokujiSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160215))) {

            int iCount = 0;
            Iterator<SokujiSikinIdouListSkssBySyoriYmdBean> iter = exDBResBean.iterator();
            SokujiSikinIdouListSkssBySyoriYmdBean SBean = null;
            while (iter.hasNext()) {

                SBean = iter.next();
                iCount++;

                Assert.assertEquals(C_Segcd.BLNK, SBean.getSeg1cd());
                Assert.assertEquals(C_Tuukasyu.BLNK, SBean.getKyktuukasyu());
                Assert.assertEquals(BizCurrency.valueOf(101, BizCurrencyTypes.YEN), SBean.getKeiyakutuukagkSum());
                Assert.assertEquals(C_SikinIdouKbn.BLNK, SBean.getSikinidoukbn());
                Assert.assertEquals(C_SikinidougroupKbn.DUMMY, SBean.getSikinidougroupkbn());
                Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, SBean.getSikinidoumeisaikbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<SokujiSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getSokujiSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160220))) {

            int iCount = 0;
            for (SokujiSikinIdouListSkssBySyoriYmdBean entityBean : exDBResBean) {

                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(null, entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());

                }

                if (2 == iCount) {

                    Assert.assertEquals(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(3, BizCurrencyTypes.AU_DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());

                }

                if (3 == iCount) {

                    Assert.assertEquals(C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(14, BizCurrencyTypes.AU_DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.DSKAIYAKU, entityBean.getSikinidoumeisaikbn());
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(17, BizCurrencyTypes.AU_DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (6 == iCount) {

                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.EUR, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(3, BizCurrencyTypes.EURO),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (7 == iCount) {

                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.USD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (8 == iCount) {

                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.USD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(62, BizCurrencyTypes.DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.FB_AZUKARI, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (9 == iCount) {

                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(51, BizCurrencyTypes.AU_DOLLAR),
                        entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.FB_AZUKARI, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.DUMMY, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }
            }

            Assert.assertEquals(9, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SikinIdouListSks> list = bizDomManager.getAllSikinIdouListSks();
        if (list.size() > 0) {
            bizDomManager.delete(list);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
