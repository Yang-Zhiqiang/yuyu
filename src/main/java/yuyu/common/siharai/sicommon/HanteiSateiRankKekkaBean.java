package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定ランク判定結果Bean
 */
public class HanteiSateiRankKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean sateiRankuHanteiKekka;

    private C_SateiYouhiKbn sateiYouhiKbn;

    private C_UmuKbn sateiSanjikaisouUmuKbn;

    public HanteiSateiRankKekkaBean() {
        super();
    }

    public boolean getSateiRankuHanteiKekka() {
        return sateiRankuHanteiKekka;
    }

    public void setSateiRankuHanteiKekka(boolean pSateiRankuHanteiKekka) {
        sateiRankuHanteiKekka = pSateiRankuHanteiKekka;
    }

    public C_SateiYouhiKbn getSateiYouhiKbn() {
        return sateiYouhiKbn;
    }

    public void setSateiYouhiKbn(C_SateiYouhiKbn pSateiYouhiKbn) {
        sateiYouhiKbn = pSateiYouhiKbn;
    }

    public C_UmuKbn getSateiSanjikaisouUmuKbn() {
        return sateiSanjikaisouUmuKbn;
    }

    public void setSateiSanjikaisouUmuKbn(C_UmuKbn pSateiSanjikaisouUmuKbn) {
        sateiSanjikaisouUmuKbn = pSateiSanjikaisouUmuKbn;
    }

}
