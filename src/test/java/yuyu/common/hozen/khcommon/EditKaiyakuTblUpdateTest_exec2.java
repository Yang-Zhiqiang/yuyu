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
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetAdrDataMockForHozen;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSksMockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約処理テーブル更新値編集クラスのメソッド {@link EditKaiyakuTblUpdate#exec(KhozenCommonParam, IT_KykKihon, BizDate,
 * EditKaiyakuTblUpdateBean, IT_BAK_KykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKaiyakuTblUpdateTest_exec2 {

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約処理テーブル更新値編集";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HanteiLinc.class).to(HanteiLincMockForHozen.class);
                bind(BzGetAdrData.class).to(BzGetAdrDataMockForHozen.class);
                bind(CommonSiwake.class).to(CommonSiwakeMockForHozen.class);
                bind(CommonSiwakeUtil.class).to(CommonSiwakeUtilMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(SrDshrTukiDataSks.class).to(SrDshrTukiDataSksMockForHozen.class);
                bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMockForHozen.class);
                bind(EditKykSyhnRirekiTbl.class).to(EditKykSyhnRirekiTblMockForHozen.class);
                bind(SetKhDshrTukiKykInfo.class).to(SetKhDshrTukiKykInfoMockForHozen.class);
                bind(EditDairitenTesuuryouTbl.class).to(EditDairitenTesuuryouTblMockForHozen.class);
                bind(KykHenkoujiZnnJytTrksKsn.class).to(KykHenkoujiZnnJytTrksKsnMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        HanteiLincMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        BzGetAdrDataMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        CommonSiwakeMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        CommonSiwakeUtilMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        KeisanGaikakanzanMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        SrDshrTukiDataSksMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        EditKoujyonaiyouTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        EditKykSyhnRirekiTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        SetKhDshrTukiKykInfoMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        EditDairitenTesuuryouTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        KykHenkoujiZnnJytTrksKsnMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HanteiLincMockForHozen.caller = null;
        HanteiLincMockForHozen.SYORIPTN = null;
        BzGetAdrDataMockForHozen.caller = null;
        BzGetAdrDataMockForHozen.SYORIPTN = null;
        CommonSiwakeMockForHozen.caller = null;
        CommonSiwakeMockForHozen.SYORIPTN = null;
        CommonSiwakeUtilMockForHozen.caller = null;
        CommonSiwakeUtilMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
        SrDshrTukiDataSksMockForHozen.caller = null;
        SrDshrTukiDataSksMockForHozen.SYORIPTN = null;
        EditKoujyonaiyouTblMockForHozen.caller = null;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = null;
        SetKhDshrTukiKykInfoMockForHozen.caller = null;
        SetKhDshrTukiKykInfoMockForHozen.SYORIPTN = null;
        EditKykSyhnRirekiTblMockForHozen.caller = null;
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = null;
        EditDairitenTesuuryouTblMockForHozen.caller = null;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = null;
        KykHenkoujiZnnJytTrksKsnMockForHozen.caller = null;
        KykHenkoujiZnnJytTrksKsnMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKaiyakuTblUpdateTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) { e.printStackTrace(); }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_KykSyouhn").executeUpdate();
        em.createJPQL("delete from IT_SyouhnTokujou").executeUpdate();
        em.createJPQL("delete from IT_BAK_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_KhHenreikin").executeUpdate();
        em.createJPQL("delete from IT_AnsyuKihon").executeUpdate();
        em.createJPQL("delete from IT_KykSyouhnRireki").executeUpdate();
        em.createJPQL("delete from IT_KhTtdkRireki").executeUpdate();
        em.createJPQL("delete from IT_KhShrRireki").executeUpdate();
        em.createJPQL("delete from IT_KhShrRirekiDetail").executeUpdate();
        em.createJPQL("delete from IT_SyouhnTokujouRireki").executeUpdate();
        em.createJPQL("delete from BT_SikinIdouRireki").executeUpdate();
        em.createJPQL("delete from IT_KhLincSousinData").executeUpdate();
    }

    private void setParameter(EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean, String syono, BizDate syoriYmd, IT_AnsyuKihon ansyuKihon) {

        MockObjectManager.initialize();
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN4;
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        SetKhDshrTukiKykInfoMockForHozen.SYORIPTN = SetKhDshrTukiKykInfoMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SYOUKENMEISAILISTSKS);

        editKaiyakuTblUpdateBean.setSyono(syono);
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(100.00, BizCurrencyTypes.DOLLAR));
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(1));

        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(20000, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(500, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(600, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR));

        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        editKaiyakuTblUpdateBean.setShrymd(syoriYmd);
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(syoriYmd.getBizDateYM());
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean1.setMkeiPJytKaisuuM(12);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(130));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.NEN);
        miKeikaPBean2.setMkeiPJytKaisuuM(11);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf("201811"));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf("20181213"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean1, miKeikaPBean2};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        String syono = "17806000150";
        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

        setParameter(editKaiyakuTblUpdateBean, syono, syoriYmd, ansyuKihon);

        CommonSiwakeUtilMockForHozen.SYORIPTN = null;

        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(40, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.ARI);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon(syono, "1005");

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean, bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);

        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");
    }
}
