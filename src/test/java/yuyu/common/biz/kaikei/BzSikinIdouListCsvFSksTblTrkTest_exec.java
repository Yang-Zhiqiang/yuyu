package yuyu.common.biz.kaikei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHtkinDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunDataSourceBean;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunDataSourceBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 資金移動リストＣＳＶファイル作成用テーブル登録クラスのメソッド {@link BzSikinIdouListCsvFSksTblTrk#exec(BizDate, List<IReportDataSouceBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSikinIdouListCsvFSksTblTrkTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_資金移動リストＣＳＶファイル作成用テーブル登録";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzSikinIdouListCsvFSksTblTrkTest_exec.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListSokujibunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListSokujibunDataSourceBean.class);
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200907"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListSokujibunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListSokujibunDataSourceBean.class);
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200908"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListYendthnkbunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBean.class);
        dsBean.setIrSikinidoukbnnm("円建変更取消分");
        dsBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(123456789012345L));
        dsBean.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(123456789012346L));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        BzSikinIdouListYendthnkbunDataSourceBean dsBean2 = SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBean.class);
        dsBean2.setIrSikinidoukbnnm("入金取消分");
        dsBean2.setIrKeiritrhktuukagk(BizCurrency.valueOf(223456789012345L));
        dsBean2.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        dsBean2.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(223456789012346L));
        dsBean2.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean2);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200905"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B1() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListTyakkinbibunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListTyakkinbibunDataSourceBean.class);
        dsBean.setIrTyakkinymd8keta(BizDate.valueOf(20200911));
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(12));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200909"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B2() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListYendthnkbunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBean.class);
        dsBean.setIrSikinidoukbnnm("円建変更取消分");
        dsBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(13));
        dsBean.setIrKeiritrhktuukasyu(C_Tuukasyu.AUD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200910"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B3() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListYendthnkbunDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListYendthnkbunDataSourceBean.class);
        dsBean.setIrSikinidoukbnnm("入金取消分");
        dsBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(13));
        dsBean.setIrKeiritrhktuukasyu(C_Tuukasyu.JPY);
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(14));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200911"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_B4() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListHijynbrNykDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListHijynbrNykDataSourceBean.class);
        dsBean.setIrSikinidoukbnnm("入金取消分");
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(15));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200912"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_B5() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListHijynbrNykDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListHijynbrNykDataSourceBean.class);
        dsBean.setIrSikinidoukbnnm("円建変更取消分");
        dsBean.setIrKeiritrhktuukagk(BizCurrency.valueOf(16));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.AUD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200915"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_B6() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        BzSikinIdouListHtkinDataSourceBean dsBean = SWAKInjector.getInstance(BzSikinIdouListHtkinDataSourceBean.class);
        dsBean.setIrKeirisiteituukagkgaika(BizCurrency.valueOf(17));
        dsBean.setIrKeirisiteituukasyu(C_Tuukasyu.USD);
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200916"), iReportSokuzibunLst);
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_B7() {

        BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);
        List<IReportDataSouceBean> iReportSokuzibunLst = new ArrayList<>();
        SkSikinIdouListHrkmKouzaHuittibunDataSourceBean dsBean = SWAKInjector.getInstance(SkSikinIdouListHrkmKouzaHuittibunDataSourceBean.class);
        dsBean.setIrSikinidougaku(BizCurrency.valueOf(123456789012345L));
        dsBean.setIrSikinidoumototuukasyu(C_Tuukasyu.USD);
        dsBean.setIrSeitoukouzatuukasyu(C_Tuukasyu.JPY);
        dsBean.setIrSikinidoumotokouzano("123456789012");
        dsBean.setIrSeitoukouzano("223456789012");
        iReportSokuzibunLst.add(dsBean);

        bzSikinIdouListCsvFSksTblTrk.exec(BizDate.valueOf("20200917"), iReportSokuzibunLst);
    }
}
