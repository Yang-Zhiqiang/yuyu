package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＢＯＳＳ連携用項目変換クラスのメソッド {@link ConvBossRnkKoumoku#getSyouhnBunruiKbn( BM_SyouhnZokusei pSyouhnZokusei
 * )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvBossRnkKoumokuTest_getSyouhnBunruiKbn {


    @Inject
    private ConvBossRnkKoumoku convBossRnkKoumoku;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_ＢＯＳＳ連携用項目変換";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetSyouhnBunruiKbn_A1(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        String syouhnBunruiKbn = convBossRnkKoumoku.getSyouhnBunruiKbn(pSyouhnZokusei);
        exStringEquals(syouhnBunruiKbn, "C", "商品分類区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetSyouhnBunruiKbn_A2(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        String syouhnBunruiKbn = convBossRnkKoumoku.getSyouhnBunruiKbn(pSyouhnZokusei);
        exStringEquals(syouhnBunruiKbn, "B", "商品分類区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetSyouhnBunruiKbn_A3(){
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyouhncd("ﾃｽﾄ");
        pSyouhnZokusei.setSyuusinhknumu(C_UmuKbn.NONE);
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);

        String syouhnBunruiKbn = convBossRnkKoumoku.getSyouhnBunruiKbn(pSyouhnZokusei);
        exStringEquals(syouhnBunruiKbn, "", "商品分類区分");
    }
}
