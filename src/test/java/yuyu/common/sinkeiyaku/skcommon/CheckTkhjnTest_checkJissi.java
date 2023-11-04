package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定関係法人チェックのメソッド {@link CheckTkhjn#checkJitusi(List<String>, List<String>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTkhjnTest_checkJissi {

    @Inject
    private CheckTkhjn checkTkhjn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testCheckJissi_A1() {
        List<String> hjnnmLst = new ArrayList<>();
        hjnnmLst.add("株式会社アイウ");
        List<String> checkTaisyouLs = new ArrayList<>();
        checkTaisyouLs.add("ＡＢＣＤ");

        C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(hjnnmLst, checkTaisyouLs);

        exClassificationEquals(youhiKbn, C_YouhiKbn.HUYOU, "要否区分");

    }

    @Test
    @TestOrder(20)
    public void testCheckJissi_A2() {
        List<String> hjnnmLst = new ArrayList<>();
        hjnnmLst.add("株式会社アイウ");
        hjnnmLst.add("株式会社ＡＢＣ");
        hjnnmLst.add("株式会社エイビーシー");
        List<String> checkTaisyouLs = new ArrayList<>();
        checkTaisyouLs.add("エＡＢＣＤ");
        checkTaisyouLs.add("エイビーシーディー");
        checkTaisyouLs.add("エービィシィデー");

        C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(hjnnmLst, checkTaisyouLs);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "要否区分");

    }

    @Test
    @TestOrder(30)
    public void testCheckJissi_A3() {
        List<String> hjnnmLst = new ArrayList<>();
        hjnnmLst.add("株式会社エイビデー");
        List<String> checkTaisyouLs = new ArrayList<>();
        checkTaisyouLs.add("株式エイビデー");

        C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(hjnnmLst, checkTaisyouLs);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "要否区分");

    }

    @Test
    @TestOrder(40)
    public void testCheckJissi_A4() {
        List<String> hjnnmLst = new ArrayList<>();
        hjnnmLst.add("株式会社エイビーシー");
        List<String> checkTaisyouLs = new ArrayList<>();
        checkTaisyouLs.add("会社エイ");

        C_YouhiKbn youhiKbn = checkTkhjn.checkJissi(hjnnmLst, checkTaisyouLs);

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "要否区分");

    }

}
