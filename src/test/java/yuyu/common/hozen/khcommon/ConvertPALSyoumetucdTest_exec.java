package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ消滅コード変換クラスのメソッド {@link ConvertPALSyoumetucd#exec(C_Syoumetujiyuu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvertPALSyoumetucdTest_exec {

    @Inject
    private ConvertPALSyoumetucd convertPALSyoumetucd;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.KYKTORIKESI);
        assertEquals(palSyoumetuCd,"0350");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.CLGOFF);
        assertEquals(palSyoumetuCd,"0350");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.MUKOU);
        assertEquals(palSyoumetuCd,"0350");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.KAIJO);
        assertEquals(palSyoumetuCd,"0351");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SIBOU);
        assertEquals(palSyoumetuCd,"3090");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU);
        assertEquals(palSyoumetuCd,"3092");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI);
        assertEquals(palSyoumetuCd,"3093");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SBKAIJO);
        assertEquals(palSyoumetuCd,"3250");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.MENSEKI);
        assertEquals(palSyoumetuCd,"3251");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SBMUKOU);
        assertEquals(palSyoumetuCd,"3252");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.KAIYAKU);
        assertEquals(palSyoumetuCd,"5010");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.JIKOU);
        assertEquals(palSyoumetuCd,"0100");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.SIBOUKYUUHUKINSHR);
        assertEquals(palSyoumetuCd,"3091");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM);
        assertEquals(palSyoumetuCd, "5010");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM);
        assertEquals(palSyoumetuCd, "5011");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.PMNYSYMET_MSSN);
        assertEquals(palSyoumetuCd,"6020");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        String palSyoumetuCd = convertPALSyoumetucd.exec(C_Syoumetujiyuu.TSNGNDTYOUKA);
        assertEquals(palSyoumetuCd, "");
    }

}
