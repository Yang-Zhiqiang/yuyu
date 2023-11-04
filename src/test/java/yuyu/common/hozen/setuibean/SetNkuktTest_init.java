package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UktKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金受取人情報設定クラスのメソッド {@link SetNkukt#init(SetNkuktExecUiBeanParamImpl)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetNkuktTest_init {

    private SetNkuktExecUiBeanParamImpl setNkuktExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setNkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetNkuktExecUiBeanParamImpl.class);

        SetNkukt.init(setNkuktExecUiBeanParamImpl);

        exClassificationEquals(setNkuktExecUiBeanParamImpl.getVnkuknenkinuktkbn(), C_UktKbn.BLNK, "（年金受取人情報）年金受取人区分");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setNkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetNkuktExecUiBeanParamImpl.class);

        setNkuktExecUiBeanParamImpl.setVnkuknenkinuktkbn(C_UktKbn.HHKN);

        SetNkukt.init(setNkuktExecUiBeanParamImpl);

        exClassificationEquals(setNkuktExecUiBeanParamImpl.getVnkuknenkinuktkbn(), C_UktKbn.BLNK, "（年金受取人情報）年金受取人区分");

        MockObjectManager.initialize();
    }
}
