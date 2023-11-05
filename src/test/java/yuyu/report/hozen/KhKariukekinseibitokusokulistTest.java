package yuyu.report.hozen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.hozen.bean.report.KhKrkknSeibiTokusokuListBean;
import yuyu.def.hozen.bean.report.KhKrkknSeibiTokusokuListDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仮受金整備督促リストテスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class KhKariukekinseibitokusokulistTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private KhKrkknSeibiTokusokuListBean khKrkknSeibiTokusokuListBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = null;

        for (int i = 0; i < 1; i++) {

            khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();

            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(null);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(null);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(null);
            khKrkknSeibiTokusokuListDsBean.setIrSyono("");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(null);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(null);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(null);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(null);
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(null);
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("");


            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd(null);
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki(null);

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = null;

        for (int i = 0; i < 1; i++) {

            khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();

            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki(null);

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(null);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(null);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji(null);
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(null);
            khKrkknSeibiTokusokuListDsBean.setIrSyono(null);

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj(null);
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji(null);
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(null);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu(null);

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(null);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(null);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(null);
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy(null);

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(null);
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd(null);

            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = null;

        for (int i = 0; i < 29; i++) {

            khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();

            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("組織００１０００１");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.IMUSATEI);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.KZHRK);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("*");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("19970606"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("11809111114");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("田中　太郎者名");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("*");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(1);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("199708"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("3年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(999));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("19970202");

            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("20871231");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = null;

        for (int i = 0; i < 30; i++) {
            khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();

            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.TOKUYAKUPANNAI);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.CREDIT);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("w");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("20871231"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("wwwwwwwwwww");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("ＷＷＷＷＷＷ");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("w");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(99999);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("Ｗ");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.YUYOKKNGONYKN_1P);


            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.OTHER);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("208712"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("99年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(9999999999999l));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("20871231");

            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = null;

        for (int i = 0; i < 31; i++) {

            khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();

            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("組織００１０００１");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.BLNK11);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.BANK);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("A");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("19970606"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("11809111114");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("田中　太郎");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("B");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(1);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("201708"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("3か月");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(1000));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("19970202");


            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean1 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean1.setIrAtesakisosiki("組織００１０００２");

        khKrkknSeibiTokusokuListDsBean1.setIrTantocd(C_TantouCdKbn.IMUIMU);

        khKrkknSeibiTokusokuListDsBean1.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean1.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
        khKrkknSeibiTokusokuListDsBean1.setIrSyono("11809111115");

        khKrkknSeibiTokusokuListDsBean1.setIrKyknmkj("田中　太郎１");
        khKrkknSeibiTokusokuListDsBean1.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean1.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean1.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean1.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean1.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean1.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean1.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean1.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean1.setIrRyosyuymd("19970202");


        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean2 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean2.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean2.setIrTantocd(C_TantouCdKbn.IMUIMU);
        khKrkknSeibiTokusokuListDsBean2.setIrNykkeiro(C_Nykkeiro.CONVENI);
        khKrkknSeibiTokusokuListDsBean2.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean2.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
        khKrkknSeibiTokusokuListDsBean2.setIrSyono("11809111115");

        khKrkknSeibiTokusokuListDsBean2.setIrKyknmkj("田中　太郎２");
        khKrkknSeibiTokusokuListDsBean2.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean2.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean2.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean2.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean2.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean2.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean2.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean2.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean2.setIrRyosyuymd("19970202");


        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean3 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean3.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean3.setIrTantocd(C_TantouCdKbn.IMUIMU);
        khKrkknSeibiTokusokuListDsBean3.setIrNykkeiro(C_Nykkeiro.CONVENI);
        khKrkknSeibiTokusokuListDsBean3.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean3.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
        khKrkknSeibiTokusokuListDsBean3.setIrSyono("11809111115");

        khKrkknSeibiTokusokuListDsBean3.setIrKyknmkj("田中　太郎３");
        khKrkknSeibiTokusokuListDsBean3.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean3.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean3.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean3.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean3.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean3.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean3.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean3.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean3.setIrRyosyuymd("19970202");


        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean4 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean4.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean4.setIrTantocd(C_TantouCdKbn.KIKAKUIMU);
        khKrkknSeibiTokusokuListDsBean4.setIrNykkeiro(C_Nykkeiro.CONVENI);
        khKrkknSeibiTokusokuListDsBean4.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean4.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
        khKrkknSeibiTokusokuListDsBean4.setIrSyono("11809111115");

        khKrkknSeibiTokusokuListDsBean4.setIrKyknmkj("田中　太郎４");
        khKrkknSeibiTokusokuListDsBean4.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean4.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean4.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean4.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean4.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean4.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean4.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean4.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean4.setIrRyosyuymd("19970202");


        for (int i = 0; i < 28; i++) {
            KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean5 = new KhKrkknSeibiTokusokuListDataSourceBean();
            khKrkknSeibiTokusokuListDsBean5.setIrAtesakisosiki("組織００１０００１");

            khKrkknSeibiTokusokuListDsBean5.setIrTantocd(C_TantouCdKbn.KIKAKUIMU);
            khKrkknSeibiTokusokuListDsBean5.setIrNykkeiro(C_Nykkeiro.CREDIT);
            khKrkknSeibiTokusokuListDsBean5.setIrTyoukimisyorihyouji("A");
            khKrkknSeibiTokusokuListDsBean5.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
            khKrkknSeibiTokusokuListDsBean5.setIrSyono("11809111115");

            khKrkknSeibiTokusokuListDsBean5.setIrKyknmkj("田中　太郎５");
            khKrkknSeibiTokusokuListDsBean5.setIrHukusuukrkarihyouji("B");
            khKrkknSeibiTokusokuListDsBean5.setIrKrkno(2);
            khKrkknSeibiTokusokuListDsBean5.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean5.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean5.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean5.setIrJyuutouym(BizDateYM.valueOf("201708"));
            khKrkknSeibiTokusokuListDsBean5.setIrJyutoukaisuuy("99か月");

            khKrkknSeibiTokusokuListDsBean5.setIrKrkgk(BizCurrency.valueOf(999));
            khKrkknSeibiTokusokuListDsBean5.setIrRyosyuymd("19970202");

        }

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean6 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean6.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean6.setIrTantocd(C_TantouCdKbn.KIKAKUIMU);
        khKrkknSeibiTokusokuListDsBean6.setIrNykkeiro(C_Nykkeiro.CREDIT);
        khKrkknSeibiTokusokuListDsBean6.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean6.setIrKrkkeijyoymd(BizDate.valueOf("20171207"));
        khKrkknSeibiTokusokuListDsBean6.setIrSyono("11809111115");

        khKrkknSeibiTokusokuListDsBean6.setIrKyknmkj("田中　太郎６");
        khKrkknSeibiTokusokuListDsBean6.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean6.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean6.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean6.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean6.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean6.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean6.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean6.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean6.setIrRyosyuymd("19970202");


        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean7 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean7.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean7.setIrTantocd(C_TantouCdKbn.KIKAKUIMU);
        khKrkknSeibiTokusokuListDsBean7.setIrNykkeiro(C_Nykkeiro.CREDIT);
        khKrkknSeibiTokusokuListDsBean7.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean7.setIrKrkkeijyoymd(BizDate.valueOf("20171207"));
        khKrkknSeibiTokusokuListDsBean7.setIrSyono("11809111114");

        khKrkknSeibiTokusokuListDsBean7.setIrKyknmkj("田中　太郎７");
        khKrkknSeibiTokusokuListDsBean7.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean7.setIrKrkno(2);
        khKrkknSeibiTokusokuListDsBean7.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean7.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean7.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean7.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean7.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean7.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean7.setIrRyosyuymd("19970202");
        iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean7);

        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean8 = new KhKrkknSeibiTokusokuListDataSourceBean();
        khKrkknSeibiTokusokuListDsBean8.setIrAtesakisosiki("組織００１０００１");

        khKrkknSeibiTokusokuListDsBean8.setIrTantocd(C_TantouCdKbn.KIKAKUIMU);
        khKrkknSeibiTokusokuListDsBean8.setIrNykkeiro(C_Nykkeiro.CREDIT);
        khKrkknSeibiTokusokuListDsBean8.setIrTyoukimisyorihyouji("A");
        khKrkknSeibiTokusokuListDsBean8.setIrKrkkeijyoymd(BizDate.valueOf("20171207"));
        khKrkknSeibiTokusokuListDsBean8.setIrSyono("11809111114");

        khKrkknSeibiTokusokuListDsBean8.setIrKyknmkj("田中　太郎８");
        khKrkknSeibiTokusokuListDsBean8.setIrHukusuukrkarihyouji("B");
        khKrkknSeibiTokusokuListDsBean8.setIrKrkno(1);
        khKrkknSeibiTokusokuListDsBean8.setIrKrkjhrkkaisuu("年");

        khKrkknSeibiTokusokuListDsBean8.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

        khKrkknSeibiTokusokuListDsBean8.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

        khKrkknSeibiTokusokuListDsBean8.setIrJyuutouym(BizDateYM.valueOf("201708"));
        khKrkknSeibiTokusokuListDsBean8.setIrJyutoukaisuuy("99か月");

        khKrkknSeibiTokusokuListDsBean8.setIrKrkgk(BizCurrency.valueOf(999));
        khKrkknSeibiTokusokuListDsBean8.setIrRyosyuymd("19970202");
        iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean8);

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 29970; i++) {
            KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();
            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("組織００１０００２");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.IMUIMU);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.CONVENI);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("A");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("11809111115");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("田中　太郎");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("B");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(2);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("201708"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("99か月");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(999));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("19970202");

            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 9999; i++) {
            KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();
            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("組織００１０００２");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.IMUIMU);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.CONVENI);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("A");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("11809111115");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("田中　太郎");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("B");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(2);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("201708"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("99か月");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(999));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("19970202");
            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }


    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("hozen", "", "KhKariukekinseibitokusokulistTest",
                C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1);

        khKrkknSeibiTokusokuListBean.setIrSakuseiymd("19900202");
        khKrkknSeibiTokusokuListBean.setIrSakuseisosiki("収納サービス室");

        List<IReportDataSouceBean> iReportDataSouceBean = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 1; i++) {
            KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDsBean = new KhKrkknSeibiTokusokuListDataSourceBean();
            khKrkknSeibiTokusokuListDsBean.setIrAtesakisosiki("組織００１０００２");

            khKrkknSeibiTokusokuListDsBean.setIrTantocd(C_TantouCdKbn.SYUUDANTEIKI);
            khKrkknSeibiTokusokuListDsBean.setIrNykkeiro(C_Nykkeiro.CONVENI);
            khKrkknSeibiTokusokuListDsBean.setIrTyoukimisyorihyouji("A");
            khKrkknSeibiTokusokuListDsBean.setIrKrkkeijyoymd(BizDate.valueOf("20171208"));
            khKrkknSeibiTokusokuListDsBean.setIrSyono("11809111115");

            khKrkknSeibiTokusokuListDsBean.setIrKyknmkj("田中　太郎");
            khKrkknSeibiTokusokuListDsBean.setIrHukusuukrkarihyouji("B");
            khKrkknSeibiTokusokuListDsBean.setIrKrkno(2);
            khKrkknSeibiTokusokuListDsBean.setIrKrkjhrkkaisuu("年");

            khKrkknSeibiTokusokuListDsBean.setIrKrkriyuukbn(C_KrkriyuuKbn.HUSOKUNYKN);

            khKrkknSeibiTokusokuListDsBean.setIrNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);

            khKrkknSeibiTokusokuListDsBean.setIrJyuutouym(BizDateYM.valueOf("201708"));
            khKrkknSeibiTokusokuListDsBean.setIrJyutoukaisuuy("99か月");

            khKrkknSeibiTokusokuListDsBean.setIrKrkgk(BizCurrency.valueOf(999));
            khKrkknSeibiTokusokuListDsBean.setIrRyosyuymd("19970202");
            iReportDataSouceBean.add(khKrkknSeibiTokusokuListDsBean);
        }

        reportTestBean.addParamObjects(iReportDataSouceBean, khKrkknSeibiTokusokuListBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });
    }
}
