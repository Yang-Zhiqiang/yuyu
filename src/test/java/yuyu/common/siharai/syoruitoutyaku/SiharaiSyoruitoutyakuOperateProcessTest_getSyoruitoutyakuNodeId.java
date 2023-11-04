package yuyu.common.siharai.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払書類到着時工程操作処理クラスのメソッド {@link SiharaiSyoruitoutyakuOperateProcess#getSyoruitoutyakuNodeId()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiSyoruitoutyakuOperateProcessTest_getSyoruitoutyakuNodeId {

    @Inject
    private SiharaiSyoruitoutyakuOperateProcess siharaiSyoruitoutyakuOperateProcess;

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetSyoruitoutyakuNodeId_A1() {

        siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        String syoruitoutyakuNodeId = siharaiSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId();
        exStringEquals(syoruitoutyakuNodeId, TeisuuSiharai.NODEID_SYORUITOUTYAKU, "書類到着ノードID");
    }

}
