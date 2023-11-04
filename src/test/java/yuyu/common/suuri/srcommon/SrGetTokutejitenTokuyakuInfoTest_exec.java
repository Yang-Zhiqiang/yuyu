package yuyu.common.suuri.srcommon;

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

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点その他特約情報取得のメソッド {@link SrGetTokutejitenTokuyakuInfo#exec(C_GetTaisyouSonotaTokuyakuKbn,
        C_SonotaTkTokuteiJitenKbn, BizDate, String, C_SuuriIdoKbn, String, BizDate, List<SV_KiykSyuhnData>,
        BizDate, List<IT_KykSyouhnHnkmae>, C_UmuKbn, BizCurrency, C_UmuKbn, Integer, BizCurrency, BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenTokuyakuInfoTest_exec {

    @Inject
    SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_特定時点その他特約情報取得";

    private final static String sheetName = "INデータ";

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public static void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenTokuyakuInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertTestData2() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenTokuyakuInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykSyouhnHnkmae());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }


    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        insertTestData1();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SINENGAPPISEITEISEI;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(12345), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.MOKUHYOURITUHENKOU;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASI;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASITRKS;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.TEIRITUITEN;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.TEIRITUITENTRKS;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOU;
        String pHenkousikibetukey = "0011";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(12345), "初期死亡時円換算最低保証額（前）");
        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkAto(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（後）");

        deleteTestData();

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
        String pHenkousikibetukey = "0011";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 0;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkMae(),
            BizCurrency.valueOf(0), "初期死亡時円換算最低保証額（前）");
        exBizCalcbleEquals(srgettokuteijitentokuyakuinfobean.getInitsbjiyenkasaiteihsygkAto(),
            BizCurrency.valueOf(12345), "初期死亡時円換算最低保証額（後）");

        deleteTestData();

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        insertTestData1();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SINENGAPPISEITEISEI;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(100);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            101, "ターゲット特約目標値（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASI;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(100);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            0, "ターゲット特約目標値（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASITRKS;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(100);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            0, "ターゲット特約目標値（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.TEIRITUITEN;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(100);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            0, "ターゲット特約目標値（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.TEIRITUITENTRKS;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(100);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            0, "ターゲット特約目標値（前）");

        deleteTestData();

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOU;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            10, "ターゲット特約目標値（前）");
        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiAto(),
            0, "ターゲット特約目標値（後）");

        deleteTestData();

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        insertTestData2();

        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn = C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU;
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn = C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET;
        BizDate pKijyunYmd = null;
        String pSyono = "17806000013";
        C_SuuriIdoKbn pSuuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
        String pHenkousikibetukey = "0010";
        BizDate pKouryokuhasseiymd = BizDate.valueOf(20180614);
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();
        BizDate pYendthnkymd = null;
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst = hozenDomManager.getAllKykSyouhnHnkmae();
        C_UmuKbn pInitsbjiyensitihsytkhukaumu = C_UmuKbn.ARI;
        BizCurrency pInitsbjiyenkasaiteihsygk = BizCurrency.valueOf(1000);
        C_UmuKbn pTargettkhkumu = C_UmuKbn.ARI;
        Integer pTargettkmokuhyouti = 10;
        BizCurrency pTargettkykkijyungk = BizCurrency.valueOf(0);
        BizDate pTargettkykkykhenkoymd = null;

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);
        srgettokuteijitentokuyakuinfobean = srGetTokutejitenTokuyakuInfo.exec(pGetTaisyouSonotaTokuyakuKbn,
            pSonotaTkTokuteiJitenKbn,
            pKijyunYmd,
            pSyono,
            pSuuriIdoKbn,
            pHenkousikibetukey,
            pKouryokuhasseiymd,
            pSV_KiykSyuhnDataLst,
            pYendthnkymd,
            pIT_KykSyouhnHnkmaeLst,
            pInitsbjiyensitihsytkhukaumu,
            pInitsbjiyenkasaiteihsygk,
            pTargettkhkumu,
            pTargettkmokuhyouti,
            pTargettkykkijyungk,
            pTargettkykkykhenkoymd);

        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiMae(),
            0, "ターゲット特約目標値（前）");
        exNumericEquals(srgettokuteijitentokuyakuinfobean.getTargettkmokuhyoutiAto(),
            10, "ターゲット特約目標値（後）");

        deleteTestData();

    }

}
