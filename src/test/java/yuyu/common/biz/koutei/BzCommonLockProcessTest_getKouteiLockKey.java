package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 工程ロック共通処理クラスのメソッド {@link BzCommonLockProcess#getKouteiLockKey()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzCommonLockProcessTest_getKouteiLockKey {

    @Test
    @TestOrder(10)
    public void testGetKouteiLockKey_A1() {
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        String string = bzCommonLockProcess.getKouteiLockKey();
        exStringEquals(string, "", "工程ロックキー");
    }
}
