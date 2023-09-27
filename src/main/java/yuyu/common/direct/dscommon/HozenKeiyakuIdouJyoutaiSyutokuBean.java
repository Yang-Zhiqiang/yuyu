package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  保全契約異動状態取得Bean<br />
 */
public class HozenKeiyakuIdouJyoutaiSyutokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_YuukshantkekKbn yuukouKbn;

    private C_IdoutyuuHanteiKekkaKbn idoutyuuKbn;

    private C_UmuKbn yotenSouiUmuKbn;

    private C_UmuKbn meigiHenkouUmuKbn;

    private C_UmuKbn juushoHenkouUmuKbn;

    private C_UmuKbn srMeigiHenkouUmuKbn;

    private C_UmuKbn srJuushoHenkouUmuKbn;

    public C_YuukshantkekKbn getYuukouKbn() {
        return yuukouKbn;
    }

    public void setYuukouKbn(C_YuukshantkekKbn pYuukouKbn) {
        this.yuukouKbn = pYuukouKbn;
    }

    public C_IdoutyuuHanteiKekkaKbn getIdoutyuuKbn() {
        return idoutyuuKbn;
    }

    public void setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn pIdoutyuuKbn) {
        this.idoutyuuKbn = pIdoutyuuKbn;
    }

    public C_UmuKbn getYotenSouiUmuKbn() {
        return yotenSouiUmuKbn;
    }

    public void setYotenSouiUmuKbn(C_UmuKbn pYotenSouiUmuKbn) {
        this.yotenSouiUmuKbn = pYotenSouiUmuKbn;
    }

    public C_UmuKbn getMeigiHenkouUmuKbn() {
        return meigiHenkouUmuKbn;
    }

    public void setMeigiHenkouUmuKbn(C_UmuKbn pMeigiHenkouUmuKbn) {
        this.meigiHenkouUmuKbn = pMeigiHenkouUmuKbn;
    }

    public C_UmuKbn getJuushoHenkouUmuKbn() {
        return juushoHenkouUmuKbn;
    }

    public void setJuushoHenkouUmuKbn(C_UmuKbn pJuushoHenkouUmuKbn) {
        this.juushoHenkouUmuKbn = pJuushoHenkouUmuKbn;
    }

    public C_UmuKbn getSrMeigiHenkouUmuKbn() {
        return srMeigiHenkouUmuKbn;
    }

    public void setSrMeigiHenkouUmuKbn(C_UmuKbn pSrMeigiHenkouUmuKbn) {
        this.srMeigiHenkouUmuKbn = pSrMeigiHenkouUmuKbn;
    }

    public C_UmuKbn getSrJuushoHenkouUmuKbn() {
        return srJuushoHenkouUmuKbn;
    }

    public void setSrJuushoHenkouUmuKbn(C_UmuKbn pSrJuushoHenkouUmuKbn) {
        this.srJuushoHenkouUmuKbn = pSrJuushoHenkouUmuKbn;
    }

}
