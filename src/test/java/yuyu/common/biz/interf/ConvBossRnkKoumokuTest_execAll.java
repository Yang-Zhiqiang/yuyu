package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＢＯＳＳ連携用項目変換クラスのメソッド {@link ConvBossRnkKoumoku#execAll( BM_SyouhnZokusei pSyouhnZokusei,
 * C_Hrkkeiro pHrkkeiro )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvBossRnkKoumokuTest_execAll {


    @Inject
    private ConvBossRnkKoumoku convBossRnkKoumoku;

    @Inject
    private ConvBossRnkKoumokuBean convBossRnkKoumokuBean;

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
    public void testExecAll_A1(){
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 1);
        convBossRnkKoumokuBean = convBossRnkKoumoku.execAll(pSyouhnZokusei, C_Hrkkeiro.KOUHURI,C_Tuukasyu.USD);
        exStringEquals(convBossRnkKoumokuBean.getSyouhinBunruiKbn(), "C", "商品分類区分");
        exStringEquals(convBossRnkKoumokuBean.getSyouhnNmKbn(), "35", "商品名称区分");
        exStringEquals(convBossRnkKoumokuBean.getSyuunouKeiroKbn(), "3", "収納経路区分");
    }

}
