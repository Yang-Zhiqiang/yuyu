package yuyu.common.siharai.siview.viewbetukutichecksibou;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_NoinitUmuKbn;

/**
 * 保険金給付金支払 支払画面部品 別口チェック項目（死亡） <br />
 */
public interface ViewBetukutiCheckSibouUiBeanParam extends CommonViewUiBeanParam {

    public C_NoinitUmuKbn getBetusibouumukbn();

    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn);

    public String getBetusiboucomment();

    public void setBetusiboucomment(String pBetusiboucomment);

    public C_NoinitUmuKbn getBetusoukiumukbn();

    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn);

    public String getBetusoukicomment();

    public void setBetusoukicomment(String pBetusoukicomment);

    public boolean isViewBetukutiCheckSibouInputDispFlg();

    public boolean isViewBetukutiCheckSibouFlg();

    public boolean isViewBetukutiCheckSibouSeigyo();

    public boolean isViewBetukutiCheckSibouDispFlg();
}
