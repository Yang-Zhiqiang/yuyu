package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 為替レート取得のメソッド{@link GetKawaseRate#exec(BizDate, C_KawaserateSyuruiKbn, C_Tuukasyu,C_Tuukasyu, C_KawasetekiyoKbn, C_KawasetsryKbn,
            C_YouhiKbn, C_YouhiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetKawaseRateTest_exec {
    @Inject
    private GetKawaseRate getKawaseRate;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_為替レート取得";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(GetKawaseRateTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        String jpql = "delete from " + "BM_KawaseRate";
        em.createJPQL(jpql).executeUpdate();

        testDataAndTblMap = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BizDate kwsrateKjYmd = null;
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = null;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = null;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = null;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = null;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = null;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = null;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160301);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.JPY;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = null;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }


    @Test
    @TestOrder(90)
    public void testExec_B1() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160305);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.JPY;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20160307), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(101), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_B2() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160305);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.JPY;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_B3() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160305);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.BLNK;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.BLNK;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20160304), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(102), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_B4() {
        BizDate kwsrateKjYmd = BizDate.valueOf(20160307);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
        C_Tuukasyu mototuuka = C_Tuukasyu.BLNK;
        C_Tuukasyu kanzantuuka = C_Tuukasyu.USD;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;
        C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.BLNK;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;

        C_ErrorKbn errorKbn = getKawaseRate.exec(kwsrateKjYmd, kawaserateSyuruiKbn, mototuuka, kanzantuuka,
            kawasetekiyoKbn, kawasetsryKbn,
            eigyoubiHoseiKbn, zenEigyoubiKsSyutokuYouhi);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExecFstPNyuukin_A1() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExecFstPNyuukin_A2() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(150)
    public void testExecFstPNyuukin_A3() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(160)
    public void testExecFstPNyuukin_A4() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_SysKbn syskbn = C_SysKbn.ESHIEN;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(170)
    public void testExecFstPNyuukin_A5() {
        BizDate ryousyuYmd = BizDate.valueOf(20190408);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(180)
    public void testExecFstPNyuukin_A6() {
        BizDate ryousyuYmd = BizDate.valueOf(20190410);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(190)
    public void testExecFstPNyuukin_A7() {
        BizDate ryousyuYmd = BizDate.valueOf(20190410);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(191)
    public void testExecFstPNyuukin_B1() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(192)
    public void testExecFstPNyuukin_B2() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.IKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(200)
    public void testExecFstPNyuukin_A8() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(210)
    public void testExecFstPNyuukin_A9() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(220)
    public void testExecFstPNyuukin_A10() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(230)
    public void testExecFstPNyuukin_A11() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_SysKbn syskbn = C_SysKbn.ESHIEN;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);


        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(231)
    public void testExecFstPNyuukin_B3() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(232)
    public void testExecFstPNyuukin_B4() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu keiyakutuuka = C_Tuukasyu.USD;
        C_Tuukasyu haraikomituuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_SysKbn syskbn = C_SysKbn.SKEI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.IKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execFstPNyuukin(ryousyuYmd, keiyakutuuka, haraikomituuka,
            zenEigyoubiKsSyutokuYouhi, hrkkaisuu, syskbn, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.11), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }


    @Test
    @TestOrder(240)
    public void testExecHyoukagk_A1() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;


        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(250)
    public void testExecHyoukagk_A2() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(260)
    public void testExecHyoukagk_A3() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(270)
    public void testExecHyoukagk_A4() {
        BizDate ryousyuYmd = BizDate.valueOf(20190408);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(280)
    public void testExecHyoukagk_A5() {
        BizDate ryousyuYmd = BizDate.valueOf(20190410);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(290)
    public void testExecHyoukagk_A6() {
        BizDate ryousyuYmd = BizDate.valueOf(20190410);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.YOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(291)
    public void testExecHyoukagk_B1() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(292)
    public void testExecHyoukagk_B2() {
        BizDate ryousyuYmd = BizDate.valueOf(20190409);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.IKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190409), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(113.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(300)
    public void testExecHyoukagk_A7() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), null, "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), null, "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(310)
    public void testExecHyoukagk_A8() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);
        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(320)
    public void testExecHyoukagk_A9() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(330)
    public void testExecHyoukagk_B3() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190405), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(115.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }


    @Test
    @TestOrder(340)
    public void testExecHyoukagk_B4() {
        BizDate ryousyuYmd = BizDate.valueOf(20190407);
        C_Tuukasyu mototuuka = C_Tuukasyu.USD;
        C_Tuukasyu knsntuuka = C_Tuukasyu.JPY;
        C_YouhiKbn zenEigyoubiKsSyutokuYouhi = C_YouhiKbn.HUYOU;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        C_UmuKbn zennouMousideumu = C_UmuKbn.ARI;
        C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.IKKATU;

        C_ErrorKbn errorKbn = getKawaseRate.execHyoukagk(ryousyuYmd, mototuuka, knsntuuka, zenEigyoubiKsSyutokuYouhi,
            hrkkaisuu, zennouMousideumu, ikkatubaraiKbn);

        exDateEquals(getKawaseRate.getKwsrateKjYmd(), BizDate.valueOf(20190408), "メンバ変数．為替レート基準日");
        exBizCalcbleEquals(getKawaseRate.getKawaserate(), BizNumber.valueOf(114.22), "メンバ変数．為替レート");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
}
