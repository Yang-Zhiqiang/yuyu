package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.MessageId;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ文言作成クラスのメソッドテスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MakeHubiMsgTest_exec {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String ret = MakeHubiMsg.exec(MessageId.ISA1001, MessageId.ISA1001, "処理コントロールテーブル", "001");
        exStringEquals(ret, "ISA1001 テーブル名＝処理コントロールテーブル　更新件数：001件", "メッセージ文言");
    }

}
