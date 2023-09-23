package yuyu.common.siharai.siview.viewsonotachecksibou;

import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 支払画面部品 その他チェック項目（死亡）クラス <br />
 */
public class ViewSonotaCheckSibouUiBeanParamImpl implements ViewSonotaCheckSibouUiBeanParam{

    private C_NoinitUmuKbn bengosikenkaiumukbn;

    private C_NoinitUmuKbn kujyouumukbn;

    private C_NoinitUmuKbn jimumissumukbn;

    private C_NoinitYouhiKbn kyhgksitukaisouyouhikbn;

    private boolean viewSonotaCheckSibouFlg;

    private boolean viewSonotaCheckSibouSeigyo;

    private boolean viewSonotaCheckSibouDispFlg;


    @Override
    public C_NoinitUmuKbn getBengosikenkaiumukbn() {
        return bengosikenkaiumukbn;
    }

    @Override
    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn) {
        bengosikenkaiumukbn = pBengosikenkaiumukbn;
    }

    @Override
    public C_NoinitUmuKbn getKujyouumukbn() {
        return kujyouumukbn;
    }

    @Override
    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn) {
        kujyouumukbn = pKujyouumukbn;
    }

    @Override
    public C_NoinitUmuKbn getJimumissumukbn() {
        return jimumissumukbn;
    }

    @Override
    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn) {
        jimumissumukbn = pJimumissumukbn;
    }

    @Override
    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn() {
        return kyhgksitukaisouyouhikbn;
    }

    @Override
    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn) {
        kyhgksitukaisouyouhikbn = pKyhgksitukaisouyouhikbn;
    }

    @Override
    public boolean isViewSonotaCheckSibouFlg() {
        return viewSonotaCheckSibouFlg;
    }

    @Override
    public boolean isViewSonotaCheckSibouSeigyo() {
        return viewSonotaCheckSibouSeigyo;
    }

    @Override
    public boolean isViewSonotaCheckSibouDispFlg() {
        return viewSonotaCheckSibouDispFlg;
    }

}
