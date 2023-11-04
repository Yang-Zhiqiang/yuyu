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
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editBosyuuDairitenAtkiKeitaiKbn(List)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editBosyuuDairitenAtkiKeitaiKbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

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
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_editBosyuuDairitenAtkiKeitaiKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    }

    @Test
    @TestOrder(10)
    public void testEditBosyuuDairitenAtkiKeitaiKbn_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        String bsDrtAtkiKtKbn = editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

        exStringEquals(bsDrtAtkiKtKbn, "0", "募集代理店扱形態区分");
    }

    @Test
    @TestOrder(20)
    public void testEditBosyuuDairitenAtkiKeitaiKbn_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        String bsDrtAtkiKtKbn = editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

        exStringEquals(bsDrtAtkiKtKbn, "3", "募集代理店扱形態区分");
    }

    @Test
    @TestOrder(30)
    public void testEditBosyuuDairitenAtkiKeitaiKbn_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        String bsDrtAtkiKtKbn = editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

        exStringEquals(bsDrtAtkiKtKbn, "1", "募集代理店扱形態区分");
    }

    @Test
    @TestOrder(40)
    public void testEditBosyuuDairitenAtkiKeitaiKbn_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        String bsDrtAtkiKtKbn = editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

        exStringEquals(bsDrtAtkiKtKbn, "1", "募集代理店扱形態区分");
    }


    @Test
    @TestOrder(50)
    public void testEditBosyuuDairitenAtkiKeitaiKbn_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        String bsDrtAtkiKtKbn = editPalRenkeiKoumoku.editBosyuuDairitenAtkiKeitaiKbn(mosDairitenLst);

        exStringEquals(bsDrtAtkiKtKbn, "1", "募集代理店扱形態区分");
    }
}