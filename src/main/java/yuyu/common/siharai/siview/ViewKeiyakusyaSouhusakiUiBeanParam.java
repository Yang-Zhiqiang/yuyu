package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(（届出）送付先情報設定)インターフェース
 */
public interface ViewKeiyakusyaSouhusakiUiBeanParam extends CommonViewUiBeanParam {

    public String getTdkdtsinyno();

    public void setTdkdtsinyno(String pTdkdtsinyno);

    public String getTdkdtsinadr1kj();

    public void setTdkdtsinadr1kj(String pTdkdtsinadr1kj);

    public String getTdkdtsinadr2kj();

    public void setTdkdtsinadr2kj(String pTdkdtsinadr2kj);

    public String getTdkdtsinadr3kj();

    public void setTdkdtsinadr3kj(String pTdkdtsinadr3kj);

    public String getTdkdtsintelno1();

    public void setTdkdtsintelno1(String pTdkdtsintelno1);

}
