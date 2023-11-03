package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setHKTShrMeisai(SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam, List<JT_SiDetail>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setHKTShrMeisai {

    @Inject
    private SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl;

    @Inject
    private SiSetUiBean siSetUiBean;

    private final static String fileName = "UT_SP_単体テスト仕様書_保険金給付金支払共通UiBean設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiSetUiBeanTest_setHKTShrMeisai.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testSetHKTShrMeisai_A1() {

        siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl = null;

        List<JT_SiDetail> siDetailLst = new ArrayList<>();

        JT_SiDetail siDetail1 = new JT_SiDetail();

        siDetail1.setKyuuhucd("A050");
        siDetail1.setKyhkg(BizCurrency.valueOf(200));
        siDetail1.setBikoumsg1("備考ＭＳＧ１");
        siDetail1.setBikoumsg2("備考ＭＳＧ２");
        siDetail1.setBikoumsg3("備考ＭＳＧ３");
        siDetail1.setBikoumsg4("備考ＭＳＧ４");
        siDetail1.setSyouhncd("M110");
        siDetail1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail1.setSyouhnsdno(1);

        siDetailLst.add(siDetail1);

        boolean result = siSetUiBean.setHKTShrMeisai(siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl, siDetailLst);

        exBooleanEquals(result, false, "結果");
    }

    @Test
    @TestOrder(20)
    public void testSetHKTShrMeisai_A2() {

        List<JT_SiDetail> siDetailLst = null;

        boolean result = siSetUiBean.setHKTShrMeisai(siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl, siDetailLst);

        List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> hktshrMeisaisInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl
            .getHktshrMeisaisInfo();

        exBooleanEquals(result, true, "結果");
        exNumericEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.size(), 0, "支払詳細情報表示（保険金）リスト");

    }

    @Test
    @TestOrder(30)
    public void testSetHKTShrMeisai_A3() {

        List<JT_SiDetail> siDetailLst = new ArrayList<>();

        JT_SiDetail siDetail1 = new JT_SiDetail();
        JT_SiDetail siDetail2 = new JT_SiDetail();
        JT_SiDetail siDetail3 = new JT_SiDetail();

        siDetail1.setKyuuhucd("A000");
        siDetail1.setKyhkg(BizCurrency.valueOf(200));
        siDetail1.setBikoumsg1("備考ＭＳＧ１１");
        siDetail1.setBikoumsg2("備考ＭＳＧ２１");
        siDetail1.setBikoumsg3("備考ＭＳＧ３１");
        siDetail1.setBikoumsg4("備考ＭＳＧ４１");
        siDetail1.setSyouhncd("M110");
        siDetail1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail1.setSyouhnsdno(1);

        siDetail2.setKyuuhucd("A001");
        siDetail2.setKyhkg(BizCurrency.valueOf(210));
        siDetail2.setBikoumsg1("備考ＭＳＧ１２");
        siDetail2.setBikoumsg2("備考ＭＳＧ２２");
        siDetail2.setBikoumsg3("備考ＭＳＧ３２");
        siDetail2.setBikoumsg4("備考ＭＳＧ４２");
        siDetail2.setSyouhncd("M120");
        siDetail2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE120);
        siDetail2.setSyouhnsdno(2);

        siDetail3.setKyuuhucd("A002");
        siDetail3.setKyhkg(BizCurrency.valueOf(220));
        siDetail3.setBikoumsg1("備考ＭＳＧ１３");
        siDetail3.setBikoumsg2("備考ＭＳＧ２３");
        siDetail3.setBikoumsg3("備考ＭＳＧ３３");
        siDetail3.setBikoumsg4("備考ＭＳＧ４３");
        siDetail3.setSyouhncd("M220");
        siDetail3.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE180);
        siDetail3.setSyouhnsdno(3);

        siDetailLst.add(siDetail1);
        siDetailLst.add(siDetail2);
        siDetailLst.add(siDetail3);

        boolean result = siSetUiBean.setHKTShrMeisai(siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl, siDetailLst);

        List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> hktshrMeisaisInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl
            .getHktshrMeisaisInfo();

        exBooleanEquals(result, true, "結果");

        exNumericEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.size(), 3, "データ格納用のリストの件数");

        exBizCalcbleEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getKyhkg(),
            BizCurrency.valueOf(200), "給付金額");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg1(), "備考ＭＳＧ１１",
            "備考ＭＳＧ１");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg2(), "備考ＭＳＧ２１",
            "備考ＭＳＧ２");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg3(), "備考ＭＳＧ３１",
            "備考ＭＳＧ３");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg4(), "備考ＭＳＧ４１",
            "備考ＭＳＧ４");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getSyouhnnmgm(), "給付名（画面用）A000",
            "商品名（画面用）");

        exBizCalcbleEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getKyhkg(),
            BizCurrency.valueOf(210), "給付金額");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getBikoumsg1(), "備考ＭＳＧ１２",
            "備考ＭＳＧ１");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getBikoumsg2(), "備考ＭＳＧ２２",
            "備考ＭＳＧ２");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getBikoumsg3(), "備考ＭＳＧ３２",
            "備考ＭＳＧ３");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getBikoumsg4(), "備考ＭＳＧ４２",
            "備考ＭＳＧ４");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(1).getSyouhnnmgm(), "給付名（画面用）A001",
            "商品名（画面用）");

        exBizCalcbleEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getKyhkg(),
            BizCurrency.valueOf(220), "給付金額");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getBikoumsg1(), "備考ＭＳＧ１３",
            "備考ＭＳＧ１");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getBikoumsg2(), "備考ＭＳＧ２３",
            "備考ＭＳＧ２");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getBikoumsg3(), "備考ＭＳＧ３３",
            "備考ＭＳＧ３");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getBikoumsg4(), "備考ＭＳＧ４３",
            "備考ＭＳＧ４");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(2).getSyouhnnmgm(), "給付名（画面用）A002",
            "商品名（画面用）");
    }

    @Test
    @TestOrder(40)
    public void testSetHKTShrMeisai_A4() {

        List<JT_SiDetail> siDetailLst = new ArrayList<>();

        JT_SiDetail siDetail1 = new JT_SiDetail();

        siDetail1.setKyuuhucd("A050");
        siDetail1.setKyhkg(BizCurrency.valueOf(300));
        siDetail1.setBikoumsg1("備考ＭＳＧ１４");
        siDetail1.setBikoumsg2("備考ＭＳＧ２４");
        siDetail1.setBikoumsg3("備考ＭＳＧ３４");
        siDetail1.setBikoumsg4("備考ＭＳＧ４４");
        siDetail1.setSyouhncd("M110");
        siDetail1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail1.setSyouhnsdno(1);

        siDetailLst.add(siDetail1);

        boolean result = siSetUiBean.setHKTShrMeisai(siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl, siDetailLst);

        List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> hktshrMeisaisInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl
            .getHktshrMeisaisInfo();

        exBooleanEquals(result, true, "結果");

        exNumericEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.size(), 1, "データ格納用のリストの件数");

        exBizCalcbleEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getKyhkg(),
            BizCurrency.valueOf(300), "給付金額");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg1(), "備考ＭＳＧ１４",
            "備考ＭＳＧ１");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg2(), "備考ＭＳＧ２４",
            "備考ＭＳＧ２");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg3(), "備考ＭＳＧ３４",
            "備考ＭＳＧ３");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getBikoumsg4(), "備考ＭＳＧ４４",
            "備考ＭＳＧ４");
        exStringEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.get(0).getSyouhnnmgm(),
            "給付名（画面用）A050", "商品名（画面用）");
    }

    @Test
    @TestOrder(50)
    public void testSetHKTShrMeisai_A5() {

        List<JT_SiDetail> siDetailLst = new ArrayList<>();

        boolean result = siSetUiBean.setHKTShrMeisai(siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl, siDetailLst);

        List<HktshrMeisaisInfoDataSourceBeanCommonParamImpl> hktshrMeisaisInfoDataSourceBeanCommonParamImplLst = siSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParamImpl
            .getHktshrMeisaisInfo();

        exBooleanEquals(result, true, "結果");
        exNumericEquals(hktshrMeisaisInfoDataSourceBeanCommonParamImplLst.size(), 0, "データ格納用のリストの件数");
    }
}
