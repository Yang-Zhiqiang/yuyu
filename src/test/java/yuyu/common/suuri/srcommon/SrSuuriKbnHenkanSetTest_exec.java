package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;

import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SkProcessForwardHenkinNyuuryokuクラスのメソッド {@link SrSuuriKbnHenkanSet#exec(C_SrKbnHenkanKbn,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrSuuriKbnHenkanSetTest_exec {

    @Inject
    private SrSuuriKbnHenkanSet srSuuriKbnHenkanSet;

    @Inject
    private static Logger logger;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5534567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5634567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "5734567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1534567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "1634567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "22", "変換後区分値");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "2134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "23", "変換後区分値");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "2734567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "24", "変換後区分値");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "2834567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "24", "変換後区分値");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "3034567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "25", "変換後区分値");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "4034567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "26", "変換後区分値");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "7134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "42", "変換後区分値");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "7234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "41", "変換後区分値");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "7334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "43", "変換後区分値");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "7434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "44", "変換後区分値");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "DRT3456";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "1", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5534567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5634567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "5734567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1534567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "1634567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "02", "変換後区分値");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "2134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "03", "変換後区分値");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "2734567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "04", "変換後区分値");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "2834567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "04", "変換後区分値");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "3034567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "05", "変換後区分値");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "4034567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "06", "変換後区分値");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "7134567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "07", "変換後区分値");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "7234567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "07", "変換後区分値");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "7334567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "07", "変換後区分値");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "7434567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "07", "変換後区分値");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "DRT3456";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "1", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(471)
    public void testExec_A47_1() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SEDAI;
        String henkanMaeKbnVal = "J";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "A170", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(472)
    public void testExec_A47_2() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SEDAI;
        String henkanMaeKbnVal = "K";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "A180", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(473)
    public void testExec_A47_3() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SEDAI;
        String henkanMaeKbnVal = "L";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "A181", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SEDAI;
        String henkanMaeKbnVal = "H";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "8";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "6";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "5", "変換後区分値");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "7";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "7", "変換後区分値");
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "AAA";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KETTEI_KEKKA;
        String henkanMaeKbnVal = "10";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KETTEI_KEKKA;
        String henkanMaeKbnVal = "11";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KETTEI_KEKKA;
        String henkanMaeKbnVal = "00";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU;
        String henkanMaeKbnVal = "AAA";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "00", "変換後区分値");
    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "12", "変換後区分値");
    }

    @Test
    @TestOrder(890)
    public void testExec_A89() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "21", "変換後区分値");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIIN;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIIN;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIIN;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIIN;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIHARAI_HASSEI_JIYUU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHIHARAI_KAISUU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKIN_D_UKETORI;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BLNK;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal = "8834567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.DAIRITENGYOUSYU;
        String henkanMaeKbnVal = "8834567";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1180)
    public void testExec_A118() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_HAITOU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1190)
    public void testExec_A119() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_HAITOU;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1200)
    public void testExec_A120() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_HAITOU;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(1210)
    public void testExec_A121() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_HAITOU;
        String henkanMaeKbnVal = "4";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1240)
    public void testExec_A124() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1250)
    public void testExec_A125() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA;
        String henkanMaeKbnVal = "JPY";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1260)
    public void testExec_A126() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA;
        String henkanMaeKbnVal = "USD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1270)
    public void testExec_A127() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA;
        String henkanMaeKbnVal = "AUD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(1280)
    public void testExec_A128() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA;
        String henkanMaeKbnVal = "EUR";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1290)
    public void testExec_A129() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1300)
    public void testExec_A130() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA;
        String henkanMaeKbnVal = "JPY";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1310)
    public void testExec_A131() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA;
        String henkanMaeKbnVal = "USD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(1320)
    public void testExec_A132() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA;
        String henkanMaeKbnVal = "AUD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(1330)
    public void testExec_A133() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA;
        String henkanMaeKbnVal = "EUR";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1470)
    public void testExec_A147() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SISUU;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "00", "変換後区分値");
    }

    @Test
    @TestOrder(1480)
    public void testExec_A148() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SISUU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(1490)
    public void testExec_A149() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SISUU;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "01", "変換後区分値");
    }

    @Test
    @TestOrder(1500)
    public void testExec_A150() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SISUU;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1640)
    public void testExec_A164() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        String henkanMaeKbnVal = "J";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "47", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1650)
    public void testExec_A165() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        String henkanMaeKbnVal = "K";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "47", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1660)
    public void testExec_A166() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        String henkanMaeKbnVal = "L";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "56", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1670)
    public void testExec_A167() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        String henkanMaeKbnVal = "H";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1680)
    public void testExec_A168() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKINGATA;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1690)
    public void testExec_A169() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKINGATA;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1700)
    public void testExec_A170() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKINGATA;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(1710)
    public void testExec_A171() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKINGATA;
        String henkanMaeKbnVal = "4";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1720)
    public void testExec_A172() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        String henkanMaeKbnVal = "L";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "42", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1730)
    public void testExec_A173() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        String henkanMaeKbnVal = "H";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
        logger.debug("変換後区分値 = " + srSuuriKbnHenkanBean.getHenkanAtoKbn());
    }

    @Test
    @TestOrder(1900)
    public void testExec_A190() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.NENKINGATA;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "7", "変換後区分値");
    }

    @Test
    @TestOrder(1910)
    public void testExec_A191() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KAISUU;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(1920)
    public void testExec_A192() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KAISUU;
        String henkanMaeKbnVal = "6";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(1930)
    public void testExec_A193() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KAISUU;
        String henkanMaeKbnVal = "12";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1940)
    public void testExec_A194() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KAISUU;
        String henkanMaeKbnVal = "99";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(1950)
    public void testExec_A195() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KAISUU;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1960)
    public void testExec_A196() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1970)
    public void testExec_A197() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(1980)
    public void testExec_A198() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(1990)
    public void testExec_A199() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "6", "変換後区分値");
    }

    @Test
    @TestOrder(2000)
    public void testExec_A200() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "4";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "4", "変換後区分値");
    }

    @Test
    @TestOrder(2010)
    public void testExec_A201() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "6";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "6", "変換後区分値");
    }

    @Test
    @TestOrder(2020)
    public void testExec_A202() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.HRK_KEIRO;
        String henkanMaeKbnVal = "5";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(2030)
    public void testExec_A203() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "1";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(2040)
    public void testExec_A204() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "2";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(2050)
    public void testExec_A205() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "3";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(2060)
    public void testExec_A206() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "4";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "4", "変換後区分値");
    }

    @Test
    @TestOrder(2070)
    public void testExec_A207() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "5";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "6", "変換後区分値");
    }

    @Test
    @TestOrder(2080)
    public void testExec_A208() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "6";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(2090)
    public void testExec_A209() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "7";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0", "変換後区分値");
    }

    @Test
    @TestOrder(2100)
    public void testExec_A210() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "9";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(2110)
    public void testExec_A211() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.KYK_JYOUTAI;
        String henkanMaeKbnVal = "8";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(2200)
    public void testExec_A220() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "10";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(2210)
    public void testExec_A221() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SHITEI_DAIRININ;
        String henkanMaeKbnVal = "11";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "4", "変換後区分値");
    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.TUUKA_SYU;
        String henkanMaeKbnVal = "JPY";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1", "変換後区分値");
    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.TUUKA_SYU;
        String henkanMaeKbnVal = "USD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "2", "変換後区分値");
    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.TUUKA_SYU;
        String henkanMaeKbnVal = "EUR";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "3", "変換後区分値");
    }

    @Test
    @TestOrder(970)
    public void testExec_A97() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.TUUKA_SYU;
        String henkanMaeKbnVal = "AUD";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "4", "変換後区分値");
    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.TUUKA_SYU;
        String henkanMaeKbnVal = "0";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, henkanMaeKbnVal);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }
}
