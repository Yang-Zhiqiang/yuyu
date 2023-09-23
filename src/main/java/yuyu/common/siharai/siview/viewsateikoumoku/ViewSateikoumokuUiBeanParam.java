package yuyu.common.siharai.siview.viewsateikoumoku;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 査定項目 <br />
 */
public interface ViewSateikoumokuUiBeanParam extends CommonViewUiBeanParam {

    public String getSateikoumoku();

    public void setSateikoumoku(String pSateikoumoku);

    public boolean isViewSateikoumokuSeigyo();

    public boolean isViewSateikoumokuDispFlg();
}
