package yuyu.common.sinkeiyaku.skcommon;

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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
import yuyu.common.hozen.ascommon.KeisanZennouNyuukinGk2MockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil#getInRangeIkkatuTukiPSpecifiedIkkatuPYen(
        String pSyusyouhncd,Integer pSyusyouhnsdno,String pSyuryouritusdno,boolean pHrkptanityouseiflg,
        C_Channelcd pKiteichkchannelcd,String pKiteichkoyadrtencd,C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu,
        BizCurrency pTeikiikkatup)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen {

    @Inject
    private SkZennouIkkatuUtil skZennouIkkatuUtil;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約前納一括払関連ユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class);
                bind(KeisanZennouNyuukinGk2.class).to(KeisanZennouNyuukinGk2MockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedZennouPYen.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllIkkatuKeisuu());

        bizDomManager.delete(bizDomManager.getAllIkkatuTekiyouNo());

        bizDomManager.delete(bizDomManager.getAllZennouGenkaRitu());
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.caller = null;
        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A1() {

        BizDate kijyunymd = null;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A2() {

        BizDate kijyunymd = BizDate.valueOf("20180230");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A3() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A4() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A5() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A6() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A7() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A8() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = null;

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A9() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A10() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = null;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A11() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 0;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A12() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 1;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A13() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = null;

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(140)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A14() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(0);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(150)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A15() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(-1);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(160)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A16() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 98;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(170)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A17() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 10;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(180)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A18() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1021";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(190)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A19() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1002";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(100);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(200)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A20() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = false;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(250000), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(210)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A21() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1003";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(100);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(220)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A22() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1004";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(100);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(230)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A23() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN2;

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(240)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A24() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN6;
        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(250000), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(250)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A25() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1025";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(101);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(260)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A26() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN6;
        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1026";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(250000), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(270)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A27() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        KeisanZennouNyuukinGk2MockForSinkeiyaku.SYORIPTN = KeisanZennouNyuukinGk2MockForSinkeiyaku.TESTPATTERN6;
        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1027";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(249999), "定期１２か月一括払月払Ｐ");
    }

    @Test
    @TestOrder(280)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A28() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1028";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 96;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1011);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }
    @Test
    @TestOrder(290)
    public void testgetInRangeIkkatuTukiPSpecifiedZennouPYen_A29() {

        BizDate kijyunymd = BizDate.valueOf("20180201");

        String syusyouhncd = "1029";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        Integer znnkaisyonendo = 99;

        BizCurrency zennoupsyonendo = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatu12tkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedZennouPYen(kijyunymd,
            syusyouhncd, syusyouhnsdno, syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd,
            znnkaisyonendo, zennoupsyonendo);

        exBizCalcbleEquals(teikiikkatu12tkbrip, BizCurrency.valueOf(0), "定期１２か月一括払月払Ｐ");
    }
}
