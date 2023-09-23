package yuyu.common.siharai.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 工程 支払分岐条件Bean
 */
public class SiRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyorikekkaKbn syoriKekkaKbn;

    private C_SateiYouhiKbn sateiYhKbn;

    private C_YouhiblnkKbn sessyouYhKbn;

    private C_UmuKbn sateiSanjiKaisouUmuKbn;

    private C_SikinouModeIdKbn hubiModorijiSenisakiNodeNm;

    public SiRuleBean() {
        super();
        init();
    }

    public C_SyorikekkaKbn getSyoriKekkaKbn() {
        return syoriKekkaKbn;
    }

    public void setSyoriKekkaKbn(C_SyorikekkaKbn pSyoriKekkaKbn) {
        this.syoriKekkaKbn = pSyoriKekkaKbn;
    }

    public C_SateiYouhiKbn getSateiYhKbn() {
        return sateiYhKbn;
    }

    public void setSateiYhKbn(C_SateiYouhiKbn pSateiYhKbn) {
        this.sateiYhKbn = pSateiYhKbn;
    }

    public C_YouhiblnkKbn getSessyouYhKbn() {
        return sessyouYhKbn;
    }

    public void setSessyouYhKbn(C_YouhiblnkKbn pSessyouYhKbn) {
        this.sessyouYhKbn = pSessyouYhKbn;
    }

    public C_UmuKbn getSateiSanjiKaisouUmuKbn() {
        return sateiSanjiKaisouUmuKbn;
    }

    public void setSateiSanjiKaisouUmuKbn(C_UmuKbn pSateiSanjiKaisouUmuKbn) {
        this.sateiSanjiKaisouUmuKbn = pSateiSanjiKaisouUmuKbn;
    }

    public C_SikinouModeIdKbn getHubiModorijiSenisakiNodeNm() {
        return hubiModorijiSenisakiNodeNm;
    }

    public void setHubiModorijiSenisakiNodeNm(C_SikinouModeIdKbn pHubiModorijiSenisakiNodeNm) {
        this.hubiModorijiSenisakiNodeNm = pHubiModorijiSenisakiNodeNm;
    }

    public void init() {
        syoriKekkaKbn = C_SyorikekkaKbn.BLNK;
        sateiYhKbn = C_SateiYouhiKbn.BLNK;
        sessyouYhKbn = C_YouhiblnkKbn.BLNK;
        sateiSanjiKaisouUmuKbn = C_UmuKbn.NONE;
        hubiModorijiSenisakiNodeNm = C_SikinouModeIdKbn.DEFAULT;
    }
}
