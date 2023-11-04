package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getHknsyuNoKeyToAisyou(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getHknsyuNoKeyToAisyou {

    @Inject
    private SyouhinUtil syouhinUtil;

    @Test
    @TestOrder(10)
    public void testGetHknsyuNoKeyToAisyou_M1() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾄ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "33102", "保険種類番号別キー１");

    }

    @Test
    @TestOrder(20)
    public void testGetHknsyuNoKeyToAisyou_M2() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾈ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "33102", "保険種類番号別キー１");

    }

    @Test
    @TestOrder(30)
    public void testGetHknsyuNoKeyToAisyou_M3() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾁ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "33101", "保険種類番号別キー１");

    }

    @Test
    @TestOrder(40)
    public void testGetHknsyuNoKeyToAisyou_M4() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕｱ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "", "保険種類番号別キー１");

    }

    @Test
    @TestOrder(50)
    public void testGetHknsyuNoKeyToAisyou_M5() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾍ", C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);
        exStringEquals(hokenSyuruiBangoBetuKey1, "", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(60)
    public void testGetHknsyuNoKeyToAisyou_M6() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾑ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(70)
    public void testGetHknsyuNoKeyToAisyou_M7() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾒ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(80)
    public void testGetHknsyuNoKeyToAisyou_M8() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾓ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(90)
    public void testGetHknsyuNoKeyToAisyou_M9() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾔ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(100)
    public void testGetHknsyuNoKeyToAisyou_M10() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾙ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(110)
    public void testGetHknsyuNoKeyToAisyou_M11() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾚ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(120)
    public void testGetHknsyuNoKeyToAisyou_M12() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾛ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(130)
    public void testGetHknsyuNoKeyToAisyou_M13() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾜ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32502", "保険種類番号別キー１");
    }

    @Test
    @TestOrder(140)
    public void testGetHknsyuNoKeyToAisyou_M14() {

        String hokenSyuruiBangoBetuKey1  = syouhinUtil.getHknsyuNoKeyToAisyou("ﾕﾍ", C_HknsyuruiNo.BLNK);
        exStringEquals(hokenSyuruiBangoBetuKey1, "32501", "保険種類番号別キー１");
    }
}
