package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Bknkessankbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 備金決算区分設定クラスのメソッド {@link SetBikinKessanKbn#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetBikinKessanKbnTest_exec {

    @Inject
    private SetBikinKessanKbn setBikinKessanKbn;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(BizDate.valueOf("20190301"));
        exClassificationEquals(bknkessankbn, C_Bknkessankbn.KESSAN, "備金決算区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(BizDate.valueOf("20190601"));
        exClassificationEquals(bknkessankbn, C_Bknkessankbn.SHNK, "備金決算区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(BizDate.valueOf("20190901"));
        exClassificationEquals(bknkessankbn, C_Bknkessankbn.HNK, "備金決算区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(BizDate.valueOf("20191201"));
        exClassificationEquals(bknkessankbn, C_Bknkessankbn.SHNK, "備金決算区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(BizDate.valueOf("20190101"));
        exClassificationEquals(bknkessankbn, C_Bknkessankbn.BLNK, "備金決算区分");
    }
}
