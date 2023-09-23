package yuyu.common.siharai.edittbl;

/**
 * 保険金給付金支払 保険金給付金支払共通 債権者情報Paramインターフェース実装クラス
 */
public class SiSaikenParamImpl implements SiSaikenParam {

    private String saikennmkj;

    private String saikennyno;

    private String saikenadr1kj;

    private String saikenadr2kj;

    private String saikenadr3kj;

    @Override
    public String getSaikennmkj() {
        return saikennmkj;
    }

    @Override
    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    @Override
    public String getSaikennyno() {
        return saikennyno;
    }

    @Override
    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    @Override
    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    @Override
    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    @Override
    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    @Override
    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    @Override
    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    @Override
    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }
}
