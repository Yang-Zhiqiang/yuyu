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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点契約基本情報取得のメソッド {@link SrGetTokutejitenKykKihonInfo#exec(String, BizDate,
        List<SV_KiykSyuhnData> ,C_TkiktbrisyuruiKbn ,String )} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenKykKihonInfoTest_exec {

    @Inject
    SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書_特定時点契約基本情報取得";

    private final static String sheetName = "INデータ";

    @Inject
    private SuuriDomManager suuriDomManager;
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrGetTokutejitenKykKihonInfoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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
    @TestOrder(10)
    public void testExec_A1() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN;
        String pSyono = "17806000013";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.BLNK, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.BLNK, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN;
        String pSyono = "17806000024";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.DANTAI, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.DANTAI, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN;
        String pSyono = "17806000035";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.SYUUDAN, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.SYUUDAN, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.TUKI, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.TUKI, "払込回数（後）");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNARI;
        String pSyono = "17806000046";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.HURIKAE, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.DANTAI, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI;
        String pSyono = "17806000057";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = null;
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.BLNK, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.BLNK, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.BLNK;
        String pSyono = "17806000068";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.BLNK, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.BLNK, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN;
        String pSyono = "17806000079";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.BLNK, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.BLNK, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN;
        String pSyono = "17806000080";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "003";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.BLNK, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.BLNK, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI;
        String pSyono = "17806000091";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "002";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.DANTAI, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.SYUUDAN, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.BLNK, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.BLNK, "払込回数（後）");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNNASI_KAISUUHNARI;
        String pSyono = "17806000105";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "001";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.DANTAI, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.DANTAI, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.TUKI, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.HALFY, "払込回数（後）");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI;
        String pSyono = "17806000116";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "001";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.DANTAI, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.SYUUDAN, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.TUKI, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.TUKI, "払込回数（後）");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI;
        String pSyono = "17806000127";
        BizDate pKijyunYmd = BizDate.valueOf(20180505);
        String pHenkousikibetuke = "001";
        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, C_SyutkKbn.SYU);
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn = C_TkiktbrisyuruiKbn.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            kykKihonTokuteiJitenKbn, pSyono, pKijyunYmd, pHenkousikibetuke, kiykSyuhnDataLst, pTikiktbrisyuruikbn,
            hrkkeiro, hrkkaisuu);

        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae(), C_Hrkkeiro.KOUHURI, "払込経路（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto(), C_Hrkkeiro.CREDIT, "払込経路（後）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae(), C_Hrkkaisuu.TUKI, "払込回数（前）");
        exClassificationEquals(srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto(), C_Hrkkaisuu.TUKI, "払込回数（後）");
    }
}
