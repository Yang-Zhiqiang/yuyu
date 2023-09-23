package yuyu.common.hozen.khview.viewkihon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 契約保全画面部品 基本情報表示 <br />
 */
public interface ViewKihonUiBeanParam extends CommonViewUiBeanParam {

    public String getVkihnsyono();

    public void setVkihnsyono(String pVkihnsyono);

    public BizDate getVkihnlastsyosaihkymd();

    public void setVkihnlastsyosaihkymd(BizDate pVkihnlastsyosaihkymd);

    public C_YuukousyoumetuKbn getVkihnyuukousyoumetukbn();

    public void setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn pVkihnyuukousyoumetukbn);

    public C_Kykjyoutai getVkihnkykjyoutai();

    public void setVkihnkykjyoutai(C_Kykjyoutai pVkihnkykjyoutai);

    public C_Syoumetujiyuu getVkihnsyoumetujiyuu();

    public void setVkihnsyoumetujiyuu(C_Syoumetujiyuu pVkihnsyoumetujiyuu);

    public BizDate getVkihnsyoumetuymd();

    public void setVkihnsyoumetuymd(BizDate pVkihnsyoumetuymd);


}
