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
 * 書類情報一覧ユーティリティクラスのメソッド {@link SyoruiUtility#dispImage(String[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyoruiUtilityTest_dispImage {

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
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    public void testDispImage_A1() {

        IwfImageClientMockForBiz.mode = "21-01";

        String[] imageId = new String[1];

        imageId[0] = "sk016";

        DispImageResultBean outBean = SyoruiUtility.dispImage(imageId);

        exStringEquals(outBean.getSyorikekkaStatus(), "9", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), "IWF0002", "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), "必須入力チェックエラー", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testDispImage_A2() {

        IwfImageClientMockForBiz.mode = "21-04";

        String[] imageId = new String[1];

        imageId[0] = "sk016";

        DispImageResultBean outBean = SyoruiUtility.dispImage(imageId);

        exStringEquals(outBean.getSyorikekkaStatus(), "9", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), "EAS0017", "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), "PDFリーダの作成に失敗しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testDispImage_A3() {

        IwfImageClientMockForBiz.mode = "21-07";

        String[] imageId = new String[1];

        imageId[0] = "sk016";

        DispImageResultBean outBean = SyoruiUtility.dispImage(imageId);

        exStringEquals(outBean.getSyorikekkaStatus(), "1", "処理結果ステータス");

        exStringEquals(outBean.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");

        exStringEquals(outBean.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");
    }

}
