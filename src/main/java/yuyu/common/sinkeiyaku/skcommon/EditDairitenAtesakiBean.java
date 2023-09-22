package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosDairiten;

/**
 * 新契約 新契約共通 代理店宛先編集Bean
 */
public class EditDairitenAtesakiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_SyoruiCdKbn syoruiCdKbn;

    private HT_MosDairiten mosDairiten;

    private BizDate hassouYmd;

    private C_SeirituKbn seirituKbn;

    private C_Ketkekkacd ketkekkaCd;

    private C_SkeijimuKbn skeijimuKbn;

    public C_SyoruiCdKbn getSyoruiCdKbn() {
        return syoruiCdKbn;
    }

    public void setSyoruiCdKbn(C_SyoruiCdKbn pSyoruiCdKbn) {
        this.syoruiCdKbn = pSyoruiCdKbn;
    }

    public HT_MosDairiten getMosDairiten() {
        return mosDairiten;
    }

    public void setMosDairiten(HT_MosDairiten pMosDairiten) {
        this.mosDairiten = pMosDairiten;
    }

    public BizDate getHassouYmd() {
        return hassouYmd;
    }

    public void setHassouYmd(BizDate pHassouYmd) {
        this.hassouYmd = pHassouYmd;
    }

    public C_SeirituKbn getSeirituKbn() {
        return seirituKbn;
    }

    public void setSeirituKbn(C_SeirituKbn pSeirituKbn) {
        this.seirituKbn = pSeirituKbn;
    }

    public C_Ketkekkacd getKetkekkaCd() {
        return ketkekkaCd;
    }

    public void setKetkekkaCd(C_Ketkekkacd pKetkekkaCd) {
        this.ketkekkaCd = pKetkekkaCd;
    }

    public C_SkeijimuKbn getSkeijimuKbn() {
        return skeijimuKbn;
    }

    public void setSkeijimuKbn(C_SkeijimuKbn pSkeijimuKbn) {
        this.skeijimuKbn = pSkeijimuKbn;
    }

}
