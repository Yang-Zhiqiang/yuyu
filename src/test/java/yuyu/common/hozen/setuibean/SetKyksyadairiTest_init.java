package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;

import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.testinfr.TestOrder;

/**
 * 契約者代理人情報設定のメソッド{@link SetKyksyadairi#init(SetKyksyadairiExecUiBeanParam)}
                                   テスト用クラスです。<br />
 */
public class SetKyksyadairiTest_init {

    private SetKyksyadairiExecUiBeanParamImpl setKyksyadairiExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setKyksyadairiExecUiBeanParamImpl = SWAKInjector.getInstance(SetKyksyadairiExecUiBeanParamImpl.class);

        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdrkbn(C_UktKbn.STDRNIN);
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdrnmkn("アイウエオ");
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdrnmkj("あいうえお");
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdrnmkjkhukakbn( C_KjkhukaKbn.KJKHUKA);
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdrseiymd(BizDate.valueOf("20191016"));
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdryno("1003124");
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdradr1kj("とうきょう");
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdradr2kj("おおさか");
        setKyksyadairiExecUiBeanParamImpl.setVkykdrkykdradr3kj("なごや");

        SetKyksyadairi.init(setKyksyadairiExecUiBeanParamImpl);

        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrkbn(), C_UktKbn.BLNK,
            "（契約者代理人情報）契約者代理人区分");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkn(), "",
            "（契約者代理人情報）契約者代理人名（カナ）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkj(), "",
            "（契約者代理人情報）契約者代理人名（漢字）");
        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkjkhukakbn(), C_KjkhukaKbn.BLNK,
            "（契約者代理人情報）契約者代理人名漢字化不可区分");
        exDateEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrseiymd(), null,
            "（契約者代理人情報）契約者代理人生年月日");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdryno(), "",
            "（契約者代理人情報）契約者代理人郵便番号");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr1kj(), "",
            "（契約者代理人情報）契約者代理人住所１（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr2kj(), "",
            "（契約者代理人情報）契約者代理人住所２（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr3kj(), "",
            "（契約者代理人情報）契約者代理人住所３（漢字）");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {

        setKyksyadairiExecUiBeanParamImpl = SWAKInjector.getInstance(SetKyksyadairiExecUiBeanParamImpl.class);

        SetKyksyadairi.init(setKyksyadairiExecUiBeanParamImpl);

        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrkbn(), C_UktKbn.BLNK,
            "（契約者代理人情報）契約者代理人区分");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkn(), "",
            "（契約者代理人情報）契約者代理人名（カナ）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkj(), "",
            "（契約者代理人情報）契約者代理人名（漢字）");
        exClassificationEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrnmkjkhukakbn(), C_KjkhukaKbn.BLNK,
            "（契約者代理人情報）契約者代理人名漢字化不可区分");
        exDateEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdrseiymd(), null,
            "（契約者代理人情報）契約者代理人生年月日");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdryno(), "",
            "（契約者代理人情報）契約者代理人郵便番号");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr1kj(), "",
            "（契約者代理人情報）契約者代理人住所１（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr2kj(), "",
            "（契約者代理人情報）契約者代理人住所２（漢字）");
        exStringEquals(setKyksyadairiExecUiBeanParamImpl.getVkykdrkykdradr3kj(), "",
            "（契約者代理人情報）契約者代理人住所３（漢字）");

        MockObjectManager.initialize();
    }
}
