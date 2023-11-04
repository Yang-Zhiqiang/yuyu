package yuyu.common.hozen.khcommon;

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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KykIdouHaraikataKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TumitatekinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * EditHokenKykIdouRirekiTblクラスのメソッド {@link EditHokenKykIdouRirekiTbl#exec(EditHokenKykIdouRirekiTblBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHokenKykIdouRirekiTblTest_exec {

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険契約異動情報履歴TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditHokenKykIdouRirekiTblTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(KeisanV.class).to(KeisanVMockForHozen.class);
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForHozen.class);
                bind(KeisanMsyMkeiP.class).to(KeisanMsyMkeiPMockForHozen.class);
                bind(KeisanIkkatuPGk.class).to(KeisanIkkatuPGkMockForHozen.class);


            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanWMockForHozen.caller = EditHokenKykIdouRirekiTblTest_exec.class;
        KeisanVMockForHozen.caller = EditHokenKykIdouRirekiTblTest_exec.class;
        KeisanZennouSeisanGk2MockForHozen.caller = EditHokenKykIdouRirekiTblTest_exec.class;
        KeisanMsyMkeiPMockForHozen.caller = EditHokenKykIdouRirekiTblTest_exec.class;
        KeisanIkkatuPGkMockForHozen.caller = EditHokenKykIdouRirekiTblTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanVMockForHozen.caller = null;
        KeisanVMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.caller = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        KeisanMsyMkeiPMockForHozen.caller = null;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = null;
        KeisanIkkatuPGkMockForHozen.caller = null;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = null;

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_MEIGIHENKOU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030410");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030410");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030410");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 0, "保険契約異動情報履歴テーブルリストの件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030421");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030421");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030421");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 0, "保険契約異動情報履歴テーブルリストの件数");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030432");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030432");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030432");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 0, "保険契約異動情報履歴テーブルリストの件数");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030443");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030443");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030443");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 0, "保険契約異動情報履歴テーブルリストの件数");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030454");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030454");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030454");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 2, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030454", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201116), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.55, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(21345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(11545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(11345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806030454", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(1).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(1).getKykymd(), BizDate.valueOf(20201116), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouhokenkngk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouptumitatekin(), BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoukiykhnrikn(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030465");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030465");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030465");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 2, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030465", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201117), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(21345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(11445.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(11345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806030465", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(1).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(1).getKykymd(), BizDate.valueOf(20201117), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouptumitatekin(), BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoukiykhnrikn(), BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030476");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030476");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030476");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.ITENTORIKESI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030476", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIYAKU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20180901), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030487");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030487");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030487");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.ITENTORIKESI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030487", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIYAKU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20180901), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_GENGAKU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030498");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030498");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030498");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 2, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030498", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.GENGAKUBFR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 3, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20180901), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(51345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(411346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(11345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(19000, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(199000, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806030498", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(1).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.GENGAKUNEW, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getTtdkrenno(), 3, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(1).getKykymd(), BizDate.valueOf(20180901), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoukiykhnrikn(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030502");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030502");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030502");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030502", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIJYO, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20180901), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030513");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030513");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030513");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030513", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.COOLINGOFF, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030524");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030524");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030524");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KYKTORIKESI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030524", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KEIYAKUTORIKESI, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030535");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030535");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030535");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.MUKOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030535", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.MUKOU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030546");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030546");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030546");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030546", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUKIBARAIPSHR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030557");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030557");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030557");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030557", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030568");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030568");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030568");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030568", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030579");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030579");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030579");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030579", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUKAIJYO, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030580");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030580");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030580");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030580", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMENSEKI, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030591");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030591");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030591");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030591", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMENSEKISHRNASI, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(200.02, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12545.02, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030605");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030605");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030605");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030605", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(212346, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030616");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030616");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030616");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030616", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030627");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030627");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030627");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.KYKTORIKESI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030627", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030638");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030638");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030638");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.MUKOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030638", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030649");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030649");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030649");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030649", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030650");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030650");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030650");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030650", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030661");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030661");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030661");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMUKOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030661", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030672");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030672");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030672");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030672", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_A28() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030683");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030683");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030683");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030683", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_A29() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030694");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030694");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030694");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030694", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.NEN, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testExec_A30() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030708");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030708");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030708");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030708", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SINKEIYAKU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(223.49, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(223.49, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.ZENNOU, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testExec_A31() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030719");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030719");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030719");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 2, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030719", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.57, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(42345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(14345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(14345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(0.01, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.TUKI, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806030719", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(1).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(1).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoukiykhnrikn(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.TUKI, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testExec_A32() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030720");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030720");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030720");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 2, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030720", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.GEN, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(42345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(14345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(14345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.TUKI, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806030720", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(1).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(1).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(1).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhrgoukei(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouhokenkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdouptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getIdoukiykhnrikn(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(1).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(1).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.TUKI, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(1).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testExec_A33() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030731");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030731");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030731");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20201117124020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030731", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SINKEIYAKU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20201117124020001", "業務用更新時間");
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testExec_A34() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001010");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806001010");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201117));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.SIBOU);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20210121203120001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806001010", "証券番号");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHenkousikibetukey(), "000000000000000110", "変更識別キー");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exDateEquals(hokenKykIdouRirekiList.get(0).getIdouymd(), BizDate.valueOf(20201117), "異動日");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SINKEIYAKU, "異動事由区分");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getTtdkrenno(), 1, "手続連番");
        exDateEquals(hokenKykIdouRirekiList.get(0).getKykymd(), BizDate.valueOf(20201118), "契約日");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exStringEquals(hokenKykIdouRirekiList.get(0).getHknsyukigou (), "ﾆｱ", "保険種類記号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_19_SMBC, "愛称名区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getZougenkbn(), C_ZougenKbn.ZOU, "増減区分");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhrgoukei(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "解約返戻金合計");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getMikeikap(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getZennouseisankgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouhokenkngk(), BizCurrency.valueOf(1234.56, BizCurrencyTypes.DOLLAR), "異動保険金額");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoup(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "異動保険料");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdouptumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "異動保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getIdoukiykhnrikn(), BizCurrency.valueOf(13579.56, BizCurrencyTypes.DOLLAR), "異動解約返戻金");
        exNumericEquals(hokenKykIdouRirekiList.get(0).getHknkkn(), 10, "保険期間");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getTumitatekinkbn(), C_TumitatekinKbn.BLNK, "積立金区分");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getKykidouharaikatakbn(), C_KykIdouHaraikataKbn.HALFY, "保険契約異動情報払方区分");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(hokenKykIdouRirekiList.get(0).getGyoumuKousinTime(), "20210121203120001", "業務用更新時間");
    }
}
