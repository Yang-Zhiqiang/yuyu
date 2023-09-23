package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 診断書料支払設定UiBeanパラメータインタフェース実装クラス
 */
public class ViewSindansyoryouShrUiBeanParamImpl implements ViewSindansyoryouShrUiBeanParam {

    private Integer sindansyomaisuu;

    @Override
    public Integer getSindansyomaisuu() {
        return sindansyomaisuu;
    }

    @Override
    public void setSindansyomaisuu(Integer pSindansyomaisuu) {
        sindansyomaisuu = pSindansyomaisuu;
    }

}
