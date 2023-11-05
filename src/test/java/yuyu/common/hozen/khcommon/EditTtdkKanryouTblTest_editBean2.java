package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editBean(C_SyoruiCdKbn,KhozenCommonParam,IT_TtdkKan,IT_KykSya)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editBean2 {

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ_20190606";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editBean2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditBean_A1() {

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004659");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806004659", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "17806004659", "（ＩＲ）証券番号");
        exClassificationEquals(khTtdkkanryouBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR, "（ＩＲ）書類コード");
        exClassificationEquals(khTtdkkanryouBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.ARI, "（ＩＲ）猶予期間超過有無");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditBean_A2() {

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111118", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111118", "（ＩＲ）証券番号");
        exClassificationEquals(khTtdkkanryouBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "（ＩＲ）書類コード");
        exClassificationEquals(khTtdkkanryouBean.getIrYuuyokkntyoukaumu(), C_UmuKbn.NONE, "（ＩＲ）猶予期間超過有無");
    }
}
