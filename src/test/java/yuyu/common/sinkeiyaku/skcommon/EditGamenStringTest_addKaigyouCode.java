package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 画面用文字列編集のメソッド {@link EditGamenString#editStringSbstr(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditGamenStringTest_addKaigyouCode {

    @Test
    @TestOrder(10)
    public void testAddKaigyouCode_A1() {
        String henkougoWkMojiretu = EditGamenString.addKaigyouCode(null);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }

    @Test
    @TestOrder(20)
    public void testAddKaigyouCode_A2() {
        String henkougoWkMojiretu = EditGamenString.addKaigyouCode("");

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }

    @Test
    @TestOrder(30)
    public void testAddKaigyouCode_A3() {
        String henkougoWkMojiretu = EditGamenString.addKaigyouCode("対象文字列");

        exStringEquals(henkougoWkMojiretu, "対象文字列\n", "編集用文字列");
    }
}
