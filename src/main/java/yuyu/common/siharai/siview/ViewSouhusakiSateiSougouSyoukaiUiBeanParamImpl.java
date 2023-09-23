package yuyu.common.siharai.siview;

/**
 * 保険金給付金支払 保険金給付金支払共通 送付先情報設定(査定総合照会)パラメータインタフェース実装クラス
 */
public class ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl implements ViewSouhusakiSateiSougouSyoukaiUiBeanParam {

    private String tsinyno;

    private String tsinadr1kj;

    private String tsinadr2kj;

    private String tsinadr3kj;

    private String tsintelno;

    @Override
    public String getTsinyno() {
        return tsinyno;
    }

    @Override
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    @Override
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Override
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    @Override
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Override
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    @Override
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Override
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    @Override
    public String getTsintelno() {
        return tsintelno;
    }

    @Override
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

}
