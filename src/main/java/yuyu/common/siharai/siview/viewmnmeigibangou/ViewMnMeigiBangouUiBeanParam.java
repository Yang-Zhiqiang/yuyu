package yuyu.common.siharai.siview.viewmnmeigibangou;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 ＭＮ名義番号表示 <br />
 */
public interface ViewMnMeigiBangouUiBeanParam extends CommonViewUiBeanParam {

    public String getUktmnmeigibangou();

    public void setUktmnmeigibangou(String pUktmnmeigibangou);

    public String getKykmnmeigibangou();

    public void setKykmnmeigibangou(String pKykmnmeigibangou);

    public boolean isViewMnMeigiBangouSeigyo();

    public boolean isViewMnMeigiBangouDispFlg();
}
