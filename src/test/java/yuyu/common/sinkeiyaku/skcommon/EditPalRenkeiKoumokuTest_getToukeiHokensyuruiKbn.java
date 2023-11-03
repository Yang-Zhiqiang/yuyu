package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#getToukeiHokensyuruiKbn(BM_SyouhnZokusei, HT_MosKihon)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getToukeiHokensyuruiKbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ連携項目編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_getToukeiHokensyuruiKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ008", testDataAndTblMap);
        } catch (Exception e) {
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
    @TestOrder(10)
    public void testGetToukeiHokensyuruiKbn_A1() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕｹ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003401").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "10", "統計用保険種類区分");
    }

    @Test
    @TestOrder(20)
    public void testGetToukeiHokensyuruiKbn_A2() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕｹ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003402").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "61", "統計用保険種類区分");
    }

    @Test
    @TestOrder(30)
    public void testGetToukeiHokensyuruiKbn_A3() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕｹ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003403").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "61", "統計用保険種類区分");
    }

    @Test
    @TestOrder(40)
    public void testGetToukeiHokensyuruiKbn_A4() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕｱ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003401").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "37", "統計用保険種類区分");
    }

    @Test
    @TestOrder(50)
    public void testGetToukeiHokensyuruiKbn_A5() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾁ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003401").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "01", "統計用保険種類区分");
    }

    @Test
    @TestOrder(60)
    public void testGetToukeiHokensyuruiKbn_A6() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾄ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003401").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "29", "統計用保険種類区分");
    }

    @Test
    @TestOrder(70)
    public void testGetToukeiHokensyuruiKbn_A7() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾍ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003404").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "M3", "統計用保険種類区分");
    }

    @Test
    @TestOrder(80)
    public void testGetToukeiHokensyuruiKbn_A8() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾍ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003405").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "M2", "統計用保険種類区分");
    }

    @Test
    @TestOrder(90)
    public void testGetToukeiHokensyuruiKbn_A9() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾎ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003406").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "M1", "統計用保険種類区分");
    }

    @Test
    @TestOrder(100)
    public void testGetToukeiHokensyuruiKbn_A10() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾕﾎ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003407").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "M1", "統計用保険種類区分");
    }

    @Test
    @TestOrder(110)
    public void testGetToukeiHokensyuruiKbn_A11() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾆｱ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003408").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "M5", "統計用保険種類区分");
    }

    @Test
    @TestOrder(120)
    public void testGetToukeiHokensyuruiKbn_A12() {
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdMaxSyouhnsdno("ﾆｱ");
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003409").get(0);

        String toukeiHokensyuruiKbn = editPalRenkeiKoumoku.getToukeiHokensyuruiKbn(pSyouhnZokusei, pMosKihon);

        exStringEquals(toukeiHokensyuruiKbn, "99", "統計用保険種類区分");
    }
}
