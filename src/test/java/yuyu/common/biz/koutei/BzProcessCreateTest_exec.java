package yuyu.common.biz.koutei;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程作成クラスのメソッド {@link BzProcessCreate#exec(BzProcessCreateInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzProcessCreateTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_業務共通工程作成";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
                bind(BzLockProcess.class).to(BzLockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        IwfKouteiClientMockForBiz.caller = "Test";
        BzGetProcessSummaryMockForBiz.caller = BzProcessCreateTest_exec.class;
        BzLockProcessMockForBiz.caller = BzProcessCreateTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.caller = null;
        BzLockProcessMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.flg = null;
        IwfKouteiClientMockForBiz.mode = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        BzLockProcessMockForBiz.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzProcessCreateTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("1002", "hozen"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("1001", "nenkin"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("1001", "siharai"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("1001", "sinkeiyaku"));
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));

        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.FAILURE, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
            (BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),"1001", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(),"780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(),"16808000029", "証券番号");
        assertArrayEquals(bzGetProcessSummaryInBean2.getSkNos(),null);
        exStringEquals(bzGetProcessSummaryInBean2.getNkSysyNo(),"16808000018", "年金証書番号");

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getFlowid(),"1001", "フローID ");
        exStringEquals(processCreateInBean.getAccountid(),"Junit", "アカウントID");
        exStringEquals(processCreateInBean.getExtParam12().getValue(),"16808000029", "追加パラメータ12");
        exStringEquals(processCreateInBean.getExtParam8().getValue(),"0", "追加パラメータ8");
        exStringEquals(processCreateInBean.getExtParam13().getValue(),"16808000018", "追加パラメータ13");
        exStringEquals(processCreateInBean.getExtParam14().getValue(),"780123451", "追加パラメータ14");
        exStringEquals(processCreateInBean.getExtParam1().getValue(),"01", "追加パラメータ1");
        exStringEquals(processCreateInBean.getExtParam2().getValue(),"1", "追加パラメータ2");
        exStringEquals(processCreateInBean.getExtParam3().getValue(),"441", "追加パラメータ3");
        exStringEquals(processCreateInBean.getExtParam4().getValue(),"drtcd01", "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),"drtcd02", "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),"jmcd1", "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam9().getValue(),"1", "追加パラメータ9");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),"2015010112101330", "追加パラメータ11");
        exStringEquals(processCreateInBean.getExtParam10().getValue(),"20150505", "追加パラメータ10");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
            (BzGetProcessSummaryMockForBiz.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(),"1001", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(),"780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryInBean3.getSyoNo(),"16808000029", "証券番号");
        assertArrayEquals(bzGetProcessSummaryInBean3.getSkNos(),null);
        exStringEquals(bzGetProcessSummaryInBean3.getNkSysyNo(),"16808000018", "年金証書番号");

        ProcessCancelInBean processCancelInBean =  (ProcessCancelInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCancel", 0, 0);
        exStringEquals(processCancelInBean.getFlowid(),"1001", "フローID");
        exStringEquals(processCancelInBean.getAccountid(),"Junit", "アカウントID");
        exStringEquals(processCancelInBean.getLockkey(),"testKouteiLockKey", "ロックキー");
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-02";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));

        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程作成、API＝工程取消、エラーコード＝IWF0000", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "異常終了しました、詳細は、出力したログファイルをご参照ください。", "エラーメッセージ");
            BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
                (BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
            exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),"1001", "事務手続コード");
            exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
            exStringEquals(bzGetProcessSummaryInBean2.getMosNo(),"780123451", "申込番号");
            exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(),"10000000001", "証券番号");
            assertArrayEquals(bzGetProcessSummaryInBean2.getSkNos(),new String[]{"100001"});
            exStringEquals(bzGetProcessSummaryInBean2.getNkSysyNo(),"nk10000001", "年金証書番号");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("11809111125");
        bzProcessCreateInBean.setNkSysyNo("79807111114");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.SUCCESS, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("11809111125");
        bzProcessCreateInBean.setNkSysyNo("79807111114");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.SUCCESS, "工程作成結果区分");
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程作成、API＝工程作成、エラーコード＝IWF0009", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN5;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN6;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.FAILURE, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "", "工程管理ID");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN7;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("100002");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("2002");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.MISAKUSEI_KIZON_ARI, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
            (BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getKouteiKanriId(),"100002", "工程管理ID");
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(),"2002", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(),null, "申込番号");
        exStringEquals(bzGetProcessSummaryInBean1.getSyoNo(),null, "証券番号");
        assertArrayEquals(bzGetProcessSummaryInBean1.getSkNos(),null);
        exStringEquals(bzGetProcessSummaryInBean1.getNkSysyNo(),null, "年金証書番号");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl02";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN4;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("100002");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("2002");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.FAILURE, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "", "工程管理ID");
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("100002");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "異常終了しました、詳細は、出力したログファイルをご参照ください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("2002");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("10000000001");
        bzProcessCreateInBean.setNkSysyNo("nk10000001");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "異常終了しました、詳細は、出力したログファイルをご参照ください。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000018");
        bzProcessCreateInBean.setNkSysyNo("16808000029");
        bzProcessCreateInBean.setSkeijimuKbn(null);
        bzProcessCreateInBean.setMosUketukeKbn(null);
        bzProcessCreateInBean.setHknsyuruiNo(null);
        bzProcessCreateInBean.setDairitenCd1(null);
        bzProcessCreateInBean.setDairitenCd2(null);
        bzProcessCreateInBean.setJimuyouCd(null);
        bzProcessCreateInBean.setJmycdMisetteiKbn(null);
        bzProcessCreateInBean.setDoujiMosumu(null);
        bzProcessCreateInBean.setJimustartYmd(null);
        bzProcessCreateInBean.setMosymd(null);
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        bzProcessCreate.exec(bzProcessCreateInBean);

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getExtParam8().getValue(),"1", "追加パラメータ8");
        exStringEquals(processCreateInBean.getExtParam1().getValue(),null, "追加パラメータ1");
        exStringEquals(processCreateInBean.getExtParam2().getValue(),null, "追加パラメータ2");
        exStringEquals(processCreateInBean.getExtParam3().getValue(),null, "追加パラメータ3");
        exStringEquals(processCreateInBean.getExtParam4().getValue(),null, "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),null, "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),null, "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam9().getValue(),null, "追加パラメータ9");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),null, "追加パラメータ11");
        exStringEquals(processCreateInBean.getExtParam10().getValue(),null, "追加パラメータ10");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(null);
        bzProcessCreateInBean.setDairitenCd1("");
        bzProcessCreateInBean.setDairitenCd2("");
        bzProcessCreateInBean.setJimuyouCd("");
        bzProcessCreateInBean.setJimustartYmd("");
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        bzProcessCreate.exec(bzProcessCreateInBean);

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getExtParam4().getValue(),null, "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),null, "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),null, "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),null, "追加パラメータ11");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(null);
        bzProcessCreateInBean.setDairitenCd1(" ");
        bzProcessCreateInBean.setDairitenCd2(" ");
        bzProcessCreateInBean.setJimuyouCd(" ");
        bzProcessCreateInBean.setJimustartYmd(" ");
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        bzProcessCreate.exec(bzProcessCreateInBean);

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getExtParam4().getValue(),null, "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),null, "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),null, "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),null, "追加パラメータ11");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(null);
        bzProcessCreateInBean.setDairitenCd1("　");
        bzProcessCreateInBean.setDairitenCd2("　");
        bzProcessCreateInBean.setJimuyouCd("　");
        bzProcessCreateInBean.setJimustartYmd("　");
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        bzProcessCreate.exec(bzProcessCreateInBean);

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getExtParam4().getValue(),null, "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),null, "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),null, "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),null, "追加パラメータ11");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setSubSystemId(null);
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1002");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.SUCCESS, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setSubSystemId("");
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.SUCCESS, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setSubSystemId("sinkeiyaku");
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean= bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.SUCCESS, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "10011", "工程管理ID");
    }

    @Test(expected = BizAppException.class)
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN3;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setSubSystemId("sinkeiyaku");
        bzProcessCreateInBean.setOyaKouteiKanriId("");
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd("");
        bzProcessCreateInBean.setSkNo("100001");
        bzProcessCreateInBean.setJimuTetuzukiCd("1009");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        try {
            BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
            bzProcessCreate.exec(bzProcessCreateInBean);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "テーブル取得エラー　DM_Jimutetuzuki　key:jimutetuzukicd=1009", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;

        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000029");
        bzProcessCreateInBean.setNkSysyNo("16808000018");
        bzProcessCreateInBean.setSkeijimuKbn(C_SkeijimuKbn.TIGINSINKIN);
        bzProcessCreateInBean.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);
        bzProcessCreateInBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        bzProcessCreateInBean.setDairitenCd1("drtcd01");
        bzProcessCreateInBean.setDairitenCd2("drtcd02");
        bzProcessCreateInBean.setJimuyouCd("jmcd1");
        bzProcessCreateInBean.setJmycdMisetteiKbn(C_UmuKbn.NONE);
        bzProcessCreateInBean.setDoujiMosumu(C_UmuKbn.ARI);
        bzProcessCreateInBean.setJimustartYmd("2015010112101330");
        bzProcessCreateInBean.setMosymd(BizDate.valueOf(20150505));
        bzProcessCreateInBean.setKetteiKbn(C_KetteiKbn.KETTEI_SUMI);
        bzProcessCreateInBean.setSeirituKbn(C_SeirituKbn.ITIPMATI);
        bzProcessCreateInBean.setLincjkKbn(C_LincjkKbn.SYOUKAI);
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        BzProcessCreateOutBean bzProcessCreateOutBean = bzProcessCreate.exec(bzProcessCreateInBean);

        exClassificationEquals(bzProcessCreateOutBean.getKouteiSakuseiKekkaKbn(), C_KouteiSakuseiKekkaKbn.FAILURE, "工程作成結果区分");
        exStringEquals(bzProcessCreateOutBean.getKouteiKanriId(), "", "工程管理ID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
            (BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(),"1001", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean2.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
        exStringEquals(bzGetProcessSummaryInBean2.getMosNo(),"780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(),"16808000029", "証券番号");
        assertArrayEquals(bzGetProcessSummaryInBean2.getSkNos(),null);
        exStringEquals(bzGetProcessSummaryInBean2.getNkSysyNo(),"16808000018", "年金証書番号");

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getFlowid(),"1001", "フローID ");
        exStringEquals(processCreateInBean.getAccountid(),"Junit", "アカウントID");
        exStringEquals(processCreateInBean.getExtParam12().getValue(),"16808000029", "追加パラメータ12");
        exStringEquals(processCreateInBean.getExtParam8().getValue(),"0", "追加パラメータ8");
        exStringEquals(processCreateInBean.getExtParam13().getValue(),"16808000018", "追加パラメータ13");
        exStringEquals(processCreateInBean.getExtParam14().getValue(),"780123451", "追加パラメータ14");
        exStringEquals(processCreateInBean.getExtParam1().getValue(),"01", "追加パラメータ1");
        exStringEquals(processCreateInBean.getExtParam2().getValue(),"1", "追加パラメータ2");
        exStringEquals(processCreateInBean.getExtParam3().getValue(),"441", "追加パラメータ3");
        exStringEquals(processCreateInBean.getExtParam4().getValue(),"drtcd01", "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(),"drtcd02", "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(),"jmcd1", "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam9().getValue(),"1", "追加パラメータ9");
        exStringEquals(processCreateInBean.getExtParam11().getValue(),"2015010112101330", "追加パラメータ11");
        exStringEquals(processCreateInBean.getExtParam10().getValue(),"20150505", "追加パラメータ10");
        exStringEquals(processCreateInBean.getExtParam15().getValue(),"1", "追加パラメータ15");
        exStringEquals(processCreateInBean.getExtParam16().getValue(),"2", "追加パラメータ16");
        exStringEquals(processCreateInBean.getExtParam17().getValue(),"3", "追加パラメータ17");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean3 =  (BzGetProcessSummaryInBean)MockObjectManager.getArgument
            (BzGetProcessSummaryMockForBiz.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean3.getJimuTetuzukiCd(),"1001", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean3.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU, "(配列)工程管理状況[0]");
        exStringEquals(bzGetProcessSummaryInBean3.getMosNo(),"780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryInBean3.getSyoNo(),"16808000029", "証券番号");
        assertArrayEquals(bzGetProcessSummaryInBean3.getSkNos(),null);
        exStringEquals(bzGetProcessSummaryInBean3.getNkSysyNo(),"16808000018", "年金証書番号");

        ProcessCancelInBean processCancelInBean =  (ProcessCancelInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCancel", 0, 0);
        exStringEquals(processCancelInBean.getFlowid(),"1001", "フローID");
        exStringEquals(processCancelInBean.getAccountid(),"Junit", "アカウントID");
        exStringEquals(processCancelInBean.getLockkey(),"testKouteiLockKey", "ロックキー");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("Junit");
        IwfKouteiClientMockForBiz.mode = "dl01-01";
        IwfKouteiClientMockForBiz.flg = "dl01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        BzProcessCreateInBean bzProcessCreateInBean = new BzProcessCreateInBean();
        bzProcessCreateInBean.setOyaKouteiKanriId(null);
        bzProcessCreateInBean.setOyaKouteiJimuTetuzukiCd(null);
        bzProcessCreateInBean.setSkNo(null);
        bzProcessCreateInBean.setJimuTetuzukiCd("1001");
        bzProcessCreateInBean.setMosNo("780123451");
        bzProcessCreateInBean.setSyoNo("16808000018");
        bzProcessCreateInBean.setNkSysyNo("16808000029");
        bzProcessCreateInBean.setSkeijimuKbn(null);
        bzProcessCreateInBean.setMosUketukeKbn(null);
        bzProcessCreateInBean.setHknsyuruiNo(null);
        bzProcessCreateInBean.setDairitenCd1(null);
        bzProcessCreateInBean.setDairitenCd2(null);
        bzProcessCreateInBean.setJimuyouCd(null);
        bzProcessCreateInBean.setJmycdMisetteiKbn(null);
        bzProcessCreateInBean.setDoujiMosumu(null);
        bzProcessCreateInBean.setJimustartYmd(null);
        bzProcessCreateInBean.setMosymd(null);
        bzProcessCreateInBean.setKetteiKbn(null);
        bzProcessCreateInBean.setSeirituKbn(null);
        bzProcessCreateInBean.setLincjkKbn(null);
        BzProcessCreate bzProcessCreate = SWAKInjector.getInstance(BzProcessCreate.class);
        bzProcessCreate.exec(bzProcessCreateInBean);

        ProcessCreateInBean processCreateInBean = (ProcessCreateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class,
            "execProcessCreate", 0, 0);
        exStringEquals(processCreateInBean.getExtParam8().getValue(), "1", "追加パラメータ8");
        exStringEquals(processCreateInBean.getExtParam1().getValue(), null, "追加パラメータ1");
        exStringEquals(processCreateInBean.getExtParam2().getValue(), null, "追加パラメータ2");
        exStringEquals(processCreateInBean.getExtParam3().getValue(), null, "追加パラメータ3");
        exStringEquals(processCreateInBean.getExtParam4().getValue(), null, "追加パラメータ4");
        exStringEquals(processCreateInBean.getExtParam5().getValue(), null, "追加パラメータ5");
        exStringEquals(processCreateInBean.getExtParam7().getValue(), null, "追加パラメータ7");
        exStringEquals(processCreateInBean.getExtParam9().getValue(), null, "追加パラメータ9");
        exStringEquals(processCreateInBean.getExtParam11().getValue(), null, "追加パラメータ11");
        exStringEquals(processCreateInBean.getExtParam10().getValue(), null, "追加パラメータ10");
        exStringEquals(processCreateInBean.getExtParam15().getValue(), null, "追加パラメータ15");
        exStringEquals(processCreateInBean.getExtParam16().getValue(), null, "追加パラメータ16");
        exStringEquals(processCreateInBean.getExtParam17().getValue(), null, "追加パラメータ17");
    }
}
