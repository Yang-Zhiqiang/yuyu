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
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HtysyoruiumuKbn;
import yuyu.def.classification.C_SyoruiInfoItiranHyoujiHouhouKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 書類情報一覧設定クラスのメソッド {@link SetSyoruiInfoItiran#exec(SetSyoruiInfoItiranExecUiBeanParam, C_SyoruiInfoItiranHyoujiHouhouKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSyoruiInfoItiranTest_exec_hyouji_00_02 {

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_書類情報一覧設定_000_02";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetSyoruiInfoItiranTest_exec_hyouji_00_02.class, fileName, sheetName);
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

    @Test
    @TestOrder(50)
    public void testExec_hyouji__00_A1() {
        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "qs-100";

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
        bzWorkflowInfo.setKouteiKanriId("cm01");
        bzWorkflowInfo.setOyaKouteiKanriId("cm01");

        setSyoruiInfoItiranExecUiBeanParamImpl.setBzWorkflowInfo(bzWorkflowInfo);

        setSyoruiInfoItiran.exec(setSyoruiInfoItiranExecUiBeanParamImpl);

        List<SyoruiInfoItiranDataSourceBeanCommonParam> paramLst = setSyoruiInfoItiranExecUiBeanParamImpl.getSyoruiInfoItiranDataSourceBeanCommonParamLst();

        exNumericEquals(paramLst.size(), 5, "画面の書類情報一覧リスト件数");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean1 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(0);

        exStringEquals(resultParamBean1.getSyoruittykymdtime(), "H29/04/03 10:01", "書類到着日時");

        exClassificationEquals(resultParamBean1.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean1.getSyoruinm(), "申込書", "書類名");

        exStringEquals(resultParamBean1.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean1.getHyoujilinkflg(), "1", "表示リンクフラグ");

        exStringEquals(resultParamBean1.getImageid(), "ImageId01", "イメージID");

        exStringEquals(resultParamBean1.getTorikomiSyoruiCd(), "sk001", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean2 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(1);

        exStringEquals(resultParamBean2.getSyoruittykymdtime(), "H29/04/03 10:02", "書類到着日時");

        exClassificationEquals(resultParamBean2.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean2.getSyoruinm(), "意向確認書", "書類名");

        exStringEquals(resultParamBean2.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean2.getHyoujilinkflg(), "1", "表示リンクフラグ");

        exStringEquals(resultParamBean2.getImageid(), "ImageId03", "イメージID");

        exStringEquals(resultParamBean2.getTorikomiSyoruiCd(), "sk005", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean3 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(2);

        exStringEquals(resultParamBean3.getSyoruittykymdtime(), "H29/04/03 10:01", "書類到着日時");

        exClassificationEquals(resultParamBean3.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean3.getSyoruinm(), "取扱報告書", "書類名");

        exStringEquals(resultParamBean3.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean3.getHyoujilinkflg(), "1", "表示リンクフラグ");

        exStringEquals(resultParamBean3.getImageid(), "ImageId02", "イメージID");

        exStringEquals(resultParamBean3.getTorikomiSyoruiCd(), "sk011", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean4 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(3);

        exStringEquals(resultParamBean4.getSyoruittykymdtime(), "H29/04/03 10:01", "書類到着日時");

        exClassificationEquals(resultParamBean4.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean4.getSyoruinm(), "契約確認依頼書", "書類名");

        exStringEquals(resultParamBean4.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean4.getHyoujilinkflg(),  "1", "表示リンクフラグ");

        exStringEquals(resultParamBean4.getImageid(),  "ImageId04", "イメージID");

        exStringEquals(resultParamBean4.getTorikomiSyoruiCd(), "sk033", "取込書類コード");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean5 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(4);

        exStringEquals(resultParamBean5.getSyoruittykymdtime(), "H29/04/03 10:03", "書類到着日時");

        exClassificationEquals(resultParamBean5.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean5.getSyoruinm(), "契約確認回答書", "書類名");

        exStringEquals(resultParamBean5.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean5.getHyoujilinkflg(),  "1", "表示リンクフラグ");

        exStringEquals(resultParamBean5.getImageid(),  "ImageId05", "イメージID");

        exStringEquals(resultParamBean5.getTorikomiSyoruiCd(), "sk034", "取込書類コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_hyouji__00_A2() {
        MockObjectManager.initialize();

        IwfImageClientMockForBiz.mode = "qs-101";

        SetSyoruiInfoItiranExecUiBeanParamImpl setSyoruiInfoItiranExecUiBeanParamImpl = SWAKInjector.getInstance(SetSyoruiInfoItiranExecUiBeanParamImpl.class);

        BzWorkflowInfo bzWorkflowInfo = SWAKInjector.getInstance(BzWorkflowInfo.class);
        bzWorkflowInfo.setKouteiKanriId("cm01");
        bzWorkflowInfo.setOyaKouteiKanriId("cm01");

        setSyoruiInfoItiranExecUiBeanParamImpl.setBzWorkflowInfo(bzWorkflowInfo);

        setSyoruiInfoItiran.exec(setSyoruiInfoItiranExecUiBeanParamImpl);

        List<SyoruiInfoItiranDataSourceBeanCommonParam> paramLst = setSyoruiInfoItiranExecUiBeanParamImpl.getSyoruiInfoItiranDataSourceBeanCommonParamLst();

        exNumericEquals(paramLst.size(), 1, "画面の書類情報一覧リスト件数");

        SyoruiInfoItiranDataSourceBeanCommonParamImpl resultParamBean1 = (SyoruiInfoItiranDataSourceBeanCommonParamImpl)paramLst.get(0);

        exStringEquals(resultParamBean1.getSyoruittykymdtime(), "H29/04/03 10:00", "書類到着日時");

        exClassificationEquals(resultParamBean1.getHtysyoruiumukbn(), C_HtysyoruiumuKbn.BLNK, "必要書類有無区分");

        exStringEquals(resultParamBean1.getSyoruinm(), "告知書", "書類名");

        exStringEquals(resultParamBean1.getHyoujilink(), "表示", "表示リンク");

        exStringEquals(resultParamBean1.getHyoujilinkflg(), "0", "表示リンクフラグ");

        exStringEquals(resultParamBean1.getImageid(), "ImageId06", "イメージID");

        exStringEquals(resultParamBean1.getTorikomiSyoruiCd(), "sk003", "取込書類コード");
    }
}
