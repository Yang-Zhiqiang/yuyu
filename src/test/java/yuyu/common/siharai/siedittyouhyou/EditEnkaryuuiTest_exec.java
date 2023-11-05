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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyu;
import yuyu.common.siharai.sicommon.SiMeisaiCommonHensyuMockForSiharai;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiBean;
import yuyu.def.siharai.bean.report.SiEditEnkaryuuiDataSourceBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 保険金支払金額試算書編集のメソッド{@link EditEnkaryuui#exec(EditEnkaryuuiBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditEnkaryuuiTest_exec {
    @Inject
    private EditEnkaryuui editEnkaryuui;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金支払金額試算書編集";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SiMeisaiCommonHensyu.class).to(SiMeisaiCommonHensyuMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SiMeisaiCommonHensyuMockForSiharai.caller = EditEnkaryuuiTest_exec.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditEnkaryuuiTest_exec.class, fileName, sheetName);
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

        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk201", "TITLE"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk201", "ANNAI_NAIYOU"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk201", "RYUUI_JIKOU"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk114", "TITLE"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk114", "ANNAI_NAIYOU"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk114", "RYUUI_JIKOU"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151221"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151221));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151221));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(null);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='tuukasyu'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151221));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = null;
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='siHkkingakuSisanParamBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151221));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = null;
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='siSiDetailParamBeanList'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN1;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151221));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        try {
            editEnkaryuui.exec(editEnkaryuuiBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B1() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN3;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151111"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.USD);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);

        editEnkaryuuiBean.setSyoNo("17806000068");
        editEnkaryuuiBean.setKyknmKj("加藤小野");
        editEnkaryuuiBean.setHhknnmKj("加藤研");
        editEnkaryuuiBean.setUktnmKj("加藤奈");
        editEnkaryuuiBean.setUkthouKbn(C_SUketoriHouhouKbn.ZENGAKU_NENKIN);
        editEnkaryuuiBean.setCalckijyunYmd(BizDate.valueOf("20151221"));
        editEnkaryuuiBean.setUktbnWari("95.5");
        editEnkaryuuiBean.setHkgkGaika(BizCurrency.valueOf(10000));
        editEnkaryuuiBean.setHkgkYen(BizCurrency.valueOf(50000));

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000068", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151111), "処理日付");

        Object[] objects = reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU.getValue());
        SiEditEnkaryuuiBean siEditEnkaryuuiBean = (SiEditEnkaryuuiBean) (objects[0]);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU.getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 26, "円貨支払留意事項説明文書編集帳票DSBEANリストサイズ");
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean1 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(0);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean2 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(1);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean3 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(2);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean4 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(3);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean5 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(4);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean6 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(5);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean7 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(6);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean8 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(7);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean9 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(8);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean10 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(9);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean11 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(10);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean12 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(11);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean13 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(12);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean14 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(13);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean15 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(14);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean16 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(15);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean17 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(16);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean18 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(17);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean19 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(18);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean20 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(19);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean21 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(20);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean22 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(21);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean23 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(22);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean24 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(23);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean25 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(24);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean26 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(25);

        exStringEquals(siEditEnkaryuuiBean.getIrTyouhyoutitle(), "（タイトルを登録する。）", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg1(), "（案内メッセージ１を登録する。）", "（ＩＲ）メッセージ１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg2(), "（案内メッセージ２を登録する。）", "（ＩＲ）メッセージ２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg3(), "（案内メッセージ３を登録する。）", "（ＩＲ）メッセージ３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg4(), "（案内メッセージ４を登録する。）", "（ＩＲ）メッセージ４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg5(), "（案内メッセージ５を登録する。）", "（ＩＲ）メッセージ５");

        exStringEquals(siEditEnkaryuuiBean.getIrSyono(), "17806000068", "（ＩＲ）証券番号");
        exStringEquals(siEditEnkaryuuiBean.getIrKyknmkj(), "加藤小野", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHhknnmkj(), "加藤研", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrUktnmkj(), "加藤奈", " （ＩＲ）受取人名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHokenkinsyurui(), null, " （ＩＲ）保険金種類");
        exStringEquals(siEditEnkaryuuiBean.getIrUkthou(), "全額年金", " （ＩＲ）受取方法");
        exStringEquals(siEditEnkaryuuiBean.getIrCalckijyunymd(), "2015年12月21日", "（ＩＲ）計算基準日");
        exStringEquals(siEditEnkaryuuiBean.getIrDispyenkansantkykwsrate(), null, "（ＩＲ）円換算適用為替レート");
        exStringEquals(siEditEnkaryuuiBean.getIrUktbnwari(), "95.5 ％", "（ＩＲ）受取人分割割合");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkgaika(), BizCurrency.valueOf(10000), "（ＩＲ）保険金額（外貨）");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkyen(), BizCurrency.valueOf(50000), "（ＩＲ）保険金額（円貨）");

        exStringEquals(siEditEnkaryuuiBean.getIrMsg6(), "（留意事項文言１を登録する。）", "（ＩＲ）メッセージ６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg7(), "（留意事項文言２を登録する。）", "（ＩＲ）メッセージ７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg8(), "（留意事項文言３を登録する。）", "（ＩＲ）メッセージ８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg9(), "（留意事項文言４を登録する。）", "（ＩＲ）メッセージ９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg10(), "（留意事項文言５を登録する。）", "（ＩＲ）メッセージ１０");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg11(), "（留意事項文言６を登録する。）", "（ＩＲ）メッセージ１１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg12(), "（留意事項文言７を登録する。）", "（ＩＲ）メッセージ１２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg13(), "（留意事項文言８を登録する。）", "（ＩＲ）メッセージ１３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg14(), "（留意事項文言９を登録する。）", "（ＩＲ）メッセージ１４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg15(), "（留意事項文言１０を登録する。）", "（ＩＲ）メッセージ１５");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg16(), "（留意事項文言１１を登録する。）", "（ＩＲ）メッセージ１６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg17(), "（留意事項文言１２を登録する。）", "（ＩＲ）メッセージ１７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg18(), "（留意事項文言１３を登録する。）", "（ＩＲ）メッセージ１８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg19(), "（留意事項文言１４を登録する。）", "（ＩＲ）メッセージ１９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg20(), "（留意事項文言１５を登録する。）", "（ＩＲ）メッセージ２０");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutgkhyjumu(), C_UmuKbn.ARI, "（ＩＲ）レイアウト（外貨）表示有無");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutyenhyjumu(), C_UmuKbn.NONE, "（ＩＲ）レイアウト（円貨）表示有無");

        exClassificationEquals(siEditEnkaryuuiDataSourceBean1.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrKyuuhuname(), "外貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean1.getIrKyhkg(), BizCurrency.valueOf(1111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrShrdetailbikou(), "外貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean2.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrKyuuhuname(), "外貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean2.getIrKyhkg(), BizCurrency.valueOf(2222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrShrdetailbikou(), "外貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean3.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrKyuuhuname(), "外貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean3.getIrKyhkg(), BizCurrency.valueOf(3333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrShrdetailbikou(), "外貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean4.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean4.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean5.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean5.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean6.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean6.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean7.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean7.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean8.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean8.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean9.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean9.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean10.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean10.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean11.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean11.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean12.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean12.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean13.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean13.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean14.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrKyuuhuname(), "円貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean14.getIrKyhkg(), BizCurrency.valueOf(111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrShrdetailbikou(), "円貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean15.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrKyuuhuname(), "円貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean15.getIrKyhkg(), BizCurrency.valueOf(222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrShrdetailbikou(), "円貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean16.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrKyuuhuname(), "円貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean16.getIrKyhkg(), BizCurrency.valueOf(333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrShrdetailbikou(), "円貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean17.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean17.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean18.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean18.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean19.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean19.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean20.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean20.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean21.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean21.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean22.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean22.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean23.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean23.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean24.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean24.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean25.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean25.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean26.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean26.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk201", "ANNAI_NAIYOU"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk201", "RYUUI_JIKOU"));
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B2() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN3;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151111));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.USD);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);

        editEnkaryuuiBean.setSyoNo("17806000068");
        editEnkaryuuiBean.setKyknmKj("加藤小野");
        editEnkaryuuiBean.setHhknnmKj("加藤研");
        editEnkaryuuiBean.setUktnmKj("加藤奈");
        editEnkaryuuiBean.setUkthouKbn(C_SUketoriHouhouKbn.ITIBU_NENKIN);
        editEnkaryuuiBean.setCalckijyunYmd(BizDate.valueOf(20151221));
        editEnkaryuuiBean.setUktbnWari("95.5");
        editEnkaryuuiBean.setHkgkGaika(BizCurrency.valueOf(10000));
        editEnkaryuuiBean.setHkgkYen(BizCurrency.valueOf(50000));

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000068", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151111), "処理日付");

        Object[] objects = reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU.getValue());
        SiEditEnkaryuuiBean siEditEnkaryuuiBean = (SiEditEnkaryuuiBean) (objects[0]);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU.getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 26, "円貨支払留意事項説明文書編集帳票DSBEANリストサイズ");
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean1 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(0);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean2 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(1);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean3 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(2);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean4 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(3);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean5 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(4);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean6 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(5);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean7 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(6);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean8 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(7);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean9 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(8);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean10 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(9);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean11 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(10);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean12 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(11);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean13 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(12);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean14 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(13);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean15 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(14);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean16 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(15);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean17 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(16);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean18 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(17);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean19 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(18);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean20 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(19);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean21 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(20);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean22 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(21);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean23 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(22);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean24 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(23);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean25 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(24);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean26 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(25);

        exStringEquals(siEditEnkaryuuiBean.getIrTyouhyoutitle(), "（タイトルを登録する。）", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg1(), null, "（ＩＲ）メッセージ１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg2(), null, "（ＩＲ）メッセージ２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");

        exStringEquals(siEditEnkaryuuiBean.getIrSyono(), "17806000068", "（ＩＲ）証券番号");
        exStringEquals(siEditEnkaryuuiBean.getIrKyknmkj(), "加藤小野", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHhknnmkj(), "加藤研", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrUktnmkj(), "加藤奈", " （ＩＲ）受取人名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHokenkinsyurui(), null, " （ＩＲ）保険金種類");
        exStringEquals(siEditEnkaryuuiBean.getIrUkthou(), "一部年金", " （ＩＲ）受取方法");
        exStringEquals(siEditEnkaryuuiBean.getIrCalckijyunymd(), "2015年12月21日", "（ＩＲ）計算基準日");
        exStringEquals(siEditEnkaryuuiBean.getIrDispyenkansantkykwsrate(), null, "（ＩＲ）円換算適用為替レート");
        exStringEquals(siEditEnkaryuuiBean.getIrUktbnwari(), "95.5 ％", "（ＩＲ）受取人分割割合");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkgaika(), BizCurrency.valueOf(10000), "（ＩＲ）保険金額（外貨）");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkyen(), BizCurrency.valueOf(50000), "（ＩＲ）保険金額（円貨）");

        exStringEquals(siEditEnkaryuuiBean.getIrMsg6(), null, "（ＩＲ）メッセージ６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg7(), null, "（ＩＲ）メッセージ７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg8(), null, "（ＩＲ）メッセージ８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg9(), null, "（ＩＲ）メッセージ９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg10(), null, "（ＩＲ）メッセージ１０");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg11(), null, "（ＩＲ）メッセージ１１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg12(), null, "（ＩＲ）メッセージ１２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg13(), null, "（ＩＲ）メッセージ１３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg14(), null, "（ＩＲ）メッセージ１４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg15(), null, "（ＩＲ）メッセージ１５");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg16(), null, "（ＩＲ）メッセージ１６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg17(), null, "（ＩＲ）メッセージ１７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg18(), null, "（ＩＲ）メッセージ１８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg19(), null, "（ＩＲ）メッセージ１９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutgkhyjumu(), C_UmuKbn.ARI, "（ＩＲ）レイアウト（外貨）表示有無");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutyenhyjumu(), C_UmuKbn.NONE, "（ＩＲ）レイアウト（円貨）表示有無");

        exClassificationEquals(siEditEnkaryuuiDataSourceBean1.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrKyuuhuname(), "外貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean1.getIrKyhkg(), BizCurrency.valueOf(1111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrShrdetailbikou(), "外貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean2.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrKyuuhuname(), "外貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean2.getIrKyhkg(), BizCurrency.valueOf(2222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrShrdetailbikou(), "外貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean3.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrKyuuhuname(), "外貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean3.getIrKyhkg(), BizCurrency.valueOf(3333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrShrdetailbikou(), "外貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean4.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean4.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean5.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean5.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean6.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean6.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean7.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean7.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean8.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean8.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean9.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean9.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean10.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean10.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean11.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean11.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean12.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean12.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean13.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean13.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean14.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrKyuuhuname(), "円貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean14.getIrKyhkg(), BizCurrency.valueOf(111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrShrdetailbikou(), "円貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean15.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrKyuuhuname(), "円貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean15.getIrKyhkg(), BizCurrency.valueOf(222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrShrdetailbikou(), "円貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean16.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrKyuuhuname(), "円貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean16.getIrKyhkg(), BizCurrency.valueOf(333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrShrdetailbikou(), "円貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean17.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean17.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean18.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean18.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean19.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean19.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean20.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean20.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean21.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean21.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean22.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean22.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean23.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean23.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean24.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean24.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean25.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean25.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean26.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean26.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B3() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN3;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151111"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_INKAN);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.USD);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        editEnkaryuuiBean.setSyoNo("17806000068");
        editEnkaryuuiBean.setKyknmKj("加藤小野");
        editEnkaryuuiBean.setHhknnmKj("加藤研");
        editEnkaryuuiBean.setUktnmKj("加藤奈");
        editEnkaryuuiBean.setUkthouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        editEnkaryuuiBean.setCalckijyunYmd(BizDate.valueOf(20151221));
        editEnkaryuuiBean.setUktbnWari("95.5");
        editEnkaryuuiBean.setHkgkGaika(BizCurrency.valueOf(10000));
        editEnkaryuuiBean.setHkgkYen(BizCurrency.valueOf(50000));

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000068", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151111), "処理日付");

        Object[] objects = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.HK_SB_INKAN.getValue());
        SiEditEnkaryuuiBean siEditEnkaryuuiBean = (SiEditEnkaryuuiBean) (objects[0]);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.HK_SB_INKAN.getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 26, "円貨支払留意事項説明文書編集帳票DSBEANリストサイズ");
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean1 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(0);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean2 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(1);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean3 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(2);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean4 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(3);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean5 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(4);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean6 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(5);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean7 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(6);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean8 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(7);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean9 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(8);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean10 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(9);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean11 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(10);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean12 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(11);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean13 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(12);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean14 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(13);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean15 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(14);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean16 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(15);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean17 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(16);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean18 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(17);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean19 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(18);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean20 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(19);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean21 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(20);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean22 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(21);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean23 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(22);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean24 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(23);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean25 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(24);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean26 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(25);


        exStringEquals(siEditEnkaryuuiBean.getIrTyouhyoutitle(), "帳票タイトル", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg1(), "メッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg2(), "メッセージ２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg3(), "メッセージ３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg4(), "メッセージ４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg5(), "メッセージ５", "（ＩＲ）メッセージ５");

        exStringEquals(siEditEnkaryuuiBean.getIrSyono(), "17806000068", "（ＩＲ）証券番号");
        exStringEquals(siEditEnkaryuuiBean.getIrKyknmkj(), "加藤小野", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHhknnmkj(), "加藤研", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrUktnmkj(), "加藤奈", " （ＩＲ）受取人名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHokenkinsyurui(), null, " （ＩＲ）保険金種類");
        exStringEquals(siEditEnkaryuuiBean.getIrUkthou(), "全額一時金", " （ＩＲ）受取方法");
        exStringEquals(siEditEnkaryuuiBean.getIrCalckijyunymd(), "2015年12月21日", "（ＩＲ）計算基準日");
        exStringEquals(siEditEnkaryuuiBean.getIrDispyenkansantkykwsrate(), null, "（ＩＲ）円換算適用為替レート");
        exStringEquals(siEditEnkaryuuiBean.getIrUktbnwari(), "95.5 ％", "（ＩＲ）受取人分割割合");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkgaika(), BizCurrency.valueOf(10000), "（ＩＲ）保険金額（外貨）");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkyen(), BizCurrency.valueOf(50000), "（ＩＲ）保険金額（円貨）");

        exStringEquals(siEditEnkaryuuiBean.getIrMsg6(), "メッセージ６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg7(), "メッセージ７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg8(), "メッセージ８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg9(), "メッセージ９", "（ＩＲ）メッセージ９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg10(), "メッセージ１０", "（ＩＲ）メッセージ１０");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg11(), "メッセージ１１", "（ＩＲ）メッセージ１１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg12(), "メッセージ１２", "（ＩＲ）メッセージ１２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg13(), "メッセージ１３", "（ＩＲ）メッセージ１３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg14(), "メッセージ１４", "（ＩＲ）メッセージ１４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg15(), "メッセージ１５", "（ＩＲ）メッセージ１５");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg16(), "メッセージ１６", "（ＩＲ）メッセージ１６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg17(), "メッセージ１７", "（ＩＲ）メッセージ１７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg18(), "メッセージ１８", "（ＩＲ）メッセージ１８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg19(), "メッセージ１９", "（ＩＲ）メッセージ１９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg20(), "メッセージ２０", "（ＩＲ）メッセージ２０");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutgkhyjumu(), C_UmuKbn.ARI, "（ＩＲ）レイアウト（外貨）表示有無");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutyenhyjumu(), C_UmuKbn.NONE, "（ＩＲ）レイアウト（円貨）表示有無");

        exClassificationEquals(siEditEnkaryuuiDataSourceBean1.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrKyuuhuname(), "外貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean1.getIrKyhkg(), BizCurrency.valueOf(1111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrShrdetailbikou(), "外貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean2.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrKyuuhuname(), "外貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean2.getIrKyhkg(), BizCurrency.valueOf(2222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrShrdetailbikou(), "外貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean3.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrKyuuhuname(), "外貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean3.getIrKyhkg(), BizCurrency.valueOf(3333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrShrdetailbikou(), "外貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean4.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean4.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean5.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean5.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean6.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean6.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean7.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean7.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean8.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean8.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean9.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean9.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean10.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean10.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean11.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean11.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean12.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean12.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean13.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean13.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean14.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrKyuuhuname(), "円貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean14.getIrKyhkg(), BizCurrency.valueOf(111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrShrdetailbikou(), "円貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean15.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrKyuuhuname(), "円貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean15.getIrKyhkg(), BizCurrency.valueOf(222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrShrdetailbikou(), "円貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean16.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrKyuuhuname(), "円貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean16.getIrKyhkg(), BizCurrency.valueOf(333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrShrdetailbikou(), "円貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean17.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean17.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean18.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean18.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean19.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean19.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean20.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean20.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean21.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean21.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean22.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean22.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean23.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean23.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean24.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean24.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean25.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean25.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean26.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean26.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
    }

    @Test
    @TestOrder(110)
    public void testExec_C1() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN2;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151112"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        editEnkaryuuiBean.setSyoNo("17806000068");
        editEnkaryuuiBean.setKyknmKj("加藤小野０１");
        editEnkaryuuiBean.setHhknnmKj("加藤研０１");
        editEnkaryuuiBean.setUktnmKj("加藤奈０１");
        editEnkaryuuiBean.setUkthouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        editEnkaryuuiBean.setCalckijyunYmd(BizDate.valueOf(20151221));
        editEnkaryuuiBean.setUktbnWari("95.5");
        editEnkaryuuiBean.setHkgkGaika(BizCurrency.valueOf(10000));
        editEnkaryuuiBean.setHkgkYen(BizCurrency.valueOf(50000));
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.JPY);

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000068", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151112), "処理日付");

        Object[] objects = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO.getValue());
        SiEditEnkaryuuiBean siEditEnkaryuuiBean = (SiEditEnkaryuuiBean) (objects[0]);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO.getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 13, "円貨支払留意事項説明文書編集帳票DSBEANリストサイズ");
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean1 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(0);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean2 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(1);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean3 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(2);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean4 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(3);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean5 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(4);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean6 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(5);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean7 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(6);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean8 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(7);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean9 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(8);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean10 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(9);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean11 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(10);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean12 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(11);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean13 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(12);

        exStringEquals(siEditEnkaryuuiBean.getIrTyouhyoutitle(), "帳票タイトル０１", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg1(), "メッセージ０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg2(), "メッセージ０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg3(), "メッセージ０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg4(), "メッセージ０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg5(), "メッセージ０５", "（ＩＲ）メッセージ５");

        exStringEquals(siEditEnkaryuuiBean.getIrSyono(), "17806000068", "（ＩＲ）証券番号");
        exStringEquals(siEditEnkaryuuiBean.getIrKyknmkj(), "加藤小野０１", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHhknnmkj(), "加藤研０１", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrUktnmkj(), "加藤奈０１", " （ＩＲ）受取人名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHokenkinsyurui(), null, " （ＩＲ）保険金種類");
        exStringEquals(siEditEnkaryuuiBean.getIrUkthou(), "全額一時金", " （ＩＲ）受取方法");
        exStringEquals(siEditEnkaryuuiBean.getIrCalckijyunymd(), "2015年12月21日", "（ＩＲ）計算基準日");
        exStringEquals(siEditEnkaryuuiBean.getIrDispyenkansantkykwsrate(), null, "（ＩＲ）円換算適用為替レート");
        exStringEquals(siEditEnkaryuuiBean.getIrUktbnwari(), "95.5 ％", "（ＩＲ）受取人分割割合");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkgaika(), BizCurrency.optional(), "（ＩＲ）保険金額（外貨）");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkyen(), BizCurrency.valueOf(10000), "（ＩＲ）保険金額（円貨）");

        exStringEquals(siEditEnkaryuuiBean.getIrMsg6(), "メッセージ１０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg7(), "メッセージ１０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg8(), "メッセージ１０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg9(), "メッセージ１０９", "（ＩＲ）メッセージ９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg10(), "メッセージ１１０", "（ＩＲ）メッセージ１０");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg11(), "メッセージ１１１", "（ＩＲ）メッセージ１１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg12(), "メッセージ１１２", "（ＩＲ）メッセージ１２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg13(), "メッセージ１１３", "（ＩＲ）メッセージ１３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg14(), "メッセージ１１４", "（ＩＲ）メッセージ１４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg15(), "メッセージ１１５", "（ＩＲ）メッセージ１５");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg16(), "メッセージ１１６", "（ＩＲ）メッセージ１６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg17(), "メッセージ１１７", "（ＩＲ）メッセージ１７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg18(), "メッセージ１１８", "（ＩＲ）メッセージ１８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg19(), "メッセージ１１９", "（ＩＲ）メッセージ１９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg20(), "メッセージ１２０", "（ＩＲ）メッセージ２０");

        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutgkhyjumu(), C_UmuKbn.NONE, "（ＩＲ）レイアウト（外貨）表示有無");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutyenhyjumu(), C_UmuKbn.ARI, "（ＩＲ）レイアウト（円貨）表示有無");

        exClassificationEquals(siEditEnkaryuuiDataSourceBean1.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrKyuuhuname(), "円貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean1.getIrKyhkg(), BizCurrency.valueOf(111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrShrdetailbikou(), "円貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean2.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrKyuuhuname(), "円貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean2.getIrKyhkg(), BizCurrency.valueOf(222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrShrdetailbikou(), "円貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean3.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrKyuuhuname(), "円貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean3.getIrKyhkg(), BizCurrency.valueOf(333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrShrdetailbikou(), "円貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean4.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean4.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean5.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean5.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean6.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean6.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean7.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean7.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean8.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean8.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean9.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean9.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean10.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean10.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean11.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean11.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean12.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean12.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean13.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrKyuuhuname(), "", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean13.getIrKyhkg(), null, "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrShrdetailbikou(), "", "（ＩＲ）支払明細備考");
    }

    @Test
    @TestOrder(120)
    public void testExec_C2() {
        MockObjectManager.initialize();
        SiMeisaiCommonHensyuMockForSiharai.SYORIPTN = SiMeisaiCommonHensyuMockForSiharai.TESTPATTERN4;
        EditEnkaryuuiBean editEnkaryuuiBean = SWAKInjector.getInstance(EditEnkaryuuiBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf("20151112"));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO);
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.USD);
        SiHkkingakuSisanParamBean siHkkingakuSisanParamBean = SWAKInjector
            .getInstance(SiHkkingakuSisanParamBean.class);
        List<SiSiDetailParamBean> siSiDetailParamBeanList = new ArrayList<SiSiDetailParamBean>();
        editEnkaryuuiBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editEnkaryuuiBean.setSiHkkingakuSisanParamBean(siHkkingakuSisanParamBean);
        editEnkaryuuiBean.setSiSiDetailParamBeanList(siSiDetailParamBeanList);
        editEnkaryuuiBean.setSyoNo("17806000068");
        editEnkaryuuiBean.setKyknmKj("加藤小野０１");
        editEnkaryuuiBean.setHhknnmKj("加藤研０１");
        editEnkaryuuiBean.setUktnmKj("加藤奈０１");
        editEnkaryuuiBean.setUkthouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        editEnkaryuuiBean.setCalckijyunYmd(BizDate.valueOf(20151221));
        editEnkaryuuiBean.setUktbnWari("95.5");
        editEnkaryuuiBean.setHkgkGaika(BizCurrency.valueOf(10000));
        editEnkaryuuiBean.setHkgkYen(BizCurrency.valueOf(50000));
        editEnkaryuuiBean.setTuukasyu(C_Tuukasyu.USD);

        ReportServicesBean reportServicesBean = editEnkaryuui.exec(editEnkaryuuiBean);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000068", "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151112), "処理日付");

        Object[] objects = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO.getValue());
        SiEditEnkaryuuiBean siEditEnkaryuuiBean = (SiEditEnkaryuuiBean) (objects[0]);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.HK_SB_KAKUNINDOUISYO.getValue());
        exNumericEquals(iReportDataSouceBeanLst.size(), 26, "円貨支払留意事項説明文書編集帳票DSBEANリストサイズ");
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean1 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(0);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean2 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(1);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean3 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(2);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean4 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(3);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean5 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(4);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean6 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(5);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean7 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(6);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean8 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(7);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean9 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(8);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean10 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(9);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean11 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(10);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean12 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(11);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean13 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(12);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean14 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(13);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean15 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(14);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean16 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(15);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean17 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(16);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean18 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(17);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean19 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(18);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean20 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(19);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean21 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(20);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean22 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(21);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean23 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(22);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean24 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(23);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean25 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(24);
        SiEditEnkaryuuiDataSourceBean siEditEnkaryuuiDataSourceBean26 = (SiEditEnkaryuuiDataSourceBean) iReportDataSouceBeanLst.get(25);

        exStringEquals(siEditEnkaryuuiBean.getIrTyouhyoutitle(), "帳票タイトル０１", "（ＩＲ）帳票タイトル");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg1(), "メッセージ０１", "（ＩＲ）メッセージ１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg2(), "メッセージ０２", "（ＩＲ）メッセージ２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg3(), "メッセージ０３", "（ＩＲ）メッセージ３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg4(), "メッセージ０４", "（ＩＲ）メッセージ４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg5(), "メッセージ０５", "（ＩＲ）メッセージ５");

        exStringEquals(siEditEnkaryuuiBean.getIrSyono(), "17806000068", "（ＩＲ）証券番号");
        exStringEquals(siEditEnkaryuuiBean.getIrKyknmkj(), "加藤小野０１", "（ＩＲ）契約者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHhknnmkj(), "加藤研０１", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrUktnmkj(), "加藤奈０１", " （ＩＲ）受取人名（漢字）");
        exStringEquals(siEditEnkaryuuiBean.getIrHokenkinsyurui(), null, " （ＩＲ）保険金種類");
        exStringEquals(siEditEnkaryuuiBean.getIrUkthou(), "全額一時金", " （ＩＲ）受取方法");
        exStringEquals(siEditEnkaryuuiBean.getIrCalckijyunymd(), "2015年12月21日", "（ＩＲ）計算基準日");
        exStringEquals(siEditEnkaryuuiBean.getIrDispyenkansantkykwsrate(), null, "（ＩＲ）円換算適用為替レート");
        exStringEquals(siEditEnkaryuuiBean.getIrUktbnwari(), "95.5 ％", "（ＩＲ）受取人分割割合");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkgaika(), BizCurrency.valueOf(10000), "（ＩＲ）保険金額（外貨）");
        exBizCalcbleEquals(siEditEnkaryuuiBean.getIrHkgkyen(), BizCurrency.valueOf(50000), "（ＩＲ）保険金額（円貨）");

        exStringEquals(siEditEnkaryuuiBean.getIrMsg6(), "メッセージ０６", "（ＩＲ）メッセージ６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg7(), "メッセージ０７", "（ＩＲ）メッセージ７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg8(), "メッセージ０８", "（ＩＲ）メッセージ８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg9(), "メッセージ０９", "（ＩＲ）メッセージ９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg10(), "メッセージ０１０", "（ＩＲ）メッセージ１０");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg11(), "メッセージ０１１", "（ＩＲ）メッセージ１１");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg12(), "メッセージ０１２", "（ＩＲ）メッセージ１２");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg13(), "メッセージ０１３", "（ＩＲ）メッセージ１３");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg14(), "メッセージ０１４", "（ＩＲ）メッセージ１４");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg15(), "メッセージ０１５", "（ＩＲ）メッセージ１５");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg16(), "メッセージ０１６", "（ＩＲ）メッセージ１６");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg17(), "メッセージ０１７", "（ＩＲ）メッセージ１７");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg18(), "メッセージ０１８", "（ＩＲ）メッセージ１８");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg19(), "メッセージ０１９", "（ＩＲ）メッセージ１９");
        exStringEquals(siEditEnkaryuuiBean.getIrMsg20(), "メッセージ０２０", "（ＩＲ）メッセージ２０");

        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutgkhyjumu(), C_UmuKbn.ARI, "（ＩＲ）レイアウト（外貨）表示有無");
        exClassificationEquals(siEditEnkaryuuiBean.getIrLayoutyenhyjumu(), C_UmuKbn.NONE, "（ＩＲ）レイアウト（円貨）表示有無");

        exClassificationEquals(siEditEnkaryuuiDataSourceBean1.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrKyuuhuname(), "外貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean1.getIrKyhkg(), BizCurrency.valueOf(1111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean1.getIrShrdetailbikou(), "外貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean2.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrKyuuhuname(), "外貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean2.getIrKyhkg(), BizCurrency.valueOf(2222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean2.getIrShrdetailbikou(), "外貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean3.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrKyuuhuname(), "外貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean3.getIrKyhkg(), BizCurrency.valueOf(3333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean3.getIrShrdetailbikou(), "外貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean4.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrKyuuhuname(), "外貨給付名４", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean4.getIrKyhkg(), BizCurrency.valueOf(4444444), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean4.getIrShrdetailbikou(), "外貨備考４", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean5.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrKyuuhuname(), "外貨給付名５", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean5.getIrKyhkg(), BizCurrency.valueOf(5555555), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean5.getIrShrdetailbikou(), "外貨備考５", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean6.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrKyuuhuname(), "外貨給付名６", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean6.getIrKyhkg(), BizCurrency.valueOf(6666666), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean6.getIrShrdetailbikou(), "外貨備考６", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean7.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrKyuuhuname(), "外貨給付名７", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean7.getIrKyhkg(), BizCurrency.valueOf(7777777), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean7.getIrShrdetailbikou(), "外貨備考７", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean8.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrKyuuhuname(), "外貨給付名８", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean8.getIrKyhkg(), BizCurrency.valueOf(8888888), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean8.getIrShrdetailbikou(), "外貨備考８", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean9.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrKyuuhuname(), "外貨給付名９", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean9.getIrKyhkg(), BizCurrency.valueOf(9999999), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean9.getIrShrdetailbikou(), "外貨備考９", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean10.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrKyuuhuname(), "外貨給付名１０", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean10.getIrKyhkg(), BizCurrency.valueOf(1010101), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean10.getIrShrdetailbikou(), "外貨備考１０", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean11.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrKyuuhuname(), "外貨給付名１１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean11.getIrKyhkg(), BizCurrency.valueOf(1101101), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean11.getIrShrdetailbikou(), "外貨備考１１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean12.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrKyuuhuname(), "外貨給付名１２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean12.getIrKyhkg(), BizCurrency.valueOf(1201201), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean12.getIrShrdetailbikou(), "外貨備考１２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean13.getIrTuukasyu(), C_Tuukasyu.USD, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrKyuuhuname(), "外貨給付名１３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean13.getIrKyhkg(), BizCurrency.valueOf(1301301), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean13.getIrShrdetailbikou(), "外貨備考１３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean14.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrKyuuhuname(), "円貨給付名１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean14.getIrKyhkg(), BizCurrency.valueOf(111111), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean14.getIrShrdetailbikou(), "円貨備考１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean15.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrKyuuhuname(), "円貨給付名２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean15.getIrKyhkg(), BizCurrency.valueOf(222222), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean15.getIrShrdetailbikou(), "円貨備考２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean16.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrKyuuhuname(), "円貨給付名３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean16.getIrKyhkg(), BizCurrency.valueOf(333333), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean16.getIrShrdetailbikou(), "円貨備考３", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean17.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrKyuuhuname(), "円貨給付名４", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean17.getIrKyhkg(), BizCurrency.valueOf(444444), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean17.getIrShrdetailbikou(), "円貨備考４", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean18.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrKyuuhuname(), "円貨給付名５", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean18.getIrKyhkg(), BizCurrency.valueOf(555555), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean18.getIrShrdetailbikou(), "円貨備考５", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean19.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrKyuuhuname(), "円貨給付名６", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean19.getIrKyhkg(), BizCurrency.valueOf(666666), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean19.getIrShrdetailbikou(), "円貨備考６", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean20.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrKyuuhuname(), "円貨給付名７", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean20.getIrKyhkg(), BizCurrency.valueOf(777777), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean20.getIrShrdetailbikou(), "円貨備考７", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean21.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrKyuuhuname(), "円貨給付名８", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean21.getIrKyhkg(), BizCurrency.valueOf(888888), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean21.getIrShrdetailbikou(), "円貨備考８", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean22.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrKyuuhuname(), "円貨給付名９", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean22.getIrKyhkg(), BizCurrency.valueOf(999999), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean22.getIrShrdetailbikou(), "円貨備考９", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean23.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrKyuuhuname(), "円貨給付名１０", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean23.getIrKyhkg(), BizCurrency.valueOf(101010), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean23.getIrShrdetailbikou(), "円貨備考１０", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean24.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrKyuuhuname(), "円貨給付名１１", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean24.getIrKyhkg(), BizCurrency.valueOf(110110), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean24.getIrShrdetailbikou(), "円貨備考１１", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean25.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrKyuuhuname(), "円貨給付名１２", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean25.getIrKyhkg(), BizCurrency.valueOf(121212), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean25.getIrShrdetailbikou(), "円貨備考１２", "（ＩＲ）支払明細備考");
        exClassificationEquals(siEditEnkaryuuiDataSourceBean26.getIrTuukasyu(), C_Tuukasyu.JPY, "（ＩＲ）通貨種類");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrKyuuhuname(), "円貨給付名１３", "（ＩＲ）給付名");
        exBizCalcbleEquals(siEditEnkaryuuiDataSourceBean26.getIrKyhkg(), BizCurrency.valueOf(131313), "（ＩＲ）給付金額");
        exStringEquals(siEditEnkaryuuiDataSourceBean26.getIrShrdetailbikou(), "円貨備考１３", "（ＩＲ）支払明細備考");
    }
}
