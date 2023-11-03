package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書共通編集クラスのメソッド {@link SiMeisaiCommonHensyu#sisansyoHensyu(SiHkkingakuSisanParamBean,
        List<SiSiDetailParamBean>, BizCurrency, BizCurrency, BizCurrency, BizCurrency, BizCurrency, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiMeisaiCommonHensyuTest_sisansyoHensyu {

    @Inject
    private SiMeisaiCommonHensyu siMeisaiCommonHensyu;

    SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払明細書共通編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiMeisaiCommonHensyuTest_sisansyoHensyu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testSisansyoHensyu_A1() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean =  null;

        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testSisansyoHensyu_A2() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));

        List<SiSiDetailParamBean> siSiDetailParamBeanLst = null;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testSisansyoHensyu_A3() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(10));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(11));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(1001));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(1002));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(1003));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(1004));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(1005));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(1006));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(1007));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(1008));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(1009));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(1010));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(1011));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(1012));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(1013));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(10000));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(20000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(50000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(60000));

        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testSisansyoHensyu_A4() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(10));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(11));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(1001));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(1002));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(1003));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(1004));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(1005));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(1006));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(1007));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(1009));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(1010));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(1011));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(1012));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(1013));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(10000));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(20000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(50000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(60000));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(1000));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 10, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(),
            BizCurrency.valueOf(10000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "1000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(),
            BizCurrency.valueOf(-1006), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "100600", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 1,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "２０１８年　１月から　１年分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getShrGkMeisai(),
            BizCurrency.valueOf(40000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisai()),
            "4000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getDetailBikou()),
            "（Ａ）配当金：1,003 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getDetailBikou()),
            "（Ｂ）保険料：2,020 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getDetailBikou()),
            "（Ｃ）預り金：20,000 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getDetailBikou()),
            "（Ｄ）その他精算金：1,013 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）＋（Ｃ）＋（Ｄ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(8).getDetailBikou()),
            "　　30,000 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(9).getDetailBikou()),
            "為替レート：１米ドル　＝　11円", "明細備考");



        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 7, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(1001), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),
            "外貨金額：1,000 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),
            "初期死亡時円換算支払額最低保証特約に基づいた", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getDetailBikou()),
            "金額となります。", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getShrGkMeisai(),
            BizCurrency.valueOf(1003), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrGkMeisai()),
            "1003", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getShrGkMeisai(),
            BizCurrency.valueOf(2020), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrGkMeisai()),
            "2020", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getShrGkMeisai(),
            BizCurrency.valueOf(20000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrGkMeisai()),
            "20000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getTekiYou(), "その他精算金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getShrGkMeisai(),
            BizCurrency.valueOf(1013), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrGkMeisai()),
            "1013", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getDetailBikou()),
            "", "明細備考");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testSisansyoHensyu_A5() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(10));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(11));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(1001));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(1002));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(1003));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(1004));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(1005));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(1006));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(1007));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(1);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(1009));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(1010));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(1011));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(1012));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(1013));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(10000));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(20000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(50000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(60000));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(1000));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 6, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(),
            BizCurrency.valueOf(1002), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "1002", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(),
            BizCurrency.valueOf(-1006), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "100600", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 1,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "２０１８年　１月から　１年分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getShrGkMeisai(),
            BizCurrency.valueOf(1010), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisai()),
            "1010", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getShrGkMeisai(),
            BizCurrency.valueOf(20000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisai()),
            "20000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getTekiYou(), "その他精算金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getShrGkMeisai(),
            BizCurrency.valueOf(1012), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisai()),
            "1012", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getDetailBikou()),
            "", "明細備考");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testSisansyoHensyu_A6() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.AUD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(10));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(11));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(1001));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(1);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(1);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(10000));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(20000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(50000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(60000));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 8, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(),
            BizCurrency.valueOf(10000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "1000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(),
            BizCurrency.valueOf(40000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "4000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "（Ａ）保険料：0 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getDetailBikou()),
            "（２０１８年　２月から　１か月分）", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(4).getDetailBikou()),
            "（Ｂ）預り金：20,000 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(5).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(6).getDetailBikou()),
            "　　30,000 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(7).getDetailBikou()),
            "為替レート：１豪ドル　＝　11円", "明細備考");


        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 7, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(60000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),
            "（Ａ）外貨金額：1,000 豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),
            "（Ｂ）預り金：10,000 豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(3).getDetailBikou()),
            "　　50,000 豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(4).getDetailBikou()),
            "為替レート：１豪ドル　＝　10円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(5).getDetailBikou()),
            "２０１８年　２月から　１か月分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getShrGkMeisai(),
            BizCurrency.valueOf(20000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrGkMeisai()),
            "20000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(6).getDetailBikou()),
            "", "明細備考");


        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testSisansyoHensyu_A7() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.AUD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(0);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 4, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(),
            BizCurrency.valueOf(40000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "4000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "保険料：0 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "（）", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(3).getDetailBikou()),
            "為替レート：１豪ドル　＝　0円", "明細備考");



        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 3, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),
            "外貨金額：0 豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),
            "為替レート：１豪ドル　＝　0円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getDetailBikou()),
            "", "明細備考");


        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testSisansyoHensyu_A8() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.AUD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(1000));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(30000));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(40000));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 3, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(),
            BizCurrency.valueOf(40000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "4000000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "保険料：0 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "為替レート：１豪ドル　＝　0円", "明細備考");


        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 3, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),
            "外貨金額：0 豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),
            "為替レート：１豪ドル　＝　0円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(2).getDetailBikou()),
            "", "明細備考");


        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(90)
    public void testSisansyoHensyu_A9() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        SiSiDetailParamBean siSiDetailParamBean2 = new SiSiDetailParamBean();
        siSiDetailParamBean2.setKyuuhucd("002");
        siSiDetailParamBean2.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean2.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean2);

        SiSiDetailParamBean siSiDetailParamBean3 = new SiSiDetailParamBean();
        siSiDetailParamBean3.setKyuuhucd("003");
        siSiDetailParamBean3.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean3.setSyouhncd("ﾕｱ");
        siSiDetailParamBeanLst.add(siSiDetailParamBean3);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 3, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(2).getDetailBikou()),
            "", "明細備考");


        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(),
            BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),
            "外貨金額：0 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),
            "為替レート：１米ドル　＝　0円", "明細備考");


        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testSisansyoHensyu_A10() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(1));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｲ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),  "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(), BizCurrency.valueOf(1), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),  "100", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),  "", "明細備考");
    }

    @Test
    @TestOrder(110)
    public void testSisansyoHensyu_A11() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(1));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｴ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),  "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(), BizCurrency.valueOf(1), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),  "1", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),  "２０１８年　２月から１３年１１か月分", "明細備考");
    }

    @Test
    @TestOrder(120)
    public void testSisansyoHensyu_A12() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(1));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｲ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),  "", "明細備考");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(0).getDetailBikou()),  "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getShrGkMeisai(), BizCurrency.valueOf(-1), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisai()),  "100", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getRendouShrknGkMeisaiHugou(), 1,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[0].get(1).getDetailBikou()),  "２０１８年　１月から１１年１２か月分", "明細備考");
    }

    @Test
    @TestOrder(130)
    public void testSisansyoHensyu_A13() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｵ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),  "外貨金額：0 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),  "為替レート：１米ドル　＝　0円", "明細備考");
    }

    @Test
    @TestOrder(140)
    public void testSisansyoHensyu_A14() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｲ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),  "外貨金額：0 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),  "為替レート：１米ドル　＝　0円", "明細備考");
    }
    @Test
    @TestOrder(150)
    public void testSisansyoHensyu_A15() {

        MockObjectManager.initialize();

        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = new SiHkkingakuSisanParamBean();
        siHkkingakuSisanParamBean.setKykTuukasyu(C_Tuukasyu.USD);
        siHkkingakuSisanParamBean.setKnsnKijyunYmd(BizDate.valueOf(20180101));
        siHkkingakuSisanParamBean.setKawaseRate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setGaikaknsnkwsrate(BizNumber.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenHokenKngk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugohaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugosonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkasonotahaitoukin(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuuy(11);
        siHkkingakuSisanParamBean.setMisyuupjyuutoukaisuum(12);
        siHkkingakuSisanParamBean.setMisyuupjyuutouym(BizDateYM.valueOf(201801));
        siHkkingakuSisanParamBean.setBunkatugomisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamisyuup(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuuy(13);
        siHkkingakuSisanParamBean.setMikeikapjyuutoukaisuum(11);
        siHkkingakuSisanParamBean.setMikeikapjyuutouym(BizDateYM.valueOf(201802));
        siHkkingakuSisanParamBean.setBunkatugomikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkamikeikap(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugozennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkazennouseisank(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugokrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoyenkakrkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingksiteituuka(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoZitkazukarikingkyen(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoGaikaknsnkkkgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsntskgk(BizCurrency.valueOf(0));
        siHkkingakuSisanParamBean.setBunkatugoYenkaknsnkkkgk(BizCurrency.valueOf(0));


        List<SiSiDetailParamBean> siSiDetailParamBeanLst = new ArrayList<>();
        SiSiDetailParamBean siSiDetailParamBean = new SiSiDetailParamBean();
        siSiDetailParamBean.setKyuuhucd("001");
        siSiDetailParamBean.setSitihsyutkyumaeyenhknkngk(BizCurrency.valueOf(0));
        siSiDetailParamBean.setSyouhncd("ﾕｴ");

        siSiDetailParamBeanLst.add(siSiDetailParamBean);

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.sisansyoHensyu(siHkkingakuSisanParamBean, siSiDetailParamBeanLst);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].size(), 2, "件数");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getShrGkMeisai(), BizCurrency.valueOf(0), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(0).getDetailBikou()),  "外貨金額：0 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisai()),  "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getRendouShrknGkMeisaiHugou(), 0,  "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSisansyoHensyuResult()[1].get(1).getDetailBikou()),  "為替レート：１米ドル　＝　0円", "明細備考");
    }
}
