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
import jp.co.slcs.swak.date.BizDateYM;
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
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * EditHokenKykIdouRirekiTblクラスのメソッド {@link EditHokenKykIdouRirekiTbl#keisanWV(String, BizDate, BizDateYM,
 * CurrencyType, IT_KykKihon, KykSyouhnCommonParam, IT_AnsyuKihon)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHokenKykIdouRirekiTblTest_keisanWV {

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
            testDataAndTblMap = testDataMaker.getInData(EditHokenKykIdouRirekiTblTest_keisanWV.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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

        KeisanWMockForHozen.caller = EditHokenKykIdouRirekiTblTest_keisanWV.class;
        KeisanVMockForHozen.caller = EditHokenKykIdouRirekiTblTest_keisanWV.class;
        KeisanZennouSeisanGk2MockForHozen.caller = EditHokenKykIdouRirekiTblTest_keisanWV.class;
        KeisanMsyMkeiPMockForHozen.caller = EditHokenKykIdouRirekiTblTest_keisanWV.class;
        KeisanIkkatuPGkMockForHozen.caller = EditHokenKykIdouRirekiTblTest_keisanWV.class;

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
    public void testKeisanWV_A1() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030812");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030812");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030812");
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030812", "証券番号");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testKeisanWV_A2() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030823");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806030823");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806030823");
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806030823", "証券番号");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getPtumitatekin(), BizCurrency.valueOf(32345, BizCurrencyTypes.DOLLAR), "保険料積立金");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getKaiyakuhr(), BizCurrency.valueOf(12345, BizCurrencyTypes.DOLLAR), "解約返戻金");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20191225), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1), BizDateYM.valueOf(202001), "基準年月");
        KeisanWExtBean keisanWExtBean = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 2);
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 10, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanWExtBean.getHhknnen(), 50, "被保険者年齢");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(100000.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(200000.00, BizCurrencyTypes.DOLLAR), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20180901), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), BizDateYM.valueOf(202101), "次回Ｐ充当年月");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 0), BizDate.valueOf(20191225), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 1), BizDateYM.valueOf(202001), "計算基準年月");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 2), BizDate.valueOf(20180901), "契約日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 3), "ﾆｱ",  "商品コード");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 4), 1, "商品世代番号");
        exStringEquals((String) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 5), "L", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 6), BizNumber.valueOf(0.038), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 7), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 8), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 9), 50, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 10), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 11), 10, "保険期間");
        exClassificationEquals((C_HrkkknsmnKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 12), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 13), 1, "払込期間");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 14), BizCurrency.valueOf(100000.00, BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 15), 0, "経過年数");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 16), 1, "経過月数");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 17), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 18), BizCurrency.valueOf(200000.00, BizCurrencyTypes.DOLLAR), "保険料");
        exClassificationEquals((C_TyksenhokanhouKbn) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 19), C_TyksenhokanhouKbn.RATE, "直線補間方法区分");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 20), C_Kykjyoutai.ZENNOU, "契約状態");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanVMockForHozen.class, "exec", 0, 21), 0, "第１保険期間");
    }
}
