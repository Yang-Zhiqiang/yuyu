package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.GetProcessSummaryInBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程サマリ取得クラスのメソッド<br />
 * {@link BzGetProcessSummary#exec(BzGetProcessSummaryInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetProcessSummaryTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_業務共通工程サマリ取得";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetProcessSummaryTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());

        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("0001", "001"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("0002", "002"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("0003", "003"));
        workflowDomManager.delete(workflowDomManager.getJimutetuzuki("0004", "004"));

        String[] systemId = new String[2];
        systemId[0] = "003";
        systemId[1] = "004";
        workflowDomManager.delete(workflowDomManager.getJimutetuzukiTasksBySubSystemIds(systemId));
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        IwfKouteiClientMockForBiz.mode = "dl01-03";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        try {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "IWFエラーです。機能＝業務共通工程サマリ取得、API＝工程サマリ取得、エラーコード＝IWF0001"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl01-04";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("");
        bzGetProcessSummaryInBean.setKouteiKanriId("");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setMosNo("");
        bzGetProcessSummaryInBean.setSyoNo("");
        bzGetProcessSummaryInBean.setNkSysyNo("");
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        GetProcessSummaryInBean getProcessSummaryInBean = (GetProcessSummaryInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execGetProcessSummary", 0, 0);
        exStringEquals(getProcessSummaryInBean.getKouteikaisibifrom(), "20140701", "工程開始日(自)");
        exStringEquals(getProcessSummaryInBean.getKouteikaisibito(), "20140703", "工程開始日(至)");
        exStringEquals(getProcessSummaryInBean.getKouteikanryoubifrom(), "20150701", "工程完了日(自)");
        exStringEquals(getProcessSummaryInBean.getKouteikanryoubito(), "20150703", "工程完了日(至)");
        exNumericEquals(getProcessSummaryInBean.getSyoristatus().length, 1, "処理状態(配列).length");
        exStringEquals(getProcessSummaryInBean.getSyoristatus()[0], "90", "処理状態(配列)[0]");

        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        IwfKouteiClientMockForBiz.mode = "dl01-05";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("");
        bzGetProcessSummaryInBean.setKouteiKanriId("");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setMosNo("");
        bzGetProcessSummaryInBean.setSyoNo("");
        bzGetProcessSummaryInBean.setNkSysyNo("");
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        IwfKouteiClientMockForBiz.mode = "dl01-02";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU, C_Kouteikanristatus.SYORITYUU,
            C_Kouteikanristatus.BLNK);
        String[] taskIds = new String[2];
        taskIds[0] = "TaskNm01";
        taskIds[1] = "TaskNm02";
        bzGetProcessSummaryInBean.setTaskIds(taskIds);
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

        exStringEquals(bzGetProcessSummaryOutBean.getJimuTetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBean.getJimuTetuzukiNm(), "加奈", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBean.getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBean.getKouteiStartYmd(), null, "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBean.getKouteEndYmd(), null, "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBean.getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBean.getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBean.getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBean.getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBean.getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBean.getZnkNodoNm(), "", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBean.getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBean.getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBean.getNowNodoNm(), "", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBean.getJimuStartYmd(), BizDate.valueOf("20150202"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBean.getSyoNo(), "12806345672", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBean.getMosNo(), "780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBean.getSkNo(), "10000000002", "請求番号");
        exStringEquals(bzGetProcessSummaryOutBean.getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBean.getSkeijimuKbn()
            , C_SkeijimuKbn.TIGINSINKIN, "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBean.getMosUketukeKbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBean.getHknsyuruiNo(),
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBean.getDairitencd1(), "drtcd1", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBean.getDairitencd2(), "drtcd2", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBean.getJimuyoucd(), "jmcd1", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBean.getJmycdMisetteiKbn()
            , C_UmuKbn.ARI, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBean.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBean.getJimuStartYmdTime(), "20150202121022333", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBean.getMosymd(), BizDate.valueOf("20150508"), "申込日");
        exClassificationEquals(bzGetProcessSummaryOutBean.getSyukouteiKbn(), C_YesNoKbn.NO, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBean.getSubSystemId(), "001", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBean.getJimutetuzukiDispOrder(), 0, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBean.getTskDispOrder(), 0, "タスク表示順");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        IwfKouteiClientMockForBiz.mode = "dl01-06";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        String[] taskIds = new String[2];
        taskIds[0] = "TaskNm01";
        taskIds[1] = "TaskNm02";
        bzGetProcessSummaryInBean.setTaskIds(taskIds);
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("");
        String[] skNos = new String[2];
        skNos[0] = "10000000001";
        skNos[1] = "10000000002";
        bzGetProcessSummaryInBean.setSkNos(skNos);

        BzGetProcessSummaryComparatorMosno outBean = SWAKInjector.getInstance(BzGetProcessSummaryComparatorMosno.class);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(outBean);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");

        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiNm(), "佐倉", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(), "GyoumuKey03", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd()
            , BizDate.valueOf("20150901"), "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd()
            , BizDate.valueOf("20150902"), "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoNm(), "前回ノード名１", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm(), "", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd()
            , BizDate.valueOf("20150202"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo(), "12806345683", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosNo(), "780123444", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkNo(), "10000000002", "請求番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkeijimuKbn(), C_SkeijimuKbn.TIGINSINKIN,
            "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosUketukeKbn(), C_MosUketukeKbn.MOSKIT,
            "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getHknsyuruiNo(),
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd1(), "drtcd1", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd2(), "drtcd2", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuyoucd(), "jmcd1", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getJmycdMisetteiKbn()
            , C_UmuKbn.ARI, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmdTime(), "20150202121022333", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosymd(), BizDate.valueOf("20150508"), "申込日");

        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyukouteiKbn(), C_YesNoKbn.YES, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSubSystemId(), "003", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimutetuzukiDispOrder(), 2, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getTskDispOrder(), 0, "タスク表示順");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuTetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuTetuzukiNm(), "桜南", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiKanriId(), "GyoumuKey04", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiStartYmd()
            , BizDate.valueOf("20150901"), "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteEndYmd()
            , BizDate.valueOf("20150902"), "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkNodoNm(), "", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowNodoNm(), "前回ノード名２", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuStartYmd()
            , BizDate.valueOf("20150302"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosNo(), "780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSkNo(), "10000000002", "請求番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getSkeijimuKbn(), C_SkeijimuKbn.SMBC,
            "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosUketukeKbn(), C_MosUketukeKbn.SEIHOWEB,
            "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getHknsyuruiNo(),
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getDairitencd1(), "drtcd3", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getDairitencd2(), "drtcd4", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuyoucd(), "jmcd2", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getJmycdMisetteiKbn()
            , C_UmuKbn.NONE, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuStartYmdTime(), "20150302121022111", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosymd(), BizDate.valueOf("20150509"), "申込日");

        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getSyukouteiKbn(), C_YesNoKbn.NO, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSubSystemId(), "004", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimutetuzukiDispOrder(), 3, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(1).getTskDispOrder(), 2, "タスク表示順");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        IwfKouteiClientMockForBiz.mode = "dl01-02";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        IwfKouteiClientMockForBiz.mode = "dl01-02";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("001");
        String[] skNos = new String[2];
        skNos[0] = "10000000008";
        skNos[1] = "10000000009";
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        bzGetProcessSummaryInBean.setSkNos(skNos);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        IwfKouteiClientMockForBiz.mode = "dl01-02";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("009");
        String[] skNos = new String[2];
        skNos[0] = "10000000008";
        skNos[1] = "10000000009";
        bzGetProcessSummaryInBean.setSkNos(skNos);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        IwfKouteiClientMockForBiz.mode = "dl01-06";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("0001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setTaskId("TaskNm02");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.ARI);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");

        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiNm(), "佐倉", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(), "GyoumuKey03", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd()
            , BizDate.valueOf("20150901"), "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd()
            , BizDate.valueOf("20150902"), "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoNm(), "前回ノード名１", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm(), "", "現在ノード名");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        IwfKouteiClientMockForBiz.mode = "dl01-06";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("100");
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        String[] taskIds = new String[2];
        taskIds[0] = "TaskNm01";
        taskIds[1] = "TaskNm02";
        bzGetProcessSummaryInBean.setTaskIds(taskIds);
        bzGetProcessSummaryInBean.setTaskId("TaskNm01");
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("");
        String[] skNos = new String[2];
        skNos[0] = "10000000001";
        skNos[1] = "10000000002";
        bzGetProcessSummaryInBean.setSkNos(skNos);

        BzGetProcessSummaryComparatorMosno outBean = SWAKInjector.getInstance(BzGetProcessSummaryComparatorMosno.class);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(outBean);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");

        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd(), "0003", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiNm(), "佐倉", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(), "GyoumuKey03", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd()
            , BizDate.valueOf("20150901"), "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd()
            , BizDate.valueOf("20150902"), "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoNm(), "前回ノード名１", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm(), "", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd()
            , BizDate.valueOf("20150202"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo(), "12806345683", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosNo(), "780123444", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkNo(), "10000000002", "請求番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkeijimuKbn(), C_SkeijimuKbn.TIGINSINKIN,
            "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosUketukeKbn(), C_MosUketukeKbn.MOSKIT,
            "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getHknsyuruiNo(),
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd1(), "drtcd1", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd2(), "drtcd2", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuyoucd(), "jmcd1", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getJmycdMisetteiKbn()
            , C_UmuKbn.ARI, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmdTime(), "20150202121022333", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosymd(), BizDate.valueOf("20150508"), "申込日");

        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyukouteiKbn(), C_YesNoKbn.YES, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSubSystemId(), "003", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimutetuzukiDispOrder(), 2, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getTskDispOrder(), 0, "タスク表示順");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuTetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuTetuzukiNm(), "桜南", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiKanriId(), "GyoumuKey04", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiStartYmd()
            , BizDate.valueOf("20150901"), "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteEndYmd()
            , BizDate.valueOf("20150902"), "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getZnkNodoNm(), "", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowNodoId(), "TaskNm02", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNowNodoNm(), "前回ノード名２", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuStartYmd()
            , BizDate.valueOf("20150302"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosNo(), "780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSkNo(), "10000000002", "請求番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getSkeijimuKbn(), C_SkeijimuKbn.SMBC,
            "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosUketukeKbn(), C_MosUketukeKbn.SEIHOWEB,
            "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getHknsyuruiNo(),
            C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getDairitencd1(), "drtcd3", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getDairitencd2(), "drtcd4", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuyoucd(), "jmcd2", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getJmycdMisetteiKbn()
            , C_UmuKbn.NONE, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimuStartYmdTime(), "20150302121022111", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(1).getMosymd(), BizDate.valueOf("20150509"), "申込日");

        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(1).getSyukouteiKbn(), C_YesNoKbn.NO, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(1).getSubSystemId(), "004", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(1).getJimutetuzukiDispOrder(), 3, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(1).getTskDispOrder(), 2, "タスク表示順");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        IwfKouteiClientMockForBiz.mode = "dl01-14";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        bzGetProcessSummaryInBean.setKouteiKanriId("111");
        bzGetProcessSummaryInBean.setJimuKaisiYmdFrom("20170911");
        bzGetProcessSummaryInBean.setJimuKaisiYmdTo("20170912");
        C_KetteiKbn[] ketteiKbn = new C_KetteiKbn[2];
        ketteiKbn[0] = C_KetteiKbn.KETTEI_SUMI;
        ketteiKbn[1] = C_KetteiKbn.KETTEI_MATI;
        bzGetProcessSummaryInBean.setKetteiKbn(ketteiKbn);
        C_SeirituKbn[] seirituKbn = new C_SeirituKbn[2];
        seirituKbn[0] = C_SeirituKbn.NONE;
        seirituKbn[1] = C_SeirituKbn.SEIRITU;
        bzGetProcessSummaryInBean.setSeirituKbn(seirituKbn);
        C_LincjkKbn[] lincjkKbn = new C_LincjkKbn[2];
        lincjkKbn[0] = C_LincjkKbn.SYOUKAITAISYOUGAI;
        lincjkKbn[1] = C_LincjkKbn.SYOUKAI;
        bzGetProcessSummaryInBean.setLincjkKbn(lincjkKbn);
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        String[] taskIds = new String[2];
        taskIds = null;
        bzGetProcessSummaryInBean.setTaskIds(taskIds);
        bzGetProcessSummaryInBean.setTaskId("TaskNm01");
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("");
        String[] skNos = new String[2];
        skNos = null;
        bzGetProcessSummaryInBean.setSkNos(skNos);
        BzGetProcessSummaryComparatorMosno outBean = SWAKInjector.getInstance(BzGetProcessSummaryComparatorMosno.class);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(outBean);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));
        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);
        exNumericEquals(bzGetProcessSummaryOutBeanLst.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ ");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiCd(), "0002", "事務手続コード" );
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuTetuzukiNm(), "名井", "事務手続名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(), "GyoumuKey02", "工程管理ID");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiStartYmd()
            , null, "工程開始年月日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteEndYmd()
            , null, "工程完了年月日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriStatus(),
            C_Kouteikanristatus.SYORITYUU, "工程管理状況");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getLastKosTime(), "20150720163400", "最終更新時間");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getFirstTantId(), "user001", "初回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkTantId(), "user002", "前回担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoId(), "TaskNm01", " 前回ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getZnkNodoNm(), "", "前回ノード名");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowTantId(), "user003", "現在担当者ID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId(), "TaskNm03", "現在ノードID");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoNm(), "", "現在ノード名");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmd()
            , BizDate.valueOf("20150202"), "事務開始年月日");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyoNo(), "12806345672", "証券番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosNo(), "780123451", "申込番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkNo(), null, "請求番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getNkSysyNo(), "12806345661", "年金証書番号");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSkeijimuKbn(), null,
            "新契約事務区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosUketukeKbn(), null,
            "申込受付区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getHknsyuruiNo(),
            null, "保険種類番号");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd1(), "drtcd1", "代理店コード１");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getDairitencd2(), "drtcd2", "代理店コード２");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuyoucd(), "jmcd1", "事務用コード");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getJmycdMisetteiKbn()
            , null, "事務用コード未設定区分");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getDoujimosumu(), null, "同時申込有無");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimuStartYmdTime(), "20150202121022333", "事務開始日");
        exDateEquals(bzGetProcessSummaryOutBeanLst.get(0).getMosymd(), null, "申込日");
        exClassificationEquals(bzGetProcessSummaryOutBeanLst.get(0).getSyukouteiKbn(), C_YesNoKbn.NO, "主工程区分");
        exStringEquals(bzGetProcessSummaryOutBeanLst.get(0).getSubSystemId(), "002", "サブシステムID");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getJimutetuzukiDispOrder(), 1, "事務手続表示順");
        exNumericEquals(bzGetProcessSummaryOutBeanLst.get(0).getTskDispOrder(), 0, "タスク表示順");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(120)
    public void testExec_A12() {
        IwfKouteiClientMockForBiz.mode = "dl01-15";
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setJimuTetuzukiCd("001");
        String[] s = new String[1];
        s[0] = "1";
        bzGetProcessSummaryInBean.setKouteiKanriIds(s);
        bzGetProcessSummaryInBean.setKekkajyougenkensu("1");
        bzGetProcessSummaryInBean.setKouteiKanriId("14");
        bzGetProcessSummaryInBean.setJimuKaisiYmdFrom("20170911111111111");
        bzGetProcessSummaryInBean.setJimuKaisiYmdTo("20170912111111111");
        C_KetteiKbn[] ketteiKbn = new C_KetteiKbn[2];
        ketteiKbn[0] = C_KetteiKbn.KETTEI_SUMI;
        ketteiKbn[1] = C_KetteiKbn.KETTEI_MATI;
        bzGetProcessSummaryInBean.setKetteiKbn(ketteiKbn);
        C_SeirituKbn[] seirituKbn = new C_SeirituKbn[2];
        seirituKbn[0] = C_SeirituKbn.NONE;
        seirituKbn[1] = C_SeirituKbn.SEIRITU;
        bzGetProcessSummaryInBean.setSeirituKbn(seirituKbn);
        C_LincjkKbn[] lincjkKbn = new C_LincjkKbn[2];
        lincjkKbn[0] = C_LincjkKbn.SYOUKAITAISYOUGAI;
        lincjkKbn[1] = C_LincjkKbn.SYOUKAI;
        bzGetProcessSummaryInBean.setLincjkKbn(lincjkKbn);
        bzGetProcessSummaryInBean.setKouteiStartYmdFrom(BizDate.valueOf("20140701"));
        bzGetProcessSummaryInBean.setKouteEndYmdFrom(BizDate.valueOf("20150701"));
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.KANRYOU);
        String[] taskIds = new String[2];
        taskIds = null;
        bzGetProcessSummaryInBean.setTaskIds(taskIds);
        bzGetProcessSummaryInBean.setTaskId("TaskNm01");
        bzGetProcessSummaryInBean.setSyoNo("12806345672");
        bzGetProcessSummaryInBean.setNkSysyNo("12806345661");
        bzGetProcessSummaryInBean.setMosNo("780123451");
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setSubSystemId("");
        String[] skNos = new String[2];
        skNos = null;
        bzGetProcessSummaryInBean.setSkNos(skNos);
        BzGetProcessSummaryComparatorMosno outBean = SWAKInjector.getInstance(BzGetProcessSummaryComparatorMosno.class);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(outBean);
        bzGetProcessSummaryInBean.setKouteiStartYmdTo(BizDate.valueOf("20140703"));
        bzGetProcessSummaryInBean.setKouteEndYmdTo(BizDate.valueOf("20150703"));

        try {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage()
                , "取得数が、上限件数を超えています。"
                , "エラーメッセージ");
            throw e;
        }
    }
}
