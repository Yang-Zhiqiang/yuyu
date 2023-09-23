package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 手続入力設定UiBeanパラメータインタフェース実装クラス
 */
public class ViewTetudukiInputUiBeanParamImpl implements ViewTetudukiInputUiBeanParam {

    private String syanaicomment;

    @Override
    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Override
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }

}
