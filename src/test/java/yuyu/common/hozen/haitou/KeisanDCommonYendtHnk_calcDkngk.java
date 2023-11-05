package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
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
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.haitou.KeisanDCommonYendtHnk.NrkKmkYendtHnkNaibuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 配当共通計算（円建変更）のメソッド {@link KeisanDCommonYendtHnk#calcDkngk(String, BizDate, BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonYendtHnk_calcDkngk {

    @Inject
    private KeisanDCommonYendtHnk keisanDCommonYendtHnk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通計算";

    private final static String sheetName = "INデータ";

    private static final String SYONO = "18806000014";

    private static final BizDate CALCKIJYUNYMD = BizDate.valueOf(20170301);

    private static final BizDate DRATEKJYMD = BizDate.valueOf(20180506);

    private static final BizDate SYORIYMD = BizDate.valueOf(20181028);

    public static int kaisuu = 0;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(DBAccessDCommon.class).to(DBAccessDCommonMockForHozen.class);
                bind(SetDNnd.class).to(SetDNndMockForHozen.class);
                bind(KeisanDGanrikin.class).to(KeisanDGanrikinMockForHozen.class);
                bind(KeisanD.class).to(KeisanDMockForHozen.class);
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
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

        SetDNndMockForHozen.caller = KeisanDCommonYendtHnk_calcDkngk.class;
        KeisanDMockForHozen.caller = KeisanDCommonYendtHnk_calcDkngk.class;
        DBAccessDCommonMockForHozen.caller = KeisanDCommonYendtHnk_calcDkngk.class;
        KeisanDGanrikinMockForHozen.caller = KeisanDCommonYendtHnk_calcDkngk.class;
        SetHokenNndMockForHozen.caller = KeisanDCommonYendtHnk_calcDkngk.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.caller = null;
        SetDNndMockForHozen.SYORIPTN = null;
        DBAccessDCommonMockForHozen.caller = null;
        DBAccessDCommonMockForHozen.SYORIPTN = null;
        KeisanDGanrikinMockForHozen.caller = null;
        KeisanDMockForHozen.caller = null;
        KeisanDMockForHozen.SYORIPTN = null;
        SetHokenNndMockForHozen.caller = null;
        kaisuu = 0;
    }

    @Test
    @TestOrder(10)
    public void testCalcDkngk_A1() {

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(null, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testCalcDkngk_A2() {

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, null, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testCalcDkngk_A3() {

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, null, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testCalcDkngk_A4() {

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(50)
    public void testCalcDkngk_A5() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonYendtHnk.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(60)
    public void testCalcDkngk_A6() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN4;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonYendtHnk.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(70)
    public void testCalcDkngk_A7() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(80)
    public void testCalcDkngk_A8() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN3;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonYendtHnk.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(90)
    public void testCalcDkngk_A9() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN3;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), null, "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), null, "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(100)
    public void testCalcDkngk_A10() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), BizCurrency.valueOf(112), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), BizCurrency.valueOf(124), "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), BizDateY.valueOf(2020), "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 0), DRATEKJYMD, "基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(SetHokenNndMockForHozen.class, "exec", 0, 1), DRATEKJYMD, "判定日");
    }

    @Test
    @TestOrder(110)
    public void testCalcDkngk_A11() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, CALCKIJYUNYMD, DRATEKJYMD, SYORIYMD);
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonYendtHnk.getEditDshrTukiDKoumokuBean();
        NrkKmkYendtHnkNaibuBean nrkKmkYendtHnkNaibuBean = keisanDCommonYendtHnk.getNrkKmkYendtHnkNaibuBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), BizCurrency.valueOf(112), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), BizCurrency.valueOf(12), "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), BizDateY.valueOf(2020), "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");

        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getDkeisanhaitouKin(), BizCurrency.valueOf(100), "配当金計算配当金");
        exClassificationEquals(editDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn(), C_NaiteiKakuteiKbn.NAITEI, "配当金計算内定確定区分");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTkbtHaitou(), BizCurrency.valueOf(0), "特別配当");
        exDateYEquals(editDshrTukiDKoumokuBean.getHaitounendo2(), null, "配当年度２");
        exClassificationEquals(editDshrTukiDKoumokuBean.getHaitoukinsksKbn(), null, "配当金作成区分");
        exClassificationEquals(editDshrTukiDKoumokuBean.getHaitoumeisaikbn(), null, "配当明細区分");
        exDateYEquals(editDshrTukiDKoumokuBean.getFstkariwariatedNendo(), null, "初回仮割当Ｄ年度");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTounendod(), null, "当年度Ｄ");
        exClassificationEquals(editDshrTukiDKoumokuBean.getNaiteikakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(editDshrTukiDKoumokuBean.getKariwariatedshrYmd(), null, "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedruiGk2(), null, "仮割当Ｄ累計額２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedgngkknGk2(), null, "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedshrGk2(), null, "仮割当Ｄ支払額２");
        exDateEquals(editDshrTukiDKoumokuBean.getTumitatedtumitateYmd(), null, "積立Ｄ積立年月日");
        exClassificationEquals(editDshrTukiDKoumokuBean.getTumitatedsksKbn(), null, "積立Ｄ作成区分");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTumitated2(), null, "積立Ｄ２");
        exDateEquals(editDshrTukiDKoumokuBean.getTumitatedshrkrkYmd(), null, "積立Ｄ支払効力日");
        exClassificationEquals(editDshrTukiDKoumokuBean.getNaiteikakuteiKbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcKari(), BizCurrency.valueOf(12), "配当元利金計算（仮割当Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst() == null, true, "元利金計算仮割当Ｄ利率リスト");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcTumi(), BizCurrency.valueOf(12), "配当元利金計算（積立Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() == null, true, "元利金計算積立Ｄ利率リスト");
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf(20170301), "計算基準日");
        exDateEquals(editDshrTukiDKoumokuBean.getSyoriYmd2(), BizDate.valueOf(20181028), "処理年月日２");
        exDateEquals(editDshrTukiDKoumokuBean.getKinoubetukijyunYmd(), BizDate.valueOf(20180506), "機能別基準日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedruiGk(), BizCurrency.valueOf(112), "仮割当Ｄ累計額");
        exDateYEquals(editDshrTukiDKoumokuBean.getHaitounendo(), BizDateY.valueOf(2020), "配当年度");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTumitated(), BizCurrency.valueOf(12), "積立Ｄ");

        exStringEquals(nrkKmkYendtHnkNaibuBean.getSyono(), "18806000014", "証券番号");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getCalckijyunymd(), BizDate.valueOf(20170301), "計算基準日");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getDratekjymd(), BizDate.valueOf(20180506), "Ｄレート基準日");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getSyoriymd(), BizDate.valueOf(20181028), "処理年月日");

    }

    @Test
    @TestOrder(120)
    public void testCalcDkngk_A12() {

        MockObjectManager.initialize();
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonYendtHnk.getEditDshrTukiDKoumokuBean();

        assertNull(editDshrTukiDKoumokuBean);
    }

    @Test
    @TestOrder(130)
    public void testCalcDkngk_A13() {

        MockObjectManager.initialize();
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDMockForHozen.SYORIPTN = KeisanDMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonYendtHnk.calcDkngk(SYONO, BizDate.valueOf(20180830), BizDate.valueOf(20180830), BizDate.valueOf(20180830));
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonYendtHnk.getEditDshrTukiDKoumokuBean();
        NrkKmkYendtHnkNaibuBean nrkKmkYendtHnkNaibuBean = keisanDCommonYendtHnk.getNrkKmkYendtHnkNaibuBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getKariwariatedruigk(), BizCurrency.valueOf(-88), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonYendtHnk.getTumitated(), BizCurrency.valueOf(12), "積立Ｄ");
        exDateYEquals(keisanDCommonYendtHnk.getHaitouNendo(), BizDateY.valueOf(2020), "配当年度");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");

        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getDkeisanhaitouKin(), BizCurrency.valueOf(-100), "配当金計算配当金");
        exClassificationEquals(editDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当金計算内定確定区分");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTkbtHaitou(), BizCurrency.valueOf(0), "特別配当");
        exDateYEquals(editDshrTukiDKoumokuBean.getHaitounendo2(), null, "配当年度２");
        exClassificationEquals(editDshrTukiDKoumokuBean.getHaitoukinsksKbn(), null, "配当金作成区分");
        exClassificationEquals(editDshrTukiDKoumokuBean.getHaitoumeisaikbn(), null, "配当明細区分");
        exDateYEquals(editDshrTukiDKoumokuBean.getFstkariwariatedNendo(), null, "初回仮割当Ｄ年度");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTounendod(), null, "当年度Ｄ");
        exClassificationEquals(editDshrTukiDKoumokuBean.getNaiteikakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(editDshrTukiDKoumokuBean.getKariwariatedshrYmd(), null, "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedruiGk2(), null, "仮割当Ｄ累計額２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedgngkknGk2(), null, "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedshrGk2(), null, "仮割当Ｄ支払額２");
        exDateEquals(editDshrTukiDKoumokuBean.getTumitatedtumitateYmd(), null, "積立Ｄ積立年月日");
        exClassificationEquals(editDshrTukiDKoumokuBean.getTumitatedsksKbn(), null, "積立Ｄ作成区分");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTumitated2(), null, "積立Ｄ２");
        exDateEquals(editDshrTukiDKoumokuBean.getTumitatedshrkrkYmd(), null, "積立Ｄ支払効力日");
        exClassificationEquals(editDshrTukiDKoumokuBean.getNaiteikakuteiKbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcKari(), BizCurrency.valueOf(12), "配当元利金計算（仮割当Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst() == null, true, "元利金計算仮割当Ｄ利率リスト");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcTumi(), BizCurrency.valueOf(12), "配当元利金計算（積立Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() == null, true, "元利金計算積立Ｄ利率リスト");
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf(20180830), "計算基準日");
        exDateEquals(editDshrTukiDKoumokuBean.getSyoriYmd2(), BizDate.valueOf(20180830), "処理年月日２");
        exDateEquals(editDshrTukiDKoumokuBean.getKinoubetukijyunYmd(), BizDate.valueOf(20180830), "機能別基準日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedruiGk(), BizCurrency.valueOf(-88), "仮割当Ｄ累計額");
        exDateYEquals(editDshrTukiDKoumokuBean.getHaitounendo(), BizDateY.valueOf(2020), "配当年度");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getTumitated(), BizCurrency.valueOf(12), "積立Ｄ");

        exStringEquals(nrkKmkYendtHnkNaibuBean.getSyono(), "18806000014", "証券番号");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getCalckijyunymd(), BizDate.valueOf(20180830), "計算基準日");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getDratekjymd(), BizDate.valueOf(20180830), "Ｄレート基準日");
        exDateEquals(nrkKmkYendtHnkNaibuBean.getSyoriymd(), BizDate.valueOf(20180830), "処理年月日");

    }

}
