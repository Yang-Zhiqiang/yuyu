package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特条保険金削減内容計算クラスのメソッド {@link TokujoSSakugenNaiyouKeisan#exec()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TokujoSSakugenNaiyouKeisanTest_exec {

    @Inject
    private TokujoSSakugenNaiyouKeisan tokujoSSakugenNaiyouKeisan;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        C_ErrorKbn errorKbn = tokujoSSakugenNaiyouKeisan.exec();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        MockObjectManager.initialize();
    }
}
