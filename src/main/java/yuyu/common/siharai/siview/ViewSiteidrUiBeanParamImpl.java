package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(指定代理人情報設定)インターフェース実装クラス
 */
public class ViewSiteidrUiBeanParamImpl implements ViewSiteidrUiBeanParam {

    private String siteidruktnmkn;

    private String siteidruktnmkj;

    @Override
    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    @Override
    public void setSiteidruktnmkn(String pSiteidruktnmkn) {
        siteidruktnmkn = pSiteidruktnmkn;
    }

    @Override
    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    @Override
    public void setSiteidruktnmkj(String pSiteidruktnmkj) {
        siteidruktnmkj = pSiteidruktnmkj;
    }

}
