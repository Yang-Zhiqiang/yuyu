package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＢＯＳＳ連携用項目変換クラスのメソッド {@link ConvBossRnkKoumoku#execAll( BM_SyouhnZokusei pSyouhnZokusei
 * )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvBossRnkKoumokuTest_getSyouhnNmKbn {


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
    public void testGetSyouhnNmKbn_A1(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.USD);
        exStringEquals(syouhnNmKbn, "35", "商品名称区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetSyouhnNmKbn_A2(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｹ", 1);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.USD);
        exStringEquals(syouhnNmKbn, "36", "商品名称区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetSyouhnNmKbn_A3(){
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyouhncd("ﾃｽﾄ");
        pSyouhnZokusei.setSyuusinhknumu(C_UmuKbn.NONE);
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.BLNK);
        exStringEquals(syouhnNmKbn, "", "商品名称区分");
    }


    @Test
    @Transactional
    @TestOrder(40)
    public void testGetSyouhnNmKbn_A4(){
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyouhncd("ﾆｱ");
        pSyouhnZokusei.setSyuusinhknumu(C_UmuKbn.ARI);
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.JPY);
        exStringEquals(syouhnNmKbn, "33", "商品名称区分");
    }


    @Test
    @Transactional
    @TestOrder(50)
    public void testGetSyouhnNmKbn_A5(){
        BM_SyouhnZokusei pSyouhnZokusei = new BM_SyouhnZokusei();
        pSyouhnZokusei.setSyouhncd("ﾆｱ");
        pSyouhnZokusei.setSyuusinhknumu(C_UmuKbn.ARI);
        pSyouhnZokusei.setNkhknumu(C_UmuKbn.NONE);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.USD);
        exStringEquals(syouhnNmKbn, "34", "商品名称区分");
    }


    @Test
    @Transactional
    @TestOrder(60)
    public void testGetSyouhnNmKbn_A6(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕﾁ", 1);
        String syouhnNmKbn = convBossRnkKoumoku.getSyouhnNmKbn(pSyouhnZokusei, C_Tuukasyu.USD);
        exStringEquals(syouhnNmKbn, "37", "商品名称区分");
    }
}
