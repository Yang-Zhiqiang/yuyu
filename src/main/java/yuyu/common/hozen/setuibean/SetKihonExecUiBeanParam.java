package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 UiBean設定 基本情報設定UiBeanパラメータ
 */
public interface SetKihonExecUiBeanParam {

    String getSyono();

    void setSyono(String pSyono);

    void setVkihnsyono(String pVkihnsyono);

    void setVkihnlastsyosaihkymd(BizDate pVkihnlastsyosaihkymd);

    void setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn pVkihnyuukousyoumetukbn);

    void setVkihnkykjyoutai(C_Kykjyoutai pVkihnkykjyoutai);

    void setVkihnsyoumetujiyuu(C_Syoumetujiyuu pVkihnsyoumetujiyuu);

    void setVkihnsyoumetuymd(BizDate pVkihnsyoumetuymd);

}
