package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払明細書共通計算クラスのメソッド {@link SiMeisaiCommonCalc#exec(SiMeisaiCommonCalcBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiMeisaiCommonCalcTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払明細書共通計算";
    private final static String sheetName = "INデータ";

    @Inject
    private SiMeisaiCommonCalc siMeisaiCommonCalc;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SiMeisaiCommonCalcTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(100)
    public void testExec_A01() {
        siMeisaiCommonCalc.exec(null);
        try {
            siMeisaiCommonCalc.exec(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='pSiMeisaiCommonCalcBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A02() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("100000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("100001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-20"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-21"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("100003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("100004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("399987")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(120)
    public void testExec_A03() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("2100"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("200000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("211111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("200001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("200002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("200003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("2200"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("200004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("1116009")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(130)
    public void testExec_A04() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("300000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("211111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("300001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("300002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("300003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("300004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("900009")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(140)
    public void testExec_A05() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("4100"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("400000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("211111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("400001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("400002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("400003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("4200"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("400004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("1920918")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }


    @Test
    @TestOrder(150)
    public void testExec_A06() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("5100"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-22"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-23"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("10"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("5200"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("1030000")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(160)
    public void testExec_A07() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("211111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(170)
    public void testExec_A08() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("7100"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("700000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("1007"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("700001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("700002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("700003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("7200"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("700004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("700005"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("15240414")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(180)
    public void testExec_A09() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("800000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("800001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("800002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("800003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("800004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("800005"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("3200014")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(190)
    public void testExec_A10() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("900000"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("900001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("900002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("900003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("900004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("900005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("900006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(200)
    public void testExec_A11() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("AA");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(210)
    public void testExec_A12() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-1"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("BB");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("18733813")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(220)
    public void testExec_A13() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-1"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-2"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("BB");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("16222624")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(230)
    public void testExec_A14() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.JPY);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-4"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-3"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("CC");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("7400616")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(240)
    public void testExec_A15() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-5"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-6"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.SOUZOKU);
        siMeisaiCommonCalcBean.setSyouhinCd("CC");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("7112127")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(250)
    public void testExec_A16() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-10"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-11"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("CC");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("6545970")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }

    @Test
    @TestOrder(260)
    public void testExec_A17() {
        SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

        siMeisaiCommonCalcBean.setKykTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setShrTuukasyu(C_Tuukasyu.USD);
        siMeisaiCommonCalcBean.setKawaseRate(BizNumber.valueOf(120));
        siMeisaiCommonCalcBean.setGaikaknsnkwsrate(BizNumber.valueOf(110));
        siMeisaiCommonCalcBean.setZeimukwsrate(BizNumber.valueOf(100));
        siMeisaiCommonCalcBean.setHokenkngkgoukei(BizCurrency.valueOf(Long.valueOf("10000"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZennouseisankgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkazennouseisankgk(BizCurrency.valueOf(Long.valueOf("1000001"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setMisyuup(BizCurrency.valueOf(Long.valueOf("-15"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setMikeikap(BizCurrency.valueOf(Long.valueOf("-16"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkamikeikap(BizCurrency.valueOf(Long.valueOf("1000002"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setHaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkahaitoukin(BizCurrency.valueOf(Long.valueOf("1000003"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setSonotahaitoukin(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setYenkasonotahaitoukin(BizCurrency.valueOf(Long.valueOf("1000004"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(BizCurrency.valueOf(Long.valueOf("10005"), BizCurrencyTypes.DOLLAR));
        siMeisaiCommonCalcBean.setZitkazukarikingkyen(BizCurrency.valueOf(Long.valueOf("1000006"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setYenkakrkgk(BizCurrency.valueOf(Long.valueOf("111111"), BizCurrencyTypes.YEN));
        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        siMeisaiCommonCalcBean.setSyouhinCd("BB");

        C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);
        BizCurrency shrmisisynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
        BizCurrency shrmisikztkgk = siMeisaiCommonCalc.getShrmisikztkgk();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(shrmisisynykngk, BizCurrency.valueOf(Long.valueOf("15837285")), "支払明細書収入金額");
        exBizCalcbleEquals(shrmisikztkgk, BizCurrency.valueOf(Long.valueOf("0")), "支払明細書課税対象金額");
    }
}
