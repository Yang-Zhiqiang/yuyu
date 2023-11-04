package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkeiro;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＢＯＳＳ連携用項目変換クラスのメソッド {@link ConvBossRnkKoumoku#getSyuunouKeiroKbn(
 * C_Hrkkeiro pHrkkeiro )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvBossRnkKoumokuTest_getSyuunouKeiroKbn {

    @Inject
    private ConvBossRnkKoumoku convBossRnkKoumoku;

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetSyuunouKeiroKbn_A1(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.KOUHURI);
        exStringEquals(syuunouKeiroKbn, "3", "収納経路区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetSyuunouKeiroKbn_A2(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.HURIKAE);
        exStringEquals(syuunouKeiroKbn, "8", "収納経路区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetSyuunouKeiroKbn_A3(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.CREDIT);
        exStringEquals(syuunouKeiroKbn, "A", "収納経路区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testGetSyuunouKeiroKbn_A4(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.DANTAI);
        exStringEquals(syuunouKeiroKbn, "", "収納経路区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testGetSyuunouKeiroKbn_A5(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.SYUUDAN);
        exStringEquals(syuunouKeiroKbn, "", "収納経路区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testGetSyuunouKeiroKbn_A6(){
        String syuunouKeiroKbn = convBossRnkKoumoku.getSyuunouKeiroKbn(C_Hrkkeiro.BLNK);
        exStringEquals(syuunouKeiroKbn, "", "収納経路区分");
    }
}
