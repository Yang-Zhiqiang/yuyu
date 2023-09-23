package yuyu.common.siharai.siview.viewskjyouhou;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * 保険金給付金支払 支払画面部品 請求者情報表示 <br />
 */
public interface ViewSkjyouhouUiBeanParam extends CommonViewUiBeanParam{

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn();

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn);

    public BizDate getSeikyuusyaseiymd();

    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd);

    public C_Seibetu getSeikyuusyasei();

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);

    public boolean isViewSkjyouhouInputDispFlg();

    public boolean isViewSkjyouhouSeigyo();

    public boolean isViewSkjyouhouDispFlg();

}
