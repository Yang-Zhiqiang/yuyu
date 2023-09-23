package yuyu.common.siharai.siview.viewsiininfo;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SiinKbn;

/**
 * 保険金給付金支払 支払画面部品 死因情報表示 <br />
 */
public interface ViewSiinInfoUiBeanParam extends CommonViewUiBeanParam{

    public C_SiinKbn getSiinkbn();

    public void setSiinkbn(C_SiinKbn pSiinkbn);

    public boolean isViewSiinInfoFlg();

    public boolean isViewSiinInfoSeigyo();

    public boolean isViewSiinInfoDispFlg();
}
