package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(指定代理人情報設定)インターフェース
 */
public interface ViewSiteidrUiBeanParam extends CommonViewUiBeanParam {

    public String getSiteidruktnmkn();

    public void setSiteidruktnmkn(String pSiteidruktnmkn);

    public String getSiteidruktnmkj();

    public void setSiteidruktnmkj(String pSiteidruktnmkj);

}
