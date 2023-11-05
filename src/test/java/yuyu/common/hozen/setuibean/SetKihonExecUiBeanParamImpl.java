package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 UiBean設定 基本情報設定UiBean
 */
public class SetKihonExecUiBeanParamImpl implements SetKihonExecUiBeanParam{

    private String syono;

    private String pVkihnsyono;

    private BizDate vkihnlastsyosaihkymd;

    private C_YuukousyoumetuKbn vkihnyuukousyoumetukbn;

    private C_Kykjyoutai vkihnkykjyoutai;

    private C_Syoumetujiyuu vkihnsyoumetujiyuu;

    private BizDate vkihnsyoumetuymd;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public String getVkihnsyono() {
        return pVkihnsyono;
    }

    @Override
    public void setVkihnsyono(String pVkihnsyono) {
        this.pVkihnsyono = pVkihnsyono;
    }

    public BizDate getVkihnlastsyosaihkymd() {
        return vkihnlastsyosaihkymd;
    }

    @Override
    public void setVkihnlastsyosaihkymd(BizDate pVkihnlastsyosaihkymd) {
        this.vkihnlastsyosaihkymd = pVkihnlastsyosaihkymd;
    }

    public C_YuukousyoumetuKbn getVkihnyuukousyoumetukbn() {
        return vkihnyuukousyoumetukbn;
    }

    @Override
    public void setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn pVkihnyuukousyoumetukbn) {
        this.vkihnyuukousyoumetukbn = pVkihnyuukousyoumetukbn;
    }

    public C_Kykjyoutai getVkihnkykjyoutai() {
        return vkihnkykjyoutai;
    }

    @Override
    public void setVkihnkykjyoutai(C_Kykjyoutai pVkihnkykjyoutai) {
        this.vkihnkykjyoutai = pVkihnkykjyoutai;
    }

    public C_Syoumetujiyuu getVkihnsyoumetujiyuu() {
        return vkihnsyoumetujiyuu;
    }

    @Override
    public void setVkihnsyoumetujiyuu(C_Syoumetujiyuu pVkihnsyoumetujiyuu) {
        this.vkihnsyoumetujiyuu = pVkihnsyoumetujiyuu;
    }

    public BizDate getVkihnsyoumetuymd() {
        return vkihnsyoumetuymd;
    }

    @Override
    public void setVkihnsyoumetuymd(BizDate pVkihnsyoumetuymd) {
        this.vkihnsyoumetuymd = pVkihnsyoumetuymd;
    }

}
