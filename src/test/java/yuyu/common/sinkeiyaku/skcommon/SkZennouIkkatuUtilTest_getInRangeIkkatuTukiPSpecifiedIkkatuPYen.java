package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
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
public class SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen {

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
            testDataAndTblMap = testDataMaker.getInData(SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class,
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

            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = SkZennouIkkatuUtilTest_getInRangeIkkatuTukiPSpecifiedIkkatuPYen.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllIkkatuKeisuu());

        bizDomManager.delete(bizDomManager.getAllIkkatuTekiyouNo());

        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A1() {

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A2() {

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A3() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A4() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A5() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A6() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = null;

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A7() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A8() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = null;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A9() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.BLNK;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A10() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU2;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A11() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU3;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A12() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU4;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A13() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU5;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(140)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A14() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU7;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(150)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A15() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU8;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(160)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A16() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU9;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(170)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A17() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU10;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(180)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A18() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU11;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(190)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A19() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = null;

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(200)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A20() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(0);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(210)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A21() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU6;

        BizCurrency teikiikkatup = BizCurrency.valueOf(-1);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(220)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A22() {

        String syusyouhncd = "1020";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(230)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A23() {

        String syusyouhncd = "1002";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(100);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(240)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A24() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = false;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(500000), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(250)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A25() {

        String syusyouhncd = "1003";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(100);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(260)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A26() {

        String syusyouhncd = "1004";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(100);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(270)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A27() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(280)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A28() {

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN6;

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(1000000);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(500000), "定期一括払月払Ｐ");
    }

    @Test
    @TestOrder(290)
    public void testgetInRangeIkkatuTukiPSpecifiedIkkatuPYen_A29() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        String syuryouritusdno = "101";

        boolean hrkptanityouseiflg = true;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu = C_IkkatubaraiKaisuuKbn.IKKATU12;

        BizCurrency teikiikkatup = BizCurrency.valueOf(100);

        BizCurrency teikiikkatutkbrip = skZennouIkkatuUtil.getInRangeIkkatuTukiPSpecifiedIkkatuPYen( syusyouhncd, syusyouhnsdno,
            syuryouritusdno, hrkptanityouseiflg, kiteichkchannelcd, kiteichkoyadrtencd, ikkatubaraikaisuu, teikiikkatup);

        exBizCalcbleEquals(teikiikkatutkbrip, BizCurrency.valueOf(0), "定期一括払月払Ｐ");
    }
}
