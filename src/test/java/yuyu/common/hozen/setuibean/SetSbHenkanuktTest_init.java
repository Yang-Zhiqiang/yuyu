package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.exClassificationEquals;
import static yuyu.testinfr.YuyuFunctionTestUtil.exDateEquals;
import static yuyu.testinfr.YuyuFunctionTestUtil.exStringEquals;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 死亡返還金受取人情報設定のメソッド {@link SetSbHenkanukt#init(SetSbHenkanuktExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSbHenkanuktTest_init {

    @Inject
    private SetSbHenkanuktExecUiBeanParamImpl setSbHenkanuktExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setSbHenkanuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHenkanuktExecUiBeanParamImpl.class);

        SetSbHenkanukt.init(setSbHenkanuktExecUiBeanParamImpl);

        exStringEquals(setSbHenkanuktExecUiBeanParamImpl.getSbhenkanuktnmkn(), "", "死亡返還金受取人氏名（カナ）");
        exStringEquals(setSbHenkanuktExecUiBeanParamImpl.getSbhenkanuktnmkj(), "", "死亡返還金受取人氏名（漢字）");
        exDateEquals(setSbHenkanuktExecUiBeanParamImpl.getSibouhenkankinuktseiymd(), null, "死亡返還金受取人生年月日");
        exClassificationEquals(setSbHenkanuktExecUiBeanParamImpl.getSibouhenkankinukttdk(), C_Tdk.BLNK, "死亡返還金受取人続柄");

        MockObjectManager.initialize();
    }
}
