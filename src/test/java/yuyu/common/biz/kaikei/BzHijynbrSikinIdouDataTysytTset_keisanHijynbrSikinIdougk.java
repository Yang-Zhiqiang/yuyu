package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HijynbrsikinidouyouKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 平準払資金移動データ抽出クラスのメソッド {@link BzHijynbrSikinIdouDataTysyt#getKhDenrenno} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk extends AbstractTest {

    @Inject
    private BzHijynbrSikinIdouDataTysyt bzHijynbrSikinIdouDataTysyt;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_平準払資金移動データ抽出";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData1() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzHijynbrSikinIdouDataTysytTset_keisanHijynbrSikinIdougk.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void testkeisanHijynbrSikinIdougk_A1() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        for (int i = 0; i < 2; i++) {

            bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);
        }

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(20)
    public void testkeisanHijynbrSikinIdougk_A2() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｺ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789, BizCurrencyTypes.YEN), "平準払資金移動金額");
    }

    @Test
    @TestOrder(30)
    public void testkeisanHijynbrSikinIdougk_A3() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000114");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(102879628.75, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(40)
    public void testkeisanHijynbrSikinIdougk_A4() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111118");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(102879628.75, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(50)
    public void testkeisanHijynbrSikinIdougk_A5() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111141");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(60)
    public void testkeisanHijynbrSikinIdougk_A6() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111129");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(70)
    public void testkeisanHijynbrSikinIdougk_A7() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111130");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(37037036703.69, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(80)
    public void testkeisanHijynbrSikinIdougk_A8() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");

    }

    @Test
    @TestOrder(90)
    public void testkeisanHijynbrSikinIdougk_A9() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111141");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(100)
    public void testkeisanHijynbrSikinIdougk_A10() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        for (int i = 0; i < 2; i++) {

            bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);
        }

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(110)
    public void testkeisanHijynbrSikinIdougk_A11() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111222");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD);
        btDenpyoData.setSyoricd("RB10");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｺ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");

    }

    @Test
    @TestOrder(120)
    public void testkeisanHijynbrSikinIdougk_A12() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111129");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        for (int i = 0; i < 2; i++) {

            bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);
        }

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(130)
    public void testkeisanHijynbrSikinIdougk_A13() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111129");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(140)
    public void testkeisanHijynbrSikinIdougk_A14() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("12806000306");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("RC05");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        for (int i = 0; i < 2; i++) {

            bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);
        }

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(24691357802.46, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(150)
    public void testkeisanHijynbrSikinIdougk_A15() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("12806000177");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(160)
    public void testkeisanHijynbrSikinIdougk_A16() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(170)
    public void testkeisanHijynbrSikinIdougk_A17() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(180)
    public void testkeisanHijynbrSikinIdougk_A18() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("60806000011");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(190)
    public void testkeisanHijynbrSikinIdougk_A19() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111233");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(1234567.89, BizCurrencyTypes.DOLLAR));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(200)
    public void testkeisanHijynbrSikinIdougk_A20() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(210)
    public void testkeisanHijynbrSikinIdougk_A21() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(220)
    public void testkeisanHijynbrSikinIdougk_A22() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(0));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(230)
    public void testkeisanHijynbrSikinIdougk_A23() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(240)
    public void testkeisanHijynbrSikinIdougk_A24() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(250)
    public void testkeisanHijynbrSikinIdougk_A25() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(260)
    public void testkeisanHijynbrSikinIdougk_A26() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(270)
    public void testkeisanHijynbrSikinIdougk_A27() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(280)
    public void testkeisanHijynbrSikinIdougk_A28() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(290)
    public void testkeisanHijynbrSikinIdougk_A29() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(300)
    public void testkeisanHijynbrSikinIdougk_A30() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(310)
    public void testkeisanHijynbrSikinIdougk_A31() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("12806000074");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(320)
    public void testkeisanHijynbrSikinIdougk_A32() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("12806000085");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345678901.23, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(330)
    public void testkeisanHijynbrSikinIdougk_A33() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000301");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(340)
    public void testkeisanHijynbrSikinIdougk_A34() {

        BizDate syoriYmd = BizDate.valueOf("20160102");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000312");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }


    @Test
    @TestOrder(350)
    public void testkeisanHijynbrSikinIdougk_A35() {

        BizDate syoriYmd = BizDate.valueOf("20160103");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("16806000012");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(360)
    public void testkeisanHijynbrSikinIdougk_A36() {

        BizDate syoriYmd = BizDate.valueOf("20160104");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000323");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(370)
    public void testkeisanHijynbrSikinIdougk_A37() {

        BizDate syoriYmd = BizDate.valueOf("20160103");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("10000000000000000003");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000013");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }
    @Test
    @TestOrder(380)
    public void testkeisanHijynbrSikinIdougk_A38() {

        BizDate syoriYmd = BizDate.valueOf("20160105");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("10000000000000000005");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000024");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(390)
    public void testkeisanHijynbrSikinIdougk_A39() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111196");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(12345679024.68, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(400)
    public void testkeisanHijynbrSikinIdougk_A40() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("17806000297");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOUP, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(2057.50, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(410)
    public void testkeisanHijynbrSikinIdougk_A41() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(420)
    public void testkeisanHijynbrSikinIdougk_A42() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(430)
    public void testkeisanHijynbrSikinIdougk_A43() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(440)
    public void testkeisanHijynbrSikinIdougk_A44() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｹ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.YOU, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(123456789), "平準払資金移動金額");
    }

    @Test
    @TestOrder(450)
    public void testkeisanHijynbrSikinIdougk_A45() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｺ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(460)
    public void testkeisanHijynbrSikinIdougk_A46() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｻ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(470)
    public void testkeisanHijynbrSikinIdougk_A47() {

        BizDate syoriYmd = BizDate.valueOf("20201229");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("20000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｻ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSkDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(480)
    public void testkeisanHijynbrSikinIdougk_A48() {

        BizDate syoriYmd = BizDate.valueOf("20201230");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｻ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSkDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.BLNK, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }

    @Test
    @TestOrder(490)
    public void testkeisanHijynbrSikinIdougk_A49() {

        BizDate syoriYmd = BizDate.valueOf("20201225");
        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        BT_DenpyoData btDenpyoData = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData.setDenrenno("30000000000000000002");
        btDenpyoData.setEdano(1);
        btDenpyoData.setKeirisyono("11807111152");
        btDenpyoData.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData.setKanjyoukmkcd(C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD);
        btDenpyoData.setSyoricd("3001");
        btDenpyoData.setKyktuukasyu(C_Tuukasyu.USD);
        btDenpyoData.setKeiyakutuukagk(BizCurrency.valueOf(123456789));
        btDenpyoData.setSyusyouhncd("ﾕｻ");

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();
        bzHijynbrSikinIdouDataTysyt.getSkDenrenno();

        bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

        exClassificationEquals(btDenpyoData.getHijynbrsikinidouyoukbn(), C_HijynbrsikinidouyouKbn.HI, " 平準払資金移動要区分");
        exBizCalcbleEquals(btDenpyoData.getHijynbrsikinidougk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "平準払資金移動金額");
    }
}
