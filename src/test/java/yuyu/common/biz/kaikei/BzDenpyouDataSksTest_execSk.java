package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 伝票データ作成クラスのメソッド {@link BzDenpyouDataSks#execSk(BzSinkeiyakuDenpyouDataTourokuBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzDenpyouDataSksTest_execSk extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_伝票データ作成";
    private final static String sheetName = "INデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(BzDenpyouDataSksTest_execSk.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager3 = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager3.delete(bizDomManager3.getAllKanjyouKamoku());
        testDataAndTblMap = null;
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExecSk_A1() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111185");
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111185", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExecSk_A2() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111186");
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(40000));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111186", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExecSk_A3() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111187");
            bean.setIbTuukasyu(C_Tuukasyu.USD);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);
            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111187", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExecSk_A4() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111188");
            bean.setIbTuukasyu(C_Tuukasyu.USD);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111188", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExecSk_A5() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111189");
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20001));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            BzSiwakeMeisaiBean siwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean3.setIbSuitoubumoncd("1");
            siwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(20002));
            siwakeMeisaiBean3.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean3.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean3);

            BzSiwakeMeisaiBean siwakeMeisaiBean4 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean4.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean4.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean4.setIbSuitoubumoncd("1");
            siwakeMeisaiBean4.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean4.setIbDenyenkagk(BizCurrency.valueOf(20001));
            siwakeMeisaiBean4.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean4.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean4);

            BzSiwakeMeisaiBean siwakeMeisaiBean5 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean5.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean5.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean5.setIbSuitoubumoncd("1");
            siwakeMeisaiBean5.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean5.setIbDenyenkagk(BizCurrency.valueOf(20004));
            siwakeMeisaiBean5.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean5.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean5);

            BzSiwakeMeisaiBean siwakeMeisaiBean6 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean6.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean6.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean6.setIbSuitoubumoncd("1");
            siwakeMeisaiBean6.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean6.setIbDenyenkagk(BizCurrency.valueOf(20005));
            siwakeMeisaiBean6.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean6.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean6);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111189", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExecSk_A6() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111190");
            bean.setIbTuukasyu(C_Tuukasyu.USD);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20001, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            BzSiwakeMeisaiBean siwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean3.setIbSuitoubumoncd("1");
            siwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(20002, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean3.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean3.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean3);

            BzSiwakeMeisaiBean siwakeMeisaiBean4 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean4.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean4.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean4.setIbSuitoubumoncd("1");
            siwakeMeisaiBean4.setIbDengaikagk(BizCurrency.valueOf(20003, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean4.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean4.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean4.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean4);

            BzSiwakeMeisaiBean siwakeMeisaiBean5 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean5.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean5.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean5.setIbSuitoubumoncd("1");
            siwakeMeisaiBean5.setIbDengaikagk(BizCurrency.valueOf(20004, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean5.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean5.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean5.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean5);

            BzSiwakeMeisaiBean siwakeMeisaiBean6 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean6.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean6.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean6.setIbSuitoubumoncd("1");
            siwakeMeisaiBean6.setIbDengaikagk(BizCurrency.valueOf(40000, BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean6.setIbDenyenkagk(BizCurrency.valueOf(0));
            siwakeMeisaiBean6.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean6.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean6);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111190", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(70)
    public void testExecSk_B1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111200");
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);
        bean.setIbKakokawaserateshiteiflg(false);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 0, "件数");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(80)
    public void testExecSk_B2() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111211", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(90)
    public void testExecSk_B3() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111222");
        bean.setIbMosno("11807111277");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("RA43");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.EUR);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setIbSyouhnsdno(2);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111222", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111277", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "30000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.EUR, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "56500", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 2, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111222", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111277", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.EUR, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "56500", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 2, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 2, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(100)
    public void testExecSk_B4() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111233");
        bean.setIbMosno("11807111244");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000001");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111233", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111244", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "0", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExecSk_B5() {
        changeSystemDate(BizDate.valueOf("20160308"));

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111244");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.EUR);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000001");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000001");
        bean.setIbAatkisyadaibosyuucd("000001");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000001");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.EURO));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.EURO));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111244", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "30000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111244", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExecSk_B6() {
        changeSystemDate(BizDate.valueOf("20160308"));

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111255");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("RA43");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000001");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000001");
        bean.setIbAatkisyadaibosyuucd("000001");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000001");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        BzSiwakeMeisaiBean siwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        siwakeMeisaiBean3.setIbSuitoubumoncd("1");
        siwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean3.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(2002));
        siwakeMeisaiBeans.add(siwakeMeisaiBean3);

        BzSiwakeMeisaiBean siwakeMeisaiBean4 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean4.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean4.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN);
        siwakeMeisaiBean4.setIbSuitoubumoncd("1");
        siwakeMeisaiBean4.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean4.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean4.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean4.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean4.setIbKeiyakutuukagk(BizCurrency.valueOf(2003));
        siwakeMeisaiBeans.add(siwakeMeisaiBean4);

        BzSiwakeMeisaiBean siwakeMeisaiBean5 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean5.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean5.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        siwakeMeisaiBean5.setIbSuitoubumoncd("1");
        siwakeMeisaiBean5.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean5.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean5.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean5.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean5.setIbKeiyakutuukagk(BizCurrency.valueOf(2004));
        siwakeMeisaiBeans.add(siwakeMeisaiBean5);

        BzSiwakeMeisaiBean siwakeMeisaiBean6 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean6.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean6.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean6.setIbSuitoubumoncd("1");
        siwakeMeisaiBean6.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean6.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean6.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean6.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean6.setIbKeiyakutuukagk(BizCurrency.valueOf(2005));
        siwakeMeisaiBeans.add(siwakeMeisaiBean6);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 6, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(2).getEdano(), 3, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(2).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(2).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(2).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(2).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(2).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(2).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(2).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(2).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(2).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(2).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(2).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(2).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(2).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(2).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(2).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(2).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(2).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(2).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(2).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(2).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(2).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(2).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(2).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(2).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(2).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(2).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(2).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(2).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(2).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(2).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(2).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(2).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(2).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(2).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(2).getKeiyakutuukagk().toString(), "2002", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(2).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(2).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(2).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(2).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(3).getEdano(), 4, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(3).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(3).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(3).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(3).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(3).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(3).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(3).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(3).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(3).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(3).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(3).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(3).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(3).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(3).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(3).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(3).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(3).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(3).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(3).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(3).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(3).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(3).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(3).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(3).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(3).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(3).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(3).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(3).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(3).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(3).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(3).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(3).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(3).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(3).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(3).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(3).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(3).getKeiyakutuukagk().toString(), "2003", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(3).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(3).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(3).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(3).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(4).getEdano(), 5, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(4).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(4).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(4).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(4).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(4).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(4).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(4).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(4).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(4).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(4).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(4).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(4).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(4).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(4).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(4).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(4).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(4).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(4).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(4).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(4).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(4).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(4).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(4).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(4).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(4).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(4).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(4).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(4).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(4).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(4).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(4).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(4).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(4).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(4).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(4).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(4).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(4).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(4).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(4).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(4).getKeiyakutuukagk().toString(), "2004", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(4).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(4).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(4).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(4).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(5).getEdano(), 6, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(5).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(5).getSyono(), "11807111255", "証券番号");
        exStringEquals(skDenpyoDatas.get(5).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(5).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(5).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(5).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(5).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(5).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(5).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(5).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(5).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(5).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(5).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(5).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(5).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(5).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(5).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(5).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(5).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(5).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(5).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(5).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(5).getAatsukaishasuitososhikicd(), "0000001", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(5).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(5).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(5).getAatsukaishasoshikicd(), "0000001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(5).getAatkisyadaibosyuucd(), "000001", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(5).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(5).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(5).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(5).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(5).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(5).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(5).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(5).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(5).getAatkisyabosyuucd(), "000001", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(5).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(5).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(5).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(5).getKeiyakutuukagk().toString(), "2005", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(5).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(5).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(5).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(5).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 4, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(130)
    public void testExecSk_B7() {
        changeSystemDate(BizDate.valueOf("20160308"));

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111266");
        bean.setIbMosno("11807111277");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.AUD);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.AU_DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000, BizCurrencyTypes.AU_DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111266", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111277", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "30000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111266", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111277", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(140)
    public void testExecSk_B8() {
        changeSystemDate(BizDate.valueOf("20160308"));

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111277");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "30000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(150)
    public void testExecSk_B9() {
        changeSystemDate(BizDate.valueOf("20160308"));

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111277");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "30000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(160)
    public void testExecSk_B10() {
        changeSystemDate(BizDate.valueOf("20160308"));

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111277");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("RA43");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN );
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 1, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(170)
    public void testExecSk_B11() {
        changeSystemDate(BizDate.valueOf("20160308"));

        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111277");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("RA43");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN );
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO );
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 2, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111277", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "20000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(1).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(1).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(1).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(1).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(1).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(1).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(1).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(1).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(1).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(1).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "5650", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 1, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(180)
    public void testExecSk_C1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("20161009"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111211", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("20161009"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(190)
    public void testExecSk_C2() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(true);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850123"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111211", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850123"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(200)
    public void testExecSk_C3() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbMosno("11807111266");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        bean.setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        bean.setIbTekiyoukbn(C_TekiyouKbn.BLNK);
        bean.setIbDensyorikbn(C_DensyoriKbn.BLNK);
        bean.setIbAatsukaishasuitososhikicd("0000002");
        bean.setIbKykymd(BizDate.valueOf("19850101"));
        bean.setIbBosyuuym(BizDateYM.valueOf("198502"));
        bean.setIbAatsukaishasoshikicd("0000003");
        bean.setIbAatkisyadaibosyuucd("000002");
        bean.setIbSyusyouhncd("0001");
        bean.setIbSdpdkbn(C_Sdpd.BLNK);
        bean.setIbHrkkaisuu(C_Hrkkaisuu.BLNK);
        bean.setIbHrkkeiro(C_Hrkkeiro.BLNK);
        bean.setIbSknnkaisiymd(BizDate.valueOf("20150103"));
        bean.setIbMosymd(BizDate.valueOf("20150104"));
        bean.setIbHnknriyuukbn(C_HenkinriyuuKbn.BLNK);
        bean.setIbFstpryosyuymd(BizDate.valueOf("20150105"));
        bean.setIbAatkisyabosyuucd("000003");
        bean.setIbRyouritusdno("001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(true);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("20161009"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111211", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getMosno(), "11807111266", "申込番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(skDenpyoDatas.get(0).getKessantyouseikbn(), C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(skDenpyoDatas.get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK, "内部契約区分");
        exClassificationEquals(skDenpyoDatas.get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorikbn(), C_DensyoriKbn.BLNK, "伝票処理区分");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasuitososhikicd(), "0000002", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoDatas.get(0).getKykymd(), BizDate.valueOf("19850101"), "契約日");
        exDateYMEquals(skDenpyoDatas.get(0).getBosyuuym(), BizDateYM.valueOf("198502"), "募集年月");
        exStringEquals(skDenpyoDatas.get(0).getAatsukaishasoshikicd(), "0000003", "Ａ扱者組織コード");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyadaibosyuucd(), "000002", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(skDenpyoDatas.get(0).getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoDatas.get(0).getSknnkaisiymd(), BizDate.valueOf("20150103"), "責任開始日");
        exDateEquals(skDenpyoDatas.get(0).getMosymd(), BizDate.valueOf("20150104"), "申込日");
        exClassificationEquals(skDenpyoDatas.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoDatas.get(0).getFstpryosyuymd(), BizDate.valueOf("20150105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoDatas.get(0).getAatkisyabosyuucd(), "000003", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoDatas.get(0).getRyouritusdno(), "001", "料率世代番号");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("20161011"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(210)
    public void testExecSk_D1() {
        changeSystemDate(BizDate.valueOf("20190325"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20190325"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
        siwakeMeisaiBean0.setIbDenkarikanjyono("12345");
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        siwakeMeisaiBean2.setIbDenkarikanjyono(null);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exStringEquals(skDenpyoDatas.get(0).getDenkarikanjyono(), "12345", "伝票用仮勘定番号");
        exStringEquals(skDenpyoDatas.get(1).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(skDenpyoDatas.get(2).getDenkarikanjyono(), "", "伝票用仮勘定番号");
    }

    @Test
    @TestOrder(220)
    public void testExecSk_E1() {
        try {
            changeSystemDate(BizDate.valueOf("20190325"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111211");
            bean.setIbHuridenatesakicd("001");
            bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
            bean.setIbDenymd(BizDate.valueOf("20190325"));
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            bean.setIbSyoriymd(BizDate.valueOf("20160119"));
            bean.setIbSyoricd("0001");
            bean.setIbSyorisosikicd("0000001");
            bean.setIbGyoumuKousinsyaId("test01");
            bean.setIbKakokawaserateshiteiflg(false);
            bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
            bean.setIbKyktuukasyu(C_Tuukasyu.JPY);
            bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bean.setIbSyouhnsdno(1);

            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean0.setIbSuitoubumoncd("1");
            siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(2000,BizCurrencyTypes.YEN));
            siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
            siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
            siwakeMeisaiBean0.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean0);

            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(1500,BizCurrencyTypes.YEN));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(1500));
            siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
            siwakeMeisaiBean1.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(501,BizCurrencyTypes.YEN));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.JPYSYUUSIN);
            siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(501));
            siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
            siwakeMeisaiBean2.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111211", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(230)
    public void testExecSk_E2() {
        try {
            changeSystemDate(BizDate.valueOf("20190325"));
            BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111212");
            bean.setIbHuridenatesakicd("001");
            bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
            bean.setIbDenymd(BizDate.valueOf("20190325"));
            bean.setIbTuukasyu(C_Tuukasyu.USD);
            bean.setIbSyoriymd(BizDate.valueOf("20160119"));
            bean.setIbSyoricd("0001");
            bean.setIbSyorisosikicd("0000001");
            bean.setIbGyoumuKousinsyaId("test01");
            bean.setIbKakokawaserateshiteiflg(false);
            bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
            bean.setIbKyktuukasyu(C_Tuukasyu.USD);
            bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bean.setIbSyouhnsdno(1);

            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean0.setIbSuitoubumoncd("1");
            siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
            siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean0.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean0);

            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1500,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(1500));
            siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean1.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(501,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(501));
            siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean2.setIbDenkarikanjyono("12345");
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSk(bean);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111212", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(240)
    public void testExecSk_E3() {
        changeSystemDate(BizDate.valueOf("20190325"));
        BzSinkeiyakuDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzSinkeiyakuDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20190325"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("12345");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1500,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(1500,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(1500));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("12345");
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(501,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(501));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean2.setIbDenkarikanjyono("12345");
        siwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<HT_SkDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSk(bean);

        exBooleanEquals(skDenpyoDatas.get(0).getTaisyakutyouseiflg(), true, "貸借調整フラグ");
        exBooleanEquals(skDenpyoDatas.get(1).getTaisyakutyouseiflg(), false, "貸借調整フラグ");
        exBooleanEquals(skDenpyoDatas.get(2).getTaisyakutyouseiflg(), true, "貸借調整フラグ");
    }
}
