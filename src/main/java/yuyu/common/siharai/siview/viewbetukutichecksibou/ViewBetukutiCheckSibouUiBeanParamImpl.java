package yuyu.common.siharai.siview.viewbetukutichecksibou;

import yuyu.def.classification.C_NoinitUmuKbn;

/**
 * 保険金給付金支払 支払画面部品 別口チェック項目（死亡）クラス <br />
 */
public class ViewBetukutiCheckSibouUiBeanParamImpl implements ViewBetukutiCheckSibouUiBeanParam{

    private C_NoinitUmuKbn betusibouumukbn;

    private String betusiboucomment;

    private C_NoinitUmuKbn betusoukiumukbn;

    private String betusoukicomment;

    private boolean viewBetukutiCheckSibouInputDispFlg;

    private boolean viewBetukutiCheckSibouFlg;

    private boolean viewBetukutiCheckSibouSeigyo;

    private boolean viewBetukutiCheckSibouDispFlg;

    @Override
    public C_NoinitUmuKbn getBetusibouumukbn() {
        return betusibouumukbn;
    }

    @Override
    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn) {
        betusibouumukbn = pBetusibouumukbn;
    }

    @Override
    public String getBetusiboucomment() {
        return betusiboucomment;
    }

    @Override
    public void setBetusiboucomment(String pBetusiboucomment) {
        betusiboucomment = pBetusiboucomment;
    }

    @Override
    public C_NoinitUmuKbn getBetusoukiumukbn() {
        return betusoukiumukbn;
    }

    @Override
    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn) {
        betusoukiumukbn = pBetusoukiumukbn;
    }

    @Override
    public String getBetusoukicomment() {
        return betusoukicomment;
    }

    @Override
    public void setBetusoukicomment(String pBetusoukicomment) {
        betusoukicomment = pBetusoukicomment;
    }

    @Override
    public boolean isViewBetukutiCheckSibouInputDispFlg() {
        return viewBetukutiCheckSibouInputDispFlg;
    }

    @Override
    public boolean isViewBetukutiCheckSibouFlg() {
        return viewBetukutiCheckSibouFlg;
    }

    @Override
    public boolean isViewBetukutiCheckSibouSeigyo() {
        return viewBetukutiCheckSibouSeigyo;
    }

    @Override
    public boolean isViewBetukutiCheckSibouDispFlg() {
        return viewBetukutiCheckSibouDispFlg;
    }
}
