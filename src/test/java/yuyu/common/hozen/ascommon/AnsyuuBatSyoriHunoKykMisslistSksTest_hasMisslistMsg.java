package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 案内収納用バッチ処理不能契約ミスリスト作成クラスのメソッド {@link AnsyuuBatSyoriHunoKykMisslistSks#hasMisslistMsg()}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuBatSyoriHunoKykMisslistSksTest_hasMisslistMsg {

    @Inject
    private AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks;

    @Test
    @TestOrder(10)
    public void testHasMisslistMsg_A1() {

        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg("17806000068", "ミスリストメッセージ", "ログメッセージ");

        exBooleanEquals(ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg(), true, "ミスリストメッセージ存在確認");
    }

    @Test
    @TestOrder(20)
    public void testHasMisslistMsg_A2() {

        exBooleanEquals(ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg(), false, "ミスリストメッセージ存在確認");
    }
}
