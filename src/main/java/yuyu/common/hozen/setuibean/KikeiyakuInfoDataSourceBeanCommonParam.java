package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 UiBean設定 別契約情報設定
 */
public interface KikeiyakuInfoDataSourceBeanCommonParam {

    public String getVbtkkdispbtkyksyono();

    public void setVbtkkdispbtkyksyono(String pVbtkkdispbtkyksyono);

    public C_YuukousyoumetuKbn getVbtkkdispbtkykyuuksumtkbn();

    public void setVbtkkdispbtkykyuuksumtkbn(C_YuukousyoumetuKbn pVbtkkdispbtkykyuuksumtkbn);

    public C_Kykjyoutai getVbtkkdispbtkykkykjyoutai();

    public void setVbtkkdispbtkykkykjyoutai(C_Kykjyoutai pVbtkkdispbtkykkykjyoutai);

    public BizDate getVbtkkdispbtkykkykymd();

    public void setVbtkkdispbtkykkykymd(BizDate pVbtkkdispbtkykkykymd);

    public C_Syoumetujiyuu getVbtkkdispbtkyksumetujiyuu();

    public void setVbtkkdispbtkyksumetujiyuu(C_Syoumetujiyuu pVbtkkdispbtkyksumetujiyuu);

    public BizDate getVbtkkdispbtkyksyoumetuymd();

    public void setVbtkkdispbtkyksyoumetuymd(BizDate pVbtkkdispbtkyksyoumetuymd);

    public String getVbtkkdispbtkyksyouhnnm();

    public void setVbtkkdispbtkyksyouhnnm(String pVbtkkdispbtkyksyouhnnm);
}
