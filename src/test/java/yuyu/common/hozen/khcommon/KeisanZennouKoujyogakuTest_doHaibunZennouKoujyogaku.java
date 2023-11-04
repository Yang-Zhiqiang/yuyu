package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納入金額計算クラスのメソッド {@link KeisanZennouKoujyogaku#doHaibunZennouKoujyogaku(BizCurrency,C_KoujyosyoumeipKbn,
 * List<KykSyouhnCommonParam>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouKoujyogakuTest_doHaibunZennouKoujyogaku {

    @Inject
    private KeisanZennouKoujyogaku keisanZennouKoujyogaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納控除証明額計算";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                KeisanZennouKoujyogakuTest_doHaibunZennouKoujyogaku.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouKeikaRiritu());
        bizDomManager.delete(bizDomManager.getAllZennouGenkaRitu());
    }

    @Test
    @TestOrder(10)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A1() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(3300000);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.IPPAN;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam.setSyouhncd("ｱｲ");
        kykSyouhnCommonParam.setSyouhnsdno(Integer.valueOf(90));
        kykSyouhnCommonParam.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(850000));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam);

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(0), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(0), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(3300000), "控除枠毎控除証明額");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 1, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱｲ", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "90", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(3300000), "商品毎控除証明額");
    }


    @Test
    @TestOrder(20)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A2() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(100000);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.IPPAN;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();

        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setSyouhncd("ｱ4");
        kykSyouhnCommonParam1.setSyouhnsdno(Integer.valueOf(94));
        kykSyouhnCommonParam1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(2555555.5));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setSyouhncd("ｱ3");
        kykSyouhnCommonParam2.setSyouhnsdno(Integer.valueOf(93));
        kykSyouhnCommonParam2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(1444444.4));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KykSyouhnCommonParamTest kykSyouhnCommonParam3 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam3.setSyouhncd("ｱ2");
        kykSyouhnCommonParam3.setSyouhnsdno(Integer.valueOf(92));
        kykSyouhnCommonParam3.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam3.setHokenryou(BizCurrency.valueOf(3999999.5));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam3);

        KykSyouhnCommonParamTest kykSyouhnCommonParam4 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam4.setSyouhncd("ｱ1");
        kykSyouhnCommonParam4.setSyouhnsdno(Integer.valueOf(91));
        kykSyouhnCommonParam4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam4.setHokenryou(BizCurrency.valueOf(2000000.5));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam4);

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(14444), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(25556), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(60000), "控除枠毎控除証明額");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 4, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "91", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(20001), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhncd(), "ｱ2", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhnsdno(), "92", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(39999), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyouhncd(), "ｱ3", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyouhnsdno(), "93", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(2).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(14444), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyouhncd(), "ｱ4", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyouhnsdno(), "94", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(3).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(3).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(25556), "商品毎控除証明額");
    }

    @Test
    @TestOrder(30)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A3() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(100);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.IPPAN;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();

        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setSyouhncd("ｱ4");
        kykSyouhnCommonParam1.setSyouhnsdno(Integer.valueOf(94));
        kykSyouhnCommonParam1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(5500));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setSyouhncd("ｱ3");
        kykSyouhnCommonParam2.setSyouhnsdno(Integer.valueOf(93));
        kykSyouhnCommonParam2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(4500));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(0), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(55), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(45), "控除枠毎控除証明額");


        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 2, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱ3", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "93", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(45), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhncd(), "ｱ4", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhnsdno(), "94", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(55), "商品毎控除証明額");
    }

    @Test
    @TestOrder(40)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A4() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.IPPAN;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setSyouhncd("ｱ4");
        kykSyouhnCommonParam1.setSyouhnsdno(Integer.valueOf(94));
        kykSyouhnCommonParam1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(550000, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setSyouhncd("ｱ3");
        kykSyouhnCommonParam2.setSyouhnsdno(Integer.valueOf(93));
        kykSyouhnCommonParam2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(450000, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(55.00, BizCurrencyTypes.DOLLAR), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(45.00, BizCurrencyTypes.DOLLAR), "控除枠毎控除証明額");


        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 2, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱ3", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "93", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(45.00, BizCurrencyTypes.DOLLAR), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhncd(), "ｱ4", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhnsdno(), "94", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(55.00, BizCurrencyTypes.DOLLAR), "商品毎控除証明額");
    }

    @Test
    @TestOrder(50)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A5() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(100, BizCurrencyTypes.YEN);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.IPPAN;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setSyouhncd("ｱ4");
        kykSyouhnCommonParam1.setSyouhnsdno(Integer.valueOf(94));
        kykSyouhnCommonParam1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(550000, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setSyouhncd("ｱ3");
        kykSyouhnCommonParam2.setSyouhnsdno(Integer.valueOf(93));
        kykSyouhnCommonParam2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(450000, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(55, BizCurrencyTypes.YEN), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(45, BizCurrencyTypes.YEN), "控除枠毎控除証明額");


        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 2, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱ3", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "93", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(45, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhncd(), "ｱ4", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhnsdno(), "94", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(55, BizCurrencyTypes.YEN), "商品毎控除証明額");
    }

    @Test
    @TestOrder(60)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A6() {

        BizCurrency zennouKoujsymgaku = BizCurrency.valueOf(100, BizCurrencyTypes.YEN);
        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;
        List<KykSyouhnCommonParam>  kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setSyouhncd("ｱ1");
        kykSyouhnCommonParam1.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhnCommonParam1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(555, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setSyouhncd("ｱ1");
        kykSyouhnCommonParam2.setSyouhnsdno(Integer.valueOf(12));
        kykSyouhnCommonParam2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(444, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KykSyouhnCommonParamTest kykSyouhnCommonParam3 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam3.setSyouhncd("ｱ1");
        kykSyouhnCommonParam3.setSyouhnsdno(Integer.valueOf(13));
        kykSyouhnCommonParam3.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam3.setHokenryou(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam3);

        KykSyouhnCommonParamTest kykSyouhnCommonParam4 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam4.setSyouhncd("ｱ1");
        kykSyouhnCommonParam4.setSyouhnsdno(Integer.valueOf(11));
        kykSyouhnCommonParam4.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam4.setHokenryou(BizCurrency.valueOf(277, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam4);

        KykSyouhnCommonParamTest kykSyouhnCommonParam5 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam5.setSyouhncd("ｱ1");
        kykSyouhnCommonParam5.setSyouhnsdno(Integer.valueOf(12));
        kykSyouhnCommonParam5.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam5.setHokenryou(BizCurrency.valueOf(233, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam5);

        KykSyouhnCommonParamTest kykSyouhnCommonParam6 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam6.setSyouhncd("ｱ1");
        kykSyouhnCommonParam6.setSyouhnsdno(Integer.valueOf(13));
        kykSyouhnCommonParam6.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhnCommonParam6.setHokenryou(BizCurrency.valueOf(233, BizCurrencyTypes.DOLLAR));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam6);


        KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(zennouKoujsymgaku, syuKoujyosyoumeipKbn, kykSyouhnCommonParamLst);
        List<KhWkgtZennouKoujyogakuBean> khWkgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhWkgtZennouKoujyogakuBeanList();
        exNumericEquals(khWkgtZennouKoujyogakuBeanList.size(), 3, "控除枠毎控除証明情報Beanリスト");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(0).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(1).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(39, BizCurrencyTypes.YEN), "控除枠毎控除証明額");
        exClassificationEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipKbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khWkgtZennouKoujyogakuBeanList.get(2).getKhWkgtZennouKoujyogaku(), BizCurrency.valueOf(48, BizCurrencyTypes.YEN), "控除枠毎控除証明額");


        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = khZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList();
        exNumericEquals(khShgtZennouKoujyogakuBeanList.size(), 6, "商品毎控除証明情報Beanリスト");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(), "11", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(33, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyouhnsdno(), "12", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(1).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(26, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyouhnsdno(), "13", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(2).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(2).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(2).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(1, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyouhnsdno(), "11", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(3).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(3).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(1).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(26, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(4).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(4).getSyouhnsdno(), "12", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(4).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(4).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(4).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "商品毎控除証明額");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(5).getSyouhncd(), "ｱ1", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(5).getSyouhnsdno(), "13", "商品世代番号");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(5).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(5).getKoujyosyoumeipkbn(), C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(5).getKhShgtZennouKoujyogaku(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "商品毎控除証明額");
    }
}
