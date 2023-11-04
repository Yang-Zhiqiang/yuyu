package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書共通編集クラスのメソッド {@link SiMeisaiCommonHensyu#siMeisaiHensyu(JT_Sk, List<JT_SiDetail>, BizDate, C_KanryotuutioutKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiMeisaiCommonHensyuTest_siMeisaiHensyu {

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
            testDataAndTblMap = testDataMaker.getInData(SiMeisaiCommonHensyuTest_siMeisaiHensyu.class, fileName, sheetName);
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
    public void testsiMeisaiHensyu_A1() {

        MockObjectManager.initialize();

        JT_Sk jtSk =  null;
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000013", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testsiMeisaiHensyu_A2() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000024");
        List<JT_SiDetail> siDetailLst = null;
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testsiMeisaiHensyu_A3() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000035");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000035", 10);
        BizDate sibouYmd = null;
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testsiMeisaiHensyu_A4() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000035");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000035", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = null;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testsiMeisaiHensyu_A5() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000035");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000035", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 11, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(12345), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "12345", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "２０１８年　３月から　３年　５か月分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getTekiYou(), "その他精算金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getTekiYou(), "支払利息", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getShrGkMeisai(),
            BizCurrency.valueOf(1000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getDetailBikou()),
            "必要書類の受付日翌日から５営業日を超えた１０日分", "明細備考");
    }

    @Test
    @TestOrder(60)
    public void testsiMeisaiHensyu_A6() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000046");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000046", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 15, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(234.56, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "23456", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(),
            BizCurrency.valueOf(-10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 1,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "２０１８年　２月から　１年　１か月分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()),
            "（Ａ）配当金：２，２３４．５６円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()),
            "（Ｂ）保険料：２３５，５５５．５５円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getDetailBikou()),
            "（Ｃ）預り金：１，０００円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getDetailBikou()),
            "（Ｄ）その他精算金：４００．００円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）＋（Ｃ）＋（Ｄ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getDetailBikou()),
            "　　８００．００円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getDetailBikou()),
            "為替レート：１米ドル　＝　４０円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getDetailBikou()),
            "換算基準日：２０１８年　３月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getTekiYou(), "支払利息", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getDetailBikou()),
            "必要書類の受付日翌日から４５日を超えた２０日分", "明細備考");
    }

    @Test
    @TestOrder(70)
    public void testsiMeisaiHensyu_A7() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000057");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000057", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 5, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(100000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "100000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "外貨金額：１２３．４５米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "初期死亡時円換算支払額最低保証特約に基づいた", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "金額となります。", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(),
            BizCurrency.valueOf(123333.33, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "12333333", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "",
            "明細備考");
    }

    @Test
    @TestOrder(80)
    public void testsiMeisaiHensyu_A8() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000068");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000068", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 15, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(22222.22, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "2222222", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "（Ａ）外貨金額：123.45 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "（Ｂ）預り金：10.00 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "（Ｃ）保険料：10.00 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "（２０１８年　１月から　１か月分）", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）－（Ｃ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()),
            "　　600.00 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()),
            "為替レート：１米ドル　＝　10円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getDetailBikou()),
            "換算基準日：２０１８年　２月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getShrGkMeisai(),
            BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisai()),
            "123456", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(10).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(11).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getTekiYou(), "その他精算金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getShrGkMeisai(),
            BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrGkMeisai()),
            "30000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(12).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(13).getDetailBikou()), "",
            "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getTekiYou(), "支払利息", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(14).getDetailBikou()),
            "必要書類の受付日翌日から５営業日を超えた１０日分", "明細備考");
    }

    @Test
    @TestOrder(90)
    public void testsiMeisaiHensyu_A9() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000057");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000057", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 5, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(100000), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "100000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "外貨金額：123.45 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "初期死亡時円換算支払額最低保証特約に基づいた", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "金額となります。", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料（円貨払込額）", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(),
            BizCurrency.valueOf(123333.33, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "12333333", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "",
            "明細備考");
    }

    @Test
    @TestOrder(100)
    public void testsiMeisaiHensyu_A10() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000079");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000079", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 9, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(22222.22, BizCurrencyTypes.AU_DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "2222222", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "（Ａ）外貨金額：１２３．４５豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "（Ｂ）預り金：１０．００豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "（Ｃ）保険料：１０．００豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "（２０１８年　１月から１２年１１か月分）", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）－（Ｃ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()),
            "　　６００．００豪ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()),
            "為替レート：１豪ドル　＝　１０円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getDetailBikou()),
            "換算基準日：２０１８年　２月　１日", "明細備考");

    }

    @Test
    @TestOrder(110)
    public void testsiMeisaiHensyu_A11() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000080");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000080", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 5, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(123.45, BizCurrencyTypes.AU_DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "支払利息", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "必要書類の受付日翌日から５営業日を超えた１０日分", "明細備考");
    }

    @Test
    @TestOrder(120)
    public void testsiMeisaiHensyu_A12() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000091");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000091", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 6, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(123.45, BizCurrencyTypes.AU_DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "12345", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.AUD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()),
            "", "明細備考");
    }

    @Test
    @TestOrder(130)
    public void testsiMeisaiHensyu_A13() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000105");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000105", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 10, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(),
            BizCurrency.valueOf(123.45, BizCurrencyTypes.EURO), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()),
            "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.EUR, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()),
            "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(),
            BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()),
            "1000", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.EUR, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()),
            "（Ａ）配当金：1,234.56 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()),
            "（Ｂ）保険料：123,333.33 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()),
            "（Ｃ）預り金：1,000 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()),
            "（Ｄ）その他精算金：300.00 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()),
            "【差引金額（Ａ）＋（Ｂ）＋（Ｃ）＋（Ｄ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()),
            "　　900.00 円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(8).getDetailBikou()),
            "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisai()),
            "0", "支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrGkMeisaiTuukasyu(),
            C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getRendouShrknGkMeisaiHugou(), 0,
            "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(9).getDetailBikou()),
            "換算基準日：２０１８年　２月　１日", "明細備考");
    }

    @Test
    @TestOrder(140)
    public void testsiMeisaiHensyu_A14() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000116");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000116", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 3, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名３", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "", "明細備考");

    }

    @Test
    @TestOrder(150)
    public void testsiMeisaiHensyu_A15() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000127");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000127", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 5, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "預り金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1000", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "２０１８年　３月から　１年分", "明細備考");
    }

    @Test
    @TestOrder(160)
    public void testsiMeisaiHensyu_A16() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000138");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000138", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 2, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");
    }

    @Test
    @TestOrder(170)
    public void testsiMeisaiHensyu_A17() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000172");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000172", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 4, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "為替レート：１米ドル　＝　30円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "換算基準日：２０１８年　２月　１日", "明細備考");
    }

    @Test
    @TestOrder(180)
    public void testsiMeisaiHensyu_A18() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000183");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000183", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 4, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "その他支払金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.USD, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "為替レート：１米ドル　＝　30円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "換算基準日：２０１８年　２月　１日", "明細備考");
    }

    @Test
    @TestOrder(190)
    public void testsiMeisaiHensyu_A19() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000194");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000194", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 5, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1000", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "", "明細備考");
    }

    @Test
    @TestOrder(200)
    public void testsiMeisaiHensyu_A20() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000208");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000208", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 7, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(123.45, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "12345", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "配当金", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "1000", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), BizCurrency.valueOf(-0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 1, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "２０１８年　１月から　１か月分", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()), "", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "保険料", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()), "1", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()), "", "明細備考");
    }

    @Test
    @TestOrder(210)
    public void testsiMeisaiHensyu_A21() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000219");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000219", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.GAIBU;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 7, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(22222.22, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "2222222", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "（Ａ）外貨金額：１２３．４５米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "（Ｂ）保険料：０．０１米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "【差引金額（Ａ）＋（Ｂ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "　　６００．００米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()), "為替レート：１米ドル　＝　１０円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()), "換算基準日：２０１８年　２月　１日", "明細備考");
    }

    @Test
    @TestOrder(220)
    public void testsiMeisaiHensyu_A22() {

        MockObjectManager.initialize();

        JT_Sk jtSk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino("skno001", "17806000220");
        List<JT_SiDetail> siDetailLst = siharaiDomManager.getSiDetailsBySknoSyonoSeikyuurirekino("skno001", "17806000220", 10);
        BizDate sibouYmd = BizDate.valueOf(20180101);
        C_KanryotuutioutKbn kanryoTuutioutKbn = C_KanryotuutioutKbn.PDF;

        C_ErrorKbn errorKbn = siMeisaiCommonHensyu.siMeisaiHensyu(jtSk, siDetailLst, sibouYmd, kanryoTuutioutKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().size(), 8, "件数");
        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getTekiYou(), "給付名１", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getShrGkMeisai(), BizCurrency.valueOf(22222.22, BizCurrencyTypes.DOLLAR), "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisai()), "2222222", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.JPY, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(0).getDetailBikou()), "死亡日：２０１８年　１月　１日", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(1).getDetailBikou()), "（Ａ）外貨金額：123.45 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(2).getDetailBikou()), "（Ｂ）保険料：0.01 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(3).getDetailBikou()), "（２０１８年　３月から　１年分）", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(4).getDetailBikou()), "【差引金額（Ａ）＋（Ｂ）】", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(5).getDetailBikou()), "　　600.00 米ドル", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(6).getDetailBikou()), "為替レート：１米ドル　＝　10円", "明細備考");

        exStringEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getTekiYou(), "", "摘要");
        exBizCalcbleEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getShrGkMeisai(), null, "支払金額明細");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisai()), "0", "連動用支払金額明細");
        exClassificationEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrGkMeisaiTuukasyu(), C_Tuukasyu.BLNK, "連動用支払金額明細通貨種類");
        exNumericEquals(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getRendouShrknGkMeisaiHugou(), 0, "連動用支払金額明細符号");
        exStringEquals(String.valueOf(siMeisaiCommonHensyu.getSiMeisaiHensyuResult().get(7).getDetailBikou()), "換算基準日：２０１８年　２月　１日", "明細備考");
    }
}
