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
 *  保険金給付金支払書類到着時工程操作処理クラスのメソッド {@link SiharaiSyoruitoutyakuOperateProcess#hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiSyoruitoutyakuOperateProcessTest_hanteiToutyakuProcessForwardSyoruiCd {

    @Inject
    private SiharaiSyoruitoutyakuOperateProcess siharaiSyoruitoutyakuOperateProcess;

    @Test
    @Transactional
    @TestOrder(10)
    public void testHanteiToutyakuProcessForwardSyoruiCd_A1() {
        boolean reflag = siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        exBooleanEquals(reflag, true, "判定結果");

        String syoruitoutyakuNodeId = siharaiSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId();
        exStringEquals(syoruitoutyakuNodeId, TeisuuSiharai.NODEID_SYORUITOUTYAKU, "書類到着ノードID");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testHanteiToutyakuProcessForwardSyoruiCd_A3() {
        boolean reflag = siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        exBooleanEquals(reflag, true, "判定結果");

        String syoruitoutyakuNodeId = siharaiSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId();
        exStringEquals(syoruitoutyakuNodeId, TeisuuSiharai.NODEID_SYORUITOUTYAKU, "書類到着ノードID");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testHanteiToutyakuProcessForwardSyoruiCd_A6() {
        boolean reflag = siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_SB_KAKUNINHKS);
        exBooleanEquals(reflag, true, "判定結果");

        String syoruitoutyakuNodeId = siharaiSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId();
        exStringEquals(syoruitoutyakuNodeId, TeisuuSiharai.NODEID_KAKUNINIRAITYUU, "書類到着ノードID");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testHanteiToutyakuProcessForwardSyoruiCd_A8() {
        boolean reflag = siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_SB_HUBITEISEI);
        exBooleanEquals(reflag, true, "判定結果");

        String syoruitoutyakuNodeId = siharaiSyoruitoutyakuOperateProcess.getSyoruitoutyakuNodeId();
        exStringEquals(syoruitoutyakuNodeId, TeisuuSiharai.NODEID_HUBIKAITOUMATI, "書類到着ノードID");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testHanteiToutyakuProcessForwardSyoruiCd_A10() {
        boolean reflag = siharaiSyoruitoutyakuOperateProcess.hanteiToutyakuProcessForwardSyoruiCd(C_SyoruiCdKbn.HK_ENKASIHARAIRYUUIJIKOU);
        exBooleanEquals(reflag, false, "判定結果");
    }
}
