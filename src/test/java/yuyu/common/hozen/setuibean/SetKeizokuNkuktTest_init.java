package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 継続年金受取人情報設定のメソッド {@link SetKeizokuNkukt#init(SetKeizokuNkuktExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetKeizokuNkuktTest_init {

    @Inject
    private SetKeizokuNkuktExecUiBeanParamImpl setKeizokuNkuktExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setKeizokuNkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetKeizokuNkuktExecUiBeanParamImpl.class);

        SetKeizokuNkukt.init(setKeizokuNkuktExecUiBeanParamImpl);

        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkn(), "", "継続年金受取人氏名（カナ）");
        exStringEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknkuktnmkj(), "", "継続年金受取人氏名（漢字）");
        exDateEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkiuktseiymd(), null, "継続年金受取人生年月日");
        exClassificationEquals(setKeizokuNkuktExecUiBeanParamImpl.getKeizknenkinukttdk(), C_Tdk.BLNK, "継続年金受取人続柄");

        MockObjectManager.initialize();
    }
}
