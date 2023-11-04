package yuyu.common.hozen.khcommon;

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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ZennouKessanHoyuuHanteiKekkaKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納決算保有契約判定クラスのメソッド {@link HanteiZennouKessanHoyuuKyk#exec(BizDate, String, BizDateYM,
 * IT_KykSyouhn, IT_KhTtdkRireki, List<IT_KhBikinkanri>,List<JT_SiBikinkanri>)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiZennouKessanHoyuuKykTest_exec {

    @Inject
    private HanteiZennouKessanHoyuuKyk hanteiZennouKessanHoyuuKyk;

    @Inject
    HozenDomManager hozenDomManager;

    @Inject
    SiharaiDomManager siharaiDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納決算保有契約判定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiZennouKessanHoyuuKykTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000013";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201804);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOUGAI, "保有判定結果区分");

        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        BizDate pKijyunYmd = BizDate.valueOf(20180228);
        String pSyono = "17806000024";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201802);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20181210), "計算基準年月日");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000035";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20181212), "計算基準年月日");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000046";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20181213), "計算基準年月日");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000057";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20181214), "計算基準年月日");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000068";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20181215), "計算基準年月日");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000079";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000080";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000091";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000105";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000116";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000127";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000138";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000149";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = hozenDomManager.getKhBikinkanrisBySyono(pSyono);
        List<JT_SiBikinkanri> pSiBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000150";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201802);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = new ArrayList<IT_KhBikinkanri>();
        List<JT_SiBikinkanri> pSiBikinkanriLst = new ArrayList<JT_SiBikinkanri>();

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }


    @Test
    @TestOrder(160)
    public void testExec_A16() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000161";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = new ArrayList<IT_KhBikinkanri>();
        List<JT_SiBikinkanri> pSiBikinkanriLst = new ArrayList<JT_SiBikinkanri>();

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        BizDate pKijyunYmd = BizDate.valueOf(20180316);
        String pSyono = "17806000172";
        BizDateYM pSkeikeijyouYm = BizDateYM.valueOf(201803);
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykSyouhn pKykSyouhn = pKykKihon.getKykSyouhns().get(0);
        IT_KhTtdkRireki pKhTtdkRireki = pKykKihon.getKhTtdkRirekis().get(0);
        List<IT_KhBikinkanri> pKhBikinkanriLst = new ArrayList<IT_KhBikinkanri>();
        List<JT_SiBikinkanri> pSiBikinkanriLst = new ArrayList<JT_SiBikinkanri>();

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = hanteiZennouKessanHoyuuKyk.exec(pKijyunYmd,
            pSyono,
            pSkeikeijyouYm,
            pKykSyouhn,
            pKhTtdkRireki,
            pKhBikinkanriLst,
            pSiBikinkanriLst);

        exClassificationEquals(hoyuuCheckKekkaKbn, C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU, "保有判定結果区分");
        exDateEquals(hanteiZennouKessanHoyuuKyk.getCalckijyunymd(), BizDate.valueOf(20180316), "計算基準年月日");

    }

}
