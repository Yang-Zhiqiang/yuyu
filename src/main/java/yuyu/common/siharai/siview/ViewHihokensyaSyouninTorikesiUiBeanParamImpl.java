package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 被保険者情報設定(承認取消)UiBeanパラメータインタフェース実装クラス
 */
public class ViewHihokensyaSyouninTorikesiUiBeanParamImpl implements ViewHihokensyaSyouninTorikesiUiBeanParam {

    private String hhknnmkn;

    private String hhknnmkj;

    @Override
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Override
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    @Override
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Override
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

}
