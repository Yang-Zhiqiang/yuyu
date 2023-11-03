package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 必要書類設定クラスのメソッド {@link SetHituyouSyorui#exec(KhozenCommonParam,SetHituyouSyoruiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHituyouSyoruiTest_init {

    private SetHituyouSyoruiExecUiBeanParamImpl setHituyouSyoruiExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setHituyouSyoruiExecUiBeanParamImpl = SWAKInjector.getInstance(SetHituyouSyoruiExecUiBeanParamImpl.class);


        SetHituyouSyorui.init(setHituyouSyoruiExecUiBeanParamImpl);

        exStringEquals(setHituyouSyoruiExecUiBeanParamImpl.getVhtysdisphtysyorui(), "", "（必要書類情報）必要書類メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setHituyouSyoruiExecUiBeanParamImpl = SWAKInjector.getInstance(SetHituyouSyoruiExecUiBeanParamImpl.class);

        setHituyouSyoruiExecUiBeanParamImpl.setVhtysdisphtysyorui("1234567");


        SetHituyouSyorui.init(setHituyouSyoruiExecUiBeanParamImpl);

        exStringEquals(setHituyouSyoruiExecUiBeanParamImpl.getVhtysdisphtysyorui(), "", "（必要書類情報）必要書類メッセージ");

        MockObjectManager.initialize();
    }
}
