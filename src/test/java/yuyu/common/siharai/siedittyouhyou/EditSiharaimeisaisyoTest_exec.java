package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyu;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyuMockForSiharai;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.bean.report.SiShrmeisaiBean;
import yuyu.def.siharai.bean.report.SiShrmeisaiDataSourceBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 支払明細書編集のメソッド テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSiharaimeisaisyoTest_exec {

    private static final String BLNK = "";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払明細書編集";

    private final static String sheetName = "テストデータ";

    @Inject
    private EditSiharaimeisaisyo editSiharaimeisaisyo;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SiMeisaiCommonHensyu.class).to(SiMeisaiCommonHensyuMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SiMeisaiCommonHensyuMockForSiharai.caller = EditSiharaimeisaisyoTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        SiMeisaiCommonHensyuMockForSiharai.caller = null;
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSiharaimeisaisyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
        MockObjectManager.initialize();
    }
    @Test
    @TestOrder(10)
    public void testExec_A1() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(null);
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(null);
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='toiawaseInfoBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        bean.setSiDetailLst(null);
        bean.setSk(new JT_Sk());
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='siDetailLst'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN1;
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20170728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        bean.setSk(null);
        try {
            editSiharaimeisaisyo.exec(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_B1() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKouzaHyoujiUmu(C_UmuKbn.NONE);
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);


        MockObjectManager.assertArgumentPassed(SiMeisaiCommonHensyuMockForSiharai.class, "siMeisaiHensyu", 0, bean.getSk());
        MockObjectManager.assertArgumentPassed(SiMeisaiCommonHensyuMockForSiharai.class, "siMeisaiHensyu", 1, bean.getSiDetailLst());
        MockObjectManager.assertArgumentPassed(SiMeisaiCommonHensyuMockForSiharai.class, "siMeisaiHensyu", 2, bean.getSibouYmd());
        MockObjectManager.assertArgumentPassed(SiMeisaiCommonHensyuMockForSiharai.class, "siMeisaiHensyu", 3, C_KanryotuutioutKbn.PDF);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(110)
    public void testExec_B2() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN3;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createSaikensyaInfoBean());
        bean.getSaikensyaInfoBean().setSaikenadr3kj(null);
        bean.getSeikyuusyaInfoBean().setTsinadr3kj(null);
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 2, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), BLNK, "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), BLNK, "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), BLNK, "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), BLNK, "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), BLNK, "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.ARI, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 3, "支払明細書DSBEANリストサイズ");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean1_1 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst.get(0);
        exStringEquals(siShrmeisaiDataSourceBean1_1.getIrKyuuhuname(), "死亡保険金", "（ＩＲ）給付名[0]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean1_1.getIrKyhkg(), BizCurrency.valueOf(123, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[0]");
        exStringEquals(siShrmeisaiDataSourceBean1_1.getIrShrdetailbikou(), "死亡日：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[0]");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean1_2 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst.get(1);
        exStringEquals(siShrmeisaiDataSourceBean1_2.getIrKyuuhuname(), "死亡保険金２", "（ＩＲ）給付名[1]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean1_2.getIrKyhkg(), BizCurrency.valueOf(223, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[1]");
        exStringEquals(siShrmeisaiDataSourceBean1_2.getIrShrdetailbikou(), "死亡日２：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[1]");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean1_3 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst.get(2);
        exStringEquals(siShrmeisaiDataSourceBean1_3.getIrKyuuhuname(), "死亡保険金３", "（ＩＲ）給付名[2]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean1_3.getIrKyhkg(), BizCurrency.valueOf(323, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[2]");
        exStringEquals(siShrmeisaiDataSourceBean1_3.getIrShrdetailbikou(), "死亡日３：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[2]");


        ReportServicesBean reportServicesBean2 = list.get(1);
        SiShrmeisaiBean siShrmeisaiBean2 = (SiShrmeisaiBean) reportServicesBean2.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean2.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean2.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean2.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SaikensyaInfoBean saikensyaInfoBean = bean.getSaikensyaInfoBean();
        exStringEquals(siShrmeisaiBean2.getIrShsyno(), saikensyaInfoBean.getSaikennyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean2.getIrShadr1kj(), saikensyaInfoBean.getSaikenadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShadr2kj(), saikensyaInfoBean.getSaikenadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShadr3kj(), saikensyaInfoBean.getSaikenadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShsnmkj(), saikensyaInfoBean.getSaikennmkj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean2 = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean2.getIrToiawasesosiki(), toiawaseInfoBean2.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseyno(), toiawaseInfoBean2.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr1kj(), toiawaseInfoBean2.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr2kj(), toiawaseInfoBean2.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr3kj(), toiawaseInfoBean2.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawasetelno(), toiawaseInfoBean2.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean2.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean2.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrHhknnmkj(), BLNK, "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean2.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean2.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean2.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean2.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean2.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean2.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean2.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean2.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst2 = reportServicesBean2.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst2.size(), 3, "支払明細書DSBEANリストサイズ");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean2_1 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst2.get(0);
        exStringEquals(siShrmeisaiDataSourceBean2_1.getIrKyuuhuname(), "死亡保険金", "（ＩＲ）給付名[0]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean2_1.getIrKyhkg(), BizCurrency.valueOf(123, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[0]");
        exStringEquals(siShrmeisaiDataSourceBean2_1.getIrShrdetailbikou(), "死亡日：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[0]");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean2_2 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst2.get(1);
        exStringEquals(siShrmeisaiDataSourceBean2_2.getIrKyuuhuname(), "死亡保険金２", "（ＩＲ）給付名[1]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean2_2.getIrKyhkg(), BizCurrency.valueOf(223, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[1]");
        exStringEquals(siShrmeisaiDataSourceBean2_2.getIrShrdetailbikou(), "死亡日２：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[1]");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean2_3 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst2.get(2);
        exStringEquals(siShrmeisaiDataSourceBean2_3.getIrKyuuhuname(), "死亡保険金３", "（ＩＲ）給付名[2]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean2_3.getIrKyhkg(), BizCurrency.valueOf(323, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[2]");
        exStringEquals(siShrmeisaiDataSourceBean2_3.getIrShrdetailbikou(), "死亡日３：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[2]");
    }

    @Test
    @TestOrder(130)
    public void testExec_B3() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN4;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.getSeikyuusyaInfoBean().setTsinadr3kj(null);
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 1, "支払明細書DSBEANリストサイズ");
        SiShrmeisaiDataSourceBean siShrmeisaiDataSourceBean1_1 = (SiShrmeisaiDataSourceBean) iReportDataSouceBeanLst.get(0);
        exStringEquals(siShrmeisaiDataSourceBean1_1.getIrKyuuhuname(), "死亡保険金", "（ＩＲ）給付名[0]");
        exBizCalcbleEquals(siShrmeisaiDataSourceBean1_1.getIrKyhkg(), BizCurrency.valueOf(123, BizCurrencyTypes.YEN), "（ＩＲ）給付金額[0]");
        exStringEquals(siShrmeisaiDataSourceBean1_1.getIrShrdetailbikou(), "死亡日：２０１６年 ７月１０日", "（ＩＲ）支払明細備考[0]");
    }

    @Test
    @TestOrder(140)
    public void testExec_B4() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(150)
    public void testExec_B5() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.SOUZOKU);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getYenShrgk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getYenShrgk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(160)
    public void testExec_B6() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ZOUYO);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(170)
    public void testExec_B7() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ZOUYO);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 2, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), BLNK, "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), BLNK, "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), BLNK, "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), BLNK, "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), BLNK, "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.ARI, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");


        ReportServicesBean reportServicesBean2 = list.get(1);
        SiShrmeisaiBean siShrmeisaiBean2 = (SiShrmeisaiBean) reportServicesBean2.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean2.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean2.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean2.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SaikensyaInfoBean saikensyaInfoBean = bean.getSaikensyaInfoBean();
        exStringEquals(siShrmeisaiBean2.getIrShsyno(), saikensyaInfoBean.getSaikennyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean2.getIrShadr1kj(), saikensyaInfoBean.getSaikenadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShadr2kj(), saikensyaInfoBean.getSaikenadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShadr3kj(), saikensyaInfoBean.getSaikenadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrShsnmkj(), saikensyaInfoBean.getSaikennmkj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean2 = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean2.getIrToiawasesosiki(), toiawaseInfoBean2.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseyno(), toiawaseInfoBean2.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr1kj(), toiawaseInfoBean2.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr2kj(), toiawaseInfoBean2.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawaseadr3kj(), toiawaseInfoBean2.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrToiawasetelno(), toiawaseInfoBean2.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean2.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean2.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrHhknnmkj(), BLNK, "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean2.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean2.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean2.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean2.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean2.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean2.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean2.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean2.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean2.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean2.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean2.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst2 = reportServicesBean2.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst2.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(180)
    public void testExec_B8() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ZOUYO);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getYenShrgk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getYenShrgk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(190)
    public void testExec_B9() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.JPY);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.HIKAZEI);
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(reportServicesBean.getKensakuKeys()[0], bean.getSyoNo(), "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), bean.getSiTyouhyouHensyuuCommonBean().getSyoriYmd(), "処理年月日");
        exStringEquals(siShrmeisaiBean.getIrTyouhyousakuseiymd(), "2016年 7月28日", "（ＩＲ）帳票作成日");
        SeikyuusyaInfoBean seikyuusyaInfoBean = bean.getSeikyuusyaInfoBean();
        exStringEquals(siShrmeisaiBean.getIrShsyno(), seikyuusyaInfoBean.getTsinyno(), "（ＩＲ）送付先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrShadr1kj(), seikyuusyaInfoBean.getTsinadr1kj(), "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr2kj(), seikyuusyaInfoBean.getTsinadr2kj(), "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShadr3kj(), seikyuusyaInfoBean.getTsinadr3kj(), "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrShsnmkj(), seikyuusyaInfoBean.getSeikyuusyanmKj(), "（ＩＲ）送付先氏名（漢字）");
        ToiawaseInfoBean toiawaseInfoBean = bean.getToiawaseInfoBean();
        exStringEquals(siShrmeisaiBean.getIrToiawasesosiki(), toiawaseInfoBean.getSosikiNm(), "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseyno(), toiawaseInfoBean.getTsinyno(), "（ＩＲ）問合せ先郵便番号");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr1kj(), toiawaseInfoBean.getTsinadr1kj(), "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr2kj(), toiawaseInfoBean.getTsinadr2kj(), "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawaseadr3kj(), toiawaseInfoBean.getTsinadr3kj(), "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(siShrmeisaiBean.getIrToiawasetelno(), toiawaseInfoBean.getTsintelno(), "（ＩＲ）問合せ先電話番号");
        exStringEquals(siShrmeisaiBean.getIrSyono(), "１７８０６００００１３", "（ＩＲ）証券番号");
        exStringEquals(siShrmeisaiBean.getIrKyknmkj(), bean.getKyknmKj(), "（ＩＲ）契約者名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrHhknnmkj(), bean.getHhknnmKj(), "（ＩＲ）被保険者名（漢字）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk(), bean.getShrGk(), "（ＩＲ）支払金額");
        exStringEquals(siShrmeisaiBean.getIrTyakkinymd(), "２０１６年 ７月２９日", "（ＩＲ）着金日");
        exStringEquals(siShrmeisaiBean.getIrBanknmkj(), bean.getBanknmKj(), "（ＩＲ）銀行名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrSitennmkj(), bean.getSitennmKj(), "（ＩＲ）支店名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrYokinknmkj(), bean.getYokinKbn().getContent(), "（ＩＲ）預金種目名（漢字）");
        exStringEquals(siShrmeisaiBean.getIrKouzano(), bean.getKouzaNo(), "（ＩＲ）口座番号");
        exStringEquals(siShrmeisaiBean.getIrKzmeiginmkn(), bean.getKzmeiginmKn(), "（ＩＲ）口座名義人氏名（カナ）");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrgk2(), bean.getShrGk(), "（ＩＲ）支払金額２");
        exBizCalcbleEquals(siShrmeisaiBean.getIrSynykngk(), bean.getSynykngk(), "（ＩＲ）収入金額");
        exBizCalcbleEquals(siShrmeisaiBean.getIrHtykeihi(), bean.getHtykeihi(), "（ＩＲ）必要経費");
        exStringEquals(siShrmeisaiBean.getIrCctelno(), bean.getCctelNo(), "（ＩＲ）コールセンター電話番号");
        exClassificationEquals(siShrmeisaiBean.getIrKouzahyoujiumukbn(), C_UmuKbn.ARI, "（ＩＲ）口座情報表示有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrSaikenshrumukbn(), C_UmuKbn.NONE, "（ＩＲ）債権者支払有無区分");
        exClassificationEquals(siShrmeisaiBean.getIrShrtuukasyu(), bean.getShrTuukasyu(), "（ＩＲ）支払通貨種類");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytkkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrItjsytknaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）一時所得内容表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztkgkhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象金額表示有無");
        exClassificationEquals(siShrmeisaiBean.getIrKztnaiyouhyoujiumukbn(), C_UmuKbn.NONE, "（ＩＲ）課税対象内容表示有無");
        exBizCalcbleEquals(siShrmeisaiBean.getIrKztkgk(), bean.getKztkgk(), "（ＩＲ）課税対象金額");
        exNumericEquals(siShrmeisaiBean.getIrKykhnkkaisuu(), bean.getKykHnkKaisuu(), "（ＩＲ）契約者変更回数");
        exBizCalcbleEquals(siShrmeisaiBean.getIrShrkyksyahtykeihi(), bean.getShrKykHtyKeihi(), "（ＩＲ）支払時契約者必要経費");
        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 0, "支払明細書DSBEANリストサイズ");
    }

    @Test
    @TestOrder(300)
    public void testExec_C1() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        bean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg1(), "死亡保険金と税金", "（ＩＲ）メッセージ１");
        exStringEquals(siShrmeisaiBean.getIrMsg2(), "税金種類１", "（ＩＲ）メッセージ２");
        exStringEquals(siShrmeisaiBean.getIrMsg3(), "税金種類２", "（ＩＲ）メッセージ３");
        exStringEquals(siShrmeisaiBean.getIrMsg4(), "税金種類３", "（ＩＲ）メッセージ４");
        exStringEquals(siShrmeisaiBean.getIrMsg5(), "税金種類４", "（ＩＲ）メッセージ５");
        exStringEquals(siShrmeisaiBean.getIrMsg6(), "税金種類５", "（ＩＲ）メッセージ６");
        exStringEquals(siShrmeisaiBean.getIrMsg7(), "税金種類６", "（ＩＲ）メッセージ７");
        exStringEquals(siShrmeisaiBean.getIrMsg8(), "税金種類７", "（ＩＲ）メッセージ８");
        exStringEquals(siShrmeisaiBean.getIrMsg9(), "相続税１", "（ＩＲ）メッセージ９");
        exStringEquals(siShrmeisaiBean.getIrMsg10(), "相続税２", "（ＩＲ）メッセージ１０");
        exStringEquals(siShrmeisaiBean.getIrMsg11(), "相続税３", "（ＩＲ）メッセージ１１");
        exStringEquals(siShrmeisaiBean.getIrMsg12(), "所得税１", "（ＩＲ）メッセージ１２");
        exStringEquals(siShrmeisaiBean.getIrMsg13(), "所得税２", "（ＩＲ）メッセージ１３");
        exStringEquals(siShrmeisaiBean.getIrMsg14(), "所得税３", "（ＩＲ）メッセージ１４");
        exStringEquals(siShrmeisaiBean.getIrMsg15(), "所得税４", "（ＩＲ）メッセージ１５");
        exStringEquals(siShrmeisaiBean.getIrMsg16(), "所得税５", "（ＩＲ）メッセージ１６");
        exStringEquals(siShrmeisaiBean.getIrMsg17(), "所得税６", "（ＩＲ）メッセージ１７");
        exStringEquals(siShrmeisaiBean.getIrMsg18(), "贈与税１", "（ＩＲ）メッセージ１８");
        exStringEquals(siShrmeisaiBean.getIrMsg19(), "贈与税２", "（ＩＲ）メッセージ１９");
        exStringEquals(siShrmeisaiBean.getIrMsg20(), "贈与税３", "（ＩＲ）メッセージ２０");
        exStringEquals(siShrmeisaiBean.getIrMsg21(), "贈与税４", "（ＩＲ）メッセージ２１");
        exStringEquals(siShrmeisaiBean.getIrMsg22(), "課税年度１", "（ＩＲ）メッセージ２２");
        exStringEquals(siShrmeisaiBean.getIrMsg23(), "課税年度２", "（ＩＲ）メッセージ２３");
        exStringEquals(siShrmeisaiBean.getIrMsg24(), "課税年度３", "（ＩＲ）メッセージ２４");
        exStringEquals(siShrmeisaiBean.getIrMsg25(), "調書提出１", "（ＩＲ）メッセージ２５");
        exStringEquals(siShrmeisaiBean.getIrMsg26(), "調書提出２", "（ＩＲ）メッセージ２６");
        exStringEquals(siShrmeisaiBean.getIrMsg27(), "調書提出３", "（ＩＲ）メッセージ２７");
        exStringEquals(siShrmeisaiBean.getIrMsg28(), null, "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), null, "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), null, "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), null, "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), null, "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), null, "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), null, "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    @Test
    @TestOrder(310)
    public void testExec_C2() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        bean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg28(), "税務情報平準円貨１", "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), "税務情報平準円貨２", "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), "税務情報平準円貨３", "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), "税務情報平準円貨４", "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), "契約者変更１", "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), "契約者変更２", "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), "支払補足１", "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), "支払補足２", "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), "預り金１", "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), "預り金２", "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), null, "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    @Test
    @TestOrder(320)
    public void testExec_C3() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.JPY);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ZOUYO);
        bean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg28(), "支払補足１", "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), "支払補足２", "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), "未収Ｐ１", "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), "未収Ｐ２", "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), "未収Ｐ３", "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), "未収Ｐ４", "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), null, "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), null, "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    @Test
    @TestOrder(330)
    public void testExec_C4() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(0);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        bean.setKykjyoutai(C_Kykjyoutai.ITIJIBARAI);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg28(), "税務情報１", "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), "税務情報２", "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), "支払補足１", "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), "支払補足２", "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), "前納１", "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), "前納２", "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), "前納３", "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), null, "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    @Test
    @TestOrder(340)
    public void testExec_C5() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ITIJI);
        bean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg28(), "税務情報平準外貨１", "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), "税務情報平準外貨２", "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), "税務情報平準外貨３", "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), "税務情報平準外貨４", "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), "税務情報平準外貨５", "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), "契約者変更１", "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), "契約者変更２", "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), "支払補足１", "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), "支払補足２", "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), "未経過１", "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), "未経過２", "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    @Test
    @TestOrder(350)
    public void testExec_C6() {

        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditSiharaimeisaisyoBean bean = createEditSiharaimeisaisyoBean();
        bean.setSaikensyaInfoBean(createBlnkSaikensyaInfoBean());
        bean.setKykTuukasyu(C_Tuukasyu.USD);
        bean.setShrTuukasyu(C_Tuukasyu.USD);
        bean.setShrGk(BizCurrency.valueOf(11000, BizCurrencyTypes.DOLLAR));
        bean.setYenShrgk(BizCurrency.valueOf(1154450, BizCurrencyTypes.YEN));
        bean.setKykHnkKaisuu(1);
        bean.setZeitratkiKbn(C_ZeitratkiKbn.ZOUYO);
        bean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        bean.getSk().setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bean.getSk().setZennouseisankgk(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        bean.getSk().setMikeikap(BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR));
        List<ReportServicesBean> list = editSiharaimeisaisyo.exec(bean);
        exNumericEquals(list.size(), 1, "帳票サービスBeanリストサイズ");


        ReportServicesBean reportServicesBean = list.get(0);
        SiShrmeisaiBean siShrmeisaiBean = (SiShrmeisaiBean) reportServicesBean.getParamObjectsData().get(bean.getSiTyouhyouHensyuuCommonBean().getSyoruiCd().getValue())[0];
        exStringEquals(siShrmeisaiBean.getIrMsg28(), "課税対象１", "（ＩＲ）メッセージ２８");
        exStringEquals(siShrmeisaiBean.getIrMsg29(), "課税対象２", "（ＩＲ）メッセージ２９");
        exStringEquals(siShrmeisaiBean.getIrMsg30(), "支払補足１", "（ＩＲ）メッセージ３０");
        exStringEquals(siShrmeisaiBean.getIrMsg31(), "支払補足２", "（ＩＲ）メッセージ３１");
        exStringEquals(siShrmeisaiBean.getIrMsg32(), "前納１", "（ＩＲ）メッセージ３２");
        exStringEquals(siShrmeisaiBean.getIrMsg33(), "前納２", "（ＩＲ）メッセージ３３");
        exStringEquals(siShrmeisaiBean.getIrMsg34(), "前納３", "（ＩＲ）メッセージ３４");
        exStringEquals(siShrmeisaiBean.getIrMsg35(), null, "（ＩＲ）メッセージ３５");
        exStringEquals(siShrmeisaiBean.getIrMsg36(), null, "（ＩＲ）メッセージ３６");
        exStringEquals(siShrmeisaiBean.getIrMsg37(), null, "（ＩＲ）メッセージ３７");
        exStringEquals(siShrmeisaiBean.getIrMsg38(), null, "（ＩＲ）メッセージ３８");
        exStringEquals(siShrmeisaiBean.getIrMsg39(), null, "（ＩＲ）メッセージ３９");
        exStringEquals(siShrmeisaiBean.getIrMsg40(), null, "（ＩＲ）メッセージ４０");
        exStringEquals(siShrmeisaiBean.getIrMsg41(), null, "（ＩＲ）メッセージ４１");
        exStringEquals(siShrmeisaiBean.getIrMsg42(), null, "（ＩＲ）メッセージ４２");
        exStringEquals(siShrmeisaiBean.getIrMsg43(), null, "（ＩＲ）メッセージ４３");
        exStringEquals(siShrmeisaiBean.getIrMsg44(), null, "（ＩＲ）メッセージ４４");
        exStringEquals(siShrmeisaiBean.getIrMsg45(), null, "（ＩＲ）メッセージ４５");
        exStringEquals(siShrmeisaiBean.getIrMsg46(), null, "（ＩＲ）メッセージ４６");
    }

    private EditSiharaimeisaisyoBean createEditSiharaimeisaisyoBean() {
        EditSiharaimeisaisyoBean bean = SWAKInjector.getInstance(EditSiharaimeisaisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector.getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20160728"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        bean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        bean.setSeikyuusyaInfoBean(createSeikyuusyaInfoBean());
        bean.setToiawaseInfoBean(createToiawaseInfoBean());
        bean.setSyoNo("17806000013");
        bean.setKyknmKj("契約者名（漢字）");
        bean.setHhknnmKj("被保険者名（漢字）");
        bean.setTyakkinYmd(BizDate.valueOf("20160729"));
        bean.setSibouYmd(BizDate.valueOf("20160710"));
        bean.setShrKwsrate(BizNumber.valueOf(104.95));
        bean.setKnsnkijyunymd(BizDate.valueOf("20160725"));
        bean.setBanknmKj("みずほ銀行");
        bean.setSitennmKj("内幸町本店");
        bean.setYokinKbn(C_YokinKbn.HUTUU);
        bean.setKouzaNo("0987654");
        bean.setKzmeiginmKn("コウザメイギンンシメイカナ");
        bean.setSynykngk(BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN));
        bean.setHtykeihi(BizCurrency.valueOf(3000000, BizCurrencyTypes.YEN));
        bean.setKztkgk(BizCurrency.valueOf(4000000, BizCurrencyTypes.YEN));
        bean.setCctelNo("0479998888");
        bean.setShrKykHtyKeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        JT_Sk sk = new JT_Sk();
        sk.setAzukarikingk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        sk.setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        sk.setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        sk.setMikeikap(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bean.setSk(sk);
        List<JT_SiDetail> siSiDetailParamBeanLst = new ArrayList<>();
        bean.setSiDetailLst(siSiDetailParamBeanLst);
        return bean;
    }

    private SeikyuusyaInfoBean createSeikyuusyaInfoBean() {
        SeikyuusyaInfoBean bean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        bean.setSeikyuusyanmKj("請求者（漢字）");
        bean.setTsinyno("1112222");
        bean.setTsinadr1kj("通信先住所１（漢字）");
        bean.setTsinadr2kj("通信先住所２（漢字）");
        bean.setTsinadr3kj("通信先住所３（漢字）");
        return bean;
    }

    private ToiawaseInfoBean createToiawaseInfoBean() {
        ToiawaseInfoBean bean = SWAKInjector.getInstance(ToiawaseInfoBean.class);
        bean.setSosikiNm("問合せ先組織名");
        bean.setTsinyno("3334444");
        bean.setTsinadr1kj("問合せ先_通信先住所１（漢字）");
        bean.setTsinadr2kj("問合せ先_通信先住所２（漢字）");
        bean.setTsinadr3kj("問合せ先_通信先住所３（漢字）");
        bean.setTsintelno("0311112222");
        bean.setTelUktkKanouTime("電話受付可能時間");
        bean.setTelUktkkanouTimeHigou("電話受付可能時間備考");
        return bean;
    }

    private SaikensyaInfoBean createSaikensyaInfoBean() {
        SaikensyaInfoBean bean = SWAKInjector.getInstance(SaikensyaInfoBean.class);
        bean.setSaikennmkj("債権者氏名（漢字）");
        bean.setSaikennyno("5556666");
        bean.setSaikenadr1kj("債権者住所１（漢字）");
        bean.setSaikenadr2kj("債権者住所２（漢字）");
        bean.setSaikenadr3kj("債権者住所３（漢字）");
        return bean;
    }

    private SaikensyaInfoBean createBlnkSaikensyaInfoBean() {
        SaikensyaInfoBean bean = SWAKInjector.getInstance(SaikensyaInfoBean.class);
        bean.setSaikennmkj("");
        bean.setSaikennyno("");
        bean.setSaikenadr1kj("");
        bean.setSaikenadr2kj("");
        bean.setSaikenadr3kj("");
        return bean;
    }
}
