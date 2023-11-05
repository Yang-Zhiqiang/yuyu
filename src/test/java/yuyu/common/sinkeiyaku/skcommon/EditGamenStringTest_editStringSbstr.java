package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 画面用文字列編集のメソッド {@link editStringSbstr#editStringSbstr(String,int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditGamenStringTest_editStringSbstr {

    EditGamenString editGamenString = SWAKInjector.getInstance(EditGamenString.class);

    @Test
    @TestOrder(10)
    public void testEditStringSbstr_A1() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr(null,1);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }

    @Test
    @TestOrder(20)
    public void testEditStringSbstr_A2() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("A",1);

        exStringEquals(henkougoWkMojiretu, "A", "編集用文字列");
    }

    @Test
    @TestOrder(30)
    public void testEditStringSbstr_A3() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("Ab\nc",3);

        exStringEquals(henkougoWkMojiretu, "Ab…", "編集用文字列");
    }


    @Test
    @TestOrder(40)
    public void testEditStringSbstr_A4() {

        String henkougoWkMojiretu = editGamenString.editStringSbstr("Ab\nc",4);

        exStringEquals(henkougoWkMojiretu, "Ab c", "編集用文字列");
    }


    @Test
    @TestOrder(50)
    public void testEditStringSbstr_A5() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("Ab\nc",5);

        exStringEquals(henkougoWkMojiretu, "Ab c", "編集用文字列");
    }

    @Test
    @TestOrder(60)
    public void testEditStringSbstr_A6() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("A",0);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }

    @Test
    @TestOrder(70)
    public void testEditStringSbstr_A7() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("Abc",2);

        exStringEquals(henkougoWkMojiretu, "A…", "編集用文字列");
    }

    @Test
    @TestOrder(80)
    public void testEditStringSbstr_A8() {
        String henkougoWkMojiretu = EditGamenString.editStringSbstr("A",-1);

        exStringEquals(henkougoWkMojiretu, "", "編集用文字列");
    }
}
