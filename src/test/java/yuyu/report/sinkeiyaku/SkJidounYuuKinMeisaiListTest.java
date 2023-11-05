package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.sinkeiyaku.bean.report.SkJidounyuukinmeisailistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 自動入金明細リスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkJidounYuuKinMeisaiListTest {

    @Inject
    private CreateReport createReport;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki(null);
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd(null);
        skJidounyuukinmeisailistDataSourceBean.setIrListnm(null);
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd(null);
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd(null);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1001);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(1000));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(2001);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(2000));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(3001);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(3000));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(2222);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(2220));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(3333);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(3330));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(4444);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(4440));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(5555);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(5550));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(6666);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(6660));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(7777);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(7770));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("ＷＷ99年99月99日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("ＷＷ99年99月99日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("wwwwwww");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(999);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(999));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(1);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.1));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(1);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.22));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testCreateReport9(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(1);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.333));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testCreateReport10(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(99999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testCreateReport11(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testCreateReport12(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(9999);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testCreateReport13(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testCreateReport14(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testCreateReport15(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(1);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(0);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(0);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testCreateReport16(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 1; i <1000; i++) {

            SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();

            skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
            skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
            skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
            if (i%2 == 0) {
                skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
            }
            else {
                skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("豪ドル入金");
            }
            skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
            skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
            skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
            skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
            skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(100);
            skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(100));
            skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
            skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(100);
            skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(100));

            dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);
        }
        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }


    @Test
    @TestOrder(170)
    @Transactional
    public void testCreateReport17(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean2 = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean.setIrTjkensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrTjgk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosikensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrZenjitukurikosigk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrHrkmtsrykingk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean.setIrSgittikensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittikensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrSghuittigk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrMostrkskensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrMostrksgk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikakensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrYuukoukknkeikagk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosikensuu(100);
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigk(BizCurrency.valueOf(100));
        skJidounyuukinmeisailistDataSourceBean.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngkcount(100);
        skJidounyuukinmeisailistDataSourceBean.setIrBankmdhntgtgkngk(BizCurrency.valueOf(100));

        skJidounyuukinmeisailistDataSourceBean2.setIrAtesaki("代理店契約室　御中");
        skJidounyuukinmeisailistDataSourceBean2.setIrTyouhyousakuseiymd("平成21年 7月30日");
        skJidounyuukinmeisailistDataSourceBean2.setIrListnm("＜自動収納　照合一致・不一致明細書（普保Ⅱ）＞");
        skJidounyuukinmeisailistDataSourceBean2.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean2.setIrDenymd("平成22年 8月30日");
        skJidounyuukinmeisailistDataSourceBean2.setIrTjkensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean2.setIrZenjitukurikosikensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrZenjitukurikosigk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrHrkmtsrykensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrHrkmtsrykingk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrJigyouhicd("1234");
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittikensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean2.setIrSghuittikensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrSghuittigk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrMostrkskensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrMostrksgk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrYuukoukknkeikakensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrYuukoukknkeikagk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosikensuu(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean2.setIrBankmdhntgtgkngkcount(100);
        skJidounyuukinmeisailistDataSourceBean2.setIrBankmdhntgtgkngk(BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean2);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testCreateReport18(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean1 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean2 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean3 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean4 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean5 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean6 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean7 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean8 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean9 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean10 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean11 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean12 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean13 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean14 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean15 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean16 = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean1.setIrTjgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrTjgkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean1.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrSgittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrSgittigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean1.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYokukurikosigkyen(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean1.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean2.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean2.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean2.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean2.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean3.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean3.setIrTjgk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrTjgkyen(BizCurrency.valueOf(1111));
        skJidounyuukinmeisailistDataSourceBean3.setIrZenjitukurikosigk(BizCurrency.valueOf(2000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrHrkmtsrykingk(BizCurrency.valueOf(3000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrSgittigk(BizCurrency.valueOf(6000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrSgittigkyen(BizCurrency.valueOf(2222));
        skJidounyuukinmeisailistDataSourceBean3.setIrSghuittigk(BizCurrency.valueOf(7000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrMostrksgk(BizCurrency.valueOf(8000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYuukoukknkeikagk(BizCurrency.valueOf(9000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYokukurikosigk(BizCurrency.valueOf(1100, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYokukurikosigkyen(BizCurrency.valueOf(3333));
        skJidounyuukinmeisailistDataSourceBean3.setIrBankmdhntgtgkngk(BizCurrency.valueOf(2200, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean4.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean4.setIrTjgk(BizCurrency.valueOf(1000));
        skJidounyuukinmeisailistDataSourceBean4.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean4.setIrZenjitukurikosigk(BizCurrency.valueOf(2000));
        skJidounyuukinmeisailistDataSourceBean4.setIrHrkmtsrykingk(BizCurrency.valueOf(3000));
        skJidounyuukinmeisailistDataSourceBean4.setIrSgittigk(BizCurrency.valueOf(6000));
        skJidounyuukinmeisailistDataSourceBean4.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean4.setIrSghuittigk(BizCurrency.valueOf(7000));
        skJidounyuukinmeisailistDataSourceBean4.setIrMostrksgk(BizCurrency.valueOf(8000));
        skJidounyuukinmeisailistDataSourceBean4.setIrYuukoukknkeikagk(BizCurrency.valueOf(9000));
        skJidounyuukinmeisailistDataSourceBean4.setIrYokukurikosigk(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean4.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean4.setIrBankmdhntgtgkngk(BizCurrency.valueOf(2200));

        skJidounyuukinmeisailistDataSourceBean5.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean5.setIrTjgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrTjgkyen(BizCurrency.valueOf(999999999999999L));
        skJidounyuukinmeisailistDataSourceBean5.setIrZenjitukurikosigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrHrkmtsrykingk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrSgittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrSgittigkyen(BizCurrency.valueOf(999999999999999L));
        skJidounyuukinmeisailistDataSourceBean5.setIrSghuittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrMostrksgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYokukurikosigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYokukurikosigkyen(BizCurrency.valueOf(999999999999999L));
        skJidounyuukinmeisailistDataSourceBean5.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean6.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean6.setIrTjgk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean6.setIrZenjitukurikosigk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrHrkmtsrykingk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrSgittigk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean6.setIrSghuittigk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrMostrksgk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrYokukurikosigk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean6.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999999999999L));

        skJidounyuukinmeisailistDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean7.setIrTjgk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrTjgkyen(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean7.setIrZenjitukurikosigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrHrkmtsrykingk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrSgittigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrSgittigkyen(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean7.setIrSghuittigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrMostrksgk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYuukoukknkeikagk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYokukurikosigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYokukurikosigkyen(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean7.setIrBankmdhntgtgkngk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean8.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean8.setIrTjgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean8.setIrZenjitukurikosigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrHrkmtsrykingk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrSgittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean8.setIrSghuittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrMostrksgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrYuukoukknkeikagk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrYokukurikosigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean8.setIrBankmdhntgtgkngk(BizCurrency.valueOf(999));

        skJidounyuukinmeisailistDataSourceBean9.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean9.setIrTjgk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrTjgkyen(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean9.setIrZenjitukurikosigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrHrkmtsrykingk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrSgittigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrSgittigkyen(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean9.setIrSghuittigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrMostrksgk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYokukurikosigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYokukurikosigkyen(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean9.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean10.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean10.setIrTjgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean10.setIrZenjitukurikosigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrHrkmtsrykingk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrSgittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean10.setIrSghuittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrMostrksgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrYuukoukknkeikagk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrYokukurikosigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean10.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9999));

        skJidounyuukinmeisailistDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean11.setIrTjgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrTjgkyen(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean11.setIrZenjitukurikosigk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrHrkmtsrykingk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrSgittigk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrSgittigkyen(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean11.setIrSghuittigk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrMostrksgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYokukurikosigk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYokukurikosigkyen(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean11.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean12.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean12.setIrTjgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean12.setIrZenjitukurikosigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrHrkmtsrykingk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrSgittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean12.setIrSghuittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrMostrksgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrYokukurikosigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean12.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.1));

        skJidounyuukinmeisailistDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean13.setIrTjgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrTjgkyen(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean13.setIrZenjitukurikosigk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrHrkmtsrykingk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrSgittigk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrSgittigkyen(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean13.setIrSghuittigk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrMostrksgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYokukurikosigk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYokukurikosigkyen(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean13.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean14.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean14.setIrTjgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean14.setIrZenjitukurikosigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrHrkmtsrykingk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrSgittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean14.setIrSghuittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrMostrksgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrYokukurikosigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean14.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.22));


        skJidounyuukinmeisailistDataSourceBean15.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean15.setIrTjgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrTjgkyen(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean15.setIrZenjitukurikosigk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrHrkmtsrykingk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrSgittigk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrSgittigkyen(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean15.setIrSghuittigk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrMostrksgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYokukurikosigk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYokukurikosigkyen(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean15.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean16.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean16.setIrTjgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean16.setIrZenjitukurikosigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrHrkmtsrykingk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrSgittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean16.setIrSghuittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrMostrksgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrYuukoukknkeikagk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrYokukurikosigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean16.setIrBankmdhntgtgkngk(BizCurrency.valueOf(9.333));


        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean1);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean2);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean3);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean4);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean5);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean6);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean7);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean8);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean9);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean10);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean11);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean12);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean13);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean14);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean15);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testCreateReport19(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkJidounYuuKinMeisaiListTest", C_SyoruiCdKbn.SK_JIDOUNYKNMEISAILIST);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean1 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean2 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean3 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean4 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean5 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean6 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean7 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean8 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean9 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean10 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean11 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean12 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean13 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean14 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean15 = new SkJidounyuukinmeisailistDataSourceBean();
        SkJidounyuukinmeisailistDataSourceBean skJidounyuukinmeisailistDataSourceBean16 = new SkJidounyuukinmeisailistDataSourceBean();

        skJidounyuukinmeisailistDataSourceBean1.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean1.setIrTjgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean1.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrSgittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean1.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean1.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean1.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean2.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean2.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean2.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean2.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean2.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean3.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean3.setIrTjgk(BizCurrency.valueOf(4000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean3.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrSgittigk(BizCurrency.valueOf(5000, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean3.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean3.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean3.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean4.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean4.setIrTjgk(BizCurrency.valueOf(4000));
        skJidounyuukinmeisailistDataSourceBean4.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean4.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrSgittigk(BizCurrency.valueOf(5000));
        skJidounyuukinmeisailistDataSourceBean4.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean4.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean4.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean4.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean5.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean5.setIrTjgk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean5.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrSgittigk(BizCurrency.valueOf(9999999999999.99, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean5.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean5.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean5.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean6.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean6.setIrTjgk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean6.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrSgittigk(BizCurrency.valueOf(9999999999999L));
        skJidounyuukinmeisailistDataSourceBean6.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean6.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean6.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean6.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean7.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean7.setIrTjgk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean7.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrSgittigk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean7.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean7.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean7.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean8.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean8.setIrTjgk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean8.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrSgittigk(BizCurrency.valueOf(999));
        skJidounyuukinmeisailistDataSourceBean8.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean8.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean8.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean8.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean9.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean9.setIrTjgk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean9.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrSgittigk(BizCurrency.valueOf(9999, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean9.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean9.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean9.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean10.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean10.setIrTjgk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean10.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrSgittigk(BizCurrency.valueOf(9999));
        skJidounyuukinmeisailistDataSourceBean10.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean10.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean10.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean10.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean11.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean11.setIrTjgk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean11.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrSgittigk(BizCurrency.valueOf(9.1, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean11.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean11.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean11.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean12.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean12.setIrTjgk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean12.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrSgittigk(BizCurrency.valueOf(9.1));
        skJidounyuukinmeisailistDataSourceBean12.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean12.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean12.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean12.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        skJidounyuukinmeisailistDataSourceBean13.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean13.setIrTjgk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean13.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrSgittigk(BizCurrency.valueOf(9.22, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean13.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean13.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean13.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean14.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean14.setIrTjgk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean14.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrSgittigk(BizCurrency.valueOf(9.22));
        skJidounyuukinmeisailistDataSourceBean14.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean14.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean14.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean14.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));


        skJidounyuukinmeisailistDataSourceBean15.setIrNyukintuuka("豪ドル入金");
        skJidounyuukinmeisailistDataSourceBean15.setIrTjgk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean15.setIrZenjitukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrHrkmtsrykingk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrSgittigk(BizCurrency.valueOf(9.333, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean15.setIrSghuittigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrMostrksgk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYuukoukknkeikagk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYokukurikosigk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        skJidounyuukinmeisailistDataSourceBean15.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean15.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));

        skJidounyuukinmeisailistDataSourceBean16.setIrNyukintuuka("円入金");
        skJidounyuukinmeisailistDataSourceBean16.setIrTjgk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrTjgkyen(BizCurrency.valueOf(1100));
        skJidounyuukinmeisailistDataSourceBean16.setIrZenjitukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrHrkmtsrykingk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrSgittigk(BizCurrency.valueOf(9.333));
        skJidounyuukinmeisailistDataSourceBean16.setIrSgittigkyen(BizCurrency.valueOf(2200));
        skJidounyuukinmeisailistDataSourceBean16.setIrSghuittigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrMostrksgk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrYuukoukknkeikagk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrYokukurikosigk(BizCurrency.valueOf(0));
        skJidounyuukinmeisailistDataSourceBean16.setIrYokukurikosigkyen(BizCurrency.valueOf(3300));
        skJidounyuukinmeisailistDataSourceBean16.setIrBankmdhntgtgkngk(BizCurrency.valueOf(0));

        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean1);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean2);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean3);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean4);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean5);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean6);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean7);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean8);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean9);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean10);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean11);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean12);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean13);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean14);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean15);
        dataSouceList.add(skJidounyuukinmeisailistDataSourceBean16);

        reportTestBean.addParamObjects(dataSouceList);

        createReport.exec(new ReportServicesBean[]{reportTestBean});
    }
}