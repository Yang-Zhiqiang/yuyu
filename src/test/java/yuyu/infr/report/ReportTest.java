package yuyu.infr.report;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.report.AMUserBean;
import yuyu.def.report.TestReportBean;
import yuyu.infr.inject.KinouProvider;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;
import yuyu.infr.report.swakreport.reader.SyoruiZokuseiCsvReader;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務帳票基盤を使った各種テスト用クラス
 */
@RunWith(OrderedRunner.class)
public class ReportTest extends AbstractTest {


    @Inject
    private BaseDomManager manager;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    @Inject
    private KinouProvider kinouProvider;

    @Inject
    private SyoruiZokuseiReader syoruiZokuseiReader;

    private static Logger logger = LoggerFactory.getLogger(OutputReport.class);

    @Transactional
    public void testSample(){
        try {

            Map<String, SyoruiZokusei> zokuseiMap = syoruiZokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            ReportServicesBean reportTestBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", zokusei.getSyoruiCdKbn());

            TestReportBean testBean = new TestReportBean();

            testBean.setSosikiCd("TESTてすと試験");
            testBean.setGengou("平成");

            List<AM_User> allUsers = manager.getAllUsers();

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();
            for( AM_User am_user: allUsers ){
                AMUserBean testBean3 = new AMUserBean();

                testBean3.setUserId(am_user.getUserId());
                testBean3.setUserNm(am_user.getUserNm());
                testBean3.setSpecialUserKbn(am_user.getSpecialUserKbn());

                rdsBeanList.add(testBean3);
            }

            reportTestBean.addParamObjects(zokusei.getSyoruiCdKbn(), testBean, rdsBeanList);
            reportTestBean.addImageFileName("Login.png", zokusei.getSyoruiCdKbn());

            String tyouhyouKey = createReport.exec(reportTestBean);
            System.out.print("帳票キー：" + tyouhyouKey);

            outputReport.outputPDFSingle(tyouhyouKey);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @Transactional
    public void testCreateReport(){
        try {

            Map<String, SyoruiZokusei> zokuseiMap = syoruiZokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            ReportServicesBean reportTestBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", zokusei.getSyoruiCdKbn());

            reportTestBean.setQrCode("abc123def567");
            TestReportBean reportBean = new TestReportBean();

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();

            reportTestBean.addParamObjects(rdsBeanList, reportBean);

            String tyouhyouKey = createReport.exec(reportTestBean);
            System.out.print("帳票キー：" + tyouhyouKey);

            //            createReport.makeKensakuInfo(reportTestBean, tyouhyouKey, new String[]{"kensakuTest1","kensakuTest2","kensakuTest3","kensakuTest4","kensakuTest5"});
            //
            //            outputReport.outputPDF2File(tyouhyouKey, null);

            outputReport.outputPDFSingle(tyouhyouKey);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testCreateJoinedReport(){
        try {
            SyoruiZokuseiCsvReader zokuseiReader = new SyoruiZokuseiCsvReader();
            Map<String, SyoruiZokusei> zokuseiMap = zokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());
            SyoruiZokusei zokusei2 = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            ReportServicesBean serviceBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", new C_SyoruiCdKbn[]{zokusei.getSyoruiCdKbn(), zokusei2.getSyoruiCdKbn()});

            TestReportBean testBean = new TestReportBean();
            TestReportBean testBean2 = new TestReportBean();

            testBean.setSosikiCd("TESTてすと");
            testBean.setGengou("平成");

            testBean2.setSosikiCd("TESTてすと");
            testBean2.setGengou("平成");

            List<AM_User> allUsers = manager.getAllUsers();

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();
            for( AM_User am_user: allUsers ){
                AMUserBean testBean3 = new AMUserBean();

                testBean3.setUserId(am_user.getUserId());
                testBean3.setUserNm(am_user.getUserNm());
                testBean3.setSpecialUserKbn(am_user.getSpecialUserKbn());

                rdsBeanList.add(testBean3);
            }

            serviceBean.addParamObjects(zokusei.getSyoruiCdKbn(), rdsBeanList, testBean);
            serviceBean.addParamObjects(zokusei2.getSyoruiCdKbn(), rdsBeanList, testBean2);

            serviceBean.addImageFileName("Login.png", zokusei.getSyoruiCdKbn());

            String tyouhyouKey = createReport.exec(serviceBean);
            System.out.print("帳票結合キー：" + tyouhyouKey);

            outputReport.outputPDFSingle(tyouhyouKey);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testCreateMultiReport(){
        try {
            SyoruiZokuseiCsvReader zokuseiReader = new SyoruiZokuseiCsvReader();
            Map<String, SyoruiZokusei> zokuseiMap = zokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            List<ReportServicesBean> multiReportBean = new ArrayList<ReportServicesBean>();

            int i = 0;
            while(i < 3){
                ReportServicesBean reportTestBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", zokusei.getSyoruiCdKbn());

                reportTestBean.setKensakuKeys(new String[]{"sosikiCd", "userId"});

                TestReportBean testBean = new TestReportBean();

                testBean.setSosikiCd("TESTてすと");
                testBean.setGengou("平成");
                testBean.setKenDantaiCdTrkNo("0000");

                List<AM_User> allUsers = manager.getAllUsers();

                List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();
                for( AM_User am_user: allUsers ){

                    AMUserBean dataSourceBean = new AMUserBean();

                    dataSourceBean.setUserId(am_user.getUserId());
                    dataSourceBean.setUserNm(am_user.getUserNm());
                    dataSourceBean.setSpecialUserKbn(am_user.getSpecialUserKbn());

                    rdsBeanList.add(dataSourceBean);
                }

                reportTestBean.addParamObjects(rdsBeanList, testBean);

                reportTestBean.addImageFileName("Login.png");

                multiReportBean.add(reportTestBean);
                i++;
            }

            String tyouhyouJoinKey = createReport.exec(multiReportBean);
            System.out.print("帳票結合キー：" + tyouhyouJoinKey);

            outputReport.outputPDFByJoinKey(tyouhyouJoinKey);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testOutputReportFile(){
        try {
            SyoruiZokuseiCsvReader zokuseiReader = new SyoruiZokuseiCsvReader();
            Map<String, SyoruiZokusei> zokuseiMap = zokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            ReportServicesBean reportTestBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", C_SyoruiCdKbn.BLNK);

            reportTestBean.setKensakuKeys(new String[]{"sosikiCd", "userId"});

            TestReportBean testBean = new TestReportBean();

            testBean.setSosikiCd("TESTてすと");
            testBean.setGengou("平成");
            testBean.setKenDantaiCdTrkNo("0000");

            List<AM_User> allUsers = manager.getAllUsers();

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();
            for( AM_User am_user: allUsers ){

                AMUserBean dataSourceBean = new AMUserBean();

                dataSourceBean.setUserId(am_user.getUserId());
                dataSourceBean.setUserNm(am_user.getUserNm());
                dataSourceBean.setSpecialUserKbn(am_user.getSpecialUserKbn());

                rdsBeanList.add(dataSourceBean);
            }

            reportTestBean.addParamObjects(rdsBeanList, testBean);

            reportTestBean.addImageFileName("Login.png");

            String tyouhyouKey = createReport.exec(reportTestBean);
            System.out.print("帳票キー：" + tyouhyouKey);

            outputReport.outputPDF2File(tyouhyouKey,null);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testCreate(){
        try {

            Properties props = System.getProperties();
            props.list(System.out);

            System.out.println(System.getProperty("user.dir"));

            SyoruiZokuseiCsvReader zokuseiReader = new SyoruiZokuseiCsvReader();
            Map<String, SyoruiZokusei> zokuseiMap = zokuseiReader.read();
            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.BLNK.getValue());

            ReportServicesBean reportTestBean = createReport.createNewReportServiceBean("subsys", "cat1", "testkinou", C_SyoruiCdKbn.BLNK);

            TestReportBean reportBean = new TestReportBean();

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();

            reportTestBean.addParamObjects(rdsBeanList, reportBean);

            //            String tyouhyouKey = createReport.exec(reportTestBean);
            String tyouhyouKey = createReport.exec(new ReportServicesBean[]{reportTestBean});
            System.out.print("帳票キー：" + tyouhyouKey);

            //            createReport.makeKensakuInfo(reportTestBean, tyouhyouKey, new String[]{"kensakuTest1","kensakuTest2","kensakuTest3","kensakuTest4","kensakuTest5"});
            //
            //            outputReport.outputPDF2File(tyouhyouKey, null);

            outputReport.outputPDFByJoinKey(tyouhyouKey);
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }
}
