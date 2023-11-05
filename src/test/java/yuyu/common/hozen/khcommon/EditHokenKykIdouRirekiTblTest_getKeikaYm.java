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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * EditHokenKykIdouRirekiTblクラスのメソッド {@link EditHokenKykIdouRirekiTbl#getKeikaYm((BizDate pSyoriYmd, BizDate pKykYmd)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHokenKykIdouRirekiTblTest_getKeikaYm {

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
            testDataAndTblMap = testDataMaker.getInData(EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ008", testDataAndTblMap);
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

        KeisanWMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class;
        KeisanVMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class;
        KeisanZennouSeisanGk2MockForHozen.caller = EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class;
        KeisanMsyMkeiPMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class;
        KeisanIkkatuPGkMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editSeiritujiHrkp.class;

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
    public void testGetKeikaYm_A1() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806001043");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806001043");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201219));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20210122155020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806001043", "証券番号");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "保険料");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testGetKeikaYm_A2() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031237");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806031237");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806031237");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20201201));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20210122155020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806031237", "証券番号");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(26814.72, BizCurrencyTypes.DOLLAR), "保険料");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testGetKeikaYm_A3() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031385");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806031385");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806031385");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20210104));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        editHokenKykIdouRirekiTblBean.setSysDateTime("20210122155020001");
        editHokenKykIdouRirekiTblBean.setMikeikaP(BizCurrency.valueOf(100000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKin(BizCurrency.valueOf(100001, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setMikeikaPGengkBf(BizCurrency.valueOf(200000, BizCurrencyTypes.DOLLAR));
        editHokenKykIdouRirekiTblBean.setZennouseisanKinGengkBf(BizCurrency.valueOf(200001, BizCurrencyTypes.DOLLAR));

        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

        List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList = kykKihon.getKhTtdkRirekiByHenkousikibetukey("000000000000000110").getHokenKykIdouRirekis();

        exNumericEquals(hokenKykIdouRirekiList.size(), 1, "保険契約異動情報履歴テーブルリストの件数");
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806031385", "証券番号");
        exBizCalcbleEquals(hokenKykIdouRirekiList.get(0).getHokenryou(), BizCurrency.valueOf(2234.56, BizCurrencyTypes.DOLLAR), "保険料");
    }
}
