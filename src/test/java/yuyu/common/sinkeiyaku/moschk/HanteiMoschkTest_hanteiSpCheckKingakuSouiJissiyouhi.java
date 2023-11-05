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
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込内容チェック実施要否判定のメソッド {@link HanteiMoschk#hanteiSpCheckKingakuSouiJissiyouhi(BM_SyouhnZokusei, List<BM_SyouhnZokusei>, HT_MosKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiMoschkTest_hanteiSpCheckKingakuSouiJissiyouhi {

    private final static String mosNo1 = "860000017";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込内容チェック実施要否判定";

    private final static String sheetName = "INデータ";

    @Inject
    private HanteiMoschk hanteiMoschk;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiMoschkTest_hanteiSpCheckKingakuSouiJissiyouhi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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
    public void testHanteiSpCheckKingakuSouiJissiyouhi_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_BlnktkumuKbn blnktkumuKbn = hanteiMoschk.hanteiSpCheckKingakuSouiJissiyouhi(null, null, mosKihon);

        exClassificationEquals(blnktkumuKbn, C_BlnktkumuKbn.BLNK, "ＳＰチェックでの実施有無");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testHanteiSpCheckKingakuSouiJissiyouhi_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);

        C_BlnktkumuKbn blnktkumuKbn = hanteiMoschk.hanteiSpCheckKingakuSouiJissiyouhi(syouhnZokusei, null, null);

        exClassificationEquals(blnktkumuKbn, C_BlnktkumuKbn.BLNK, "ＳＰチェックでの実施有無");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHanteiSpCheckKingakuSouiJissiyouhi_A3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        C_BlnktkumuKbn blnktkumuKbn = hanteiMoschk.hanteiSpCheckKingakuSouiJissiyouhi(syouhnZokusei,
            new ArrayList<BM_SyouhnZokusei>(), mosKihon);

        exClassificationEquals(blnktkumuKbn, C_BlnktkumuKbn.ARI, "ＳＰチェックでの実施有無");
    }
}
