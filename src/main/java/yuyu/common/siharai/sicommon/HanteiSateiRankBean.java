package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定ランク判定Bean
 */
public class HanteiSateiRankBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private C_SateiYouhiKbn sateiYouhiKbn;

    private C_SKNaiyouChkkekkaKbn sKNaiyouChkkekkaKbn;

    private C_SaisateiKbn saisateikbn;

    public HanteiSateiRankBean() {
        super();
    }

    public String getSyono() {
        return syoNo;
    }

    public void setSyono(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public C_SateiYouhiKbn getSateiYouhiKbn() {
        return sateiYouhiKbn;
    }

    public void setSateiYouhiKbn(C_SateiYouhiKbn pSateiYouhiKbn) {
        sateiYouhiKbn = pSateiYouhiKbn;
    }

    public C_SKNaiyouChkkekkaKbn getSKNaiyouChkkekkaKbn() {
        return sKNaiyouChkkekkaKbn;
    }

    public void setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn pSKNaiyouChkkekkaKbn) {
        sKNaiyouChkkekkaKbn = pSKNaiyouChkkekkaKbn;
    }

    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;
    }
}
