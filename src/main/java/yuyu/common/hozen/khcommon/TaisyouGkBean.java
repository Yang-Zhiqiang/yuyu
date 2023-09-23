package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_Segcd;

/**
 * 契約保全 契約保全共通 対象金額Bean
 */
public class TaisyouGkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KhDengkSyuruiKbn khDengkSyuruiKbn;

    private BizCurrency taisyouGk;

    private BizCurrency keiyakutuukaGk;

    private C_Segcd seg1cd;

    private C_Segcd seg2cd;

    public C_KhDengkSyuruiKbn getKhDengkSyuruiKbn() {
        return khDengkSyuruiKbn;
    }

    public void setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn pKhDengkSyuruiKbn) {
        khDengkSyuruiKbn = pKhDengkSyuruiKbn;
    }

    public BizCurrency getTaisyouGk() {
        return taisyouGk;
    }

    public void setTaisyouGk(BizCurrency pTaisyouGk) {
        taisyouGk = pTaisyouGk;
    }

    public BizCurrency getKeiyakutuukaGk() {
        return keiyakutuukaGk;
    }

    public void setKeiyakutuukaGk(BizCurrency pKeiyakutuukaGk) {
        keiyakutuukaGk = pKeiyakutuukaGk;
    }

    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        this.seg1cd = pSeg1cd;
    }

    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        this.seg2cd = pSeg2cd;
    }
}
