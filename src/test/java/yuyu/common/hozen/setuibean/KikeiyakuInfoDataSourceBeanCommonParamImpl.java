package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 UiBean設定 別契約（既契約）  のデータソースのデータ
 */
public class KikeiyakuInfoDataSourceBeanCommonParamImpl implements KikeiyakuInfoDataSourceBeanCommonParam {

    private String vbtkkdispbtkyksyono;

    @Override
    public String getVbtkkdispbtkyksyono() {
        return vbtkkdispbtkyksyono;
    }

    @Override
    public void setVbtkkdispbtkyksyono(String pVbtkkdispbtkyksyono) {
        vbtkkdispbtkyksyono = pVbtkkdispbtkyksyono;
    }


    private C_YuukousyoumetuKbn vbtkkdispbtkykyuuksumtkbn;

    @Override
    public C_YuukousyoumetuKbn getVbtkkdispbtkykyuuksumtkbn() {
        return vbtkkdispbtkykyuuksumtkbn;
    }

    @Override
    public void setVbtkkdispbtkykyuuksumtkbn(C_YuukousyoumetuKbn pVbtkkdispbtkykyuuksumtkbn) {
        vbtkkdispbtkykyuuksumtkbn = pVbtkkdispbtkykyuuksumtkbn;
    }


    private C_Kykjyoutai vbtkkdispbtkykkykjyoutai;

    @Override
    public C_Kykjyoutai getVbtkkdispbtkykkykjyoutai() {
        return vbtkkdispbtkykkykjyoutai;
    }

    @Override
    public void setVbtkkdispbtkykkykjyoutai(C_Kykjyoutai pVbtkkdispbtkykkykjyoutai) {
        vbtkkdispbtkykkykjyoutai = pVbtkkdispbtkykkykjyoutai;
    }


    private BizDate vbtkkdispbtkykkykymd;

    @Override
    public BizDate getVbtkkdispbtkykkykymd() {
        return vbtkkdispbtkykkykymd;
    }

    @Override
    public void setVbtkkdispbtkykkykymd(BizDate pVbtkkdispbtkykkykymd) {
        vbtkkdispbtkykkykymd = pVbtkkdispbtkykkykymd;
    }


    private C_Syoumetujiyuu vbtkkdispbtkyksumetujiyuu;

    @Override
    public C_Syoumetujiyuu getVbtkkdispbtkyksumetujiyuu() {
        return vbtkkdispbtkyksumetujiyuu;
    }

    @Override
    public void setVbtkkdispbtkyksumetujiyuu(C_Syoumetujiyuu pVbtkkdispbtkyksumetujiyuu) {
        vbtkkdispbtkyksumetujiyuu = pVbtkkdispbtkyksumetujiyuu;
    }


    private BizDate vbtkkdispbtkyksyoumetuymd;

    @Override
    public BizDate getVbtkkdispbtkyksyoumetuymd() {
        return vbtkkdispbtkyksyoumetuymd;
    }

    @Override
    public void setVbtkkdispbtkyksyoumetuymd(BizDate pVbtkkdispbtkyksyoumetuymd) {
        vbtkkdispbtkyksyoumetuymd = pVbtkkdispbtkyksyoumetuymd;
    }


    private String vbtkkdispbtkyksyouhnnm;

    @Override
    public String getVbtkkdispbtkyksyouhnnm() {
        return vbtkkdispbtkyksyouhnnm;
    }

    @Override
    public void setVbtkkdispbtkyksyouhnnm(String pVbtkkdispbtkyksyouhnnm) {
        vbtkkdispbtkyksyouhnnm = pVbtkkdispbtkyksyouhnnm;
    }
}
