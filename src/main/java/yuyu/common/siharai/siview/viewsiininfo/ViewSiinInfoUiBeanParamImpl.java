package yuyu.common.siharai.siview.viewsiininfo;

import yuyu.def.classification.C_SiinKbn;

/**
 * 保険金給付金支払 支払画面部品 死因情報表示クラス <br />
 */
public class ViewSiinInfoUiBeanParamImpl implements ViewSiinInfoUiBeanParam{

    private C_SiinKbn siinkbn;

    private boolean viewSiinInfoFlg;

    private boolean viewSiinInfoSeigyo;

    private boolean viewSiinInfoDispFlg;

    @Override
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    @Override
    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    @Override
    public boolean isViewSiinInfoFlg() {
        return viewSiinInfoFlg;
    }

    @Override
    public boolean isViewSiinInfoSeigyo() {
        return viewSiinInfoSeigyo;
    }

    @Override
    public boolean isViewSiinInfoDispFlg() {
        return viewSiinInfoDispFlg;
    }
}
