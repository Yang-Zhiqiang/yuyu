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
import yuyu.def.biz.result.bean.TyakkinSikinIdouListSkssBySyoriYmdBean;
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
 * getTyakkinSikinIdouListSkssBySyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTyakkinSikinIdouListSkssBySyoriYmd {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getTyakkinSikinIdouListSkssBySyoriYmd";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        try(ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getTyakkinSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160215))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional()
    public static void insertSubData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getTyakkinSikinIdouListSkssBySyoriYmd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getTyakkinSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160213))) {

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        try(ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getTyakkinSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160215))) {

            int iCount = 0;
            Iterator<TyakkinSikinIdouListSkssBySyoriYmdBean> iter = exDBResBean.iterator();
            TyakkinSikinIdouListSkssBySyoriYmdBean tKTBSDbean = null;
            while (iter.hasNext()) {

                tKTBSDbean = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf(20160315), tKTBSDbean.getTyakkinymd());
                Assert.assertEquals(C_Segcd.BLNK, tKTBSDbean.getSeg1cd());
                Assert.assertEquals(C_Tuukasyu.JPY, tKTBSDbean.getKyktuukasyu());
                Assert.assertEquals(BizCurrency.valueOf(101, BizCurrencyTypes.YEN), tKTBSDbean.getKeiyakutuukagkSum());
                Assert.assertEquals(C_SikinIdouKbn.BLNK, tKTBSDbean.getSikinidoukbn());
                Assert.assertEquals(C_SikinidougroupKbn.BLNK, tKTBSDbean.getSikinidougroupkbn());
                Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, tKTBSDbean.getSikinidoumeisaikbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<TyakkinSikinIdouListSkssBySyoriYmdBean> exDBResBean = bizDomManager.
            getTyakkinSikinIdouListSkssBySyoriYmd(BizDate.valueOf(20160220))) {

            int iCount = 0;
            for (TyakkinSikinIdouListSkssBySyoriYmdBean entityBean : exDBResBean) {

                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.BLNK, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(33, BizCurrencyTypes.AU_DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (2 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.BLNK, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(24, BizCurrencyTypes.AU_DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.DSKAIYAKU, entityBean.getSikinidoumeisaikbn());
                }

                if (3 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(15, BizCurrencyTypes.AU_DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (4 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(6, BizCurrencyTypes.AU_DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (5 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.JPY, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(70, BizCurrencyTypes.YEN), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (6 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.USD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(3.1, BizCurrencyTypes.DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (7 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(null, entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.DUMMY, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (8 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160320), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.AUD, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(3, BizCurrencyTypes.AU_DOLLAR), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.DUMMY, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (9 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160321), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.JPY, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(17, BizCurrencyTypes.YEN), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (10 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160322), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.JPY, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(15, BizCurrencyTypes.YEN), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.BLNK, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }

                if (11 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160322), entityBean.getTyakkinymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, entityBean.getSeg1cd());
                    Assert.assertEquals(C_Tuukasyu.JPY, entityBean.getKyktuukasyu());
                    Assert.assertEquals(BizCurrency.valueOf(3, BizCurrencyTypes.YEN), entityBean.getKeiyakutuukagkSum());
                    Assert.assertEquals(C_SikinIdouKbn.FB_AZUKARI, entityBean.getSikinidoukbn());
                    Assert.assertEquals(C_SikinidougroupKbn.BLNK, entityBean.getSikinidougroupkbn());
                    Assert.assertEquals(C_SikinidoumeisaiKbn.BLNK, entityBean.getSikinidoumeisaikbn());
                }


            }
            Assert.assertEquals(11, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SikinIdouListSks> list = bizDomManager.getAllSikinIdouListSks();
        if(list.size() > 0){
            bizDomManager.delete(list);
        }

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        deleteTestSubData();
    }

}