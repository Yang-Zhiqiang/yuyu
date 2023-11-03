package yuyu.common.biz.syoruiitiran;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HtysyoruiumuKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 書類情報一覧設定クラスのメソッド {@link SetSyoruiInfoItiran#exec(SetSyoruiInfoItiranExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSyoruiInfoItiranTest_exec {

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_書類情報一覧設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSyoruiInfoItiranTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
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

    @AfterClass
    public static void testClear() {
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
        MockObjectManager.initialize();
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "qs-01";

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);

        bzWorkflowInfo.setKouteiKanriId("kb01");
        bzWorkflowInfo.setOyaKouteiKanriId(null);

        setSyoruiInfoItiranExecUiBeanParamImpl.setBzWorkflowInfo(bzWorkflowInfo);

        try {
            setSyoruiInfoItiran.exec(setSyoruiInfoItiranExecUiBeanParamImpl);

        }catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。書類情報一覧設定処理が正常終了しませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "qs-02";

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
        bzWorkflowInfo.setKouteiKanriId("sk01");
        bzWorkflowInfo.setOyaKouteiKanriId("");

        setSyoruiInfoItiranExecUiBeanParamImpl.setBzWorkflowInfo(bzWorkflowInfo);

        setSyoruiInfoItiran.exec(setSyoruiInfoItiranExecUiBeanParamImpl);

        String[] imageids = setSyoruiInfoItiranExecUiBeanParamImpl.getImageids();

        exStringEquals(imageids[0], null, "イメージID配列[0]");

        List<SyoruiInfoItiranDataSourceBeanCommonParam> paramLst = setSyoruiInfoItiranExecUiBeanParamImpl.getSyoruiInfoItiranDataSourceBeanCommonParamLst();

        exNumericEquals(paramLst.size(), 1, "画面の書類情報一覧リスト件数");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(0);

        exStringEquals(resultParamBean.getSyoruittykymdtime(), "", "書類到着日時");

        exClassificationEquals(resultParamBean.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.MARU, "必要書類有無区分");

        exStringEquals(resultParamBean.getSyoruinm(), "支払明細書", "書類名");

        exStringEquals(resultParamBean.getHyoujilink(), "", "表示リンク");

        exStringEquals(resultParamBean.getHyoujilinkflg(), "", "表示リンクフラグ");

        exStringEquals(resultParamBean.getImageid(), "", "イメージID");

        exStringEquals(resultParamBean.getTorikomiSyoruiCd(), "hk001", "取込書類コード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "qs-03";

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
        bzWorkflowInfo.setKouteiKanriId("nm01");
        bzWorkflowInfo.setOyaKouteiKanriId("nm01");

        setSyoruiInfoItiranExecUiBeanParamImpl.setBzWorkflowInfo(bzWorkflowInfo);

        setSyoruiInfoItiran.exec(setSyoruiInfoItiranExecUiBeanParamImpl);

        String[] imageids = setSyoruiInfoItiranExecUiBeanParamImpl.getImageids();

        exStringEquals(imageids[0], "ImageId02", "イメージID配列[0]");

        exStringEquals(imageids[1], "ImageId03", "イメージID配列[1]");

        exStringEquals(imageids[2], null, "イメージID配列[2]");

        List<SyoruiInfoItiranDataSourceBeanCommonParam> paramLst = setSyoruiInfoItiranExecUiBeanParamImpl.getSyoruiInfoItiranDataSourceBeanCommonParamLst();

        exNumericEquals(paramLst.size(), 4, "画面の書類情報一覧リスト件数");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean1 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(0);

        exStringEquals(resultParamBean1.getSyoruittykymdtime(), "H28/05/03 10:11", "書類到着日時");

        exClassificationEquals(resultParamBean1.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean1.getSyoruinm(), "支払遅延利息内訳リスト", "書類名");

        exStringEquals(resultParamBean1.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean1.getHyoujilinkflg(), "1", "表示リンクフラグ");

        exStringEquals(resultParamBean1.getImageid(), "ImageId02", "イメージID");

        exStringEquals(resultParamBean1.getTorikomiSyoruiCd(), "cm021", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean2 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(1);

        exStringEquals(resultParamBean2.getSyoruittykymdtime(), "H28/05/21 10:11", "書類到着日時");

        exClassificationEquals(resultParamBean2.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean2.getSyoruinm(), "支払明細書", "書類名");

        exStringEquals(resultParamBean2.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean2.getHyoujilinkflg(), "1", "表示リンクフラグ");

        exStringEquals(resultParamBean2.getImageid(), "ImageId03", "イメージID");

        exStringEquals(resultParamBean2.getTorikomiSyoruiCd(), "hk001", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean3 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(2);

        exStringEquals(resultParamBean3.getSyoruittykymdtime(), "", "書類到着日時");

        exClassificationEquals(resultParamBean3.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.MARU, "必要書類有無区分");

        exStringEquals(resultParamBean3.getSyoruinm(), "取込用表紙", "書類名");

        exStringEquals(resultParamBean3.getHyoujilink(), "", "表示リンク");

        exStringEquals(resultParamBean3.getHyoujilinkflg(), "", "表示リンクフラグ");

        exStringEquals(resultParamBean3.getImageid(), "", "イメージID");

        exStringEquals(resultParamBean3.getTorikomiSyoruiCd(), "wf001", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean4 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(3);

        exStringEquals(resultParamBean4.getSyoruittykymdtime(), "", "書類到着日時");

        exClassificationEquals(resultParamBean4.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean4.getSyoruinm(), "取込用表紙", "書類名");

        exStringEquals(resultParamBean4.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean4.getHyoujilinkflg(), null, "表示リンクフラグ");

        exStringEquals(resultParamBean4.getImageid(), null, "イメージID");

        exStringEquals(resultParamBean4.getTorikomiSyoruiCd(), "wf001", "取込書類コード");
    }
}
