package yuyu.common.siharai.siview.viewsinkensya;

import yuyu.def.classification.C_SkskknsyubetuKbn;

/**
 * 保険金給付金支払 支払画面部品 親権者後見人情報表示クラス <br />
 */
public class ViewSinkensyaUiBeanParamImpl implements ViewSinkensyaUiBeanParam{

    private String skskknnmkn;

    private String skskknnmkj;

    private C_SkskknsyubetuKbn skskknsyubetu;

    private boolean viewSinkensyaSeigyo;

    private boolean viewSinkensyaDispFlg;

    private boolean viewSinkensyaHyouji;

    @Override
    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Override
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    @Override
    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Override
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    @Override
    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    @Override
    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    @Override
    public boolean isViewSinkensyaSeigyo() {
        return viewSinkensyaSeigyo;
    }

    @Override
    public boolean isViewSinkensyaDispFlg() {
        return viewSinkensyaDispFlg;
    }

    @Override
    public boolean isViewSinkensyaHyouji() {
        return viewSinkensyaHyouji;
    }

}
