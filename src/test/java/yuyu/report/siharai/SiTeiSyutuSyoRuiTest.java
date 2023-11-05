package yuyu.report.siharai;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiBean;
import yuyu.def.siharai.bean.report.SiEditTeisyutusyoruiDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ご提出書類について編集帳票テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class SiTeiSyutuSyoRuiTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiEditTeisyutusyoruiBean siEditTeisyutusyoruiBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");
        siEditTeisyutusyoruiBean.setIrSyono("XXXXXXXXXXX");

        for (int i = 1; i < 13; i++) {

            SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

            siEditTeisyutusyoruiDataSourceBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("平成２８年１２月２日");
        siEditTeisyutusyoruiBean.setIrSyono("10000000001");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean.setIrMsg1("死亡保険金請求書");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg2("");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg3("■請求者は死亡保険金受取人さまとなります。");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg4("　死亡保険金請求書の記入見本を参照のうえ請求者さまご自身が");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg5("　ご記入ください。");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg6("■請求者さま本人口座をご指定ください。");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean1 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg1("保険証券");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg2("");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg3("■再発行されていますので、お手元の証券をお確かめください。");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg4("");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg5("※紛失されている場合は、請求書の【保険証券紛失届】欄にレ印を");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg6("　ご記入ください。");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean1.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean1);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean2 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg1("医師の発行する死亡診断書");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg2("（または死体検案書）の写し");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg3("■死亡診断書または死体検案書の内容について、当社職員が病院あ");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg4("　てに照会させていただくことがありますので、ご了承ください。");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg5("※保険金等を全くお支払いできなかった場合で、当社所定の要件を");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg6("　満たすときは、診断書原本一通につき、一律５，４００円をお支");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg7("　払いいたします。");
            siEditTeisyutusyoruiDataSourceBean2.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean2);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean3 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg1("代表選任届");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg2("");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg3("■受取人または相続人の代表者が請求される場合、代表選任届の");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg4("　記入見本を参照のうえ、ご記入ください。");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg5("");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg6("");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean3.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean3);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean4 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg1("被保険者の住民票（写し可）");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg2("");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg3("■被保険者さまの死亡記事の記載があり、発行後６か月以内のもの");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg4("　をご提出ください。");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg5("※被保険者さまの死亡記事の記載がある戸籍謄（抄）本をご提出の");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg6("　場合は、不要です。");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean4.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean4);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean5 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg1("戸籍謄本または全部事項証明書");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg2("（写し可）");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg3("■被保険者さまの死亡記事の記載があり、相続人の確認ができる");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg4("　発行後６か月以内のものをご提出ください。");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg5("■被保険者さまに改姓があるときは、その事実がわかるものをご");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg6("　提出ください。");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean5.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean5);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean6 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg1("事故状況報告書(事故証明書)");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg2("");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg3("■従業中の事故の場合は、証明欄に勤務先から証明を受けてくださ");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg4("　い。");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg5("■事故状況報告書（事故証明書）の記入見本を参照のうえ、請求者");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg6("　さまご自身でご記入ください。");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean6.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean6);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean7 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg1("交通事故証明書");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg2("（自動車安全運転センター発行）");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg3("■交通事故を警察に届出されている場合に必要です。");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg4("");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg5("");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg6("");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean7.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean7);
        }

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean8 = new SiEditTeisyutusyoruiDataSourceBean();

        for (int i = 1; i < 2; i++) {
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg1("受取人全員の");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg2("本人確認書類（写し）");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg3("■運転免許証、パスポート、健康保険証などの各種証明書の写し");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg4("　をご提出ください。");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg5("※「免許の条件等」の記載がある場合は、その箇所を黒マジック");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg6("　等で塗りつぶしてください。");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg7("");
            siEditTeisyutusyoruiDataSourceBean8.setIrMsg8("");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean8);
        }

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd(null);
        siEditTeisyutusyoruiBean.setIrSyono(null);

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

        siEditTeisyutusyoruiDataSourceBean.setIrMsg1(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg2(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg3(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg4(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg5(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg6(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg7(null);
        siEditTeisyutusyoruiDataSourceBean.setIrMsg8(null);

        iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("");
        siEditTeisyutusyoruiBean.setIrSyono("");

        SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

        siEditTeisyutusyoruiDataSourceBean.setIrMsg1("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg2("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg3("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg4("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg5("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg6("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg7("");
        siEditTeisyutusyoruiDataSourceBean.setIrMsg8("");

        iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");
        siEditTeisyutusyoruiBean.setIrSyono("XXXXXXXXXXX");

        for (int i = 1; i < 14; i++) {

            SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

            siEditTeisyutusyoruiDataSourceBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");
        siEditTeisyutusyoruiBean.setIrSyono("XXXXXXXXXXX");

        for (int i = 1; i < 12; i++) {

            SiEditTeisyutusyoruiDataSourceBean siEditTeisyutusyoruiDataSourceBean = new SiEditTeisyutusyoruiDataSourceBean();

            siEditTeisyutusyoruiDataSourceBean.setIrMsg1("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg2("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg3("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg4("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg5("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg6("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg7("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            siEditTeisyutusyoruiDataSourceBean.setIrMsg8("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");

            iReportDataSouceBeanLst.add(siEditTeisyutusyoruiDataSourceBean);
        }
        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {

        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiTeiSyutuSyoRuiTest", C_SyoruiCdKbn.HK_TEISYUTUSYORUI);

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();

        siEditTeisyutusyoruiBean.setIrTyouhyousakuseiymd("ＷＷ９９年９９月９９日");
        siEditTeisyutusyoruiBean.setIrSyono("XXXXXXXXXXX");

        reportTestBean.addParamObjects(iReportDataSouceBeanLst, siEditTeisyutusyoruiBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }
}
