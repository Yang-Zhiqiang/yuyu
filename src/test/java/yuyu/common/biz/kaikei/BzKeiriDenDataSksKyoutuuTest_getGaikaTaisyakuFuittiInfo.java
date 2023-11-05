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
import yuyu.common.base.BaseUserInfo;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 経理伝票データ作成共通処理クラスのメソッド {@link BzKeiriDenDataSksKyoutuu#getGaikaTaisyakuFuittiInfo(List<BT_DenpyoData> )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKeiriDenDataSksKyoutuuTest_getGaikaTaisyakuFuittiInfo extends AbstractTest {

    @Inject
    private BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_経理伝票データ作成共通処理";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzKeiriDenDataSksKyoutuuTest_changeGaikaData.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    public void testGetGaikaTaisyakuFuittiInfo_A1() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData btDenpyoData1 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData1.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData1.setDenrenno("30000000000000000001");
        btDenpyoData1.setEdano(1);
        btDenpyoData1.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData1.setKakokawaserateshiteiflg(true);
        btDenpyoData1.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData1.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData1.setDengaikagk(BizCurrency.valueOf(101, BizCurrencyTypes.EURO));
        btDenpyoData1.setTaisyakutyouseiflg(false);
        btDenpyoData1.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData2 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData2.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData2.setDenrenno("30000000000000000001");
        btDenpyoData2.setEdano(2);
        btDenpyoData2.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData2.setKakokawaserateshiteiflg(true);
        btDenpyoData2.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData2.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData2.setDengaikagk(BizCurrency.valueOf(99, BizCurrencyTypes.EURO));
        btDenpyoData2.setTaisyakutyouseiflg(true);
        btDenpyoData2.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData3 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData3.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData3.setDenrenno("30000000000000000001");
        btDenpyoData3.setEdano(3);
        btDenpyoData3.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData3.setKakokawaserateshiteiflg(true);
        btDenpyoData3.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData3.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData3.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData3.setTaisyakutyouseiflg(true);
        btDenpyoData3.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData4 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData4.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData4.setDenrenno("30000000000000000001");
        btDenpyoData4.setEdano(4);
        btDenpyoData4.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData4.setKakokawaserateshiteiflg(true);
        btDenpyoData4.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData4.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData4.setDengaikagk(BizCurrency.valueOf(102, BizCurrencyTypes.EURO));
        btDenpyoData4.setTaisyakutyouseiflg(false);
        btDenpyoData4.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData5 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData5.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData5.setDenrenno("30000000000000000001");
        btDenpyoData5.setEdano(5);
        btDenpyoData5.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData5.setKakokawaserateshiteiflg(true);
        btDenpyoData5.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData5.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData5.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData5.setTaisyakutyouseiflg(false);
        btDenpyoData5.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData6 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData6.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData6.setDenrenno("30000000000000000001");
        btDenpyoData6.setEdano(6);
        btDenpyoData6.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData6.setKakokawaserateshiteiflg(true);
        btDenpyoData6.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData6.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData6.setDengaikagk(BizCurrency.valueOf(98, BizCurrencyTypes.EURO));
        btDenpyoData6.setTaisyakutyouseiflg(true);
        btDenpyoData6.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData7 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData7.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData7.setDenrenno("30000000000000000001");
        btDenpyoData7.setEdano(7);
        btDenpyoData7.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData7.setKakokawaserateshiteiflg(true);
        btDenpyoData7.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData7.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData7.setDengaikagk(BizCurrency.valueOf(99, BizCurrencyTypes.EURO));
        btDenpyoData7.setTaisyakutyouseiflg(true);
        btDenpyoData7.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData8 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData8.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData8.setDenrenno("30000000000000000001");
        btDenpyoData8.setEdano(8);
        btDenpyoData8.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData8.setKakokawaserateshiteiflg(true);
        btDenpyoData8.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData8.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData8.setDengaikagk(BizCurrency.valueOf(101, BizCurrencyTypes.EURO));
        btDenpyoData8.setTaisyakutyouseiflg(false);
        btDenpyoData8.setKeirisyono("18807000017");

        BT_DenpyoData btDenpyoData9 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData9.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData9.setDenrenno("30000000000000000002");
        btDenpyoData9.setEdano(1);
        btDenpyoData9.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData9.setKakokawaserateshiteiflg(true);
        btDenpyoData9.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData9.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData9.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData9.setTaisyakutyouseiflg(true);
        btDenpyoData9.setKeirisyono("18807000028");

        BT_DenpyoData btDenpyoData10 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData10.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData10.setDenrenno("30000000000000000002");
        btDenpyoData10.setEdano(2);
        btDenpyoData10.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData10.setKakokawaserateshiteiflg(true);
        btDenpyoData10.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData10.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData10.setDengaikagk(BizCurrency.valueOf(110, BizCurrencyTypes.EURO));
        btDenpyoData10.setTaisyakutyouseiflg(true);
        btDenpyoData10.setKeirisyono("18807000028");

        BT_DenpyoData btDenpyoData11 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData11.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData11.setDenrenno("30000000000000000003");
        btDenpyoData11.setEdano(1);
        btDenpyoData11.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData11.setKakokawaserateshiteiflg(true);
        btDenpyoData11.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData11.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData11.setDengaikagk(BizCurrency.valueOf(200, BizCurrencyTypes.EURO));
        btDenpyoData11.setTaisyakutyouseiflg(false);
        btDenpyoData11.setKeirisyono("18807000039");

        BT_DenpyoData btDenpyoData12 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData12.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData12.setDenrenno("30000000000000000003");
        btDenpyoData12.setEdano(2);
        btDenpyoData12.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData12.setKakokawaserateshiteiflg(true);
        btDenpyoData12.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData12.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData12.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData12.setTaisyakutyouseiflg(false);
        btDenpyoData12.setKeirisyono("18807000039");

        BT_DenpyoData btDenpyoData13 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData13.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData13.setDenrenno("30000000000000000003");
        btDenpyoData13.setEdano(3);
        btDenpyoData13.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData13.setKakokawaserateshiteiflg(true);
        btDenpyoData13.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData13.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData13.setDengaikagk(BizCurrency.valueOf(110, BizCurrencyTypes.EURO));
        btDenpyoData13.setTaisyakutyouseiflg(false);
        btDenpyoData13.setKeirisyono("18807000039");

        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData1);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData2);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData3);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData4);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData5);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData6);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData7);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData8);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData9);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData10);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData11);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData12);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData13);

        List<BzTaisyakuFuittiInfoBean> bzTaisyakuFuittiInfoBeanList = bzKeiriDenDataSksKyoutuu
            .getGaikaTaisyakuFuittiInfo();

        exNumericEquals(bzTaisyakuFuittiInfoBeanList.size(), 3, "件数");
        exClassificationEquals(bzTaisyakuFuittiInfoBeanList.get(0).getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(bzTaisyakuFuittiInfoBeanList.get(0).getDenrenNo(), "30000000000000000003", "伝票データ連番");
        exNumericEquals(bzTaisyakuFuittiInfoBeanList.get(0).getEdaNo(), 3, "枝番号");
        exBizCalcbleEquals(bzTaisyakuFuittiInfoBeanList.get(0).getKagk(), BizCurrency.valueOf(2400), "金額");
        exClassificationEquals(bzTaisyakuFuittiInfoBeanList.get(1).getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(bzTaisyakuFuittiInfoBeanList.get(1).getDenrenNo(), "30000000000000000002", "伝票データ連番");
        exNumericEquals(bzTaisyakuFuittiInfoBeanList.get(1).getEdaNo(), 1, "枝番号");
        exBizCalcbleEquals(bzTaisyakuFuittiInfoBeanList.get(1).getKagk(), BizCurrency.valueOf(880), "金額");
        exClassificationEquals(bzTaisyakuFuittiInfoBeanList.get(2).getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(bzTaisyakuFuittiInfoBeanList.get(2).getDenrenNo(), "30000000000000000001", "伝票データ連番");
        exNumericEquals(bzTaisyakuFuittiInfoBeanList.get(2).getEdaNo(), 7, "枝番号");
        exBizCalcbleEquals(bzTaisyakuFuittiInfoBeanList.get(2).getKagk(), BizCurrency.valueOf(824), "金額");
    }

    @Test
    @TestOrder(20)
    public void testGetGaikaTaisyakuFuittiInfo_A2() {

        BizDate syoriYmd = BizDate.valueOf("20160101");
        AM_User aMUser = new AM_User();
        aMUser.setUserId("user01");
        BaseUserInfo baseUserInfo = new BaseUserInfo(aMUser);
        bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

        BT_DenpyoData btDenpyoData1 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData1.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData1.setDenrenno("30000000000000000001");
        btDenpyoData1.setEdano(1);
        btDenpyoData1.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        btDenpyoData1.setKakokawaserateshiteiflg(true);
        btDenpyoData1.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData1.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData1.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData1.setTaisyakutyouseiflg(false);
        btDenpyoData1.setKeirisyono("18807000040");

        BT_DenpyoData btDenpyoData2 = SWAKInjector.getInstance(BT_DenpyoData.class);
        btDenpyoData2.setDensyskbn(C_DensysKbn.SKEI);
        btDenpyoData2.setDenrenno("30000000000000000001");
        btDenpyoData2.setEdano(2);
        btDenpyoData2.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        btDenpyoData2.setKakokawaserateshiteiflg(true);
        btDenpyoData2.setKakokawaserateshiteiymd(BizDate.valueOf("20160110"));
        btDenpyoData2.setTuukasyu(C_Tuukasyu.EUR);
        btDenpyoData2.setDengaikagk(BizCurrency.valueOf(100, BizCurrencyTypes.EURO));
        btDenpyoData2.setTaisyakutyouseiflg(false);
        btDenpyoData2.setKeirisyono("18807000040");

        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData1);
        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData2);

        List<BzTaisyakuFuittiInfoBean> bzTaisyakuFuittiInfoBeanList = bzKeiriDenDataSksKyoutuu
            .getGaikaTaisyakuFuittiInfo();

        exNumericEquals(bzTaisyakuFuittiInfoBeanList.size(), 0, "件数");

        changeSystemDate(BizDate.getSysDate());

    }
}
