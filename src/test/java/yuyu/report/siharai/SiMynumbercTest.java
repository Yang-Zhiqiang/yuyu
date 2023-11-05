package yuyu.report.siharai;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiMynumberCBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 *マイナンバー申告書（Ｃ票）
 */
@RunWith(OrderedRunner.class)
public class SiMynumbercTest extends AbstractTest {

    @Inject
    private CreateReport createReport;

    @Inject
    private SiMynumberCBean siMynumberCBean;

    @Test
    @TestOrder(10)
    @Transactional
    public void testCreateReport1() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("");
        siMynumberCBean.setIrSyono("");
        siMynumberCBean.setIrSinkokurukthyjumu(null);
        siMynumberCBean.setIrSinkokursksyahyjumu(null);
        siMynumberCBean.setIrIninrukthyjumu(null);
        siMynumberCBean.setIrIninrkykhyjumu(null);
        siMynumberCBean.setIrIninrsksyahyjumu(null);



        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.execNoCommit(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateReport2() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle(null);
        siMynumberCBean.setIrSyono(null);
        siMynumberCBean.setIrSinkokurukthyjumu(null);
        siMynumberCBean.setIrSinkokursksyahyjumu(null);
        siMynumberCBean.setIrIninrukthyjumu(null);
        siMynumberCBean.setIrIninrkykhyjumu(null);
        siMynumberCBean.setIrIninrsksyahyjumu(null);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateReport3() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("マイナンバー（個人番号）提供書　兼　委任状");
        siMynumberCBean.setIrSyono("12345678901");
        siMynumberCBean.setIrSinkokurukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrSinkokursksyahyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrIninrukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrkykhyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrsksyahyjumu(C_UmuKbn.ARI);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testCreateReport4() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siMynumberCBean.setIrSyono("XXXXXXXXXXX");
        siMynumberCBean.setIrSinkokurukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrSinkokursksyahyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrIninrukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrkykhyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrsksyahyjumu(C_UmuKbn.ARI);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testCreateReport5() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siMynumberCBean.setIrSyono("XXXXXXXXXXX");
        siMynumberCBean.setIrSinkokurukthyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrSinkokursksyahyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrukthyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrIninrkykhyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrsksyahyjumu(C_UmuKbn.NONE);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testCreateReport6() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("ＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷＷ");
        siMynumberCBean.setIrSyono("XXXXXXXXXXX");
        siMynumberCBean.setIrSinkokurukthyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrSinkokursksyahyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrkykhyjumu(C_UmuKbn.ARI);
        siMynumberCBean.setIrIninrsksyahyjumu(C_UmuKbn.NONE);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testCreateReport7() {


        ReportServicesBean reportTestBean =
            createReport.createNewReportServiceBean("siharai", "", "SiMynumbercTest", C_SyoruiCdKbn.HK_MYNUMBER_CHYOU );


        siMynumberCBean.setIrTyouhyoutitle("マイナンバー（個人番号）提供書　兼　委任状");
        siMynumberCBean.setIrSyono("12345678901");
        siMynumberCBean.setIrSinkokurukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrSinkokursksyahyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrukthyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrkykhyjumu(C_UmuKbn.NONE);
        siMynumberCBean.setIrIninrsksyahyjumu(C_UmuKbn.NONE);


        reportTestBean.addParamObjects(siMynumberCBean);
        createReport.exec(new ReportServicesBean[] { reportTestBean });

    }


}