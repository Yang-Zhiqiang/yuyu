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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.haitou.KeisanDCommonGengaku.NrkKmkGengakuNaibuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当共通計算（減額）のメソッド {@link KeisanDCommonGengaku#calcDShrgk(String, BizDate, BizDate, BizNumber)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDCommonGengakuTest_calcDShrgk {

    @Inject
    private KeisanDCommonGengaku keisanDCommonGengaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通計算";

    private final static String sheetName = "INデータ";

    private static final String SYONO = "18806000014";

    private static final BizDate CALCKIJYUNYMD = BizDate.valueOf(20170301);

    private static final BizDate SYORIYMD = BizDate.valueOf(20180506);

    private static final BizNumber GENGAKUWARIAI = BizNumber.valueOf(0.12);

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

        SetDNndMockForHozen.caller = KeisanDCommonGengakuTest_calcDShrgk.class;
        DBAccessDCommonMockForHozen.caller = KeisanDCommonGengakuTest_calcDShrgk.class;
        KeisanDGanrikinMockForHozen.caller = KeisanDCommonGengakuTest_calcDShrgk.class;
        NaiteiKakuteiRateHanteiMockForHozen.caller = KeisanDCommonGengakuTest_calcDShrgk.class;
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
    }

    //    @Test
    //    @TestOrder(10)
    //    public void testCalcDShrgk_A1() {
    //
    //        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(null, CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);
    //
    //        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    //        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
    //        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
    //        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");
    //
    //        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
    //        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
    //        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
    //        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    //    }


    @Test
    @TestOrder(20)
    public void testCalcDShrgk_A2() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, null, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testCalcDShrgk_A3() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, CALCKIJYUNYMD, BizDate.valueOf(20160302), null, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testCalcDShrgk_A4() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, BizNumber.optional());

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(50)
    public void testCalcDShrgk_A5() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonGengaku.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
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
    @TestOrder(60)
    public void testCalcDShrgk_A6() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonGengaku.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(70)
    public void testCalcDShrgk_A7() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(80)
    public void testCalcDShrgk_A8() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, BizDate.valueOf(20140303), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonGengaku.getEditDshrTukiDKoumokuBean();
        NrkKmkGengakuNaibuBean nrkKmkGengakuNaibuBean = keisanDCommonGengaku.getNrkKmkGengakuNaibuBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(1), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(8), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(6), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
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
        exClassificationEquals(editDshrTukiDKoumokuBean.getNaiteikakuteiKbn2(), null, "内定確定区分２");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcKari(), BizCurrency.valueOf(10), "配当元利金計算（仮割当Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().size() == 1, true, "元利金計算仮割当Ｄ利率リスト");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getHaitouganrikincalcTumi(), null, "配当元利金計算（積立Ｄ元利金）");
        exBooleanEquals(editDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() == null, true, "元利金計算積立Ｄ利率リスト");
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf(20140303), "計算基準日");
        exDateEquals(editDshrTukiDKoumokuBean.getSyoriYmd2(), BizDate.valueOf(20180506), "処理年月日２");
        exDateEquals(editDshrTukiDKoumokuBean.getKinoubetukijyunYmd(), BizDate.valueOf(20160302), "機能別基準日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getGengkwari(), BizNumber.valueOf(0.12), "減額割合");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedruiGk(), BizCurrency.valueOf(1), "仮割当Ｄ累計額");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedgngkknGk(), BizCurrency.valueOf(8), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getKariwariatedshrGk(), BizCurrency.valueOf(6), "仮割当Ｄ支払額");

        exStringEquals(nrkKmkGengakuNaibuBean.getSyono(), "18806000014", "証券番号");
        exDateEquals(nrkKmkGengakuNaibuBean.getCalckijyunymd(), BizDate.valueOf(20140303), "計算基準日");
        exDateEquals(nrkKmkGengakuNaibuBean.getSyoriymd(), BizDate.valueOf(20180506), "処理年月日");
        exDateEquals(nrkKmkGengakuNaibuBean.getSyoruiukeymd(), BizDate.valueOf(20160302), "書類受付日");
        exBizCalcbleEquals(nrkKmkGengakuNaibuBean.getGengakuWariai(), BizNumber.valueOf(0.12), "減額割合");
    }

    @Test
    @TestOrder(90)
    public void testCalcDShrgk_A9() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, BizDate.valueOf(20140302), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(0), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(0), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(100)
    public void testCalcDShrgk_A10() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, BizDate.valueOf(20140302), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(-2), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(-17), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(110)
    public void testCalcDShrgk_A11() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN4;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk(SYONO, BizDate.valueOf(20140301), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(1), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(10), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }


    @Test
    @TestOrder(120)
    public void testCalcDShrgk_A12() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", null, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(130)
    public void testCalcDShrgk_A13() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", CALCKIJYUNYMD, BizDate.valueOf(20160302), null, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(140)
    public void testCalcDShrgk_A14() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, BizNumber.optional());

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(150)
    public void testCalcDShrgk_A15() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonGengaku.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(NaiteiKakuteiRateHantei.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
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
    @TestOrder(160)
    public void testCalcDShrgk_A16() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        List<HaitouErrorInfo> haitouErrorInfoList = keisanDCommonGengaku.getErrorInfo();
        exNumericEquals(haitouErrorInfoList.size(), 2, "配当エラー情報リストの件数");
        exStringEquals(haitouErrorInfoList.get(0).getKinouId(), SWAKInjector.getInstance(SetDNnd.class)
            .getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(0).getErrorInfo2(), "NoError", "エラー情報（小分類）");
        exStringEquals(haitouErrorInfoList.get(1).getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfoList.get(1).getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(170)
    public void testCalcDShrgk_A17() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", CALCKIJYUNYMD, BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "計算時エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "確定期間中に内定レコードを計算対象としている", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(180)
    public void testCalcDShrgk_A18() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN1;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", BizDate.valueOf(20140303), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(1), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(8), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(6), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(190)
    public void testCalcDShrgk_A19() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", BizDate.valueOf(20140302), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(0), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(0), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(200)
    public void testCalcDShrgk_A20() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN3;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", BizDate.valueOf(20140302), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(-2), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(-17), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(210)
    public void testCalcDShrgk_A21() {

        MockObjectManager.initialize();
        NaiteiKakuteiRateHanteiMockForHozen.SYORIPTN = NaiteiKakuteiRateHanteiMockForHozen.TESTPATTERN2;
        SetDNndMockForHozen.SYORIPTN = SetDNndMockForHozen.TESTPATTERN2;
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        KeisanDGanrikinMockForHozen.SYORIPTN = KeisanDGanrikinMockForHozen.TESTPATTERN4;

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", BizDate.valueOf(20140301), BizDate.valueOf(20160302), SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), BizCurrency.valueOf(1), "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), BizCurrency.valueOf(10), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), BizCurrency.valueOf(0), "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(220)
    public void testCalcDShrgk_A22() {

        C_ErrorKbn errorKbn = keisanDCommonGengaku.calcDShrgk("99806001010", BizDate.valueOf(20170301), null, SYORIYMD, GENGAKUWARIAI);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedruigk(), null, "仮割当Ｄ累計額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedgngkkngk(), null, "仮割当Ｄ減額金額");
        exBizCalcbleEquals(keisanDCommonGengaku.getKariwariatedshrgk(), null, "仮割当Ｄ支払額");

        HaitouErrorInfo haitouErrorInfo = keisanDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), keisanDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "必須項目にnullが含まれる", "エラー情報（小分類）");
    }

    @Test
    @TestOrder(230)
    public void testCalcDShrgk_A23() {

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanDCommonGengaku.getEditDshrTukiDKoumokuBean();

        assertNull(editDshrTukiDKoumokuBean);
    }
}
