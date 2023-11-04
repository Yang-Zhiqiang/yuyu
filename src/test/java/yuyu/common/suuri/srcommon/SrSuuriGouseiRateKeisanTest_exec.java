package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SuuriKyoutuuErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理用合成レート計算クラスのメソッド {@link SrSuuriGouseiRateKeisan#exec(BizDate,C_Tuukasyu,BizNumber)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrSuuriGouseiRateKeisanTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_数理用合成レート計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSuuriGouseiRateKeisanTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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
    public void testExec_A1() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = null;

        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.USD;

        BizNumber pKurosuKawaseRate = BizNumber.valueOf(1);

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(),
            C_SuuriKyoutuuErrorKbn.INPUTERROR, "数理用共通エラー区分");

        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(0), "数理用合成レート");

        SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

        exDateEquals(setErrMessageInfoBean.getKwsrateKjYmd(), BizDate.valueOf("00000000"), "為替レート基準日");

        exClassificationEquals(setErrMessageInfoBean.getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.BLNK, "為替レート種類区分");

        exClassificationEquals(setErrMessageInfoBean.getMotoTuukasyu(), C_Tuukasyu.BLNK, "元通貨");

        exClassificationEquals(setErrMessageInfoBean.getKansanTuukasyu(), C_Tuukasyu.BLNK, "換算通貨");

        exClassificationEquals(setErrMessageInfoBean.getKawasetekiyoKbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");

        exClassificationEquals(setErrMessageInfoBean.getKawasetsryKbn(), C_KawasetsryKbn.BLNK, "為替手数料区分");

        exClassificationEquals(setErrMessageInfoBean.getEigyoubiHoseiKbn(), C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");

        exClassificationEquals(setErrMessageInfoBean.getYouhiKbn(), C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = BizDate.valueOf(20160307);

        C_Tuukasyu pHrktuukasyu = null;

        BizNumber pKurosuKawaseRate = BizNumber.valueOf(1);

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(),
            C_SuuriKyoutuuErrorKbn.INPUTERROR, "数理用共通エラー区分");

        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(0), "数理用合成レート");

        SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

        exDateEquals(setErrMessageInfoBean.getKwsrateKjYmd(), BizDate.valueOf("00000000"), "為替レート基準日");

        exClassificationEquals(setErrMessageInfoBean.getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.BLNK, "為替レート種類区分");

        exClassificationEquals(setErrMessageInfoBean.getMotoTuukasyu(), C_Tuukasyu.BLNK, "元通貨");

        exClassificationEquals(setErrMessageInfoBean.getKansanTuukasyu(), C_Tuukasyu.BLNK, "換算通貨");

        exClassificationEquals(setErrMessageInfoBean.getKawasetekiyoKbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");

        exClassificationEquals(setErrMessageInfoBean.getKawasetsryKbn(), C_KawasetsryKbn.BLNK, "為替手数料区分");

        exClassificationEquals(setErrMessageInfoBean.getEigyoubiHoseiKbn(), C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");

        exClassificationEquals(setErrMessageInfoBean.getYouhiKbn(), C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = BizDate.valueOf(20160307);

        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;

        BizNumber pKurosuKawaseRate = null;

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(),
            C_SuuriKyoutuuErrorKbn.INPUTERROR, "数理用共通エラー区分");

        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(0), "数理用合成レート");

        SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

        exDateEquals(setErrMessageInfoBean.getKwsrateKjYmd(), BizDate.valueOf("00000000"), "為替レート基準日");

        exClassificationEquals(setErrMessageInfoBean.getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.BLNK, "為替レート種類区分");

        exClassificationEquals(setErrMessageInfoBean.getMotoTuukasyu(), C_Tuukasyu.BLNK, "元通貨");

        exClassificationEquals(setErrMessageInfoBean.getKansanTuukasyu(), C_Tuukasyu.BLNK, "換算通貨");

        exClassificationEquals(setErrMessageInfoBean.getKawasetekiyoKbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");

        exClassificationEquals(setErrMessageInfoBean.getKawasetsryKbn(), C_KawasetsryKbn.BLNK, "為替手数料区分");

        exClassificationEquals(setErrMessageInfoBean.getEigyoubiHoseiKbn(), C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");

        exClassificationEquals(setErrMessageInfoBean.getYouhiKbn(), C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = BizDate.valueOf(20160307);

        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;

        BizNumber pKurosuKawaseRate = BizNumber.valueOf(0);

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(),
            C_SuuriKyoutuuErrorKbn.INPUTERROR, "数理用共通エラー区分");

        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(0), "数理用合成レート");

        SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

        exDateEquals(setErrMessageInfoBean.getKwsrateKjYmd(), BizDate.valueOf("00000000"), "為替レート基準日");

        exClassificationEquals(setErrMessageInfoBean.getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.BLNK, "為替レート種類区分");

        exClassificationEquals(setErrMessageInfoBean.getMotoTuukasyu(), C_Tuukasyu.BLNK, "元通貨");

        exClassificationEquals(setErrMessageInfoBean.getKansanTuukasyu(), C_Tuukasyu.BLNK, "換算通貨");

        exClassificationEquals(setErrMessageInfoBean.getKawasetekiyoKbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");

        exClassificationEquals(setErrMessageInfoBean.getKawasetsryKbn(), C_KawasetsryKbn.BLNK, "為替手数料区分");

        exClassificationEquals(setErrMessageInfoBean.getEigyoubiHoseiKbn(), C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");

        exClassificationEquals(setErrMessageInfoBean.getYouhiKbn(), C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = BizDate.valueOf(20170307);

        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.EUR;

        BizNumber pKurosuKawaseRate = BizNumber.valueOf(20.0001);

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(), C_SuuriKyoutuuErrorKbn.NONE,
            "数理用共通エラー区分");
        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(600.403002), "数理用合成レート");

        SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

        exDateEquals(setErrMessageInfoBean.getKwsrateKjYmd(), BizDate.valueOf("00000000"), "為替レート基準日");

        exClassificationEquals(setErrMessageInfoBean.getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.BLNK, "為替レート種類区分");

        exClassificationEquals(setErrMessageInfoBean.getMotoTuukasyu(), C_Tuukasyu.BLNK, "元通貨");

        exClassificationEquals(setErrMessageInfoBean.getKansanTuukasyu(), C_Tuukasyu.BLNK, "換算通貨");

        exClassificationEquals(setErrMessageInfoBean.getKawasetekiyoKbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");

        exClassificationEquals(setErrMessageInfoBean.getKawasetsryKbn(), C_KawasetsryKbn.BLNK, "為替手数料区分");

        exClassificationEquals(setErrMessageInfoBean.getEigyoubiHoseiKbn(), C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");

        exClassificationEquals(setErrMessageInfoBean.getYouhiKbn(), C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

        BizDate pKwsrateKjYmd = BizDate.valueOf(20170307);

        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;

        BizNumber pKurosuKawaseRate = BizNumber.valueOf(1);

        SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
            srSuuriGouseiRateKeisan.exec(pKwsrateKjYmd, pHrktuukasyu, pKurosuKawaseRate);

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getSuuriKyoutuuErrorKbn(),
            C_SuuriKyoutuuErrorKbn.KAWASERATEGETERROR, "数理用共通エラー区分");

        exBizCalcbleEquals(srSuuriGouseiRateKeisanBean.getSuuriGouseiRate(), BizNumber.valueOf(0), "数理用合成レート");

        exDateEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getKwsrateKjYmd(),
            BizDate.valueOf("20170307"), "計算基準日");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getKawaserateSyuruiKbn(),
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE, "為替レート種類区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getMotoTuukasyu(), C_Tuukasyu.JPY,
            "元通貨");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getKansanTuukasyu(), C_Tuukasyu.JPY,
            "換算通貨");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getKawasetekiyoKbn(),
            C_KawasetekiyoKbn.TTM, "為替適用区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getKawasetsryKbn(),
            C_KawasetsryKbn.JISSEIRATE, "為替手数料区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getEigyoubiHoseiKbn(),
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI, "営業日補正区分");

        exClassificationEquals(srSuuriGouseiRateKeisanBean.getErrMessageInfoBean().getYouhiKbn(), C_YouhiKbn.HUYOU,
            "前営業日為替レート取得要否");
    }
}
