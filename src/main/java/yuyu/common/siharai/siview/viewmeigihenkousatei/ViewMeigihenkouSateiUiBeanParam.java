package yuyu.common.siharai.siview.viewmeigihenkousatei;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;

/**
 * 保険金給付金支払 支払画面部品 名義変更査定 <br />
 */
public interface ViewMeigihenkouSateiUiBeanParam extends CommonViewUiBeanParam {

    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn();

    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn);

    public C_MeihenUktKbn getMeihenuktkbn();

    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn);

    public String getMeihenuktnm();

    public void setMeihenuktnm(String pMeihenuktnm);

    public boolean isViewMeigihenkouSateiFlg();

    public boolean isViewMeigihenkouSateiSeigyo();

    public boolean isViewMeigihenkouSateiDispFlg();
}
