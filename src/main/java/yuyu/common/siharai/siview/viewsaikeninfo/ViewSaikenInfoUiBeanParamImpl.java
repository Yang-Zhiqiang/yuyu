package yuyu.common.siharai.siview.viewsaikeninfo;

/**
 * 保険金給付金支払 支払画面部品 債権者情報表示 <br />
 */
public class ViewSaikenInfoUiBeanParamImpl implements ViewSaikenInfoUiBeanParam{

    private String saikennmkj;

    private String saikennyno;

    private String saikenadr1kj;

    private String saikenadr2kj;

    private String saikenadr3kj;

    private boolean viewSaikenInfoInputDispFlg;

    private boolean viewSaikenInfoFlg;

    private boolean viewSaikenInfoSeigyo;

    private boolean viewSaikenInfoDispFlg;

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

    @Override
    public boolean isViewSaikenInfoInputDispFlg() {
        return viewSaikenInfoInputDispFlg;
    }

    @Override
    public boolean isViewSaikenInfoFlg() {
        return viewSaikenInfoFlg;
    }

    @Override
    public boolean isViewSaikenInfoSeigyo() {
        return viewSaikenInfoSeigyo;
    }

    @Override
    public boolean isViewSaikenInfoDispFlg(){
        return viewSaikenInfoDispFlg;
    }
}
