package yuyu.common.hozen.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全書類到着時工程操作処理クラスのメソッド {@link HozenSyoruitoutyakuOperateProcess#getSyoruitoutyakuNodeId()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HozenSyoruitoutyakuOperateProcessTest_getSyoruitoutyakuNodeId {

    @Test
    @TestOrder(10)
    public void testGetSyoruitoutyakuNodeId_A1() {

        HozenSyoruitoutyakuOperateProcess hozenSyoruitoutyakuOperateProcess =  SWAKInjector.getInstance(HozenSyoruitoutyakuOperateProcess.class);

        hozenSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.KK_SYOSAIHK_SKS);

        exStringEquals(hozenSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId(),"state-syoruitoutyaku","書類到着ノードID");

        MockObjectManager.initialize();

    }
}
