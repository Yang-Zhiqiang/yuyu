package yuyu.report.sinkeiyaku;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.sinkeiyaku.bean.report.SkKouhuritourokuhaneierrlistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 口座振替登録反映エラーリスト帳票テスト用クラス<br />
 */
@RunWith(OrderedRunner.class)
public class SkKouhuritrkhaneierrorListTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SkSyanailistheaderBean skSyanailistheaderBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki(null);
        skSyanailistheaderBean.setIrTyouhyousakuseiymd(null);

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
        skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu(null);
        dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
        skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(null);
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn("");
        skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu("");
        dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14; i++) {
            SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd("8050602");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno("100120001");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano("9876543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd("20100519");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd("0012");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd("003");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(C_YokinKbn.TEIKI);
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano("6543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn("カキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモ");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu("払込経路エラー　払込経路口座振替以外");
            dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("9999年99月99日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 15; i++) {
            SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd("wwwwwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno("wwwwwwwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano("wwwwwwwwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd("99999999");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd("wwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd("www");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(C_YokinKbn.BLNK);
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano("wwwwwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
            dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();


        for (int i = 0; i < 14; i++) {
            SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean1 = new SkKouhuritourokuhaneierrlistDataSourceBean();
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrSosikicd("8050603");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrMosno("100120001");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrOkyakusamano("9876543210");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrKouzahrketrkymd("20100519");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrKinyuucd("0012");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrSitencd("003");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrYokinkbn(C_YokinKbn.TUMITATE);
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrKouzano("6543210");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrKzmeiginmkn("ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓ");
            skKouhuritourokuhaneierrlistDataSourceBean1.setIrKhrtrkkekkahaneierrriyuu("申込書消滅　申込取消");
            dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean1);
        }

        SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean2 = new SkKouhuritourokuhaneierrlistDataSourceBean();
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrSosikicd("8050602");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrMosno("100120002");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrOkyakusamano("9876543210");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrKouzahrketrkymd("20100519");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrKinyuucd("0012");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrSitencd("003");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrYokinkbn(C_YokinKbn.TUMITATE);
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrKouzano("6543210");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrKzmeiginmkn("ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓ");
        skKouhuritourokuhaneierrlistDataSourceBean2.setIrKhrtrkkekkahaneierrriyuu("申込書消滅　申込取消");
        dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean2);

        SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean3 = new SkKouhuritourokuhaneierrlistDataSourceBean();
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrSosikicd("8050602");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrMosno("100120001");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrOkyakusamano("9876543210");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrKouzahrketrkymd("20100519");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrKinyuucd("0012");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrSitencd("003");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrYokinkbn(C_YokinKbn.TUMITATE);
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrKouzano("6543210");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrKzmeiginmkn("ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓ");
        skKouhuritourokuhaneierrlistDataSourceBean3.setIrKhrtrkkekkahaneierrriyuu("申込書消滅　申込取消");
        dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean3);

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 999; i++) {
            SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd("8050602");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno("100120001");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano("9876543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd("20100519");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd("0012");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd("003");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(C_YokinKbn.HUTUU);
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano("6543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn("カキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモ");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu("口座情報が既に登録されています");
            dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        for (int i = 0; i < 14985; i++) {
            SkKouhuritourokuhaneierrlistDataSourceBean skKouhuritourokuhaneierrlistDataSourceBean = new SkKouhuritourokuhaneierrlistDataSourceBean();
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSosikicd("8050602");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrMosno("100120001");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrOkyakusamano("9876543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzahrketrkymd("20100519");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKinyuucd("0012");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrSitencd("003");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrYokinkbn(C_YokinKbn.TOUZA);
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKouzano("6543210");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKzmeiginmkn("ｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓ");
            skKouhuritourokuhaneierrlistDataSourceBean.setIrKhrtrkkekkahaneierrriyuu("登録方法エラー　口座振替登録方法QR方式以外");
            dataSouceList.add(skKouhuritourokuhaneierrlistDataSourceBean);
        }

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testCreateReport8(){
        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("sinkeiyaku", "", "SkKouhuritrkhaneierrorListTest", C_SyoruiCdKbn.SK_KOUFURITOUROKUHANEIERRORLIST);

        skSyanailistheaderBean.setIrAtesakisosiki("代理店契約室 御中");
        skSyanailistheaderBean.setIrTyouhyousakuseiymd("2019年10月30日");

        List<IReportDataSouceBean> dataSouceList = new ArrayList<IReportDataSouceBean>();

        reportTestBean.addParamObjects(dataSouceList, skSyanailistheaderBean);

        createReport.exec(new ReportServicesBean[]{reportTestBean});

    }

}