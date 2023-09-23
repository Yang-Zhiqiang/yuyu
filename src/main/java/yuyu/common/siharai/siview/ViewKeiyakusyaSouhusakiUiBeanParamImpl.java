package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金支払共通UiBean設定UiBeanパラメータ(（届出）送付先情報設定)インターフェース実装クラス
 */
public class ViewKeiyakusyaSouhusakiUiBeanParamImpl implements ViewKeiyakusyaSouhusakiUiBeanParam {

    private String tdkdtsinyno;

    private String tdkdtsinadr1kj;

    private String tdkdtsinadr2kj;

    private String tdkdtsinadr3kj;

    private String tdkdtsintelno1;

    @Override
    public String getTdkdtsinyno() {
        return tdkdtsinyno;
    }

    @Override
    public void setTdkdtsinyno(String pTdkdtsinyno) {
        tdkdtsinyno = pTdkdtsinyno;
    }

    @Override
    public String getTdkdtsinadr1kj() {
        return tdkdtsinadr1kj;
    }

    @Override
    public void setTdkdtsinadr1kj(String pTdkdtsinadr1kj) {
        tdkdtsinadr1kj = pTdkdtsinadr1kj;
    }

    @Override
    public String getTdkdtsinadr2kj() {
        return tdkdtsinadr2kj;
    }

    @Override
    public void setTdkdtsinadr2kj(String pTdkdtsinadr2kj) {
        tdkdtsinadr2kj = pTdkdtsinadr2kj;
    }

    @Override
    public String getTdkdtsinadr3kj() {
        return tdkdtsinadr3kj;
    }

    @Override
    public void setTdkdtsinadr3kj(String pTdkdtsinadr3kj) {
        tdkdtsinadr3kj = pTdkdtsinadr3kj;
    }

    @Override
    public String getTdkdtsintelno1() {
        return tdkdtsintelno1;
    }

    @Override
    public void setTdkdtsintelno1(String pTdkdtsintelno1) {
        tdkdtsintelno1 = pTdkdtsintelno1;
    }

}
