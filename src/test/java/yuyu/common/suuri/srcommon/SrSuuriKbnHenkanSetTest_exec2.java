package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.testinfr.TestOrder;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.testinfr.OrderedRunner;

/**
 * SkProcessForwardHenkinNyuuryokuクラスのメソッド {@link SrSuuriKbnHenkanSet#exec2(C_SrKbnHenkanKbn,String,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrSuuriKbnHenkanSetTest_exec2 {

    @Inject
    private SrSuuriKbnHenkanSet srSuuriKbnHenkanSet;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｱ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｲ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｳ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｴ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｵ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｶ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｷ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｸ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｹ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｺ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｻ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｼ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｽ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｾ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕｿ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾀ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕA";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0U", "変換後区分値");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕB";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕC";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕD";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕE";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾁ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾂ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾃ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾄ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾅ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾆ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾇ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾈ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾉ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1C", "変換後区分値");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾊ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1D", "変換後区分値");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾋ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1C", "変換後区分値");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾌ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1D", "変換後区分値");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾍ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾎ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾏ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾐ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾑ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾒ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾓ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾔ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾕ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾖ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾗ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾘ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾙ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾚ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾛ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕﾜ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾕF";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1E", "変換後区分値");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾆｱ";
        String henkanMaeKbnVal2 = "JPY";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1F", "変換後区分値");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｱ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｲ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｳ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｴ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｵ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｶ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｷ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0S", "変換後区分値");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｸ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0T", "変換後区分値");
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｹ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｺ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｻ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｼ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E7", "変換後区分値");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｽ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｾ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕｿ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾀ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E8", "変換後区分値");
    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕA";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "0U", "変換後区分値");
    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕB";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕC";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕD";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕE";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "E9", "変換後区分値");
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾁ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾂ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾃ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾄ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F0", "変換後区分値");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾅ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾆ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(790)
    public void testExec_A79() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾇ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾈ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F1", "変換後区分値");
    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾉ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1C", "変換後区分値");
    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾊ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1D", "変換後区分値");
    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾋ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1C", "変換後区分値");
    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾌ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1D", "変換後区分値");
    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾍ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾎ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾏ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾐ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F2", "変換後区分値");
    }

    @Test
    @TestOrder(890)
    public void testExec_A89() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾑ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(900)
    public void testExec_A90() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾒ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(910)
    public void testExec_A91() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾓ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾔ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F3", "変換後区分値");
    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾕ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾖ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾗ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾘ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F4", "変換後区分値");
    }

    @Test
    @TestOrder(970)
    public void testExec_A97() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾙ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾚ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(990)
    public void testExec_A99() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾛ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }

    @Test
    @TestOrder(1000)
    public void testExec_A100() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕﾜ";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "F5", "変換後区分値");
    }


    @Test
    @TestOrder(1010)
    public void testExec_A101() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾕF";
        String henkanMaeKbnVal2 = "";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1E", "変換後区分値");
    }

    @Test
    @TestOrder(1020)
    public void testExec_A102() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "ﾆｱ";
        String henkanMaeKbnVal2 = "USD" ;

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "0", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "0", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "1G", "変換後区分値");
    }

    @Test
    @TestOrder(1030)
    public void testExec_A103() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "ﾆｱ";
        String henkanMaeKbnVal2 = "EUR";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1040)
    public void testExec_A104() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SYOKEIYAKU;
        String henkanMaeKbnVal1 = "12";
        String henkanMaeKbnVal2 = "JPY";

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1050)
    public void testExec_A105() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURISYURUI;
        String henkanMaeKbnVal1 = "12";
        String henkanMaeKbnVal2 = "USD" ;

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }

    @Test
    @TestOrder(1060)
    public void testExec_A106() {

        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BOSYU_KEITAI;
        String henkanMaeKbnVal1 = "";
        String henkanMaeKbnVal2 = "" ;

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(srKbnHenkanKbn, henkanMaeKbnVal1, henkanMaeKbnVal2);
        exStringEquals(srSuuriKbnHenkanBean.getKekkaKbn().toString(), "1", "結果区分");
        exStringEquals(srSuuriKbnHenkanBean.getSuuriKbnHenkanErrorKbn().toString(), "2", "数理用区分変換エラー区分");
        exStringEquals(srSuuriKbnHenkanBean.getHenkanAtoKbn(), "", "変換後区分値");
    }
}