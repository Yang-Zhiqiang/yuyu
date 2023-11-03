package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * その他特約特則設定クラスのメソッド {@link SetSonotaTk#init(SetSonotaTkExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSonotaTkTest_init {

    private SetSonotaTkExecUiBeanParamImpl setSonotaTkExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setSonotaTkExecUiBeanParamImpl = SWAKInjector.getInstance(SetSonotaTkExecUiBeanParamImpl.class);

        SetSonotaTk.init(setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "", "（表示用）特約付加情報");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setSonotaTkExecUiBeanParamImpl = SWAKInjector.getInstance(SetSonotaTkExecUiBeanParamImpl.class);

        setSonotaTkExecUiBeanParamImpl.setVsntkdisptkhukainfo("円入金特約");


        SetSonotaTk.init(setSonotaTkExecUiBeanParamImpl);

        exStringEquals(setSonotaTkExecUiBeanParamImpl.getVsntkdisptkhukainfo(), "", "（表示用）特約付加情報");

        MockObjectManager.initialize();
    }
}
