package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuu;
import yuyu.common.hozen.khcommon.CreditKessaiyouNoHensyuuMockForKhansyuu;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanKihrkPMockForKhansyuu;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisan;
import yuyu.common.hozen.khcommon.SyouhntaniKousingoPkeisanMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 払込情報設定クラスのメソッド {@link SetHaraikomiInfo#exec(KhozenCommonParam,SetHaraikomiInfoExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHaraikomiInfoTest_exec {

    private SetHaraikomiInfoExecUiBeanParamImpl setHaraikomiInfoExecUiBeanParamImpl;

    private SetHaraikomiInfo setHaraikomiInfo;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT_SP_単体テスト仕様書_払込情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    public static void testInit(){
        SyouhntaniKousingoPkeisanMockForKhansyuu.caller =SetHaraikomiInfoTest_exec.class;
        KeisanKihrkPMockForKhansyuu.caller =SetHaraikomiInfoTest_exec.class;
        CreditKessaiyouNoHensyuuMockForKhansyuu.caller = SetHaraikomiInfoTest_exec.class;
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SyouhntaniKousingoPkeisan.class).to(SyouhntaniKousingoPkeisanMockForKhansyuu.class);
                bind(KeisanKihrkP.class).to(KeisanKihrkPMockForKhansyuu.class);
                bind(CreditKessaiyouNoHensyuu.class).to(CreditKessaiyouNoHensyuuMockForKhansyuu.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SyouhntaniKousingoPkeisanMockForKhansyuu.caller =null;
        KeisanKihrkPMockForKhansyuu.caller =null;
        CreditKessaiyouNoHensyuuMockForKhansyuu.caller = null;
        SyouhntaniKousingoPkeisanMockForKhansyuu.SYORIPTN =null;
        KeisanKihrkPMockForKhansyuu.SYORIPTN =null;
        CreditKessaiyouNoHensyuuMockForKhansyuu.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHaraikomiInfoTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("22806345675");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("32806345689");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, false, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_C1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345731");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoustartym(), null, "（払込情報）前納開始年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukingk(), BizCurrency.optional(), "（払込情報）前納入金額");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoukkn(), "", "（払込情報）前納期間 ");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukinymd(), null, "（払込情報）前納入金年月日");
    }

    @Test
    @TestOrder(100)
    public void testExec_C2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345742");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoustartym(), BizDateYM.valueOf(201812), "（払込情報）前納開始年月");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukingk(), BizCurrency.valueOf(2000000), "（払込情報）前納入金額");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennoukkn(), "16", "（払込情報）前納期間 ");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.ARI, "（払込情報）全期前納有無");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizennounyuukinymd(), BizDate.valueOf(20181102), "（払込情報）前納入金年月日");
    }

    @Test
    @TestOrder(110)
    public void testExec_C3() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("19806000015");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");
    }

    @Test
    @TestOrder(120)
    public void testExec_D1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345753");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(0), "（払込情報）契約管理次回更新後払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");

    }

    @Test
    @TestOrder(130)
    public void testExec_D2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345764");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(1), "（払込情報）契約管理次回更新後払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.ARI, "次回更新有無");
    }

    @Test
    @TestOrder(140)
    public void testExec_E1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345775");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(150)
    public void testExec_E2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345786");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(0), "（払込情報）契約管理次回更新後払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");
    }

    @Test
    @TestOrder(160)
    public void testExec_E3() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345867");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(1), "（払込情報）契約管理次回更新後払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.ARI, "次回更新有無");

    }

    @Test
    @TestOrder(170)
    public void testExec_E4() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345797");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(2), "（払込情報）契約管理次回更新後払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.ARI, "次回更新有無");
    }

    @Test
    @TestOrder(180)
    public void testExec_F1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345801");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkijkipjytym(), null, "（払込情報）次回Ｐ充当年月");
    }

    @Test
    @TestOrder(190)
    public void testExec_F2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345812");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkijkipjytym(), BizDateYM.valueOf("201512"), "（払込情報）次回Ｐ充当年月");
    }

    @Test
    @TestOrder(200)
    public void testExec_G1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345823");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobankcd(), "", "（払込情報）払込情報銀行コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "", "（払込情報）払込情報銀行名（漢字）");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositencd(), "", "（払込情報）払込情報支店コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "", "（払込情報）払込情報支店名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.BLNK, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "", "（払込情報）払込情報口座番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokzmeiginmkn(), "", "（払込情報）払込情報口座名義人氏名（カナ）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfosinkeizkkbn(), C_SinkeizkKbn.BLNK, "（払込情報）払込情報新規継続区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfotuutyoukigou(), "", "（払込情報）払込情報郵貯通帳記号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikzdoukbn(), C_KzkykdouKbn.BLNK, "（払込情報）口座名義人同一区分");
    }

    @Test
    @TestOrder(210)
    public void testExec_G2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        khozenCommonParam.setFunctionId("khhukkatu");

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345834");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobankcd(), "9900", "（払込情報）払込情報銀行コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositencd(), "345", "（払込情報）払込情報支店コード");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "", "（払込情報）払込情報銀行名（漢字）");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "", "（払込情報）払込情報支店名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.BLNK, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "1001", "（払込情報）払込情報口座番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokzmeiginmkn(), "カナ", "（払込情報）払込情報口座名義人氏名（カナ）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfosinkeizkkbn(), C_SinkeizkKbn.SHINKI, "（払込情報）払込情報新規継続区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfotuutyoukigou(), "13450", "（払込情報）払込情報郵貯通帳記号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikzdoukbn(), C_KzkykdouKbn.DOUITU, "（払込情報）口座名義人同一区分");
    }

    @Test
    @TestOrder(220)
    public void testExec_G3() {

        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        khozenCommonParam.setFunctionId("khonlinenyuukin");

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345845");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "", "（払込情報）払込情報銀行名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.TOUZA, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "200", "（払込情報）払込情報口座番号");
    }

    @Test
    @TestOrder(230)
    public void testExec_G4() {

        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        khozenCommonParam.setFunctionId("khnyuukintorikesi");

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345856");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfobanknmkj(), "ゆうちょ銀行", "（払込情報）払込情報銀行名（漢字）");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfoyokinkbn(), C_YokinKbn.TTYOKIN, "（払込情報）払込情報預金種目区分");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfokouzano(), "300", "（払込情報）払込情報口座番号");
    }

    @Test
    @TestOrder(240)
    public void testExec_G5() {

        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        khozenCommonParam.setFunctionId("khharaikatahenkou");

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345845");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "", "（払込情報）払込情報支店名（漢字）");
    }

    @Test
    @TestOrder(250)
    public void testExec_G6() {

        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        khozenCommonParam.setFunctionId("khharaikatahenkou");

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345856");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkinfositennmkj(), "東京支店", "（払込情報）払込情報支店名（漢字）");
    }

    @Test
    @TestOrder(260)
    public void testExec_H1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806346477");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkifstphrkkeirokbn(), C_FstphrkkeiroKbn.HURIKOMI, "（払込情報）初回保険料払込経路区分");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkaisuu(), C_Hrkkaisuu.ITIJI, "（払込情報）払込回数");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkeiro(), C_Hrkkeiro.KOUHURI, "（払込情報）払込経路");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkp(), BizCurrency.valueOf(3), "（払込情報）払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikihrkp(), BizCurrency.valueOf(200), "（払込情報）既払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(0), "（払込情報）契約管理次回更新後払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyenkansannyknkingk(), BizCurrency.valueOf(4), "（払込情報）円換算入金額");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrateymd(), BizDate.valueOf("20151224"), "（払込情報）円換算適用為替レート基準日");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrate(), BizNumber.valueOf(123.45), "（払込情報）円換算適用為替レート");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsratetuukasyu(), C_Tuukasyu.JPY, "（払込情報）円換算適用為替レート通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getYennykntkhkumu(), C_UmuKbn.ARI, "円入金特約付加有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiitijibrp(), BizCurrency.valueOf(100), "（払込情報）一時払保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkitikiktbrijk(), C_TkiktbrisyuruiKbn.NONE, "（払込情報）定期一括払状況");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（払込情報）契約状態");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");

    }
    @Test
    @TestOrder(270)
    public void testExec_H2() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806345672");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkifstphrkkeirokbn(), C_FstphrkkeiroKbn.HURIKOMI, "（払込情報）初回保険料払込経路区分");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkaisuu(), C_Hrkkaisuu.TUKI, "（払込情報）払込回数");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkkeiro(), C_Hrkkeiro.KOUHURI, "（払込情報）払込経路");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkihrkp(), BizCurrency.valueOf(3), "（払込情報）払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikihrkp(), BizCurrency.valueOf(0), "（払込情報）既払込保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getNextkosumu(), C_UmuKbn.NONE, "次回更新有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkinextkosgohrkp(), BizCurrency.valueOf(0), "（払込情報）契約管理次回更新後払込保険料");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyenkansannyknkingk(), BizCurrency.valueOf(4), "（払込情報）円換算入金額");
        exDateEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrateymd(), BizDate.valueOf("20151224"), "（払込情報）円換算適用為替レート基準日");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsrate(), BizNumber.valueOf(123.45), "（払込情報）円換算適用為替レート");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiyentkykwsratetuukasyu(), C_Tuukasyu.JPY, "（払込情報）円換算適用為替レート通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getYennykntkhkumu(), C_UmuKbn.ARI, "円入金特約付加有無");
        exBizCalcbleEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkiitijibrp(), BizCurrency.valueOf(100), "（払込情報）一時払保険料");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkitikiktbrijk(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "（払込情報）定期一括払状況");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkikykjyoutai(), C_Kykjyoutai.HRKMTYUU, "（払込情報）契約状態");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkizenkizennouumu(), C_UmuKbn.NONE, "（払込情報）全期前納有無");

    }

    @Test
    @TestOrder(280)
    public void testExec_I1() {
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806346008");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicreditkessaiyouno(), "", "（払込情報）クレジットカード決済用番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkidispcreditkessaiyouno(), "", "（払込情報）表示用クレジットカード決済用番号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakkekka(), C_Yuukoukakkekka.BLNK, "（払込情報）クレジットカード有効確認結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakym(), null, "（払込情報）クレジットカード有効確認年月");
    }

    @Test
    @TestOrder(290)
    public void testExec_I2() {
        CreditKessaiyouNoHensyuuMockForKhansyuu.SYORIPTN = CreditKessaiyouNoHensyuuMockForKhansyuu.TESTPATTERN1;
        setHaraikomiInfoExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaraikomiInfoExecUiBeanParamImpl.class);

        setHaraikomiInfoExecUiBeanParamImpl.setSyono("12806346019");

        setHaraikomiInfo = SWAKInjector.getInstance(SetHaraikomiInfo.class);

        boolean result = setHaraikomiInfo.exec(khozenCommonParam, setHaraikomiInfoExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicreditkessaiyouno(), "12345678912345678912345678", "（払込情報）クレジットカード決済用番号");
        exStringEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkidispcreditkessaiyouno(), "12345678912345678987654321", "（払込情報）表示用クレジットカード決済用番号");
        exClassificationEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakkekka(), C_Yuukoukakkekka.YUUKOUKAK_OK, "（払込情報）クレジットカード有効確認結果");
        exDateYMEquals(setHaraikomiInfoExecUiBeanParamImpl.getVhrkicredityuukoukakym(), BizDateYM.valueOf(201910), "（払込情報）クレジットカード有効確認年月");
        exStringEquals((String)MockObjectManager.getArgument(CreditKessaiyouNoHensyuuMockForKhansyuu.class, "exec", 0, 0),
            "12345678912345678912345678", "クレジットカード決済用番号");
    }
}
