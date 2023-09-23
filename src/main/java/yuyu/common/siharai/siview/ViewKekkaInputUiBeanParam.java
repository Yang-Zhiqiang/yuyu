package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 結果入力設定UiBeanパラメータインタフェース
 */
public interface ViewKekkaInputUiBeanParam extends CommonViewUiBeanParam {

    public C_SyorikekkaKbn getSyorikekkakbn();

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn);

    public String getTennousakisousasyacd();

    public void setTennousakisousasyacd(String pTennousakisousasyacd);

    public String getSyanaicomment();

    public void setSyanaicomment(String pSyanaicomment);

}
