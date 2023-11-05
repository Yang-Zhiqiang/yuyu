package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.TestOrder;

/**
 * 相手申込番号ワーニングＭＳＧ取得クラスのメソッド {@link GetMsgAitemosno#exec(C_UmuKbn ,String)} テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetMsgAitemosnoTest_exec_CUKbn_mosno {

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        exNumericEquals(getMsgAitemosno.exec(C_UmuKbn.ARI, "A01"), 1, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "セット販売の申込です。（相手申込番号：A01）", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "WHA1004", "画面メッセージID");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        exNumericEquals(getMsgAitemosno.exec(C_UmuKbn.ARI, ""), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        exNumericEquals(getMsgAitemosno.exec(C_UmuKbn.NONE, "A01"), 0, "結果区分");

        exStringEquals(getMsgAitemosno.getS_gmmsg(), "", "画面メッセージ");
        exStringEquals(getMsgAitemosno.getS_gmmsgid(), "", "画面メッセージID");
    }
}
