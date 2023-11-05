package yuyu.common.biz.report;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 帳票表示用の住所編集のメソッド{@link ViewReport#editAdrDispeditAdrDisp(int pLength, String pAdr1, String pAdr2, String pAdr3)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ViewReportTest_editAdrDisp {

    @Test
    @TestOrder(10)
    public void testEditAdrDisp_A1() {
        int pLength = 0;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = "Ｂ２３４５６７８９０１２３４５６７８９０";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "Ｂ２３４５６７８９０１２３４５６７８９０", "住所２");
        exStringEquals(result[2], "Ｃ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(20)
    public void testEditAdrDisp_A2() {
        int pLength = 1;
        String pAdr1 = "１２３";
        String pAdr2 = "ＡＢＣ";
        String pAdr3 = "住所";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "１", "住所１");
        exStringEquals(result[1], "２", "住所２");
        exStringEquals(result[2], "３", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(30)
    public void testEditAdrDisp_A3() {
        int pLength = 20;
        String pAdr1 = null;
        String pAdr2 = null;
        String pAdr3 = null;

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], null, "住所１");
        exStringEquals(result[1], null, "住所２");
        exStringEquals(result[2], null, "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(40)
    public void testEditAdrDisp_A4() {
        int pLength = 20;
        String pAdr1 = "";
        String pAdr2 = "";
        String pAdr3 = "";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "", "住所１");
        exStringEquals(result[1], "", "住所２");
        exStringEquals(result[2], "", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(50)
    public void testEditAdrDisp_A5() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = "Ｂ２３４５６７８９０１２３４５６７８９０";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "Ｂ２３４５６７８９０１２３４５６７８９０", "住所２");
        exStringEquals(result[2], "Ｃ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(60)
    public void testEditAdrDisp_A6() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０１";
        String pAdr2 = "Ｂ２３４５６７８９０１２３４５６７８９０";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "１Ｂ２３４５６７８９０１２３４５６７８９", "住所２");
        exStringEquals(result[2], "０Ｃ２３４５６７８９０１２３４５６７８９", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(70)
    public void testEditAdrDisp_A7() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０";
        String pAdr2 = "Ｂ２３４５６７８９０１２３４５６７８９０１";
        String pAdr3 = "Ｃ２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０Ｂ２３４５６７８９０", "住所１");
        exStringEquals(result[1], "１２３４５６７８９０１Ｃ２３４５６７８９", "住所２");
        exStringEquals(result[2], "０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(80)
    public void testEditAdrDisp_A8() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０";
        String pAdr2 = "Ｂ２３４５６７８９０";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０１";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０Ｂ２３４５６７８９０", "住所１");
        exStringEquals(result[1], "Ｃ２３４５６７８９０１２３４５６７８９０", "住所２");
        exStringEquals(result[2], "１", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(90)
    public void testEditAdrDisp_A9() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０１";
        String pAdr2 = null;
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０１";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "１Ｃ２３４５６７８９０１２３４５６７８９", "住所２");
        exStringEquals(result[2], "０１", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(100)
    public void testEditAdrDisp_A10() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０１";
        String pAdr2 = "";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０１";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "１Ｃ２３４５６７８９０１２３４５６７８９", "住所２");
        exStringEquals(result[2], "０１", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(110)
    public void testEditAdrDisp_A11() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = null;
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], null, "住所２");
        exStringEquals(result[2], "Ｃ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(120)
    public void testEditAdrDisp_A12() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = "";
        String pAdr3 = "Ｃ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "", "住所２");
        exStringEquals(result[2], "Ｃ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(130)
    public void testEditAdrDisp_A13() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = "";
        String pAdr3 = "";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], "", "住所２");
        exStringEquals(result[2], "", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(140)
    public void testEditAdrDisp_A14() {
        int pLength = 20;
        String pAdr1 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr2 = null;
        String pAdr3 = null;

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "Ａ２３４５６７８９０１２３４５６７８９０", "住所１");
        exStringEquals(result[1], null, "住所２");
        exStringEquals(result[2], null, "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(150)
    public void testEditAdrDisp_A15() {
        int pLength = 20;
        String pAdr1 = "";
        String pAdr2 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr3 = "";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "", "住所１");
        exStringEquals(result[1], "Ａ２３４５６７８９０１２３４５６７８９０", "住所２");
        exStringEquals(result[2], "", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(160)
    public void testEditAdrDisp_A16() {
        int pLength = 20;
        String pAdr1 = null;
        String pAdr2 = "Ａ２３４５６７８９０１２３４５６７８９０";
        String pAdr3 = null;

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], null, "住所１");
        exStringEquals(result[1], "Ａ２３４５６７８９０１２３４５６７８９０", "住所２");
        exStringEquals(result[2], null, "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(170)
    public void testEditAdrDisp_A17() {
        int pLength = 20;
        String pAdr1 = "";
        String pAdr2 = "";
        String pAdr3 = "Ａ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], "", "住所１");
        exStringEquals(result[1], "", "住所２");
        exStringEquals(result[2], "Ａ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }

    @Test
    @TestOrder(180)
    public void testEditAdrDisp_A18() {
        int pLength = 20;
        String pAdr1 = null;
        String pAdr2 = null;
        String pAdr3 = "Ａ２３４５６７８９０１２３４５６７８９０";

        String[] result = ViewReport.editAdrDisp(pLength, pAdr1, pAdr2, pAdr3);

        exStringEquals(result[0], null, "住所１");
        exStringEquals(result[1], null, "住所２");
        exStringEquals(result[2], "Ａ２３４５６７８９０１２３４５６７８９０", "住所３");
        exNumericEquals(result.length, 3, "配列の長さ");
    }
}
