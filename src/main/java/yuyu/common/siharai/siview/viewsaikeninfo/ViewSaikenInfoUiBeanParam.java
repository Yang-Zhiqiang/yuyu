package yuyu.common.siharai.siview.viewsaikeninfo;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 債権者情報表示 <br />
 */
public interface ViewSaikenInfoUiBeanParam extends CommonViewUiBeanParam {

    public String getSaikennmkj();

    public void setSaikennmkj(String pSaikennmkj);

    public String getSaikennyno();

    public void setSaikennyno(String pSaikennyno);

    public String getSaikenadr1kj();

    public void setSaikenadr1kj(String pSaikenadr1kj);

    public String getSaikenadr2kj();

    public void setSaikenadr2kj(String pSaikenadr2kj);

    public String getSaikenadr3kj();

    public void setSaikenadr3kj(String pSaikenadr3kj);

    public boolean isViewSaikenInfoInputDispFlg();

    public boolean isViewSaikenInfoFlg();

    public boolean isViewSaikenInfoSeigyo();

    public boolean isViewSaikenInfoDispFlg();
}
