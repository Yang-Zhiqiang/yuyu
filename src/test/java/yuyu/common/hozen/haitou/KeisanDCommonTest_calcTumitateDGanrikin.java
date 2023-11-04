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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 配当共通計算のメソッド {@link KeisanDCommon#calcTumitateDGanrikin(String, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonTest_calcTumitateDGanrikin {

    @Inject
    private KeisanDCommon keisanDCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通計算";

    private final static String sheetName = "INデータ";

    private static final String SYONO = "18806000014";

    private static final BizDate CALCKIJYUNYMD = BizDate.valueOf(20170301);

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SetDNnd.class).to(SetDNndMockForHozen.class);
                bind(DBAccessDCommon.class).to(DBAccessDCommonMockForHozen.class);
                bind(KeisanDGanrikin.class).to(KeisanDGanrikinMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(CheckDSeigouTest_checkHaitoukanriTBL.class, fileName, sheetName);
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
    }

    @BeforeClass
    public static void testInit() {

        SetDNndMockForHozen.caller = KeisanDCommonTest_calcTumitateDGanrikin.class;
        DBAccessDCommonMockForHozen.caller = KeisanDCommonTest_calcTumitateDGanrikin.class;
        KeisanDGanrikinMockForHozen.caller = KeisanDCommonTest_calcTumitateDGanrikin.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.caller = null;
        SetDNndMockForHozen.SYORIPTN = null;
        DBAccessDCommonMockForHozen.caller = null;
        DBAccessDCommonMockForHozen.SYORIPTN = null;
        KeisanDGanrikinMockForHozen.caller = null;
        KeisanDGanrikinMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testCalcTumitateDGanrikin_A1() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(null, CALCKIJYUNYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testCalcTumitateDGanrikin_A2() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testCalcTumitateDGanrikin_A3() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, CALCKIJYUNYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class).getClass()
            .getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20120302), "契約日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20180901), "円建変更日");
        exStringEquals((String) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 2), SYONO, "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "exec", 0, 3), CALCKIJYUNYMD, "計算基準日");
    }

    @Test
    @TestOrder(40)
    public void testCalcTumitateDGanrikin_A4() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, CALCKIJYUNYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(KeisanDGanrikin.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exStringEquals((String) MockObjectManager.getArgument(DBAccessDCommonMockForHozen.class,
            "getKijyunymdTykzenTumitateDKanri", 0, 0), SYONO, "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(DBAccessDCommonMockForHozen.class,
            "getKijyunymdTykzenTumitateDKanri", 0, 1), BizDate.valueOf(20020305), "基準日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 0),
            BizCurrency.valueOf(0), "累計額");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20020203), "計算基準日自");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 2),
            BizDate.valueOf(20020305), "計算基準日至");
    }

    @Test
    @TestOrder(50)
    public void testCalcTumitateDGanrikin_A5() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, CALCKIJYUNYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() != null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() != null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 0),
            BizCurrency.valueOf(456), "累計額");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20020203), "計算基準日自");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "exec", 0, 2),
            BizDate.valueOf(20020305), "計算基準日至");
    }

    @Test
    @TestOrder(60)
    public void testCalcTumitateDGanrikin_A6() {

        MockObjectManager.initialize();

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, BizDate.valueOf(20000102));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        BizCurrency tumitateDGanrikin = keisanDCommon.getTumitateDGanrikin();
        exBizCalcbleEquals(tumitateDGanrikin, BizCurrency.valueOf(0), "配当元利金（積立Ｄ元利金）");
        List<BizNumber> tumitateDRiritu = keisanDCommon.getTumitateDRirituList();
        exBooleanEquals(tumitateDRiritu.size() == 0, true, "配当利率リスト（積立Ｄ元利金）");
    }

    @Test
    @TestOrder(210)
    public void testCalcTumitateDGanrikin_B1() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(null, CALCKIJYUNYMD, BizDate.valueOf(20170401));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(220)
    public void testCalcTumitateDGanrikin_B2() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, null, BizDate.valueOf(20170401));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(230)
    public void testCalcTumitateDGanrikin_B3() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, CALCKIJYUNYMD, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(240)
    public void testCalcTumitateDGanrikin_B4() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, BizDate.valueOf(20130304), BizDate.valueOf(20130302));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class).getClass()
            .getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "execCorrespoindingOverAYear", 0, 0),
            BizDate.valueOf(20120302), "契約日");
        exStringEquals((String) MockObjectManager.getArgument(SetDNndMockForHozen.class, "execCorrespoindingOverAYear", 0, 1), SYONO, "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "execCorrespoindingOverAYear", 0, 2), BizDate.valueOf(20130304), "計算基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetDNndMockForHozen.class, "execCorrespoindingOverAYear", 0, 3),
            BizDate.valueOf(20130302), "調整済計算基準日");
    }

    @Test
    @TestOrder(250)
    public void testCalcTumitateDGanrikin_B5() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin(SYONO, BizDate.valueOf(20130304), BizDate.valueOf(20130302));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommon.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(KeisanDGanrikin.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(260)
    public void testCalcTumitateDGanrikin_B6() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin("99806001010", BizDate.valueOf(20130304), BizDate.valueOf(20130303));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() != null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(),
            C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() != null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "execAllowOverAYear", 0, 0),
            BizCurrency.valueOf(456), "累計額");
        List<DRateBean> dRateBeanLst= (List<DRateBean>)MockObjectManager.getArgument(KeisanDGanrikinMockForHozen.class, "execAllowOverAYear", 0, 1);
        exStringEquals(dRateBeanLst.get(0).getDRateSyutokuInfoBean().getSyouhncd(), "ﾕｱ", "商品コード");
    }

    @Test
    @TestOrder(270)
    public void testCalcTumitateDGanrikin_B7() {

        MockObjectManager.initialize();

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin("99806001010", BizDate.valueOf(20130304), BizDate.valueOf(20130301));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        BizCurrency tumitateDGanrikin = keisanDCommon.getTumitateDGanrikin();
        exBizCalcbleEquals(tumitateDGanrikin, BizCurrency.valueOf(0), "配当元利金（積立Ｄ元利金）");
    }

    @Test
    @TestOrder(280)
    public void testCalcTumitateDGanrikin_B8() {

        C_ErrorKbn errorKbn = keisanDCommon.calcTumitateDGanrikin("", CALCKIJYUNYMD, BizDate.valueOf(20170401));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBooleanEquals(keisanDCommon.getKhTumitateDKanri() == null, true, "積立Ｄ管理TBLエンティティ");
        exClassificationEquals(keisanDCommon.getKhTumitateDKanriNaiteiKakuteiKbn(), null, "内定確定区分");
        exBooleanEquals(keisanDCommon.getKeyInfoKhTumitateDKanriBean() == null, true, "キー情報（積立Ｄ管理TBL）Bean");

        HaitouErrorInfo haitouErrorInfo = keisanDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }
}
