package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払額Bean
 */
public class SiharaigakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_Kanjyoukmkcd kanjyouKmkCd;

    private BizCurrency siharaiGk;

    private BizCurrency keiyakuGk;

    public SiharaigakuBean() {
        kanjyouKmkCd = C_Kanjyoukmkcd.BLNK;
        siharaiGk = BizCurrency.valueOf(0);
        keiyakuGk = BizCurrency.valueOf(0);
    }

    public C_Kanjyoukmkcd getKanjyouKmkCd() {
        return kanjyouKmkCd;
    }

    public void setKanjyouKmkCd(C_Kanjyoukmkcd pKanjyouKmkCd) {
        kanjyouKmkCd = pKanjyouKmkCd;
    }

    public BizCurrency getSiharaiGk() {
        return siharaiGk;
    }

    public void setSiharaiGk(BizCurrency pSiharaiGk) {
        siharaiGk = pSiharaiGk;
    }

    public BizCurrency getKeiyakuGk() {
        return keiyakuGk;
    }

    public void setKeiyakuGk(BizCurrency pKeiyakuGk) {
        keiyakuGk = pKeiyakuGk;
    }
}
