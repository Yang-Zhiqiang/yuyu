package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ環境依存文字変換ユーティリティクラスのメソッド {@link DsKankyouizonmojiHenkanUtil#henkanRomesuuji(String} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsKankyouizonmojiHenkanUtilTest_henkanRomesuuji {

    @Inject
    private DsKankyouizonmojiHenkanUtil dsKankyouizonmojiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testHenkanRomesuuji_A1() {

        String henkanStr = "ああ12Ⅱ34";

        String afterStr = dsKankyouizonmojiHenkanUtil.henkanRomesuuji(henkanStr);

        exStringEquals(afterStr,"ああ12II34","変換後文字列");
    }

    @Test
    @TestOrder(20)
    public void testHenkanRomesuuji_A2() {

        String henkanStr = "ああ12Ⅲ34";

        String afterStr = dsKankyouizonmojiHenkanUtil.henkanRomesuuji(henkanStr);

        exStringEquals(afterStr,"ああ12Ⅲ34","変換後文字列");
    }

    @Test
    @TestOrder(30)
    public void testHenkanRomesuuji_A3() {

        String henkanStr = "Ⅱああ12Ⅱ34";

        String afterStr = dsKankyouizonmojiHenkanUtil.henkanRomesuuji(henkanStr);

        exStringEquals(afterStr,"IIああ12II34","変換後文字列");
    }
}
