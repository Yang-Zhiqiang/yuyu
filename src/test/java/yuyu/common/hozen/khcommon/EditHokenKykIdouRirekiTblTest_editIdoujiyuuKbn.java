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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * EditHokenKykIdouRirekiTblクラスのメソッド {@link EditHokenKykIdouRirekiTbl#editIdoujiyuuKbn(String, C_SyoriKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn {

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
            testDataAndTblMap = testDataMaker.getInData(EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
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

        KeisanWMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class;
        KeisanVMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class;
        KeisanZennouSeisanGk2MockForHozen.caller = EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class;
        KeisanMsyMkeiPMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class;
        KeisanIkkatuPGkMockForHozen.caller = EditHokenKykIdouRirekiTblTest_editIdoujiyuuKbn.class;

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
    public void testEditIdoujiyuuKbn_A1() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032113");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032113");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032113");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032113", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SINKEIYAKU, "異動事由区分");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditIdoujiyuuKbn_A2() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032124");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032124");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032124");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032124", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIYAKU, "異動事由区分");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditIdoujiyuuKbn_A3() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032135");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032135");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032135");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032135", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIYAKU, "異動事由区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditIdoujiyuuKbn_A4() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032146");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032146");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032146");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032146", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU, "異動事由区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditIdoujiyuuKbn_A5() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032157");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032157");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032157");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032157", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.GENGAKUBFR, "異動事由区分");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806032157", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.GENGAKUNEW, "異動事由区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testEditIdoujiyuuKbn_A6() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032168");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032168");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032168");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032168", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR, "異動事由区分");

        exStringEquals(hokenKykIdouRirekiList.get(1).getSyono(), "99806032168", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(1).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW, "異動事由区分");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testEditIdoujiyuuKbn_A7() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032179");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032179");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032179");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032179", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KEIYAKUTORIKESI, "異動事由区分");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testEditIdoujiyuuKbn_A8() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032180");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032180");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032180");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032180", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.COOLINGOFF, "異動事由区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testEditIdoujiyuuKbn_A9() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032191");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032191");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032191");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032191", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUKIBARAIPSHR, "異動事由区分");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testEditIdoujiyuuKbn_A10() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032205");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032205");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032205");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032205", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI, "異動事由区分");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testEditIdoujiyuuKbn_A11() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032216");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032216");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032216");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032216", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.KAIJYO, "異動事由区分");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testEditIdoujiyuuKbn_A12() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032227");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032227");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032227");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032227", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.MUKOU, "異動事由区分");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testEditIdoujiyuuKbn_A13() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032238");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032238");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032238");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032238", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUKAIJYO, "異動事由区分");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testEditIdoujiyuuKbn_A14() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032249");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032249");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032249");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032249", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMENSEKI, "異動事由区分");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testEditIdoujiyuuKbn_A15() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032250");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032250");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032250");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032250", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMENSEKISHRNASI, "異動事由区分");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testEditIdoujiyuuKbn_A16() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032261");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032261");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032261");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
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
    @TestOrder(170)
    @Transactional
    public void testEditIdoujiyuuKbn_A17() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032272");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032272");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032272");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032272", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOU, "異動事由区分");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testEditIdoujiyuuKbn_A18() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032283");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032283");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032283");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
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
        exStringEquals(hokenKykIdouRirekiList.get(0).getSyono(), "99806032283", "証券番号");
        exClassificationEquals(hokenKykIdouRirekiList.get(0).getIdoujiyuukbn(), C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI, "異動事由区分");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testEditIdoujiyuuKbn_A19() {
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032294");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032294");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032294");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
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
    @TestOrder(200)
    @Transactional
    public void testEditIdoujiyuuKbn_A20() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN2;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;

        EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
        EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806032308");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("99806032308");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
        editHokenKykIdouRirekiTblBean.setSyoNo("99806032308");
        editHokenKykIdouRirekiTblBean.setSyoriYmd(BizDate.valueOf(20180901));
        editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
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
}
