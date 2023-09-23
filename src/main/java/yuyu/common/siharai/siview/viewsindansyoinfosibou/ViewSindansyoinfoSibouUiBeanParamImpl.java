package yuyu.common.siharai.siview.viewsindansyoinfosibou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;

/**
 * 保険金給付金支払 支払画面部品 診断書情報（死亡）クラス <br />
 */
public class ViewSindansyoinfoSibouUiBeanParamImpl implements ViewSindansyoinfoSibouUiBeanParam {

    private DataSource<?> viewSindansyoinfoSibouInfo1DataSource;

    private C_GeninKbn geninkbn;

    private BizDate sibouymd;

    private C_SibouBasyoKbn siboubasyokbn;

    private String siboubasyo;

    private boolean viewSindansyoinfoSibouInputDispFlg;

    private boolean viewSindansyoinfoSibouSeigyo;

    private boolean viewSindansyoinfoSibouDispFlg;

    @Override
    public DataSource<?> getViewSindansyoinfoSibouInfo1DataSource() {
        return viewSindansyoinfoSibouInfo1DataSource;
    }

    @Override
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    @Override
    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @Override
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Override
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    @Override
    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    @Override
    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    @Override
    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Override
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }

    @Override
    public boolean isViewSindansyoinfoSibouInputDispFlg() {
        return viewSindansyoinfoSibouInputDispFlg;
    }

    @Override
    public boolean isViewSindansyoinfoSibouSeigyo() {
        return viewSindansyoinfoSibouSeigyo;
    }

    @Override
    public boolean isViewSindansyoinfoSibouDispFlg() {
        return viewSindansyoinfoSibouDispFlg;
    }
}
