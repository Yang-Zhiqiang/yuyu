package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込内容チェック実施要否判定のメソッド {@link HanteiMoschk#hanteiKykNenreiUpSekininkaisiNasiTyuui(BM_SyouhnZokusei, List<BM_SyouhnZokusei>, HT_MosKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiMoschkTest_hanteiKykNenreiUpSekininkaisiNasiTyuui {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込内容チェック実施要否判定";

    private final static String sheetName = "INデータ";

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000025";

    @Inject
    private HanteiMoschk hanteiMoschk;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiMoschkTest_hanteiKykNenreiUpSekininkaisiNasiTyuui.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A1() {

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(null, null, null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei,
            new ArrayList<BM_SyouhnZokusei>(), null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ｱ1", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei, null, null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.HUYOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A4() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾁ", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei, null, null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A5() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾍ", 1);

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei, null, null);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A6() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei, null, mosKihon);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "チェック要否");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testHanteiKykNenreiUpSekininkaisiNasiTyuui_A7() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾆｱ", 1);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_YouhiKbn youhiKbn = hanteiMoschk.hanteiKykNenreiUpSekininkaisiNasiTyuui(syouhnZokusei, null, mosKihon);

        exClassificationEquals(youhiKbn, C_YouhiKbn.HUYOU, "チェック要否");
    }
}
