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
import jp.co.slcs.swak.date.BizDateYM;

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
 * 配当支払チェック（入金取消）クラスのメソッド {@link CheckDShrNyukinTorikesi#checkDShr(String , BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDShrNyukinTorikesiTest_checkDShr {

    @Inject
    CheckDShrNyukinTorikesi checkDShrNyukinTorikesi;

    private C_ErrorKbn errorKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当支払チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckDSeigou.class).to(CheckDSeigouMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckDSeigouMockForHozen.caller = CheckDShrNyukinTorikesiTest_checkDShr.class;

    }

    @AfterClass
    public static void testClear() {

        CheckDSeigouMockForHozen.caller = null;

        CheckDSeigouMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDShrNyukinTorikesiTest_checkDShr.class, fileName, sheetName);
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

        errorKbn = checkDShrNyukinTorikesi.checkDShr(null, BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(20)
    public void testCheckDShr_A2() {

        errorKbn = checkDShrNyukinTorikesi.checkDShr("", BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");


    }

    @Test
    @TestOrder(30)
    public void testCheckDShr_A3() {

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111185", null, BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(40)
    public void testCheckDShr_A4() {

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111185", BizDateYM.valueOf(201804), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(50)
    public void testCheckDShr_A5() {

        errorKbn = checkDShrNyukinTorikesi.checkDShr(null, null, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");

    }

    @Test
    @TestOrder(60)
    public void testCheckDShr_A6() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111336", BizDateYM.valueOf(201812), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.NONE, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111336", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }

    @Test
    @TestOrder(70)
    public void testCheckDShr_A7() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111336", BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.ARI, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111336", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }

    @Test
    @TestOrder(80)
    public void testCheckDShr_A8() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111370", BizDateYM.valueOf(201802), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.ARI, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111370", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }

    @Test
    @TestOrder(90)
    public void testCheckDShr_A9() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111185", BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 2, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(1).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), null, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), null, "処理可否区分");

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
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111336", BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.ARI, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111336", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2020), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181201), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181130), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }

    @Test
    @TestOrder(110)
    public void testCheckDShr_A11() {


        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN3;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111451", BizDateYM.valueOf(201812), BizDate.valueOf(20171130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.NONE, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIKANOU, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.NONE, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111451", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2001), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20171230), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20171130), "処理年月日");

    }

    @Test
    @TestOrder(120)
    public void testCheckDShr_A12() {

        CheckDSeigouMockForHozen.SYORIPTN = CheckDSeigouMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        errorKbn = checkDShrNyukinTorikesi.checkDShr("11807111358", BizDateYM.valueOf(201804), BizDate.valueOf(20181130));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShrNyukinTorikesi.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShrNyukinTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHuseigouUmu(), C_UmuKbn.ARI, "配当不整合有無");
        exClassificationEquals(checkDShrNyukinTorikesi.getSyorikahiKbn(), C_SyorikahiKbn.SYORIHUKA, "処理可否区分");
        exClassificationEquals(checkDShrNyukinTorikesi.getDHaneiYmdUmu(), C_UmuKbn.NONE, "配当金反映日有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 0), "11807111358", "証券番号");
        exDateYEquals((BizDateY)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 1), BizDateY.valueOf(2021), "契約ＭＦ配当年度");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20181130), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20181230), "円建変更日");
        exDateEquals((BizDate)MockObjectManager.getArgument(CheckDSeigouMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181130), "処理年月日");

    }
}
