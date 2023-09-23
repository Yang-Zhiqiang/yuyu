package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 被保険者情報設定(承認取消)UiBeanパラメータインタフェース
 */
public interface ViewHihokensyaSyouninTorikesiUiBeanParam extends CommonViewUiBeanParam {

    public String getHhknnmkn();

    public void setHhknnmkn(String pHhknnmkn);

    public String getHhknnmkj();

    public void setHhknnmkj(String pHhknnmkj);

}
