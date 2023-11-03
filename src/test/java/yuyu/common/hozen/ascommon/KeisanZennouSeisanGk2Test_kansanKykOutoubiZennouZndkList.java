package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算額計算２クラスのメソッド {@link KeisanZennouSeisanGk2#kansanKykOutoubiZennouZndkList(List<KykOutoubiZennouZndkBean>, BizDate, C_Tuukasyu, BizNumber)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGk2Test_kansanKykOutoubiZennouZndkList {

    @Inject
    private KeisanZennouSeisanGk2 keisanZennouSeisanGk2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算２";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGk2Test_kansanKykOutoubiZennouZndkList.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testKansanKykOutoubiZennouZndkList_A1() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        BizDate syoriYmd = BizDate.valueOf(20170427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.USD;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 0, "契約応当日前納残高（換算通貨）リスト件数");
    }

    @Test
    @TestOrder(20)
    public void testKansanKykOutoubiZennouZndkList_A2() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20200921));
        kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

        BizDate syoriYmd = BizDate.valueOf(20170427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.USD;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 1, "件数");
        exDateEquals(beanLst.get(0).getKykOutoubi(), BizDate.valueOf(20200921), "契約応当日");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnTk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(500), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(200), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(300), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnKawaseRate(), null, "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(0).getGetKawaseRateUmuKbn(), C_UmuKbn.NONE, "為替レート取得有無区分");
    }

    @Test
    @TestOrder(30)
    public void testKansanKykOutoubiZennouZndkList_A3() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20180427));
        kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

        BizDate syoriYmd = BizDate.valueOf(20200921);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(40)
    public void testKansanKykOutoubiZennouZndkList_A4() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20180427));
        kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

        BizDate syoriYmd = BizDate.valueOf(20180427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 1, "件数");
        exDateEquals(beanLst.get(0).getKykOutoubi(), BizDate.valueOf(20180427), "契約応当日");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnTk(), BizCurrency.valueOf(20), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(500), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(200), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(300), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(0.02), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(0).getGetKawaseRateUmuKbn(), C_UmuKbn.NONE, "為替レート取得有無区分");
    }

    @Test
    @TestOrder(50)
    public void testKansanKykOutoubiZennouZndkList_A5() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean1 = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean1.setKykOutoubi(BizDate.valueOf(20170427));
        kykOutoubiZennouZndkBean1.setZennouZndk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean1.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean1.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(2000));
        kykOutoubiZennouZndkBean1.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(3000));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean1);

        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean2 = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean2.setKykOutoubi(BizDate.valueOf(20170427));
        kykOutoubiZennouZndkBean2.setZennouZndk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean2.setJyuutoumaeZennouZndk(BizCurrency.valueOf(50));
        kykOutoubiZennouZndkBean2.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean2.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean2);

        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean3 = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean3.setKykOutoubi(BizDate.valueOf(20170427));
        kykOutoubiZennouZndkBean3.setZennouZndk(BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean3.setJyuutoumaeZennouZndk(BizCurrency.valueOf(5));
        kykOutoubiZennouZndkBean3.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(20));
        kykOutoubiZennouZndkBean3.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(30));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean3);

        BizDate syoriYmd = BizDate.valueOf(20180427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 3, "件数");
        exDateEquals(beanLst.get(0).getKykOutoubi(), BizDate.valueOf(20170427), "契約応当日");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnTk(), BizCurrency.valueOf(120390), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(500), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(2000), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(3000), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(120.39), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(0).getGetKawaseRateUmuKbn(), C_UmuKbn.ARI, "為替レート取得有無区分");

        exDateEquals(beanLst.get(1).getKykOutoubi(), BizDate.valueOf(20170427), "契約応当日");
        exBizCalcbleEquals(beanLst.get(1).getZennouZndkKnsnTk(), BizCurrency.valueOf(12039), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(1).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(50), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(1).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(200), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(1).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(300), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(1).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(120.39), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(1).getGetKawaseRateUmuKbn(), C_UmuKbn.ARI, "為替レート取得有無区分");

        exDateEquals(beanLst.get(2).getKykOutoubi(), BizDate.valueOf(20170427), "契約応当日");
        exBizCalcbleEquals(beanLst.get(2).getZennouZndkKnsnTk(), BizCurrency.valueOf(1203), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(2).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(5), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(2).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(20), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(2).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(30), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(2).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(120.39), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(2).getGetKawaseRateUmuKbn(), C_UmuKbn.ARI, "為替レート取得有無区分");
    }

    @Test
    @TestOrder(60)
    public void testKansanKykOutoubiZennouZndkList_A6() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20200427));
        kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

        BizDate syoriYmd = BizDate.valueOf(20180427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.JPY;
        BizNumber knsnKwsRate = BizNumber.valueOf(0.02);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 1, "件数");
        exDateEquals(beanLst.get(0).getKykOutoubi(), BizDate.valueOf(20200427), "契約応当日");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnTk(), BizCurrency.valueOf(20), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(500), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(200), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(300), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(0.02), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(0).getGetKawaseRateUmuKbn(), C_UmuKbn.NONE, "為替レート取得有無区分");
    }


    @Test
    @TestOrder(70)
    public void testKansanKykOutoubiZennouZndkList_A7() {

        List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList = new ArrayList<>();
        KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
        kykOutoubiZennouZndkBean.setKykOutoubi(BizDate.valueOf(20200921));
        kykOutoubiZennouZndkBean.setZennouZndk(BizCurrency.valueOf(1000));
        kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(BizCurrency.valueOf(500));
        kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(BizCurrency.valueOf(200));
        kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(BizCurrency.valueOf(300));
        kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

        BizDate syoriYmd = BizDate.valueOf(20170427);
        C_Tuukasyu knsnTuukasyu = C_Tuukasyu.USD;
        BizNumber knsnKwsRate = BizNumber.valueOf(130.39);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.kansanKykOutoubiZennouZndkList(kykOutoubiZennouZndkList, syoriYmd,
            knsnTuukasyu, knsnKwsRate);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<KykOutoubiZennouZndkKnsnBean> beanLst = keisanZennouSeisanGk2.getKykOutoubiZennouZndkKnsnList();
        exNumericEquals(beanLst.size(), 1, "件数");
        exDateEquals(beanLst.get(0).getKykOutoubi(), BizDate.valueOf(20200921), "契約応当日");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnTk(), BizCurrency.valueOf(130390, BizCurrencyTypes.DOLLAR), "前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getJyuutoumaeZennouZndkKnsnTk(), BizCurrency.valueOf(65195, BizCurrencyTypes.DOLLAR), "充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyZnnuzndkTuk(), BizCurrency.valueOf(26078, BizCurrencyTypes.DOLLAR), "前納利率適用前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZnnurrttkyjytmaeZnnuzndkTuk(), BizCurrency.valueOf(39117, BizCurrencyTypes.DOLLAR), "前納利率適用充当前前納残高（換算通貨）");
        exBizCalcbleEquals(beanLst.get(0).getZennouZndkKnsnKawaseRate(), BizNumber.valueOf(130.39), "前納残高換算為替レート");
        exClassificationEquals(beanLst.get(0).getGetKawaseRateUmuKbn(), C_UmuKbn.NONE, "為替レート取得有無区分");
    }
}
