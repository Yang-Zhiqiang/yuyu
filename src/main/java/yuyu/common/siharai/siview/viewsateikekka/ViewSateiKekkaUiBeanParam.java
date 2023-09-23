package yuyu.common.siharai.siview.viewsateikekka;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金支払 支払画面部品 査定結果 <br />
 */
public interface ViewSateiKekkaUiBeanParam extends CommonViewUiBeanParam {

    public C_SyorikekkaKbn getSateisyorikekkakbn();

    public void setSateisyorikekkakbn(C_SyorikekkaKbn pSateisyorikekkakbn);

    public String getSateitennousakisousasyacd();

    public void setSateitennousakisousasyacd(String pSateitennousakisousasyacd);

    public BizDate getKaiketuymd();

    public void setKaiketuymd(BizDate pKaiketuymd);

    public String getSateisyanaicomment();

    public void setSateisyanaicomment(String pSateisyanaicomment);

    public boolean isViewSateiKekkaSeigyo();

    public boolean isViewSateiKekkaDispFlg();

    public boolean isSyouninInputHanteiFlg();

    public boolean isSessyouInputHanteiFlg();

    public boolean isKaiketuInputHanteiFlg();
}
