package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約前納一括払関連ユーティリティクラスのメソッド {@link SkZennouIkkatuUtil#getHaraikomiPTanni(String syusyouhncd,
 *     Integer syusyouhnsdno,C_Hrkkaisuu hrkkaisuu,C_Channelcd kiteichkchannelcd,String kiteichkoyadrtencd,
 *     C_Tuukasyu tuukasyu)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkZennouIkkatuUtilTest_getHaraikomiPTanni {

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
            testDataAndTblMap = testDataMaker.getInData(SkZennouIkkatuUtilTest_getHaraikomiPTanni.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkChannel());
    }

    @Test
    @TestOrder(10)
    public void testgetHaraikomiPTanni_A1() {

        String syusyouhncd = null;

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(20)
    public void testgetHaraikomiPTanni_A2() {

        String syusyouhncd = "";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(30)
    public void testgetHaraikomiPTanni_A3() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = null;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(40)
    public void testgetHaraikomiPTanni_A4() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 0;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(50)
    public void testgetHaraikomiPTanni_A5() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = -1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(60)
    public void testgetHaraikomiPTanni_A6() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = null;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(70)
    public void testgetHaraikomiPTanni_A7() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = null;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(80)
    public void testgetHaraikomiPTanni_A8() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "5102152";

        C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(90)
    public void testgetHaraikomiPTanni_A9() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.YUUSEIKANPO;

        String kiteichkoyadrtencd = "0000000";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(100)
    public void testgetHaraikomiPTanni_A10() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.SINKIN;

        String kiteichkoyadrtencd = "0000000";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(110)
    public void testgetHaraikomiPTanni_A11() {

        String syusyouhncd = "1002";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(0), "払込Ｐ単位");
    }

    @Test
    @TestOrder(120)
    public void testgetHaraikomiPTanni_A12() {

        String syusyouhncd = "1001";

        Integer syusyouhnsdno = 1;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.ITIJI;

        C_Channelcd kiteichkchannelcd = C_Channelcd.TIGIN;

        String kiteichkoyadrtencd = "0000000";

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;

        BizCurrency hrkptani = skZennouIkkatuUtil.getHaraikomiPTanni(syusyouhncd, syusyouhnsdno, hrkkaisuu,
            kiteichkchannelcd, kiteichkoyadrtencd, tuukasyu);

        exBizCalcbleEquals(hrkptani, BizCurrency.valueOf(125000), "払込Ｐ単位");
    }
}
