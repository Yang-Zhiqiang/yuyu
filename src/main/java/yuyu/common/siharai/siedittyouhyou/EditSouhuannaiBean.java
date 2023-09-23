package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払帳票編集 送付案内編集Bean
 */
public class EditSouhuannaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean;

    private SeikyuusyaInfoBean seikyuusyaInfoBean;

    private ToiawaseInfoBean toiawaseInfoBean;

    private String syono;

    private C_SeikyuuSyubetu seikyuuSyubetu;

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    private C_HknKknKbn hknkknkbn;

    private boolean jisatuMenseki;

    private C_Tuukasyu kykTuukasyu;

    private C_UmuKbn mynumbertksUmuKbn;

    public EditSouhuannaiBean() {
        super();
    }

    public SiTyouhyouHensyuuCommonBean getSiTyouhyouHensyuuCommonBean() {
        return siTyouhyouHensyuuCommonBean;
    }

    public void setSiTyouhyouHensyuuCommonBean(SiTyouhyouHensyuuCommonBean pSiTyouhyouHensyuuCommonBean) {
        siTyouhyouHensyuuCommonBean = pSiTyouhyouHensyuuCommonBean;
    }

    public SeikyuusyaInfoBean getSeikyuusyaInfoBean() {
        return seikyuusyaInfoBean;
    }

    public void setSeikyuusyaInfoBean(SeikyuusyaInfoBean pSeikyuusyaInfoBean) {
        seikyuusyaInfoBean = pSeikyuusyaInfoBean;
    }

    public ToiawaseInfoBean getToiawaseInfoBean() {
        return toiawaseInfoBean;
    }

    public void setToiawaseInfoBean(ToiawaseInfoBean pToiawaseInfoBean) {
        toiawaseInfoBean = pToiawaseInfoBean;
    }

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public C_SeikyuuSyubetu getSeikyuuSyubetu() {
        return seikyuuSyubetu;
    }

    public void setSeikyuuSyubetu(C_SeikyuuSyubetu pSeikyuuSyubetu) {
        seikyuuSyubetu = pSeikyuuSyubetu;
    }

    public C_UmuKbn getInitsbjiyensitihsytkhukaUmu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaUmu(C_UmuKbn pInitsbjiyensitihsytkhukaUmu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaUmu;
    }

    public C_HknKknKbn getHknkknKbn() {
        return hknkknkbn;
    }

    public void setHknkknKbn(C_HknKknKbn pHknkknKbn) {
        hknkknkbn = pHknkknKbn;
    }

    public boolean getJisatuMenseki() {
        return jisatuMenseki;
    }

    public void setJisatuMenseki(boolean pJisatuMenseki) {
        jisatuMenseki = pJisatuMenseki;
    }

    public C_Tuukasyu getKykTuukasyu() {
        return kykTuukasyu;
    }

    public void setKykTuukasyu(C_Tuukasyu pKykTuukasyu) {
        kykTuukasyu = pKykTuukasyu;
    }

    public C_UmuKbn getMynumbertksUmuKbn() {
        return mynumbertksUmuKbn;
    }

    public void setMynumbertksUmuKbn(C_UmuKbn mynumbertksUmuKbn) {
        this.mynumbertksUmuKbn = mynumbertksUmuKbn;
    }

}
