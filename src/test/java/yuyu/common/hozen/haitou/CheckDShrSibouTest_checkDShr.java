package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当支払チェック（死亡）クラスのメソッド {@link CheckDShrSibou#checkDShr(String , BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDShrSibouTest_checkDShr {

    @Inject
    CheckDShrSibou checkDShrSibou;

    private C_ErrorKbn errorKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当支払チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckDSeigou.class).to(CheckDSeigouMockForHozen.class);
                bind(CheckDJyoutai.class).to(CheckDJyoutaiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckDSeigouMockForHozen.caller = CheckDShrSibouTest_checkDShr.class;
        CheckDJyoutaiMockForHozen.caller = CheckDShrSibouTest_checkDShr.class;

    }

    @AfterClass
    public static void testClear() {

        CheckDSeigouMockForHozen.caller = null;
        CheckDJyoutaiMockForHozen.caller = null;


        CheckDSeigouMockForHozen.SYORIPTN = null;
        CheckDJyoutaiMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDShrSibouTest_checkDShr.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllKhHaitouKanri());
        hozenDomManager.delete(hozenDomManager.getAllKhTumitateDKanri());
    }

    @Test
    @TestOrder(10)
    public void testCheckDShr_A1() {

        errorKbn = checkDShrSibou.checkDShr(null, BizDate.valueOf(20180401), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(20)
    public void testCheckDShr_A2() {

        errorKbn = checkDShrSibou.checkDShr("", BizDate.valueOf(20180401), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");


    }

    @Test
    @TestOrder(30)
    public void testCheckDShr_A3() {

        errorKbn = checkDShrSibou.checkDShr("11807111185", null, BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(40)
    public void testCheckDShr_A4() {

        errorKbn = checkDShrSibou.checkDShr("11807111185", BizDate.valueOf(20180401), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(50)
    public void testCheckDShr_A5() {

        errorKbn = checkDShrSibou.checkDShr(null, null, BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(60)
    public void testCheckDShr_A6() {

        errorKbn = checkDShrSibou.checkDShr(null, BizDate.valueOf(20180401), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(70)
    public void testCheckDShr_A7() {

        errorKbn = checkDShrSibou.checkDShr("11807111185", null, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(80)
    public void testCheckDShr_A8() {

        errorKbn = checkDShrSibou.checkDShr(null, null, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(90)
    public void testCheckDShr_A9() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111185", BizDate.valueOf(20181001), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 2, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(1).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111185", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2019), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181001), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20180901), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }

    @Test
    @TestOrder(100)
    public void testCheckDShr_A10() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111336", BizDate.valueOf(20181201), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.NONE, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.ARI, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111336", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181201), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181130), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2020), "配当年度");

    }

    @Test
    @TestOrder(110)
    public void testCheckDShr_A11() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111347", BizDate.valueOf(20181202), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.ARI, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.NONE, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111347", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181202), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181230), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2021), "配当年度");

    }

    @Test
    @TestOrder(120)
    public void testCheckDShr_A12() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111358", BizDate.valueOf(20181230), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.NONE, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.NONE, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111358", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181230), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181230), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2021), "配当年度");


    }

    @Test
    @TestOrder(130)
    public void testCheckDShr_A13() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111358", BizDate.valueOf(20181201), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.ARI, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.NONE, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111358", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181201), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181230), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2021), "配当年度");

    }

    @Test
    @TestOrder(140)
    public void testCheckDShr_A14() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111369", BizDate.valueOf(20181201), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.ARI, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.ARI, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111369", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181201), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181230), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2021), "配当年度");

    }

    @Test
    @TestOrder(150)
    public void testCheckDShr_A15() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111370", BizDate.valueOf(20181230), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.NONE, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.ARI, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111370", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181230), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181230), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2021), "配当年度");

    }

    @Test
    @TestOrder(160)
    public void testCheckDShr_A16() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111381", BizDate.valueOf(20181201), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), C_UmuKbn.NONE, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIKANOU, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), C_UmuKbn.NONE, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111381", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181201), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181130), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2020), "配当年度");

    }

    @Test
    @TestOrder(170)
    public void testCheckDShr_A17() {

        errorKbn = checkDShrSibou.checkDShr("11807111381", BizDate.valueOf(20181130), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), C_SyorikahiKbn.SYORIKANOU, "処理可否区分");

    }

    @Test
    @TestOrder(180)
    public void testCheckDShr_A18() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        CheckDJyoutaiMockForHozen.SYORIPTN = CheckDJyoutaiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = checkDShrSibou.checkDShr("11807111381", BizDate.valueOf(20181201), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrSibou.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 2, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(1).getKinouId(), checkDShrSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrSibou.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrSibou.getMihaneiDUmu(), null, "未反映配当金有無");
        exClassificationEquals(checkDShrSibou.getSyorikahiKbn(), null, "処理可否区分");
        exClassificationEquals(checkDShrSibou.getDShrYmdUmu(), null, "配当金支払日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111381", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 0),
            BizDate.valueOf(20181201), "判定基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 1),
            BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 2),
            BizDate.valueOf(20181130), "円建変更日");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDJyoutaiMockForHozen.class, "execForMibaraiHaitouHantei", 0, 3),
            BizDateY.valueOf(2020), "配当年度");

    }
}
