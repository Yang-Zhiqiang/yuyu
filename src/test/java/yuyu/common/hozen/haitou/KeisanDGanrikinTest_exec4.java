package yuyu.common.hozen.haitou;

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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当元利金計算クラスのメソッド {@link KeisanDGanrikin#execAllowOverAYear(BizCurrency, List<DRateBean> )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDGanrikinTest_exec4 {

    C_ErrorKbn  errorKbn;

    @Inject
    KeisanDGanrikin keisanDGanrikin;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当元利金計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanDGanrikinTest_exec4.class, fileName, sheetName);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManagerImpl bizDomManagerImpl = SWAKInjector.getInstance(BizDomManagerImpl.class);
        bizDomManagerImpl.delete(bizDomManagerImpl.getAllHaitouRiritu());
    }

    @Test
    @TestOrder(130)
    public void testExecAllowOverAYear_D1() {

        BizCurrency pRuigk = null;
        List<DRateBean> pDRateBeanList = new ArrayList<>();

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExecAllowOverAYear_D2() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = null;

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExecAllowOverAYear_D3() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<>();

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(160)
    public void testExecAllowOverAYear_D4() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<DRateBean>();

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        DRateBean dRateBean = setDNnd.new DRateBean();
        pDRateBeanList.add(dRateBean);

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(170)
    public void testExecAllowOverAYear_D5() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<DRateBean>();

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        DRateBean dRateBean = setDNnd.new DRateBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();
        dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
        pDRateBeanList.add(dRateBean);

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(180)
    public void testExecAllowOverAYear_D6() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<DRateBean>();
        BizDate kikanfrom = BizDate.valueOf("20170101");

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        DRateBean dRateBean = setDNnd.new DRateBean();
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();
        haitouKaisuuBean.setKikanfrom(kikanfrom);
        haitouKaisuuBeanLst.add(haitouKaisuuBean);
        dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
        pDRateBeanList.add(dRateBean);

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExecAllowOverAYear_D7_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(200)
    public void testExecAllowOverAYear_D7() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<DRateBean>();
        BizDate kikanfrom = BizDate.valueOf("20181101");
        BizDate kikanto = BizDate.valueOf("20181121");
        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        DRateBean dRateBean = setDNnd.new DRateBean();
        HaitouKaisuuBean haitouKaisuuBean = setDNnd.new HaitouKaisuuBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst = new ArrayList<HaitouKaisuuBean>();
        haitouKaisuuBean.setKikanfrom(kikanfrom);
        haitouKaisuuBean.setKikanto(kikanto);
        haitouKaisuuBeanLst.add(haitouKaisuuBean);
        dRateBean.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst);
        pDRateBeanList.add(dRateBean);

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExecAllowOverAYear_D8_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(220)
    public void testExecAllowOverAYear_D8() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        List<DRateBean> pDRateBeanList = new ArrayList<DRateBean>();
        BizDate kikanfrom1 = BizDate.valueOf("20181101");
        BizDate kikanto1 = BizDate.valueOf("20181121");
        BizDate kikanfrom2 = BizDate.valueOf("20191101");
        BizDate kikanto2 = BizDate.valueOf("20191121");
        BizDate kikanfrom3 = BizDate.valueOf("20201101");
        BizDate kikanto3 = BizDate.valueOf("20201121");

        SetDNnd setDNnd = SWAKInjector.getInstance(SetDNnd.class);
        DRateBean dRateBean1 = setDNnd.new DRateBean();
        DRateBean dRateBean2 = setDNnd.new DRateBean();
        DRateBean dRateBean3 = setDNnd.new DRateBean();
        HaitouKaisuuBean haitouKaisuuBean1 = setDNnd.new HaitouKaisuuBean();
        HaitouKaisuuBean haitouKaisuuBean2 = setDNnd.new HaitouKaisuuBean();
        HaitouKaisuuBean haitouKaisuuBean3 = setDNnd.new HaitouKaisuuBean();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst1 = new ArrayList<HaitouKaisuuBean>();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst2 = new ArrayList<HaitouKaisuuBean>();
        List<HaitouKaisuuBean> haitouKaisuuBeanLst3 = new ArrayList<HaitouKaisuuBean>();
        haitouKaisuuBean1.setKikanfrom(kikanfrom1);
        haitouKaisuuBean1.setKikanto(kikanto1);
        haitouKaisuuBean2.setKikanfrom(kikanfrom2);
        haitouKaisuuBean2.setKikanto(kikanto2);
        haitouKaisuuBean3.setKikanfrom(kikanfrom3);
        haitouKaisuuBean3.setKikanto(kikanto3);
        haitouKaisuuBeanLst1.add(haitouKaisuuBean1);
        haitouKaisuuBeanLst2.add(haitouKaisuuBean2);
        haitouKaisuuBeanLst3.add(haitouKaisuuBean3);
        dRateBean1.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst1);
        dRateBean2.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst2);
        dRateBean3.setHaitouKaisuuBeanLst(haitouKaisuuBeanLst3);
        pDRateBeanList.add(dRateBean1);
        pDRateBeanList.add(dRateBean2);
        pDRateBeanList.add(dRateBean3);

        errorKbn = keisanDGanrikin.execAllowOverAYear(pRuigk, pDRateBeanList);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1716), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 3, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(1), BizNumber.valueOf(0.2), "配当利率");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(2), BizNumber.valueOf(0.3), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20201121"), "計算基準日至");
    }

}
