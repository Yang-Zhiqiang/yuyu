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
import yuyu.common.hozen.haitou.KeisanDCommonSibou.NrkKmkSibouNaibuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 配当共通計算（死亡）のメソッド {@link KeisanDCommonSibou#calcDShrgk(String, BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonSibouTest_calcDShrgk {

    @Inject
    private KeisanDCommonSibou keisanDCommonSibou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通計算";

    private final static String sheetName = "INデータ";

    private static final String SYONO = "18806000014";

    private static final BizDate CALCKIJYUNYMD = BizDate.valueOf(20170301);

    private static final BizDate SYORIYMD = BizDate.valueOf(20180506);

    public static int kaisuu = 0;

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(NaiteiKakuteiRateHantei.class).to(NaiteiKakuteiRateHanteiMockForHozen.class);
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

        SetDNndMockForHozen.caller = KeisanDCommonSibouTest_calcDShrgk.class;
        DBAccessDCommonMockForHozen.caller = KeisanDCommonSibouTest_calcDShrgk.class;
        KeisanDGanrikinMockForHozen.caller = KeisanDCommonSibouTest_calcDShrgk.class;
        NaiteiKakuteiRateHanteiMockForHozen.caller = KeisanDCommonSibouTest_calcDShrgk.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.caller = null;
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = null;
        SetDNndMockForHozen.caller = null;
        SetDNndMockForHozen.SYORIPTN = null;
        DBAccessDCommonMockForHozen.caller = null;
        DBAccessDCommonMockForHozen.SYORIPTN = null;
        KeisanDGanrikinMockForHozen.caller = null;
        KeisanDGanrikinMockForHozen.SYORIPTN = null;
        kaisuu = 0;
    }

    @Test
    @TestOrder(10)
    public void testCalcDShrgk_A1() {

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(null, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testCalcDShrgk_A2() {

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, null, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testCalcDShrgk_A3() {

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testCalcDShrgk_A4() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonSibou.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exDateEquals((BizDate) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 0),
            SYORIYMD, "判定日");
        exDateYEquals((BizDateY) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class, "exec", 0, 1),
            BizDateY.valueOf(2016), "Ｄレート年度");
        exClassificationEquals((C_UmuKbn) MockObjectManager.getArgument(NaiteiKakuteiRateHanteiMockForHozen.class,
            "exec", 0, 2), C_UmuKbn.NONE, "決算使用有無");
    }

    @Test
    @TestOrder(50)
    public void testCalcDShrgk_A5() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonSibou.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(60)
    public void testCalcDShrgk_A6() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(70)
    public void testCalcDShrgk_A7() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), BizCurrency.valueOf(-1), "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(80)
    public void testCalcDShrgk_A8() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN4;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), BizCurrency.valueOf(0), "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(90)
    public void testCalcDShrgk_A9() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN5;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonSibou.getEditDshrTukiDKoumokuBean();
        NrkKmkSibouNaibuBean nrkKmkSibouNaibuBean = keisanDCommonSibou.getNrkKmkSibouNaibuBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), BizCurrency.valueOf(2), "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");

        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getDkeisanhaitouKin(), null, "配当金計算配当金");
        exClassificationEquals(editDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn(), null, "配当金計算内定確定区分");
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
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcKari(), BizCurrency.valueOf(1), "配当元利金計算（仮割当Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst() == null, true, "元利金計算仮割当Ｄ利率リスト");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcTumi(), BizCurrency.valueOf(1), "配当元利金計算（積立Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() == null, true, "元利金計算積立Ｄ利率リスト");
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf(20170301), "計算基準日");
        exDateEquals(editDshrTukiDKoumokuBean.getSyoriYmd2(), BizDate.valueOf(20180506), "処理年月日２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitoushrKin(), BizCurrency.valueOf(2), "配当支払金");

        exStringEquals(nrkKmkSibouNaibuBean.getSyono(), "18806000014", "証券番号");
        exDateEquals(nrkKmkSibouNaibuBean.getCalckijyunymd(), BizDate.valueOf(20170301), "計算基準日");
        exDateEquals(nrkKmkSibouNaibuBean.getSyoriymd(), BizDate.valueOf(20180506), "処理年月日");
    }

    @Test
    @TestOrder(100)
    public void testCalcDShrgk_A10() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN3;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonSibou.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(110)
    public void testCalcDShrgk_A11() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN3;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), null, "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(120)
    public void testCalcDShrgk_A12() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN4;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), BizCurrency.valueOf(0), "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(130)
    public void testCalcDShrgk_A13() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(SYONO, CALCKIJYUNYMD, SYORIYMD);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonSibou.getDShrkn(), BizCurrency.valueOf(26), "配当支払金");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonSibou.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonSibou.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(140)
    public void testCalcDShrgk_A14() {

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonSibou.getEditDshrTukiDKoumokuBean();

        assertNull(editDshrTukiDKoumokuBean);
    }
}
