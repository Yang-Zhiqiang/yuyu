package yuyu.common.hozen.ascommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 被災害特伸情報Beanクラス
 */
public class HsigiTksnInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HsigiTkbtTaiouSyuruiKbn hsigiTkbtTaiouSyurui;

    private C_UmuKbn koujyoSyoumeiTkbtTaiouUmu;

    private BizDate bnktAnnaiKaisiYmd;

    private BizDate bnktAnnaiEndYmd;

    public C_HsigiTkbtTaiouSyuruiKbn getHsigiTkbtTaiouSyurui() {
        return hsigiTkbtTaiouSyurui;
    }

    public void setHsigiTkbtTaiouSyurui(C_HsigiTkbtTaiouSyuruiKbn pHsigiTkbtTaiouSyurui) {
        hsigiTkbtTaiouSyurui = pHsigiTkbtTaiouSyurui;
    }

    public C_UmuKbn getKoujyoSyoumeiTkbtTaiouUmu() {
        return koujyoSyoumeiTkbtTaiouUmu;
    }

    public void setKoujyoSyoumeiTkbtTaiouUmu(C_UmuKbn pKoujyoSyoumeiTkbtTaiouUmu) {
        koujyoSyoumeiTkbtTaiouUmu = pKoujyoSyoumeiTkbtTaiouUmu;
    }

    public BizDate getBnktAnnaiKaisiYmd() {
        return bnktAnnaiKaisiYmd;
    }

    public void setBnktAnnaiKaisiYmd(BizDate pBnktAnnaiKaisiYmd) {
        bnktAnnaiKaisiYmd = pBnktAnnaiKaisiYmd;
    }

    public BizDate getBnktAnnaiEndYmd() {
        return bnktAnnaiEndYmd;
    }

    public void setBnktAnnaiEndYmd(BizDate pBnktAnnaiEndYmd) {
        bnktAnnaiEndYmd = pBnktAnnaiEndYmd;
    }
}
