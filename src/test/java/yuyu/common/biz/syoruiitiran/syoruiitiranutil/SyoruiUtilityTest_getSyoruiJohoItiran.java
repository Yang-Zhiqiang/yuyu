package yuyu.common.biz.syoruiitiran.syoruiitiranutil;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 書類情報一覧ユーティリティクラスのメソッド {@link SyoruiUtility#getSyoruiJohoItiran(String[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyoruiUtilityTest_getSyoruiJohoItiran {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_書類情報一覧ユーティリティ";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyoruiUtilityTest_getSyoruiJouhouItiranBetu.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllTorikomiSyorui());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";
    }

    @Test
    @TestOrder(10)
    public void testGetSyoruiJohoItiran_A1() {

        IwfImageClientMockForBiz.mode = "qs-99";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "kb01";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 5, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean1 = resultBeanLst.get(1);

        exStringEquals(bean1.getKouteikanriId(), "kb01", "工程管理ＩＤ");

        exStringEquals(bean1.getTorikomiSyoruiCd(), "cm021", "取込書類コード");

        exStringEquals(bean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean1.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean2 = resultBeanLst.get(2);

        exStringEquals(bean2.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean2.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean2.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean2.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean3 = resultBeanLst.get(3);

        exStringEquals(bean3.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean3.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean3.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean3.getSortNo(), 3, "ソート番号");

    }

    @Test
    @TestOrder(20)
    public void testGetSyoruiJohoItiran_A2() {

        IwfImageClientMockForBiz.mode = "qs-99";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk016";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 5, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean1 = resultBeanLst.get(1);

        exStringEquals(bean1.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean1.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean1.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean1.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean2 = resultBeanLst.get(2);

        exStringEquals(bean2.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean2.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean2.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean2.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean3 = resultBeanLst.get(3);

        exStringEquals(bean3.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean3.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean3.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean3.getSortNo(), 3, "ソート番号");

    }

    @Test
    @TestOrder(30)
    public void testGetSyoruiJohoItiran_A3() {

        IwfImageClientMockForBiz.mode = "qs-99";

        String[] kouteikanriId = new String[3];

        kouteikanriId[0] = "sk033";
        kouteikanriId[1] = "sk034";
        kouteikanriId[2] = "sk038";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 30, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean1 = resultBeanLst.get(1);

        exStringEquals(bean1.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean1.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean1.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean1.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean2 = resultBeanLst.get(2);

        exStringEquals(bean2.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean2.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean2.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean2.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean3 = resultBeanLst.get(3);

        exStringEquals(bean3.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean3.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean3.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean3.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean4 = resultBeanLst.get(4);

        exStringEquals(bean4.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean4.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean4.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean4.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean5 = resultBeanLst.get(5);

        exStringEquals(bean5.getKouteikanriId(), "gyoumukey3", "工程管理ＩＤ");

        exStringEquals(bean5.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        exStringEquals(bean5.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean5.getSortNo(), 1, "ソート番号");


        SyoruiJohoItiranBean bean6 = resultBeanLst.get(6);

        exStringEquals(bean6.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean6.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean6.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean6.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean7 = resultBeanLst.get(7);

        exStringEquals(bean7.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean7.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean7.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean7.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean8 = resultBeanLst.get(8);

        exStringEquals(bean8.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean8.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean8.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean8.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean9 = resultBeanLst.get(9);

        exStringEquals(bean9.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean9.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean9.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean9.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean10 = resultBeanLst.get(10);

        exStringEquals(bean10.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean10.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean10.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean10.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean11 = resultBeanLst.get(11);

        exStringEquals(bean11.getKouteikanriId(), "", "工程管理ＩＤ");

        exStringEquals(bean11.getTorikomiSyoruiCd(), "cm099", "取込書類コード");

        exStringEquals(bean11.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean11.getSortNo(), 2, "ソート番号");


        SyoruiJohoItiranBean bean12 = resultBeanLst.get(12);

        exStringEquals(bean12.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean12.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean12.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean12.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean13 = resultBeanLst.get(13);

        exStringEquals(bean13.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean13.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean13.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean13.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean14 = resultBeanLst.get(14);

        exStringEquals(bean14.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean14.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean14.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean14.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean15 = resultBeanLst.get(15);

        exStringEquals(bean15.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean15.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean15.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean15.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean16 = resultBeanLst.get(16);

        exStringEquals(bean16.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean16.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean16.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean16.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean17 = resultBeanLst.get(17);

        exStringEquals(bean17.getKouteikanriId(), "gyoumukey1", "工程管理ＩＤ");

        exStringEquals(bean17.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean17.getSyoruiTtykYmdTime(), "20160524010201234", "書類到着日時");

        exNumericEquals(bean17.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean18 = resultBeanLst.get(18);

        exStringEquals(bean18.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean18.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean18.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean18.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean19 = resultBeanLst.get(19);

        exStringEquals(bean19.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean19.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean19.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean19.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean20 = resultBeanLst.get(20);

        exStringEquals(bean20.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean20.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean20.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean20.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean21 = resultBeanLst.get(21);

        exStringEquals(bean21.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean21.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean21.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean21.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean22 = resultBeanLst.get(22);

        exStringEquals(bean22.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean22.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean22.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean22.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean23 = resultBeanLst.get(23);

        exStringEquals(bean23.getKouteikanriId(), "gyoumukey2", "工程管理ＩＤ");

        exStringEquals(bean23.getTorikomiSyoruiCd(), "kk001", "取込書類コード");

        exStringEquals(bean23.getSyoruiTtykYmdTime(), "20160523010201234", "書類到着日時");

        exNumericEquals(bean23.getSortNo(), 3, "ソート番号");


        SyoruiJohoItiranBean bean24 = resultBeanLst.get(24);

        exStringEquals(bean24.getKouteikanriId(), "sk001", "工程管理ＩＤ");

        exStringEquals(bean24.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        exStringEquals(bean24.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean24.getSortNo(), 10, "ソート番号");


        SyoruiJohoItiranBean bean25 = resultBeanLst.get(25);

        exStringEquals(bean25.getKouteikanriId(), "sk002", "工程管理ＩＤ");

        exStringEquals(bean25.getTorikomiSyoruiCd(), "sk002", "取込書類コード");

        exStringEquals(bean25.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean25.getSortNo(), 20, "ソート番号");


        SyoruiJohoItiranBean bean26 = resultBeanLst.get(26);

        exStringEquals(bean26.getKouteikanriId(), "sk033", "工程管理ＩＤ");

        exStringEquals(bean26.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        exStringEquals(bean26.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean26.getSortNo(), 160, "ソート番号");


        SyoruiJohoItiranBean bean27 = resultBeanLst.get(27);

        exStringEquals(bean27.getKouteikanriId(), "sk034", "工程管理ＩＤ");

        exStringEquals(bean27.getTorikomiSyoruiCd(), "sk034", "取込書類コード");

        exStringEquals(bean27.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean27.getSortNo(), 170, "ソート番号");


        SyoruiJohoItiranBean bean28 = resultBeanLst.get(28);

        exStringEquals(bean28.getKouteikanriId(), "sk038", "工程管理ＩＤ");

        exStringEquals(bean28.getTorikomiSyoruiCd(), "sk038", "取込書類コード");

        exStringEquals(bean28.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean28.getSortNo(), 180, "ソート番号");


        SyoruiJohoItiranBean bean29 = resultBeanLst.get(29);

        exStringEquals(bean29.getKouteikanriId(), "nk005", "工程管理ＩＤ");

        exStringEquals(bean29.getTorikomiSyoruiCd(), "sk071", "取込書類コード");

        exStringEquals(bean29.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean29.getSortNo(), 190, "ソート番号");

    }

    @Test
    @TestOrder(40)
    public void testGetSyoruiJohoItiran_A4() {

        IwfImageClientMockForBiz.mode = "qs-102";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk016";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 1, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "sk016", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "sk016", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 210, "ソート番号");
    }

    @Test
    @TestOrder(50)
    public void testGetSyoruiJohoItiran_A5() {

        IwfImageClientMockForBiz.mode = "qs-103";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk016";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 0, "書類情報一覧Beanリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testGetSyoruiJohoItiran_A6() {

        IwfImageClientMockForBiz.mode = "qs-104";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk032";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 1, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "20160111151630111", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 150, "ソート番号");


    }

    @Test
    @TestOrder(70)
    public void testGetSyoruiJohoItiran_A7() {

        IwfImageClientMockForBiz.mode = "qs-105";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk032";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 1, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 150, "ソート番号");


    }

    @Test
    @TestOrder(80)
    public void testGetSyoruiJohoItiran_A8() {

        IwfImageClientMockForBiz.mode = "qs-106";

        String[] kouteikanriId = new String[1];

        kouteikanriId[0] = "sk032";

        GetSyoruiJohoItiranListResultBean outBean = SyoruiUtility.getSyoruiJohoItiran(kouteikanriId);

        List<SyoruiJohoItiranBean> resultBeanLst = outBean.getSyoruiJohoItiranBeanList();

        exNumericEquals(resultBeanLst.size(), 4, "書類情報一覧Beanリスト件数");

        SyoruiJohoItiranBean bean0 = resultBeanLst.get(0);

        exStringEquals(bean0.getKouteikanriId(), "GyoumuKey03", "工程管理ＩＤ");

        exStringEquals(bean0.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        exStringEquals(bean0.getSyoruiTtykYmdTime(), "20170403100217919", "書類到着日時");

        exNumericEquals(bean0.getSortNo(), 50, "ソート番号");


        SyoruiJohoItiranBean bean1 = resultBeanLst.get(1);

        exStringEquals(bean1.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exStringEquals(bean1.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        exStringEquals(bean1.getSyoruiTtykYmdTime(), "20170403100116677", "書類到着日時");

        exNumericEquals(bean1.getSortNo(), 110, "ソート番号");


        SyoruiJohoItiranBean bean2 = resultBeanLst.get(2);

        exStringEquals(bean2.getKouteikanriId(), "GyoumuKey01", "工程管理ＩＤ");

        exStringEquals(bean2.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(bean2.getSyoruiTtykYmdTime(), "20170403100112515", "書類到着日時");

        exNumericEquals(bean2.getSortNo(), 150, "ソート番号");


        SyoruiJohoItiranBean bean3 = resultBeanLst.get(3);

        exStringEquals(bean3.getKouteikanriId(), "sk032", "工程管理ＩＤ");

        exStringEquals(bean3.getTorikomiSyoruiCd(), "sk032", "取込書類コード");

        exStringEquals(bean3.getSyoruiTtykYmdTime(), "", "書類到着日時");

        exNumericEquals(bean3.getSortNo(), 150, "ソート番号");


    }


}
