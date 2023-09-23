package yuyu.common.siharai.siview.viewsonotachecksibou;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 その他チェック項目（死亡） <br />
 */
public interface ViewSonotaCheckSibouUiBeanParam extends CommonViewUiBeanParam {

    public C_NoinitUmuKbn getBengosikenkaiumukbn();

    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn);

    public C_NoinitUmuKbn getKujyouumukbn();

    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn);

    public C_NoinitUmuKbn getJimumissumukbn();

    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn);

    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn();

    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn);

    public boolean isViewSonotaCheckSibouFlg();

    public boolean isViewSonotaCheckSibouSeigyo();

    public boolean isViewSonotaCheckSibouDispFlg();
}
