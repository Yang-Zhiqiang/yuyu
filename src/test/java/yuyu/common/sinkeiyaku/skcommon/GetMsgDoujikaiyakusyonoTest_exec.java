package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 同時解約証券番号ＭＳＧ取得クラスのメソッド {@link GetMsgDoujikaiyakusyono#exec(C_UmuKbn, String)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class GetMsgDoujikaiyakusyonoTest_exec {

    private final static String syoNo1 = "10000000001";

    private final static String syoNo2 = "10000000002";

    @Inject
    private GetMsgDoujikaiyakusyono getMsgDoujikaiyakusyono;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        int result = getMsgDoujikaiyakusyono.exec(C_UmuKbn.ARI, syoNo1);

        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsg(), "商品切替の申込です。（同時解約証券番号：10000000001）", "画面メッセージ");
        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsgid(), "WHC0081", "画面メッセージID");
        exNumericEquals(result, 1, "結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        int result = getMsgDoujikaiyakusyono.exec(C_UmuKbn.NONE, syoNo2);

        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsgid(), "", "画面メッセージID");
        exNumericEquals(result, 0, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        int result = getMsgDoujikaiyakusyono.exec(C_UmuKbn.ARI, "");

        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgDoujikaiyakusyono.getS_gmmsgid(), "", "画面メッセージID");
        exNumericEquals(result, 0, "結果区分");
    }
}
